package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.repositories.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
    // Hardcoded data implementation
    private static Map<Long, PlaceModel> placeRepo = new HashMap<>();
    static{
        PlaceModel brasil = new PlaceModel(1L, "Brasil");
        placeRepo.put(brasil.getId(), brasil);
    }
    // Persistence data implementation
    private PlaceRepository repository;
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        repository = placeRepository;
    }

    @Override
    public PlaceModel createPlace(PlaceModel place) {
        return repository.save(place);
    }

    @Override
    public List<PlaceModel> getAllPlaces() {
        return repository.findAll();
    }

    @Override
    public Optional<PlaceModel> getPlaceById(Long id) {
        // TODO: When id do not exist return empty json, not a null value
        return repository.findById(id);
    }

    @Override
    public String updatePlaceById(Long id, PlaceModel place) {
        // Search if record exists
        PlaceModel placeToUpdate = placeRepo.get(id);
        try {
            // If placeToUpdate is null throws an exception
            place.setId(placeToUpdate.getId());
            placeRepo.put(id, place);
            return "Place is updated successfully";
        } catch (Exception e) {
            return "Error";
        }
    }

    @Override
    public String deletePlaceById(Long id) {
        // Search if record exists
        PlaceModel placeToUpdate = placeRepo.get(id);
        try {
            // If placeToUpdate is null throws an exception
            placeRepo.remove(id, placeToUpdate);
            return "id: " + id + " deleted successfully";
        } catch (Exception e) {
            return "Error";
        }
    }
}
