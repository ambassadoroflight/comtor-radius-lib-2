package net.comtor.radius.entities;

import java.io.Serializable;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorId;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since 1.8
 * @version May 03, 2019
 */
@ComtorElement(tableName = "country")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class Country implements Serializable {

    private static final long serialVersionUID = -8252465684113316799L;

    @ComtorId
    private String iso;
    private String name;

    public Country() {
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{"
                + "iso=" + iso
                + ", name=" + name
                + '}';
    }

}
