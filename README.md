# CSCI-340-Project-1

The project involves implementing and analyzing various job scheduling algorithms in Java. Here's a summary of the key components:

Job Class: Represents a job with attributes such as arrival time, CPU burst, priority, exit time, turnaround time, and remaining time. Jobs are randomly generated for testing the scheduling algorithms.

# 1 First-In-First-Out (FIFO) Algorithm (FIFO.java):
Jobs are scheduled based on their arrival time, with the first job arriving first being processed first. The algorithm calculates exit time and turnaround time for each job.
# 2 Shortest Job First (SJF) Algorithm (SJF.java):
Jobs are scheduled based on their CPU burst time, with the shortest job being processed first. The algorithm calculates exit time, turnaround time, and remaining time for each job.
# 3 Highest Priority (HighestPriority.java):
Jobs are scheduled based on their priority, with the highest priority job being processed first. The algorithm calculates exit time, turnaround time, and updates arrival times for remaining jobs.
# 4Shortest Remaining Time First (SRTF) Algorithm (SRJ.java):
Jobs are scheduled based on their remaining CPU burst time, with the job having the shortest remaining time being processed first. The algorithm calculates exit time, turnaround time, and updates arrival times for remaining jobs.
# 5 Round Robin Algorithm (RoundRobin.java):
Jobs are scheduled in a round-robin fashion, with each job getting a time quantum to execute. The algorithm handles context switching and calculates exit time, turnaround time, and remaining time for each job.
Each algorithm is implemented as a separate class with a run() method to execute the scheduling logic. 

The main class generates a list of random jobs and runs each scheduling algorithm to compare their performance in terms of average waiting time and average turnaround time. The project demonstrates the use of different scheduling algorithms and their impact on job scheduling efficiency.






