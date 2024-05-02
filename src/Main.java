import java.io.File;

public class Main {

    public static void main(String[] args) {
        print(new File("src/main/java/org/example/"), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, i == files.length - 1);
            } else {
                System.out.print(indent);
                if (i == files.length - 1) {
                    System.out.println("└─" + files[i].getName());
                } else {
                    System.out.println("├─" + files[i].getName());
                }
            }
        }
    }
    }

