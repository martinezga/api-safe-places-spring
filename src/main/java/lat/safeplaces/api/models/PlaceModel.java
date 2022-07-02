package lat.safeplaces.api.models;

public class PlaceModel {
    private String id;
    private String name;
    private String description;
    private String address_state;
    private String address_city;
    private String address_colonia;
    private String address_street;
    private String address_zipcode;

    public PlaceModel(String id,
                      String name){
        this.id = id;
        this.name = name;
        // TODO: complete assigment
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
