package ciclo4.reto2.Repository;

import ciclo4.reto2.Model.Clothe;
import ciclo4.reto2.Repository.Crud.ClotheCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClotheRepository {
    @Autowired
    private ClotheCrudRepository clotheCrudRepository;

    public List<Clothe> getAll() {
        return clotheCrudRepository.findAll();
    }

    public Optional<Clothe> getClothe(String id) {
        return clotheCrudRepository.findById(id);
    }

    public Clothe save(Clothe clothe) {
        return clotheCrudRepository.save(clothe);
    }

    public void update(Clothe clothe){clotheCrudRepository.save(clothe);}

    public void delete(String id) {
        clotheCrudRepository.deleteById(id);
    }
}
