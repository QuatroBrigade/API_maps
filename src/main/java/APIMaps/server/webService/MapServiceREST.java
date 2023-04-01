package APIMaps.server.webService;


import APIMaps.entity.FeatureCollection;
import APIMaps.entity.ReturnTwoDouble;
import APIMaps.server.service.RouteCalculationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dominik Ivanoc
 */

@RestController
@RequestMapping("/api/map")
@EntityScan(basePackages = "APIMaps.entity")
public class MapServiceREST {


    @Autowired
    private RouteCalculationService routeCalculationService;

    @GetMapping("/route/startX/{startx}/starty/{starty}/endX/{endx}/endY/{endy}")
    public String savePdfInDB(@PathVariable double startx, @PathVariable double starty,
                           @PathVariable double endx, @PathVariable double endy) {

        FeatureCollection result =
        routeCalculationService.returnFeatureCollection(startx, starty, endx, endy);

        ReturnTwoDouble returnTwoDouble = new ReturnTwoDouble(result.getFeatures()[0].getProperties().getSummary().getDuration(),
                                                              result.getFeatures()[0].getProperties().getSummary().getDistance());

        return new Gson().toJson(returnTwoDouble);
    }



}
