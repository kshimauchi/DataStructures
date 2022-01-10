package Programming.Trees.Kd_Tree;


// https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Point.html

import java.util.LinkedList;

public class KD_Point<Object> {
    Object X, Y;
    Object data;

    public KD_Point(){};

    public KD_Point(Object x, Object y, Object data){
        this.X = x;
        this.Y = y;
    }

    public Object getX(Object x){
        return x;
    }

    public Object getY(Object y){
        return y;
    }


}
//        import java.io.*;
//        import java.util.*;
//        import java.awt.*;
//  public static void main(String [] args)throws IOException {
//      String S;
//      int X, Y;
//
//      System.out.println("\n implementation of a Point");
//
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//      System.out.println("Enter the x coordinates");
//        S =br.readLine();
//        X = Integer.parseInt(S);
//        System.out.println("Enter the y coordinates");
//        S = br.readLine();
//        Y= Integer.parseInt(S);
//
//        Point q = new Point(X, Y);
//
//        if(q.getX() == 0 && q.getY()==0){System.out.println("Invalid"); }
//        else if (q.getX()==0){ System.out.println("Vertical Line"); }
//        else if(q.getY()==0){System.out.println("Horizontal Line"); }
//        else if(q.getX()==q.getY()){System.out.println("Square"); }
//        else {
//                System.out.println("Rectangle");
//        }
//
//  }



