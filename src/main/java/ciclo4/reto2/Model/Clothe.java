package ciclo4.reto2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: Jessica Alexandra Millan
 * Clase Ropa
 * 24-11-2021
 */

@Document(collection = "clothes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clothe {

    @Id
    private String reference;
    private String category;
    private String size;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
}