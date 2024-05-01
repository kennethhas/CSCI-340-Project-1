import java.util.*;

public class RoundRobin {
    private List<Job> jobs; // List of jobs
    private int timeQuantum; // Time quantum for each job
    private int contextSwitchTime; // Time required for context switching

    // Constructor to initialize the Round Robin scheduler
    public RoundRobin(List<Job> jobs, int timeQuantum, int contextSwitch) {
        this.jobs = jobs; // Initialize the list of jobs
        this.timeQuantum = timeQuantum; // Initialize the time quantum
        this.contextSwitchTime = contextSwitch; // Initialize the context switch time
    }

    // Method to run the Round Robin scheduler
    public void run() {
        Queue<Job> jobQueue = new LinkedList<>(jobs); // Queue to store jobs
        Queue<Job> roundRobinQueue = new LinkedList<>(); // Queue for the Round Robin algorithm
        int currentTime = 0; // Current time of the scheduler
        int remainingContextSwitch = 0; // Remaining time for context switch

        // Process jobs until both queues are empty
        while (!jobQueue.isEmpty() || !roundRobinQueue.isEmpty()) {
            // Add arriving jobs to the round robin queue
            while (!jobQueue.isEmpty() && jobQueue.peek().getArrivalTime() <= currentTime) {
                roundRobinQueue.offer(jobQueue.poll());
            }

            // Process the current job or context switch
            if (remainingContextSwitch == 0) {
                Job currentJob = roundRobinQueue.poll();
                if (currentJob != null) {
                    // Determine the time slice for the job
                    int timeSlice = Math.min(timeQuantum, currentJob.getRemainingTime());
                    currentJob.setRemainingTime(currentJob.getRemainingTime() - timeSlice);
                    currentTime += timeSlice;

                    // Check if job is finished
                    if (currentJob.getRemainingTime() == 0) {
                        currentJob.setExitTime(currentTime);
                        currentJob.setTurnaroundTime(currentJob.getExitTime() - currentJob.getArrivalTime());
                        System.out.println(currentJob); // Print the job details
                    } else {
                        roundRobinQueue.offer(currentJob); // Re-add the job to the queue
                    }

                    remainingContextSwitch = contextSwitchTime; // Set context switch time
                } else {
                    currentTime++; // Increment current time
                }
            } else {
                remainingContextSwitch--; // Decrement remaining context switch time
                currentTime++; // Increment current time
            }
        }
    }

    // Main method to create and run the Round Robin scheduler
    public static void main(String[] args) {
        Random random = new Random();
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            jobs.add(new Job()); // Create random jobs
        }

        int timeQuantum = random.nextInt(3) + 1; // Random time quantum between 1 and 3
        int contextSwitch = random.nextInt(2) + 1; // Random context switch between 1 and 2

        RoundRobin roundRobin = new RoundRobin(jobs, timeQuantum, contextSwitch);
        roundRobin.run(); // Run the Round Robin scheduler
    }
}
