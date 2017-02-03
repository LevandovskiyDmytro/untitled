package ua.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.entities.Delivery;

public interface DeliveryReposiotry extends JpaRepository<Delivery,Integer> {

    Delivery findByName(String name);

    @Modifying
    @Query("DELETE FROM Delivery c WHERE c.id=:id")
    void deleteById(@Param("id") int id);

    @Modifying
    @Query("SELECT c FROM Delivery c WHERE c.name=:name")
    void updateByName(@Param("name") String name);

}
