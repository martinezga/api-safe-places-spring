package lat.safeplaces.api.payloads.request;

public class CommentRequest {
    private Long placeId;
    private String comment;

    public CommentRequest() {
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
