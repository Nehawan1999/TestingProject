package testPackage;

import org.testng.annotations.Test;
import java.io.IOException;



import genericPackage.BaseTest;
import genericPackage.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;
import pagePackage.TaskListPage;
import pagePackage.UserListPage;

public class ValidLoginTestCase extends BaseTest {
	
	
	
	@Test
	public void validTestCase() throws IOException, InterruptedException
	{
		
		BaseTest bt = new BaseTest();
		bt.setUp();
		Flib flib = new Flib();
		LoginPage lp = new LoginPage(driver);
		lp.validLogin(flib.readPropertyData(PROP_PATH,"username"),flib.readPropertyData(PROP_PATH,"password"));
		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.usersModuleMethod();
		Thread.sleep(2000);
		UserListPage ulp = new UserListPage(driver);
		ulp.createUserMethod(flib.readExcelData(EXCEL_PATH,"mgr",1,0),flib.readExcelData(EXCEL_PATH,"mgr",1,1),flib.readExcelData(EXCEL_PATH,"mgr",1,2),flib.readExcelData(EXCEL_PATH,"mgr",1,3));
		ulp.selectCheckBox();
		ulp.managerCreateMethod();
		Thread.sleep(2000);
		TaskListPage task = new TaskListPage(driver);
		task.createNewCustomerMethod(flib.readExcelData(EXCEL_PATH,"customer&projectList",1,0));
		Thread.sleep(2000);
		task.createProjectMethod(0,flib.readExcelData(EXCEL_PATH,"customer&projectList",1,1));

	}

}
