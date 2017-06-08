package com.example.logonpf.fipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private Spinner spMarca;
    private ArrayAdapter<Marca> adpMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spMarca = (Spinner) findViewById(R.id.spMarca);
        carregarMarca();
    }

    private void carregarMarca() {

        String urlTXT = "http://fipeapi.appspot.com/api/1/carros/marcas.json";

        JsonArrayRequest req = new JsonArrayRequest(urlTXT,
                                                    new RequestMarca(spMarca,
                                                            adpMarca,
                                                            getApplicationContext()),
                                                    new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);

    }
}
