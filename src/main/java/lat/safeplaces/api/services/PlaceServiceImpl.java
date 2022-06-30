package lat.safeplaces.api.services;

import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Override
    public String getAllPlaces() {
        return "Hello world from service";
    }

    @Override
    public String getPlaceById(String id) {
        return id;
    }
}
