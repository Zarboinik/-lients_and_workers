package sample;

import java.util.Random;

public class Job {
    Random random = new Random();
    public Job() {
    }

    public void doJob(){
        try {
            Thread.sleep(random.nextInt(10)*50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
