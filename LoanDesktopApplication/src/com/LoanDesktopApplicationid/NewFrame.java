package com.LoanDesktopApplicationid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewFrame extends JFrame {

    //region sql stuff
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet;
    int id = -1;

    //endregion

    //region Tables
    JTable clientTable = new JTable();
    JScrollPane clientScroll = new JScrollPane(clientTable);

    JTable workerTable = new JTable();
    JScrollPane workersScroll = new JScrollPane(workerTable);

    JTable loanTable = new JTable();
    JScrollPane loanScroll = new JScrollPane(loanTable);

    JTable searchTable = new JTable();
    JScrollPane searchScroll = new JScrollPane(searchTable);
//endregion

    //region Tabs

    JPanel clientsPanel = new JPanel();
    JPanel workersPanel = new JPanel();
    JPanel loanPanel = new JPanel();
    JPanel SearchPanel = new JPanel();

    JTabbedPane tab = new JTabbedPane(); //TABS

    //endregion

    //region Client fields

    //Client


    // Client Panels
    JPanel upClientPanel = new JPanel();
    JPanel midClientPanel = new JPanel();
    JPanel downClientPanel = new JPanel();


    // Client Buttons

    //------------------buttons
    JButton addClientButton = new JButton("Add");
    JButton deleteClientButton = new JButton("Delete");
    JButton editClientButton = new JButton("Edit");
    JButton searchClientButton = new JButton("Search by IN");
    JButton refreshClientButton = new JButton("Refresh");


    //--------------------------------

    // Client Label

    JLabel idClientLabel = new JLabel("ID:");
    JLabel idNumberClientLabel = new JLabel("");
    JLabel fullNameClientLabel = new JLabel("Full name");
    JLabel identificationNumberClientLabel = new JLabel("Identification number(EGN/IN)");
    JLabel phoneNumberClientLabel = new JLabel("Phone Number");
    JLabel ageClientLabel = new JLabel("Age");
    JLabel genderClientLabel = new JLabel("Gender");

    //--------------------------------

    // Client Field
    JTextField fullClientNameField = new JTextField();

    JTextField identificationNumberClientField = new JTextField();
    JTextField phoneNumberClientField = new JTextField();
    JTextField ageClientField = new JTextField();
    JComboBox<String> genderClientComboBox = new JComboBox<>();//


    //endregion


    //region Worker

    //Panels
    JPanel upWorkerPanel = new JPanel();
    JPanel midWorkerPanel = new JPanel();
    JPanel downWorkerPanel = new JPanel();


    //Buttons
    JButton addWorkerButton = new JButton("Add");
    JButton deleteWorkerButton = new JButton("Delete");
    JButton editWorkerButton = new JButton("Edit");
    JButton searchWorkerButton = new JButton("Search by IN");
    JButton refreshWorkerButton = new JButton("Refresh");

    // Worker Label
    JLabel idWorkerLabel = new JLabel("ID:");
    JLabel idNumberWorkerLabel = new JLabel("");
    JLabel genderWorkerLabel = new JLabel("Gender");
    JLabel fullNameWorkerLabel = new JLabel("Full name");
    JLabel identificationNumberWorkerLabel = new JLabel("Identification number(EGN/IN)");
    JLabel workerPositionLabel = new JLabel("Select position");

    //--------------------------------

    // Worker Field
    JTextField fullNameWorkerField = new JTextField();

    JTextField identificationNumberWorkerField = new JTextField();
    JComboBox<String> workerPositionComboBox = new JComboBox<>();
    JComboBox<String> genderWorkerComboBox = new JComboBox<>();//

    //endregion


    //region Loan

    //Panels
    JPanel upLoanPanel = new JPanel();
    JPanel midLoanPanel = new JPanel();
    JPanel downLoanPanel = new JPanel();


    //Buttons
    JButton addLoanButton = new JButton("Add");
    JButton deleteLoanButton = new JButton("Delete");
    JButton editLoanButton = new JButton("Edit");
    JButton searchLoanButton = new JButton("Search by client and worker");
    JButton refreshLoanButton = new JButton("Refresh");

    // Loan Label
    JLabel idLoanLabel = new JLabel("ID:");
    JLabel idNumberLoanLabel = new JLabel("");

    JLabel clientLoanLabel = new JLabel("Select client");
    JLabel workerLoanLabel = new JLabel("Select worker");
    JLabel amountLoanLabel = new JLabel("Loan amount (Separate with . )");
    JLabel interestRateLoanLabel = new JLabel("Interest rate (Separate with . )");

    JLabel amountToPayLoanLabel = new JLabel("Amount to pay:");
    JLabel amountToPayNumberLoanLabel = new JLabel("");

    //--------------------------------

    //Loan Field

    JComboBox<String> clientLoanComboBox = new JComboBox<>();
    JComboBox<String> workerLoanComboBox = new JComboBox<>();
    JTextField amountLoanField = new JTextField();
    JTextField interestRateLoanField = new JTextField();


    //endregion

    //region Search
    JPanel upSearchPanel = new JPanel();
    JPanel midSearchPanel = new JPanel();
    JPanel downSearchPanel = new JPanel();



    JButton searchSearchButton = new JButton("Search by client IN and worker ID");
    JButton refreshSearchButton = new JButton("Refresh");

    JLabel clientInSearchLabel = new JLabel("Enter client IN:(From table client)");
    JLabel workerIdLoanLabel = new JLabel("Enter worker ID:(From table worker)");

    JLabel emptySearchLabel = new JLabel(" ");

    JTextField clientInSearchField = new JTextField();
    JTextField workerIdLoanField = new JTextField();

    //endregion




    NewFrame() {                                     //The Constructor is here

        this.setSize(600, 550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        tab.add("Client", clientsPanel);
        tab.add("Worker", workersPanel);
        tab.add("Loan", loanPanel);
        tab.add("Search", SearchPanel);

        //region Client
        clientsPanel.setLayout(new GridLayout(3, 1));

        upClientPanel.setLayout(new GridLayout(6, 2)); // layout

        upClientPanel.add(idClientLabel);
        upClientPanel.add(idNumberClientLabel);

        upClientPanel.add(fullNameClientLabel);
        upClientPanel.add(fullClientNameField);

        upClientPanel.add(identificationNumberClientLabel);
        upClientPanel.add(identificationNumberClientField);

        upClientPanel.add(genderClientLabel);
        upClientPanel.add(genderClientComboBox);

        refreshGenderClientComboBox();

        upClientPanel.add(phoneNumberClientLabel);
        upClientPanel.add(phoneNumberClientField);
        upClientPanel.add(ageClientLabel);
        upClientPanel.add(ageClientField);

        clientsPanel.add(upClientPanel);


        midClientPanel.setLayout(new FlowLayout());  // layout

        midClientPanel.add(addClientButton);
        midClientPanel.add(deleteClientButton);
        midClientPanel.add(editClientButton);
        midClientPanel.add(searchClientButton);
        midClientPanel.add(refreshClientButton);


        // midClientPanel.add(clientComboBox);  //combobox !!!

        refreshClientButton.addActionListener(new RefreshClientAction());
        addClientButton.addActionListener(new AddClientAction());
        deleteClientButton.addActionListener(new DeleteClientAction());
        searchClientButton.addActionListener(new ClientSearchAction());
        editClientButton.addActionListener(new EditClientAction());


        clientsPanel.add(midClientPanel);      //add in middle

        clientTable.addMouseListener(new mouseClientAction());
        clientScroll.setPreferredSize(new Dimension(550, 150));

        downClientPanel.add(clientScroll);

        clientsPanel.add(downClientPanel);
        refreshClientTable();
        clearClientForm();
        // refreshClientCombo();


        //endregion

        //region Workers


        workersPanel.setLayout(new GridLayout(3, 1));

        upWorkerPanel.setLayout(new GridLayout(5, 2)); // layout


        upWorkerPanel.add(idWorkerLabel);
        upWorkerPanel.add(idNumberWorkerLabel);

        upWorkerPanel.add(fullNameWorkerLabel);
        upWorkerPanel.add(fullNameWorkerField);

        upWorkerPanel.add(identificationNumberWorkerLabel);
        upWorkerPanel.add(identificationNumberWorkerField);
        upWorkerPanel.add(workerPositionLabel);
        upWorkerPanel.add(workerPositionComboBox);

        upWorkerPanel.add(genderWorkerLabel);
        upWorkerPanel.add(genderWorkerComboBox);
        refreshGenderWorkerComboBox();

        workersPanel.add(upWorkerPanel);


        midWorkerPanel.setLayout(new FlowLayout());  // layout

        midWorkerPanel.add(addWorkerButton);
        midWorkerPanel.add(deleteWorkerButton);
        midWorkerPanel.add(editWorkerButton);
        midWorkerPanel.add(searchWorkerButton);
        midWorkerPanel.add(refreshWorkerButton);


        addWorkerButton.addActionListener(new AddWorkerAction());
        deleteWorkerButton.addActionListener(new DeleteWorkerAction());
        refreshWorkerButton.addActionListener(new RefreshWorkerAction());
        searchWorkerButton.addActionListener(new WorkerSearchAction());
        editWorkerButton.addActionListener(new EditWorkerAction());


        workersPanel.add(midWorkerPanel);  //add in middle

        workerTable.addMouseListener(new mouseWorkerAction());
        workersScroll.setPreferredSize(new Dimension(550, 150));

        downWorkerPanel.add(workersScroll);

        workersPanel.add(downWorkerPanel);

        refreshWorkerTable();
        clearWorkerForm();
        refreshWorkerLoanComboBox();
        refreshWorkerPositionComboBox();

        //endregion

        //region Loans

        loanPanel.setLayout(new GridLayout(3, 1));   // layout
        upLoanPanel.setLayout(new GridLayout(6, 2)); // layout


        upLoanPanel.add(idLoanLabel);
        upLoanPanel.add(idNumberLoanLabel);


        upLoanPanel.add(workerLoanLabel);
        upLoanPanel.add(workerLoanComboBox);

        upLoanPanel.add(clientLoanLabel);
        upLoanPanel.add(clientLoanComboBox);

        upLoanPanel.add(amountLoanLabel);
        upLoanPanel.add(amountLoanField);

        upLoanPanel.add(interestRateLoanLabel);
        upLoanPanel.add(interestRateLoanField);

        upLoanPanel.add(amountToPayLoanLabel);
        upLoanPanel.add(amountToPayNumberLoanLabel);

        loanPanel.add(upLoanPanel);

        midLoanPanel.setLayout(new FlowLayout());

        midLoanPanel.add(addLoanButton);
        midLoanPanel.add(deleteLoanButton);
        midLoanPanel.add(editLoanButton);
        midLoanPanel.add(searchLoanButton);
        midLoanPanel.add(refreshLoanButton);


        //  midLoanPanel.add(loanComboBox);

        addLoanButton.addActionListener(new AddLoanAction());
        deleteLoanButton.addActionListener(new DeleteLoanAction());
        refreshLoanButton.addActionListener(new RefreshLoanAction());
        searchLoanButton.addActionListener(new LoanSearchAction());
        editLoanButton.addActionListener(new EditLoanAction());

        loanPanel.add(midLoanPanel);


        loanTable.addMouseListener(new mouseLoanAction());
        loanScroll.setPreferredSize(new Dimension(550, 150));

        downLoanPanel.add(loanScroll);

        loanPanel.add(downLoanPanel);

        refreshLoanTable();
        clearLoanForm();

        refreshWorkerLoanComboBox();
        refreshClientLoanComboBox();


        //endregion


        SearchPanel.setLayout(new GridLayout(3, 1));  // 3 sections
        upSearchPanel.setLayout(new GridLayout(2, 2)); // layout



        upSearchPanel.add(clientInSearchLabel);
        upSearchPanel.add(clientInSearchField);

        upSearchPanel.add(workerIdLoanLabel);
        upSearchPanel.add(workerIdLoanField);

        SearchPanel.add(upSearchPanel);

        midSearchPanel.setLayout(new FlowLayout());

        midSearchPanel.add(searchSearchButton);
        midSearchPanel.add(refreshSearchButton);

        searchSearchButton.addActionListener(new searchSearchAction());
        refreshSearchButton.addActionListener(new refreshSearchAction());

        SearchPanel.add(midSearchPanel);


        searchScroll.setPreferredSize(new Dimension(550, 150));

        downSearchPanel.add(searchScroll);

        SearchPanel.add(downSearchPanel);




        this.add(tab);


        this.setVisible(true);


    }


    public void refreshClientTable() {

        connection = DBConnection.getConnection();
        try {
            statement = connection.prepareStatement("SELECT c.ID,CLIENT_FULL_NAME,IDENTIFICATION_NUMBER,PHONE_NUMBER,GENDER,AGE  FROM CLIENT c, GENDER g  WHERE c.GENDER_ID=g.ID;");
            resultSet = statement.executeQuery();
            clientTable.setModel(new MyModel(resultSet));
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }
    }

    public void refreshWorkerTable() {

        connection = DBConnection.getConnection();
        try {
            statement = connection.prepareStatement("SELECT w.ID,WORKER_FULL_NAME,GENDER,IDENTIFICATION_NUMBER,POSITION  FROM WORKER w, GENDER g,POSITION p  WHERE w.GENDER_ID=g.ID AND  w.POSITION_ID=p.ID");


            resultSet = statement.executeQuery();
            workerTable.setModel(new MyModel(resultSet));
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }
    }

    public void refreshLoanTable() {

        connection = DBConnection.getConnection();
        try {
            statement = connection.prepareStatement("SELECT l.ID,w.WORKER_FULL_NAME,c.CLIENT_FULL_NAME,AMOUNT,INTEREST_RATE  FROM LOAN l, WORKER w,CLIENT c  WHERE l.WORKER_ID=w.ID AND  l.CLIENT_ID=c.ID");


            resultSet = statement.executeQuery();
            loanTable.setModel(new MyModel(resultSet));
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }
    }


    //region Client Specific methods

    //region AddClientAction
    class AddClientAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO CLIENT VALUES(null , ? ,? ,? ,? ,?);";

            try {
                statement = connection.prepareStatement(sql);

                statement.setString(1, fullClientNameField.getText().toLowerCase());

                statement.setLong(2, Long.parseLong(identificationNumberClientField.getText()));
                statement.setString(3, phoneNumberClientField.getText());
                statement.setInt(4, ((genderClientComboBox.getSelectedIndex() + 1)));  //The first el is on [0]
                statement.setInt(5, Integer.parseInt(ageClientField.getText()));
                statement.execute();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            refreshClientTable();
            refreshLoanTable();
            clearClientForm();
            refreshClientLoanComboBox();
        }

    }
    //endregion

    class EditClientAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sql = "UPDATE CLIENT SET CLIENT_FULL_NAME=? ,identification_number=? ,phone_number=? ,gender_id=?,age=? WHERE ID=?;";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, fullClientNameField.getText().toLowerCase());
                statement.setLong(2, Long.parseLong(identificationNumberClientField.getText()));
                statement.setString(3, phoneNumberClientField.getText());
                statement.setInt(4, ((genderClientComboBox.getSelectedIndex() + 1)));  //The first el is on [0]
                statement.setInt(5, Integer.parseInt(ageClientField.getText()));

                statement.setInt(6, Integer.parseInt(idNumberClientLabel.getText()));
                statement.execute();

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

            refreshClientTable();
            refreshLoanTable();
            clearClientForm();
            refreshClientLoanComboBox();
        }

    }


    //region RefreshClientAction
    class RefreshClientAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshClientTable();
            refreshGenderClientComboBox();
            clearClientForm();

            refreshClientTable();

        }
    }
    //endregion

    //region ClientSearchAction
    class ClientSearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            connection = DBConnection.getConnection();
            String sql = "SELECT c.ID,CLIENT_FULL_NAME,IDENTIFICATION_NUMBER,PHONE_NUMBER,GENDER,AGE  FROM CLIENT c, GENDER g  WHERE c.GENDER_ID=g.ID AND  identification_number=? ;";
            //"SELECT * FROM CLIENT WHERE identification_number=?;";

            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, identificationNumberClientField.getText());
                resultSet = statement.executeQuery();

                clientTable.setModel(new MyModel(resultSet));

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }

            //  refreshCombo();

        }
    }
    //endregion


    //region DeleteClientAction
    class DeleteClientAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            connection = DBConnection.getConnection();
            String sql = "DELETE FROM CLIENT WHERE ID=?;";


            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                refreshClientTable();
                clearClientForm();
                id = -1;

            } catch (SQLException throwable) {
               // throwable.printStackTrace();
                System.out.println("Uncollected loans.Collect first the loan then delete!");
            }
            refreshClientLoanComboBox();
            refreshClientTable();
            refreshLoanTable();

        }

    }

//endregion


    public void refreshGenderClientComboBox() {
        genderClientComboBox.removeAllItems();
        connection = DBConnection.getConnection();
        String sql = "SELECT ID,GENDER FROM GENDER;";

        String item = "";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = resultSet.getObject(2).toString();
                genderClientComboBox.addItem(item);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }


    //region clearClientForm
    public void clearClientForm() {

        idNumberClientLabel.setText(null);
        fullClientNameField.setText(null);
        phoneNumberClientField.setText(null);
        identificationNumberClientField.setText(null);
        genderClientComboBox.setSelectedItem("");
        ageClientField.setText(null);
    }
    //endregion

    //region mouseClientAction
    class mouseClientAction implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = clientTable.getSelectedRow();
            id = Integer.parseInt(clientTable.getValueAt(row, 0).toString());
            if (e.getClickCount() > 1) {

                idNumberClientLabel.setText(clientTable.getValueAt(row, 0).toString());

                fullClientNameField.setText(clientTable.getValueAt(row, 1).toString());

                identificationNumberClientField.setText(clientTable.getValueAt(row, 2).toString());
                phoneNumberClientField.setText(clientTable.getValueAt(row, 3).toString());

                String Str1 = clientTable.getValueAt(row, 4).toString(); // from table
                for (int i1 = 0; i1 < genderClientComboBox.getItemCount(); ++i1) {
                    String selectedItem = genderClientComboBox.getItemAt(i1); //.ToString
                    String c1 = genderClientComboBox.getItemAt(i1);
                    if (c1 == Str1) {
                        genderClientComboBox.setSelectedIndex(i1);
                        break;
                    }
                }

                ageClientField.setText(clientTable.getValueAt(row, 5).toString());

            }
        }


        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    //endregion
    //endregion

    //region Worker Specific methods




    //region AddWorkerAction
    class AddWorkerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO WORKER VALUES(null , ? ,? ,? ,?);";

            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, fullNameWorkerField.getText().toLowerCase());
                statement.setInt(2, ((genderWorkerComboBox.getSelectedIndex() + 1)));  //The first el is on [0]
                statement.setLong(3, Long.parseLong(identificationNumberWorkerField.getText()));
                statement.setInt(4, ((workerPositionComboBox.getSelectedIndex()) + 1));// Because the first element is in[0]
                statement.execute();

                //here

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            refreshWorkerTable();

            refreshLoanTable();


            clearWorkerForm();
            refreshWorkerLoanComboBox();

        }

    }
    //endregion

    //region WorkerSearchAction
    class WorkerSearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            connection = DBConnection.getConnection();
            String sql = "SELECT w.ID,WORKER_FULL_NAME,GENDER,IDENTIFICATION_NUMBER,POSITION  FROM WORKER w, GENDER g,POSITION p  WHERE w.GENDER_ID=g.ID AND  w.POSITION_ID=p.ID AND identification_number=?;";

            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, identificationNumberWorkerField.getText());
                resultSet = statement.executeQuery();

                workerTable.setModel(new MyModel(resultSet));

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //endregion


    class RefreshWorkerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshWorkerTable();
            refreshWorkerPositionComboBox();
            clearWorkerForm();


        }
    }

    //region Edit Worker
    class EditWorkerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            connection = DBConnection.getConnection();
            String sql = "UPDATE WORKER SET WORKER_FULL_NAME=?,identification_number=? ,position_id=?,GENDER_ID=? WHERE ID=?;";

            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, fullNameWorkerField.getText().toLowerCase());

                statement.setLong(2, Long.parseLong(identificationNumberWorkerField.getText()));
                statement.setInt(3, ((workerPositionComboBox.getSelectedIndex()) + 1));// Because the first element is in[0]
                statement.setInt(4, ((genderWorkerComboBox.getSelectedIndex()) + 1));
                statement.setInt(5, Integer.parseInt(idNumberWorkerLabel.getText()));
                statement.execute();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            refreshWorkerTable();

            refreshLoanTable();
            clearWorkerForm();
            refreshWorkerLoanComboBox();


        }
    }
    //endregion


    //region DeleteWorkerAction
    class DeleteWorkerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            connection = DBConnection.getConnection();
            String sql = "DELETE FROM WORKER WHERE id=?;";
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                refreshWorkerTable();
                clearWorkerForm();
                id = -1;

            } catch (SQLException throwable) {
               // throwable.printStackTrace();
                System.out.println("Uncollected loans.Clear first the loan or change the the worker of it");
            }
            refreshWorkerLoanComboBox();
            refreshWorkerTable();

            refreshLoanTable();

        }

    }

//endregion

    public void refreshGenderWorkerComboBox() {
        genderWorkerComboBox.removeAllItems();
        connection = DBConnection.getConnection();
        String sql = "SELECT ID,GENDER FROM GENDER;";

        String item = "";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = resultSet.getObject(2).toString();
                genderWorkerComboBox.addItem(item);
            }

        } catch (SQLException throwable) {

            throwable.printStackTrace();
        }

    }


    //region refreshWorkerPositionComboBox
    public void refreshWorkerPositionComboBox() {
        workerPositionComboBox.removeAllItems();
        connection = DBConnection.getConnection();
        String sql = "SELECT ID,POSITION FROM POSITION";
        String item = "";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = resultSet.getObject(2).toString();
                workerPositionComboBox.addItem(item);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
    //endregion


    //region clearWorkerForm
    public void clearWorkerForm() {

        idNumberWorkerLabel.setText(null);
        fullNameWorkerField.setText(null);
        identificationNumberWorkerField.setText(null);
        workerPositionComboBox.setSelectedItem("Select position");
        genderWorkerComboBox.setSelectedIndex(0);

    }
    //endregion


    //region mouseWorkerAction
    class mouseWorkerAction implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = workerTable.getSelectedRow();
            id = Integer.parseInt(workerTable.getValueAt(row, 0).toString());
            if (e.getClickCount() > 1) {

                idNumberWorkerLabel.setText(workerTable.getValueAt(row, 0).toString());
                fullNameWorkerField.setText(workerTable.getValueAt(row, 1).toString());

                identificationNumberWorkerField.setText(workerTable.getValueAt(row, 3).toString());


                String Str1 = workerTable.getValueAt(row, 2).toString(); // from table
                for (int i1 = 0; i1 < genderWorkerComboBox.getItemCount(); ++i1) {
                    String selectedItem = genderWorkerComboBox.getItemAt(i1); //.ToString
                    String c1 = genderWorkerComboBox.getItemAt(i1);
                    if (c1 == Str1) {
                        genderWorkerComboBox.setSelectedIndex(i1);
                        break;
                    }
                }


                String Str = workerTable.getValueAt(row, 4).toString(); // from table
                for (int i = 0; i < workerPositionComboBox.getItemCount(); ++i) {
                    String selectedItem = workerPositionComboBox.getItemAt(i); //.ToString
                    String c = workerPositionComboBox.getItemAt(i);
                    if (c == Str) {
                        workerPositionComboBox.setSelectedIndex(i);
                        break;
                    }
                }


            }
        }


        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    //endregion

    //endregion

    //region Loan Specific methods


    //region AddLoanAction
    class AddLoanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO LOAN VALUES(null , ? ,? ,? ,?);";
            try {
                statement = connection.prepareStatement(sql);


                String str1 = clientLoanComboBox.getSelectedItem().toString();
                String[] str1Split = str1.split("_");
                int client_id = Integer.parseInt(str1Split[0]);
                statement.setInt(1, client_id);


                String str2 = workerLoanComboBox.getSelectedItem().toString();
                String[] str2Split = str2.split("_");
                int worker_id = Integer.parseInt(str2Split[0]);

                statement.setInt(2, worker_id);


                double amount = Double.parseDouble(amountLoanField.getText());
                double interest_rate = Double.parseDouble(interestRateLoanField.getText());

                statement.setDouble(3, amount);
                statement.setDouble(4, interest_rate);

                statement.execute();
                //here
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            refreshLoanTable();
            clearWorkerForm();
            refreshWorkerLoanComboBox();
        }

    }
    //endregion

    //region RefreshLoanAction
    class RefreshLoanAction implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            refreshLoanTable();

            refreshClientLoanComboBox();
            refreshWorkerLoanComboBox();
            clearLoanForm();
            refreshLoanTable();

        }
    }
    //endregion


    //region LoanSearchAction
    class LoanSearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            connection = DBConnection.getConnection();
            //#TODO FIX
            //SELECT l.ID,w.WORKER_FULL_NAME,c.CLIENT_FULL_NAME,AMOUNT,INTEREST_RATE  FROM LOAN l, WORKER w,CLIENT c  WHERE l.WORKER_ID=w.ID AND  l.CLIENT_ID=c.ID

            //
         //   String sql = "SELECT * FROM LOAN WHERE client_id=? AND worker_id=?;";

            String sql = "SELECT l.ID,w.WORKER_FULL_NAME,c.CLIENT_FULL_NAME,AMOUNT,INTEREST_RATE  FROM LOAN l, WORKER w,CLIENT c  WHERE l.WORKER_ID=w.ID AND  l.CLIENT_ID=c.ID AND l.WORKER_ID=? And l.CLIENT_ID=?; ";
            try {
                statement = connection.prepareStatement(sql);

                String str1 = clientLoanComboBox.getSelectedItem().toString();
                String[] str1Split = str1.split("_");
                int client_id = Integer.parseInt(str1Split[0]);
                statement.setInt(2, client_id);
                String str2 = workerLoanComboBox.getSelectedItem().toString();

                String[] str2Split = str2.split("_");
                int worker_id = Integer.parseInt(str2Split[0]);
                statement.setInt(1, worker_id);

                resultSet = statement.executeQuery();
                loanTable.setModel(new MyModel(resultSet));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    //endregion

    class EditLoanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            connection = DBConnection.getConnection();
            String sql = "UPDATE LOAN SET client_id=? ,worker_id=?,amount=? ,interest_rate=? WHERE ID=?;";

            try {


                statement = connection.prepareStatement(sql);


                String str1 = clientLoanComboBox.getSelectedItem().toString();
                String[] str1Split = str1.split("_");
                int client_id = Integer.parseInt(str1Split[0]);
                statement.setInt(1, client_id);

                String str = workerLoanComboBox.getSelectedItem().toString();
                String[] strSplit = str.split("_");
                int worker_id = Integer.parseInt(strSplit[0]);
                statement.setInt(2, worker_id);


                double amount = Double.parseDouble(amountLoanField.getText());
                double interest_rate = Double.parseDouble(interestRateLoanField.getText());

                statement.setDouble(3, amount);
                statement.setDouble(4, interest_rate);

                statement.setInt(5, Integer.parseInt(idNumberLoanLabel.getText()));

                statement.execute();
                //here
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            refreshLoanTable();

            clearLoanForm();
            refreshWorkerLoanComboBox();

        }
    }


    //region DeleteLoanAction
    class DeleteLoanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            connection = DBConnection.getConnection();
            String sql = "DELETE FROM LOAN WHERE ID=?";


            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                refreshLoanTable();
                clearLoanForm();
                id = -1;

            } catch (SQLException throwable) {

                throwable.printStackTrace();
            }

            refreshLoanTable();

        }

    }


    //region refreshWorkerLoanComboBox
    public void refreshWorkerLoanComboBox() {
        workerLoanComboBox.removeAllItems();
        connection = DBConnection.getConnection();
        String sql = "SELECT ID,WORKER_FULL_NAME FROM WORKER ";
        String item = "";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = resultSet.getObject(1).toString() + "_" + resultSet.getObject(2).toString();
                workerLoanComboBox.addItem(item);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
    //endregion


    //region refreshClientLoanComboBox
    public void refreshClientLoanComboBox() {
        clientLoanComboBox.removeAllItems();
        connection = DBConnection.getConnection();
        String sql = "SELECT ID,CLIENT_FULL_NAME FROM CLIENT;";
        String item = "";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                item = resultSet.getObject(1).toString() + "_" + resultSet.getObject(2).toString();
                clientLoanComboBox.addItem(item);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
    //endregion


    //region clearLoanForm
    public void clearLoanForm() {

        idNumberLoanLabel.setText(null);
        clientLoanComboBox.setSelectedItem("Select client");
        workerLoanComboBox.setSelectedItem("Select worker");
        amountLoanField.setText(null);
        interestRateLoanField.setText(null);
        amountToPayNumberLoanLabel.setText(null);

    }
    //endregion


    //region mouseLoanAction
    class mouseLoanAction implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = loanTable.getSelectedRow();
            id = Integer.parseInt(loanTable.getValueAt(row, 0).toString());
            if (e.getClickCount() > 1) {



                String str1 = loanTable.getValueAt(row, 2).toString();

                for (int i1 = 0; i1 < clientLoanComboBox.getItemCount(); ++i1) {
                    String c1 = clientLoanComboBox.getItemAt(i1);
                    String[] splitClient = c1.split("_");

                    if (str1.equals( splitClient[1])) {
                        clientLoanComboBox.setSelectedIndex(i1);
                        break;
                    }
                }


                String str = loanTable.getValueAt(row, 1).toString(); // from table

                for (int i1 = 0; i1 < workerLoanComboBox.getItemCount(); ++i1) {
                   String c2 = workerLoanComboBox.getItemAt(i1);
                    String[] splitWorker = c2.split("_");
                    if (str.equals(splitWorker[1] )) {
                        workerLoanComboBox.setSelectedIndex(i1);
                        break;
                    }
                }

                String amnt =loanTable.getValueAt(row, 3).toString();
                amountLoanField.setText(amnt);

                String intstR =loanTable.getValueAt(row, 4).toString();
                interestRateLoanField.setText(intstR);

                double amount = Double.parseDouble(amnt);
                double interestRate = Double.parseDouble(intstR);
                double amountToPay= amount+ (amount * interestRate) ;


                amountToPayNumberLoanLabel.setText(String.valueOf(amountToPay));


                idNumberLoanLabel.setText(loanTable.getValueAt(row, 0).toString());
            }
        }


        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }



    class searchSearchAction implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            connection = DBConnection.getConnection();
           String sql = "SELECT  LOAN.AMOUNT,LOAN.INTEREST_RATE FROM LOAN WHERE WORKER_ID=? AND CLIENT_ID=(SELECT ID FROM CLIENT WHERE IDENTIFICATION_NUMBER=?);";


            try {
                statement = connection.prepareStatement(sql);


                String str2 = workerIdLoanField.getText();

                int worker_id = Integer.parseInt(str2);

                statement.setInt(1, worker_id);


                String str1 = clientInSearchField.getText();

               int client_id = Integer.parseInt(str1);

               statement.setInt(2, client_id);






                resultSet = statement.executeQuery();
                searchTable.setModel(new MyModel(resultSet));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }


    class refreshSearchAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            clearSearchForm();



        }
    }


    public void clearSearchForm() {

        workerIdLoanField.setText(null);
        clientInSearchField.setText(null);


    }
    //endregion

    //endregion


}





