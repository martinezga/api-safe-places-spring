package lat.safeplaces.api.payloads.response;

public class DeleteResponse {
    private Long id;
    private boolean deleted = false;

    public DeleteResponse(Long id) {
        this.id = id;
        deleted = true;
    }
}
