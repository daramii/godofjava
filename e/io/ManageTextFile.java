package e.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.io.File.separator;

public class ManageTextFile {

    public static void main(String[] args) {
        ManageTextFile manager = new ManageTextFile();
        int numberCount=10;
        String fullPath = separator+"Users"+separator+"82107"+separator+"git"+separator+"godofjava"+separator+"numbers.txt";
        //manager.writeFile(fullPath, numberCount);
        //manager.readFile(fullPath);
        //manager.readFileWithScanner(fullPath);
        manager.readFileWithFiles(fullPath);
    }

    public void writeFile(String fileName, int numberCount) {
        //Char 기반의 내용을 파일로 쓰기 위한 클래스.
        FileWriter fileWriter = null; // 여기 있는 wirte()나 append() 메소드를 사용하여 데이터를 쓰면, 메소드를 호출했을 떄마다 파일에 쓴다.
        BufferedWriter bufferedWriter = null; // 여기있는 애로 쓰면 버퍼라는 공간에 저장할 데이터를 보관해 두었다가, 버퍼가 차게되면 데이터를 저장한다. 훨씬 효율적이다.
        try{
            //fileWriter = new FileWriter(fileName);
            fileWriter = new FileWriter(fileName, true); //true라고 해주면, 기존파일 내용의 끝에 새로운 내용이 덧붙어서 나온다.
            bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0; i<numberCount; i++) {
                bufferedWriter.write(Integer.toString(i));
                bufferedWriter.newLine(); //줄바꿈을 해준다.
            }
            System.out.println("Write success !!!");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e){
          e.printStackTrace();
        } finally {
            if(bufferedWriter != null) {
                try{
                    bufferedWriter.close();
                }catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }

            if(fileWriter != null) {
                try{
                    fileWriter.close();
                }catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }


    public void readFile(String fileName) {
        //Char 기반의 내용을 파일로 쓰기 위한 클래스.
        FileReader fileReader = null; // 여기 있는 wirte()나 append() 메소드를 사용하여 데이터를 쓰면, 메소드를 호출했을 떄마다 파일에 쓴다.
        BufferedReader bufferedReader = null; // 여기있는 애로 쓰면 버퍼라는 공간에 저장할 데이터를 보관해 두었다가, 버퍼가 차게되면 데이터를 저장한다. 훨씬 효율적이다.
        try{
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String data;
            while ( (data=bufferedReader.readLine()) != null) {
                System.out.println(data);
            }
            System.out.println("Read success !!!");


        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                try{
                    bufferedReader.close();
                }catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }

            if(fileReader != null) {
                try{
                    fileReader.close();
                }catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public void readFileWithScanner(String fileName) {
        File file = new File(fileName);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println("Read success !!!");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }

    public void readFileWithFiles(String fileName) {
        try {
            String data = new String(Files.readAllBytes(Paths.get(fileName)));
            System.out.println(data);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
