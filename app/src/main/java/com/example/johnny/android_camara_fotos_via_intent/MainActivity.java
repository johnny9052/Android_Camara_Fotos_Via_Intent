package com.example.johnny.android_camara_fotos_via_intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    /*RECORDAR COLOCAR EL PERMISO NECESARIO EN EL MANIFIEST*/

    /*Imagen*/
    private ImageView imagen;
    /*Campo de texto*/
    private EditText txtNombreImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Referencia de los elementos visuales*/
        imagen = (ImageView) findViewById(R.id.imageView);
        txtNombreImagen = (EditText) findViewById(R.id.txtNombreImagen);
    }


    public void tomarFoto(View v) {
        /*Definimos un intent para abrir la activity de fotografias*/
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        /*Definimos un file donde se creara el archivo (El parametro recibe el directorio donde se
        va a crear (Musica, Ringtones, etc.), si se manda null se deja en la raiz) ---- Nombre del archivo a crear*/
        /*OJOOOO, esto no es la micro sd, es el archivo que se crean en la carpeta Android con el
        * nombre del paquete del proyecto, ahi quedan todas las fotos*/
        File foto = new File(getExternalFilesDir(null), txtNombreImagen.getText().toString());
        /*Se añade (Permiso para almacenar  --- el archivo que contendra la foto)*/
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
        /*Se inicia la actitity*/
        startActivity(intent);
    }

    public void recuperarFoto(View v) {
        /*Recuperamos la imagen, mandano la ruta (recordar el NULL es porque no es un directorio
        en especifico, solo la raiz del proyecto en la carpeta android ---- y el nombre del archivo)*/
        Bitmap bitmap1 = BitmapFactory.decodeFile(getExternalFilesDir(null) + "/" + txtNombreImagen.getText().toString());
        /*Se añade la foto al imageView*/
        imagen.setImageBitmap(bitmap1);
    }

}
