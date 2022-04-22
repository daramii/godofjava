package f.niosecond;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilesManager {

    public static void main(String[] args) {
        FilesManager sample = new FilesManager();
        String fileName = "AboutThisBook.txt";
        Path fromPath = sample.writeAndRead(fileName);
        sample.copyMoveDelete(fromPath, fileName);
    }

    //컨텐츠 작성 메소드
    public List<String> getContents() {
        List<String> contents = new ArrayList<>();
        contents.add("가나다라마바사아자차카다파하");
        contents.add("가나다라마바사아자차카다파하");
        contents.add("가나다라마바사아자차카다파하");
        contents.add("가나다라마바사아자차카다파하");
        contents.add("Current Date = " + new Date());
        return contents;
    }

    //작성한 컨텐츠를 파일로 저장하는 메소드
    //Path 객체를 매개 변수로 받아서 해당 경로의 파일에 데이터를 저장한다.
    public Path writeFile(Path path) throws Exception {
        Charset charset = Charset.forName("UTF-8"); //저장되는 문자열 캐릭터 셋을 지정한다. 한글 데이터를 제공하기 때문에, 한글 타입으로 "EUC-KR"로 저장했다.
        List<String> contents = getContents();
        StandardOpenOption openOption = StandardOpenOption.CREATE; //파일을 열때 설정하는 옵션이다. CREATE는 파일이 존재하지 않으면, 새로 생성할때 사용한다.
        return Files.write(path, contents, charset, openOption);
    }

    //파일 읽기
    public void readFile(Path path) throws Exception {
        Charset charset = Charset.forName("UTF-8");
        System.out.println("Path = " + path);
        List<String> fileContents = Files.readAllLines(path, charset);
        for(String tempContents : fileContents) {
            System.out.println(tempContents);
        }
        System.out.println();
    }


    public Path writeAndRead(String fileName) {
        Path returnPath = null;
        try{
            Path path = Paths.get(fileName);
            //Write a text file
            returnPath = writeFile(path);
            //Read written file
            System.out.println("********* Created file contents ************");
            readFile(returnPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnPath;
    }


    //파일 삭제하기
    public void copyMoveDelete(Path fromPath, String fileName) {
        try{
            //writeAndRead() 메소드 결과 Path 객체를 받는다.
            //그리고, 그 경로는 상대 경로로 되어 있으므로, 절대 경로로 변경하는 toAbsolutePath()메소드를 호출했다.
            //그 다음 getParent()메소드를 호출하여 파일 명의 앞 단계인 경로 정보를 받게 된다.
            Path toPath = fromPath.toAbsolutePath().getParent();

            //Make a directory if it is not exist.
            //부모 경로가 저장되어있는 Path 객체에 resolve() 메소드를 사용하여 "copied" 라는 새로운 경로를 만들었다.
            Path copyPath = toPath.resolve("copied");
            //copied라는 경로가 존재하지 않는 경우에는 createDirectories()라는 메소드를 사용해, 디렉터리를 생성한다.
            if(!Files.exists(copyPath)) {
                Files.createDirectories(copyPath);
            }

            //Copy file
            //복사를 위해 copiedFilePath라는 객체를 생성했고, StandardCopyOption 객체를 생성해 복사할때 옵션을 지정해준다.
            Path copiedFilePath = copyPath.resolve(fileName);
            StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING; //기존파일이 있으면 새 파일로 변경
            Files.copy(fromPath, copiedFilePath, copyOption);

            //Read copied file
            System.out.println("************ Copied file contents **********");
            readFile(copiedFilePath);

            //Move file
            Path movedFilePath = Files.move(copiedFilePath, copyPath.resolve("moved.txt"), copyOption);

            //Delete files
            Files.delete(movedFilePath);
            Files.delete(copyPath);


        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
