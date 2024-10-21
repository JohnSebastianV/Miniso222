import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Inicializamos Firebase
        FirebaseConfig.initFirebase();

        // Creamos el servicio para interactuar con la base de datos
        FirebaseService service = new FirebaseService();

        // Ejemplo para agregar un usuario
        /*service.addUsuario("10", "pepito", "pepito@gmail.com");

            //Ejemplo para agregar un producto
            service.addProducto("1", "Electrónica", "Teléfono", 120000);

            // Ejemplo para agregar un historial de compra
            Map<String, Integer> productos = new HashMap<>();
            productos.put("1", 2); // 2 unidades del producto con id 1
            service.addHistorialCompra("1", 1, productos); */

            // Obtener un usuario por su id
            service.getUsuario("1");
            

    }

}
