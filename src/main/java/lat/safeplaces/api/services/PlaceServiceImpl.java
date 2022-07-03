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
    public PlaceModel updatePlaceById(Long id, PlaceModel place) {
        // Search if record exists
        Optional<PlaceModel> placeToUpdate = repository.findById(id);
        PlaceModel placeUpdated = placeToUpdate.map(placeFound -> {
            placeFound.setName(place.getName());
            return repository.save(placeFound);
        }).orElseGet(() -> {
            // TODO: implement orElseThrow / NotFoundException
            System.out.println("do not exist");
            return new PlaceModel();
        });
        return placeUpdated;
    }

    @Override
    public String deletePlaceById(Long id) {
        try {
            // If object do not exist throws an exception
            repository.deleteById(id);
            return "id: " + id + " deleted successfully";
        } catch (Exception e) {
            return "Error";
        }
    }
}
