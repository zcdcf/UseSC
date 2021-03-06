package water.ustc.bean;

import water.ustc.dao.UserDAO;
import water.ustc.util.FormattedTime;

/**
 * Creator: hfang
 * Date: 2018/12/26 09:40
 * Description:
 **/

public class UserBean {
    private String ID;
    private String userName;
    private String userPassword;
    private UserDAO userDAO;
    private static final String TAG = FormattedTime.getCurrentTime()+"water.ustc.bean.UserBean:";

    public UserBean() {

    }

    public UserBean(String ID, String userName, String userPassword) {
        this.ID = ID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public boolean signIn() {
        /*userDAO = UserDAOFactory.getUserDAO(ConstRepo.JDBC_PREFIX+ RunTimeVar.projectRootPath+ConstRepo.LOGIN_DB_PATH, ConstRepo.DB_DEFAULT_USERNAME, ConstRepo.DB_DEFAULT_PASSWORD, ConstRepo.LOG_DB_DRIVER);
        String sql = "SELECT * FROM logininfo where NAME=\""+this.userName+"\"";
        UserBean queryUser = (UserBean) userDAO.query(this);
        if(queryUser==null) {
            System.out.println(TAG+"didn't found data in db");
            return false;
        } else {
            System.out.println(TAG+"user data in db is name="+queryUser.getUserName()+" password="+queryUser.getUserPassword());
            System.out.println(TAG+"user commit data is name="+this.userName+" password="+this.userPassword);
            if(queryUser.getUserPassword().equals(this.userPassword)) {
                return true;
            } else {
                return false;
            }
        }*/
        System.out.println(TAG+"UserBean is signing");
        System.out.println(TAG+"name is "+userName+" password is "+userPassword);
        UserDAO userDAO = new UserDAO();
        UserBean userBean = (UserBean) userDAO.query(this, "userName");

        if(userBean==null) {
            return false;
        } else {
            String password = userBean.getUserPassword();
            return password.equals(this.userPassword);
        }

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
