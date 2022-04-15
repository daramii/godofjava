package e.thread.support;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
        //sample.checkThreadState1();
        sample.checkJoin();

    }
    public void checkThreadState1() {
        SleepThread thread = new SleepThread(2000);
        try {
            System.out.println("thread state=" + thread.getState());
            thread.start();
            System.out.println("thread state(after start)=" + thread.getState());

            Thread.sleep(1000);
            System.out.println("thread state(after 1 sec)=" + thread.getState());

            thread.join(); //메서드가 종료될때까지 기다린다.
            thread.interrupt(); //쓰레드를 중지시킨다.
            System.out.println("thread state(after join) = " + thread.getState());
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void checkJoin() {
        SleepThread thread = new SleepThread(2000); //2초간 대기.
        try{
            thread.start();
            thread.join(500); //0.5초를 대기한다. = 쓰레드가 종료하지 않은 상태다.
            thread.interrupt(); //잠자고 있던 쓰레드가 멈추고, 중지시킨다. InterruptedException 발생. --> interrupt()메소드가 수행되고나서 해당 쓰레드가 중지된다.
            System.out.println("thread state(after join) = " + thread.getState());
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
