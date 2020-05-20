package com.sotcode.contactostarea.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sotcode.contactostarea.pojo.Contacto;
import com.sotcode.contactostarea.DetalleContacto;
import com.sotcode.contactostarea.R;

import java.util.ArrayList;

public class ContactoAdapter  extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{
    @NonNull
    ArrayList<Contacto> contactos;
    Activity activity;
    public ContactoAdapter(ArrayList<Contacto> contactos, Activity activity){
        this.contactos=contactos;
        this.activity=activity;
    }
    //iniciamos un coleccion de contactos y lo llamamos contactos
    @Override  //infla el layout y lo pasara al viewholder para que el obtenga los views
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);//esto solamente captura el cad view y lo trae

        return  new ContactoViewHolder(v);
    }

    @Override  //asocia cada elemento de la lista con cada view
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
             final Contacto contacto = contactos.get(position);
             contactoViewHolder.imgfotocv.setImageResource(contacto.getFoto());
             contactoViewHolder.tvnombrecv.setText(contacto.getNombre());
             contactoViewHolder.tvtelefoocv.setText(contacto.getTelefono());
             contactoViewHolder.imgfotocv.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_SHORT).show();
                     Intent intent= new Intent(activity, DetalleContacto.class);
                     intent.putExtra("nombre",contacto.getNombre());
                     intent.putExtra("telefono",contacto.getNombre());
                     intent.putExtra("email",contacto.getNombre());
                     activity.startActivity(intent);
                 }
             });

             contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Toast.makeText(activity,"diste calabera a "+contacto.getNombre(),Toast.LENGTH_SHORT).show();
                 }
             });
    }

    @Override
    public int getItemCount() {                     //aqui estan la cantidad de elementos que tiene mi lista
        return contactos.size();                  //debolvemos el tamaño del arraylist creado
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView  imgfotocv;              //creamos objetos del tipo en este caso imageview para aqui almacenar los view del archivo xml
        private TextView  tvnombrecv;
        private TextView tvtelefoocv;
        private ImageButton btnLike;
        public ContactoViewHolder(@NonNull View itemView) {               //este metodo nos ayuda a castear los views y recivew como parametro un view
            super(itemView);                      //este es un metod osobreescrito por lo que la variable que recibe como parametro lo tomamos de los views para convertilos en objetos en este pojo
            imgfotocv     =(ImageView) itemView.findViewById(R.id.img_fotocv);       //castear en la varible creada vamos a almacenar el view casteado es decir convertido en objeto
            tvnombrecv    =(TextView) itemView.findViewById(R.id.tv_nombrecv);
            tvtelefoocv   =(TextView) itemView.findViewById(R.id.tv_telefonocv);
            btnLike       =(ImageButton) itemView.findViewById(R.id.btn_like);
         }
    }
}
