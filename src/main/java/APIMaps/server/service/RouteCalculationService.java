package APIMaps.server.service;

import APIMaps.entity.FeatureCollection;
import APIMaps.entity.FeatureCollection2;

public interface RouteCalculationService {

    FeatureCollection returnDurationAndDistance(double startX, double startY, double destinationX, double destinationY);
    FeatureCollection2 returnBoundaries(double startX, double startY);
}
