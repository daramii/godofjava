package e.thread;

import java.util.StringTokenizer;

public class RamenProgram {

    public static void main(String[] args) {
        try{
            RamenCook ramenCook = new RamenCook(50);
            new Thread(ramenCook, "A").start();
            new Thread(ramenCook, "B").start();
            new Thread(ramenCook, "C").start();
            new Thread(ramenCook, "D").start();
        }catch(Exception e) {
            e.printStackTrace();
        }


    }
}
