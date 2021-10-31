/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureshw1;

/**
 *
 * @author Veteran
 */
public class DataStructuresHW1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("question1 X power of n : ");
        System.out.println(xPowerOfN(3, 4));
        System.out.println(xPowerOfN(3, -4));
        System.out.println("------------");
        
        System.out.println("question2 change money to 50 100 500 :");
        int[] moneys = {50,100,500};
        System.out.println(changeMoney(moneys, moneys.length, 1000));
        System.out.println("------------");
        
        System.out.println("question3 Greatest Common Divisor:");
        System.out.println(GCD(750, 500));
        System.out.println("------------");
        
        System.out.println("question4 Ackerman:");
        System.out.println(ackerman(3,1));
        System.out.println("------------");
        
        System.out.println("question5 add neighbor elements :");
        int[] a = {1,2,3,4,5};
        System.out.println(rec(a,0,a.length));
        System.out.println("------------");
        
        System.out.println("question11 find maxvalue in array:");
        int[] arr = {5, -1 ,195,-25,45,-65,152,-75,750,95,42,36,12,1,0};
        System.out.println(maxValue(arr, 0, arr.length-1));
        System.out.println("------------");
    }
    private static double xPowerOfN(int x, int n)//q1
    {
        if(n==0) return 1;
        if(n>0)
            return x * xPowerOfN(x, n-1);
        return 1.0/x * xPowerOfN(x, n+1);
    }

    private static int changeMoney(int[] moneys, int coinCounts, int yourMoney) {
        if (yourMoney == 0) return 1;
        if (yourMoney < 0) return 0;
        if (coinCounts <= 0 && yourMoney >= 1) return 0;

        return changeMoney(moneys, coinCounts - 1, yourMoney) + changeMoney(moneys, coinCounts, yourMoney - moneys[coinCounts - 1]);
    }
    private static int GCD(int x, int y)//q3
    {
        if(x<y)
        {
            x = x+y;
            y=x-y;
            x = x-y;
        }
        if(y==0)
            return x;
        return GCD(y,x%y);
    }
    private static int ackerman(int m, int n)//q4
    {
        if(m==0 && n>=0) return n+1;
        if(n==0 && m>0) return ackerman(m-1, 1);
        if(m>=0 && n>=0) return ackerman(m-1, ackerman(m, n-1));
        
        return n+1;
    }
    private static int rec(int[] arr, int i, int size)//q5
    {
        if(size == 0) return Integer.MIN_VALUE;
        if(size == 1) return arr[0];
        if(i<size-1)
        {
            arr[i] = arr[i]+arr[i+1];
            return rec(arr, i+1, size);
        }
        
        return rec(arr,0,size-1);
    }
    private static int[] recursiveWanted(int[] arr)//q5
    {
        if(arr.length == 1)
            return arr;
        int[] newArr = new int[arr.length-1];
        for(int i=0; i<(arr.length -1); i++)
        {
            newArr[i] = arr[i] + arr[i+1];
        }
        return recursiveWanted(newArr);
    }
    private static int maxValue(int[] a, int left, int right)//q11
    {
        if(left==right-1) return a[left];
        
        int mid = (int) (left+right)/2;
        int ans1 = maxValue(a, left, mid);
        int ans2 = maxValue(a, mid, right);
        
        if(ans1 > ans2)
            return ans1;
        
        return ans2;
    }
    private static void dumpArray(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }
    
}
