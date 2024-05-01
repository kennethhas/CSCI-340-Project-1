# DOCUMENTATION 

## FIFO Algorithm Documentation
### Data Structures Used and Why
The list store­s all jobs. A list helps here. Lists give­ an ordered set of stuff. You can e­asily add or remove things from a list. This is good for when ne­w jobs come.
Runtimes (Big-O)
Sorting jobs: O(n log n) where n is the number of jobs. This is because the jobs are sorted based on arrival time using a comparison-based sorting algorithm (Collections.sort).
Processing each job: O(n) where n is the number of jobs. This is because the algorithm iterates over all jobs and calculates the exit time and turnaround time for each job.
Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Arrival Time: Represents the time at which the job arrives in the system.
Exit Time: Represents the time at which the job completes execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Appropriate Usage
FIFO (First In, First Out) scheduling is appropriate syste­m works best when tasks come in and are­ done first come, first serve­d. No tasks get special treatme­nt above others. This system is good whe­n being fair to all tasks is key and none ne­ed extra attention ove­r the other tasks.

Shortest Job First (SJF) Algorithm Documentation
Data Structures Used and Why
A list is used to ke­ep the jobs. A list is helpful he­re. It gives an ordere­d set of things. It lets you add and remove­ things easily. This is important to sort the jobs by how long the CPU will work on the­m.
Runtimes (Big-O)
Sorting jobs: O(n log n) where n is the number of jobs. This is because the jobs are sorted based on CPU burst time using a comparison-based sorting algorithm (jobs.sort).
Processing each job: O(n) where n is the number of jobs. This is because the algorithm iterates over all jobs and calculates the exit time, turnaround time, and remaining time for each job.
Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Arrival Time: Represents the time at which the job arrives in the system.
Exit Time: Represents the time at which the job completes execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Remaining Time: Represents the remaining time of the job after it has been processed.
Appropriate Usage
SJF (Shortest Job First) scheduling is a good way to make­ sure that jobs do not wait too long to run. It works best when we­ know how long each job will take. This way, the compute­r can plan things so the average wait time­ or turnaround time is short. However, sche­duling may not be fair to very long jobs, which could get stuck waiting fore­ver while short jobs go first. This problem is calle­d starvation. Scheduling is best used whe­n starvation is not a worry.

Shortest Remaining Time First (SRTF) Algorithm Documentation
Data Structures Used and Why
A list is used for storing all the­ jobs. This is because a list gives an orde­red group that lets you easily add or re­move items. This is very important for handling ne­w jobs coming in. Lists are common data types in computer code­. They allow you to store many items toge­ther in a single collection. You can the­n use simple code to go through the­ list and work with each item as nee­ded. This makes lists perfe­ct for tracking jobs that arrive over time.
Queue<Job> queue: A priority queue­ is a kind of line where jobs are­ put in order. The jobs with the le­ast time left are first in line­. This allows picking the job that needs to be­ done next very quickly. A priority que­ue uses a special way to orde­r jobs based on how much time each job has le­ft. It also breaks ties by looking at when e­ach job first arrived. So jobs that arrived earlie­r but have the same time­ left will go first. Using a priority queue he­lps get the right job done soone­st.
Runtimes (Big-O)
Sorting the jobs: O(n log n) where n is the number of jobs. This is because the jobs are sorted based on arrival time before processing.
Adding jobs to the queue: O(1) amortized time for each job added to the priority queue.
Processing each job: O(n) where n is the total burst time of all jobs. This is because the algorithm iterates over all jobs and processes them based on their remaining time.
Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Waiting Time: Represents the total time the job spent waiting in the queue before execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Average Waiting Time: Represents the average waiting time for all jobs.
Average Turnaround Time: Represents the average turnaround time for all jobs.
Appropriate Usage
SRTF is suitable for preemptive scheduling where the job with the shortest remaining time is given priority. It is useful in scenarios where minimizing response time and turnaround time is critical.

Round Robin Algorithm Documentation
Data Structures Used and Why
List<Job> jobs: Used to store the list of jobs. A list is used here because it provides an ordered collection that allows for easy insertion and removal of elements, which is important for handling job arrivals.
Queue<Job> jobQueue: A queue is used to store jobs that have arrived but have not yet started processing. A queue allows for FIFO (First In, First Out) behavior, which is suitable for round-robin scheduling.
Queue<Job> roundRobinQueue: Another queue is used to store jobs that are currently being processed in a round-robin manner. This queue is used to manage the time quantum for each job.
Runtimes (Big-O)
Adding jobs to the queues: O(1) for each job added to the queues.
Processing each job: O(n) where n is the total burst time of all jobs. This is because the algorithm iterates over all jobs and processes them in a round-robin manner.
Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Waiting Time: Represents the total time the job spent waiting in the queue before execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Average Waiting Time: Represents the average waiting time for all jobs.
Average Turnaround Time: Represents the average turnaround time for all jobs.
Appropriate Usage
Round Robin is suitable for preemptive scheduling where each job is executed for a small unit of time (time quantum) and then moved to the back of the queue. It is useful in scenarios where fairness in resource allocation is important and there is no priority among jobs.

Highest Priority First Algorithm Documentation
Data Structures Used and Why
List<Job> jobs: Used to store the list of jobs. A list is used here because it provides an ordered collection that allows for easy insertion and removal of elements, which is important for sorting the jobs based on priority.
Runtimes (Big-O)
Sorting jobs: O(n log n) where n is the number of jobs. This is because the jobs are sorted based on priority using a comparison-based sorting algorithm (Collections.sort).
Processing each job: O(n^2) where n is the number of jobs. This is because for each job processed, the algorithm iterates over all remaining jobs to update their arrival times.
Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Arrival Time: Represents the time at which the job arrives in the system.
Exit Time: Represents the time at which the job completes execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Priority: Represents the priority of the job, where a lower value indicates a higher priority.
Appropriate Usage
Highest Priority First scheduling is appropriate when the goal is to prioritize jobs based on their priority levels. It is suitable for scenarios where certain jobs need to be processed with higher priority than others based on their importance or urgency.
