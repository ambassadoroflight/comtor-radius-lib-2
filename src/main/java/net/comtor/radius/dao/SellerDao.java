package net.comtor.radius.dao;

import net.comtor.aaa.helper.PasswordHelper2;
import net.comtor.radius.entities.Seller;
import net.comtor.dao.ComtorDaoException;
import net.comtor.dao.generics.ComtorDaoElementLogicFacade;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 24, 2018
 */
public class SellerDao extends ComtorDaoElementLogicFacade<Seller, String> {

    @Override
    public void create(Seller entity) throws ComtorDaoException {
        encryptPassword(entity);

        super.create(entity);
    }

    @Override
    public void edit(Seller entity) throws ComtorDaoException {
        editPassword(entity);

        super.edit(entity);
    }

    private void encryptPassword(Seller entity) throws ComtorDaoException {
        final String salt = PasswordHelper2.getHelper().createSalt();

        entity.setSalt(salt);
        entity.setPassword(PasswordHelper2.getHelper().encryption(entity.getPassword(), salt));
    }

    private void editPassword(Seller entity) throws ComtorDaoException {
        if (entity.getPassword().equals("nochange")) {
            Seller currentCustomer = find(entity.getLogin());
            entity.setPassword(currentCustomer.getPassword());
            entity.setSalt(currentCustomer.getSalt());

            return;
        }

        encryptPassword(entity);
    }

    // TODO
    @Deprecated
    public String validateAccess(String loginSeller, String passwd) throws ComtorDaoException {
        Seller seller = find(loginSeller);
        
        if (seller == null) {
            return "Usuario no existe";
        }

        if (!seller.getPassword().equals(passwd)) {
            return "Contrasena invalida";
        }

        return null;
    }

}
