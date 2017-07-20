package dao;

import util.Items;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 69099 on 2017/3/15.
 */
public class test {
    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        Items item = new Items();
        item.setName("iphone");
        item.setCity("Taibei");
        item.setPrice(5000);
        item.setNumber(3000);
        item.setPicture("010.jpg");
        //dao.addItems(item);
        //dao.delItems(11);
        item.setName("iphone1");
        item.setCity("Taibei1");
        item.setPrice(5000);
        item.setNumber(30010);
        item.setPicture("011.jpg");
        item.setId(12);
        //dao.updateItems(item);

        List<Items> itemsList = new ArrayList<Items>();
        /*itemsList = dao.query();
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println(itemsList.get(i).getId() + " " + itemsList.get(i).getName() + " " + itemsList.get(i).getCity() + " "
                    + itemsList.get(i).getPrice() + " " + itemsList.get(i).getNumber() + " " +
                    itemsList.get(i).getPicture());
        }*/
        //item = dao.get(1);
        //System.out.println(item.toString());
        String li = "7";
        itemsList = dao.getList(li);
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println(itemsList.get(i).getId() + " " + itemsList.get(i).getName());
        }
    }
}
