//package mail;
//
//import org.apache.log4j.spi.LoggingEvent;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
///**
// * Created by Троицкий Дмитрий on 14.04.2017.
// */
//public  class SendMail {
//
//    public static void sendmail(String loggingEvent) {
//
////        final String username = "username@gmail.com";
////        final String password = "password";
////
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.list.ru");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                                                                                            return new PasswordAuthentication("sleitor", "icqclone12");
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            try {
//                message.setFrom(new InternetAddress("Sleitor@list.ru"));
//            } catch(MessagingException e) {
//                e.printStackTrace();
//            }
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse("Sleitor@list.ru"));
//            message.setSubject("Testing Subject");
//            message.setText(loggingEvent);
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}