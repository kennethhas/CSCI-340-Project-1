import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SRJ {

    // Method to run the Shortest Remaining Time First (SRTF) scheduling algorithm
    public static void runSRTF(List<Job> jobs) {
        // Sort the jobs based on arrival time
        jobs.sort(Comparator.comparingInt(Job::getArrivalTime));

        // Create a priority queue to store jobs based on remaining time (and arrival time for tie-breaker)
        Queue<Job> queue = new PriorityQueue<>(Comparator.comparingInt(Job::getRemainingTime).thenComparingInt(Job::getArrivalTime));
        int currentTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;

        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");

        // Process until all jobs are completed
        while (!jobs.isEmpty() || !queue.isEmpty()) {
            // Add arriving jobs to the queue
            while (!jobs.isEmpty() && jobs.get(0).getArrivalTime() <= currentTime) {
                queue.offer(jobs.remove(0));
            }

            // Process the current job or idle
            if (!queue.isEmpty()) {
                // Get the job with the shortest remaining time
                Job currentJob = queue.poll();
                // Calculate waiting time
                int waitTime = currentTime - currentJob.getArrivalTime();
                if (waitTime < 0) {
                    waitTime = 0;
                }
                totalWaitTime += waitTime;
                // Calculate turnaround time
                totalTurnaroundTime += waitTime + currentJob.getCpuBurst();

                // Move current time to the completion time of the current job
                currentTime += currentJob.getCpuBurst();

                // Print the details of the completed job
                System.out.println(currentJob + "\t\t" + waitTime + "\t\t" + (waitTime + currentJob.getCpuBurst()));
            } else {
                // No job is available, so move to the next time unit
                currentTime++;
            }
        }

        // Calculate and print average waiting and turnaround times
        System.out.println("\nAverage Waiting Time: " + (double) totalWaitTime / jobs.size());
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / jobs.size());
    }

    // Main method to generate random jobs and run the SRTF algorithm
    public static void main(String[] args) {
        Random random = new Random();
        List<Job> jobs = new ArrayList<>();
        int numJobs = 25; // Number of jobs to generate

        // Generate random jobs
        for (int i = 0; i < numJobs; i++) {
            Job job = new Job();
            jobs.add(job);
        }

        // Run the SRTF algorithm on the generated jobs
        runSRTF(jobs);
    }
}
