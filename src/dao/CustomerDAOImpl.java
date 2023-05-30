package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{

    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.crudUtil("SELECT * FROM Customer");

        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
       while (rst.next()) {
           CustomerDTO customerDTO = new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }


    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.crudUtil("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());

    }

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.crudUtil("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());

    }

    public boolean delete (String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.crudUtil("DELETE FROM Customer WHERE id=?", id);

    }

    public String genarateid() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.crudUtil("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public boolean existId(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.crudUtil("SELECT id FROM Customer WHERE id=?", id);
        if (rst.next()) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<CustomerDTO> findId(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.crudUtil("SELECT * FROM Customer WHERE id=?",id);
        ArrayList<CustomerDTO> findIdCustomer = new ArrayList<>();

        while (rst.next()) {

            CustomerDTO customerDTO = new CustomerDTO(id + "", rst.getString(2), rst.getString(3));
            findIdCustomer.add(customerDTO);
        }

        return findIdCustomer;

    }
}
