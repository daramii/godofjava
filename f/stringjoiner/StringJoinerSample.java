package f.stringjoiner;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerSample {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String[] stringArray = new String[]{"StudyHard","GodOfJava","Book"};
        for(String str : stringArray) {
            builder.append(str);
            builder.append(", ");
        }
        System.out.println("(" + builder + ")"); //이렇게 하면 끝에 , 를 다시 또 처리해줘야한다.

        StringJoinerSample sample = new StringJoinerSample();
        sample.joinStringOnlyComma(stringArray);
        sample.joinString(stringArray);
        sample.withCollector(stringArray);

    }
    //그래서 StringJoiner가 탄생함요 :)
    public void joinStringOnlyComma(String[] stringArray) {
        StringJoiner joiner = new StringJoiner(",");
        for(String string:stringArray) {
            joiner.add(string);
        }
        System.out.println("(" + joiner + ")"); //여기서는 이렇게 또 앞뒤로 소괄호를 넣어줘야한다.
    }

    //앞뒤 소괄호까지 넣는 방법이 있다.
    public void joinString(String[] stringArray) {
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for(String string:stringArray) {
            joiner.add(string);
        }
        System.out.println(joiner); //여기서는 이렇게 또 앞뒤로 소괄호를 넣어줘야한다.
    }

    //stream과 lamda 표현식을 사용하면 이렇게도 작성할 수 있다.
    //Collectors라는 클래스의 joining 메소드를 사용하면 이와 같이 간단한 코드로 정리가능
    public void withCollector(String[] stringArray) {
        List<String> stringList = Arrays.asList(stringArray);
        String result = stringList.stream().collect(Collectors.joining(","));
        System.out.println(result);
    }

}
