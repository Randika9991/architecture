package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO{
    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean save(OrderDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",customerDTO.getOrderId(),customerDTO.getOrderDate(),customerDTO.getCustomerId());

    }

    @Override
    public boolean update(OrderDTO customerDTO) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public String genarateid() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.crudUtil("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";

    }

    @Override
    public boolean existId(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.crudUtil("SELECT oid FROM `Orders` WHERE oid=?",id);
        return rst.next();
    }

    @Override
    public ArrayList<OrderDTO> findId(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }
}
