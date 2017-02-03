package ua.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email =:email")
    boolean userExistsByEmail(@Param("email") String email);

    User findByPhone(String phone);

    User findByName(String name);

    @Query(value = "select u from User u left join fetch u.commodities com where u.id =:id")
    User findUserByFetch(@Param("id") int id);

    @Query("select u from User u where u.uuid =:uuid")
    User findByUUID(@Param("uuid") String uuid);



}
