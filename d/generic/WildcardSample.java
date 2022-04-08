package d.generic;

public class WildcardSample {

    public static void main(String[] args) {
        WildcardSample sample = new WildcardSample();
        sample.callWildcardMethod();
    }

    public void callWildcardMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard);
    }

    public void wildcardStringMethod(WildcardGeneric<?> c) {
        Object value = c.getWildcard();
        if(value instanceof String) System.out.println(value);
    }
}
