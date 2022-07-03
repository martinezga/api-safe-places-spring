package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface PlaceService {
    PlaceModel createPlace(PlaceModel place);
    List<PlaceModel> getAllPlaces();
    Optional<PlaceModel> getPlaceById(Long id);
    String updatePlaceById(Long id, PlaceModel place);
    String deletePlaceById(Long id);
}
