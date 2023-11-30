import java.io.File;

public class ExploreDirectory {

    public static void main(String[] args) {
        // Check if the correct number of command line arguments is provided
        if (args.length != 1) {
            System.out.println("Please enter one directory as an arguement");
            System.exit(-1);
        }

        String folderPath = args[0];

        // Create the root node for the tree
        MyTreeNode<String> root = createNode(folderPath, null);

        // Print the contents of the directory tree
        root.print();
    }

    private static MyTreeNode<String> createNode(String filename, MyTreeNode<String> parent) {
        File file = new File(filename);
        MyTreeNode<String> node;
        // MyTreeNode<String> node = new MyTreeNode<>(file.getName(), parent);
        if(parent != null){
            node = parent.addChild(filename);
        }
        else{
            node = new MyTreeNode<>(file.getName());
        }
        if (file.isDirectory()) {
            // If it's a directory, get the list of subfolders and files
            File[] files = file.listFiles();
            if (files != null) {
                // Recursively create nodes for each subfolder or file
                for (File child : files) {
                    MyTreeNode<String> childNode = createNode(child.getPath(), node);
                    node.addChild(childNode.getItem());
                }
            }
        }

        return node;
    }
}