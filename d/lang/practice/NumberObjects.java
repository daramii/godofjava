package d.lang.practice;

public class NumberObjects {

    public static void main(String[] args) {
        NumberObjects n = new NumberObjects();
        n.parseLong("r1024");
        n.printOtherBase(1024);
    }


    //문자열을 받아 long타입으로 변환하여 리턴.
    public long parseLong(String data) throws NumberFormatException{
        long result = -1;

        try{
            result = Long.parseLong(data);
            System.out.println(result);

        }catch(NumberFormatException e) {

            System.out.println(data + " is not a number.");

        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void printOtherBase(long value) {

        String binary = Long.toBinaryString(value);
        String hex = Long.toHexString(value);
        String octal = Long.toOctalString(value);

        System.out.println("Original : " + value);
        System.out.println("Binary : " + binary);
        System.out.println("Hex : " + hex);
        System.out.println("Octal : " + octal);
    }

}
