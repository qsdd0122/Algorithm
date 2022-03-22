import java.util.*;

//시간복잡도 : o(n^3)
public class report1 {
   private static int mcss1(int[] a, int n){
      int max = 0;
      int sum;
      for(int i=0; i < n; i++) {
         for(int j=i;j<n;j++) {
            sum=0;
            for(int k=i;k<=j;k++) {
               sum += a[k];
            }
            if(sum>max) 
               max = sum;
         }
      }
      return max;
   }
   
   //시간복잡도 : o(n)
   private static int mcss2(int[] a, int n){
      int sum = 0;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < a.length; i++) {
         sum = Math.max(sum + a[i], a[i]);
         max = Math.max(sum, max);
      }
      return max;
   }
   //시간복잡도 : o(n^2)
   private static int sol1(int[] a, int n){
      int max = 0;
      int sum;
      for(int i=0; i < n; i++) {
         sum=0;
         for(int j=i;j<n;j++) {
            sum = a[j]-a[i];
            if(sum>max) max=sum;
         }
      }
      return max;
   }
   //시간복잡도 : o(n)
   private static int sol2(int[] a, int n){
      int min = a[0];
      int max=0;
      int index=0;
      
      for(int i=1; i < n-1; i++) {
         if(a[i] < min) {
            min = a[i];
            index = i;
         }
      }      
      
      for(int i=index+1;i<n;i++) {
         int sub = a[i]-min;
         if(max<sub) max = sub;
      }
      return max;
   }
   
   public static void main(String[] args) {
      int[] a = {-7, 4, -3, 6, 3, -8, 3, 4};
      int n = 8;
      System.out.println("1-a: "+mcss1(a, n));
      System.out.println("1-b: "+mcss2(a, n));
      int[] a2 = {8, 1, 5, 3, 7, 4};
      int n2 = 6;
      System.out.println("2-a: "+sol1(a2, n2));
      System.out.println("2-b: "+sol2(a2, n2));
   }

}
