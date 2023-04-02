package APIMaps.server.webService;


import APIMaps.entity.FeatureCollection;
import APIMaps.entity.FeatureCollection2;
import APIMaps.entity.ReturnTwoDouble;
import APIMaps.server.service.RouteCalculationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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

    @GetMapping("/route/startX/{startx}/startY/{starty}/endX/{endx}/endY/{endy}")
    public String loadDurationAndDistance(@PathVariable double startx, @PathVariable double starty,
                           @PathVariable double endx, @PathVariable double endy) {

        FeatureCollection result =
        routeCalculationService.returnDurationAndDistance(startx, starty, endx, endy);

        ReturnTwoDouble returnTwoDouble = new ReturnTwoDouble(result.getFeatures()[0].getProperties().getSummary().getDuration(),
                                                              result.getFeatures()[0].getProperties().getSummary().getDistance());

        return new Gson().toJson(returnTwoDouble);
    }

    @GetMapping("/route/startX/{startx}/starty/{starty}")
    public double[][][] loadBoundaries(@PathVariable double startx, @PathVariable double starty) {

        if(startx != 0 || starty != 0) {
            FeatureCollection2 result =
                    routeCalculationService.returnBoundaries(startx, starty);

            int lastIdx = result.getFeatures().length - 1;

            return result.getFeatures()[lastIdx].getGeometry().getCoordinates();
        } else {
            return new double[0][0][0];
        }


    }

}
