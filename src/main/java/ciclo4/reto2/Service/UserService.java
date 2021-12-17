package ciclo4.reto2.Service;

import ciclo4.reto2.Model.User;
import ciclo4.reto2.Model.Custom.UserAndMail;
import ciclo4.reto2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.getById(id);
    }

    public User save(User user){
        if(user.getId()==null){
            return userRepository.save(user);
        }else{
            Optional<User> e=userRepository.getById(user.getId());
            if(e.isEmpty()){
                return userRepository.save(user);
            }else{
                return user;
            }
        }
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getById(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if(user.getBirthtDay()!=null){
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if(user.getMonthBirthtDay()!=null){
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean deleteUser(int id){
        Boolean aBoolean=getUser(id).map(user -> {
            userRepository.delete(id);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }


    //CUSTOMS
    public Boolean getByEmail(String email){
        //Cuento la lista para saber si existe algún registro con ese email
        if(userRepository.findByEmail(email).size()!=0){
            return true;
        }else{
            return false;
        }
    }

    public Object getEmailAndPassword(String email, String password){
        //return userRepository.findByEmailAndPassword(email, password);
        Optional<Object> ExisteUsuario = userRepository.findByEmailAndPassword(email, password);
        System.out.println("ExisteUsuario: "+ExisteUsuario);

        if(ExisteUsuario.isPresent()==true){
            return userRepository.findByEmailAndPassword(email, password);
        }else{
            UserAndMail O= new UserAndMail();
            O.setName(null);
            O.setAddress(null);
            O.setCellPhone(null);
            O.setEmail(null);
            O.setPassword(null);
            O.setZone(null);
            O.setType(null);


            System.out.println("Objeto NULO: "+O);
            return O;
        }


    }

}