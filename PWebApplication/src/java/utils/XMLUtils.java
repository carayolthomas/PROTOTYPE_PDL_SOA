/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import hibernate.PsCustomer;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Fred
 */
public class XMLUtils {

    public static String customerToXML(Object o) {
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream os = new StringOutputStream();
            m.marshal(o, os);
            return os.toString();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    static class StringOutputStream extends OutputStream {

        private final StringBuilder string = new StringBuilder();

        @Override
        public void write(int b) throws IOException {
            this.string.append((char) b);
        }

        @Override
        public String toString() {
            return this.string.toString();
        }
    };

}
