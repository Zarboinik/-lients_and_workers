package sample;

import javax.swing.*;
import java.util.Random;

public class ThreadClient implements Runnable {
    private Random random = new Random();
    private int timeout;
    private int n = 0;
    private JLabel jLabel;
    private JobList jobList;

    public ThreadClient(JLabel jLabel, JobList jobList) {
        this.jLabel = jLabel;
        this.jobList = jobList;
    }

    @Override
    public void run() {
        while (true){
            timeout = random.nextInt(2) * 1000 + 1000;
            jLabel.setText(String.valueOf(n++));
            jobList.setJobs(new Job());
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
