package co.com.ies.cachejhip;

import java.util.Optional;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,UUID> {

    public static final String CACHE_ESTUDIANTES = "estudiantes";

    @Cacheable(value = CACHE_ESTUDIANTES, key = "#id")
    Optional<Student> findById(UUID id);

}
