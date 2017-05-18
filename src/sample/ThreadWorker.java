package sample;

import javax.swing.*;

public class ThreadWorker implements Runnable {
    private int i;
    private JLabel jLabelWorker;
    private JLabel jLabelJobs;
    private JobList jobList;

    public ThreadWorker(JLabel jLabelWorker,JLabel jLabelJobs, JobList jobList) {
        this.jLabelWorker = jLabelWorker;
        this.jLabelJobs = jLabelJobs;
        this.jobList = jobList;
    }

    @Override
    public void run() {
        while (true) {
            Job job = jobList.getJob();
            if (job != null) {
                job.doJob();
                jLabelWorker.setText(String.valueOf(i++));
                jLabelJobs.setText(String.valueOf(jobList.allJobs()));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}
