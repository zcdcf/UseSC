package water.ustc.model;

/**
 * Creator: hfang
 * Date: 2018/12/18 19:20
 * Description:
 **/

public class ConstRepo {
    public static final String LOG_FILE_PATH = "WEB-INF/log.xml";
    public static final String LOG_FILE_PATH2 = "WEB-INF/log2.xml";
    public static final String LOGIN_DB_PATH = "WEB-INF\\database\\loginInfo.db";
    public static final String JDBC_PREFIX = "jdbc:sqlite:";
    public static final String LOG_DB_DRIVER = "org.sqlite.JDBC";
    public static final String DB_DEFAULT_USERNAME = "name";
    public static final String DB_DEFAULT_PASSWORD = "pleasesetpassword";
    public static final String DB_DEFAULT_USERID = "dfid";
    public static final String DB_LOGININFO_COLUMN_NAME = "name";
    public static final String DB_LOGININFO_COLUMN_PASSWORD = "password";
    public static final String SUCCESS_VIEW_XML_PATH = "pages\\success_view.xml";
}
