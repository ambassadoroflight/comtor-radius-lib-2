package net.comtor.radius.dao;

import java.util.List;
import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;
import net.comtor.radius.entities.Campaign;
import net.comtor.radius.entities.CampaignXZone;

/**
 *
 * @author juandiego@comtor.net
 * @since 1.8
 * @version Apr 16, 2019
 */
public class CampaignDao extends ComtorDaoElementLogicFacade<Campaign, Long> {

    @Override
    public void create(Campaign entity) throws ComtorDaoException {
        if (entity.getStart_date() == null) {
            entity.setStart_date(new java.sql.Date(System.currentTimeMillis()));
        }

        super.create(entity);

        assignZones(entity);
    }

    @Override
    public void edit(Campaign entity) throws ComtorDaoException {
        if (entity.getStart_date() == null) {
            entity.setStart_date(new java.sql.Date(System.currentTimeMillis()));
        }

        super.edit(entity);

        updateZones(entity);
    }

    @Override
    public void remove(Campaign entity) throws ComtorDaoException {
        deleteZones(entity);

        super.remove(entity);
    }

    private void deleteZones(Campaign entity) throws ComtorDaoException {
        new CampaignXZoneDao().deleteAllByCampaign(entity.getId());
    }

    private void assignZones(Campaign campaign) throws ComtorDaoException {
        List<String> zones = campaign.getZones();

        if ( zones.isEmpty()) {
            return;
        }

        CampaignXZoneDao cxzDao = new CampaignXZoneDao();

        for (String zone : zones) {
            cxzDao.create(new CampaignXZone(campaign.getId(), Long.parseLong(zone)));
        }
    }

    private void updateZones(Campaign entity) throws ComtorDaoException {
        deleteZones(entity);
        assignZones(entity);
    }

}
