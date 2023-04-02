package APIMaps.server.api;

import APIMaps.entity.FeatureCollection;
import APIMaps.entity.FeatureCollection2;
import APIMaps.server.service.RouteCalculationService;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class calculateRouteTime implements RouteCalculationService {

    String API_KEY= "5b3ce3597851110001cf62485929fc74e89c4761b432394d6034fb48";

    public FeatureCollection returnDurationAndDistance(double startX, double startY, double destinationX, double destinationY) {

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

    public FeatureCollection2 returnBoundaries(double startX, double startY) {
        String origin = "" + startX + "," + startY;

        // Construct the URL
        String mode = "foot-walking"; // Mode of transportation
        //String urlStr = "https://api.openrouteservice.org/v2/isochrones/driving-car?api_key=" + API_KEY + "&locations=-122.4194,37.7749&range_type=time&range=600&interval=120&attributes=total_pop";

        String urlStr = "https://api.openrouteservice.org/v2/isochrones/"+ mode;

        try {

            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", API_KEY);
            con.setRequestProperty("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8");
            con.setRequestProperty("Content-Type", "application/json");

            String postData = "{ \"locations\": [ ["+origin+"] ], \"range\": [ 900 ], \"range_type\": \"time\", \"interval\": 120, \"attributes\": [ \"total_pop\" ] }";
            con.setDoOutput(true);
            con.getOutputStream().write(postData.getBytes("UTF-8"));

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                Gson gson = new Gson();
                System.out.println(response.toString());

                // parse string data into object based on Json
                String jsonString = response.toString();
                return gson.fromJson(jsonString, FeatureCollection2.class);
            } else {
                System.out.println("HTTP error code: " + responseCode);
            }
        }catch (Exception e) {
            System.out.println(e);
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