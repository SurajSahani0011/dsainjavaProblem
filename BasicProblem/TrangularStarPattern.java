package BasicProblem;

import java.util.Scanner;

public class TrangularStarPattern {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int curRow = 1;
        while (curRow <= n) {
            int curCol = 1;

            while (curRow >= curCol) {
                System.out.print('*');
                curCol += 1;
                
            }
            System.out.println();
            curRow += 1;
            
        }
      


    }
  
 
  

    }


