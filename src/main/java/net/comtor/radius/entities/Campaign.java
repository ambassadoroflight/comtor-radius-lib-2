package net.comtor.radius.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.comtor.dao.ComtorJDBCDao;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorField;
import net.comtor.dao.annotations.ComtorForeingField;
import net.comtor.dao.annotations.ComtorId;
import net.comtor.dao.annotations.ComtorSequence;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since 1.8
 * @version Apr 16, 2019
 */
@ComtorElement(tableName = "campaign")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class Campaign implements Serializable {

    private static final long serialVersionUID = -7354386585376297503L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private String description;
    private String banner_1;
    private String banner_2;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private long sponsor;

    @ComtorForeingField(referencesClass = Sponsor.class, foreingColumn = "name", referencesColumn = "sponsor")
    private String sponsor_name;

    @ComtorField(insertable = false, updatable = false, findable = false, selectable = false)
    private List<String> zones;

    public Campaign() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBanner_1() {
        return banner_1;
    }

    public void setBanner_1(String banner_1) {
        this.banner_1 = banner_1;
    }

    public String getBanner_2() {
        return banner_2;
    }

    public void setBanner_2(String banner_2) {
        this.banner_2 = banner_2;
    }

    public java.sql.Date getStart_date() {
        return start_date;
    }

    public void setStart_date(java.sql.Date start_date) {
        this.start_date = start_date;
    }

    public java.sql.Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(java.sql.Date end_date) {
        this.end_date = end_date;
    }

    public long getSponsor() {
        return sponsor;
    }

    public void setSponsor(long sponsor) {
        this.sponsor = sponsor;
    }

    public String getSponsor_name() {
        return sponsor_name;
    }

    public void setSponsor_name(String sponsor_name) {
        this.sponsor_name = sponsor_name;
    }

    public List<String> getZones() {
        return (zones == null) ? new ArrayList<>() : zones;
    }

    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @Override
    public String toString() {
        return "Campaign{"
                + "id=" + id
                + ", description=" + description
                + ", banner_1=" + banner_1
                + ", banner_2=" + banner_2
                + ", start_date=" + start_date
                + ", end_date=" + end_date
                + ", sponsor=" + sponsor
                + ", sponsor_name=" + sponsor_name
                + '}';
    }

}
