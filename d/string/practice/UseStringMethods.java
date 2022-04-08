package d.string.practice;

public class UseStringMethods {

    public static void main(String[] args) {
        String words = "The String class represents character strings.";
        UseStringMethods usm = new UseStringMethods();
        String[] str = words.split(" ");
        for(String s : str) {
            usm.printWords(s);
        }
        usm.findString(words,"string");
        usm.findAnyCaseString(words,"string");
        usm.countChar(words,'s');
        usm.printContainWords(words,"ss");

    }

    public void printWords(String str) {
        System.out.println(str);
    }

    public void findString(String str, String findStr) {
        //str중에서 findStr과 동일한 단어의 첫번째 위치를 출력해라.
        int firstLocation = str.indexOf(findStr);
        if(firstLocation != -1) System.out.println("string is appeared at " + firstLocation);
    }

    public void findAnyCaseString(String str, String findStr) {
        //str중에서 findStr과 "대소문자 구분 없이" 동일한 단어의 첫번째 위치를 출력해라.
        int firstLocation = str.toLowerCase().indexOf(findStr.toLowerCase());
        System.out.println("string is appeared at " + firstLocation);
    }

    public void countChar(String str, char c) {
        int count = 0;
        //str에서 c와 동일한 char의 갯수를 출력해라.
        char[] chars = str.toCharArray();
        for(char oneChar : chars) {
            if(oneChar == c) {
                count++;
            }
        }
        System.out.println("char 's' count is " + count);
    }

    public void printContainWords(String str, String findStr) {
        //str문자열에서 findStr이 포함된 단어를 출력해라.
        String[] strings = str.split(" ");
        for(String s : strings) {
            if(s.contains(findStr)) System.out.println(s + " contains ss");
        }
    }

}
