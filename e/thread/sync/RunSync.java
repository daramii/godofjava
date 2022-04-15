package e.thread.sync;

public class RunSync {

    public static void main(String[] args) {
        RunSync runSync = new RunSync();
        runSync.runCommonCalculate();

    }

    public void runCommonCalculate() {
        CommonCalculate calc = new CommonCalculate();
        ModifyAmountThread thread1 = new ModifyAmountThread(calc, true);
        ModifyAmountThread thread2 = new ModifyAmountThread(calc, true);

        thread1.start();
        thread2.start();
        try{
            //join()은 쓰레드가 종료될 때 까지 기다리는 메서드.
            thread1.join();
            thread2.join();
            System.out.println("Final value is " + calc.getAmount());
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

}
