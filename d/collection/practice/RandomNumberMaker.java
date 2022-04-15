package d.collection.practice;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberMaker {

    public static void main(String[] args) {
        RandomNumberMaker r = new RandomNumberMaker();
        for(int i = 0; i < 10; i ++) {
            HashSet<Integer> result = r.getSixNumber();
            System.out.println(result);
        }
    }

    public HashSet<Integer> getSixNumber() {

        Random random = new Random();
        HashSet<Integer> num = new HashSet<>();
        while(true) {
            int tempNumber = random.nextInt(45);
            num.add(tempNumber);
            if(num.size() == 6) break;
        }
        return num;
    }

}
