import java.util.*;

public class FIFO {
    protected List<Job> jobs;

    public FIFO(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void run() {
        // Sort jobs based on arrival time
        Collections.sort(jobs, Comparator.comparing(Job::getArrivalTime));
        int currentTime = 0;
        for (Job job : jobs) {
            // If current time is before job arrival time, move to job arrival time
            if (currentTime < job.getArrivalTime()) {
                currentTime = job.getArrivalTime();
            }
            // Set exit time for the job
            job.setExitTime(currentTime + job.getCpuBurst());
            // Calculate turnaround time for the job
            job.setTurnaroundTime(job.getExitTime() - job.getArrivalTime());
            currentTime = job.getExitTime();
        }
    }
}
