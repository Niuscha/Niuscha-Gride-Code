package ie.ulster;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        ArrayList <Client> customer = new ArrayList<Client>();

        Grid <Client> grid = new Grid <>();
        
		grid.setItems(customer);
        grid.addColumn(Client::getId).setCaption("Id");
        grid.addColumn(Client::getFirst_Name).setCaption("First Name");
        grid.addColumn(Client::getLast_Name).setCaption("Last Name");
        grid.addColumn(Client::getCity).setCaption("City");
        grid.addColumn(Client::isPaid).setCaption("Paid");
        grid.addColumn(Client::getAmount).setCaption("Amount"); 
     

                
        String connetionString =    "jdbc:sqlserver://napcustomer1.database.windows.net:1433;" +
                                    "database=NiuschaDB1;" +
                                    "user=Niuscha@napcustomer1;" +
                                    "password=Microsoft123;" +
                                    "encrypt=true;trustServerCertificate=false;" +
                                    "hostNameInCertificate=*.database.windows.net;" +
                                    "loginTimeout=30;";

        Connection connection = null;

        try 
        
        {
			connection = DriverManager.getConnection(connetionString);
		    ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM clientTable;");
        
            while (rs.next())

            {
                
            customer.add(new Client (rs.getString("Id"),
                                    rs.getString("FIRST_NAME"),
                                    rs.getString("LAST_NAME"),
                                    rs.getString("City"),
                                    rs.getBoolean("paid"),
                                    rs.getInt("amount")));
            }

            layout.addComponent(grid);
            
        }

        

        catch (Exception error)
            {
                layout.addComponent(new Label(error.getMessage()));
            }
        
        setContent(layout);
            
        }

        

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {}

}