package f.forkjoin;

import java.util.concurrent.RecursiveTask;

public class GetSum2 extends RecursiveTask<Long> {
    long from, to;

    public GetSum2(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long compute() {
        long gap = to-from;
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log("From = " + from + " To = " + to);

        if(gap<=3) {
            long tempSum = 0;
            for(long i = from; i<=to; i++) {
                tempSum += i;
            }
            log("Return !! " + from + " ~ " + to + " = " + tempSum);
            return tempSum;
        }

        long middle = (from+to) / 2 ; //중간을 찾는다.
        GetSum2 sumPre = new GetSum2(from, middle); //처음부터 중간 값으로 설정, 작업 수행을 위한 두 개의 객체를 생성
        log("Pre     From = " + from + " To = " + middle);
        sumPre.fork(); //하나의 작업 수행
        GetSum2 sumPost = new GetSum2(middle+1, to); //중간다음부터 끝 값으로 설정, 작업 수행을 위한 두 개의 객체를 생성
        log("Post     From = " + (middle+1) + " To = " + to);
        return sumPost.compute() + sumPre.join(); //sumPost.compute()라는 또다른 작업을 수행한후, sumPre.join()으로 조금전에 했던 sumPre.fork() 작업을 기다린다.

    }

    public void log(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] " + message);
    }
}
