package com.example.conversodemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscar a caixa de digitar o valor apartir da ID
        // EditText valor = findViewById(R.id.edit_Valor);
        //valor.getText();


        this.mViewHolder.editValue = findViewById(R.id.edit_Valor);
        this.mViewHolder.textDolar = findViewById(R.id.textDolar);
        this.mViewHolder.textEuro = findViewById(R.id.textEuro);
        this.mViewHolder.buttonCalculator = findViewById(R.id.buttonCalculate);

        this.mViewHolder.buttonCalculator.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalculate) {
            String value = this.mViewHolder.editValue.getText().toString();
            if (" ".equals(value)) {
                //Mostra mensgem pro usuario

                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText((String.format("%2f",(real/4))));
                this.mViewHolder.textEuro.setText(String.format("%2f",(real/5)));

            }
        }
    }

    private void clearValues(){
        this.mViewHolder.textEuro.setText(" ");
        this.mViewHolder.textDolar.setText(" ");
    }


    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculator;

    }
}
