package lat.safeplaces.api.services;

import lat.safeplaces.api.exceptions.ResourceNotFoundException;
import lat.safeplaces.api.models.CommentModel;
import lat.safeplaces.api.payloads.request.CommentRequest;

import javax.transaction.Transactional;

@Transactional
public interface CommentService {
    CommentModel createComment(CommentRequest comment) throws ResourceNotFoundException;
    void deleteComment(Long id);
}
