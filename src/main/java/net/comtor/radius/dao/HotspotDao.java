package net.comtor.radius.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;
import net.comtor.radius.entities.Hotspot;
import net.comtor.util.StringUtil;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
public class HotspotDao extends ComtorDaoElementLogicFacade<Hotspot, Long> {

    public List<Hotspot> find(final Long sponsor, final long zone, final String country, final java.sql.Date startDate, final java.sql.Date endDate) throws ComtorDaoException {
        String query = "\n"
                + " SELECT \n"
                + "     h.* \n"
                + " FROM \n"
                + "     hotspot h \n";

        if ((sponsor > 0) || (startDate != null) || (endDate != null)) {
            query += ""
                    + " JOIN campaign_x_zone cxz    ON cxz.zone = h.zone \n"
                    + " JOIN campaign c             ON c.id = cxz.campaign \n";
        }

        if ((zone > 0) || StringUtil.isValid(country)) {
            query += " JOIN zone z ON z.id = h.zone \n";
        }

        query += ""
                + " WHERE \n"
                + "     1 = 1 \n";
        List<Object> params = new ArrayList<>();

        if (sponsor > 0) {
            query += "  AND c.sponsor = ? \n";
            params.add(sponsor);
        }

        if (zone > 0) {
            query += "  AND h.zone = ? \n";
            params.add(zone);
        }

        if (StringUtil.isValid(country)) {
            query += "  AND z.country = ? \n";
            params.add(country);
        }

        if (startDate != null) {
            query += "  AND c.start_date >= ? \n";
            params.add(startDate);
        }

        if (endDate != null) {
            query += "  AND c.end_date <= ? \n";
            params.add(endDate);
        }

        return findAll(query, params.toArray());
    }

    public Hotspot findByCalledStationIdAndIpAddress(final String calledStationId, final String ipAddress) throws ComtorDaoException {
        String query = getFindQuery()
                + " WHERE \n"
                + "     hotspot.called_station_id = ? \n"
                + " AND hotspot.ip_address = ? \n";
        Object[] params = {calledStationId, ipAddress};
        LinkedList<Hotspot> hotspots = findAll(query, params);

        return hotspots.isEmpty() ? null : hotspots.getFirst();
    }

    public long getCountByZone(long zone) throws ComtorDaoException {
        String query = getFindQuery() + " WHERE hotspot.zone = ? \n";

        return super.getCountElements(query, zone);
    }

    public void deleteHotspotsFromZone(final long zone) throws ComtorDaoException {
        try (ApplicationDao dao = new ApplicationDao()) {
            try (Connection conn = dao.getJdbcConnection()) {
                String update = "UPDATE hotspot SET zone = 0 WHERE hotspot.zone = ? \n";

                try (PreparedStatement ps = conn.prepareStatement(update)) {
                    ps.setLong(1, zone);

                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            throw new ComtorDaoException(ex);
        }
    }

}
