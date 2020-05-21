package com.sotcode.contactostarea.vista_fragment;

import com.sotcode.contactostarea.adapter.ContactoAdapter;
import com.sotcode.contactostarea.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
public void generarLinearLayoutVertical();
public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos);
public void inicializarAdaptadorRv(ContactoAdapter adapter);
}
