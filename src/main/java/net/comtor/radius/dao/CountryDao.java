package net.comtor.radius.dao;

import java.util.LinkedList;
import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;
import net.comtor.radius.entities.Country;

/**
 *
 * @author juandiego@comtor.net
 * @since
 * @version May 03, 2019
 */
public class CountryDao extends ComtorDaoElementLogicFacade<Country, String> {

    @Override
    public LinkedList<Country> findAll() throws ComtorDaoException {
        String query = getFindQuery() + " ORDER BY country.name ASC \n";

        return findAll(query);
    }

}
