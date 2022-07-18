package com.example.alertsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.Map;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class geraralerta extends AppCompatActivity {

    Spinner campus, tipo, bloco, andar, sala;
    Button btn;
    EditText msg;
    Boolean digitou;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geraralerta);

        Spinner spinner = (Spinner) findViewById(R.id.campus_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.campus_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner1 = (Spinner) findViewById(R.id.tipo_spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.tipo_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.bloco_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.bloco_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Spinner spinner3 = (Spinner) findViewById(R.id.andar_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.andar_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        Spinner spinner4 = (Spinner) findViewById(R.id.sala_spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.sala_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        campus = findViewById(R.id.campus_spinner);
        tipo = findViewById(R.id.tipo_spinner);
        bloco = findViewById(R.id.bloco_spinner);
        andar = findViewById(R.id.andar_spinner);
        sala = findViewById(R.id.sala_spinner);
        msg = findViewById(R.id.alerta_texto);

        btn = findViewById(R.id.btncriaral);



    }



    public void CAlert(View view) {

            String url = "http:// 10.0.0.153:80/site/CriarAlerta.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    response -> Toast.makeText(getApplicationContext(), "Alerta criado com sucesso", Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(getApplicationContext(), "Erro na ciação do alerta, tente novamente", Toast.LENGTH_LONG).show()) {
                //parametros do request

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("CampusSQL", campus.getSelectedItem().toString());
                    params.put("BlocoSQL", bloco.getSelectedItem().toString());
                    params.put("AndarSQL", andar.getSelectedItem().toString());
                    params.put("SalaSQL", sala.getSelectedItem().toString());
                    params.put("TipoSQL", tipo.getSelectedItem().toString());
                    params.put("MSGSQL", msg.getText().toString());

                    return params;

                }
            };

            requestQueue = Volley.newRequestQueue(geraralerta.this);
            requestQueue.add(stringRequest);
        }

    }










































































    //VerificarMensagem();
/*
        if(digitou){
        String xcampus= campus.getSelectedItem().toString();
        String xtipo= tipo.getSelectedItem().toString();
        String xbloco= bloco.getSelectedItem().toString();
        String xandar= andar.getSelectedItem().toString();
        String xsala= sala.getSelectedItem().toString();
        String xmsg= msg.getText().toString();

        CriarAlerta(xcampus, xbloco, xandar, xsala,xtipo, xmsg);
    }
                else {
        Toast.makeText(getApplicationContext(), "Campo de mensagem se encontra vazio", Toast.LENGTH_LONG).show();
    }

    public void CriarAlerta(final String S_campus, final String S_Bloco, final String S_Andar, final String S_Sala, final String S_Tipo, final String S_MSG){

        @SuppressLint("StaticFieldLeak")
        class CrierAlertClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                Toast.makeText(getApplicationContext(), "Enviando alerta", Toast.LENGTH_SHORT).show();
            }



        }

        CrierAlertClass crierAlertClass = new CrierAlertClass();

        crierAlertClass.execute(S_campus,S_Bloco,S_Andar,S_Sala,S_Tipo,S_MSG);
    }


    public void VerificarMensagem(){

        String xmsg= msg.getText().toString();

        if(TextUtils.isEmpty(xmsg) )
        {

            digitou = false;

        }
        else {

            digitou = true ;
        }

    }
}

*/
