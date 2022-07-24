package lat.safeplaces.api.controllers;

import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.payloads.response.AllPlacesResponse;
import lat.safeplaces.api.payloads.response.PlaceResponse;
import lat.safeplaces.api.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlaceServiceController {
    // TODO: implement status codes

    // Connect service
    // Constructor-base injection
    private final PlaceService placeService;

    @Autowired
    public PlaceServiceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    // Create a place
    @PostMapping
    public ResponseEntity<PlaceResponse> createPlace(@RequestBody PlaceModel request) {
        return ResponseEntity.ok(placeService.createPlace(request));
    }

    // Get all places
    @GetMapping
    public ResponseEntity<List<AllPlacesResponse>> getAllPlaces() {
        return ResponseEntity.ok(placeService.getAllPlaces());
    }

    // Get a place by ID
    // Not required at API specification
    @GetMapping("/{id}")
    public Optional<PlaceModel> getPlace(@PathVariable("id") Long id) {
        return placeService.getPlaceById(id);
    }

    // Update place by ID
    @PatchMapping("/{id}")
    public ResponseEntity<PlaceResponse> updatePlace(@PathVariable("id") Long id, @RequestBody PlaceModel place) {
        return ResponseEntity.ok(placeService.updatePlaceById(id, place));
    }

    // Delete place by ID
    @DeleteMapping("/{id}")
    public String deletePlace(@PathVariable("id") Long id) {
        return placeService.deletePlaceById(id);
    }

}
