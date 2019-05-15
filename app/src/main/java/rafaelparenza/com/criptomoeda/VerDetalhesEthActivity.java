package rafaelparenza.com.criptomoeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import rafaelparenza.com.criptomoeda.adapter.EthAdapter;
import rafaelparenza.com.criptomoeda.data.EthDataSourceHelper;
import rafaelparenza.com.criptomoeda.data.Ordens;

public class VerDetalhesEthActivity extends AppCompatActivity {


    private RecyclerView ethRecyclerView;
    private List<Ordens> datasourceOrdensEth;
    private EthAdapter ethAdapter;

    private EditText precoCompraSugeridoEditText;
    private EditText precoVendaSugeridoEditText;
    private TextView quantidadeDisponivelNegociacaoTextView;
    private TextView saldoDisponivelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalhes_eth);


        //buscar referencias
        ethRecyclerView = findViewById(R.id.activity_principal_recycler_view_ordensETH);
        precoCompraSugeridoEditText = findViewById(R.id.activity_verETH_preco_comprar);
        precoVendaSugeridoEditText = findViewById(R.id.activity_verETH_preco_vender);
        quantidadeDisponivelNegociacaoTextView = findViewById(R.id.activity_veETH_quantidade_disponivel);
        saldoDisponivelTextView = findViewById(R.id.activity_verETH_saldo_disponivel);


        EthDataSourceHelper helper = new EthDataSourceHelper();
        datasourceOrdensEth = helper.getDatasourceEth();

        ethAdapter = new EthAdapter (datasourceOrdensEth);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        ethRecyclerView.setAdapter(ethAdapter);
        ethRecyclerView.setLayoutManager(layoutManager);

        //concatenar e dar valor na tela da activity
        precoCompraSugeridoEditText.setText("653,99");
        precoVendaSugeridoEditText.setText("653,99");
        quantidadeDisponivelNegociacaoTextView.setText("ETHEREUM DISPONÍVEL:" + "0.012" + "ETH");
        saldoDisponivelTextView.setText("SALDO DISPONÍVEL: R$" + "35,75");

    }
}
