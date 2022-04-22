package f.niosecond;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsAndFiles {

    public static void main(String[] args) {
        PathsAndFiles sample = new PathsAndFiles();
        String dir = "C:\\Users\\82107\\git\\godofjava\\f\\niosecond";
        String dir2 = "C:\\WINDOWS";
        //sample.checkPath(dir);
        sample.checkPath2(dir, dir2);
    }

    public void checkPath(String dir) {
        Path path = Paths.get(dir); //FileSystems.getDefault().getPath(first, more) 가 내부적으로 호출됨.
        System.out.println(path.toString());
        System.out.println("getFileName() : " + path.getFileName());
        System.out.println("getNameCount() : " + path.getNameCount());
        System.out.println("getParent() : " + path.getParent());
        System.out.println("getRoot() : " + path.getRoot());
    }

    public void checkPath2(String dir1, String dir2) {
        Path path = Paths.get(dir1);
        Path path2 = Paths.get(dir2);
        Path relativized = path.relativize(path2); //path 에서 path2로 가는 상대경로
        System.out.println("relativized path = " + relativized);
        Path absolute = relativized.toAbsolutePath(); //그 상대경로에서 .. 이거 다 그대로 두고 그 앞에부분에 대해서 절대경로 표시. (절대경로 + 상대경로)
        System.out.println("toAbsolutePath path = " + absolute);
        Path normalized = absolute.normalize(); //경로상에 .나 ..를 다 없앰.
        System.out.println("normalized path = " + normalized);

        Path resolved = path.resolve("godofjava"); //매개변수로 넘어온 문자열을 하나의 경로로 생각한다. 현재 Path의 가장 마지막 path로 추가한다.
        System.out.println("resolved path = " + resolved);
    }
}
