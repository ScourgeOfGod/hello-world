package dao;

import util.Items;
import util.db_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 69099 on 2017/3/15.
 */
public class DAO {

    public void addItems(Items item) throws SQLException {
        Connection con = db_Connection.getConnection();
        String sql = "INSERT INTO shopping.items(name, city, price, number, picture) VALUES (?,?,?,?,?)  ";
        PreparedStatement pmpt = con.prepareStatement(sql);
        pmpt.setString(1,item.getName());
        pmpt.setString(2,item.getCity());
        pmpt.setInt(3,item.getPrice());
        pmpt.setInt(4,item.getNumber());
        pmpt.setString(5,item.getPicture());
        pmpt.execute();
    }

    public void delItems(int id) throws SQLException {
        Connection con = db_Connection.getConnection();
        String sql = "DELETE FROM shopping.items WHERE id=?";
        PreparedStatement pmpt = con.prepareStatement(sql);
        pmpt.setInt(1,id);
        pmpt.execute();
    }

    public void updateItems(Items item) throws SQLException {
        Connection con = db_Connection.getConnection();
        String sql = "UPDATE shopping.items SET " +
                "name=?,city=?,price=?,number=?,picture=? WHERE id=?";
        PreparedStatement pmpt = con.prepareStatement(sql);
        pmpt.setString(1,item.getName());
        pmpt.setString(2,item.getCity());
        pmpt.setInt(3,item.getPrice());
        pmpt.setInt(4,item.getNumber());
        pmpt.setString(5,item.getPicture());
        pmpt.setInt(6,item.getId());
        pmpt.execute();
    }

    public List<Items> query() throws SQLException {
        try {
            Connection con = db_Connection.getConnection();
            Items item = null;
            List<Items> itemsList = new ArrayList<Items>();
            String sql = "SELECT * FROM shopping.items";
            PreparedStatement ptmt = con.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()){
                item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setPrice(rs.getInt("price"));
                item.setNumber(rs.getInt("number"));
                item.setPicture(rs.getString("picture"));

                itemsList.add(item);
            }

            return itemsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Items get(int id) throws SQLException {
        Items item = null;
        Connection con = db_Connection.getConnection();
        String sql = "SELECT * FROM shopping.items WHERE id = ?";
        PreparedStatement pmpt = con.prepareStatement(sql);
        pmpt.setInt(1,id);
        ResultSet rs = pmpt.executeQuery();
        while (rs.next()){
            item = new Items();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setCity(rs.getString("city"));
            item.setPrice(rs.getInt("price"));
            item.setNumber(rs.getInt("number"));
            item.setPicture(rs.getString("picture"));
        }
        return item;
    }

    public List<Items> getList(String list) throws SQLException {
        List<Items> itemsList = new ArrayList<Items>();
        int count = 5;
        DAO dao = new DAO();
        Items item = null;
        if(list!=null&&list.length()>0){
            String[] arr = list.split(",");
            if(arr.length>=5){
                for (int i = arr.length-2; i >= arr.length-count-1 ; i--) {
                    itemsList.add(dao.get(Integer.parseInt(arr[i]))) ;
                }
            }else{
                for (int i = arr.length-2; i >= 0 ; i--) {
                    itemsList.add(dao.get(Integer.parseInt(arr[i]))) ;
                }
            }
        }

        return itemsList;
    }

}
