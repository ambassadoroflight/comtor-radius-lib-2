package net.comtor.radius.entities;

import java.io.Serializable;
import web.connection.ApplicationDao;
import net.comtor.dao.ComtorJDBCDao;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorId;
import net.comtor.dao.annotations.ComtorSequence;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
//TODO: QUÉ HACE ESTE ELEMENTO?
//TODO: COMO QUE ESTO REALMENTE NO HACE MUCHO... REVISAR LUEGUITO...
@ComtorElement(tableName = "customer_hotspot")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class CustomerHotspot implements Serializable {

    private static final long serialVersionUID = 8655089997271260086L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private long hotspot;
    private String login;
    private java.sql.Date creation_date;
    private String created_by;
    private boolean active;

    public CustomerHotspot() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHotspot() {
        return hotspot;
    }

    public void setHotspot(long hotspot) {
        this.hotspot = hotspot;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public java.sql.Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(java.sql.Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerHotpot{"
                + "id=" + id
                + ", hotspot=" + hotspot
                + ", login=" + login
                + ", creation_date=" + creation_date
                + ", created_by=" + created_by
                + ", active=" + active
                + '}';
    }

}
