//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.citygml.bridge._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BridgeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BridgeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/bridge/2.0}AbstractBridgeType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfBridge" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BridgeType", propOrder = {
    "_GenericApplicationPropertyOfBridge"
})
public class BridgeType
    extends AbstractBridgeType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfBridge", namespace = "http://www.opengis.net/citygml/bridge/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfBridge;

    /**
     * Gets the value of the genericApplicationPropertyOfBridge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBridge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfBridge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfBridge() {
        if (_GenericApplicationPropertyOfBridge == null) {
            _GenericApplicationPropertyOfBridge = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfBridge;
    }

    public boolean isSet_GenericApplicationPropertyOfBridge() {
        return ((this._GenericApplicationPropertyOfBridge!= null)&&(!this._GenericApplicationPropertyOfBridge.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfBridge() {
        this._GenericApplicationPropertyOfBridge = null;
    }

    public void set_GenericApplicationPropertyOfBridge(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfBridge = value;
    }

}
