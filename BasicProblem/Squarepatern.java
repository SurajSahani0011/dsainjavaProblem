package BasicProblem;
import java.util.Scanner;
public class Squarepatern {

    public static void main(String[] args){
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();

       int curRow = 1;
       while (curRow <= n) {

        int curCol = 1;
        while (curCol <= n) {
            System.out.print(n);
            curCol = curCol + 1;
            
        }
        System.out.println();
         curRow = curRow + 1;
        
       }

    }
}










  