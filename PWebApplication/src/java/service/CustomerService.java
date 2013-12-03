/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import hibernate.HibernateUtil;
import hibernate.PsCustomer;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import utils.RandomUtils.*;
import static utils.RandomUtils.randomDateInMilliseconds;
import static utils.RandomUtils.randomInt;
import static utils.RandomUtils.randomMD5;

/**
 *
 * @author Fred
 */
public class CustomerService {

    public static int[] getNbCustomersUpdatedFrom(Date limit) {
        int listIds[] = null;
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = sess.createCriteria(PsCustomer.class);
        Disjunction or = Restrictions.disjunction();
        or.add(Restrictions.gt("dateAdd", limit));
        or.add(Restrictions.gt("dateUpd", limit));
        crit.add(or);
        List<PsCustomer> allToUpdate = crit.list();
        for (PsCustomer customer : allToUpdate) {
            listIds = ArrayUtils.add(listIds, customer.getIdCustomer());
        }
        sess.close();
        return listIds;
    }

    public static List<PsCustomer> getCustomers(int[] ids) {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = sess.createCriteria(PsCustomer.class);
        Disjunction or = Restrictions.disjunction();
        for (int id : ids) {
            or.add(Restrictions.eq("idCustomer", id));
        }
        crit.add(or);
        List<PsCustomer> list = crit.list();
        sess.close();
        return list;
    }

    private static void populate(int imax) {
        Session sess = HibernateUtil.getSessionFactory().openSession();
        int i;
        PsCustomer newCustomer;
        for (i = 0; i < imax; i++) {
            Date update = new Date(randomDateInMilliseconds());
            newCustomer = new PsCustomer(1, 1, "Fred" + randomInt(), "Boisguer" + randomInt(), "freddy_" + randomInt() + "@gmail.com", randomMD5(), new Date(), true, true, randomMD5(), true, false, false, update, update);
            sess.save(newCustomer);
            System.out.println("Customer " + String.format("%1$6d", i) + " created");
        }
        sess.beginTransaction().commit();
        sess.close();
    }

    public static void main(String[] args) {
        populate(600);
//        System.out.println("Test = " + getNbCustomersUpdatedFrom(new Date()));
    }

}
