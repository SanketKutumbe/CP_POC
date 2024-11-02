import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

class Result {

    /*
     * Complete the 'getPhoneNumbers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING country
     *  2. STRING phoneNumber
     * Base URL for copy/paste: https://jsonmock.hackerrank.com/api/countries?name=country

     */

    public static void main(String[] args) {
        String country = "Afghanistan";
        System.out.println( resultCode( country,"12345"));
    }

    public static String resultCode(String country, String mobile){
        String api = "https://jsonmock.hackerrank.com/api/countries?name="+country;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println( response.body() );
            Gson gson = new Gson();

            // Parse JSON to User object
            Response user = gson.fromJson(response.body(), Response.class);
            List<String> codes = user.data.get(0).callingCodes;
            return codes.get(codes.size()-1);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "1";
    }
}

class Response{
    String page;
    String per_page;
    String total;
    String total_pages;
    List<Countries> data;

    static class Countries{
        String name;
        String nativeName;
        List<String> topLevelDomain;
        String alpha2Code;
        String numericCode;
        List<String> currencies;
        List<String> callingCodes;
        String capital;

        public List<String> getCallingCodes() {
            return this.callingCodes;
        }

        @Override
        public String toString() {
            return "Countries{" +
                    "name='" + name + '\'' +
                    ", nativeName='" + nativeName + '\'' +
                    ", topLevelDomain=" + topLevelDomain +
                    ", alpha2Code='" + alpha2Code + '\'' +
                    ", numericCode='" + numericCode + '\'' +
                    ", currencies=" + currencies +
                    ", callingCodes=" + callingCodes +
                    ", capital='" + capital + '\'' +
                    '}';
        }
    }
}

