package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;

import java.util.Collection;

public interface PlaceService {
    void createPlace(PlaceModel place);
    Collection<PlaceModel> getAllPlaces();
    PlaceModel getPlaceById(String id);
}
