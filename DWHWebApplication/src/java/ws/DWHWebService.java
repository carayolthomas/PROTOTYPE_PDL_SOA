/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import database.CustomerDWH;
import database.DWHHibernateUtil;
import database.DWHOperation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author root
 */
@WebService()
public class DWHWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCustomer")
    public String addCustomer(String toDisplay) {
        /** Init BD */
        DWHOperation.s = DWHHibernateUtil.getSessionFactory().openSession();
        DWHOperation.t = DWHOperation.s.beginTransaction();
        System.out.println("DEBUG --- " + toDisplay);
        /** Write the XML in a file */
        File xmlCustomers = new File("customersToInsert.xml");
        FileWriter fw;
        try {
            fw = new FileWriter(xmlCustomers);
            fw.write("<?xml version=\"1.0\"?>");
            fw.write("<root>");
            fw.write(toDisplay);
            fw.write("</root>");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(DWHWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        /** Parse this file to get customer by customer */
        SAXBuilder builder = new SAXBuilder();
        try {
            Document doc = builder.build(xmlCustomers);
            Element racine = doc.getRootElement();
            List children = racine.getChildren("psCustomer");
            Iterator ite = children.iterator();
            while(ite.hasNext()) {
                /** Traitement psCustomer */
                Element e = (Element) ite.next();
                System.out.println("FIRSTNAME : " + e.getChildText("firstname"));
                System.out.println("LASTNAME : " + e.getChildText("lastname"));
                System.out.println("EMAIL : " + e.getChildText("email"));
                
                DWHOperation.insertCustomer(new CustomerDWH(e.getChildText("firstname"), e.getChildText("lastname"), e.getChildText("email"), "23 rue dulaurier 31000 Toulouse"));
            }
        } catch (JDOMException ex) {
            Logger.getLogger(DWHWebService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DWHWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0 ; i < 100 ; i++) {
            DWHOperation.insertCustomer(new CustomerDWH("Toto", "Yolo", "totoyolo@gmail.com", "23 rue dulaurier 31000 Toulouse"));
        }
        DWHOperation.t.commit();
        return "addCustomerDone";
    }

}
