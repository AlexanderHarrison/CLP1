                  /*  File: convexDown.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class convexDown extends Template {

     static {templateClass = new convexDown() ; }

     public void setup() {
          filePrefix = "convexDown" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 1.2 ;   
          xmin = -1.0 ;
          xmax = 1.0 ;
          ymin = -1.0 ;
          ymax = 0.2;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          double x = 0 ; double y = -x*x ; double yp = -2*x ; double dx = 0.4 ;
          fLine(x-dx, y-yp*dx, x+dx, y+yp*dx) ;
          x = -0.5 ; y = -x*x ;  yp = -2*x ;  dx = 0.3 ;
          fLine(x-dx, y-yp*dx, x+dx, y+yp*dx) ;
          fTeXlabel(x-0.05,y, "cr", "${\\scriptstyle f'(x)>0}$") ;
          x = +0.5 ; y = -x*x ;  yp = -2*x ;  dx = 0.3 ;
          fLine(x-dx, y-yp*dx, x+dx, y+yp*dx) ;
          fTeXlabel(x+0.08,y, "cl", "${\\scriptstyle f'(x)<0}$") ;

          fEnv("lineWidth", 1.0) ;
          double t2 = Math.pow(2.0, 1.0/3.0)  ;
          fCurve("y=-x*x", 0, -0.8, 0.8, OPEN) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double aspect = (ymax-ymin)*xsize/(xmax-xmin)/ysize ;
          double r = 0.03 ;
          x = 0 ; y = x*x ;
          fDisk(x,y, r,r*aspect, FILLED) ;
          fTeXlabel(x,y-0.1, "tc", "${\\scriptstyle(c, f(c))}$") ;



     }
}
