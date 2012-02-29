/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.system;

import cuke4duke.annotation.After;
import cuke4duke.annotation.Before;
import java.io.IOException;
import org.krohm.selecuke.generic.cucumber.Env;
import org.krohm.selecuke.generic.selenium.GenericSeleniumUtil;

/**
 *
 * @author arnaud
 */
public class NewClass {


    @Before
    public void before() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        Env.init();
        GenericSeleniumUtil.startBrowser();
    }

    @After
    public void after() {
        GenericSeleniumUtil.closeBrowser();
    }
     /**/

}
