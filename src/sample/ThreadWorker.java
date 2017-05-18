package sample;

import javax.swing.*;
import java.util.Random;

public class ThreadWorker implements Runnable {
    private Random random = new Random();
    private int timeout;
    private int i = 0;
    private JLabel jLabelClient1;
    private JLabel jLabelClient2;
    private JLabel jLabelWorker;

    public ThreadWorker(JLabel jLabelWorker, JLabel jLabelClient1, JLabel jLabelClient2) {
        this.jLabelClient1 = jLabelClient1;
        this.jLabelClient2 = jLabelClient2;
        this.jLabelWorker = jLabelWorker;
    }

    @Override
    public synchronized void run() {
        while (true) {
            i++;
            timeout = random.nextInt(2) * 1000 + 1000;
            if (Integer.parseInt(jLabelClient1.getText()) < 3) {
                jLabelWorker.setText(String.valueOf(i));
                jLabelClient2.setText(String.valueOf(Integer.parseInt(jLabelClient2.getText()) - 1));
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                jLabelWorker.setText(String.valueOf(i));
                jLabelClient1.setText(String.valueOf(Integer.parseInt(jLabelClient1.getText()) - 1));
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
