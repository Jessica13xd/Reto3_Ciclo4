package ciclo4.reto2.Controller;

import ciclo4.reto2.Model.Clothe;
import ciclo4.reto2.Service.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clothe")
public class ClotheController {
    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll() {
        return clotheService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clothe> getClothe(@PathVariable String id) {
        return clotheService.getClothe(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe clothe) {
        return clotheService.update(clothe);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe save(@RequestBody Clothe clothe) {
        return clotheService.save(clothe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable String id) {
        return clotheService.deleteClothe(id);
    }
}