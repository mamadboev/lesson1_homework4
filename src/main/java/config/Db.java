package config;

import models.Product;

import java.sql.*;

public class Db {
    private String url ="jdbc:postgresql://localhost:5432/computer_db";
    private String db_user = "db_user";
    private String db_pass = "db_pass";

    public void addProduct(Product product){
        try {
            Connection connection = DriverManager.getConnection(url,db_user,db_pass);
            Statement statement = connection.createStatement();
            String query = "select model from product where model='"+product.getModel()+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                System.out.println("Product already exists with "+ product.getModel()+" model");
            }else{
                String sql = "insert into product(maker,model,type) values(?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, product.getMaker());
                preparedStatement.setString(2, String.valueOf(product.getModel()));
                preparedStatement.setString(3, product.getType());
                preparedStatement.executeUpdate();
                System.out.println("Product added");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getList(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,db_user,db_pass);
            Statement statement = connection.createStatement();
            String query = "select * from product";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String maker = resultSet.getString(1);
                int model = resultSet.getInt(2);
                String type = resultSet.getString(3);
                Product product = new Product(maker, model, type);
                System.out.println(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}