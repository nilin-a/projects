package com.diploma.server.repository;;
import com.diploma.server.entity.Medic;;
import com.diploma.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
    Medic findMedicByUser(User user);

    Medic findMedicById(long id);
}
