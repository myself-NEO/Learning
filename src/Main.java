import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// n is no of test cases
        for (int i = 0; i < n; i++) {
            //  int f=Integer.parseInt(br.readLine());
            String str=br.readLine();
            ArrayList<Integer> ans=new ArrayList<>();
            for(String s:str.split(" ")){
                ans.add(Integer.parseInt(s));
            }

            String str2=br.readLine();
            ArrayList<Long> ans2=new ArrayList<>();
            for(String s:str2.split(" ")){
                ans2.add(Long.parseLong(s));
            }

            String str3=br.readLine();
            ArrayList<Long> ans3=new ArrayList<>();
            for(String s:str3.split(" ")){
                ans3.add(Long.parseLong(s));
            }
            fnc(ans2,ans3,ans.get(1)-1);
        }


    }

    public static long mySqrt(long x) {
        long l = 0 , r =(int)1e9;
        while(r - l > 1){
            long m = (l+r) >>> 1;
            // System.out.println(m + " " + l + " " + r);
            if(m * m > x) r = m;
            else l = m;
        }
        return r-1;
    }


    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    // a^b % x  : binary exponentiation !!
    public static long binPow(long a,long b,long mod)
    {
        if (b == 0)return 1;
        if (b == 1)return a;
        long ret = binPow(a,b/2,mod);
        if (b%2 == 0)return (ret * ret)%mod;
        return ((ret * ret)%mod * a)%mod;
    }

    public static long inv(long a,long mod)
    {
        return (binPow(a,mod - 2,mod)%mod + mod)%mod;
    }

    // nCr mod P : VVIMP STANDARD TEMPLATE !!
    public static long nCrModPFermat(int a, int b,long mod) {
        if (b < 0 || a < 0)return 0;
        return (((fact[a] * inv(fact[b],mod))%mod * inv(fact[a - b],mod))%mod + mod)%mod;
    }


    static long[] fact;
    public static void fnc(ArrayList<Long> a1,ArrayList<Long> b1,int m){

        // mth wale pe ruk jaoge ?
        // aM lena padega :
        long sum=0;
        long min=Long.MAX_VALUE;
        for(int i=a1.size()-1;i>=0;i--){
            if(i<=m){
                long temp=(sum+a1.get(i)); // means we are ending over here !!
                min=Math.min(min,temp);

                sum=sum+Math.min(a1.get(i),b1.get(i));
            }
            else{
                sum=(sum)+Math.min(a1.get(i),b1.get(i));
            }
        }


        System.out.println(min);

    }


}

