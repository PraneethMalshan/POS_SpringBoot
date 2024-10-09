package lk.kdpm.pos_backend.repo;

import lk.kdpm.pos_backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository   //Repository ekak kiyala pennanna daanawa.
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer> {   //wam paththata danne entity ekee name eka. dakunu paththata daanne entity ekee primary key ekee type eka.

}
