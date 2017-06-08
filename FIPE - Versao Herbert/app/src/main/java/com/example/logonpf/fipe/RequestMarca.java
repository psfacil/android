package com.example.logonpf.fipe;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RequestMarca implements Response.Listener<JSONArray>{

    private Spinner spMarca;
    private ArrayAdapter<Marca> adpMarca;
    private Context ctx;

    public RequestMarca(Spinner spMarca, ArrayAdapter<Marca> adpMarca, Context ctx){
        this.spMarca = spMarca;
        this.adpMarca = adpMarca;
        this.ctx = ctx;
    }

    @Override
    public void onResponse(JSONArray response) {

        List<Marca> marcas = new ArrayList<Marca>();

        for (int i = 0; i < response.length(); i++) {
            try {

                JSONObject obj = response.getJSONObject(i);
                marcas.add(new Marca(obj.getInt("id"), obj.getString("name")));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

       adpMarca = new ArrayAdapter<Marca>(ctx,
                android.R.layout.simple_spinner_dropdown_item,
                marcas);
       spMarca.setAdapter(adpMarca);

        Log.i("FIPE", response.toString());

    }
}
