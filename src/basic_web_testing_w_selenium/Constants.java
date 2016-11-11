package basic_web_testing_w_selenium;

//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Izzat Alsmadi
 */
public interface Constants {

    //FRAMEWORK CONVENTIONS
    public String ID = "id";
    public String XPATH = "xpath";
    public String CSS = "css";
    public String TAG = "tag";

    //FB LOGIN PAGE
    public String FB_URL = "http://www.tamusa.edu/";
    public String FB_LOGIN_FORM_ID = "login_form";
    public String FB_LOGIN_USERNAME_ID = "email";
    public String FB_LOGIN_PASSWORD_ID = "pass";
    public String FB_LOGIN_BUTTON_ID = "u_0_y";

    //FB CONVERSATION PAGE
    public String FB_CONVERSATION_URL = "";
    public String FB_CONVERSATION_NAME = "Lenin Alevski HA";
    public String FB_CONVERSATION_TEXTAREA_XPATH = "//*[@id=\"js_q\"]/div[1]/div[2]/textarea";
    public String FB_SINGLE_CONVERSATION_TEXTAREA_XPATH = "//*[@id=\"js_p\"]/div[1]/div[2]/textarea";
    public String FB_CONVERSATION_CONTAINER_ID = "webMessengerRecentMessages";
    public String FB_CONVERSATION_ITEM_CLASS = ".webMessengerMessageGroup.clearfix";
}
