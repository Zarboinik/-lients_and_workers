package sample;

import javax.swing.*;
import java.util.Random;

public class ThreadWorker implements Runnable {
    private Random random = new Random();
    private int timeout;
    private int i = 0;
    private JLabel jLabelWorker;
    private Quest quest;

    public ThreadWorker(JLabel jLabelWorker, Quest quest) {
        this.jLabelWorker = jLabelWorker;
        this.quest = quest;
    }

    @Override
    public void run() {
        while (true) {
            if (quest.getJobs() > 1){
            i++;
            timeout = random.nextInt(2) * 1000 + 1000;
            quest.setJobs(quest.getJobs()-1);
            jLabelWorker.setText(String.valueOf(i));
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }
        }
    }
}
