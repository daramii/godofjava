package f.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample2 {

    static final ForkJoinPool mainPool = new ForkJoinPool(); //ForkJoinPool이라는 클래스의 객체를 생성한다.

    public static void main(String[] args) {
        ForkJoinSample2 sample = new ForkJoinSample2();
        sample.calculate();
    }

    public void calculate() {
        long from = 0;
        long to = 10;

        GetSum2 sum = new GetSum2(from, to); //계산을 수행할 객체를 만든다.
        Long result = mainPool.invoke(sum); //ForkJoinPool에 선언되어 있는 invoke()라는 메소드를 사용하여 계산을 수행하는 객체를 넘겨주면, 작업이 시작된다. 그리고 그 결과를 받는다.
        System.out.println("Fork Join : Total sum of " + from + " ~ " + "to" + " = " + result);
    }


}
