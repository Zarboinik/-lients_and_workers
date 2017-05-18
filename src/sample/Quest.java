package sample;

import javax.swing.*;

public class Quest implements Runnable {
    private int jobs;
    private JLabel jLabel;

    public int getJobs() {
        return jobs;
    }

    public Quest(JLabel jLabel) {
        this.jLabel = jLabel;
        this.jobs = 0;
    }

    public void setJobs(int jobs) {
        this.jobs = jobs;
    }


    @Override
    public void run() {
        while (true) {
            jLabel.setText(String.valueOf(getJobs()));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
