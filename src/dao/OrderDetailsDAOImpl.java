package dao;

import db.DBConnection;
import model.OrderDetailDTO;
import view.tdm.OrderDetailTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO{
//    public boolean saveOrderDetail(String orderId, OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
//
//        return SQLUtil.crudUtil("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", orderId, detail.getItemCode(), detail.getUnitPrice(), detail.getQty());
//    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean save(OrderDetailDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", customerDTO.getOrderID(), customerDTO.getItemCode(), customerDTO.getUnitPrice(), customerDTO.getQty());
    }

    @Override
    public boolean update(OrderDetailDTO customerDTO) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public String genarateid() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean existId(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public ArrayList<OrderDetailDTO> findId(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }
}
