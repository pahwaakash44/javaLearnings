package hacker.rank.interviewpreparationkit.oneweek.daythree;

import java.util.Arrays;

public class ZigZagSequence
{
    public static void main (String[] args)
    {
        /*Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }*/
        int[] array = /*new int[]{1,2,3,4,5,6,7};*/ new int[]{2,3,5,1,4};
//        findZigZagSequence(new int[]{1,2,3,4,5,6,7}, 7);
        findZigZagSequence1(array, array.length);
    }
    
    public static void findZigZagSequence(int [] a, int n)
    {
        Arrays.sort(a);
        for (int i = 0; i < n ; i++)
        {
            System.out.printf("a[%d] = %d, ", i, a[i]);
        }
        System.out.println("");
        int mid = (n + 1)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
    
        System.out.printf("swap element: a[%d] = %d, end: a[%d] = %d%n", mid, a[mid], n-1, a[n-1]);
    
        System.out.println("post swap array");
        for (int i = 0; i < n ; i++)
        {
            System.out.printf("a[%d] = %d, ", i, a[i]);
        }
    
        System.out.println("\nagain some swap");
        
        int st = mid + 1;
        int ed = n - 1;
        
        System.out.printf("before loop start: %d, end: %d%n", st, ed);
        
        while(st <= ed)
        {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            
            System.out.printf("start: a[%d] = %d, end: a[%d] = %d%n", st, a[st], ed, a[ed]);
            
            st = st + 1;
            ed = ed + 1;
            System.out.printf("post increment start: %d, end: %d%n", st, ed);
        }
    
        System.out.println("final array");
        for(int i = 0; i < n; i++)
        {
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
    
    //working
    // need to change the lines which are identified by the author as error
    public static void findZigZagSequence1(int [] a, int n){
        Arrays.sort(a);
        for (int i = 0; i < n ; i++)
        {
            System.out.printf("a[%d] = %d, ", i, a[i]);
        }
        System.out.println("");
        int mid = (n - 1)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
        System.out.printf("swap element: a[%d] = %d, end: a[%d] = %d%n", mid, a[mid], n-1, a[n-1]);
    
        System.out.println("post swap array");
        for (int i = 0; i < n ; i++)
        {
            System.out.printf("a[%d] = %d, ", i, a[i]);
        }
    
        System.out.println("\nagain some swap");
        
        int st = mid + 1;
        int ed = n - 2;
        System.out.printf("before loop start: %d, end: %d%n", st, ed);
        while(st <= ed && ed < n-1){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            System.out.printf("start: a[%d] = %d, end: a[%d] = %d%n", st, a[st], ed, a[ed]);
            st = st + 1;
            ed = ed - 1;
            System.out.printf("post increment start: %d, end: %d%n", st, ed);
        }
    
        System.out.println("final array");
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
