package BasicProblem;

import java.util.Scanner;

public class AverageMarks {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        char name = s.next().charAt(0);
        int m1,m2,m3;
        m1= s.nextInt();
         m2= s.nextInt();
          m3= s.nextInt();
          int average = (m1 + m2 + m3) / 3;
          System.out.println(name);
          System.out.println(average);
    }

}
