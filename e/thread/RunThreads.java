package e.thread;

public class RunThreads {
    public static void main(String[] args) {
        RunThreads threads = new RunThreads();
        threads.runBasic();
    }

    public void runBasic() {
        //Runnable 인터페이스를 구현한 RunnableSample 클래스를 쓰레드로 바로 시작할 수는 없다.
        //따라서, 이와 같이 Thread 클래스의 생성자에 해당 객체를 추가하여 시작해주어야만 한다.
        RunnableSample runnable = new RunnableSample();
        new Thread(runnable).start();

        //Thread 클래스를 상속받은 ThreadSample 클래스는 객체에 바로 start() 메소드를 호출하였다.
        ThreadSample thread = new ThreadSample();
        thread.start();
        System.out.println("RunThreads.runBasic() method is ended.");
    }
}
