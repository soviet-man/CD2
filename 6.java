/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    static Map<Character,List<String>> grammer =new HashMap<>();
    static String input;
    static int i=0;
	public static void main(String[] args) {
	
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the no of productions");
	 int num=sc.nextInt();
	 sc.nextLine();
	 for(int i=0;i<num;i++){
	     String pro[]=sc.nextLine().split("->");
	     grammer.put(pro[0].charAt(0),Arrays.asList(pro[1].split("\\|")));
	 }
	 System.out.println("Enter the sttring");
	 input=sc.nextLine()+"$";
	 sc.close();
	 System.out.println(parse('E')&&i==input.length()-1?"String is accepted":"String is rejected");
	}
	public static boolean parse(char Non){
	    int backtrack=i;
	    
	    for(String pros:grammer.get(Non)){
	        i=backtrack;
	        boolean isleft=true;
	        for(char ch:pros.toCharArray()){
	            if(ch=='@')
	             continue;
	             else if(Character.isUpperCase(ch)){
	                 isleft&=parse(ch);
	             }
	             else if(i<input.length()&&ch==input.charAt(i)){
	                 i++;
	             }
	             else {
	                 isleft=false;
	                 break;
	             }
	        }
	        if(isleft)
	          return true;
	    }
	    return false;
	}
}