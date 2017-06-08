package esensato.nac02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private List<Acao> acoes;
    private ArrayAdapter<Acao> adpAcoes;

    private Spinner spAcoes;
    private EditText edtQtde;
    private Button btnComprar;
    private TextView txtTotalAtual;

    private Acao acaoSelecionada;
    private double totalAtual = 10000.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spAcoes = (Spinner) findViewById(R.id.spAcoes);
        acoes = new ArrayList<Acao>();
        adpAcoes = new ArrayAdapter<Acao>(this, android.R.layout.simple_spinner_item, acoes);
        spAcoes.setAdapter(adpAcoes);
        spAcoes.setOnItemSelectedListener(this);
        carregarAcoes();

        btnComprar = (Button) findViewById(R.id.btnComprar);
        btnComprar.setVisibility(View.INVISIBLE);

        edtQtde = (EditText) findViewById(R.id.edtQtde);

        txtTotalAtual = (TextView) findViewById(R.id.txtTotal);
        txtTotalAtual.setText(Acao.df.format(this.totalAtual));

    }

    private void carregarAcoes() {

        try {

            JSONArray acoes = new JSONArray(Server.request());
            for (int i = 0; i < acoes.length(); i++) {

                JSONObject acao = acoes.getJSONObject(i);
                this.adpAcoes.add(new Acao(acao.getString("acao"), acao.getDouble("valor")));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void aceitarTermo(View v) {

        CheckBox click = (CheckBox) v;
        if (click.isChecked())
            this.btnComprar.setVisibility(View.VISIBLE);
        else
            btnComprar.setVisibility(View.INVISIBLE);

    }

    public void confirmarCompra(View v) {

        double valorAcao = this.acaoSelecionada.getValor();
        int qte = Integer.parseInt(this.edtQtde.getText().toString());
        this.totalAtual = this.totalAtual - (valorAcao * qte);
        txtTotalAtual.setText(Acao.df.format(this.totalAtual));

    }

    @Override
    public void onItemSelected(AdapterView<?> adp, View view, int pos, long l) {

        this.acaoSelecionada = (Acao) adp.getItemAtPosition(pos);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
