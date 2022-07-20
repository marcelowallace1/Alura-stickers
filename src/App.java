import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer uma conexao HTTP buscar top filmes
        String url = "https://api.mocki.io/v2/549a5d8b"; // usando endereço alternativo ao IMDB
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        

    
        // puxar os dados necessarios, titulo, poster, notas
        var parser = new jsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.size());
        // System.out.println(listaDeFilmes.get(0));


        // exibir/manipular os dados na aplicacao
        for (Map<String,String> film : listaDeFilmes) {

            String urlImage = film.get("image");
            String Title = film.get("title");

            InputStream inputStream = new URL(urlImage).openStream();
            String nameArquive = Title + ".png";
            var generate = new stickerGenerator();
            generate.create(inputStream, nameArquive);


            System.out.println(Title);
            System.out.println();
        }
    }
}
