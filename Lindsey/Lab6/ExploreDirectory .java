import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class ExploreDirectory {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one dictionary as an arguement.");
            System.exit(-1);
        }

        String directoryPath = args[0];
        Path rootPath = Paths.get(directoryPath);

        if (!Files.exists(rootPath) || !Files.isDirectory(rootPath)) {
            System.out.println("Invalid directory path.");
            System.exit(-1);
        }

        MyTreeNode<String> root = createNode(rootPath.getFileName().toString(), null);

        // Print the contents of the directory
        root.print();
    }

    private static MyTreeNode<String> createNode(String filename, MyTreeNode<String> parent) {
        MyTreeNode<String> newNode = new MyTreeNode<>(filename, parent);

        if (Files.isDirectory(Paths.get(filename))) {
            try (Stream<Path> paths = Files.walk(Paths.get(filename), 1)) {
                paths.filter(Files::isDirectory)
                        .forEach(path -> createNode(path.getFileName().toString(), newNode));

                paths.filter(Files::isRegularFile)
                        .forEach(path -> newNode.addChild(path.getFileName().toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return newNode;
    }
}