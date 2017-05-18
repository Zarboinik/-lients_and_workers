package sample;

import javax.swing.*;

public class Main{

    public static void main(String[] args) {
        NewJFrame newJFrame = new NewJFrame();
        newJFrame.setVisible(true);
        JLabel jLabelQest = newJFrame.getjLabel5();
        Quest quest = new Quest(jLabelQest);
        Thread t0 = new Thread(quest);
        t0.start();
        JLabel jLabelClient1 = newJFrame.getjLabel1();
        Thread t1 = new Thread(new ThreadClient(jLabelClient1,quest));
        t1.start();
        JLabel jLabelClient2 = newJFrame.getjLabel2();
        Thread t2 = new Thread(new ThreadClient(jLabelClient2,quest));
        t2.start();
        JLabel jLabelWorker1 = newJFrame.getjLabel3();
        Thread t3 = new Thread(new ThreadWorker(jLabelWorker1, quest));
        t3.start();
        JLabel jLabelWorker2 = newJFrame.getjLabel4();
        Thread t4 = new Thread(new ThreadWorker(jLabelWorker2, quest));
        t4.start();
    }
}
