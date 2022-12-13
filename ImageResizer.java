import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageResizer {

  // Redimensiona uma imagem para um tamanho específico usando a biblioteca de imagens Java
  public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
    BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
    resizedImage.getGraphics().drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
    return resizedImage;
  }
  
  public void resize() throws IOException {
    // O caminho para a pasta onde as imagens estão armazenadas
    String path = "C:\\Users\\yoshi\\Desktop\\lovtokimages";

    // Lê o conteúdo da pasta
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();

    // Percorre cada arquivo na pasta
    for (File file : listOfFiles) {
      if (file.isFile() && file.getName().endsWith(".png") || file.getName().endsWith(".jpeg") || file.getName().endsWith(".jpg")) {
        try {
          // Abre a imagem usando a biblioteca de imagens Java
          BufferedImage image = ImageIO.read(file);

          // Redimensiona a imagem para 1000x1000 usando a biblioteca de imagens Java
          BufferedImage resizedImage = resizeImage(image, 1000, 1000);

          // Salva a imagem redimensionada com o mesmo nome do arquivo original
          ImageIO.write(resizedImage, "png", file);
        } catch (IOException e) {
          System.out.println("Erro ao redimensionar imagem: " + file.getName());
          e.printStackTrace();
        }
      }
    }
  }

  //deletar imagens em .jpeg
    public void deleteJpeg() throws IOException {
        // O caminho para a pasta onde as imagens estão armazenadas
        String path = "C:\\Users\\yoshi\\Desktop\\lovtokimages";
    
        // Lê o conteúdo da pasta
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        
        // Percorre cada arquivo na pasta
        for (File file : listOfFiles) {
          if (file.isFile() && file.getName().endsWith(".jpeg")) {
            file.delete();
          }
        }

    }

    //deletar imagens em .jpg
    public void deleteJpg() throws IOException {
        // O caminho para a pasta onde as imagens estão armazenadas
        String path = "C:\\Users\\yoshi\\Desktop\\lovtokimages";
    
        // Lê o conteúdo da pasta
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        // Percorre cada arquivo na pasta
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".jpg")) {
                file.delete();
            }
        }
    }

    //deletar images em .png que não são 1000x1000
    public void deletePng() throws IOException {
        // O caminho para a pasta onde as imagens estão armazenadas
        String path = "C:\\Users\\yoshi\\Desktop\\lovtokimages";
    
        // Lê o conteúdo da pasta
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        // Percorre cada arquivo na pasta
        for (File file : listOfFiles) {
        if (file.isFile() && file.getName().endsWith(".png")) {
            try {
                // Abre a imagem usando a biblioteca de imagens Java
                BufferedImage image = ImageIO.read(file);
                int width = image.getWidth();
                int height = image.getHeight();
                    if (width != 1000 || height != 1000) {
                        file.delete();
                    }
            } catch (IOException e) {
                System.out.println("Erro ao deletar imagem: " + file.getName());
                e.printStackTrace();
            }
        }
        }
    }
}