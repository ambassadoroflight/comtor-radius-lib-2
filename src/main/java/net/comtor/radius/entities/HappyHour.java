package net.comtor.radius.entities;

import java.io.Serializable;
import java.sql.Timestamp;
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
@ComtorElement(tableName = "happy_hour")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class HappyHour implements Serializable {

    private static final long serialVersionUID = 3960940880052662108L;
    
    public static final String PIN_PREFIX = "HAP-";

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private long hotspot;
    private String login;
    private long start_time;
    private long end_time;
    private boolean sunday;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private Timestamp creation_date;
    private String created_by;

    @ComtorForeingField(foreingColumn = "name", referencesClass = Hotspot.class, referencesColumn = "hotspot")
    private String hotspot_name;

    public HappyHour() {
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

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    public String getHotspot_name() {
        return hotspot_name;
    }

    public void setHotspot_name(String hotspot_name) {
        this.hotspot_name = hotspot_name;
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

    @Override
    public String toString() {
        return "HappyHourPin{"
                + "id=" + id
                + ", hotspot=" + hotspot
                + ", login=" + login
                + ", start_time=" + start_time
                + ", end_time=" + end_time
                + ", sunday=" + sunday
                + ", monday=" + monday
                + ", tuesday=" + tuesday
                + ", wednesday=" + wednesday
                + ", thursday=" + thursday
                + ", friday=" + friday
                + ", saturday=" + saturday
                + ", creation_date=" + creation_date
                + ", created_by=" + created_by
                + ", hotspot_name=" + hotspot_name
                + '}';
    }

}
