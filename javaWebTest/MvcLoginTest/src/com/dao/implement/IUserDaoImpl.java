package com.dao.implement;

/**
 * Created by zheng1617 on 16-7-19.
 */
import com.dao.IUserDao;
import com.domain.User;
import com.sun.xml.internal.ws.util.xml.XmlUtil;
import org.dom4j.Document;
import com.util.XmlUtils;
import org.dom4j.Element;
import org.dom4j.util.SimpleSingleton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IUserDaoImpl implements IUserDao {
    @Override
    public User find(String userName, String userPwd) {
        try{
            Document document = XmlUtils.getDocument();

            Element e = (Element) document.selectSingleNode
                    ("//user[@userName='"+userName+"' and @userPwd='"+userPwd+"']");
            if(e == null) {
                return null;
            }
            User user = new User();
            user.setId(e.attributeValue("id"));
            user.setUserName(e.attributeValue("userName"));
            user.setEmail(e.attributeValue("email"));
            user.setUserPwd(e.attributeValue("userPwd"));
            String birth = e.attributeValue("birthday");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(sdf.parse(birth));

            return user;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public User find(String userName) {
        try{
            Document document = XmlUtils.getDocument();

            Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"']");
            if(e == null) {
                return null;
            }
            User user = new User();
            user.setId(e.attributeValue("id"));
            user.setUserName(e.attributeValue("userName"));
            user.setEmail(e.attributeValue("email"));
            user.setUserPwd(e.attributeValue("userPwd"));
            String birth = e.attributeValue("birthday");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(sdf.parse(birth));

            return user;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("deprecation")
    @Override
    public void add(User user) {
        try {
            Document document = XmlUtils.getDocument();
            Element root = document.getRootElement();
            Element user_node = root.addElement("user");
            user_node.setAttributeValue("id", user.getId());
            user_node.setAttributeValue("userName", user.getUserName());
            user_node.setAttributeValue("email", user.getEmail());
            user_node.setAttributeValue("userPwd", user.getUserPwd());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user_node.setAttributeValue("birthday", sdf.format(user.getBirthday()));

            XmlUtils.write2Xml(document);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
