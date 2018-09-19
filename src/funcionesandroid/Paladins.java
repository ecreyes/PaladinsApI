package funcionesandroid;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Calendar;
import java.security.MessageDigest;

public class Paladins {
    private static final String PATH = "http://api.paladins.com/paladinsapi.svc";
    private static final String DEVID = "2858";
    private static final String AUTHKEY = "501970C223CF474BACD0493FCD62A66A";
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");
    
    private static String getTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.HOUR, 3);
        timestamp = new Timestamp(cal.getTime().getTime());
        return SDF.format(timestamp);
    }
    
    private static String getSignature(String method)throws Exception{
        String time = Paladins.getTimeStamp();
        String original = DEVID+method+AUTHKEY+time;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
        }

        //System.out.println("original:" + original);
        //System.out.println("digested(hex):" + sb.toString());
        return sb.toString();
    }
    
    public static String getUrltoSession(){
        String url = "";
        String method = "createsession";
        String methodJson = method+"Json";
        try{
            url = PATH+"/"+methodJson+"/"+DEVID+"/"+Paladins.getSignature(method)+"/"+Paladins.getTimeStamp();
            return url;
        }catch(Exception e){
            e.printStackTrace();
            return url;
        }
    }
    
}
