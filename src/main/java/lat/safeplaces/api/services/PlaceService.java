package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.payloads.response.AllPlacesResponse;
import lat.safeplaces.api.payloads.response.PlaceResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface PlaceService {
    PlaceResponse createPlace(PlaceModel place);
    List<AllPlacesResponse> getAllPlaces();
    Optional<PlaceModel> getPlaceById(Long id);
    PlaceModel updatePlaceById(Long id, PlaceModel place);
    String deletePlaceById(Long id);
}
