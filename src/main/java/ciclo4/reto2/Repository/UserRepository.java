package ciclo4.reto2.Repository;

import ciclo4.reto2.Model.User;
import ciclo4.reto2.Repository.Crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return userCrudRepository.findAll();
    }

    public Optional<User> getById(Integer id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public void update(User user) {userCrudRepository.save(user);
    }

    public void delete(Integer id) {
        userCrudRepository.deleteById(id);
    }

    //CUSTOMS
    public List<User> findByEmail(String email){
        return userCrudRepository.findByEmail(email);

    }

    public Optional<Object> findByEmailAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);

    }
}
