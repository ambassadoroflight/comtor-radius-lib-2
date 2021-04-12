package net.comtor.radius.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;
import net.comtor.radius.entities.CampaignXZone;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since 1.8
 * @version Apr 16, 2019
 */
public class CampaignXZoneDao extends ComtorDaoElementLogicFacade<CampaignXZone, Long> {

    private static final Logger LOG = Logger.getLogger(CampaignXZoneDao.class.getName());

    public List<Long> findAllByCampaign(long campaign) throws ComtorDaoException {
        List<Long> zones = new ArrayList<>();

        try (ApplicationDao dao = new ApplicationDao()) {
            try (Connection conn = dao.getJdbcConnection()) {
                String query = "\n"
                        + " SELECT \n"
                        + "     campaign_x_zone.zone \n"
                        + " FROM    \n"
                        + "     campaign_x_zone \n"
                        + " WHERE   \n"
                        + "     campaign_x_zone.campaign = ? \n";

                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setLong(1, campaign);

                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            zones.add(rs.getLong(1));
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return zones;
    }

    public void deleteAllByCampaign(long campaign) throws ComtorDaoException {
        try (ApplicationDao dao = new ApplicationDao()) {
            try (Connection conn = dao.getJdbcConnection()) {
                String query = "\n"
                        + " DELETE FROM \n"
                        + "     campaign_x_zone \n"
                        + " WHERE \n"
                        + "     campaign_x_zone.campaign = ? \n";

                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setLong(1, campaign);

                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
