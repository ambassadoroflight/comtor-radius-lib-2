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
@ComtorElement(tableName = "radius_log")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class RadiusLog implements Serializable {

    public enum Type {

        ACCESO,
        ERROR
    }

    private static final long serialVersionUID = -4617685435579611411L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private long hotspot;
    private String user;
    private String type;
    private String message;
    private String called_station_id;
    private String calling_mac_address;
    private java.sql.Date date;
    private java.sql.Time hour;
    private java.sql.Timestamp datetime;

    public RadiusLog() {
    }

    public RadiusLog(long hotspot, String message, String username, String type) {
        this.hotspot = hotspot;
        this.user = username;
        this.type = type;
        this.message = message;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCalled_station_id() {
        return called_station_id;
    }

    public void setCalled_station_id(String called_station_id) {
        this.called_station_id = called_station_id;
    }

    public String getCalling_mac_address() {
        return calling_mac_address;
    }

    public void setCalling_mac_address(String calling_mac_address) {
        this.calling_mac_address = calling_mac_address;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public java.sql.Time getHour() {
        return hour;
    }

    public void setHour(java.sql.Time hour) {
        this.hour = hour;
    }

    public java.sql.Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(java.sql.Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "RadiusLog{"
                + "id=" + id
                + ", hotspot=" + hotspot
                + ", user=" + user
                + ", type=" + type
                + ", message=" + message
                + ", called_station_id=" + called_station_id
                + ", calling_mac_address=" + calling_mac_address
                + ", date=" + date
                + ", hour=" + hour
                + ", datetime=" + datetime
                + '}';
    }

}
