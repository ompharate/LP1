 import java.util.Scanner;
 public class FCFS {
 Scanner sc = new Scanner(System.in);
 public static void main(String args[]) {
 FCFS scheduler = new FCFS();
 scheduler.FCFS();
 scheduler.SJF();
 scheduler.Priority();
 }
 private void Priority() {
 System.out.println("Enter No. Of processes:");
 int nop = sc.nextInt();
 String[] pname = new String[nop];
 int[] arr_time = new int[nop];
 int[] burst_time = new int[nop];
 int[] priority = new int[nop];
 // Input process details
 for (int i = 0; i < nop; i++) {
 System.out.println("Enter Process Name, Arrival Time, Burst Time, and Priority:");
 pname[i] = sc.next();
 arr_time[i] = sc.nextInt();
 burst_time[i] = sc.nextInt();
 priority[i] = sc.nextInt();
 }
 // Sort based on arrival time, then by priority
 for (int i = 0; i < nop- 1; i++) {
 for (int j = i + 1; j < nop; j++) {
 if (arr_time[i] > arr_time[j] ||
 (arr_time[i] == arr_time[j] && priority[i] > priority[j])) {
 // Swap arrival time
 int temp = arr_time[i];
 arr_time[i] = arr_time[j];
 arr_time[j] = temp;
 // Swap burst time
 temp = burst_time[i];
 burst_time[i] = burst_time[j];
 burst_time[j] = temp;
 // Swap priority
 temp = priority[i];
 priority[i] = priority[j];
 priority[j] = temp;
 // Swap process name
 String tempName = pname[i];
 pname[i] = pname[j];
 pname[j] = tempName;
 }
 }
 }
// Calculate completion, turnaround, and waiting times
 int[] completion_time = new int[nop];
 int[] turn_around_time = new int[nop];
 int[] waiting_time = new int[nop];
 for (int i = 0; i < nop; i++) {
 if (i == 0) {
 completion_time[i] = arr_time[i] + burst_time[i];
 } else {
 completion_time[i] = Math.max(completion_time[i- 1], arr_time[i]) + burst_time[i];
 }
 turn_around_time[i] = completion_time[i]- arr_time[i];
 waiting_time[i] = turn_around_time[i]- burst_time[i];
 }
 // Display results
 System.out.println("Process | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting
 Time");
 for (int i = 0; i < nop; i++) {
 System.out.printf("%s\t|\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%d\n",
 pname[i], arr_time[i], burst_time[i],
 completion_time[i], turn_around_time[i],
 waiting_time[i]);
 }
 }
 private void SJF() {
 System.out.println("Enter No. Of processes:");
 int nop = sc.nextInt();
 String[] pname = new String[nop];
 int[] arr_time = new int[nop];
 int[] burst_time = new int[nop];
 // Input process details
 for (int i = 0; i < nop; i++) {
 System.out.println("Enter Process Name, Arrival Time, and Burst Time:");
 pname[i] = sc.next();
 arr_time[i] = sc.nextInt();
 burst_time[i] = sc.nextInt();
 }
 // Sort based on arrival time
 for (int i = 0; i < nop- 1; i++) {
 for (int j = i + 1; j < nop; j++) {
 if (arr_time[i] > arr_time[j]) {
 // Swap arrival time
 int temp = arr_time[i];
 arr_time[i] = arr_time[j];
 arr_time[j] = temp;
 // Swap burst time
 temp = burst_time[i];
 burst_time[i] = burst_time[j];
 burst_time[j] = temp;
 // Swap process name
 String tempName = pname[i];
 pname[i] = pname[j];
 pname[j] = tempName;
}
 }
 }
 // Calculate completion, turnaround, and waiting times
 int[] completion_time = new int[nop];
 int[] turn_around_time = new int[nop];
 int[] waiting_time = new int[nop];
 for (int i = 0; i < nop; i++) {
 if (i == 0) {
 completion_time[i] = arr_time[i] + burst_time[i];
 } else {
 completion_time[i] = Math.max(completion_time[i- 1], arr_time[i]) + burst_time[i];
 }
 turn_around_time[i] = completion_time[i]- arr_time[i];
 waiting_time[i] = turn_around_time[i]- burst_time[i];
 }
 // Display results
 System.out.println("Process | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting
 Time");
 for (int i = 0; i < nop; i++) {
 System.out.printf("%s\t|\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%d\n",
 pname[i], arr_time[i], burst_time[i],
 completion_time[i], turn_around_time[i],
 waiting_time[i]);
 }
 }
 private void FCFS() {
 System.out.println("Enter No. Of processes:");
 int nop = sc.nextInt();
 String[] pname = new String[nop];
 int[] arr_time = new int[nop];
 int[] burst_time = new int[nop];
 // Input process details
 for (int i = 0; i < nop; i++) {
 System.out.println("Enter Process Name, Arrival Time, and Burst Time:");
 pname[i] = sc.next();
 arr_time[i] = sc.nextInt();
 burst_time[i] = sc.nextInt();
 }
 // Sort based on arrival time
 for (int i = 0; i < nop- 1; i++) {
 for (int j = i + 1; j < nop; j++) {
 if (arr_time[i] > arr_time[j]) {
 // Swap arrival time
 int temp = arr_time[i];
 arr_time[i] = arr_time[j];
 arr_time[j] = temp;
 // Swap burst time
 temp = burst_time[i];
 burst_time[i] = burst_time[j];
 burst_time[j] = temp;
// Swap process name
 String tempName = pname[i];
 pname[i] = pname[j];
 pname[j] = tempName;
 }
 }
 }
 // Calculate completion, turnaround, and waiting times
 int[] completion_time = new int[nop];
 int[] turn_around_time = new int[nop];
 int[] waiting_time = new int[nop];
 for (int i = 0; i < nop; i++) {
 if (i == 0) {
 completion_time[i] = arr_time[i] + burst_time[i];
 } else {
 completion_time[i] = Math.max(completion_time[i- 1], arr_time[i]) + burst_time[i];
 }
 turn_around_time[i] = completion_time[i]- arr_time[i];
 waiting_time[i] = turn_around_time[i]- burst_time[i];
 }
 // Display results
 System.out.println("Process | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting
 Time");
 for (int i = 0; i < nop; i++) {
 System.out.printf("%s\t|\t%d\t|\t%d\t|\t%d\t|\t%d\t|\t%d\n",
 pname[i], arr_time[i], burst_time[i],
 completion_time[i], turn_around_time[i],
 waiting_time[i]);
 }
 }
 }