import java.util.*;
public class QuickSortFlightPrices{
 static int part(int[] a,int l,int h){
   int p=a[h],i=l-1;
   for(int j=l;j<h;j++) if(a[j]<=p){i++;int t=a[i];a[i]=a[j];a[j]=t;}
   int t=a[i+1];a[i+1]=a[h];a[h]=t; return i+1;
 }
 static void qs(int[]a,int l,int h){
   if(l<h){int p=part(a,l,h);qs(a,l,p-1);qs(a,p+1,h);}
 }
 public static void main(String[]args){
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();int[]a=new int[n];
  for(int i=0;i<n;i++)a[i]=sc.nextInt();
  qs(a,0,n-1);
  for(int x:a)System.out.print(x+" ");
 }
}
