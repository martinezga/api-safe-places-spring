package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PlaceServiceImpl implements PlaceService {
    // Hardcoded data implementation
    private static Map<String, PlaceModel> placeRepo = new HashMap<>();
    static{
        PlaceModel brasil = new PlaceModel("1", "Brasil");
        placeRepo.put(brasil.getId(), brasil);
    }

    @Override
    public void createPlace(PlaceModel place) {
        placeRepo.put(place.getId(), place);
    }

    @Override
    public Collection<PlaceModel> getAllPlaces() {
        return placeRepo.values();
    }

    @Override
    public PlaceModel getPlaceById(String id) {
        return placeRepo.get(id);
    }

    @Override
    public String updatePlaceById(String id, PlaceModel place) {
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
}
