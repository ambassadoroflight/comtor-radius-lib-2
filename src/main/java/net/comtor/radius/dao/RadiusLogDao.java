package net.comtor.radius.dao;

import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;
import net.comtor.radius.entities.RadiusLog;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
public class RadiusLogDao extends ComtorDaoElementLogicFacade<RadiusLog, Long> {

    @Override
    public void create(RadiusLog entity) throws ComtorDaoException {
        long now = System.currentTimeMillis();
        
        entity.setDate(new java.sql.Date(now));
        entity.setHour(new java.sql.Time(now));
        entity.setDatetime(new java.sql.Timestamp(now));

        super.create(entity);
    }

}
