package net.comtor.radius.dao;

import java.util.LinkedList;
import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;
import net.comtor.radius.entities.HappyHour;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
public class HappyHourDao extends ComtorDaoElementLogicFacade<HappyHour, Long> {

    public HappyHour findByPinAndHotspot(final String pin, final long hotspot) throws ComtorDaoException {
        String query = getFindQuery()
                + " WHERE \n"
                + "     happy_hour.login = ? \n"
                + " AND happy_hour.hotspot = ? \n";
        Object[] params = {pin, hotspot};

        LinkedList<HappyHour> happyHours = findAll(query, params);

        return happyHours.isEmpty() ? null : happyHours.getFirst();
    }

}
