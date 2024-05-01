import java.util.Random;

public class Job {
    protected int arrivalTime;
    protected int cpuBurst;
    protected int priority;
    protected int exitTime;
    protected int turnaroundTime;
    protected int remainingTime;

    public Job() {
        Random random = new Random();
        this.arrivalTime = random.nextInt(250) + 1;
        this.cpuBurst = random.nextInt(14) + 2;
        this.priority = random.nextInt(5) + 1;
        this.remainingTime = this.cpuBurst;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getCpuBurst() {
        return cpuBurst;
    }

    public int getPriority() {
        return priority;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "arrivalTime=" + arrivalTime +
                ", cpuBurst=" + cpuBurst +
                ", priority=" + priority +
                ", exitTime=" + exitTime +
                ", turnaroundTime=" + turnaroundTime +
                ", remainingTime=" + remainingTime +
                '}';
    }

    public void setArrivalTime(int exitTime2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setArrivalTime'");
    }
}
