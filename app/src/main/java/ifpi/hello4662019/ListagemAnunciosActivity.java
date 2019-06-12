package ifpi.hello4662019;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import ifpi.hello4662019.adapters.ListagemAnunciosAdapter;
import ifpi.hello4662019.modelos.Anuncio;

public class ListagemAnunciosActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private RecyclerView rvAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_anuncios);

        rvAnuncios = findViewById(R.id.rv_anuncios);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListagemAnunciosAdapter adapter = new ListagemAnunciosAdapter(Anuncio.obterAnunciosFake(), this);

        rvAnuncios.setAdapter(adapter);

        rvAnuncios.setLayoutManager(new LinearLayoutManager(this));

    }

     private void obterAnunciosDoFirestore(){

        final List<Anuncio> anuncios = new ArrayList<>();

        db.collection("anuncios").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task){
                if(task.isSuccessful()){
                    for (DocumentSnapshot documento: task.getResult()){
                        Anuncio anuncio = documento.toObject(Anuncio.class);
                        anuncios.add(anunci
                    }
                }
            }
        });
     }
}








