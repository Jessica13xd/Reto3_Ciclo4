package ciclo4.reto2.Repository;

import ciclo4.reto2.Model.Order;
import ciclo4.reto2.Repository.Crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderCrudRepository.findById(id);
    }

    public Order save(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Integer id) {
        orderCrudRepository.deleteById(id);
    }

    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }

    public List<Order> findByStatus(String status, int idSales){
        return orderCrudRepository.findByStatus(status,idSales);
    }

    public List<Order> findByRegisterDate(Date date, int idSales){
        return orderCrudRepository.findByRegisterDay(date,idSales);
    }

    public List<Order> findBySalesMan(int idSales){
        return orderCrudRepository.findBySalesMan(idSales);
    }
}
