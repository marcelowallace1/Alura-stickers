import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class contentExtractorIMDB implements contentExtractor{
    public List<Content> extractContent(String json){
        var parser = new jsonParser();
        List<Map<String, String>> atributesList = parser.parse(json);   
        
        List<Content> contents = new ArrayList<>();

        //pupular a listade conteudos

        for(Map<String, String> atributes : atributesList){
            String Title = atributes.get("title");
            String urlImage = atributes.get("image").replaceAll("(@+)(.*).jpg$", "#1.jpg");
            var Content = new Content(Title, urlImage);

            contents.add(Content);
        }
        return contents;
    }
}
