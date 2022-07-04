package lat.safeplaces.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlaceModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String address_state;
    private String address_city;
    private String address_colonia;
    private String address_street;
    private String address_zipcode;

    public PlaceModel() {}

    public PlaceModel(Long id,
                      String name) {
        this.id = id;
        this.name = name;
        // TODO: complete assigment
    }

    public PlaceModel(String name) {
        this.name = name;
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
}
