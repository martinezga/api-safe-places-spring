package lat.safeplaces.api.controllers;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String createPlace(@RequestBody PlaceModel place) {
        placeService.createPlace(place);
        return "Place is created successfully";
    }

    // Get all places
    @GetMapping("/")
    public List<PlaceModel> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    // Get a place by ID
    @GetMapping("/{id}")
    public PlaceModel getPlace(@PathVariable("id") Long id) {
        return placeService.getPlaceById(id);
    }

    // Update place by ID
    @PatchMapping("/{id}")
    public String updatePlace(@PathVariable("id") Long id, @RequestBody PlaceModel place) {
        return placeService.updatePlaceById(id, place);
    }

    // Delete place by ID
    @DeleteMapping("/{id}")
    public String deletePlace(@PathVariable("id") Long id) {
        return placeService.deletePlaceById(id);
    }

}
