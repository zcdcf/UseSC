package water.ustc.action;

import water.ustc.bean.UserBean;
import water.ustc.model.ConstRepo;
import water.ustc.util.FormattedTime;
import water.ustc.util.XMLModifier;

/**
 * Creator: hfang
 * Date: 2018/12/11 22:34
 * Description: Use to handle Login Business.
 **/

public class LoginAction {
    private static String TAG = FormattedTime.getCurrentTime()+"water.ustc.action.LoginAction:";
//    private String userName;
//    private String password;
    private UserBean userBean;

    public LoginAction() {

    }

    public String handleLogin() {
        System.out.println(TAG+"start handle login");
//        UserBean userBean = new UserBean(ConstRepo.DB_DEFAULT_USERID, this.userName, this.password);
        if(userBean.signIn()) {
            System.out.println(FormattedTime.getCurrentTime()+TAG+"success");
            XMLModifier.UpdateSuccessView(userBean);
            return "success";
        } else {
            System.out.println(FormattedTime.getCurrentTime()+TAG+"FAILURE");
            return "failure";
        }
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
