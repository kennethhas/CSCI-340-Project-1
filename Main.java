import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Generate 25 random jobs
        List<Job> jobs = generateJobs(5);
        
        // Create FIFO scheduler and run it
        FIFO fifoScheduler = new FIFO(new ArrayList<>(jobs));
        fifoScheduler.run();

        // Create SJF scheduler and run it
        SJF sjfScheduler = new SJF(new ArrayList<>(jobs));
        sjfScheduler.run();

            System.out.println("SRJ:");
        // Create SRJ scheduler and run it
        //  SRJ srjScheduler = new SRJ(new ArrayList<>(jobs));
        //  srjScheduler.run();
        System.out.println("------------");
        // Create Highest Priority scheduler and run it
         HighestPriority highestPriorityScheduler = new HighestPriority(new ArrayList<>(jobs));
         highestPriorityScheduler.run();

        //Display results for all schedulers
        HighestPriority highestPriority = new HighestPriority(jobs);
        List<Job> jobsList = highestPriority.getJobs();
        
        System.out.println("------------");
        displayResults(highestPriorityScheduler.getJobs(), "Highest Priority");
        // System.out.println("------------");
        // displayResults(srjScheduler.jobs,"SRJ;" );
        displayResults(fifoScheduler.jobs, "FIFO");
        System.out.println("------------");
        displayResults(sjfScheduler.jobs, "SJF");
        System.out.println("------------");
    }
    // Method to generate random jobs
    private static List<Job> generateJobs(int count) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            jobs.add(new Job());
        }
        return jobs;
    }

    // Method to display results for a scheduler
    private static void displayResults(List<Job> jobs, String schedulerName) {
        System.out.println(schedulerName + ":");
        for (Job job : jobs) {
            System.out.println(job);
        }
        System.out.println(); // Add a blank line for readability
    }
}
