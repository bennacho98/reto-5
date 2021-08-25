package views;

import javax.swing.*;
import java.awt.*;

public class PanelLista extends JPanel{

    private JList<String> listaReqs;

    private View vista;

    public PanelLista(View v) {
        super();
        setLayout(new GridLayout());
        vista = v;

        listaReqs = new JList<>();

        add(listaReqs);

       }

    public void updateLista(String[] listado) {
        listaReqs.setListData(listado);
    }

}

        

    
