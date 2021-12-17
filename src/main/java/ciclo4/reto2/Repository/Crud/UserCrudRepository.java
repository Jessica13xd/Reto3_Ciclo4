package ciclo4.reto2.Repository.Crud;

import ciclo4.reto2.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
    public List<User> findByEmail(String email);
    public Optional<Object> findByEmailAndPassword (String email, String password);
}