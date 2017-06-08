package com.example.logonpf.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void json1(View v) {

        String json = getString(R.string.json1);

        try {
            // {"nome":"JOAO", "nota":10}
            JSONObject alunoJSON = new JSONObject(json);
            AlunoBean aluno = new AlunoBean(alunoJSON.getString("nome"),
                                            alunoJSON.getInt("nota"));
            Toast.makeText(this, aluno.getNome() +
                            ", " +
                            aluno.getNota(), Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    public void json2(View v) {

        String json = getString(R.string.json2);

        // [{"nome":"JOAO", "nota":8},
        // {"nome":"MARIA", "nota":10}]

        try {

            JSONArray alunosJSON = new JSONArray(json);

            List<AlunoBean> alunos = new ArrayList<AlunoBean>();
            for (int i = 0; i < alunosJSON.length(); i++) {
                JSONObject alunoJSON = alunosJSON.getJSONObject(i);
                alunos.add(new AlunoBean(alunoJSON.getString("nome"),
                                         alunoJSON.getInt("nota")));
            }

            for (AlunoBean a:alunos) {

                Toast.makeText(this, a.getNome(), Toast.LENGTH_SHORT).show();

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void json3(View v) {

        String json = getString(R.string.json3);

       // {"nome":"JOAO", "nota":10,
       //         "disciplinas":[{"nome":"Android"}, {"nome":"iOS"}]}

        try {

            JSONObject jsonAluno = new JSONObject(json);
            JSONArray disciplinasJSON = jsonAluno.getJSONArray("disciplinas");
            for (int i = 0; i < disciplinasJSON.length(); i++){

                JSONObject disciplinaJSON = disciplinasJSON.getJSONObject(i);
                Toast.makeText(this, disciplinaJSON.getString("nome"),
                        Toast.LENGTH_SHORT).show();

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
