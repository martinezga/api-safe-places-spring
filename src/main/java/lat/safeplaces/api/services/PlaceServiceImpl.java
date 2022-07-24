package lat.safeplaces.api.services;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.payloads.response.AllPlacesResponse;
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
    public List<AllPlacesResponse> getAllPlaces() {
        return new AllPlacesResponse(repository.findAll()).getListPlaceResponse();
    }

    @Override
    public Optional<PlaceModel> getPlaceById(Long id) {
        // TODO: When id do not exist return empty json, not a null value
        return repository.findById(id);
    }

    @Override
    public PlaceResponse updatePlaceById(Long id, PlaceModel place) {
        // Search if record exists
        Optional<PlaceModel> placeToUpdate = repository.findById(id);
        return placeToUpdate.map(placeFound -> {
            var name = place.getName();
            var description = place.getDescription();
            var address_state = place.getAddress_state();
            var address_city = place.getAddress_city();
            var address_colonia = place.getAddress_colonia();
            var address_street = place.getAddress_street();
            var address_zipcode = place.getAddress_zipcode();

            if (name != null) placeFound.setName(name);
            if (description != null) placeFound.setDescription(name);
            if (address_state != null) placeFound.setAddress_state(address_state);
            if (address_city != null) placeFound.setAddress_city(address_city);
            if (address_colonia != null) placeFound.setAddress_colonia(address_colonia);
            if (address_street != null) placeFound.setAddress_street(address_street);
            if (address_zipcode != null) placeFound.setAddress_zipcode(address_zipcode);

            repository.save(placeFound);

            return new PlaceResponse(id, placeFound.getName());
        }).orElseGet(() -> {
            // TODO: implement orElseThrow / NotFoundException
            System.out.println("do not exist");
            return new PlaceResponse();
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
