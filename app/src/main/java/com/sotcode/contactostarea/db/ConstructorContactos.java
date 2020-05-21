package com.sotcode.contactostarea.db;

import android.content.ContentValues;
import android.content.Context;

import com.sotcode.contactostarea.R;
import com.sotcode.contactostarea.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorContactos(Context context){
        this.context=context;
    }
    public ArrayList<Contacto> obtenerDatos(){
        /* ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.editar_calabera,"rene alberto","451254","rene@gmail.com", 4));
        contactos.add(new Contacto(R.drawable.computer,"jose mari","451784548","jose@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.mought,"andrea picazo","47845254","andrea@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.pizza,"ruben dario","458545854","ruben@gmail.com", 20));
        contactos.add(new Contacto(R.drawable.editar_choper,"esteban arze ","478551254","esteba@gmail.com", 515));
       return contactos;*/
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return  db.obtenerTodosLosContactos();
    }
    public void insertarTresContactos ( BaseDatos db ){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "rene alberto");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "65167018");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "rene.mamani.sto@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.editar_choper);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "anai salgado");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "78569586");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "ancode@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.editar_calabera);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "jose paredes");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "67856978");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "jose_puto@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.pizza);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "joaquin mendosa");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "7856985");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "chapo_gusman@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.pizza);
        db.insertarContacto(contentValues);
    }
    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES , LIKE);
        db.insertarlikecontactos(contentValues);
    }
    public int obtenerLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerLikesContacto(contacto);
    }
}
