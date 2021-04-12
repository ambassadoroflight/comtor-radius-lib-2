package net.comtor.radius.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;
import net.comtor.radius.entities.SellerAuthToken;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 31, 2019
 */
public class SellerAuthTokenDao extends ComtorDaoElementLogicFacade<SellerAuthToken, String> {

    private static final Logger LOG = Logger.getLogger(SellerAuthTokenDao.class.getName());

    public void save(SellerAuthToken entity) throws ComtorDaoException {
        try (ApplicationDao dao = new ApplicationDao()) {
            try (Connection conn = dao.getJdbcConnection()) {
                String query = "\n"
                        + " INSERT INTO \n"
                        + "     seller_auth_token (seller, token, expiration_dare) \n"
                        + " VALUES \n"
                        + "     (?, ?, ?) \n"
                        + " ON DUPLICATE KEY UPDATE \n"
                        + "     token = ?, \n"
                        + "     expiration_date = ? \n";

                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    String seller = entity.getSeller();
                    String authToken = entity.getToken();
                    Timestamp expirationDate = entity.getExpiration_date();

                    int pos = 1;
                    ps.setString(pos++, seller);
                    ps.setString(pos++, authToken);
                    ps.setTimestamp(pos++, expirationDate);
                    ps.setString(pos++, authToken);
                    ps.setTimestamp(pos++, expirationDate);

                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

}
