package views;
import java.awt.*;


import javax.swing.*;
import java.util.ArrayList;
import Controller.Controller;


public class View extends JFrame{

    
    private PanelBotones panelBotones;
    private PanelLista panelLista;
    private Controller control;

    public View(String url) {
        super();
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panelBotones = new PanelBotones(this);
        panelLista = new PanelLista(this);

        control = new Controller(url);
        
        

        add(panelLista, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

    }


        public void updateList1(){
            control.req1();
            req1(control.getReq1s());
        }

        public void req1(ArrayList<String> listaReq1) {
            
            String[] listado = new String[listaReq1.size()];
            for (int i = 0; i < listado.length; i++) {
                listado[i] = listaReq1.get(i);
            }
            panelLista.updateLista(listado);
        }
        
        public void updateList2(){
            control.req2();
            req1(control.getReq2s());
        }

        public void req2(ArrayList<String> listaReq2) {
            
            String[] listado = new String[listaReq2.size()];
            for (int i = 0; i < listado.length; i++) {
                listado[i] = listaReq2.get(i);
            }
            panelLista.updateLista(listado);
        }
        
        public void updateList3(){
            control.req3();
            req1(control.getReq3s());
        }

        public void req3(ArrayList<String> listaReq3) {
            
            String[] listado = new String[listaReq3.size()];
            for (int i = 0; i < listado.length; i++) {
                listado[i] = listaReq3.get(i);
            }
            panelLista.updateLista(listado);
        }
}
