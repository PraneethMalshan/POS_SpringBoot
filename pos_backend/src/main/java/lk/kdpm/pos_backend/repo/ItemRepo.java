package lk.kdpm.pos_backend.repo;

import lk.kdpm.pos_backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);
//    findAllBy=ekakda godakda kiyala filter kara ganna, ItemNameEquals=mulinma thina variable eka Equals denna oona filter kara ganna., And=saha, ActiveStateEquals=Active state eka equals wennath oona.

}
