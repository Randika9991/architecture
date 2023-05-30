package dao;

import db.DBConnection;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{

    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<ItemDTO> allItem = new ArrayList<>();
        ResultSet rst = SQLUtil.crudUtil("SELECT * FROM Item");
        while (rst.next()){

            ItemDTO itemDTO = new ItemDTO(rst.getString(1),rst.getString(2),rst.getBigDecimal(4),rst.getInt(3));
            allItem.add(itemDTO);
        }
        return allItem;
    }

    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.crudUtil("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
    }


    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.crudUtil("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(), itemDTO.getCode());

    }

    public boolean delete(String code) throws SQLException, ClassNotFoundException {

        return SQLUtil.crudUtil("DELETE FROM Item WHERE code=?", code);
    }

    public String genarateid() throws SQLException, ClassNotFoundException {

       ResultSet rst =  SQLUtil.crudUtil("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public ArrayList<ItemDTO> findId(String code) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.crudUtil("SELECT * FROM Item WHERE code=?", code);
        ArrayList<ItemDTO> findIdItem = new ArrayList<>();
        while (rst.next()) {

            ItemDTO itemDTO = new ItemDTO(code + "", rst.getString(2),rst.getBigDecimal(3), rst.getInt(4));
            findIdItem.add(itemDTO);
        }
        return findIdItem;
    }

    public boolean existId(String code) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.crudUtil("SELECT code FROM Item WHERE code=?", code);
        while (rst.next()) {
           return true;
        }
        return false;
    }
}
