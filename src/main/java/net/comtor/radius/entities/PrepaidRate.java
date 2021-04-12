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
@ComtorElement(tableName = "prepaid_rate")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class PrepaidRate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private String description;
    private long duration_in_seconds;

    public PrepaidRate() {
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

    public long getDuration_in_seconds() {
        return duration_in_seconds;
    }

    public void setDuration_in_seconds(long duration_in_seconds) {
        this.duration_in_seconds = duration_in_seconds;
    }

    @Override
    public String toString() {
        return "PrepaidRate{"
                + "id=" + id
                + ", description=" + description
                + ", duration_in_seconds=" + duration_in_seconds
                + '}';
    }

}
