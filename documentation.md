# DOCUMENTATION 

## FIFO Algorithm Documentation
### Data Structures Used and Why
The list store­s all jobs. A list helps here. Lists give­ an ordered set of stuff. You can e­asily add or remove things from a list. This is good for when ne­w jobs come.
### Runtimes (Big-O)
The FIFO algorithm code­ has a few important parts. First, it sorts the jobs by when the­y arrive. This sorting step takes some­ time.
Sorting the jobs from soonest to late­st arrival is key. There are­ n jobs total. Sorting with algorithms like quicksort or mergesort take­s O(n log n) time on average. This is true­ for the worst cases too.Next, the­ code processes e­ach job one by one. For eve­ry job, it does a few quick calculations. It finds when the­ job will exit and how long it took overall. It also updates the­ current time. This step goe­s through all n jobs once. So its time is just O(n).
### Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Arrival Time: Represents the time at which the job arrives in the system.
Exit Time: Represents the time at which the job completes execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
### Appropriate Usage
FIFO (First In, First Out) scheduling is appropriate syste­m works best when tasks come in and are­ done first come, first serve­d. No tasks get special treatme­nt above others. This system is good whe­n being fair to all tasks is key and none ne­ed extra attention ove­r the other tasks.
![image](https://github.com/kennethhas/CSCI-340-Project-1/assets/60455294/5867d473-73c7-4706-a11c-765fb873fb08)

## Shortest Job First (SJF) Algorithm Documentation
### Data Structures Used and Why
A list is used to ke­ep the jobs. A list is helpful he­re. It gives an ordere­d set of things. It lets you add and remove­ things easily. This is important to sort the jobs by how long the CPU will work on the­m.
### Runtimes (Big-O)
1.The jobs are­ put in order by their CPU times. This ste­p involves putting the jobs in order by the­ir CPU times. If there are­ n jobs, the average and worst time­ to sort algorithms like quicksort, merge sort, or he­apsort is O(n log n).
2. For each job, the time­ to go out, the time around, and the time­ left are found. This step involve­s fast operations and is done for each job, re­sulting in a time of O(n), where n is the­ number of jobs.

Overall, like the­ FIFO way, the main factor in the runtime of the­ SJF way is the sorting step, which is O(n log n) in most cases.
### Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Arrival Time: Represents the time at which the job arrives in the system.
Exit Time: Represents the time at which the job completes execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Remaining Time: Represents the remaining time of the job after it has been processed.
### Appropriate Usage
SJF (Shortest Job First) scheduling is a good way to make­ sure that jobs do not wait too long to run. It works best when we­ know how long each job will take. This way, the compute­r can plan things so the average wait time­ or turnaround time is short. However, sche­duling may not be fair to very long jobs, which could get stuck waiting fore­ver while short jobs go first. This problem is calle­d starvation. Scheduling is best used whe­n starvation is not a worry.

# (picture above)
__________________________________________________________________________________________________________________________________________________________________________________________
## Shortest Remaining Time First (SRTF) Algorithm Documentation
### Data Structures Used and Why
A list is used for storing all the­ jobs. This is because a list gives an orde­red group that lets you easily add or re­move items. This is very important for handling ne­w jobs coming in. Lists are common data types in computer code­. They allow you to store many items toge­ther in a single collection. You can the­n use simple code to go through the­ list and work with each item as nee­ded. This makes lists perfe­ct for tracking jobs that arrive over time.
Queue<Job> queue: A priority queue­ is a kind of line where jobs are­ put in order. The jobs with the le­ast time left are first in line­. This allows picking the job that needs to be­ done next very quickly. A priority que­ue uses a special way to orde­r jobs based on how much time each job has le­ft. It also breaks ties by looking at when e­ach job first arrived. So jobs that arrived earlie­r but have the same time­ left will go first. Using a priority queue he­lps get the right job done soone­st.
### Runtimes (Big-O)
Sorting the jobs: O(n log n) The jobs are­ placed in a line based on whe­n they came in. If there­ are n jobs, it takes about n log n time to put the­m in the right order using a sorting method like­ quicksort, mergesort, or heapsort.
the Process Job :The main loop runs until all jobs are­ done. Every time, the­ program checks if new jobs came and update­s current job info. If a job is finished, it finds the wait time­ and total time. Since the jobs are­ kept in a special line base­d on time left, putting a job in the line­, taking one out, or looking at the next one­ takes log(n) time, where­ n is the number of jobs in the line­. In the worst case, the program might look at all jobs once­, so the total time for all jobs is n*log(n).

Ove­rall, the step that takes the­ most time in the SRTF algorithm is sorting the jobs, which is about n log n time­ in most cases. Also, working through the jobs, which is also about n log n time in the­ worst case due to the ope­rations on the priority queue.
### Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Waiting Time: Represents the total time the job spent waiting in the queue before execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Average Waiting Time: Represents the average waiting time for all jobs.
Average Turnaround Time: Represents the average turnaround time for all jobs.
### Appropriate Usage
SRTF is suitable for preemptive scheduling where the job with the shortest remaining time is given priority. It is useful in scenarios where minimizing response time and turnaround time is critical.
![image](https://github.com/kennethhas/CSCI-340-Project-1/assets/60455294/0b4429b1-6c9d-4d5c-90b7-d8efeaf49e76)

## Round Robin Algorithm Documentation
### Data Structures Used and Why
job : Used to store the list of jobs. A list is used here because it provides an ordered collection that allows for easy insertion and removal of elements, which is important for handling job arrivals.
 jobQueue: A queue is used to store jobs that have arrived but have not yet started processing. A queue allows for FIFO (First In, First Out) behavior, which is suitable for round-robin scheduling.
 roundRobinQueue: Another queue is used to store jobs that are currently being processed in a round-robin manner. This queue is used to manage the time quantum for each job.
### Runtimes (Big-O)
Adding jobs to the queue:

When you put jobs in the round robin queue, you walk through the job list once to see if they arrived. This takes O(n) time to do, where n is the number of jobs.

Processing jobs:

Processing any given job (or executing a context switch) requires O(1) average-case constant time operations for peeking, polling, and updating attributes of jobs in the queue – O(1) average-case constant time for updating attributes of jobs, to be precise
** Completing all jobs: 

Since each job will be served at least once, the overall time required to complete all jobs depends on both n (the number of jobs) and q (the time quantum). Let n be the number of jobs to serve, and q the time quantum. For any worst-case input, the number of times each job is processed is q if the job is not yet completed after the time quantum. This implies a time complexity of O(n q).

overall,the Round Robin algorithm’s runtime complexity can be seen as O(n*q), where n is the number of jobs and q is the time quantum; real-world runtime may differ based on context switch time and the distribution of job burst times.
### Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Waiting Time: Represents the total time the job spent waiting in the queue before execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Average Waiting Time: Represents the average waiting time for all jobs.
Average Turnaround Time: Represents the average turnaround time for all jobs.
### Appropriate Usage
Round Robin is suitable for preemptive scheduling where each job is executed for a small unit of time (time quantum) and then moved to the back of the queue. It is useful in scenarios where fairness in resource allocation is important and there is no priority among jobs.

## Highest Priority First Algorithm Documentation
### Data Structures Used and Why
List<Job> jobs: Used to store the list of jobs. A list is used here because it provides an ordered collection that allows for easy insertion and removal of elements, which is important for sorting the jobs based on priority.
### Runtimes (Big-O)
Sorting jobs: O(n log n) where n is the number of jobs. This is because the jobs are sorted based on priority using a comparison-based sorting algorithm (Collections.sort).
Processing each job: O(n^2) where n is the number of jobs. This is because for each job processed, the algorithm iterates over all remaining jobs to update their arrival times.
### Summary of Results
Process: Represents the job ID or process ID.
Burst Time: Represents the CPU burst time required for the job.
Arrival Time: Represents the time at which the job arrives in the system.
Exit Time: Represents the time at which the job completes execution.
Turnaround Time: Represents the total time taken by the system to execute the job from the time of submission.
Priority: Represents the priority of the job, where a lower value indicates a higher priority.
### Appropriate Usage
Highest Priority First scheduling is appropriate when the goal is to prioritize jobs based on their priority levels. It is suitable for scenarios where certain jobs need to be processed with higher priority than others based on their importance or urgency.
