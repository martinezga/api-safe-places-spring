package lat.safeplaces.api.controllers;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/places")
public class PlaceServiceController {
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
    public String index() {
        return placeService.getAllPlaces();
    }

    // Get a place by ID
    @GetMapping("/{id}")
    public PlaceModel index(@PathVariable("id") String id) {
        return placeService.getPlaceById(id);
    }
}
