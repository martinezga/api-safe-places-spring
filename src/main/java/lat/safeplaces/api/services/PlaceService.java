package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;

public interface PlaceService {
    void createPlace(PlaceModel place);
    String getAllPlaces();
    PlaceModel getPlaceById(String id);
}
