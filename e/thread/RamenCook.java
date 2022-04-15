package e.thread;

class RamenCook implements Runnable {
    private int ramenCount; //라면의 갯수 = 해야할 작업의 갯수라고 생각하자.
    private String[] burners = {"_", "_", "_", "_"}; //버너의 상태를 출력해주기 위함. 4개의 스레드라고 생각

    //라면의 갯수 = 해야할 작업의 갯수를 생성자를 통해 만들어준다.
    public RamenCook(int ramenCount) {
        this.ramenCount = ramenCount;
    }

    @Override
    public void run() {
        //라면(해야할 작업)이 다 덜어질때까지 작업을 진행한다.
        while (ramenCount > 0) {

            //버너 2개가 동시에 라면을 잡을 경우 문제가 발생할 수 있으니,
            //synchronized를 걸어준다.
            synchronized (this) {
                ramenCount--; //버너하나 (스레드 하나가) 라면(해야할 작업)을 집었다.
                //현재 스레드의 이름(버너의 이름)과 남은 라면(해야할 일)의 갯수를 출력해줌.
                System.out.println(Thread.currentThread().getName() + " : " + ramenCount + "개 남음");
            }

            for (int i = 0; i < burners.length; i++) {

                //라면 하나를 집었는데, 버너에 사용중이라고 표시해줘야하니깐 사용중이지 않은 버너를 찾아 표시해준다.
                if(!burners[i].equals("_")) continue;

                //근데 버너를 고를때도, 동시에 고르면 안되니깐 싱크로나이즈드 걸어준다.
                synchronized (this) {
                    burners[i] = Thread.currentThread().getName();
                    System.out.println("                        " + Thread.currentThread().getName() + ": [" + (i+1) + "]번 버너 ON");
                    showBurners(); //현재 버너의 상태를 보여준다.
                }

                //라면을 끓이는 시간을 확보한다.
                try{
                    Thread.sleep(2000);
                } catch(Exception e) {
                    e.printStackTrace();
                }

                //다 끓였으면 버너를 꺼준다.
                synchronized(this) {
                    burners[i] = "_";
                    System.out.println("                        " + Thread.currentThread().getName() + ": [" + (i+1) + "]번 버너 OFF");
                    showBurners(); //현재 버너의 상태를 보여준다.
                }
                break;
            }

            try{
                Thread.sleep(Math.round( 1000 * Math.random()));
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void showBurners() {
        String stringToPrint = "";
        for (int i =0; i<burners.length; i++) {
            stringToPrint += (" " + burners[i]);
        }
        System.out.println(stringToPrint);
    }


}
