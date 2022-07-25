import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class contentExtractorNasa implements contentExtractor{
    public List<Content> extractContent(String json){
        // puxar os dados necessarios, titulo, poster, notas
        var parser = new jsonParser();
        List<Map<String, String>> atributesList = parser.parse(json);   
        
        List<Content> contents = new ArrayList<>();

        //pupular a listade conteudos

        for(Map<String, String> atributes : atributesList){
            String Title = atributes.get("title");
            String urlImage = atributes.get("url");
            var content = new Content(Title, urlImage);

            contents.add(content);
        }
        return contents;

    
}
}