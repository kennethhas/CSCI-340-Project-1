import java.util.List;

public abstract class Scheduler {
    protected List<Job> jobs;

    public Scheduler(List<Job> jobs) {
        this.jobs = jobs;
    }

    public abstract void run();
}

