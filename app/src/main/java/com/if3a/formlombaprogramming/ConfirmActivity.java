package com.if3a.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    TextView tvnama, tvjk, tvnowhatsapp, tvalamat, tvtanggal;
    Button btntanggal, btnkonfirmasi;

    String nama, jk, nowhatsapp, alamat, choosendate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvnama = findViewById(R.id.tv_nama);
        tvjk = findViewById(R.id.tv_jk);
        tvnowhatsapp = findViewById(R.id.tv_no_whatsapp);
        tvalamat = findViewById(R.id.tv_alamat);
        tvtanggal = findViewById(R.id.tv_tanggal);
        btntanggal = findViewById(R.id.btn_tanggal);
        btnkonfirmasi = findViewById(R.id.btn_konfirmasi);

        //ambil intent yang dikirim oleg MainActivity
        Intent terima = getIntent();

        nama = terima.getStringExtra("varNama");
        jk = terima.getStringExtra("varJK");
        nowhatsapp = terima.getStringExtra("varNoWhatsapp");
        alamat= terima.getStringExtra("varAlamat");
        //set variable

        tvnama.setText(nama);
        tvjk.setText(jk);
        tvnowhatsapp.setText(nowhatsapp);
        tvalamat.setText(alamat);

        btntanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalender = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String hari = Integer.toString(dayofmonth);
                        choosendate = hari + " / " + bulan + " / " + tahun;
                        tvtanggal.setText(choosendate);
                    }
                }, newCalender.get(Calendar.YEAR),newCalender.get(Calendar.MONTH),newCalender.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btnkonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog= new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data anda sudah benar ?");
                //button positive
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ConfirmActivity.this,"Terima Kasih, Pendaftaran anda telah berhasil", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                });

                //button negative
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });

                // tampilkan dialog
                dialog.show();

            }

        });


    }
}