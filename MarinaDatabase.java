import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MarinaDatabase {
    static final String DATABASE_URL = "jdbc:ucanaccess://C:/Users/ambergholson/Desktop/Marina.accdb";
    Connection connection = null;
    Statement statement = null;
    ResultSet rSet = null;
    PreparedStatement searchCustByName = null;
    PreparedStatement addNewCust = null;
    PreparedStatement addNewLease = null;
    PreparedStatement addNewPowerboat = null;
    PreparedStatement addNewSailboat = null;
    PreparedStatement addNewServiceRecord = null;
    DateFormat df = new SimpleDateFormat("MM/dd/yyy");

    public MarinaDatabase(){
        try{
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Made a connection to the database");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet searchCustByName(String fName, String lName) {
        try
        {
            searchCustByName = connection.prepareStatement(
                    "SELECT firstName, lastName, boatingLicense FROM Customer WHERE firstName = ? AND lastName = ?");

            searchCustByName.setString(1, fName);
            searchCustByName.setString(2, lName);

            rSet = searchCustByName.executeQuery();

            return rSet;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rSet;
        }
    }

    public void addNewCust(int license, String fName, String lName){
        try{
            addNewCust = connection.prepareStatement("INSERT INTO CUSTOMER(boatingLicense, firstName, lastName) VALUES(?, ?, ?)");

            addNewCust.setInt(1, license);
            addNewCust.setString(2, fName);
            addNewCust.setString(3, lName);

            System.out.println("Customer added!");
            addNewCust.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //TODO: double check types w/ db
    //TODO: ensure the Date gets inserted correctly
    public void addNewLease(int slotNum, double rate, int duration, String expirationDate, int slipNumber){
        try{
            addNewLease = connection.prepareStatement("INSERT INTO LEASE(slotNum, rate, duration, expirationDate, slipNumber) VALUES(?, ?, ?, ?, ?)");

            addNewLease.setInt(1, slotNum);
            addNewLease.setDouble(2, rate);
            addNewLease.setInt(3, duration);
            addNewLease.setDate(4, (Date)df.parse(expirationDate));
            addNewLease.setInt(5, slipNumber);

            System.out.println("Lease added!");
            addNewCust.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //TODO potential problem with size?
    public void addNewPowerboat(int registrationNum, int size, String fuelType, int engineNum, String engineType){
        try{
            addNewPowerboat = connection.prepareStatement("INSERT INTO POWERBOAT(registrationNum, size, fuelType, engineNum, engineType) VALUES(?, ?, ?, ?, ?)");

            addNewPowerboat.setInt(1, registrationNum);
            addNewPowerboat.setInt(2, size);
            addNewPowerboat.setString(3, fuelType);
            addNewPowerboat.setInt(4, engineNum);
            addNewPowerboat.setString(5, engineType);

            System.out.println("Powerboat added!");
            addNewCust.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //TODO potential problem with size?
    public void addNewSailboat(int registrationNum, int size, String fuelType, int keelHeight, String hasEngine, int sailNum){
        try{
            addNewSailboat = connection.prepareStatement("INSERT INTO SAILBOAT(registrationNum, size, fuelType, keelHeight, hasEngine, sailNum) VALUES(?, ?, ?, ?, ?, ?)");

            addNewSailboat.setInt(1, registrationNum);
            addNewSailboat.setInt(2, size);
            addNewSailboat.setString(3, fuelType);
            addNewSailboat.setInt(4, keelHeight);
            addNewSailboat.setString(5, hasEngine);
            addNewSailboat.setInt(6, sailNum);

            System.out.println("Customer added!");
            addNewCust.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    public void addNewServiceRecord(int invoiceNum, String dateOfMaintenance, String workDone){
        try{
            addNewServiceRecord = connection.prepareStatement("INSERT INTO MAINTENANCE(invoiceNum, dateOfMaintenance, workDone) VALUES(?, ?, ?)");

            addNewServiceRecord.setInt(1, invoiceNum);
            addNewServiceRecord.setDate(2, (Date)df.parse(dateOfMaintenance));
            addNewServiceRecord.setString(3, workDone);

            System.out.println("Service Record added!");
            addNewCust.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
