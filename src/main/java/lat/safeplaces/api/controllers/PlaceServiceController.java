package lat.safeplaces.api.controllers;

import lat.safeplaces.api.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceServiceController {
    // Connect service
    @Autowired
    PlaceService placeService;

    // Get all places
    @GetMapping("/")
    public String index() {
        return placeService.getAllPlaces();
    }
}
