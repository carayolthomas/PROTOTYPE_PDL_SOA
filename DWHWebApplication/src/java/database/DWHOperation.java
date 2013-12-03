/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class DWHOperation {

    public static Session s;
    public static Transaction t;
    public static void insertCustomer(CustomerDWH pNewCustomer) {
        s.save(pNewCustomer);
    }
}
