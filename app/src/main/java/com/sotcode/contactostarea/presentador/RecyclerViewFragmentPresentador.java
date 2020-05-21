package com.sotcode.contactostarea.presentador;

import android.content.Context;

import com.sotcode.contactostarea.adapter.ContactoAdapter;
import com.sotcode.contactostarea.db.ConstructorContactos;
import com.sotcode.contactostarea.pojo.Contacto;
import com.sotcode.contactostarea.vista_fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresentador {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ArrayList<Contacto> contactos;
    private ConstructorContactos constructorContactos;
    public RecyclerViewFragmentPresentador(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
            this.iRecyclerViewFragmentView= iRecyclerViewFragmentView;
            this.context=context;
            obtenerContactoBaseDatos();
    }

    @Override
    public void obtenerContactoBaseDatos() {
        constructorContactos= new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRv(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
