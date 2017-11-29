import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class HomeGUI implements ActionListener{
    JPanel cards;
    final String    HOME_MENU = "Home Menu",
                    SEARCH_MENU = "Search Menu",
                    CREATE_MENU = "Create Menu",
                    FINANCIAL_MENU = "Financial Menu",
                    CUSTOMER_SEARCH = "Customer Panel",
                    BOAT_SEARCH = "Boat Panel",
                    LEASE_SEARCH = "Lease Search",
                    SERVICE_RECORD_SEARCH = "Service Record Search",
                    CREATE_CUSTOMER = "Create Customer",
                    CREATE_LEASE = "Create Lease",
                    CREATE_SERVICE_RECORD = "Create Service Record",
                    CREATE_PAYMENT = "Create Payment",
                    CREATE_SAILBOAT = "Create Sailboat",
                    CREATE_POWERBOAT = "Create Powerboat";


    MarinaDatabase db = new MarinaDatabase();
    //search by customer
    static ResultSet result = null;
    

    public static void main(String args[]){
        createAndShowGUI();
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Chesapeake Bay Marina");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HomeGUI gui = new HomeGUI();

        frame.setJMenuBar(gui.createMenuBar());
        gui.addComponentToPane(frame.getContentPane());

        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void addComponentToPane(Container pane){
        JPanel  homeMenu = homeMenu(),
                searchMenu = searchMenu(),
                financialMenu = FinancialMenu(),
                createCustomer = createCustomer(),
                createMenu = createMenu(),
                createServiceRecord = createServiceRecord(),
                createLease = createLease(),
                custSearch = custSearch(),
                boatSearch = boatSearch(),
                leaseSearch = leaseSearch(),
                serviceSearch = serviceSearch(), 
                createPayment = createPayment(),
                createPowerboat = createPowerboat(),
                createSailboat = createSailboat();

        cards = new JPanel(new CardLayout());


        cards.add(homeMenu, HOME_MENU);
        cards.add(searchMenu, SEARCH_MENU);
        cards.add(financialMenu, FINANCIAL_MENU);
        cards.add(createCustomer, CREATE_CUSTOMER);
        cards.add(createServiceRecord, CREATE_SERVICE_RECORD);
        cards.add(createLease, CREATE_LEASE);
        cards.add(createMenu, CREATE_MENU);
        cards.add(custSearch, CUSTOMER_SEARCH);
        cards.add(boatSearch, BOAT_SEARCH);
        cards.add(leaseSearch, LEASE_SEARCH);
        cards.add(serviceSearch, SERVICE_RECORD_SEARCH);
        cards.add(createPayment, CREATE_PAYMENT);
        cards.add(createSailboat, CREATE_SAILBOAT);
        cards.add(createPowerboat, CREATE_POWERBOAT);

        pane.add(cards);

    }

    public JPanel leaseSearch(){
        JPanel leaseSearch = new JPanel();

        final String    BOATSLOT = "Boat slot",
                        RATE = "Rate",
                        EXPIRATIONDATE = "Expiration Date",
                        DURATION = "Duration",
                        SLIPNUMBER = "Slip Number";

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel  slipNum = new JLabel(SLIPNUMBER, SwingConstants.RIGHT),
                boatSlot = new JLabel(BOATSLOT, SwingConstants.RIGHT),
                expirationDate = new JLabel(EXPIRATIONDATE, SwingConstants.RIGHT),
                duration = new JLabel(DURATION, SwingConstants.RIGHT),
                rate = new JLabel(RATE, SwingConstants.RIGHT);

        JTextField  slipNumTF = new JTextField(25),
                    boatSlotTF = new JTextField(25),
                    expirationDateTF = new JTextField(25),
                    durationTF = new JTextField(25),
                    rateTF = new JTextField(25);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SEARCH_MENU);
            }
        });

        leaseSearch.setLayout(new GridLayout(7, 2));

        leaseSearch.add(back);
        leaseSearch.add(new JLabel());

        leaseSearch.add(slipNum);
        leaseSearch.add(slipNumTF);

        leaseSearch.add(boatSlot);
        leaseSearch.add(boatSlotTF);

        leaseSearch.add(expirationDate);
        leaseSearch.add(expirationDateTF);

        leaseSearch.add(duration);
        leaseSearch.add(durationTF);

        leaseSearch.add(rate);
        leaseSearch.add(rateTF);

        leaseSearch.add(submit);

        return leaseSearch;
    }
    public JPanel homeMenu(){
        JPanel homeMenu = new JPanel();

        JButton
                newBtn = new JButton("New"),
                financial = new JButton("Financial"),
                search = new JButton("Search");

        newBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_MENU);
            }
        });
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SEARCH_MENU);
            }
        });
        financial.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, FINANCIAL_MENU);
			}
        });

        homeMenu.add(newBtn);
        homeMenu.add(financial);
        homeMenu.add(search);

        return homeMenu;
    }

    public JPanel createMenu(){
        JPanel createMenu = new JPanel();

        JButton back = new JButton("Back"),
                customer = new JButton("Create a Customer"),
                lease = new JButton("Create a Lease"),
                serviceRecord = new JButton("Create a Service Record"),
                sailBoat = new JButton("Create a Sail Boat"),
                powerBoat = new JButton("Create a Power Boat");

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, HOME_MENU);
            }
        });

        customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_CUSTOMER);
            }
        });
        lease.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_LEASE);
            }
        });
        serviceRecord.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_SERVICE_RECORD);
            }
        });


        sailBoat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_SAILBOAT);
            }
        });


        powerBoat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_POWERBOAT);
            }
        });

        createMenu.add(back);
        createMenu.add(customer);
        createMenu.add(lease);
        createMenu.add(serviceRecord);
        createMenu.add(powerBoat);
        createMenu.add(sailBoat);

        return createMenu;
    }

    public JPanel createCustomer(){
        JPanel createCustomer = new JPanel();

        final  String   FIRSTNAME = "First Name",
                		LASTNAME = "Last Name",
                		LICENSE = "Boating License Number";

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel  fName = new JLabel(FIRSTNAME, SwingConstants.RIGHT),
                lName = new JLabel(LASTNAME, SwingConstants.RIGHT),
                lic = new JLabel(LICENSE, SwingConstants.RIGHT);

        JTextField  fNameTF = new JTextField(25),
                lNameTF = new JTextField(25),
                licTF = new JTextField(25);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_MENU);
            }
        });

        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int license = Integer.parseInt(licTF.getText());
                String fName = fNameTF.getText();
                String lName = lNameTF.getText();

                db.addNewCust(license, fName, lName);
            }
        });

        createCustomer.setLayout(new GridLayout(5, 2));

        createCustomer.add(back);
        createCustomer.add(new JLabel());

        createCustomer.add(fName);
        createCustomer.add(fNameTF);

        createCustomer.add(lName);
        createCustomer.add(lNameTF);

        createCustomer.add(lic);
        createCustomer.add(licTF);

        createCustomer.add(submit);

        return createCustomer;
    }

    public JPanel createLease(){
        JPanel createLease = new JPanel();

        final String    BOATSLOT = "Boat slot",
                        RATE = "Rate",
                        EXPIRATIONDATE = "Expiration Date",
                        DURATION = "Duration",
                        SLIPNUMBER = "Slip Number";

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel  slipNum = new JLabel(SLIPNUMBER, SwingConstants.RIGHT),
                boatSlot = new JLabel(BOATSLOT, SwingConstants.RIGHT),
                expirationDate = new JLabel(EXPIRATIONDATE, SwingConstants.RIGHT),
                duration = new JLabel(DURATION, SwingConstants.RIGHT),
                rate = new JLabel(RATE, SwingConstants.RIGHT);

        JTextField  slipNumTF = new JTextField(25),
                boatSlotTF = new JTextField(25),
                expirationDateTF = new JTextField(25),
                durationTF = new JTextField(25),
                rateTF = new JTextField(25);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_MENU);
            }
        });

        createLease.setLayout(new GridLayout(7, 2));

        createLease.add(back);
        createLease.add(new JLabel());

        createLease.add(slipNum);
        createLease.add(slipNumTF);

        createLease.add(boatSlot);
        createLease.add(boatSlotTF);

        createLease.add(expirationDate);
        createLease.add(expirationDateTF);

        createLease.add(duration);
        createLease.add(durationTF);

        createLease.add(rate);
        createLease.add(rateTF);

        createLease.add(submit);

        return createLease;
    }
    
    public JPanel createServiceRecord(){
        JPanel createServiceRecord = new JPanel();

        final String    INVOICENUMBER = "Invoice #",
                        DATEOFMAINT = "Date of Maintenance",
                        WORKDONE = "Work Done";

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel  invoiceNum = new JLabel(INVOICENUMBER, SwingConstants.RIGHT),
                date = new JLabel(DATEOFMAINT, SwingConstants.RIGHT),
                workDone = new JLabel(WORKDONE, SwingConstants.RIGHT);

        JTextField  invoiceNumTF = new JTextField(25),
                dateTF = new JTextField(25);

        JTextArea workDoneTA = new JTextArea(10, 25);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_MENU);
            }
        });

        createServiceRecord.setLayout(new GridLayout(5, 2));

        createServiceRecord.add(back);
        createServiceRecord.add(new JLabel());

        createServiceRecord.add(invoiceNum);
        createServiceRecord.add(invoiceNumTF);

        createServiceRecord.add(date);
        createServiceRecord.add(dateTF);

        createServiceRecord.add(workDone);
        createServiceRecord.add(workDoneTA);

        createServiceRecord.add(submit);

        return createServiceRecord;
    }
    
    public JPanel createPayment(){
    	JPanel createPayment = new JPanel();
    	
    	JButton backBtn = new JButton("Back"),
    			paymentBtn = new JButton("Make Payment");
    	
    	JLabel	nameLbl = new JLabel("Name on card:"),
    			numLbl = new JLabel("Card Number:"),
    			securityLbl = new JLabel("Security Code:"),
    			dateLbl = new JLabel("Expiration Date:"),
    			totalLbl = new JLabel("Total Amount Due: $0.00");	//TODO: change this later to reflect actual cost
    			
    	JTextField  nameField = new JTextField(12),
    				numField = new JTextField(12),
    				securityField = new JTextField(12),
    				dateField = new JTextField(12);
    	
    	createPayment.setLayout(new GridLayout(6,2));

    	createPayment.add(new JLabel());
    	createPayment.add(backBtn);
    	
    	createPayment.add(nameLbl);
    	createPayment.add(nameField);
    	
    	createPayment.add(numLbl);
    	createPayment.add(numField);
    	
    	createPayment.add(securityLbl);
    	createPayment.add(securityField);
    	
    	createPayment.add(dateLbl);
    	createPayment.add(dateField);
    	
    	createPayment.add(totalLbl);
    	createPayment.add(paymentBtn);
    	
    	//add action listeners
    	backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, FINANCIAL_MENU);
			}		
    	});
    	
    	//add action listener for make payment button...
    	
    	return createPayment;
    }

    public JPanel createPowerboat(){
        JPanel createPowerboat = new JPanel();

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel	registrationNum = new JLabel("Registration Number:"),
                length = new JLabel("Length(feet):"),
                fuelType = new JLabel("Fuel Type:"),
                engineNum = new JLabel("Number of Engines:"),
                engineType = new JLabel("Type of Engine(s):");

        JTextField  registrationNumTF = new JTextField(12),
                    lengthTF = new JTextField(12),
                    fuelTypeTF = new JTextField(12),
                    engineNumTF = new JTextField(12),
                    engineTypeTF = new JTextField(12);


        createPowerboat.setLayout(new GridLayout(7,2));

        createPowerboat.add(back);
        createPowerboat.add(new JLabel());

        createPowerboat.add(registrationNum);
        createPowerboat.add(registrationNumTF);

        createPowerboat.add(length);
        createPowerboat.add(lengthTF);

        createPowerboat.add(fuelType);
        createPowerboat.add(fuelTypeTF);

        createPowerboat.add(engineNum);
        createPowerboat.add(engineNumTF);

        createPowerboat.add(engineType);
        createPowerboat.add(engineTypeTF);

        createPowerboat.add(submit);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_MENU);
            }
        });

        return createPowerboat;
    }

    public JPanel createSailboat(){
        JPanel createSailboat = new JPanel();

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel	registrationNum = new JLabel("Registration Number:"),
                length = new JLabel("Length(feet):"),
                fuelType = new JLabel("Fuel Type"),
                keelHeight = new JLabel("Keel Height:"),
                hasEngine = new JLabel("Have an engine:"),
                sailNum = new JLabel("Number of Sails:");

        JTextField  registrationNumTF = new JTextField(12),
                    lengthTF = new JTextField(12),
                    fuelTypeTF = new JTextField(12),
                    keelHeightTF = new JTextField(12),
                    hasEngineTF = new JTextField(12),
                    sailNumTF = new JTextField(12);


        createSailboat.setLayout(new GridLayout(8,2));

        createSailboat.add(back);
        createSailboat.add(new JLabel());

        createSailboat.add(registrationNum);
        createSailboat.add(registrationNumTF);

        createSailboat.add(length);
        createSailboat.add(lengthTF);

        createSailboat.add(fuelType);
        createSailboat.add(fuelTypeTF);

        createSailboat.add(keelHeight);
        createSailboat.add(keelHeightTF);

        createSailboat.add(hasEngine);
        createSailboat.add(hasEngineTF);

        createSailboat.add(sailNum);
        createSailboat.add(sailNumTF);

        createSailboat.add(submit);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_MENU);
            }
        });
        return createSailboat;
    }
    public JPanel serviceSearch(){
        JPanel serviceSearch = new JPanel();

        final String    INVOICENUMBER = "Invoice #",
                        DATEOFMAINT = "Date of Maintenance",
                        WORKDONE = "Work Done";

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel  invoiceNum = new JLabel(INVOICENUMBER, SwingConstants.RIGHT),
                date = new JLabel(DATEOFMAINT, SwingConstants.RIGHT),
                workDone = new JLabel(WORKDONE, SwingConstants.RIGHT);

        JTextField  invoiceNumTF = new JTextField(25),
                    dateTF = new JTextField(25);

        JTextArea workDoneTA = new JTextArea(10, 25);

        serviceSearch.setLayout(new GridLayout(5, 2));

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SEARCH_MENU);
            }
        });

        serviceSearch.add(back);
        serviceSearch.add(new JLabel());

        serviceSearch.add(invoiceNum);
        serviceSearch.add(invoiceNumTF);

        serviceSearch.add(date);
        serviceSearch.add(dateTF);

        serviceSearch.add(workDone);
        serviceSearch.add(workDoneTA);

        serviceSearch.add(submit);

        return serviceSearch;
    }

    public JPanel boatSearch(){

        JPanel boatSearch = new JPanel();

        final String    REGISTRATIONNUM = "Registration Number",
                        LENGTH = "Length",
                        FUELTYPE = "Fuel Type";

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel  regNum = new JLabel(REGISTRATIONNUM, SwingConstants.RIGHT),
                length = new JLabel(LENGTH, SwingConstants.RIGHT),
                fuelType = new JLabel(FUELTYPE, SwingConstants.RIGHT);

        JTextField  regNumTF = new JTextField(25),
                    lengthTF = new JTextField(25),
                    fuelTypeTF = new JTextField(25);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SEARCH_MENU);
            }
        });

        boatSearch.setLayout(new GridLayout(5, 2));

        boatSearch.add(back);
        boatSearch.add(new JLabel());

        boatSearch.add(regNum);
        boatSearch.add(regNumTF);

        boatSearch.add(length);
        boatSearch.add(lengthTF);

        boatSearch.add(fuelType);
        boatSearch.add(fuelTypeTF);

        boatSearch.add(submit);

        return boatSearch;
    }



    public JPanel custSearch(){
        //----------__Customer Search ---------------
        JPanel custSearch = new JPanel();
        final  String   FIRSTNAME = "First Name",
                        LASTNAME = "Last Name",
                        LICENSE = "Boating License Number";

        JButton back = new JButton("Back"),
                submit = new JButton("Submit");

        JLabel  fName = new JLabel(FIRSTNAME, SwingConstants.RIGHT),
                lName = new JLabel(LASTNAME, SwingConstants.RIGHT),
                lic = new JLabel(LICENSE, SwingConstants.RIGHT);

        JTextField  fNameTF = new JTextField(25),
                    lNameTF = new JTextField(25),
                    licTF = new JTextField(25);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SEARCH_MENU);
            }
        });
        
        submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
		        //for database connection
                result = db.searchCustByName(fNameTF.getText(), lNameTF.getText());
                try {
                    while (result.next()) {
                        fNameTF.setText(result.getString("firstName"));
                        lNameTF.setText(result.getString("lastName"));
                        licTF.setText(Integer.toString(result.getInt("boatingLicense")));
                    }
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "No Reults from Search", JOptionPane.ERROR_MESSAGE);
                }

			} 	
        });

        custSearch.setLayout(new GridLayout(5, 2));

        custSearch.add(back);
        custSearch.add(new JLabel());

        custSearch.add(fName);
        custSearch.add(fNameTF);

        custSearch.add(lName);
        custSearch.add(lNameTF);

        custSearch.add(lic);
        custSearch.add(licTF);

        custSearch.add(submit);

        return custSearch;
    }

    public JPanel searchMenu(){
        JPanel searchMenu = new JPanel();
        final String    CUSTOMER = "Search by Customer",
                        LEASE = "Search by Lease",
                        BOAT = "Search by Boat",
                        SERVICE = "Search by Service Record";

        JButton back = new JButton("Back"),
                customer = new JButton(CUSTOMER),
                lease = new JButton(LEASE),
                boat = new JButton(BOAT),
                service = new JButton(SERVICE);

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, HOME_MENU);
            }
        });

        customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CUSTOMER_SEARCH);
            }
        });

        lease.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, LEASE_SEARCH);
            }
        });

        boat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, BOAT_SEARCH);
            }
        });

        service.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SERVICE_RECORD_SEARCH);
            }
        });


        searchMenu.add(back);
        searchMenu.add(customer);
        searchMenu.add(lease);
        searchMenu.add(boat);
        searchMenu.add(service);

        return searchMenu;
    }
    
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;

        JMenu file,
                search,
                financial;

        menuBar = new JMenuBar();

        file = new JMenu("File");
        search = new JMenu("Search");
        financial = new JMenu("Financial");

        //-------_File --------------
        menuBar.add(file);

        JMenuItem   createCustomer,
                    createLease,
                    createServiceRecord,
                    createPowerboat,
                    createSailboat;

        createCustomer = new JMenuItem("Create New Customer");
        createLease = new JMenuItem("Create New Lease");
        createServiceRecord = new JMenuItem("Create Service Record");
        createPowerboat = new JMenuItem("Create Powerboat");
        createSailboat = new JMenuItem("Create Sailboat");

        createCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_CUSTOMER);
            }
        });
        createLease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_LEASE);
            }
        });
        createServiceRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_SERVICE_RECORD);
            }
        });
        createSailboat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_SAILBOAT);
            }
        });
        createPowerboat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CREATE_POWERBOAT);
            }
        });
        file.add(createCustomer);
        file.add(createLease);
        file.add(createServiceRecord);
        file.add(createSailboat);
        file.add(createPowerboat);

        //------- Search ------------
        menuBar.add(search);

        JMenuItem customer,
                lease,
                boat,
                maintenance;

        customer = new JMenuItem("By Customer");
        lease = new JMenuItem("By Lease");
        boat = new JMenuItem("By Boat");
        maintenance = new JMenuItem("By Maintenance");

        customer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, CUSTOMER_SEARCH);
            }
        });

        boat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, BOAT_SEARCH);
            }
        });
        lease.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, LEASE_SEARCH);
            }
        });

        maintenance.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, SERVICE_RECORD_SEARCH);
            }
        });

        search.add(customer);
        search.add(lease);
        search.add(boat);
        search.add(maintenance);

        //------- Payment ---------
        menuBar.add(financial);

        //Billing submenu
        JMenu createBill = new JMenu("Create A Bill");

        JMenuItem leaseBill,
                serviceBill;

        leaseBill = new JMenuItem("Lease Bill");
        serviceBill = new JMenuItem("Service Bill");

        createBill.add(leaseBill);
        createBill.add(serviceBill);

        JMenuItem recordPayment,
                lateNotice,
                accountsReceivable;

        recordPayment = new JMenuItem("Record Payment");
        lateNotice = new JMenuItem("Late Notices");
        accountsReceivable = new JMenuItem("Accounts Receivable");
        //Make a submenu for leases and boat services

        financial.add(createBill);
        financial.add(recordPayment);
        financial.add(lateNotice);
        financial.add(accountsReceivable);

        return menuBar;
    }
    
    //--------financial--------
    public JPanel FinancialMenu(){
    	JPanel financialMenu = new JPanel();
    	
    	JButton paymentBtn = new JButton("Make A Payment"),
    			backBtn = new JButton("Back");
    	
    	backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
    			CardLayout cl = (CardLayout)(cards.getLayout());
    			cl.show(cards, HOME_MENU);
			}
    	});
    	
    	paymentBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, CREATE_PAYMENT);
			}    		
    	});
    	
    	financialMenu.add(backBtn);
    	financialMenu.add(paymentBtn);
    	
    	return financialMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

