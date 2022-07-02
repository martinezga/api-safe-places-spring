package lat.safeplaces.api.controllers;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/places")
public class PlaceServiceController {
    // TODO: implement status codes

    // Connect service
    @Autowired
    PlaceService placeService;

    // Create a place
    @PostMapping("/")
    public String createPlace(@RequestBody PlaceModel place) {
        placeService.createPlace(place);
        return "Place is created successfully";
    }

    // Get all places
    @GetMapping("/")
    public Collection<PlaceModel> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    // Get a place by ID
    @GetMapping("/{id}")
    public PlaceModel getPlace(@PathVariable("id") String id) {
        return placeService.getPlaceById(id);
    }

    // Update place by ID
    @PatchMapping("/{id}")
    public String updatePlace(@PathVariable("id") String id, @RequestBody PlaceModel place) {
        return placeService.updatePlaceById(id, place);
    }

    // Delete place by ID
    @DeleteMapping("/{id}")
    public String deletePlace(@PathVariable("id") String id) {
        return placeService.deletePlaceById(id);
    }

}
