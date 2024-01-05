package BasicProblem;

import java.util.Scanner;

public class TriangleNumberPattern {
    

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int row=1 ; row<=n; row++)
        {
            for(int col=1 ; col<=row; col++ )
            {
                System.out.print(row);
            }
            System.out.println();
        }
    }

}
