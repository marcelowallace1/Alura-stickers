import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // fazer uma conexao HTTP buscar a lista de contentudos
        String url = "https://api.mocki.io/v2/549a5d8b"; // usando endereço alternativo ao IMDB
        contentExtractor extractor = new contentExtractorIMDB();

        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        //contentExtractor extractor = new contentExtractorNasa();

        var http = new clientHttp();
        String json  = http.buscaDados(url);
         
        List<Content> contents = extractor.extractContent(json);
        var generate = new stickerGenerator();
        for (int i = 0; i < 10; i++){
            Content content = contents.get(i);
            
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String nameArquive = content.getUrlTitle() + ".png";
            
            generate.create(inputStream, nameArquive);
            System.out.println(content.getUrlTitle());
            System.out.println();

        }
   
    }
}
