import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Process {
    int id;            
    int burstTime;     
    int waitingTime;   
    int turnAroundTime; 
    int completionTime; 

    Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }
}

public class SJFScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            int burstTime = sc.nextInt();
            processes[i] = new Process(i + 1, burstTime);
        }

      
        Arrays.sort(processes, Comparator.comparingInt(p -> p.burstTime));

        int totalWaitingTime = 0, totalTurnAroundTime = 0, totalCompletionTime = 0;
        processes[0].waitingTime = 0;
        processes[0].turnAroundTime = processes[0].burstTime;
        processes[0].completionTime = processes[0].burstTime; 

      
        for (int i = 1; i < n; i++) {
            processes[i].waitingTime = processes[i - 1].waitingTime + processes[i - 1].burstTime;
            processes[i].turnAroundTime = processes[i].waitingTime + processes[i].burstTime;
            processes[i].completionTime = processes[i].waitingTime + processes[i].burstTime;

            totalWaitingTime += processes[i].waitingTime;
            totalTurnAroundTime += processes[i].turnAroundTime;
            totalCompletionTime += processes[i].completionTime;
        }

        
        System.out.println("\nProcess Execution Order (SJF): ");
        for (Process process : processes) {
            System.out.println("Process " + process.id + ": Burst Time = " + process.burstTime
                    + ", Waiting Time = " + process.waitingTime
                    + ", Turnaround Time = " + process.turnAroundTime
                    + ", Completion Time = " + process.completionTime);
        }

    
        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnAroundTime = (double) totalTurnAroundTime / n;
        double avgCompletionTime = (double) totalCompletionTime / n;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
        System.out.println("Average Completion Time: " + avgCompletionTime);
    }
}
