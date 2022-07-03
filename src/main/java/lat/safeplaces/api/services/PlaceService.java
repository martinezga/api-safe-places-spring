package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PlaceService {
    PlaceModel createPlace(PlaceModel place);
    List<PlaceModel> getAllPlaces();
    PlaceModel getPlaceById(Long id);
    String updatePlaceById(Long id, PlaceModel place);
    String deletePlaceById(Long id);
}
