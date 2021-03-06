/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pkg315;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;  
import javax.swing.WindowConstants;
/**
 *
 * @author arvin
 */
class WindowEventHandler extends WindowAdapter {
  public void windowClosing(WindowEvent evt) {
      try {
          AppMain.closeConnection();
      } catch (SQLException ex) {
          Logger.getLogger(WindowEventHandler.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
public class AppMain extends javax.swing.JFrame {
    private boolean isFiltered = false;
    private static Connection conn;
    private final static String DB_STRING =
            "jdbc:postgresql://csce-315-db.engr.tamu.edu/db908_group18_project2";
    private static boolean isLoggedIn = false;
    
    /**
     * Creates new form AppMain
     */
    public AppMain() {
        initComponents();
        Search.setEnabled(false);
    }
    public static void closeConnection() throws SQLException{
        if(conn != null){
            conn.close();
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

        loginDialog = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        userPassword = new javax.swing.JPasswordField();
        loginMessage = new javax.swing.JLabel();
        userUserName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        loginUser = new javax.swing.JButton();
        outputDialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsText = new javax.swing.JTextArea();
        exportFile = new javax.swing.JButton();
        outputMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        connectionLabel = new javax.swing.JLabel();
        query = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        queryErrorMessage = new javax.swing.JLabel();
        questionButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        loginDialog.setMinimumSize(new java.awt.Dimension(466, 300));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Database Login");

        userPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPasswordActionPerformed(evt);
            }
        });

        userUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userUserNameActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Username");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Password");

        loginUser.setText("Login");
        loginUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginDialogLayout = new javax.swing.GroupLayout(loginDialog.getContentPane());
        loginDialog.getContentPane().setLayout(loginDialogLayout);
        loginDialogLayout.setHorizontalGroup(
            loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(loginUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginDialogLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginDialogLayout.createSequentialGroup()
                        .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(loginDialogLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(userPassword))
                                .addGroup(loginDialogLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(userUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(loginDialogLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(loginMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        loginDialogLayout.setVerticalGroup(
            loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(67, 67, 67)
                .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(userUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginUser)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        outputDialog.setMinimumSize(new java.awt.Dimension(613, 425));

        resultsText.setColumns(20);
        resultsText.setRows(5);
        jScrollPane1.setViewportView(resultsText);

        exportFile.setText("Export to File");
        exportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileActionPerformed(evt);
            }
        });

        outputMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        outputMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout outputDialogLayout = new javax.swing.GroupLayout(outputDialog.getContentPane());
        outputDialog.getContentPane().setLayout(outputDialogLayout);
        outputDialogLayout.setHorizontalGroup(
            outputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputDialogLayout.createSequentialGroup()
                .addGroup(outputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outputDialogLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(exportFile)
                        .addGap(0, 248, Short.MAX_VALUE))
                    .addGroup(outputDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(outputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        outputDialogLayout.setVerticalGroup(
            outputDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(outputMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Team M.A.S.K Presents");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel2.setText("Yelp Business Query");

        connectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        connectionLabel.setText("Status: Not Connected to Database");

        query.setEditable(false);
        query.setText("Please Login Before Searching");
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search for Businesses:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        queryErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        questionButton.setText("Query Question");
        questionButton.setToolTipText("");
        questionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Question 1", "Question 2", "Question 3", "Question 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(questionButton)
                        .addGap(267, 267, 267)
                        .addComponent(Search))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(queryErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(298, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(360, 360, 360))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(250, 250, 250)
                        .addComponent(loginButton)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(loginButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(connectionLabel)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(queryErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Search))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(questionButton)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPasswordActionPerformed

    private void userUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userUserNameActionPerformed

    private void loginUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserActionPerformed
        // TODO add your handling code here:
        String userName = userUserName.getText();
        String passCode = new String(userPassword.getPassword());
        if(userPassword.getPassword().length == 0 || userName.equals("")) {
            loginMessage.setText("Error: Missing Fields");
        } else {
            try {
                loginMessage.setText("Logging in....");
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(DB_STRING, userName, passCode);
                isLoggedIn = true;
                connectionLabel.setText("Status: Connected");
                connectionLabel.setForeground(new Color(76, 175, 80));
            } catch (SQLException | ClassNotFoundException e) {
                loginMessage.setText("Error connecting to database, please try again");
                e.printStackTrace();        
            }
        }
        if(isLoggedIn) {
            Search.setEnabled(true);
            query.setText("");
            query.setEditable(true);
            loginButton.setVisible(false);
            loginDialog.setVisible(false);
           // filterButton.setEnabled(true);
        }
    }//GEN-LAST:event_loginUserActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        loginDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        loginDialog.setVisible(true);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        try {
            String business_name = query.getText(); 
            if(business_name.contains("\'")) {
                business_name = business_name.substring(0, business_name.indexOf("\'")) 
                        + "\'\'" 
                        + business_name.substring(business_name.indexOf("\'") + 1);
            }
            System.out.println(business_name);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlStatement = "SELECT * FROM business "; 
            if(isFiltered) {
                sqlStatement += "AS b INNER JOIN attr AS a ON b.attribute_id = "
                        + "a.attributes_id WHERE ";
                if(!business_name.equals("")) {
                    sqlStatement += "WHERE b.name = " 
                        + "\'" + business_name + "\' AND ";
                }
                
                if(BusinessAttributes.delivery) {
                    sqlStatement += "a.restaurantsdelivery = \'True\' AND ";
                }
                if(BusinessAttributes.goodForKids) {
                    sqlStatement += "a.goodforkids = \'True\' AND ";
                }
                if(BusinessAttributes.openTwentyFourHours) {
                    sqlStatement += "a.open24hours = \'True\' AND ";
                }
                if(BusinessAttributes.takeout) {
                    sqlStatement += "a.restaurantstakeout = \'True\' AND ";
                }
                sqlStatement = sqlStatement.substring(0, sqlStatement.length() - 5);
            } else {
                sqlStatement += "WHERE name = " + "\'" 
                    + business_name + "\'";
            }
            System.out.println(sqlStatement);
            
            //send statement to DBMS
            queryErrorMessage.setText("Searching....");
            ResultSet result = stmt.executeQuery(sqlStatement);
            int size = 0;
            if(result != null) {
                result.last();
                size = result.getRow();
            }
            if(size == 0) {
                resultsText.setText("No Results Found");
                exportFile.setEnabled(false);
            } else {
                result.first();
                String city = "";
                String stars = "";      
                int city_string_len = 0;
                int stars_string_len = 0;
                
                String business_info = String.format("%-50s%-50s%-20s", "Business Name", "City", "Rating") + "\n\n";
                while (result.next()) {
                     city = result.getString("city");
                     stars = result.getString("stars");
                     String name = result.getString("name");
                     city_string_len = city.length();
                     stars_string_len = stars.length();
                    //output    
                     business_info += String.format("%-50s%-50s%-20s", name, city, stars)+ "\n";  
                }
                
                resultsText.setText(business_info);
            }
            outputDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            outputDialog.setVisible(true);
            exportFile.setEnabled(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        resetQueryFields();
    }//GEN-LAST:event_SearchActionPerformed

    private void exportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");  
        Date date = new Date();
        String fileName = formatter.format(date) + ".txt";
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(resultsText.getText());
            file.close();
            String outputMessageText = "Successfully exported to file: " 
                    + fileName;
            outputMessage.setText(outputMessageText);
        } catch (IOException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
            outputMessage.setText("Error outputting to file, please try again.");
        }
    }//GEN-LAST:event_exportFileActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
        /*
        filterDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        filterDialog.setVisible(true);
        */
    }//GEN-LAST:event_filterButtonActionPerformed

    private void submitFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitFiltersActionPerformed
     /*   // TODO add your handling code here:
        if(takeOutCheckBox.isSelected() || twentyFourHoursCheckBox.isSelected()
                || goodForKidsCheckBox.isSelected() || deliveryCheckBox.isSelected()) {
            isFiltered = true;
        }
        if(takeOutCheckBox.isSelected()) {
            BusinessAttributes.takeout = true;
        }
        if(twentyFourHoursCheckBox.isSelected()) {
            BusinessAttributes.openTwentyFourHours = true;
        }
        if(goodForKidsCheckBox.isSelected()) {
            BusinessAttributes.takeout = true;
        }
        if(deliveryCheckBox.isSelected()) {
            BusinessAttributes.openTwentyFourHours = true;
        }
        filterDialog.setVisible(false);
        */
    }//GEN-LAST:event_submitFiltersActionPerformed

    private void questionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionButtonActionPerformed
        Statement stmt2;
        try {
            stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             //send statement to DBMS
        String sqlStatement = "";
        System.out.println(query.getText());
        if(jComboBox1.getSelectedItem() == "Question 1" ){
            
        }
        else if(jComboBox1.getSelectedItem() == "Question 2"){
            sqlStatement += "SELECT NAME, avg_stars, r.text, r.stars, r.funny, r.cool, r.useful FROM (SELECT user_id, NAME, average_stars AS avg_stars FROM users WHERE  user_id = " + "\'" + query.getText() + "\'" + ") INNER JOIN review AS r ON a.user_id = r.user_id"; 
            
        }
        else if(jComboBox1.getSelectedItem() == "Question 3"){
            sqlStatement += "SELECT franCntInState.name, franCntInState.countinstate, rate.avgstars FROM (SELECT Count(franInState.name) AS countInState,";
            sqlStatement += "franInState.name FROM (SELECT b.name, b.business_id FROM   (SELECT name, Count(name) FROM   business GROUP  BY name HAVING Count(name) > 1) fran INNER JOIN business AS b ON b.name = fran.name WHERE  b.state = \'" + query.getText() + "\' ORDER  BY name) franInState GROUP  BY franInState.name  ORDER  BY countinstate DESC) franCntInState INNER JOIN (SELECT name, Avg(stars) AS avgStars FROM business GROUP  BY name) rate ON rate.name = franCntInState.name WHERE  avgstars >= 3.5 ORDER  BY countinstate DESC LIMIT 5 ";    
        }
        else if(jComboBox1.getSelectedItem() == "Question 4"){
            sqlStatement += "SELECT mostTip.name, mostTip.count, tip.text FROM (SELECT nonFran.name, nonFran.business_id, Count(name) FROM (SELECT a.name, b.city, b.business_id FROM (SELECT name, Count(name) FROM business GROUP BY name HAVING Count(name) = 1) a INNER JOIN business AS b ON b.name = a.name WHERE city = " + "\'" + query.getText() + "\'" + ") nonFran INNER JOIN tip AS t ON nonFran.business_id = t.business_id GROUP BY name, nonFran.business_id ORDER BY count DESC LIMIT 1) mostTip INNER JOIN tip ON mostTip.business_id = tip.business_id";
        }
        System.out.println(sqlStatement);
        
        ResultSet result2 = stmt2.executeQuery(sqlStatement);
        
        queryErrorMessage.setText("Searching....");
        
         int size = 0;
            if(result2 != null) {
                result2.last();
                size = result2.getRow();
            }
            if(size == 0) {
                resultsText.setText("No Results Found");
                exportFile.setEnabled(false);
            } else {
               resultsText.setText("hi!");
            }
            outputDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            outputDialog.setVisible(true);
            

        } catch (SQLException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
       
       
        
    }//GEN-LAST:event_questionButtonActionPerformed
    
    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed
        
    }//GEN-LAST:event_queryActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    private void resetQueryFields() {
        queryErrorMessage.setText("");
        BusinessAttributes.resetFields();
        isFiltered = false;
        /*
        takeOutCheckBox.setSelected(false);
        twentyFourHoursCheckBox.setSelected(false);
        goodForKidsCheckBox.setSelected(false);
        deliveryCheckBox.setSelected(false);
        */
    }
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
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppMain main = new AppMain();
                main.setVisible(true);
                main.addWindowListener(new WindowEventHandler());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JButton exportFile;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JDialog loginDialog;
    private javax.swing.JLabel loginMessage;
    private javax.swing.JButton loginUser;
    private javax.swing.JDialog outputDialog;
    private javax.swing.JLabel outputMessage;
    private javax.swing.JTextField query;
    private javax.swing.JLabel queryErrorMessage;
    private javax.swing.JButton questionButton;
    private javax.swing.JTextArea resultsText;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JTextField userUserName;
    // End of variables declaration//GEN-END:variables
}
