package net.comtor.radius.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import net.comtor.dao.annotations.ComtorDaoFactory;
import net.comtor.dao.annotations.ComtorElement;
import net.comtor.dao.annotations.ComtorId;
import web.connection.ApplicationDao;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 31, 2019
 */
@ComtorElement(tableName = "seller_auth_token")
@ComtorDaoFactory(factory = ApplicationDao.class)
public class SellerAuthToken implements Serializable {

    private static final long serialVersionUID = 8492900078250214625L;

    @ComtorId
    private String seller;
    private String token;
    private Timestamp expiration_date;

    public SellerAuthToken() {
    }

    public SellerAuthToken(String seller, String token, Timestamp expiration_date) {
        this.seller = seller;
        this.token = token;
        this.expiration_date = expiration_date;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Timestamp expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return "SellerAuthToken{"
                + "seller=" + seller
                + ", token=" + token
                + ", expiration_date=" + expiration_date
                + '}';
    }

}
