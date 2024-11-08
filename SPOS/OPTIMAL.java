import java.io.*;

class optimal {
    public static void main(String args[]) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int f, page = 0, pgf = 0, n, chn = 0;
        boolean flag;
        int pages[];
        int pt = 0;
        System.out.println("Enter the number of frames: ");
        f = Integer.parseInt(obj.readLine());
        int frame[] = new int[f];
        for (int i = 0; i < f; i++) {
            frame[i] = -1;
        }
        System.out.println("Enter the number of pages: ");
        n = Integer.parseInt(obj.readLine());
        pages = new int[n];
        System.out.println("Enter the page numbers: ");
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
                
                    if (pt < f) {
                        frame[pt] = page;
                        pt++;
                    } else {
                  
                        int farthest = -1;
                        int indexToReplace = -1;
                        for (int j = 0; j < f; j++) {
                            int nextUse = -1;
                            for (int k = pg + 1; k < n; k++) {
                                if (frame[j] == pages[k]) {
                                    nextUse = k;
                                    break;
                                }
                            }
                        
                            if (nextUse == -1) {
                                indexToReplace = j;
                                break;
                            }
                          
                            if (nextUse > farthest) {
                                farthest = nextUse;
                                indexToReplace = j;
                            }
                        }
                    
                        frame[indexToReplace] = page;
                    }
              
                    System.out.print("Frame: ");
                    for (int j = 0; j < f; j++) {
                        System.out.print(frame[j] + " \t ");
                    }
                    System.out.println();
                    pgf++; 
                } else {
               
                    System.out.print("Frame: ");
                    for (int j = 0; j < f; j++) {
                        System.out.print(frame[j] + " \t ");
                    }
                    System.out.println();
                }
                chn++;
            }
        } while (chn != n);
        int phit = n - pgf; 
        System.out.println("Page fault: " + pgf);
        System.out.println("Page hit: " + phit);
    }
}