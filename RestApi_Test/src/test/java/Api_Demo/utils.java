package Api_Demo;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class utils {
   public static int getpageNo(){
       // Random random=new Random();
       int genraterandomnum = 2;//random.nextInt();
        return genraterandomnum;
    }
    public static String getName(){
      //String generateRandomString=RandomStringUtils.randomAlphabetic(1);
       String generateRandomString="Aman";
        return (generateRandomString);
    }

    public static String getJob(){
       String generateRandomString= RandomStringUtils.randomAlphabetic(1);
        return ("leader"+generateRandomString);
    }
}
