package ua.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.entities.Discount;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {

    Discount findByName(String name);

    @Modifying
    @Query("DELETE FROM Discount c WHERE c.id=:id")
    void deleteById(@Param("id") int id);

    @Modifying
    @Query("SELECT c FROM Discount c WHERE c.name=:name")
    void updateByName(@Param("name") String name);
}
