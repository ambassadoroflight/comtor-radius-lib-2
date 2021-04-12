package net.comtor.radius.entities;

import java.io.Serializable;
import net.comtor.dao.ComtorJDBCDao;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorForeingField;
import net.comtor.dao.annotations.ComtorId;
import net.comtor.dao.annotations.ComtorSequence;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since 1.8
 * @version Apr 03, 2019
 */
@ComtorElement(tableName = "zone")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class Zone implements Serializable {

    private static final long serialVersionUID = -8208208000808458825L;

    public static final String DEFAULT_COUNTRY = "CO";

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private String name;
    private String country;

    @ComtorForeingField(referencesClass = Country.class, foreingColumn = "name", referencesColumn = "country")
    private String country_name;

    public Zone() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    @Override
    public String toString() {
        return "Zone{"
                + "id=" + id
                + ", name=" + name
                + ", country=" + country
                + '}';
    }

}
