package sample;

import javax.swing.*;
import java.util.Random;

public class ThreadClient implements Runnable {
    private Random random = new Random();
    private int timeout;
    private int n = 0;
    private JLabel jLabel;
    private Quest quest;

    public ThreadClient(JLabel jLabel, Quest quest) {
        this.jLabel = jLabel;
        this.quest = quest;
    }

    @Override
    public void run() {
        while (true){
            timeout = random.nextInt(2) * 1000 + 1000;
            jLabel.setText(String.valueOf(n++));
            quest.setJobs(quest.getJobs()+1);
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
