package ciclo4.reto2.Repository.Crud;

import ciclo4.reto2.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    @Query("{status: ?0, 'salesMan.id': ?1}")
    List<Order> findByStatus(final String status, Integer id);
    @Query("{'salesMan.id': ?0}")
    List<Order> findBySalesMan(final Integer id);
    @Query("{registerDay: ?0, 'salesMan.id': ?1}")
    List<Order> findByRegisterDay(final Date registerDay, Integer id);
}
