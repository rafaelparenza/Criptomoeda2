package rafaelparenza.com.criptomoeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import rafaelparenza.com.criptomoeda.adapter.XrpAdapter;
import rafaelparenza.com.criptomoeda.data.Ordens;
import rafaelparenza.com.criptomoeda.data.XrpDatasourceHelper;

public class VerDetalhesXrpActivity extends AppCompatActivity {

    private RecyclerView xrpRecyclerView;
    private List<Ordens> datasourceOrdensXrp;
    private XrpAdapter xrpAdapter;

    private EditText precoCompraSugeridoEditText;
    private EditText precoVendaSugeridoEditText;
    private TextView quantidadeDisponivelNegociacaoTextView;
    private TextView saldoDisponivelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalhes_xrp);

        //buscar referencias
        xrpRecyclerView = findViewById(R.id.activity_principal_recycler_view_ordensXRP);
        precoCompraSugeridoEditText = findViewById(R.id.activity_verXRP_preco_comprar);
        precoVendaSugeridoEditText = findViewById(R.id.activity_verXRP_preco_vender);
        quantidadeDisponivelNegociacaoTextView = findViewById(R.id.activity_verXRP_quantidade_disponivel);
        saldoDisponivelTextView = findViewById(R.id.activity_verXRP_saldo_disponivel);


        XrpDatasourceHelper helper = new XrpDatasourceHelper();
        datasourceOrdensXrp = helper.getDatasourceXrp();

        xrpAdapter = new XrpAdapter(datasourceOrdensXrp);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        xrpRecyclerView.setAdapter(xrpAdapter);
        xrpRecyclerView.setLayoutManager(layoutManager);

        //concatenar e dar valor na tela da activity
        precoCompraSugeridoEditText.setText("1,31");
        precoVendaSugeridoEditText.setText("1,33");
        quantidadeDisponivelNegociacaoTextView.setText("RIPPLE DISPONÍVEL:" + "0.00236500" + "ETH");
        saldoDisponivelTextView.setText("SALDO DISPONÍVEL: R$" + "35,75");

    }
}
