
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class CurrencyQuery {

    public Coin currencySearch (String coinCode){
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/c194357252329ec1b8c0cd84/latest/" + coinCode );


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        try{
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(),Coin.class);
        } catch (IOException | InterruptedException e){
            throw new RuntimeException("Couldn't find tha currency values "+ e.getMessage());
        }
    }

}





