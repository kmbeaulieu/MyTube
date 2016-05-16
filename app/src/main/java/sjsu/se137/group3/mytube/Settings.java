package sjsu.se137.group3.mytube;

/**
 * Created by Krystle on 5/15/2016.
 * This contains the youtube api key.Possibly oauth2 in the future.
 */
public class Settings {
    private Settings(){}
    //this is the api key for using youtube. Krystle has access to it on her developer settings. Ask her if other info is needed.
    private static final String YOUTUBE_KEY = "AIzaSyBOdD5hrDl0dRO2wuLSm2sTgZi4HrV56Sg";

    public static final String getKey(){
        return YOUTUBE_KEY;
    }
    
}
