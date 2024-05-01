import java.util.*;

public class HighestPriority {
    private List<Job> jobs;

    public HighestPriority(List<Job> jobs) {
        this.jobs = jobs;
    }
    public List<Job> getJobs() {
        return jobs;
    }
    public void run() {
        // Sort jobs by priority (lower value means higher priority)
        Collections.sort(jobs, Comparator.comparingInt(Job::getPriority));

        int currentTime = 0;
        while (!jobs.isEmpty()) {
            Job currentJob = jobs.get(0); // Get the highest priority job
            jobs.remove(0); // Remove it from the list

            // Calculate exit and turnaround times
            currentJob.setExitTime(currentTime + currentJob.getCpuBurst());
            currentJob.setTurnaroundTime(currentJob.getExitTime() - currentJob.getArrivalTime());

            // Update remaining jobs' arrival times
            for (Job job : jobs) {
                if (job.getArrivalTime() <= currentJob.getExitTime()) {
                    job.setArrivalTime(currentJob.getExitTime());
                }
            }

            // Increment current time
            currentTime = currentJob.getExitTime();

            // Print the current job
            System.out.println(currentJob);
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            jobs.add(new Job());
        }

        HighestPriority highestPriority = new HighestPriority(jobs);
        highestPriority.run();
    }
}