package ciclo4.reto2.Controller;

import ciclo4.reto2.Model.User;
import ciclo4.reto2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    //Customs
    @GetMapping("/emailexist/{email}")
    public Boolean getByEmail(@PathVariable("email") String email){
        return userService.getByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public Object getEmailAndPassword(
            @PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getEmailAndPassword(email, password);
    }
}