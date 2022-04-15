package d.collection.practice;

import java.util.ArrayList;

public class ManageHeight {

    public static void main(String[] args) {
        ManageHeight m = new ManageHeight();
        m.setData();
        for(int i = 1; i <= 5; i++) {
            m.printAverage(i);
        }

    }

    private ArrayList<ArrayList<Integer>> gradeHeights;

    public void setData() {

        gradeHeights = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> class1 = new ArrayList<>();
        class1.add(170);
        class1.add(180);
        class1.add(173);
        class1.add(175);
        class1.add(177);

        gradeHeights.add(class1);

        ArrayList<Integer> class2 = new ArrayList<>();
        class2.add(160);
        class2.add(165);
        class2.add(167);
        class2.add(186);

        gradeHeights.add(class2);

        ArrayList<Integer> class3 = new ArrayList<>();
        class3.add(158);
        class3.add(177);
        class3.add(187);
        class3.add(176);

        gradeHeights.add(class3);

        ArrayList<Integer> class4 = new ArrayList<>();
        class4.add(173);
        class4.add(182);
        class4.add(181);

        gradeHeights.add(class4);

        ArrayList<Integer> class5 = new ArrayList<>();
        class5.add(170);
        class5.add(180);
        class5.add(165);
        class5.add(177);
        class5.add(172);

        gradeHeights.add(class5);

    }

    //반 번호를 매개 변수로 넘겨주면 해당 반 학생들의 키를 번호 순대로 출력
    public void printHeight(int classNo) {

        System.out.println("Class No. : " + classNo);
        ArrayList<Integer> classes = gradeHeights.get(classNo - 1);

        for(int height : classes) {
            System.out.println(height);
        }
    }

    //각 반별 키의 평균을 계산하여 출력
    public void printAverage(int classNo) {
        System.out.println("Class No. : " + classNo);
        ArrayList<Integer> classes = gradeHeights.get(classNo - 1);

        int sum = 0;
        for(int height : classes) {
            sum += height;
        }

        double average = (double)sum / classes.size();

        System.out.println("Height average : " + average);
    }

}
