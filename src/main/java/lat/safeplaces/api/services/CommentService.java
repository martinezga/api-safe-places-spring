package lat.safeplaces.api.services;

import lat.safeplaces.api.exceptions.ResourceNotFoundException;
import lat.safeplaces.api.payloads.request.CommentRequest;

import javax.transaction.Transactional;

@Transactional
public interface CommentService {
    public void createComment(CommentRequest comment) throws ResourceNotFoundException;
    public void deleteComment(Long id);
}
