package basic_web_testing_w_selenium;

//import static com.facebook.selenium.MainPage.driver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// created by Izzat Alsmadi
public class MainPage 
{
	//log variables
	static final private Logger LOGGER = Logger.getLogger(MainPage.class.getName() );
	static final private String APPENDER_MAIN = "MainPage.main";
        public static WebDriver driver = null;
         private static WebDriverWait wait;
      //  public static Logger logger = LogManager.getLogger();
	//public static Logger log =LogManager.getLogger("test");
	
	//class variables
	static final private String CONFIGURATION_PROPERTIES = "config.properties";
	static final private String TARGET_URL = "http://www.tamusa.tamus.edu//";
	
        public static void LoginForm1() {
        driver.get("http://www.tamusa.tamus.edu/");
 driver.findElement(By.name("email")).sendKeys("your email");
 driver.findElement(By.name("pass")).sendKeys("yourpassword");
 driver.findElement(By.id("loginbutton")).click();
  
    }
        public static void LoginForm() {
        waitForVisibility(Constants.ID,Constants.FB_LOGIN_FORM_ID);
        getElement(Constants.ID,Constants.FB_LOGIN_USERNAME_ID).sendKeys("your email");
        getElement(Constants.ID,Constants.FB_LOGIN_PASSWORD_ID).sendKeys("password");
        getElement(Constants.ID,Constants.FB_LOGIN_BUTTON_ID).click();
    }
        public static WebElement getElement(String by, String identifier) {
        WebElement element = null;
        switch (by) {
            case Constants.ID:
                element = driver.findElement(By.id(identifier));
                break;

            case Constants.XPATH:
                element = driver.findElement(By.xpath(identifier));
                break;

            case Constants.CSS:
                element = driver.findElement(By.cssSelector(identifier));
                break;

            case Constants.TAG:
                element = driver.findElement(By.tagName(identifier));
                break;

            default:
                element = driver.findElement(By.id(identifier));
                break;
        }
        return element;
    }
        public static void waitForVisibility(String by, String identifier) {
        switch (by) {
            case Constants.ID:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
                break;

            case Constants.XPATH:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
                break;

            case Constants.CSS:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(identifier)));
                break;

            case Constants.TAG:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(identifier)));
                break;

            default:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
                break;
        }
    }

    public static List<WebElement> getElements(String by, String identifier) {
        List<WebElement> elements = null;
        switch (by) {
            case Constants.ID:
                elements = driver.findElements(By.id(identifier));
                break;

            case Constants.XPATH:
                elements = driver.findElements(By.xpath(identifier));
                break;

            case Constants.CSS:
                elements = driver.findElements(By.cssSelector(identifier));
                break;

            case Constants.TAG:
                elements = driver.findElements(By.tagName(identifier));
                break;

            default:
                elements = driver.findElements(By.id(identifier));
                break;
        }
        return elements;
    }

    

        private static String trimChar( char toTrim, String inString ) { 
        int from = 0;
        int to = inString.length();

        for( int i = 0 ; i < inString.length() ; i++ ) {
            if( inString.charAt( i ) != toTrim) {
                from = i;
                break;
            }
        }
        for( int i = inString.length()-1 ; i >= 0 ; i-- ){ 
            if( inString.charAt( i ) != toTrim ){
                to = i;
                break;
            }
        }
        return inString.substring( from , to );
    }
        static Properties properties;
        static ChromeOptions options;
        static void prepare(){
            properties = loadConfigurationProperties();    
                			// If you want to change  browser in Properties file then pass "bName" variable into switch contractor 
			String bName = properties.getProperty("browser");
			
			// If you want to change  browser in command prompt  then pass "bName" variable into switch contractor 
			String browserName = System.getProperty("browser");
			
			
			// NOTE : If you do not use command prompt then only use "bName in to SWITCH contractor"
			switch (bName) {
			case "firefox":
	//			logger.info(Constant.dash);
	//			logger.info("Starting Firefox browser");
	//			logger.info(Constant.dash);
				driver = new FirefoxDriver();
				break;
                        case "IE":
	//			logger.info(Constant.dash);
	//			logger.info("Starting Internet Explorer browser");
	//			logger.info(Constant.dash);
				
				//Set Internet Explorer Driver path to execute test cases
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
						"/src/test/resources/driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "chrome":
	//			logger.info(Constant.dash);
	//			logger.info("Starting Chrome browser");
	//			logger.info(Constant.dash);
				//Set Chrome Driver path to execute test cases
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/driver/chromedriver.exe");
                                System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
                              //  C:\Users\ialsmadi\AppData\Local\chromium\Application
                                        options = new ChromeOptions();
                    options.setBinary("C:\\Users\\yourname\\AppData\\Local\\chromium\\Application\\chrome.exe");
                    options.addArguments("--dns-prefetch-disable");
                               
				try{
                             //   driver = new ChromeDriver();
                                 driver = new ChromeDriver(options);
                            driver.get("http://www.tamusa.edu/");
                       //     LoginForm1();
                                }
                                catch(Exception ex){
                                    System.out.println(ex.getMessage());
                                }
				break;
			
			case "htmlUnit":
	//			logger.info("Starting Htma Unit browser");
				driver = new HtmlUnitDriver();
				break;
			case "safari":
	//			logger.info(Constant.dash);
	//			logger.info("Starting safari browser");
	//			logger.info(Constant.dash);
				driver = new SafariDriver();
				break;
			default:
				// Default browser 
	//			logger.info(Constant.dash);
	//			logger.info("Starting default browser");
	//			logger.info(Constant.dash);
				driver = new FirefoxDriver();
				break;
			}
		//}
		
		// Delete all cookies from browser
		//driver.manage().deleteAllCookies();
		
		// Navigate to the test URL
		
		// NOTE : If you want to pass test url in commend prompt then pass "cURL" variable in get contractor.
					
		
		String URL = Constant.URL;
		String cURL = Constant.cURL;
		try{
		//driver.get(URL);
                driver.navigate().to(URL);
                LoginForm1();
		
		// Set global wait time for find the page element 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    	
    	//WebDriver driver = new FirefoxDriver();
    	
    	driver.manage().window().maximize(); 
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
/*    	LOGGER.info( APPENDER_MAIN + "[EVENT]: browser window is maximized" );
    	    	
        driver.get( TARGET_URL );
        LOGGER.info( APPENDER_MAIN + "[EVENT]: target url requested" );
        
        //look at file src/main/resources/config.properties
        //change email password in this file
        final String email = properties.getProperty( "email" );
        driver.findElement( By.id( "email" )).sendKeys( email );
        LOGGER.info( APPENDER_MAIN + "[EVENT]: username/email entered" );
        
        final String password = properties.getProperty( "password" );
        driver.findElement( By.id("pass") ).sendKeys( password );
        LOGGER.info( APPENDER_MAIN + "[EVENT]: password entered" );
                
        driver.findElement( By.id( "loginbutton" ) ).click();
        LOGGER.info( APPENDER_MAIN + "[EVENT]: login button clicked" );
        
        LOGGER.info( APPENDER_MAIN + "[SLEEP]: 4 seconds for the page to load" );
        try {
			Thread.sleep( 4000 );
		} catch ( InterruptedException e ) {
			LOGGER.severe( APPENDER_MAIN + "[InturreptedException]: thread pause failed" );
			e.printStackTrace();
		}
        LOGGER.info( APPENDER_MAIN + "[EVENT]: logged in, on facebook home page"); */
        }
        static ArrayList<String> mutualTemp;
        
        
        
       
        public static void main( String[] args ) {
            
            prepare();
            System.out.println("end of prepare");
            try{
     //   doLogin();
     driver.findElement(By.xpath("//*[@title='Profile']")).click();
     }
            catch(Exception ex){
              System.out.println("driver Exception");
            }
           

                }
        
        
      
     
                                    
           
           
	
         
        public static void doLogin() throws InterruptedException{
        //prepare();
       // Random rand = new Random();
            /*
        // Login and navigate to frineds tab
        driver.get(config.getProperty("URL"));
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(config.getProperty("Login"));
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(config.getProperty("Password"));
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(Keys.RETURN); */
            System.out.println("111");
            try{
        
            }
            catch(Exception ex){
                
            }
            int k=100;
           
        Thread.sleep(k);
        System.out.println(k);
        try{
        driver.findElement(By.xpath("//*[@title='Profile']")).click();
        }
        catch(Exception ex){
           
        Thread.sleep(k);
        System.out.println(k);
        driver.findElement(By.xpath("//*[@title='Profile']")).click();
        }
        String loginId = null; 
	try {
	
	System.out.println("login id..."+loginId); 
	} catch (Exception e) {
	    System.out.println("Error!!!");
	//    System.exit(1); 
	}
        //k=randInt(100,1000);
        Thread.sleep(k);
        System.out.println(k);
        System.out.println("2");
        //find your frineds count
        String frinedsCount = driver.findElement(By.xpath("//*[@data-tab-key='friends']")).getText().substring(7);
       frinedsCount = frinedsCount.replaceAll(",", "");
        int count = Integer.parseInt(frinedsCount);
        System.out.println("3");
        //click on frineds tab
        driver.findElement(By.xpath("//*[@data-tab-key='friends']")).click();
         //k=randInt(100,1000);
        Thread.sleep(k);
        System.out.println(k);
         System.out.println("4");
          List<WebElement> frineds2;
        //find your couurent loaded frineds count and get it in a list
        List<WebElement> frineds = driver.findElements(By.xpath("//*[@class='fsl fwb fcb']"));
        System.out.println("5"); 
       // k=randInt(100,1000);
        Thread.sleep(k);
        System.out.println(k);
        int found = frineds.size();
        int stablecounter=0;
        int previousFound=0;
        
        while (found <= count){
            System.out.println(found);
      //     k=randInt(1000,1000);
        Thread.sleep(k);
        //System.out1.println(k);
         /*   if(stablecounter >100){
                break;
            } */
            //scroll to the last friend found from the current loaded friend list
            Coordinates coordinate = ((Locatable) frineds.get(found-1)).getCoordinates();
            coordinate.onPage();
            coordinate.inViewPort();
         //   frineds = driver.findElements(By.xpath("//*[@class='fsl fwb fcb']"));
             
            previousFound=found;
            found = frineds.size();
            if(previousFound==found){
                stablecounter++;
            }

            // break and print frined list if the condition found frineds = count of frined list
            if (found >= count || stablecounter >100 || found >35){
             break;   
            }
            else{
                continue;
            }
        }
                List<WebElement> element = driver.findElements(By.xpath("//li[@class='_698']/div/div/div[2]/div/div[2]/div/a"));	

frineds2= driver.findElements(By.tagName("a"));
String[] links = null;
boolean check=false;
          //   for(WebElement Element : frineds2){
            for(int i=0;i<frineds2.size();i++)  {
                WebElement Element= frineds2.get(i);
                String test=Element.getText();
                String test1=Element.getAttribute("href");
                    try{
                  //  User myFriend= (User)Element;
         System.out.println("GETTEXT.."+Element.getText()+Element.getAttribute("innerText")+Element.getAttribute("textContent"));
         if((Element.getText().contains("Friends") || Element.getAttribute("innerText").contains("Friends")) && test1.contains("friends") ){
             check=true;
         }
         if(check==true){
      //   out2.println(Element.getText()+","+Element.getAttribute("innerText")+","+Element.getAttribute("textContent")+","+test1);  
         }
}        catch(org.openqa.selenium.TimeoutException ex1){
           try{
           driver = new ChromeDriver(options);
                            driver.get("http://www.tamusa.edu/");
                            LoginForm1();
           }
           catch(Exception ex){
           
       }}
                    catch(Exception ex){
        
    }
                    try{
if(Element.getText().contains("mutual friends")){
    System.out.println("GETTEXT.."+ Element.getText()+Element.getAttribute("innerText")+Element.getAttribute("textContent"));
    int end1=Element.getText().indexOf("mutual friends");
    int start1=0;
    
try{ start1=end1-3;}
    catch(Exception ex){
        start1=end1-2;
    }
//out1.print(Element.getText().substring(start1, end1));
    System.out.println("mutual"+","+Element.getText().substring(start1, end1));
}
}
                    catch(org.openqa.selenium.TimeoutException ex1){
           try{
           driver = new ChromeDriver(options);
                            driver.get("http://www.tamusa.edu/");
                            LoginForm1();
           }
           catch(Exception ex){
           
       }}
catch(Exception ex){
    
}
          
    
try{
links[i] = Element.getAttribute("href");
driver.navigate().to(links[i]);

Thread.sleep(3000);
}
catch(Exception ex){}

//out1.flush();
//out2.flush();

            }
                     
         //   }         
   
    //            }
    try{
                System.out.println(found);
                System.out.println("---Printing FriendList---");
                for (int i=0; i<found; i++){
                
  //              System.out.println(frineds.get(i).getText() + frineds.get(i).getAttribute("innerText")+frineds.get(i).getAttribute("textContent") );
                        
                }
    //            out1.flush();
      //          out2.flush();

    }
    catch(Exception ex){
        
    }
                
  
      
            
        //out1.close();
        //out2.close();
        }
 
	private static Properties loadConfigurationProperties() {
		
		InputStream input = null;
		Properties properties = new Properties();

    	try {
    		
    		input = MainPage.class.getClassLoader().getResourceAsStream( CONFIGURATION_PROPERTIES );    		
    		properties.load( input );
    		LOGGER.info( "MainPage.loadConfigurationProperties:LOAD_COMPLETED" );
    	
    	} catch ( IOException e ) {
    		
    		LOGGER.severe( "App.loadConfigurationProperties[IOException]: properties file not loaded" );
    		e.printStackTrace();
    	
    	} finally {
    		
    		if ( input != null ) {
    			try {    				
    				input.close();    			
    			} catch ( IOException e ) {    				
    				LOGGER.severe( "App.loadConfigurationProperties[IOException]: inputstream not closed" );
    				e.printStackTrace();
    			}
    		}
    	}
    	
    	return properties;
	}
        public static String getText(WebDriver driver, WebElement element){
            try{
    return (String) ((JavascriptExecutor) driver).executeScript(
        "return jQuery(arguments[0]).text();", element);
            }
            catch(Exception ex){
                
            }
            return "";
}
}
