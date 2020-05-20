package com.sotcode.contactostarea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {
    private TextView tvnombre;
    private TextView tvtelefono;
    private TextView tvemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros  = getIntent().getExtras();
        String nombre      = parametros.getString("nombre");
        String telefono    = parametros.getString("telefono");
        String email       = parametros.getString("email");
        tvnombre = (TextView) findViewById(R.id.tvnombre);
        tvtelefono = (TextView) findViewById(R.id.tvtelefono);
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvnombre.setText(nombre);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
    }
    public void llamar(View v) {
        String phone = tvtelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));

    }
    public void enviaremail(View v){
        String email =tvemail.getText().toString();
        Intent emailintent= new Intent((Intent.ACTION_SEND));
        emailintent.setData(Uri.parse("mailto:"));
        emailintent.putExtra(Intent.EXTRA_EMAIL,email);
        emailintent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailintent,"email"));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
