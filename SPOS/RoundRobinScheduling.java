import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    int id;           
    int burstTime;      
    int remainingTime; 

    Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter the time quantum: ");
        int quantum = sc.nextInt();

      
        Queue<Process> processQueue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter burst time for process " + i + ": ");
            int burstTime = sc.nextInt();
            processQueue.add(new Process(i, burstTime));
        }

        int currentTime = 0;

     
        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.poll();

         
            if (currentProcess.remainingTime > quantum) {
                currentTime += quantum;
                currentProcess.remainingTime -= quantum;
                System.out.println("Process " + currentProcess.id + " executed for " + quantum + " units. Remaining time: " + currentProcess.remainingTime);
                processQueue.add(currentProcess);  
            } else {

                currentTime += currentProcess.remainingTime;
                System.out.println("Process " + currentProcess.id + " executed for " + currentProcess.remainingTime + " units and finished.");
            }
        }

        System.out.println("Total execution time: " + currentTime + " units.");
    }
}