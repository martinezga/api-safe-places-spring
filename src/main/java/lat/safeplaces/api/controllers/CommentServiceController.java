package lat.safeplaces.api.controllers;

import lat.safeplaces.api.exceptions.ResourceNotFoundException;
import lat.safeplaces.api.models.CommentModel;
import lat.safeplaces.api.payloads.request.CommentRequest;
import lat.safeplaces.api.payloads.response.DeleteResponse;
import lat.safeplaces.api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentServiceController {
    private final CommentService service;

    @Autowired
    public CommentServiceController(CommentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommentModel> createComment(@RequestBody CommentRequest request)
        throws ResourceNotFoundException {
        return ResponseEntity.ok(service.createComment(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> deleteOneComment(@PathVariable("id") Long id)
        throws ResourceNotFoundException {
        return ResponseEntity.ok(service.deleteCommentByID(id));
    }
}
