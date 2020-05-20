package com.sotcode.contactostarea.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sotcode.contactostarea.R;
import com.sotcode.contactostarea.adapter.ContactoAdapter;
import com.sotcode.contactostarea.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Contacto> contactos;
    private RecyclerView listacontactos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listacontactos=(RecyclerView) v.findViewById(R.id.reciclerview_contactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); //esto lo que hace que se muestre como una linea o lista podria mostrarse como un grid es es solo configurarlo
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listacontactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
    public ContactoAdapter adapter;
    private void inicializarAdaptador(){
        adapter=new ContactoAdapter(contactos,getActivity());
        listacontactos.setAdapter(adapter);
    }
    public void inicializarListaContactos(){
        contactos=new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.editar_calabera,"rene alberto","451254","rene@gmail.com"));
        contactos.add(new Contacto(R.drawable.computer,"jose mari","451784548","jose@gmail.com"));
        contactos.add(new Contacto(R.drawable.mought,"andrea picazo","47845254","andrea@gmail.com"));
        contactos.add(new Contacto(R.drawable.pizza,"ruben dario","458545854","ruben@gmail.com"));
        contactos.add(new Contacto(R.drawable.editar_choper,"esteban arze ","478551254","esteba@gmail.com"));

    }
}
