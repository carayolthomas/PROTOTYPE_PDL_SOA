/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import hibernate.PsCustomer;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import service.CustomerService;
import utils.XMLUtils;

/**
 *
 * @author Fred
 */
@WebService(serviceName = "CustomersToUpdateWS")
public class CustomersToUpdateWS {

    @WebMethod(operationName = "getIdsToUpdate")
    public int[] getIdsToUpdate() {
        return CustomerService.getNbCustomersUpdatedFrom(new Date());
    }

    @WebMethod(operationName = "getCustomers")
    public String getCustomers(int[] ids) {
        List<PsCustomer> customers = CustomerService.getCustomers(ids);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            PsCustomer c = customers.get(i);
            sb.append(XMLUtils.customerToXML(c));
        }
        return sb.toString();
    }

    @WebMethod(operationName = "test")
    public String test() {
        return getCustomers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

}
