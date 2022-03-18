package br.edu.unis.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtMassa;
    EditText edtAltura;
    Button btnCalcular;
    TextView txtIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loadWidgets();
    }

    private void loadWidgets() {
        this.edtMassa = findViewById(R.id.edtMassa);
        this.edtAltura = findViewById(R.id.edtAltura);
        this.btnCalcular = findViewById(R.id.btnCalcular);
        this.btnCalcular.setOnClickListener(this);
        this.txtIMC = findViewById(R.id.txtIMC);
    }

    @Override
    public void onClick(View view) {
        float altura = Float.parseFloat(this.edtAltura.getText().toString());
        float massa = Float.parseFloat(this.edtMassa.getText().toString());
        float imc = this.calculaIMC(altura, massa);
        String classificacao = this.classificaIMC(imc);
        this.exibeClassificacao(classificacao);
        this.limpaCampos();
    }

    private float calculaIMC(float altura, float massa) {
        return massa / (altura * altura);
    }

    private String classificaIMC(float imc) {
        String classificacao;
        if (imc < 16) {
            classificacao = "Magreza grave";
        } else if (imc >=16 && imc < 17) {
            classificacao = "Magreza moderada";
        } else if (imc >=17 && imc < 18.5) {
            classificacao = "Magreza leve";
        } else if (imc >=18.5 && imc < 25) {
            classificacao = "Saudável";
        } else if (imc >=25 && imc < 30) {
            classificacao = "Sobrepeso";
        } else if (imc >=30 && imc < 35) {
            classificacao = "Obesidade Grau I";
        } else if (imc >=35 && imc < 40) {
            classificacao = "Obesidade Grau II";
        } else {
            classificacao = "Obesidade Grau IIII (mórbida)";
        }
        return classificacao;
    }

    private void exibeClassificacao(String classificacao) {
        txtIMC.setText(classificacao);
    }

    private void limpaCampos() {
        this.edtMassa.setText("");
        this.edtAltura.setText("");
        this.edtMassa.requestFocus();
    }
}