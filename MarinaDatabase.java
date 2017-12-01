import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MarinaDatabase {
    static final String DATABASE_URL = "jdbc:ucanaccess://X:/My Documents/Marina.accdb";
    Connection connection = null;
    Statement statement = null;
    ResultSet rSet = null;
    PreparedStatement searchCustByLicense = null;
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
    PreparedStatement addNewboatMaintenance = null;
    PreparedStatement updatePowerSlot = null;
    PreparedStatement updateSailSlot = null;
    PreparedStatement SailboatSlots = null;
    PreparedStatement PowerboatSlots = null;
    PreparedStatement SailSlotInfo = null;
    PreparedStatement PowerSlotInfo = null;
    
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
    public ResultSet searchCustByLicense(int license) {
        try
        {
            searchCustByLicense = connection.prepareStatement(
                    "SELECT * FROM Customer WHERE boatingLicense = ?");

            searchCustByLicense.setInt(1, license);

            rSet = searchCustByLicense.executeQuery();

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
            addNewPowerboat = connection.prepareStatement("INSERT INTO POWERBOAT(registrationNumber, size, fuelType, numEngines, engineType) VALUES(?, ?, ?, ?, ?)");

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
            addNewSailboat = connection.prepareStatement("INSERT INTO SAILBOAT(registrationNumber, size, fuelType, keelHeight, hasEngine, sailNum) VALUES(?, ?, ?, ?, ?, ?)");

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
    public void addNewLease(int slipNumber, int duration, double rate, java.sql.Date expirationDate, int boatingLicense){
        try{
            addNewLease = connection.prepareStatement("INSERT INTO LEASE(slipNumber, duration, rate, expirationDate) VALUES(?, ?, ?, ?)");

            addNewLease.setInt(1, slipNumber);
            addNewLease.setInt(2, duration);
            addNewLease.setDouble(3, rate);
            addNewLease.setDate(4, expirationDate);

            System.out.println("Lease Created!");
            int ans = addNewLease.executeUpdate();



            addNewboatLeases = connection.prepareStatement("INSERT INTO BOATLEASES(slipNumber, registrationNumber) VALUES(?, ?)");
            addNewboatLeases.setInt(1, slipNumber);
            addNewboatLeases.setInt(2, boatingLicense);
            addNewboatLeases.executeUpdate();
            
           
            addNewcustomerLeases = connection.prepareStatement("INSERT INTO CUSTOMERLEASES(boatingLicense, slipNumber) VALUES(?, ?)");
            addNewcustomerLeases.setInt(1, boatingLicense);
            addNewcustomerLeases.setInt(2, slipNumber);
            addNewcustomerLeases.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addNewMaintenance(int invoiceNum, java.sql.Date dateOfMaintenance, String workDone, int registrationNumber){
        try{
            addNewMaintenance = connection.prepareStatement("INSERT INTO MAINTENANCE(invoiceNumber, dateOfMaintenance, workDone) VALUES(?, ?, ?)");

            addNewMaintenance.setInt(1, invoiceNum);
            addNewMaintenance.setDate(2, dateOfMaintenance);
            addNewMaintenance.setString(3, workDone);

            System.out.println("Maintenance record created!");
            int ans = addNewMaintenance.executeUpdate();

           
            addNewboatMaintenance = connection.prepareStatement("INSERT INTO BOATMAINTENANCE(invoiceNum, registrationNum) VALUES(?, ?)");
            addNewboatMaintenance.setInt(1, invoiceNum);
            addNewboatMaintenance.setInt(2, registrationNumber);

            System.out.println("Maintenance record created!");
            int ans2 = addNewboatMaintenance.executeUpdate();
           

            //possible location for boatMaintenance code
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updatePowerSlot (int slipNumber, int slotNumber){
    	try{
    		updatePowerSlot = connection.prepareStatement("UPDATE POWERBOATSLOTS SET slipNumber = ? WHERE slotNumber = ?");
    		
    		updatePowerSlot.setInt(1, slipNumber);
    		updatePowerSlot.setInt(2, slotNumber);
    		
    		int ans = updatePowerSlot.executeUpdate();
    		
    	}
    	 catch(Exception e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, e.getMessage());
    	 }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateSailSlot (int slipNumber, int slotNumber){
    	try{
    		updateSailSlot = connection.prepareStatement("UPDATE SAILBOATSLOTS SET slipNumber = ? WHERE slotNumber = ?");

    		updateSailSlot.setInt(1, slipNumber);
    		updateSailSlot.setInt(2, slotNumber);

    		int ans =  updateSailSlot.executeUpdate();

    	}
    	catch(Exception e){
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ResultSet PowerboatSlots (int slotNumber) 
    {
    	
        try
        {
        	PowerboatSlots = connection.prepareStatement(
                    "SELECT slipNumber FROM PowerboatSlots WHERE slotNumber = ?");

        	PowerboatSlots.setInt(1, slotNumber);

            rSet = PowerboatSlots.executeQuery();

            return rSet;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rSet;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ResultSet SailboatSlots (int slotNumber) 
    {

    	try
    	{
    		SailboatSlots = connection.prepareStatement(
    				"SELECT slipNumber FROM SailboatSlots WHERE slotNumber = ?");

    		SailboatSlots.setInt(1, slotNumber);

    		rSet = SailboatSlots.executeQuery();

    		return rSet;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, e.getMessage());
    		return rSet;
    	}
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public ResultSet PowerSlotInfo (int slotNumber) 
	{

	try
	{
		PowerSlotInfo = connection.prepareStatement(
			"SELECT slipNumber, firstName, lastName, boatingLicense, registrationNumber FROM Customer, customerLeases, Lease, boatLeases, Powerboat, PowerboatSlots WHERE PowerboatSlots.slotNumber = ?");

		PowerSlotInfo.setInt(1, slotNumber);

	rSet = PowerSlotInfo.executeQuery();

	return rSet;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.getMessage());
		return rSet;
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public ResultSet SailSlotInfo (int slotNumber) 
{

try
{
	SailSlotInfo = connection.prepareStatement(
		"SELECT slipNumber, firstName, lastName, boatingLicense, registrationNumber FROM Customer, customerLeases, Lease, boatLeases, Sailboat, SailboatSlots WHERE SailboatSlots.slotNumber = ?");

	SailSlotInfo.setInt(1, slotNumber);

	rSet = SailSlotInfo.executeQuery();

	return rSet;
	}
		catch(Exception e)
	{
	e.printStackTrace();
	JOptionPane.showMessageDialog(null, e.getMessage());
	return rSet;
}
}
}
///////////////Storage/////////////////////////
// addNewServiceRecord.setDate(2, (Date)df.parse(dateOfMaintenance));
//
////////////////////////////////////////////////