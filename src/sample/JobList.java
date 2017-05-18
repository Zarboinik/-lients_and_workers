package sample;

import java.util.ArrayList;

public class JobList {
    private ArrayList <Job> jobs = new ArrayList();

    public synchronized Job getJob() {
        if (!this.jobs.isEmpty()) {
            Job job = this.jobs.get(0);
            this.jobs.remove(job);
            return job;
        }else {return null;}
    }

    public synchronized int allJobs(){
        return jobs.size();
    }

    public synchronized void setJobs(Job job) {
        this.jobs.add(job);
    }

    public JobList() {
    }
}
