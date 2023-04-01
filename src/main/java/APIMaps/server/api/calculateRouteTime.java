package APIMaps.server.api;

import APIMaps.entity.FeatureCollection;
import APIMaps.server.service.RouteCalculationService;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class calculateRouteTime implements RouteCalculationService {

    String API_KEY= "5b3ce3597851110001cf62485929fc74e89c4761b432394d6034fb48";

    public FeatureCollection returnFeatureCollection(double startX, double startY, double destinationX, double destinationY) {

        String origin = ""+startX+","+startY;
        String destination = ""+destinationX+","+destinationY;

        // Construct the URL
        String mode = "foot-walking"; // Mode of transportation
        String url = "https://api.openrouteservice.org/v2/directions/" + mode + "?api_key=" + API_KEY + "&start=" + origin + "&end=" + destination + "&number_of_alternatives=1";

        System.out.println(url);

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            // create gson
            Gson gson = new Gson();

            // parse string data into object based on Json
            String jsonString = response.toString();
            return gson.fromJson(jsonString, FeatureCollection.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//
//        String origin = "21.254345,48.727035"; // Latitude and Longitude of the starting point
//        String destination = "21.257070,48.727775"; // Latitude and Longitude of the destination
//
//
//        FeatureCollection result = returnFeatureCollection(21.254345, 48.727035 ,21.257070, 48.727775);
//
//        assert result != null;
//        System.out.println(result.getFeatures()[0].getProperties().getSummary().getDuration());
//        System.out.println(result.getFeatures()[0].getProperties().getSummary().getDistance());
//
//
//    }

}
