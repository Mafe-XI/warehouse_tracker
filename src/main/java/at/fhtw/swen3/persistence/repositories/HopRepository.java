package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HopRepository  extends JpaRepository<HopEntity, Long> {
    HopEntity findByCode (String code);
    List<HopEntity> findByLocationName (String locationName);
}
