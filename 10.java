/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    static List<String> code=new ArrayList<>();
    static Stack<String> operand=new Stack<>();
    static Stack<Character> operater=new Stack<>();
    static int count =0;
	public static void main(String[] args) {
	    Scanner sc=new Scanner (System.in);
	    System.out.println("Enter the String ");
	    String s=sc.nextLine();
	    function(s);
	    System.out.println("Intermediate code is:");
	    for(int i=0;i<code.size();i++){
	        System.out.println(code.get(i));
	    }
	}
	public static void function(String s){
	    for(int i=0;i<s.length();i++){
	        char ch=s.charAt(i);
	        if(Character.isLetterOrDigit(ch)){
	            operand.add(Character.toString(ch));
	        }
	        else{
	            while(operater.size()>0&&proc(operater.peek())>=proc(ch)){
	                process();
	            }
	            operater.add(ch);
	        }
	    }
	    while(!operater.isEmpty()){
	        process();
	    }
	}
	public static void process(){
	    String ch1=operand.pop();
	    String ch2=operand.pop();
	    String s="t"+count+"="+ch2+operater.pop()+ch1;
	    code.add(s);
	    operand.add("t"+count);
	    count++;
	}
	public static int proc(char ch){
	    switch(ch){
	        case '+':case '-':return 1;
	        case '*':case '/':return 2;
	        default:return 0;
	    }
	}
	
}