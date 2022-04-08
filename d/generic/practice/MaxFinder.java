package d.generic.practice;

public class MaxFinder {

    public static void main(String[] args) {
        MaxFinder max = new MaxFinder();
        max.testGetMax();
    }

    public void testGetMax() {
        System.out.println(getMax(1,2,3));
        System.out.println(getMax(3,1,2));
        System.out.println(getMax(2,3,1));
        System.out.println(getMax("a","b","c"));
        System.out.println(getMax("b","c","b"));
        System.out.println(getMax("a","b","c"));

        System.out.println(getMin(1,2,3));
        System.out.println(getMin(3,1,2));
        System.out.println(getMin(2,3,1));
        System.out.println(getMin("a","b","c"));
        System.out.println(getMin("b","c","b"));
        System.out.println(getMin("a","b","c"));

    }

    public <T extends Comparable<T>> T getMax(T ... a) {
        T maxT = a[0];
        for(T tempT : a) {
            if(tempT.compareTo(maxT) > 0) maxT = tempT;
        }
        return maxT;
    }

    public <T extends Comparable<T>> T getMin(T ... a) {
        T minT = a[0];
        for(T tempT : a) {
            if(tempT.compareTo(minT) < 0) minT = tempT;
        }
        return minT;
    }
}
