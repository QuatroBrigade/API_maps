package APIMaps.server.service;

import APIMaps.entity.FeatureCollection;

public interface RouteCalculationService {

    FeatureCollection returnFeatureCollection(double startX, double startY, double destinationX, double destinationY);
}
