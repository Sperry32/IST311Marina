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
    PreparedStatement searchPowerBoatByRegNum = null;
    PreparedStatement searchSailBoatByRegNum = null;
    PreparedStatement searchLeaseBySlipNum = null;
    PreparedStatement searchMaintenanceByInvoiceNumber = null;
    PreparedStatement addNewCust = null;
    PreparedStatement addNewLease = null;
    PreparedStatement addNewboatLeases = null;
    PreparedStatement addNewcustomerLeases = null;
    PreparedStatement addNewPowerboat = null;
    PreparedStatement addNewSailboat = null;
    PreparedStatement addNewMaintenance = null;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

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
                    "SELECT * FROM Customer WHERE firstName = ? AND lastName = ?");

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
    public ResultSet searchPowerBoatByRegNum(int registrationNumber) {
        try
        {
            searchPowerBoatByRegNum = connection.prepareStatement(
                    "SELECT * FROM Powerboat WHERE registrationNumber = ?");

            searchPowerBoatByRegNum.setInt(1, registrationNumber);


            rSet = searchPowerBoatByRegNum.executeQuery();

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
    public ResultSet searchSailBoatByRegNum(int registrationNumber) {
        try
        {
            searchSailBoatByRegNum = connection.prepareStatement(
                    "SELECT * FROM Sailboat WHERE registrationNumber = ?");

            searchSailBoatByRegNum.setInt(1, registrationNumber);


            rSet = searchSailBoatByRegNum.executeQuery();

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
    public ResultSet searchLeaseBySlipNum(int slipNum) {
        try
        {
            searchLeaseBySlipNum = connection.prepareStatement(
                    "SELECT * FROM Lease WHERE slipNumber = ?");

            searchLeaseBySlipNum.setInt(1, slipNum);


            rSet = searchLeaseBySlipNum.executeQuery();

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
    public ResultSet searchMaintenanceByInvoiceNumber(int invoiceNumber) {
        try
        {
            searchMaintenanceByInvoiceNumber = connection.prepareStatement(
                    "SELECT * FROM Maintenance WHERE invoiceNumber = ?");

            searchMaintenanceByInvoiceNumber.setInt(1, invoiceNumber);

            rSet = searchMaintenanceByInvoiceNumber.executeQuery();

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
    public void addNewPowerboat(int registrationNumber, double size, String fuelType, int numEngines, String engineType){
        try{
            addNewPowerboat = connection.prepareStatement("INSERT INTO POWERBOAT(registrationNum, size, fuelType, numEngines, engineType) VALUES(?, ?, ?, ?, ?)");

            addNewPowerboat.setInt(1, registrationNumber);
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
    public void addNewSailboat(int registrationNumber, double size, String fuelType, double keelHeight, boolean hasEngine, int sailNum){
        try{
            addNewSailboat = connection.prepareStatement("INSERT INTO SAILBOAT(registrationNum, size, fuelType, keelHeight, hasEngine, sailNum) VALUES(?, ?, ?, ?, ?, ?)");

            addNewSailboat.setInt(1, registrationNumber);
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
    public void addNewLease(int slipNumber, int slotNumber, int duration, double rate, String expirationDate, int registrationNumber, int boatingLicense){
        try{
            addNewLease = connection.prepareStatement("INSERT INTO LEASE(slipNumber, slotNumber, duration, rate, expirationDate) VALUES(?, ?, ?, ?, ?)");

            addNewLease.setInt(1, slipNumber);
            addNewLease.setInt(2, slotNumber);
            addNewLease.setInt(3, duration);
            addNewLease.setDouble(4, rate);
            addNewLease.setString(5, expirationDate);

            System.out.println("Lease Created!");
            int ans = addNewLease.executeUpdate();


            /*
            addNewboatLeases = connection.prepareStatement("INSERT INTO BOATLEASES(slipNumber, registrationNumber) VALUES(?, ?)");
            addNewboatLeases.setInt(1, slipNumber);
            addNewboatLeases.setInt(2, registrationNumber);


            //System.out.println("Lease Created!");
            int ans2 = addNewLease.executeUpdate();
            */

             /*
            addNewcustomerLeases = connection.prepareStatement("INSERT INTO CUSTOMERLEASES(boatingLicense, slipNumber) VALUES(?, ?)");
            addNewboatLeases.setInt(1, boatingLicense);
            addNewboatLeases.setInt(2, slipNumber);


            //System.out.println("Lease Created!");
            int ans3 = addNewLease.executeUpdate();
            */

            //possible location for boatLeases and customerLeases code

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addNewMaintenance(int invoiceNum, String dateOfMaintenance, String workDone, int registrationNumber){
        try{
            addNewMaintenance = connection.prepareStatement("INSERT INTO MAINTENANCE(invoiceNum, dateOfMaintenance, workDone) VALUES(?, ?, ?)");

            addNewMaintenance.setInt(1, invoiceNum);
            addNewMaintenance.setString(2, dateOfMaintenance);
            addNewMaintenance.setString(3, workDone);

            System.out.println("Maintenance record created!");
            int ans = addNewMaintenance.executeUpdate();

           /*
            addNewboatMaintenance = connection.prepareStatement("INSERT INTO BOATMAINTENANCE(invoiceNum, registrationNumber) VALUES(?, ?, ?)");
            addNewMaintenance.setInt(1, invoiceNum);
            addNewMaintenance.setInt(2, registrationNumber);

            //System.out.println("Maintenance record created!");
            int ans2 = addNewMaintenance.executeUpdate();
           */

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