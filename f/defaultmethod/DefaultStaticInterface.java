package f.defaultmethod;

public interface DefaultStaticInterface {
    static final String name = "GodOfJavaBook";
    static final int since = 2013;
    String getName();
    int getSince();

    //Java8 부터 추가된 부분
    default String getEMail() {
        return name + "@godogjava.com";
    }
}
