import java.util.*;

public class SJF {
    List<Job> jobs;

    public SJF(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void run() {
        List<Job> result = new ArrayList<>();
        int currentTime = 0;

        // Sort jobs by CPU burst time
        jobs.sort(Comparator.comparingInt(Job::getCpuBurst));

        for (Job job : jobs) {
            // Check if the job arrives after the current time
            if (job.getArrivalTime() > currentTime) {
                currentTime = job.getArrivalTime();
            }

            // Calculate exit time, turnaround time, and remaining time
            int exitTime = currentTime + job.getCpuBurst();
            int turnaroundTime = exitTime - job.getArrivalTime();
            int remainingTime = 0; // SJF is non-preemptive, so remaining time is 0

            // Update job information
            job.setExitTime(exitTime);
            job.setTurnaroundTime(turnaroundTime);
            job.setRemainingTime(remainingTime);

            // Add job to result list
            result.add(job);

            // Update current time
            currentTime = exitTime;
        }

        // Display results if needed
       
    }
}
