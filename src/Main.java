import java.io.File;

public class Main {

    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        int subDirTotal = 0;
        int fileTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                subDirTotal++;
            } else {
                fileTotal++;
            }
        }

        int subDirCounter = 0;
        int fileCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                print(files[i], indent, subDirTotal == ++subDirCounter);
            } else {
                System.out.print(indent);
                if (fileTotal == ++fileCounter){
                    System.out.print("└─");
                } else {
                    System.out.print("├─");
                }
                System.out.println(files[i].getName());
            }
        }
    }
}