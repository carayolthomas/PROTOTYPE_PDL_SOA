/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class CustomerDWH implements Serializable{

    private int mIdCustomerDWH;
    private String mFirstNameCustomerDWH;
    private String mLastNameCustomerDWH;
    private String mAdressCustomerDWH;
    private String mEmailCustomerDWH;


    public CustomerDWH () {
    }

    public CustomerDWH (String pFirstNameCustomerDWH, String pLastNameCustomerDWH) {
        mFirstNameCustomerDWH = pFirstNameCustomerDWH;
        mLastNameCustomerDWH = pLastNameCustomerDWH;
    }

    public CustomerDWH (int pIdCustomerDWH, String pFirstNameCustomerDWH, String pLastNameCustomerDWH) {
        mIdCustomerDWH = pIdCustomerDWH;
        mFirstNameCustomerDWH = pFirstNameCustomerDWH;
        mLastNameCustomerDWH = pLastNameCustomerDWH;
    }

    public CustomerDWH(String mFirstNameCustomerDWH, String mLastNameCustomerDWH, String mAdressCustomerDWH, String mEmailCustomerDWH) {
        this.mFirstNameCustomerDWH = mFirstNameCustomerDWH;
        this.mLastNameCustomerDWH = mLastNameCustomerDWH;
        this.mAdressCustomerDWH = mAdressCustomerDWH;
        this.mEmailCustomerDWH = mEmailCustomerDWH;
    }

    public String getmAdressCustomerDWH() {
        return mAdressCustomerDWH;
    }

    public void setmAdressCustomerDWH(String mAdressCustomerDWH) {
        this.mAdressCustomerDWH = mAdressCustomerDWH;
    }

    public String getmEmailCustomerDWH() {
        return mEmailCustomerDWH;
    }

    public void setmEmailCustomerDWH(String mEmailCustomerDWH) {
        this.mEmailCustomerDWH = mEmailCustomerDWH;
    }

    public String getmFirstNameCustomerDWH() {
        return mFirstNameCustomerDWH;
    }

    public void setmFirstNameCustomerDWH(String mFirstNameCustomerDWH) {
        this.mFirstNameCustomerDWH = mFirstNameCustomerDWH;
    }

    public int getmIdCustomerDWH() {
        return mIdCustomerDWH;
    }

    public void setmIdCustomerDWH(int mIdCustomerDWH) {
        this.mIdCustomerDWH = mIdCustomerDWH;
    }

    public String getmLastNameCustomerDWH() {
        return mLastNameCustomerDWH;
    }

    public void setmLastNameCustomerDWH(String mLastNameCustomerDWH) {
        this.mLastNameCustomerDWH = mLastNameCustomerDWH;
    }
}
