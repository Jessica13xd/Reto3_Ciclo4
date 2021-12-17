package ciclo4.reto2.Repository.Crud;

import ciclo4.reto2.Model.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClotheCrudRepository extends MongoRepository<Clothe, String> {
}
