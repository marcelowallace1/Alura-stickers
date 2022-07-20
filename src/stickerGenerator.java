import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class stickerGenerator {
    
    public void create(InputStream inputStream, String nameArquive) throws Exception{
        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entradas/TopMovies_1.jpg"));
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage originalImg = ImageIO.read(inputStream);

        // cria nova imagem em memoria com transparencia e redimencionada 
        int width = originalImg.getWidth();
        int height = originalImg.getHeight();
        int newHeight = height + 200;
        BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a img original para nova img(em memoria)
        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(originalImg, 0, 0, null);

        // ajustar fonte da frase
        var font = new Font(Font.SANS_SERIF, Font.ITALIC, 64);
        
        graphics.setFont(font);
        graphics.setColor(Color.green);

        // escrever uma frase na nova img
        
        graphics.drawString("texto exemplo", 100, newHeight- 110);
        
        // escrever a nova img em um arquivo
        var output = "output/" + nameArquive;
        
        ImageIO.write(newImg, "png", new File(output));

    }

}
