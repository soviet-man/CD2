import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of productions");
        int num=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<num;i++){
            String pro=sc.nextLine();
            Eliminate(pro);
        }
    }
    public static void Eliminate(String pro){
        String par[]=pro.split("->");
        String nonterminal=par[0].trim();
        String choice[]=par[1].split("/");
        if(choice[0].startsWith(nonterminal)){
            System.out.println("production has leftrecursion");
            String beta=choice[0].substring(1);
            System.out.print(nonterminal+"-> ");
            for(int i=1;i<choice.length;i++){
                if(i==choice.length-1){
                    System.out.print(choice[i]);
                }
                else
                System.out.print(choice[i]+nonterminal+"'/");
            }
            System.out.println(nonterminal+"'");
            System.out.println(nonterminal+"' ->"+beta+nonterminal+"'/epsilon");
        }
        else{
            System.out.println("there is no left recursion");
        }
    }
}