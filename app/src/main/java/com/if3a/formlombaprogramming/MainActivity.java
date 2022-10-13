package com.if3a.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText etnama, etnowhatsapp, etalamat, etpassword, etpin;
    private RadioGroup rgjeniskelamin;
    private RadioButton rbjeniskelamin;
    private Button btndaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.et_nama);
        etnowhatsapp = findViewById(R.id.et_no_whatsapp);
        etalamat = findViewById(R.id.et_alamat);
        etpassword = findViewById(R.id.et_password);
        etpin = findViewById(R.id.et_pin);
        rgjeniskelamin = findViewById(R.id.rg_jk);
        btndaftar =  findViewById(R.id.btn_daftar);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama= etnama.getText().toString();
                String nowhatsapp = etnowhatsapp.getText().toString();
                String alamat = etalamat.getText().toString();
                String password = etpassword.getText().toString();
                String pin =  etpin.getText().toString();

                int jeniskelaminId= rgjeniskelamin.getCheckedRadioButtonId();
                rbjeniskelamin = findViewById(jeniskelaminId);

                String jeniskelamin = rbjeniskelamin.getText().toString();

                if(nama.trim().isEmpty()){
                    etnama.setError("Nama tidak boleh kosong");

                } else if (nowhatsapp.trim().isEmpty()) {
                    etnowhatsapp.setError("No Whatsapp tidak boleh kosong");

                } else if (alamat.trim().isEmpty()) {
                    etalamat.setError("Alamat tidak boleh kosong");

                } else if (password.trim().isEmpty()) {
                    etpassword.setError("Password tidak boleh kosong");

                } else if (pin.trim().isEmpty()) {
                    etpin.setError("Pin tidak boleh kosong");

                } else {
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("varNama", nama);
                    intent.putExtra("varNoWhatsapp", nowhatsapp);
                    intent.putExtra("varAlamat", alamat);
                    intent.putExtra("varPassword", password);
                    intent.putExtra("varJK", jeniskelamin);
                    intent.putExtra("varPin", pin);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etnama.setText("");
        etnowhatsapp.setText("");
        etalamat.setText("");
        etpassword.setText("");
        etpin.setText("");

    }
}