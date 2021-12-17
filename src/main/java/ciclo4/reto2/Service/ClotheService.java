package ciclo4.reto2.Service;

import ciclo4.reto2.Model.Clothe;
import ciclo4.reto2.Repository.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClotheService {
    @Autowired
    private ClotheRepository clotheRepository;

    public List<Clothe> getAll(){
        return clotheRepository.getAll();
    }

    public Optional<Clothe> getClothe(String id){
        return clotheRepository.getClothe(id);
    }

    public Clothe save(Clothe clothe){
        if(clothe.getReference()==null){
            return clotheRepository.save(clothe);
        }else{
            Optional<Clothe> e=clotheRepository.getClothe(clothe.getReference());
            if(e.isEmpty()){
                return clotheRepository.save(clothe);
            }else{
                return clothe;
            }
        }
    }

    public Clothe update(Clothe clothe){

        if(clothe.getReference()!=null){
            Optional<Clothe> e=clotheRepository.getClothe(clothe.getReference());
            System.out.println("E es igual a: "+clothe.getSize());
            if(!e.isEmpty()){
                if(clothe.getCategory()!=null){
                    e.get().setCategory(clothe.getCategory());
                }
                if(clothe.getSize()!=null){
                    e.get().setSize(clothe.getSize());
                }
                if(clothe.getDescription()!=null){
                    e.get().setDescription(clothe.getDescription());
                }
                if(clothe.getPhotography()!=null){
                    e.get().setPhotography(clothe.getPhotography());
                }
                e.get().setAvailability(clothe.isAvailability());
                clotheRepository.update(e.get());
                return e.get();
            }else{
                return clothe;
            }
        }else {
            return clothe;
        }
    }

    public boolean deleteClothe(String id){


        Boolean aBoolean=getClothe(id).map(user -> {
            clotheRepository.delete(id);
            return true;
        }).orElse(aBoolean=false);

        return aBoolean;
    }
}
