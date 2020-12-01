package Programming.ConvexHull;

import java.util.ArrayList;

/*
 The idea of Jarvis’s Algorithm is simple, we start from the leftmost point
(or point with minimum x coordinate value) and we keep wrapping points in
counterclockwise direction. The big question is, given a point p as current
point, how to find the next point in output? The idea is to use orientation() here.
Next point is selected as the point that beats all other points at counterclockwise
orientation, i.e., next point is q if for any other point r, we have “orientation(p, q, r) = counterclockwise”.
Following is the detailed algorithm.
 */
public class convexHull {
//Intersection points
    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }//End of point class

    public static int orientation(Point p, Point q, Point r){
        int val =   (q.y -p.y)*(r.x -q.x)-
                    (q.x-p.x )*(r.y-q.y);
        //Co-Linear
        if(val == 0) return 0;  //lying on same line
        return (val > 0) ? 1 : 2;
    }
    // Convex Hull of n points
    public static void convexHull(Point[] points, int n){
        //no need here since 3 points are needed
        if(n < 3) return;
        //Need to intialize the hull
        ArrayList<Point> hull = new ArrayList<Point>();
        int leftMost =0;

        for(int i= 1; i < n; i++)
            if(points[i].x < points[leftMost].x)
                leftMost = i;


            int p = leftMost, q;
        do{
            //adds current point to result
            hull.add(points[p]);
            //Search for a point q such that orientation(p,x,q) is counterclockwise
            //for all points 'x'.  The idea is to keep
            //track of last visited most counterclockwise
            //point in q.  If any 'i' is more counterclockwise
            //than q, then update q
            q =(p+1) % n;

            for(int i=0; i < n; i++){
                //if i is more counterclockwise than
                //current q, then update q
                if(orientation(points[p], points[i], points[q])==2)
                    q =i;
            }
            //Since q is the most counterclockwise with respect to p
            //Set p as q for next iteration, so that q is added to result hull
            p = q;
        }
        while(p != leftMost);
        //results
        for(Point temp: hull) System.out.println("(" + temp.x + " ,"
        + temp.y + ")");

    }
    /* Driver program to test above function */
    public static void main(String[] args)
    {

        Point points[] = new Point[7];
        points[0]=new Point(0, 3);
        points[1]=new Point(2, 3);
        points[2]=new Point(1, 1);
        points[3]=new Point(2, 1);
        points[4]=new Point(3, 0);
        points[5]=new Point(0, 0);
        points[6]=new Point(3, 3);

        int n = points.length;
        convexHull(points, n);
   
    }

}
