package lat.safeplaces.api.models;

import javax.persistence.*;

@Entity
@Table(name = "places")
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
    @Column(name = "imageUrl")
    private String url;

    public PlaceModel() {}

    public PlaceModel(Long id, String name,
                      String description, String address_state,
                      String address_city, String address_colonia,
                      String address_street, String address_zipcode,
                      String url)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address_state = address_state;
        this.address_city = address_city;
        this.address_colonia = address_colonia;
        this.address_street = address_street;
        this.address_zipcode = address_zipcode;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String imageUrl) {
        this.url = imageUrl;
    }

    @Override
    public String toString() {
        return String.format("PlaceModel[id=%d, name='%s']", id, name);
    }
}
