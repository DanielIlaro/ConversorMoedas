package br.com.alphaaquilae.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.alphaaquilae.conversormoedas.functionalites.Conversion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private String formattingDisplayedDouble = "%.2f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editReal = findViewById(R.id.edit_real);
        this.mViewHolder.textDolla = findViewById(R.id.text_valor_dollar);
        this.mViewHolder.textEuro = findViewById(R.id.text_valor_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        double value;

        if (this.mViewHolder.editReal.getText().toString().equals("")){
             value = 0.0;
             Toast.makeText(this, "Por favor, digite um valor",
                            Toast.LENGTH_SHORT).show();
        }

        else {
             value = Double.valueOf(this.mViewHolder.editReal.getText().toString());
        }

        Conversion dollar = new Conversion("dollar", value);
        Conversion euro = new Conversion("euro", value);

        switch (id) {
            case R.id.button_calculate:
                this.mViewHolder.textDolla.setText(String.format(formattingDisplayedDouble,
                                                                 dollar.getConversionValue()));
                this.mViewHolder.textEuro.setText(String.format(formattingDisplayedDouble,
                                                                euro.getConversionValue()));
                break;

            default:
                this.mViewHolder.textDolla.setText("");
                this.mViewHolder.textEuro.setText("");
        }
    }

    private static class ViewHolder {
        EditText editReal;
        TextView textDolla;
        TextView textEuro;
        Button buttonCalculate;
    }
}
