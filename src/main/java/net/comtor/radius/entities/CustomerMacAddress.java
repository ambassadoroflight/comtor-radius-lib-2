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
//TODO: ESTA COMO QUE TAMPOCO SE USA... REVISAR AL RATO
@ComtorElement(tableName = "customer_mac_address")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class CustomerMacAddress implements Serializable {

    private static final long serialVersionUID = -8455823888732090597L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private long hotspot;
    private String mac_address;
    private String description;
    private Timestamp creation_date;
    private String created_by;
    private Timestamp first_use_date;
    private boolean active;
    private int hotspot_joined;

    public CustomerMacAddress() {
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

    public String getCreado_por() {
        return created_by;
    }

    public void setCreado_por(String creado_por) {
        this.created_by = creado_por;
    }

    public Timestamp getFirst_use_date() {
        return first_use_date;
    }

    public void setFirst_use_date(Timestamp first_use_date) {
        this.first_use_date = first_use_date;
    }

    public int getHotspot_joined() {
        return hotspot_joined;
    }

    public void setHotspot_joined(int hotspot_joined) {
        this.hotspot_joined = hotspot_joined;
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
        return "CustomerMacAddress{"
                + "id=" + id
                + ", hotspot=" + hotspot
                + ", mac_address=" + mac_address
                + ", description=" + description
                + ", creation_date=" + creation_date
                + ", created_by=" + created_by
                + ", first_use_date=" + first_use_date
                + ", active=" + active
                + ", hotspot_joined=" + hotspot_joined
                + '}';
    }

}
