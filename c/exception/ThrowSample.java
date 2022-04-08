package c.exception;

public class ThrowSample {

    public static void main(String[] args) {
        ThrowSample sample = new ThrowSample();
        try {
            sample.throwsException(13);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sample.throwException(13);
    }


    public void throwException(int number){
        try{
            //12보다 숫자가 크면 예외를 발생시킨다.
            if(number > 12) throw new Exception("Number is over than 12");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //메소드 끝에 throws Exception을 선언하면, 예외가 발생 안한 경우에는
    //호출한 곳으로 다시 예외를 던진다.
    //이런경우 반드시 호출한 곳은 try catch로 감싸야한다.
    public void throwsException(int number) throws Exception{
        try{
            //12보다 숫자가 크면 예외를 발생시킨다.
            if(number > 12) throw new Exception("Number is over than 12");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
