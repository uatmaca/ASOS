package com.asos.database;

import org.json.JSONObject;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by Umut on 15.4.2016.
 */
public class JDBCUtil {

    Connection connection;

    public String getLastSignalGreenHouse(Long greenHouseId){

        JSONObject jsonObject = new JSONObject();

        String query = "SELECT * FROM rasp_pi_signal r where greenHouseId = " + greenHouseId + " ORDER BY SIGNAL_ID DESC LIMIT 1";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/asos", "root", "root");
        }catch (SQLException sql){
            System.out.println("getLastSignalGreenHouse SQLException 1");
            sql.printStackTrace();
        }catch (ClassNotFoundException c){
            System.out.println("getLastSignalGreenHouse ClassNotFoundException");
            c.printStackTrace();
        }

        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                jsonObject.put("signal_id", rs.getString("SIGNAL_ID"));
                jsonObject.put("heating_signal", rs.getString("HEATING_SIGNAL"));
                jsonObject.put("ventilation_signal", rs.getString("VENTILATION_SIGNAL"));
                jsonObject.put("watering_signal", rs.getString("WATERING_SIGNAL"));
                jsonObject.put("roof_signal", rs.getString("ROOF_SIGNAL"));
                break;
            }
            connection.close();
        }catch (SQLException sql){
            System.out.println("getLastSignalGreenHouse SQLException 2");
            sql.printStackTrace();
        }
        return jsonObject.toString();

    }

    public boolean setGreenHouseTemperature(String greenHouseId, String temperatureInfo){

        JSONObject jsonObject = new JSONObject();

        String query = "INSERT INTO `asos`.`temperature_info` (`TEMPERATURE_VALUE`, `greenHouseId`) VALUES ('" + temperatureInfo + "', '" + greenHouseId + "');\n";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/asos", "root", "root");
        }catch (SQLException sql){
            System.out.println("setGreenHouseTemperature SQLException 1");
            sql.printStackTrace();
        }catch (ClassNotFoundException c){
            System.out.println("setGreenHouseTemperature ClassNotFoundeException 1");
            c.printStackTrace();
        }

        try {
            boolean process = connection.createStatement().execute(query);
            connection.close();
            return process;
        }catch (SQLException sql){
            System.out.println("setGreenHouseTemperature SQLException 2");
            sql.printStackTrace();
        }

        return false;
    }

    public boolean setGreenHouseDump(String greenHouseId, String dumpInfo){

        JSONObject jsonObject = new JSONObject();

        String query = "INSERT INTO `asos`.`dump_info` (`DUMP_RATE`, `greenHouseId`) VALUES ('" + dumpInfo + "', '" + greenHouseId + "');\n";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/asos", "root", "root");
        }catch (SQLException sql){
            System.out.println("setGreenHouseDump SQLException 1");
            sql.printStackTrace();
        }catch (ClassNotFoundException c){
            System.out.println("setGreenHouseDump ClassNotFoundException 1");
            c.printStackTrace();
        }

        try {
            boolean process = connection.createStatement().execute(query);
            connection.close();
            return process;
        }catch (SQLException sql){
            System.out.println("setGreenHouseDump SQLException 2");
            sql.printStackTrace();
        }

        return false;
    }


    public String veri(){
        String query = "SELECT * FROM users";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/asos", "root", "root");
        }catch (SQLException sql){
            sql.printStackTrace();
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }

        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                return rs.getString("name");
            }

        }catch (SQLException sql){
            sql.printStackTrace();
        }
        return "Bos";
    }
}
