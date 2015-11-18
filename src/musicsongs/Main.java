/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package musicsongs;

/**
 *
 * @author rosco_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataBaseCreator table = new DataBaseCreator();
      System.out.println("Table is created, but no content yet");
      table.showData();

      table.addData();
      System.out.println("Table now populated with data");
      table.showData();
    }

}
