import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{

    public static void main (String[] args)
    {
        //Taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking count of total testcases
        int t = sc.nextInt();

        boolean flag = false;
        while(t-- > 0){

            //taking the String
            String s=sc.next();

            Geeks obj=new Geeks();

            //calling follPatt() method
            //of class Geeks and passing
            //String as parameter
            obj.follPatt(s);

        }
    }
}


// } Driver Code Ends
//User function Template for Java



class Geeks{

    static void follPatt(String s)
    {

        //Your code here
        int l = s.length();
        char pre = s.charAt(0);
        boolean alreadyPrinted = false;
        if(pre=='y') {
            System.out.println(0);
            alreadyPrinted = true;
            return;
        }
        int countx = 0;
        int county = 0;
        for(int i = 0; i<l; i++){
            char curr = s.charAt(i);
            if(curr == 'x'){
                countx++;
            }else {
                county++;
            }

            if(county>countx) {
                System.out.println(0);
                alreadyPrinted = true;
                return;
            }
            if(countx==county){
                countx = 0;
                county = 0;
            }
        }

        if(!alreadyPrinted) {
            if(countx==0 && county==0){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }

        System.out.println();
    }
}