package edu.salesianos.triana.manejoerrores.repo;

import edu.salesianos.triana.manejoerrores.model.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepository extends JpaRepository<Estacion,Long> {
}
