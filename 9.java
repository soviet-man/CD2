/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
   public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       Stack<Integer> s=new Stack<>();
       System.out.println("1.insert\n2.delete\n3.peekvale\n4.display\n5.exit");
       int n=sc.nextInt();
       do{
           switch(n){
               case 1:System.out.println("Enter the number");
                      int a=sc.nextInt();
                      s.push(a);
                      break;
               case 2:System.out.println("the deleted value is :"+s.pop());
               break;
               case 3:System.out.println("the peek value is :"+s.peek());
                  break;
            case 4:for(int i=s.size()-1;i>=0;i--){
                  System.out.println(s.get(i));
            } 
            break;
           }
            System.out.println("1.insert\n2.delete\n3.peekvale\n4.display\n5.exit");
           n=sc.nextInt();
       }while(n<=4);
   }
	
}