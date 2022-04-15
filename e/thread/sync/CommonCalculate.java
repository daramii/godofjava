package e.thread.sync;

public class CommonCalculate {
    private int amount;
    private int interest;
    private Object interestLock = new Object();
    private Object amountLock = new Object();

    public CommonCalculate() {
        amount=0;
    }
    public void addInterest(int value) {
        synchronized (interestLock) {
            interest += value;
        }
    }

    //public synchronized void plus(int value) {
    public void plus(int value) {
        synchronized (amountLock) { //이 선언 이후로부터만 동시에 여러 쓰레드에서 처리하지 않겠다.
            amount += value;
        }
    }
    //public synchronized void minus(int value) {
    public void minus(int value) {
        synchronized (amountLock) { //이 선언 이후로부터만 동시에 여러 쓰레드에서 처리하지 않겠다.
            amount = +value;
        }
    }
    public int getAmount() {
        return amount;
    }
}
