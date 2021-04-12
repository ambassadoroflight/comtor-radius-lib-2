package net.comtor.radius.entities;

import java.io.Serializable;
import net.comtor.dao.ComtorJDBCDao;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorId;
import net.comtor.dao.annotations.ComtorSequence;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since 1.8
 * @version Apr 16, 2019
 */
@ComtorElement(tableName = "campaign_x_zone")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class CampaignXZone implements Serializable {

    private static final long serialVersionUID = -6052896405478508213L;

    @ComtorId
    @ComtorSequence(name = ComtorJDBCDao.MYSQL_SEQUENCE, typeInsert = ComtorSequence.POST_INSERT)
    private long id;
    private long campaign;
    private long zone;

    public CampaignXZone() {
    }

    public CampaignXZone(long campaign, long zone) {
        this.campaign = campaign;
        this.zone = zone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCampaign() {
        return campaign;
    }

    public void setCampaign(long campaign) {
        this.campaign = campaign;
    }

    public long getZone() {
        return zone;
    }

    public void setZone(long zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "CampaignXZone{"
                + "id=" + id
                + ", campaign=" + campaign
                + ", zone=" + zone
                + '}';
    }

}
