package rafaelparenza.com.criptomoeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import rafaelparenza.com.criptomoeda.adapter.BtcAdapter;
import rafaelparenza.com.criptomoeda.data.Ordens;
import rafaelparenza.com.criptomoeda.data.BtcDatasourceHelper;

public class VerDetalhesBtcActivity extends AppCompatActivity {

    private RecyclerView btcRecyclerView;
    private List<Ordens> datasourceOrdens;
    private BtcAdapter btcAdapter;

    private EditText precoCompraSugeridoEditText;
    private EditText precoVendaSugeridoEditText;
    private TextView quantidadeDisponivelNegociacaoTextView;
    private TextView saldoDisponivelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalhes_btc);

        //buscar referencias
        btcRecyclerView = findViewById(R.id.activity_principal_recycler_view_ordensBTC);
        precoCompraSugeridoEditText = findViewById(R.id.activity_verBTC_preco_comprar);
        precoVendaSugeridoEditText = findViewById(R.id.activity_verBTC_preco_vender);
        quantidadeDisponivelNegociacaoTextView = findViewById(R.id.activity_verBTC_quantidade_disponivel);
        saldoDisponivelTextView = findViewById(R.id.activity_verBTC_saldo_disponivel);


        BtcDatasourceHelper helper = new BtcDatasourceHelper();
        datasourceOrdens = helper.getDatasourceBtc();

        btcAdapter = new BtcAdapter(datasourceOrdens);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        btcRecyclerView.setAdapter(btcAdapter);
        btcRecyclerView.setLayoutManager(layoutManager);

        //concatenar e dar valor na tela da activity
        precoCompraSugeridoEditText.setText("22.020,03");
        precoVendaSugeridoEditText.setText("23.110,67");
        quantidadeDisponivelNegociacaoTextView.setText("BITCOIN DISPONÍVEL:" + "0.00236500" + "BTC");
        saldoDisponivelTextView.setText("SALDO DISPONÍVEL: R$" + "35,75");

    }
}
