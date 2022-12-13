import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PngToWebp{
  public static void main(String[] args) {

    //usar metodo resizePng() da classe ImageResizer
    ImageResizer imageResizer = new ImageResizer();
    try {
      imageResizer.resize();
    } catch (Exception e) {
      e.printStackTrace();
    }

    //usar metodo deletePng
    try {
      imageResizer.deletePng();
    } catch (Exception e) {
      e.printStackTrace();
    }


    // Set the source and destination folders
    String sourceFolder = "C:\\Users\\yoshi\\Desktop\\lovtokimages";
    String destinationFolder = "C:\\Users\\yoshi\\Desktop\\lovtokimages";

    // Get a list of all the files in the source folder
    File sourceFolderFile = new File(sourceFolder);
    File[] files = sourceFolderFile.listFiles();

    // Loop through the files in the source folder
    for (File file : files) {
      // Check if the file is a .png image
      if (file.getName().endsWith(".png")) {
        // Create the path for the source and destination files
        Path sourcePath = Paths.get(file.getAbsolutePath());
        Path destPath = Paths.get(destinationFolder + "\\" + file.getName().replace(".png", ".webp"));

        // Replace the .png image with a .webp image
        try {
          Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    //transformar arquivos .jpeg em .webp
    for (File file : files) {
      // Check if the file is a .jpeg image
      if (file.getName().endsWith(".jpeg")) {
        // Create the path for the source and destination files
        Path sourcePath = Paths.get(file.getAbsolutePath());
        Path destPath = Paths.get(destinationFolder + "\\" + file.getName().replace(".jpeg", ".webp"));

        // Replace the .jpeg image with a .webp image
        try {
          Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    //transformar arquivos .jpg em .webp
    for (File file : files) {
      // Check if the file is a .jpg image
      if (file.getName().endsWith(".jpg")) {
        // Create the path for the source and destination files
        Path sourcePath = Paths.get(file.getAbsolutePath());
        Path destPath = Paths.get(destinationFolder + "\\" + file.getName().replace(".jpg", ".webp"));

        // Replace the .jpg image with a .webp image
        try {
          Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    //usar metodo deleteJpeg
    try {
      imageResizer.deleteJpeg();
    } catch (Exception e) {
      e.printStackTrace();
    }

    //usar metodo deleteJpg
    try {
      imageResizer.deleteJpg();
    } catch (Exception e) {
      e.printStackTrace();
    }

    //delete png files
    for (File file : files) {
      if (file.getName().endsWith(".png")) {
        file.delete();
      }
    }
  }
}