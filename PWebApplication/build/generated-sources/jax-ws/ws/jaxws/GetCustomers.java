
package ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCustomers", namespace = "http://ws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomers", namespace = "http://ws/")
public class GetCustomers {

    @XmlElement(name = "arg0", namespace = "", nillable = true)
    private int[] arg0;

    /**
     * 
     * @return
     *     returns int[]
     */
    public int[] getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(int[] arg0) {
        this.arg0 = arg0;
    }

}
