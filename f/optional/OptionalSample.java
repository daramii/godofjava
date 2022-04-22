package f.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalSample {

    public static void main(String[] args) {
        OptionalSample sample = new OptionalSample();
        sample.createOptionalObjects();
        sample.checkOptionalData();
        Optional<String> data = Optional.of("data");
        try {
            sample.getOptionalData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Optional 데이터 넣는법 (객체 생성)
    private void createOptionalObjects() {
        Optional<String> emptyString = Optional.empty();
        String common = null;
        Optional<String> nullableString = Optional.ofNullable(common);
        common = "common";
        Optional<String> commonString = Optional.of(common);
    }

    //Optional 데이터 유무를 체크하는 방법
    private void checkOptionalData() {
        System.out.println(Optional.of("present").isPresent());
        System.out.println(Optional.ofNullable(null).isPresent());
    }

    //Optional 데이터 꺼내는 방법
    private void getOptionalData(Optional<String> data) throws Exception {
        String defaultValue = "default";
        String result1 = data.get();
        String result2 = data.orElse(defaultValue);
        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "GodOfJava";
            }
        };
        String result3 = data.orElseGet(stringSupplier);
        Supplier<Exception> exceptionSupplier = new Supplier<Exception>() {
            @Override
            public Exception get() {
                return new Exception();
            }
        };
        String result4 = data.orElseThrow(exceptionSupplier);
    }
}
