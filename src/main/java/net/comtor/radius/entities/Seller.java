package net.comtor.radius.entities;

import java.io.Serializable;
import web.connection.ApplicationDao;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorField;
import net.comtor.dao.annotations.ComtorForeingField;
import net.comtor.dao.annotations.ComtorId;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
@ComtorElement(tableName = "seller")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class Seller implements Serializable {

    private static final long serialVersionUID = -4854529801196712606L;

    @ComtorId
    private String login;
    private String password;
    @ComtorField(insertable = false, updatable = false, selectable = false)
    private String confirm_password;
    private String salt;
    private String name;
    private String document_id;
    private String email;
    private String phone;
    private String address;
    private long kiosk;
    private boolean active;

    @ComtorForeingField(foreingColumn = "name", referencesClass = Kiosk.class, referencesColumn = "kiosk")
    private String kiosk_name;

    public Seller() {
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

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean deleted) {
        this.active = deleted;
    }

    public long getKiosk() {
        return kiosk;
    }

    public void setKiosk(long kiosk) {
        this.kiosk = kiosk;
    }

    public String getKiosk_name() {
        return kiosk_name;
    }

    public void setKiosk_name(String kiosk_name) {
        this.kiosk_name = kiosk_name;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    @Override
    public String toString() {
        return "Seller{"
                + "login=" + login
                + ", name=" + name
                + ", document_id=" + document_id
                + ", email=" + email
                + ", phone=" + phone
                + ", address=" + address
                + ", kiosk=" + kiosk
                + ", active=" + active
                + '}';
    }

}
