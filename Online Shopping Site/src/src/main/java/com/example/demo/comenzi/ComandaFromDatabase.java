package com.example.demo.comenzi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaFromDatabase {
    private static final String url="jdbc:mysql://localhost:3306/onlineshop?serverTimezone=UTC&user=root&password=btsbts43";
    public List<Comanda> vizualizareComenzi() throws SQLException {
        List<Comanda> listac =new ArrayList<Comanda>();
        Connection con= DriverManager.getConnection(url);
        String sql="select * from comenzi";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            Comanda c=new Comanda();
            c.setId(rs.getLong("id"));
            c.setData(rs.getDate("date"));
            c.setIdClient(rs.getInt("idclient"));
            c.setTotalValue(rs.getInt("total_value"));
            listac.add(c);
        }
        rs.close();
        st.close();
        con.close();
        return listac;
    }
    public List<Comanda> vizualizareComenziClient(Long id) throws SQLException {
        List<Comanda> listac =new ArrayList<Comanda>();
        Connection con= DriverManager.getConnection(url);
        String sql="select * from comenzi where idclient="+id+";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            Comanda c=new Comanda();
            c.setId(rs.getLong("id"));
            c.setData(rs.getDate("date"));
            c.setIdClient(rs.getInt("idclient"));
            c.setTotalValue(rs.getInt("total_value"));
            listac.add(c);
        }
        rs.close();
        st.close();
        con.close();
        return listac;
    }
}
