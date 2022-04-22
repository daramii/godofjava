package f.forkjoin;

import java.util.concurrent.RecursiveTask;

public class GetSum extends RecursiveTask<Long> {
    long from, to;

    public GetSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long compute() {
        long gap = to-from;

        if(gap<=3) {
            long tempSum = 0;
            for(long i = from; i<=to; i++) {
                tempSum += i;
            }
            return tempSum;
        }

        long middle = (from+to) / 2 ; //중간을 찾는다.
        GetSum sumPre = new GetSum(from, middle); //처음부터 중간 값으로 설정, 작업 수행을 위한 두 개의 객체를 생성
        sumPre.fork(); //하나의 작업 수행
        GetSum sumPost = new GetSum(middle+1, to); //중간다음부터 끝 값으로 설정, 작업 수행을 위한 두 개의 객체를 생성
        return sumPost.compute() + sumPre.join(); //sumPost.compute()라는 또다른 작업을 수행한후, sumPre.join()으로 조금전에 했던 sumPre.fork() 작업을 기다린다.

    }
}
