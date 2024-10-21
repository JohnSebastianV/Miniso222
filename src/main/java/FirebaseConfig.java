import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.cloud.FirestoreClient;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {
    public static void initFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/paradigmaskey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://paradigmas-ccf80.firebaseio.com") // Si estás usando Realtime Database
                .build();

        FirebaseApp.initializeApp(options);
    }

    public static Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }
}

