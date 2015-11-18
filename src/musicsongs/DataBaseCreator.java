/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package musicsongs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rosco_000
 */
public class DataBaseCreator {
    Connection connection;
    Statement statement;

    public DataBaseCreator()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Derby driver not found.");
        }

        try
        {
            connection = DriverManager.getConnection
            ("jdbc:derby://localhost:1527/MusicShop;create=true;user=admin;pass=admin");
            statement = connection.createStatement();
            try
            {
                statement.execute("drop table TITLES_PERFORMERS");
            }
            catch (SQLException e)
            {
                System.out.println("Table did not previously exist " + e);
            }
            statement.execute("create table " +
                "TITLES_PERFORMERS (" +
                "ID varchar(12) primary key not null, " +
                "TITLE varchar(24), " +
                "PERFORMER varchar(24) )" ) ; ;
        }
        catch (SQLException sqle)
        {
            System.err.println("Problem:" + sqle);
        }
    }

    public void addData()
    {
        try
        {
            statement.execute("insert into TITLES_PERFORMERS values " +
               "('1', 'Get Back', 'The Beatles')");
            statement.execute("insert into TITLES_PERFORMERS values " +
               "('2', 'Honky Tonk Woman', 'The Rolling Stones')");
            statement.execute("insert into TITLES_PERFORMERS values " +
               "('3', 'Rollin n Tumblin', 'Canned Heat')");
        }
        catch (SQLException sqle)
        {
            System.err.println("Problem populating data:" + sqle);
        }
    }

    public void showData()
    {
        try
        {
            statement.execute("select TITLE from TITLES_PERFORMERS");
            ResultSet results = statement.getResultSet();
            while (results.next())
            {
                String songTitle = results.getString("TITLE");
                System.out.println(songTitle);
            }
        }
        catch (SQLException e)
        {
            // nothing wrong
        }
    }
}
