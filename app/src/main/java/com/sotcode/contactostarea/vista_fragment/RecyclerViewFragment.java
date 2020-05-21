package com.sotcode.contactostarea.vista_fragment;

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
import com.sotcode.contactostarea.presentador.IRecyclerViewFragmentPresentador;
import com.sotcode.contactostarea.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    ArrayList<Contacto> contactos;
    private RecyclerView listacontactos;
    private IRecyclerViewFragmentPresentador presentador;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_recyclerview,container,false);
           listacontactos=(RecyclerView) v.findViewById(R.id.reciclerview_contactos);
           presentador = new RecyclerViewFragmentPresentador(this, getContext()) ;
        return v;
    }
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); //esto lo que hace que se muestre como una linea o lista podria mostrarse como un grid es es solo configurarlo
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listacontactos.setLayoutManager(llm);
    }
    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdapter adapter;
         adapter=new ContactoAdapter(contactos,getActivity());
        return adapter;
    }
    @Override
    public void inicializarAdaptadorRv(ContactoAdapter adapter) {
        listacontactos.setAdapter(adapter);
    }
}
