package ciclo4.reto2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

/**
 * @author: Jessica Alexandra Millan
 * Clase Orden
 * 02-12-2021
 */

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<String, Clothe> products;
    private Map<String, Integer> quantities;
}
