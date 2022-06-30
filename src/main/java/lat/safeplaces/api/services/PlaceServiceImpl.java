package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;
import org.springframework.stereotype.Service;
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
    public String getAllPlaces() {
        return "Hello world from service";
    }

    @Override
    public String getPlaceById(String id) {
        return id;
    }
}
