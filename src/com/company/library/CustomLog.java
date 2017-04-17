//package com.company.library;
//
//import mail.SendMail;
////import org.apache.log4j.AppenderSkeleton;
////import org.apache.log4j.PatternLayout;
////import org.apache.log4j.spi.LoggingEvent;
////
///**
// * Created by Троицкий Дмитрий on 14.04.2017.
// */
//public class CustomLog  extends AppenderSkeleton
//{
//    public String format(LoggingEvent event)
//    {
//
//        //UserObject user = (UserObject)event.getMessage();
//
//        StringBuffer sb = new StringBuffer();
//
//        String name =""; //user.getName();
//        String age= ""; //user.getAge();
//        String country= ""; //user.getCountry();
//
//        sb.append( "<log>" );
//        sb.append("<level>").append( event.getLevel() ).append( "</level>" );
//        sb.append("<level>").append( event.getMessage() ).append( "</level>" );
//        sb.append( "</log>" );
//        sb.append("<user>");
//        sb.append("<name>").append(name).append("</name>");
//        sb.append("<age>").append(age).append("</age>");
//        sb.append("<country>").append(country).append("</country>");
//        sb.append("</user>");
//        sb.append("</user>");
//        sb.append( "</log>" );
//        sb.append("\n");
//
//
//        return sb.toString();
//    }
//
//    @Override
//    protected void append(LoggingEvent loggingEvent) {
//            SendMail.sendmail(format( loggingEvent ));
////        try
////        {
////            Class.forName(driver);
////            Connection conn = DriverManager.getConnection(url, user, pass);
////
////            pst= conn.prepareStatement(sql);
////            pst.setString(1, event.getLevel().toString());
////
////            pst.setString(2, layout.format(event));
////
////            pst.executeUpdate();
////            pst.close();
////            conn.close();
////        }
////        catch(Exception e)
////        {
////            e.printStackTrace();
////        }
//
//    }
//
//    @Override
//    public void close() {
//
//    }
//
//    @Override
//    public boolean requiresLayout() {
//        return false;
//    }
//}