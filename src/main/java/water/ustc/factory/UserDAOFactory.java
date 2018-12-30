package water.ustc.factory;

import water.ustc.dao.UserDAO;

/**
 * Creator: hfang
 * Date: 2018/12/30 15:48
 * Description:
 **/

public class UserDAOFactory {
    public static UserDAO getUserDAO(String url, String userName, String userPassword, String driver) {
        return new UserDAO(url, userName, userPassword, driver);
    }
}
