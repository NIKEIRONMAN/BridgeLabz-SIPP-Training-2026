import java.util.*;
public class BankFraudDetection{
 static long cnt;
 static void ms(int[]a,int l,int r){
  if(l>=r)return;
  int m=(l+r)/2; ms(a,l,m); ms(a,m+1,r);
  int j=m+1;
  for(int i=l;i<=m;i++){
    while(j<=r && (long)a[i] > 3L*a[j]) j++;
    cnt += j-(m+1);
  }
  int[]t=new int[r-l+1];
  int i=l; j=m+1; int k=0;
  while(i<=m&&j<=r)t[k++]=a[i]<=a[j]?a[i++]:a[j++];
  while(i<=m)t[k++]=a[i++];
  while(j<=r)t[k++]=a[j++];
  for(i=0;i<t.length;i++)a[l+i]=t[i];
 }
 public static void main(String[]args){
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();int[]a=new int[n];
  for(int i=0;i<n;i++)a[i]=sc.nextInt();
  ms(a,0,n-1);
  System.out.println(cnt);
 }
}
