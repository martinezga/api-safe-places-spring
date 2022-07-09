package lat.safeplaces.api.payloads.response;

import lat.safeplaces.api.models.PlaceModel;

import java.util.ArrayList;
import java.util.List;

public class PlaceResponse {

    private Long id;
    private String name;
    private List<PlaceResponse> listPlacesResponse;
    private String test;

    public PlaceResponse() {}

    public PlaceResponse(Long id, String name) {
        this.id = id;
        this.name = name;
        this.test = "hardcoded message";
    }

    public PlaceResponse(List<PlaceModel> allPlaces) {
        List<PlaceResponse> allPlacesResponse = new ArrayList<>();
        // Convert List<PlaceModel> into List<PlaceResponse>
        for (PlaceModel place : allPlaces) {
            allPlacesResponse.add(new PlaceResponse(place.getId(), place.getName()));
        }
        listPlacesResponse = allPlacesResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlaceResponse> getListPlacesResponse() {
        return listPlacesResponse;
    }

    public void setListPlacesResponse(List<PlaceResponse> listPlacesResponse) {
        this.listPlacesResponse = listPlacesResponse;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
