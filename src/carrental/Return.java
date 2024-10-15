/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrental;

import com.mysql.cj.protocol.Resultset;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KAVEEN
 */
public class Return extends javax.swing.JFrame {

    /**
     * Creates new form Return
     */
    
    Connection con ;
    Statement st;
    Resultset Rs;
    PreparedStatement pst;
    
    public Return() {
        initComponents();
        DisplaycarsRent();
        DisplaycarsReturn();
        displaycust();
    }
     
                private void DisplaycarsRent()
    {
        DefaultTableModel model = (DefaultTableModel) tblCarsRent.getModel();
        model.setRowCount(0);
        
    
 try {
            String url = "jdbc:mysql://localhost:3306/ajcar";
            String username = "Kaveen";
            String password = "123";

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM tblrent";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            String RegID = rs.getString("RegID");
                            String RentID = rs.getString("RentID");
                            String customername = rs.getString("CusName");
                            String rentDate = rs.getString("RentDate");
                            String returnDate = rs.getString("ReturnDate");
                            String fee = rs.getString("Fees");
                            Object[] rowData = { RegID, RentID, customername, rentDate,returnDate,fee};
                            model.addRow(rowData);
                        }
                    }
                }
            }
        } catch (SQLException e) {
}
  }
                
                
    private void DisplaycarsReturn()
    {
        DefaultTableModel model = (DefaultTableModel) tblCarReturn.getModel();
        model.setRowCount(0);
        
    
 try {
            String url = "jdbc:mysql://localhost:3306/ajcar";
            String username = "Kaveen";
            String password = "123";

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM tblreturn";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            String ReturnID = rs.getString("ReturnID");
                            String RegID = rs.getString("RegID");
                            String customername = rs.getString("CusName");
                            String returnDate = rs.getString("ReturnDate");
                            String Delay = rs.getString("Delay");
                            String Fine = rs.getString("Fine");
                            Object[] rowData = { ReturnID, RegID, customername, returnDate,Delay,Fine};
                            model.addRow(rowData);
                        }
                    }
                }
            }
        } catch (SQLException e) {
}
  }
    
    
    public void displaycust(){
  
        String url = "jdbc:mysql://localhost:3306/ajcar";
        String username = "Kaveen";
        String password = "123";

 try {
            // Create a database connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create a SQL query to retrieve customer names from a "customers" table
            String query = "SELECT CName FROM customer";

            // Create a statement and execute the query
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Create a list to store the retrieved customer names
            ArrayList<String> customerNames = new ArrayList<>();

            // Fetch and populate customer names from the result set
            while (resultSet.next()) {
                customerNames.add(resultSet.getString("CName"));
            }

            // Add the customer names to the JComboBox
            for (String customerName : customerNames) {
                cmbCustomerName.addItem(customerName);
            }

            conn.close(); // Close the database connection
        } catch (Exception e) {
            e.printStackTrace();
        }
}
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblCarsRent1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblAjCarRental = new javax.swing.JLabel();
        lblAjCarRental1 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblCustomer = new javax.swing.JLabel();
        lblCars = new javax.swing.JLabel();
        lblRentcar = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        lblManageCars = new javax.swing.JLabel();
        lblReturnID = new javax.swing.JLabel();
        txtReturnID = new javax.swing.JTextField();
        lblRegister = new javax.swing.JLabel();
        txtRegistration = new javax.swing.JTextField();
        lblCustomerName = new javax.swing.JLabel();
        cmbCustomerName = new javax.swing.JComboBox<>();
        lblReturnDate = new javax.swing.JLabel();
        jdateReturnDate = new com.toedter.calendar.JDateChooser();
        lblFine = new javax.swing.JLabel();
        txtDelay = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        lblDelay = new javax.swing.JLabel();
        txtFine = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCarsRent = new javax.swing.JTable();
        lblCarList1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCarReturn = new javax.swing.JTable();
        lblCarList2 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        tblCarsRent1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblCarsRent1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Registration", "Rent ID", "Customer Name", "Rent Date", "Return Date", "Fees"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCarsRent1.setRowHeight(25);
        jScrollPane3.setViewportView(tblCarsRent1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        lblAjCarRental.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblAjCarRental.setForeground(new java.awt.Color(51, 51, 51));
        lblAjCarRental.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAjCarRental.setText("Service");
        lblAjCarRental.setName("lblAJCarRental"); // NOI18N

        lblAjCarRental1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblAjCarRental1.setForeground(new java.awt.Color(51, 51, 51));
        lblAjCarRental1.setText("AJ Car Rental");
        lblAjCarRental1.setName("lblAJCarRental"); // NOI18N

        lblImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\KAVEEN\\Desktop\\New folder (6)\\images_(2)-transformed.png")); // NOI18N

        lblCustomer.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblCustomer.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomer.setText("Customer");
        lblCustomer.setName("lblAJCarRental"); // NOI18N
        lblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCustomerMouseClicked(evt);
            }
        });

        lblCars.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblCars.setForeground(new java.awt.Color(255, 255, 255));
        lblCars.setText("Cars");
        lblCars.setName("lblAJCarRental"); // NOI18N
        lblCars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCarsMouseClicked(evt);
            }
        });

        lblRentcar.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblRentcar.setForeground(new java.awt.Color(255, 255, 255));
        lblRentcar.setText("Rent Car");
        lblRentcar.setName("lblAJCarRental"); // NOI18N
        lblRentcar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRentcarMouseClicked(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 0, 51));
        btnLogout.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAjCarRental1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCustomer)
                            .addComponent(lblCars)
                            .addComponent(lblRentcar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblAjCarRental))
                            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblImage)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAjCarRental1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAjCarRental)
                .addGap(125, 125, 125)
                .addComponent(lblCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCars)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRentcar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnClose.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 0, 51));
        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
        );

        lblManageCars.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        lblManageCars.setForeground(new java.awt.Color(255, 0, 51));
        lblManageCars.setText("Car Return");
        lblManageCars.setName("lblAJCarRental"); // NOI18N

        lblReturnID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblReturnID.setForeground(new java.awt.Color(255, 0, 51));
        lblReturnID.setText("ReturnID");
        lblReturnID.setName("lblAJCarRental"); // NOI18N

        txtReturnID.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtReturnID.setForeground(new java.awt.Color(255, 0, 51));

        lblRegister.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(255, 0, 51));
        lblRegister.setText("Registration ");
        lblRegister.setName("lblAJCarRental"); // NOI18N

        txtRegistration.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtRegistration.setForeground(new java.awt.Color(255, 0, 51));

        lblCustomerName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCustomerName.setForeground(new java.awt.Color(255, 0, 51));
        lblCustomerName.setText("Customer Name");
        lblCustomerName.setName("lblAJCarRental"); // NOI18N

        lblReturnDate.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblReturnDate.setForeground(new java.awt.Color(255, 0, 51));
        lblReturnDate.setText("Return Date");
        lblReturnDate.setName("lblAJCarRental"); // NOI18N

        lblFine.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblFine.setForeground(new java.awt.Color(255, 0, 51));
        lblFine.setText("Fine");
        lblFine.setName("lblAJCarRental"); // NOI18N

        txtDelay.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDelay.setForeground(new java.awt.Color(255, 0, 51));

        btnsave.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 0, 51));
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 0, 51));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblDelay.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDelay.setForeground(new java.awt.Color(255, 0, 51));
        lblDelay.setText("Delay");
        lblDelay.setName("lblAJCarRental"); // NOI18N

        txtFine.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFine.setForeground(new java.awt.Color(255, 0, 51));

        tblCarsRent.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblCarsRent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Registration", "Rent ID", "Customer Name", "Rent Date", "Return Date", "Fees"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCarsRent.setRowHeight(25);
        jScrollPane2.setViewportView(tblCarsRent);

        lblCarList1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblCarList1.setForeground(new java.awt.Color(255, 0, 51));
        lblCarList1.setText("Cars Rent");
        lblCarList1.setName("lblAJCarRental"); // NOI18N

        tblCarReturn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblCarReturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Return ID", "Registration", "Customer Name", "Return Date", "Delay", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCarReturn.setRowHeight(25);
        jScrollPane4.setViewportView(tblCarReturn);

        lblCarList2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblCarList2.setForeground(new java.awt.Color(255, 0, 51));
        lblCarList2.setText("Car Return");
        lblCarList2.setName("lblAJCarRental"); // NOI18N

        btnReset.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 0, 51));
        btnReset.setText("Clear");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 51));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(248, 248, 248)
                                        .addComponent(lblManageCars))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtReturnID)
                                                    .addComponent(lblReturnID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cmbCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jdateReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lblReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(59, 59, 59)
                                                        .addComponent(lblDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(207, 207, 207)
                                                .addComponent(btnsave)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDelete)
                                                .addGap(24, 24, 24)
                                                .addComponent(btnReset)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFine, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCarList1)
                                        .addGap(434, 434, 434)
                                        .addComponent(lblCarList2)))
                                .addGap(16, 16, 16)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblManageCars)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerName)
                            .addComponent(lblReturnDate)
                            .addComponent(lblDelay)
                            .addComponent(lblFine))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdateReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblReturnID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReturnID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnsave)
                    .addComponent(btnReset)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarList1)
                    .addComponent(lblCarList2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void lblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCustomerMouseClicked
        // TODO add your handling code here:
        this.dispose();
Customer c = new Customer();
c.setVisible(true);
    }//GEN-LAST:event_lblCustomerMouseClicked

    private void lblCarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCarsMouseClicked
        // TODO add your handling code here:
         this.dispose();
        try{
         cars c = new cars();
        c.setVisible(true);}
        catch(Exception e){
        
        }
    }//GEN-LAST:event_lblCarsMouseClicked

    private void lblRentcarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRentcarMouseClicked
        // TODO add your handling code here:
          this.dispose();
        Rents re = new Rents();
        re.setVisible(true);
    }//GEN-LAST:event_lblRentcarMouseClicked

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        try {
            String ID = txtReturnID.getText();
            String reg = txtRegistration.getText();
            String custName = cmbCustomerName.getSelectedItem().toString();
            SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyy-MM-dd");
            String due = Date_Format1.format(jdateReturnDate.getDate());
            String delay = txtDelay.getText();
            String fine = txtFine.getText();
            
            

            // Validate input fields
            if (reg.isEmpty() || ID.isEmpty() || delay.isEmpty() || custName.isEmpty() || fine.isEmpty() || due.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int Fine = Integer.parseInt(fine);
                    if (Fine <= 0) {
                        JOptionPane.showMessageDialog(this, "Fine must be a positive integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajcar", "Kaveen", "123");
                        PreparedStatement add = con.prepareStatement("insert into tblreturn values(?,?,?,?,?,?)");

                        add.setString(1, ID);
                        add.setString(2, reg);
                        add.setString(3, custName);
                        add.setString(4, due);
                        add.setString(5,  delay);
                        add.setInt(6, Fine);

                        int row = add.executeUpdate();
                        if (row > 0) {
                            JOptionPane.showMessageDialog(this, " Car Return Successfully");
                            DisplaycarsReturn();
                            btnResetActionPerformed(evt);
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to Return .", "Database Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please Fill all!.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        String url = "jdbc:mysql://localhost:3306/ajcar";
        String username = "Kaveen";
        String password = "123";

        Connection connection = null; // Initialize the connection

        try {
            connection = DriverManager.getConnection(url, username, password);

            String sql = "UPDATE tblreturn SET RegID = ?, CusName = ? , ReturnDate = ? , Fine = ?, Delay = ? WHERE ReturnID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            // Format date values using SimpleDateFormat
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the pattern to match your date format

            String returnDate = dateFormat.format(jdateReturnDate.getDate());

            // ...

            // Set the date values in the PreparedStatement

            statement.setString(1, txtRegistration.getText());
            statement.setString(2, cmbCustomerName.getSelectedItem().toString());
            statement.setString(3, returnDate);
            statement.setInt(4, Integer.parseInt(txtDelay.getText()));
            statement.setInt(5, Integer.parseInt(txtFine.getText()));
            statement.setString(6, txtReturnID.getText());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Updated successfully.");
                DisplaycarsReturn();
                btnResetActionPerformed(evt);

            } else {
                JOptionPane.showMessageDialog(null, "No records were updated.", "Update Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException | NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Data cannot be updated because of: " + exception, "Update Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // Close the connection when done
                } catch (SQLException e) {
                    // Handle any potential closing error
                    e.printStackTrace();
                }

    }//GEN-LAST:event_btnEditActionPerformed
        }
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtRegistration.setText(null);
        txtReturnID.setText(null);
        txtDelay.setText(null);
        jdateReturnDate.setDate(null);
        cmbCustomerName.setSelectedItem(null);
        txtFine.setText(null);
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
String url = "jdbc:mysql://localhost:3306/ajcar";
        String username = "Kaveen";
        String password = "123";

        // SQL query to delete voter details
        String sql = "DELETE FROM tblreturn WHERE ReturnID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            String Rent = txtReturnID.getText();
            stmt.setString(1, Rent);

            // Execute the delete query
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(rootPane, "deleted successfully.");
                DisplaycarsReturn();
                btnResetActionPerformed(evt);

            } else {
                JOptionPane.showMessageDialog(rootPane, "No matching details found.");

            }

        } catch (SQLException e) {
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbCustomerName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jdateReturnDate;
    private javax.swing.JLabel lblAjCarRental;
    private javax.swing.JLabel lblAjCarRental1;
    private javax.swing.JLabel lblCarList1;
    private javax.swing.JLabel lblCarList2;
    private javax.swing.JLabel lblCars;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDelay;
    private javax.swing.JLabel lblFine;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblManageCars;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblRentcar;
    private javax.swing.JLabel lblReturnDate;
    private javax.swing.JLabel lblReturnID;
    private javax.swing.JTable tblCarReturn;
    private javax.swing.JTable tblCarsRent;
    private javax.swing.JTable tblCarsRent1;
    private javax.swing.JTextField txtDelay;
    private javax.swing.JTextField txtFine;
    private javax.swing.JTextField txtRegistration;
    private javax.swing.JTextField txtReturnID;
    // End of variables declaration//GEN-END:variables
}
