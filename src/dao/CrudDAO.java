package dao;

import model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T,t>{
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(T customerDTO) throws SQLException, ClassNotFoundException ;

    public boolean update(T customerDTO) throws SQLException, ClassNotFoundException ;

    public boolean delete (t id) throws SQLException, ClassNotFoundException ;

    public String genarateid() throws SQLException, ClassNotFoundException ;

    public boolean existId(t id) throws SQLException, ClassNotFoundException ;

    public ArrayList<T> findId(t id) throws SQLException, ClassNotFoundException ;
}
