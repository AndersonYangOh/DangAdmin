package com.chinauicom.research.rudang.process;

import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component; 
 
import com.chinauicom.research.rudang.process.service.OperOrganService;
import com.chinauicom.research.rudang.system.operator.entity.SysOperatorEmailTable; 
 
/**
 * 
 * @ClassName: SysMenuAction
 * @Description: TODO(后台菜单管理)
 * @author huangChuQin
 * @date 2016-7-18 上午9:51:13
 *
 */
@Component
public class EmailAction {

	@Autowired
	private OperOrganService operOrganService; 
     
	  
	@Scheduled(cron = "0 03 17 * * ?")
    public void executeSendEmail(){

        try {
        	Map<String,Object>paramMap=new HashMap<>();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	String sendTime = sdf.format(new Date());
        	paramMap.put("sendTime", sendTime);  
            //查询工单类型为新单的所有工单
            List<SysOperatorEmailTable> workBillList = operOrganService.selectEmail(paramMap);
            if (null != workBillList && workBillList.size() > 0) {
                final Properties mailProps = new Properties();
              
                //构建授权信息,用于进行SMTP进行身份验证
                Authenticator authenticator = new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        //用户名、密码
                        String userName = mailProps.getProperty("mail.username");
                        String password = mailProps.getProperty("mail.password");

                        return new PasswordAuthentication(userName, password);
                    }
                };

                //使用环境属性和授权信息,创建邮件会话
                Session mailSession = Session.getInstance(mailProps, authenticator);

                for (SysOperatorEmailTable workBill : workBillList) {
                    //创建邮件消息
                    MimeMessage message = new MimeMessage(mailSession);
                    //设置发件人
                    InternetAddress from = new InternetAddress(mailProps.getProperty("mail.username"));
                    message.setFrom(from);

                    //设置收件人
                    InternetAddress to = new InternetAddress(workBill.getOperMail());
                    message.setRecipient(RecipientType.TO, to);

                    //设置邮件标题
                    message.setSubject("党务系统测试");

                    //设置邮件的内容体 设置为html格式
                    MimeMultipart mainPart = new MimeMultipart();
                    // 创建一个包含HTML内容的MimeBodyPart
                    MimeBodyPart html = new MimeBodyPart();
                    // 设置HTML内容
                    html.setContent(workBill.getSendContent(), "text/html; charset=utf-8");
                    
                    mainPart.addBodyPart(html);
                    // 将MiniMultipart对象设置为邮件内容
                    message.setContent(mainPart);
                    //发送邮件
                    Transport.send(message);
                    
                    //标记已经发送过邮件了 status=1
                }
            }
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
