package net.comtor.radius.entities;

import java.io.Serializable;
import web.connection.ApplicationDao;
import net.comtor.dao.ComtorJDBCDao;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorForeingField;
import net.comtor.dao.annotations.ComtorId;
import net.comtor.dao.annotations.ComtorSequence;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
@ComtorElement(tableName = "kiosk")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class Kiosk implements Serializable {

    private static final long serialVersionUID = -6209781043081691920L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private String nit;
    private String name;
    private String city;
    private String address;
    private String phone;
    private String email;
    private long hotspot;

    @ComtorForeingField(foreingColumn = "name", referencesClass = Hotspot.class, referencesColumn = "hotspot")
    private String hotspot_name;

    public Kiosk() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getHotspot() {
        return hotspot;
    }

    public void setHotspot(long hotspot) {
        this.hotspot = hotspot;
    }

    public String getHotspot_name() {
        return hotspot_name;
    }

    public void setHotspot_name(String hotspot_name) {
        this.hotspot_name = hotspot_name;
    }

    @Override
    public String toString() {
        return "Kiosk{"
                + "id=" + id
                + ", nit=" + nit
                + ", name=" + name
                + ", city=" + city
                + ", address=" + address
                + ", phone=" + phone
                + ", email=" + email
                + ", hotspot=" + hotspot
                + ", hotspotName=" + hotspot_name
                + '}';
    }

}
