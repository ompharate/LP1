import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FIFO {
    public static void main(String args[]) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int f, page = 0, ch, pgf = 0, n, chn = 0, phit = 0;
        boolean flag;
        int pages[];
        int pt = 0;
        System.out.println("enter no. of frames: ");
        f = Integer.parseInt(obj.readLine());
        int frame[] = new int[f];
        for (int i = 0; i < f; i++) {
            frame[i] = -1;
        }
        System.out.println("enter the no of pages ");
        n = Integer.parseInt(obj.readLine());
        pages = new int[n];
        System.out.println("enter the page no ");
        for (int j = 0; j < n; j++)
            pages[j] = Integer.parseInt(obj.readLine());
        do {
            int pg = 0;
            for (pg = 0; pg < n; pg++) {
                page = pages[pg];
                flag = true;
                for (int j = 0; j < f; j++) {
                    if (page == frame[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    frame[pt] = page;
                    pt++;
                    if (pt == f)
                        pt = 0;
                    System.out.print("frame :");
                    for (int j = 0; j < f; j++)
                        System.out.print(frame[j] + " ");
                    System.out.println();
                    pgf++;
                } else {
                    System.out.print("frame :");
                    for (int j = 0; j < f; j++)
                        System.out.print(frame[j] + " ");
                    System.out.println();
                }
                chn++;
            }
        } while (chn != n);
        phit = n - pgf;
        System.out.println("Page fault:" + pgf);
        System.out.println("Page hit:" + phit);
    }
}