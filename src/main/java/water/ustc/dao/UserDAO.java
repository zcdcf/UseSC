package water.ustc.dao;

import sc.ustc.dao.BaseDAO;
import sc.ustc.dao.Conversation;
import water.ustc.bean.UserBean;
import water.ustc.model.ConstRepo;
import water.ustc.util.FormattedTime;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

/**
 * Creator: hfang
 * Date: 2018/12/29 15:14
 * Description:
 **/

public class UserDAO extends BaseDAO {
    private static final String TAG = FormattedTime.getCurrentTime()+"water.ustc.dao:";
    public UserDAO(String url, String userName, String userPassword, String driver) {
        super(url, userName, userPassword, driver);
    }

    public UserDAO() {

    }
    @Override
    public Object query(Object queryObj, String field) {
        Conversation conversation = new Conversation();
        UserBean userBean = (UserBean) conversation.getObject(queryObj, field);
        return userBean;
    }

    @Override
    public boolean insert(String s) {
        return false;
    }

    @Override
    public boolean update(String s) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

/*    public Object query(String sql) {
        Connection connection = super.openDBConnection();
        ResultSet resultSet = null;
        UserBean userBean = null;
        try {
            Statement statement = connection.createStatement();
            System.out.println(TAG+"sql="+sql);
            resultSet = statement.executeQuery(sql);
            String name = null;
            String password = null;
            if (resultSet.next()) {
                name = resultSet.getString(1);
                password = resultSet.getString(2);
            }
            if(name!=null) {
                userBean = new UserBean(ConstRepo.DB_DEFAULT_USERID, name, password);
                System.out.println(TAG+"name is "+name+" password is "+password);
            } else {
                System.out.println(TAG+"didn't find user in database");
                userBean = null;
            }
            statement.close();
            super.closeDBConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;
    }

    public boolean insert(String sql) {
        return update(sql);
    }

    public boolean update(String sql) {
        Connection connection = super.openDBConnection();
        int updateRowNum = 0;
        try {
            Statement statement = connection.createStatement();
            updateRowNum = statement.executeUpdate(sql);
            statement.close();
            super.closeDBConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return updateRowNum > 0;

    }

    public boolean delete(String sql) {
        return update(sql);
    }*/
}
