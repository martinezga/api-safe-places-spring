package lat.safeplaces.api.services;

import lat.safeplaces.api.exceptions.ResourceNotFoundException;
import lat.safeplaces.api.models.CommentModel;
import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.payloads.request.CommentRequest;
import lat.safeplaces.api.payloads.response.DeleteResponse;
import lat.safeplaces.api.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository repository;
    private PlaceServiceImpl placeService;

    public CommentServiceImpl(CommentRepository commentRepository, PlaceServiceImpl placeService) {
        repository = commentRepository;
        this.placeService = placeService;
    }

    @Override
    public CommentModel createComment(CommentRequest request) throws ResourceNotFoundException {
        PlaceModel placeReceived = placeService.getPlaceById(request.getPlaceId());
        CommentModel commentToSave = new CommentModel();
        commentToSave.setComment(request.getComment());
        placeReceived.getComments().add(commentToSave);
        return repository.save(commentToSave);
    }

    @Override
    public DeleteResponse deleteCommentByID(Long id)
        throws ResourceNotFoundException {
            // If object do not exist throws an exception
            try {
                repository.deleteById(id);
            } catch (Exception e) {
                throw new ResourceNotFoundException();
            }
            return new DeleteResponse(id);
        }
}
