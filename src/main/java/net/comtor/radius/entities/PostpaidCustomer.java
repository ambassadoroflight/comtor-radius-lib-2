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
//TODO: MENOS... REVISAR IGUALMENTE....
@ComtorElement(tableName = "postpaid_customer")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class PostpaidCustomer implements Serializable {

    private static final long serialVersionUID = -7683838547565851276L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private String login;
    private String password;
    private String type;
    private String name;
    private String document;
    private String address;
    private String phone;
    private String phone2;
    private String email;
    private String local;
    private String description;
    private Timestamp creation_date;
    private String created_by;
    private Timestamp first_use_date;
    private boolean active;

    public PostpaidCustomer() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    @Override
    public String toString() {
        return "PostpaidCustomer{"
                + "id=" + id
                + ", login=" + login
                + ", type=" + type
                + ", name=" + name
                + ", document=" + document
                + ", address=" + address
                + ", phone=" + phone
                + ", phone2=" + phone2
                + ", email=" + email
                + ", local=" + local
                + ", description=" + description
                + ", creation_date=" + creation_date
                + ", created_by=" + created_by
                + ", first_use_date=" + first_use_date
                + ", active=" + active
                + '}';
    }

}
