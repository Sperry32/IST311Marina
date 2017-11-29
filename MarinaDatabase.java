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
    PreparedStatement addNewMaintenance = null;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyY");

    public MarinaDatabase(){
        try{
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Made a connection to the database");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
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
///////////////////////////////////////////////////////////////////////////////////////////////////////
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
///////////////////////////////////////////////////////////////////////////////////////////////////////    
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
///////////////////////////////////////////////////////////////////////////////////////////////////////    
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
///////////////////////////////////////// ADDS////////////////////////////////////////////////////////////////////////
    public void addNewCust(int license, String fName, String lName){
        try{
            addNewCust = connection.prepareStatement("INSERT INTO CUSTOMER(boatingLicense, firstName, lastName) VALUES(?, ?, ?)");

            addNewCust.setInt(1, license);
            addNewCust.setString(2, fName);
            addNewCust.setString(3, lName);

            System.out.println("Customer added!");
            int ans = addNewCust.executeUpdate();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////    
    public void addNewPowerboat(int registrationNum, double size, String fuelType, int numEngines, String engineType){
        try{
            addNewPowerboat = connection.prepareStatement("INSERT INTO POWERBOAT(registrationNum, size, fuelType, numEngines, engineType) VALUES(?, ?, ?, ?, ?)");

            addNewPowerboat.setInt(1, registrationNum);
            addNewPowerboat.setDouble(2, size);
            addNewPowerboat.setString(3, fuelType);
            addNewPowerboat.setInt(4, numEngines);
            addNewPowerboat.setString(5, engineType);
           

            System.out.println("Power Boat added!");
            int ans = addNewPowerboat.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////    
    public void addNewSailboat(int registrationNum, double size, String fuelType, double keelHeight, boolean hasEngine, int sailNum){
        try{
            addNewSailboat = connection.prepareStatement("INSERT INTO SAILBOAT(registrationNum, size, fuelType, keelHeight, hasEngine, sailNum) VALUES(?, ?, ?, ?, ?, ?)");

            addNewSailboat.setInt(1, registrationNum);
            addNewSailboat.setDouble(2, size);
            addNewSailboat.setString(3, fuelType);
            addNewSailboat.setDouble(4, keelHeight);
            addNewSailboat.setBoolean(5, hasEngine);
            addNewSailboat.setInt(6, sailNum);
           

            System.out.println("Sail Boat added!");
            int ans = addNewSailboat.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////    
    public void addNewLease(int slipNumber, int slotNumber, int duration, double rate, String expirationDate){
        try{
            addNewLease = connection.prepareStatement("INSERT INTO LEASE(slipNumber, slotNumber, duration, rate, expirationDate) VALUES(?, ?, ?, ?, ?)");

            addNewLease.setInt(1, slipNumber);
            addNewLease.setInt(2, slotNumber);
            addNewLease.setInt(3, duration);
            addNewLease.setDouble(4, rate);
            addNewLease.setString(5, expirationDate);
            
            System.out.println("Lease Created!");
            int ans = addNewLease.executeUpdate();
            
            //possible location for boatLeases and customerLeases code
            
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////    
    public void addNewMaintenance(int invoiceNum, String dateOfMaintenance, String workDone){
        try{
            addNewMaintenance = connection.prepareStatement("INSERT INTO MAINTENANCE(invoiceNum, dateOfMaintenance, workDone) VALUES(?, ?, ?)");

            addNewMaintenance.setInt(1, invoiceNum);
            addNewMaintenance.setString(2, dateOfMaintenance);
            addNewMaintenance.setString(3, workDone);

            System.out.println("Maintenance record created!");
            int ans = addNewMaintenance.executeUpdate();
            
            //possible location for boatMaintenance code
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
///////////////Storage/////////////////////////
// addNewServiceRecord.setDate(2, (Date)df.parse(dateOfMaintenance));
//
////////////////////////////////////////////////
