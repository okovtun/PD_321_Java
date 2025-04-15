package org.openjfx.academyfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class HelloController {
    private Connector connector = null;
    @FXML
    private Label labelStatus;
    /*@FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private DatePicker age;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String data = lastName.getText() + " " + firstName.getText() + " " + age.getValue();
        welcomeText.setText(data);
        //welcomeText.setText("Welcome to JavaFX Application!");
        Alert alert = new Alert(Alert.AlertType.INFORMATION,data, ButtonType.OK);
        alert.setTitle("Hello " + firstName.getText());
        alert.show();
    }*/
    @FXML
    private ComboBox cbDirections;
    @FXML
    private Button load;
    @FXML
    private Button check;
    @FXML
    private TableView<String[]> tableDirections;

    @FXML
    protected void onLoadButtonClick() throws SQLException
    {
        String connectionString =
                "jdbc:sqlserver://localhost:1433;" +
                        "database=PD_212;" +
                        "user=PHP;" +
                        "password=111;" +
                        "Connect Timeout=30;Encrypt=True;" +
                        "TrustServerCertificate=True;";

        Connection connection = DriverManager.getConnection(connectionString);

        Statement statement = connection.createStatement();

        ResultSet set = statement.executeQuery("SELECT * FROM Directions");
        while (set.next())
        {
            cbDirections.getItems().add(set.getString("direction_name"));
        }
        set.close();;
        connection.close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, connectionString, ButtonType.OK);
        alert.show();
    }
    @FXML
    protected void onCheckButtonClick()
    {
        String msg = cbDirections.getValue().toString();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.show();
    }
    @FXML
    protected void loadDirections()throws SQLException, Exception
    {
        /*String connectionString =
                "jdbc:sqlserver://localhost:1433;" +
                        "database=PD_212;"+
                        "user=PHP;"+
                        "password=111;"+
                        "Connect Timeout=10;" +
                        "TrustServerCertificate=True";
        Connection connection = DriverManager.getConnection(connectionString);*/
        try {
            Statement statement = connector.getConnection().createStatement();

            ResultSet set = statement.executeQuery("SELECT * FROM Directions");
            for(int i=0; i<set.getMetaData().getColumnCount();i++)
            {
                TableColumn<String[], String> column = new TableColumn<>(set.getMetaData().getColumnLabel(i+1));
                tableDirections.getColumns().add(column);
                final int j = i;
                column.setCellValueFactory(data->new SimpleStringProperty(data.getValue()[j]));
            }

            while (set.next())
            {
                Collection<String> list = new ArrayList<>();
                for(int i=1; i<=set.getMetaData().getColumnCount();i++)
                {
                    list.add(set.getString(i));
                }
                String[] arr = new String[list.size()];
                list.toArray(arr);
                tableDirections.getItems().addAll(arr);
            }

            //connection.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    protected void connect()
    {
        if(connector == null)
        {
            String connectionString = "jdbc:sqlserver://localhost:1433;"
                + "database=PD_212;"
                + "user=PHP;"
                + "password=111;"
                + "ConnectTimeout=30;"
                + "Encrypt=True;"
                + "TrustServerCertificate=True;"
                + "ApplicationIntent=ReadWrite;"
                + "MultiSubnetFailover=False;";
            try
            {
                connector = new Connector(connectionString);
                labelStatus.setText("Connected\n" + connector.getConnection().toString());
            }
            catch (SQLException e)
            {
                Alert error = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                error.showAndWait();
            }
        }
        else
        {
            Alert error = new Alert(Alert.AlertType.ERROR, "Connection already established", ButtonType.OK);
            error.show();
        }
    }
    @FXML
    protected void disconnect()
    {
        if(connector != null)
        {
            try
            {
                connector.closeConnection();
                //TODO: clear all data
                connector = null;
                labelStatus.setText("Disconnected");
            }
            catch (SQLException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.showAndWait();
            }
        }
    }
}