package water.ustc.interceptor;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import sc.ustc.util.ProduceTimeFormatted;
import water.ustc.model.ConstRepo;
import water.ustc.util.FormattedTime;
import sc.ustc.model.RunTimeVar;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Creator: hfang
 * Date: 2018/12/18 18:39
 * Description:
 **/

public class LogInterceptor {
    private String actionName;
    private String startTime;
    private String finishTime;
    private String projectRootPath = RunTimeVar.projectRootPath;
    private static final String TAG = ProduceTimeFormatted.getCurrentTime()+"water.ustc.interceptor.LogInterceptor:";

    public LogInterceptor() {
    }

    public LogInterceptor(String actionName) {
        this.actionName = actionName;
    }

    public void preAction(String actionName) {
        this.startTime = FormattedTime.getCurrentTime();
        this.actionName = actionName;

        // open log.xml
        File file = new File(projectRootPath+ConstRepo.LOG_FILE_PATH);
        Document document = null;
        Element root;
        // test if log.xml exist
        // if not, create a new file and add root Node
        // else, read the file
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            document = DocumentHelper.createDocument();
            root = document.addElement("log");
        } else {
            SAXReader saxReader = new SAXReader();
            try {
                document = saxReader.read(file);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            root = document.getRootElement();
        }

        System.out.println(TAG+"s-time = "+this.startTime+" action name = "+this.actionName);

        // add node-action and sub-node name and s-time
        Element ActionNode = root.addElement("action");
        ActionNode.addElement("name").addText(this.actionName);
        ActionNode.addElement("s-time").addText(this.startTime);

        // use XMLWriter write the document into the log.xml
        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileWriter(new File(projectRootPath+ConstRepo.LOG_FILE_PATH)),OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afterAction(String result) {
        this.finishTime = FormattedTime.getCurrentTime();
        File logFile = new File(projectRootPath + ConstRepo.LOG_FILE_PATH);

        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(logFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();

        System.out.println(TAG+" e-time"+this.finishTime+" result = "+result);

        // traverse the xml and find the last action node
        // to add sub-node e-time and result
        List<Node> actionNodeList = root.selectNodes("//log/action");
        for(Iterator iterator = actionNodeList.iterator(); iterator.hasNext(); ) {
           Element node = (Element) iterator.next();
           if(!iterator.hasNext()) {
               System.out.println(TAG+"found last node");
               Element lastNode = node;
               lastNode.addElement("e-time").addText(this.finishTime);
               lastNode.addElement("result").addText(result);
           }
        }

        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileWriter(new File(projectRootPath+ConstRepo.LOG_FILE_PATH)),OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
