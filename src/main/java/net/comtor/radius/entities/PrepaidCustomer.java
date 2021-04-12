package net.comtor.radius.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import net.comtor.dao.ComtorJDBCDao;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorId;
import net.comtor.dao.annotations.ComtorSequence;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
@ComtorElement(tableName = "prepaid_customer")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class PrepaidCustomer implements Serializable {

    private static final long serialVersionUID = -1220569362289871130L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private String login;
    private String password;
    private String pin_type;
    private long hotspot;
    private long purchased_time;
    private String mac_address;
    private String description;
    private Timestamp creation_date;
    private java.sql.Date creation_ddate;
    private String created_by;
    private Timestamp first_use_date;
    private Timestamp end_session_date;
    private int hotspot_joined;
    private String attr_1;
    private String attr_2;
    private boolean active;

    public PrepaidCustomer() {
    }

    public PrepaidCustomer(String pin, long purchased_time, String pin_type, String created_by) {
        this.login = pin;
        this.password = "";
        this.pin_type = pin_type;
        this.mac_address = "";
        this.description = "";
        this.purchased_time = purchased_time;
        this.created_by = created_by;
        this.active = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPin_type() {
        return pin_type;
    }

    public void setPin_type(String pin_type) {
        this.pin_type = pin_type;
    }

    public long getHotspot() {
        return hotspot;
    }

    public void setHotspot(long hotspot) {
        this.hotspot = hotspot;
    }

    public long getPurchased_time() {
        return purchased_time;
    }

    public void setPurchased_time(long purchased_time) {
        this.purchased_time = purchased_time;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public java.sql.Date getCreation_ddate() {
        return creation_ddate;
    }

    public void setCreation_ddate(java.sql.Date creation_ddate) {
        this.creation_ddate = creation_ddate;
    }
    
    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getFirst_use_date() {
        return first_use_date;
    }

    public void setFirst_use_date(Timestamp first_use_date) {
        this.first_use_date = first_use_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getEnd_session_date() {
        return end_session_date;
    }

    public void setEnd_session_date(Timestamp end_session_date) {
        this.end_session_date = end_session_date;
    }

    public int getHotspot_joined() {
        return hotspot_joined;
    }

    public void setHotspot_joined(int hotspot_joined) {
        this.hotspot_joined = hotspot_joined;
    }

    public String getAttr_1() {
        return attr_1;
    }

    public void setAttr_1(String attr_1) {
        this.attr_1 = attr_1;
    }

    public String getAttr_2() {
        return attr_2;
    }

    public void setAttr_2(String attr_2) {
        this.attr_2 = attr_2;
    }

    @Override
    public String toString() {
        return "PrepaidCustomer{"
                + "id=" + id
                + ", login=" + login
                + ", pin_type=" + pin_type
                + ", hotspot=" + hotspot
                + ", purchased_time=" + purchased_time
                + ", mac_address=" + mac_address
                + ", description=" + description
                + ", creation_date=" + creation_date
                + ", created_by=" + created_by
                + ", first_use_date=" + first_use_date
                + ", active=" + active
                + ", end_session_date=" + end_session_date
                + ", hotspot_joined=" + hotspot_joined
                + ", attr_1=" + attr_1
                + ", attr_2=" + attr_2
                + '}';
    }

}
