package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conector.Conector;

import model.Req1;
import model.Req2;
import model.Req3;

public class Controller {

    private ArrayList<String> req1s;
    private ArrayList<String> req2s;
    private ArrayList<String> req3s;
    
    private Conector conectorDB;

    public Controller(String url) {
        super();
        this.req1s = new ArrayList<>();
        this.req2s = new ArrayList<>();
        this.req3s = new ArrayList<>();
        conectorDB = new Conector(url); 
    }

    

    public ArrayList<String> getReq1s() {
        return req1s;
    }



    public void setReq1s(ArrayList<String> req1s) {
        this.req1s = req1s;
    }



    public ArrayList<String> getReq2s() {
        return req2s;
    }



    public void setReq2s(ArrayList<String> req2s) {
        this.req2s = req2s;
    }



    public ArrayList<String> getReq3s() {
        return req3s;
    }



    public void setReq3s(ArrayList<String> req3s) {
        this.req3s = req3s;
    }



    public void req1() {
        ResultSet rs = conectorDB.getReq1DB();
        try {
            while (rs.next()) {
                Req1 req1 =  new Req1(rs.getInt("total"), rs.getInt("ID_Proyecto"), rs.getString("pagado") ,rs.getString("Proveedor"));
                req1s.add(req1.toString());
            }
        } catch (SQLException e) {
            System.out.println("ruta del error");
            e.printStackTrace();
        }
        
    }
    
    public void req2() {
        ResultSet rs = conectorDB.getReq2DB();
        try{
            while (rs.next()) {
                Req2 req2 = new Req2(rs.getString("Inicio"), rs.getInt("financiable"), rs.getInt("estrato"), rs.getDouble("Proyecto.Porcentaje_Cuota_Inicial * 100"));
                req2s.add(req2.toString());
                
            }
        }catch (SQLException e){
            System.out.println("ruta del error");
            e.printStackTrace();
        }
    }

    public void req3() {
        ResultSet rs = conectorDB.getReq3DB();
        try{
            while (rs.next()) {
                Req3 req3 = new Req3(rs.getInt("ID_Proyecto"), rs.getString("pagado"), rs.getString("clasificacion"));
                req3s.add(req3.toString());
                
            }
        }catch (SQLException e){
            System.out.println("ruta del error");
            e.printStackTrace();
        }
    }

}