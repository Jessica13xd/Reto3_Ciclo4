package ciclo4.reto2.Service;

import ciclo4.reto2.Model.Order;
import ciclo4.reto2.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderRepository.getOrder(id);
    }

    public Order save(Order order){
        if(order.getId()==null){
            return orderRepository.save(order);
        }else{
            Optional<Order> e=orderRepository.getOrder(order.getId());
            if(e.isEmpty()){
                return orderRepository.save(order);
            }else{
                return order;
            }
        }
    }
    public Order update(Order order){

        if(order.getId()==null){
            return orderRepository.save(order);
        }else{
            Optional<Order> e=orderRepository.getOrder(order.getId());
            if(!e.isEmpty()){
                if(order.getProducts()!=null){
                    e.get().setProducts(order.getProducts());
                }
                if(order.getQuantities()!=null){
                    e.get().setQuantities(order.getQuantities());
                }
                if(order.getRegisterDay()!=null){
                    e.get().setRegisterDay(order.getRegisterDay());
                }
                if(order.getStatus()!=null){
                    e.get().setStatus(order.getStatus());
                }
                if(order.getSalesMan()!=null){
                    e.get().setSalesMan(order.getSalesMan());
                }
                orderRepository.save(e.get());
                return e.get();
            }else{
                return order;
            }
        }
    }

    public boolean deleteOrder(Integer id){


        Boolean aBoolean=getOrder(id).map(user -> {
            orderRepository.delete(id);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }

    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

    public List<Order> findByStatus(String status, int idSales){
        return orderRepository.findByStatus(status,idSales);
    }
    public List<Order> findBySalesMan(int idSales){
        return orderRepository.findBySalesMan(idSales);
    }

    public List<Order> findByRegisterDay(String date, int idSales){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = new Date();
        try{
            dateFormat= formato.parse(date);

        }catch(ParseException e){
            e.printStackTrace();
        }
        return orderRepository.findByRegisterDate(dateFormat, idSales);
    }
}
