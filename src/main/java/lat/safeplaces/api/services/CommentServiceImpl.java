package lat.safeplaces.api.services;

import lat.safeplaces.api.exceptions.ResourceNotFoundException;
import lat.safeplaces.api.models.CommentModel;
import lat.safeplaces.api.models.PlaceModel;
import lat.safeplaces.api.payloads.request.CommentRequest;
import lat.safeplaces.api.repositories.CommentRepository;

import java.util.Optional;

public class CommentServiceImpl implements CommentService {

    private CommentRepository repository;
    private PlaceServiceImpl placeService;

    public CommentServiceImpl(CommentRepository commentRepository) {
        repository = commentRepository;
    }

    public CommentServiceImpl(PlaceServiceImpl placeService) {
        this.placeService = placeService;
    }

    @Override
    public void createComment(CommentRequest request) throws ResourceNotFoundException {
        PlaceModel placeReceived = placeService.getPlaceById(request.getPlaceId());
        CommentModel commentToSave = null; // WIP
        repository.save(commentToSave);
    }

    @Override
    public void deleteComment(Long id) {

    }
}
