import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class SelectFile {


    //Select the text file
    public static File selectFile() {

        File file = null;
        boolean flag = false;

        while (!flag) {

            JFileChooser selectedFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = selectedFile.showOpenDialog(null);
            if (returnValue != JFileChooser.APPROVE_OPTION)
                return null;
            else {
                file = selectedFile.getSelectedFile();
                int dotIndex = file.getName().lastIndexOf('.');
                String fileType =file.getName().substring(dotIndex + 1);
                if (!fileType.equals("txt")) {
                    System.out.println("You chose the wrong file type! Please choose another one.");
                }
                else flag=true;

            }
        }
        return file;
    }
}