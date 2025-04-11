// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    static char opt[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of terminals");
        int n=sc.nextInt();
        sc.nextLine();
        opt=new char [n][n];
        System.out.println("Enter the terminals");
        String str=sc.nextLine();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println("Enter the value for "+str.charAt(i)+str.charAt(j)+":");
                opt[i][j]=sc.nextLine().charAt(0);
            }
        }
        System.out.println("operator table is");
        System.out.println("\t");
        
        for(int i=0;i<n;i++){
        System.out.print(str.charAt(i)+"\t");    
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(str.charAt(i)+"\t");
            for(int j=0;j<n;j++){
                System.out.print(opt[i][j]+"\t");
            }
            System.out.println();
        }
        String input=sc.nextLine();
        String s="$";
        int i=0;
        System.out.println("stack\tinput\taction");
        while(true){
            int idx1=str.indexOf(s.charAt(s.length()-1));
            int idx2=str.indexOf(input.charAt(i));
            if(opt[idx1][idx2]!='>'){
                s+=opt[idx1][idx2];
                s+=input.charAt(i);
                i++;
                System.out.println(s+"\t"+input.substring(i)+"\t"+"shift"+input.charAt(i-1));
            }
            while(s.length()>2&&(opt[idx1][idx2]=='>'||opt[idx1][idx2]=='=')){
                s=s.substring(0,s.length()-2);
                System.out.println(s+"\t"+input.substring(i)+"\t"+"Reduce"+input.charAt(i-1));
                idx1=str.indexOf(s.charAt(s.length()-1));
            }
            if(i==input.length()&&s.charAt(s.length()-1)=='$'){
                System.out.println("Accepted");
                break;
            }
            if(i==input.length()){
                 System.out.println("rejected");
                break;
            }
        }
    }
}