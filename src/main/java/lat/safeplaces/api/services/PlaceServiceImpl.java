package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.payloads.response.PlaceResponse;
import lat.safeplaces.api.repositories.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
    // Persistence data implementation
    private final PlaceRepository repository;
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        repository = placeRepository;
    }

    @Override
    public PlaceResponse createPlace(PlaceModel request) {
        repository.save(request);
        return new PlaceResponse(request.getId(), request.getName());
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
        return placeToUpdate.map(placeFound -> {
            placeFound.setName(place.getName());
            return repository.save(placeFound);
        }).orElseGet(() -> {
            // TODO: implement orElseThrow / NotFoundException
            System.out.println("do not exist");
            return new PlaceModel();
        });
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
