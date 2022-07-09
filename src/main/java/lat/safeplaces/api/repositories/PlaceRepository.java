package lat.safeplaces.api.repositories;

import lat.safeplaces.api.models.PlaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceModel, Long> {

}
