package ua.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.entities.Commodity;



public interface CommodityRepository extends JpaRepository<Commodity,Integer>{


}