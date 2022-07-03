package lat.safeplaces.api.controllers;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlaceServiceController {
    // TODO: implement status codes

    // Connect service
    // Field injection
    @Autowired
    PlaceService placeService;

    // Create a place
    @PostMapping("/")
    public PlaceModel createPlace(@RequestBody PlaceModel place) {
        return placeService.createPlace(place);
    }

    // Get all places
    @GetMapping("/")
    public List<PlaceModel> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    // Get a place by ID
    // Not required at API specification
    @GetMapping("/{id}")
    public Optional<PlaceModel> getPlace(@PathVariable("id") Long id) {
        return placeService.getPlaceById(id);
    }

    // Update place by ID
    @PatchMapping("/{id}")
    public PlaceModel updatePlace(@PathVariable("id") Long id, @RequestBody PlaceModel place) {
        return placeService.updatePlaceById(id, place);
    }

    // Delete place by ID
    @DeleteMapping("/{id}")
    public String deletePlace(@PathVariable("id") Long id) {
        return placeService.deletePlaceById(id);
    }

}
