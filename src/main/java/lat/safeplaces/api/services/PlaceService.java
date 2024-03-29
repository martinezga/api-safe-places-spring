package lat.safeplaces.api.services;

import lat.safeplaces.api.exceptions.ResourceNotFoundException;
import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.payloads.response.AllPlacesResponse;
import lat.safeplaces.api.payloads.response.DeleteResponse;
import lat.safeplaces.api.payloads.response.PlaceResponse;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface PlaceService {
    PlaceResponse createPlace(PlaceModel place);
    List<AllPlacesResponse> getAllPlaces();
    Optional<PlaceModel> getPlaceById(Long id);
    PlaceResponse updatePlaceById(Long id, PlaceModel place) throws ResourceNotFoundException;
    DeleteResponse deletePlaceById(Long id) throws ResourceNotFoundException;
    PlaceResponse addPlaceImage(Long id, String imageUrl) throws ResourceNotFoundException;
}
