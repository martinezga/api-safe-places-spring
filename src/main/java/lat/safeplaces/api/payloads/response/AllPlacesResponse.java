package lat.safeplaces.api.payloads.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lat.safeplaces.api.models.PlaceModel;

import java.util.ArrayList;
import java.util.List;

public class AllPlacesResponse {

    private Long id;
    private String name;
    private String description;
    private String address_state;
    private String address_city;
    private String address_colonia;
    private String address_street;
    private String address_zipcode;
    @JsonIgnore
    private List<AllPlacesResponse> listPlaceResponse;

    public AllPlacesResponse() {}

    public AllPlacesResponse(
            Long id,
            String name,
            String description,
            String address_state,
            String address_city,
            String address_colonia,
            String address_street,
            String address_zipcode
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address_state = address_state;
        this.address_city = address_city;
        this.address_colonia = address_colonia;
        this.address_street = address_street;
        this.address_zipcode = address_zipcode;
    }

    public AllPlacesResponse(List<PlaceModel> listPlaceModel) {
        List<AllPlacesResponse> allPlaceResponse = new ArrayList<>();
        // Convert List<PlaceModel> into List<PlaceResponse>
        for (PlaceModel place: listPlaceModel) {
            allPlaceResponse.add(
                    new AllPlacesResponse(
                            place.getId(),
                            place.getName(),
                            place.getDescription(),
                            place.getAddress_state(),
                            place.getAddress_city(),
                            place.getAddress_colonia(),
                            place.getAddress_street(),
                            place.getAddress_zipcode()
                    )
            );
            listPlaceResponse = allPlaceResponse;
        }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_colonia() {
        return address_colonia;
    }

    public void setAddress_colonia(String address_colonia) {
        this.address_colonia = address_colonia;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_zipcode() {
        return address_zipcode;
    }

    public void setAddress_zipcode(String address_zipcode) {
        this.address_zipcode = address_zipcode;
    }

    public List<AllPlacesResponse> getListPlaceResponse() {
        return listPlaceResponse;
    }

    public void setListPlaceResponse(List<AllPlacesResponse> listPlaceResponse) {
        this.listPlaceResponse = listPlaceResponse;
    }
}
