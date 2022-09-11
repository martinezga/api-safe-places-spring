package lat.safeplaces.api.payloads.response;

public class DeleteResponse {
    private Long id;
    private boolean deleted = false;

    public DeleteResponse(Long id) {
        this.id = id;
        deleted = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
