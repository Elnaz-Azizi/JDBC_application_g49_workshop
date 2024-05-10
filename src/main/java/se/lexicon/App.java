package se.lexicon;

import se.lexicon.jdbc_workshop.City;
import se.lexicon.jdbc_workshop.CityDaoJDBC;
import se.lexicon.jdbc_workshop.DatabaseConnector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DatabaseConnector mySqConnector = new DatabaseConnector();

        CityDaoJDBC cityDaoJDBC= new CityDaoJDBC(mySqConnector.getConnection());

        City foundCity1 = cityDaoJDBC.findById(20);
        System.out.println("foundCity1 = " + foundCity1);

    }
}
