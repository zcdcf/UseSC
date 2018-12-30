package water.ustc.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import sc.ustc.model.ConstRepo;
import sc.ustc.model.RunTimeVar;
import water.ustc.bean.UserBean;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Creator: hfang
 * Date: 2018/12/30 20:12
 * Description:
 **/

public class XMLModifier {
    public static void UpdateSuccessView(UserBean userBean) {
        String textviewXPath = "//view/body/form/textView";
        String fileUrl = RunTimeVar.projectRootPath+ConstRepo.XML_VIEW_PATH;

        File file = new File(RunTimeVar.projectRootPath+ ConstRepo.XML_VIEW_PATH);
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(fileUrl);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        List<Node> textviewList = document.selectNodes(textviewXPath);
        for(Iterator<Node> iterator = textviewList.iterator(); iterator.hasNext();) {
            Element element = (Element) iterator.next();
            if(element.valueOf("name").equals("userName")) {
                Node nameNode = element.element("value");
                nameNode.setText(userBean.getUserName());
            }
        }

        XMLWriter writer;
        try {
            //格式化为缩进格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            //设置编码格式
            format.setEncoding("UTF-8");
            writer = new XMLWriter(new FileWriter(file),format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
