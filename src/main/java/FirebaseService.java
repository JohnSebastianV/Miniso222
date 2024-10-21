import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import java.util.HashMap;
import java.util.Map;

public class FirebaseService {

    private Firestore db;

    public FirebaseService() {
        db = FirebaseConfig.getFirestore();
    }

    public void addUsuario(String id, String nombre, String correo) throws Exception {
        Map<String, Object> usuario = new HashMap<>();
        usuario.put("nombre", nombre);
        usuario.put("correo", correo);

        DocumentReference docRef = db.collection("usuario").document(id);
        ApiFuture<WriteResult> result = docRef.set(usuario);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    public void addProducto(String id, String categoria, String nombre, int valor) throws Exception {
        Map<String, Object> producto = new HashMap<>();
        producto.put("categoria", categoria);
        producto.put("nombre", nombre);
        producto.put("valor", valor);

        DocumentReference docRef = db.collection("producto").document(id);
        ApiFuture<WriteResult> result = docRef.set(producto);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    public void addHistorialCompra(String id, int idUsuario, Map<String, Integer> productos) throws Exception {
        Map<String, Object> historialCompra = new HashMap<>();
        historialCompra.put("id_usuario", idUsuario);
        historialCompra.put("productos", productos);

        DocumentReference docRef = db.collection("historial_compra").document(id);
        ApiFuture<WriteResult> result = docRef.set(historialCompra);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    public void getUsuario(String id) throws Exception {
        DocumentReference docRef = db.collection("usuario").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
    }


}

