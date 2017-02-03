package ua.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);

    @Modifying
    @Query("DELETE FROM Category c WHERE c.id=:id")
    void deleteById(@Param("id") int id);

    @Modifying
	@Query("SELECT c FROM Category c WHERE c.name=:name")
	void updateByName(@Param("name") String name);
    
    @Query("select distinct a from Category a left join fetch a.commodities")
	List<Category> findCategoryWithCommodity();
    
    @Query("select distinct a from Category a left join fetch a.commodities where a.id =:id")
    Category findCategoryWithCommodity(@Param("id")int id);
}
