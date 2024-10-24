 import java.io.*;
 class LRU
 {
 public static void main(String args[])throws IOException
 {
 BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
 int f,page=0,ch,pgf=0,n,chn=0,phit=0;
 boolean flag;
 int pages[];
 int pt=0;
 int k=0;
 System.out.println("enter no. of frames: ");
 f=Integer.parseInt(obj.readLine());
 int frame1[]=new int[f];
 int a[]=new int[f];
 int b[]=new int[f];
 for(int i=0;i<f;i++)
 {
 frame1[i]=-1;
 a[i]=-1;
 b[i]=-1;
 }
 System.out.println("enter the no of pages ");
 n=Integer.parseInt(obj.readLine());
 pages=new int[n];
 System.out.println("enter the page no ");
 for(int j=0;j<n;j++)
 pages[j]=Integer.parseInt(obj.readLine());
 do{
 int pg=0;
for(pg=0;pg<n;pg++)
 {
 page=pages[pg];
 flag=true;
 for(int j=0;j<f;j++)
 {
 if(page==frame1[j])
 {flag=false; break;}
 }
 for(int j=0;j<f && flag;j++)
 {
 if(frame1[j]==a[f-1])
 {k=j;
 break;}
 }
 if(flag)
 {
 frame1[k]=page;
 System.out.println("frame :" );
 for(int j=0;j<f;j++)
 System.out.print(frame1[j]+" ");
 pgf++;
 System.out.println();
 }
 else
 {
 System.out.println("frame :" );
 for(int j=0;j<f;j++)
 System.out.print(frame1[j]+" ");
 System.out.println();
 }
 int p=1;
 b[0]=page;
 for(int j=0;j<a.length;j++)
 {
 if(page!=a[j] && p<f)
 {
 b[p]=a[j];
 p++;
 }
 }
 for(int j=0;j<f;j++)
 {
 a[j]=b[j];
 }
 chn++;
 }
 }while(chn!=n);
 phit=n-pgf;
 System.out.println("Page fault:"+pgf);
 System.out.println("Page hit:"+phit);}}