package lat.safeplaces.api.exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException() {
        super("Error: Not found");
    }
}
