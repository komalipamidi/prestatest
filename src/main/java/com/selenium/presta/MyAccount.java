package com.selenium.presta;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.selenium.presta.CommonCode;

public class MyAccount {

	public WebDriver driver = Configuration.browser();
	public ReadExcel read;
	public CommonCode commons;
	public Home home;

	@FindBy(id="search_query_top")
	public WebElement Searchbox;
	
	@FindBy(xpath=".//*[@id='searchbox']/p/input[5]")
	public WebElement Enterbutton;
	
	@FindBy(xpath=".//*[@id='center_column']/h3/span")
	public WebElement Printtext;
	
	@FindBy(xpath=".//*[@id='product_list']/li[1]/div[2]/h3/a")
	public  WebElement producttext;
	
	@FindBy(xpath=".//*[@id='pb-left-column']/h1")
	public  WebElement producPagetext;
	

	@FindBy(xpath=".//*[@id='our_price_display']")
	public  WebElement productPrice;
	
	@FindBy(xpath=".//*[@id='add_to_cart']/input")
	public WebElement Addtocart;
	
	@FindBy(xpath=".//*[@id='product_list']/li[1]/div[2]/h3/a")
	public WebElement ClickIpodShuffle;
	
	@FindBy(xpath=".//*[@id='shopping_cart']/a")
	public WebElement ClickShopingcart;
	
	@FindBy(xpath=".//*[@id='center_column']/p[3]/a[1]")
	public WebElement Nextbutton;
	
	@FindBy(xpath=".//*[@id='shopping_cart']/a")
	public WebElement Cartlink;
	
	@FindBy(xpath=".//*[@id='cart_title']")
	public WebElement CartSummary;
	
	@FindBy(xpath=".//*[@id='product_2_2_0_40']/td[2]/p/a")
public WebElement CartDescription;
	
	@FindBy(xpath=".//*[@id='product_price_2_2_40']")
	public WebElement productcost;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/ul/li[1]/a")
	public WebElement Homebutton; 
	

	@FindBy(xpath=".//*[@id='2_2_0_40']")
	public WebElement Deletebutton;
	
	@FindBy(xpath=".//*[@id='center_column']/p[3]/a[2]")
	public WebElement ContinueshpBtn;
	
	@FindBy(xpath=".//*[@id='center_column']/p")
	public WebElement ShpngEmpty;
	
	@FindBy(xpath=".//*[@id='header_user_info']/a[2]")
	public WebElement Logoutlink;
	
	@FindBy(id="addressesAreEquals")
	public WebElement Checkbox;
	
	@FindBy(id="SubmitLogin")
	public WebElement loginbutton;
	
	@FindBy(xpath="//*[@id='center_column']/form/p/input[3]")
	public WebElement Nextbutton2;
	
	@FindBy(xpath=".//*[@id='center_column']/form/div/p[4]/a")
	public WebElement NewaddresButton;
	
	@FindBy(xpath=".//*[@id='carrier_area']/h1")
	public WebElement Shippingtext;
	
	@FindBy(xpath=".//*[@id='cgv']")
	public WebElement ShippingCheckbox;
	@FindBy(xpath=".//*[@id='cgv']")
	public WebElement Checkbox2;
	
	@FindBy(xpath=".//*[@id='form']/p/input[3]")
	public WebElement NextButton3;
	

	@FindBy(xpath=".//*[@id='product_2_2_0_40']/td[2]/p/a")
	public WebElement CartpaymentDescription;
	

	@FindBy(xpath=".//*[@id='product_price_2_2_40']")
	public WebElement Cardpaymentdescriptionprice;
	

	@FindBy(xpath=".//*[@id='HOOK_PAYMENT']/p[1]/a")
	public WebElement chequepay;
	

	@FindBy(xpath=".//*[@id='HOOK_PAYMENT']/p[2]/a")
	public WebElement wirepay;
	
	@FindBy(xpath=".//*[@id='HOOK_PAYMENT']/div/h3")
	public WebElement Creditcardpay;
	

	@FindBy(xpath=".//*[@id='HOOK_PAYMENT']/p[3]/a")
	public WebElement Cashondelivery;
	
	@FindBy(xpath=".//*[@id='stripe-payment-form']/button")
	public WebElement Submitbtn;
	@FindBy(xpath=".//*[@id='center_column']/form/p[3]/input")
	public WebElement Confirmbtn;
	
	@FindBy(xpath=".//*[@id='center_column']/div[2]")
	public WebElement congratulationstext;
	
	@FindBy(xpath=".//*[@id='center_column']/h1")
	public WebElement Confirmedtext;
	@FindBy(xpath=".//*[@id='center_column']/h3")
	public WebElement Cashondeliverytext;
	
	@FindBy(xpath=".//*[@id='center_column']/form/p[3]/a")
	public WebElement Otherpaymentbtn;
	
	
	@FindBy(xpath=".//*[@id='shopping_cart']/a")
	public WebElement cartempty;
	
	@FindBy(id = "btn_basic_example")
	public WebElement startprctisingbtn;

	@FindBy(xpath = ".//*[@id='home_bar']/span/i")
	public WebElement homebtn;

	@FindBy(xpath = ".//*[@id='basic']/h3")
	public WebElement verifycontent;

	@FindBy(xpath = ".//*[@id='inter_example']/span/i")
	public WebElement Intermediate;

	@FindBy(css = "a[class=\"list-group-item\"]")
	public WebElement verifybutton;

	@FindBy(id = "btn_advanced_example")
	public WebElement proceed;

	@FindBy(xpath = ".//*[@id='advanced']/h3")
	public WebElement verifycontent2;

	@FindBy(xpath = ".//*[@id='advanced']/div/a[5]")
	public WebElement verifycontent3;

	@FindBy(xpath = ".//*[@id='done_example']/span/i")
	public WebElement completebtn;
	
	@FindBy(css = "h3[class=\"head text-center\"]")
	public WebElement Completeverify;

	public MyAccount() {

		PageFactory.initElements(driver, this);
		read = new ReadExcel();
		commons = new CommonCode();
		home = new Home();
	}

	public void assertAccount() {
		Assert.assertEquals(driver.getTitle(), read.readData("MyAccount_Title"));
		Assert.assertTrue(Logoutlink.isDisplayed(), "LogoutButton is not displayed");
		Assert.assertTrue(Searchbox.isDisplayed(),
				"Search_Btn is not displayed");
	}

	public void ifLogoutExists() {
		if (Logoutlink == null) {
			loginbutton.click();
		} else {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clickLogout();
		}
	}

	public void clickLogout() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(Logoutlink.isDisplayed());
		Logoutlink.click();
		// Assert.assertFalse(Logout.isDisplayed());
		ExpectedCondition<Alert> s = ExpectedConditions.alertIsPresent();
		if (s.toString()!="alert to be present") {
			Alert alert = driver.switchTo().alert();
			// update is executed
			alert.accept();
			// Assert.assertTrue(false, "AlertBox available");
		}

	}

	public void searchItem() throws InterruptedException{
		//commons.fluentWait(By.xpath(Elements.CartDetails));
		CommonCode.wait(5);
		Assert.assertTrue(Searchbox.isDisplayed());
		Searchbox.sendKeys(read.readData("Searchproduct"));
		Enterbutton.click();
		String Text=Printtext.getText();
		Assert.assertEquals(Text, read.readData("resultsfound"));
		String Text2=producttext.getText();
		Assert.assertEquals(Text2, read.readData("producttext"));
		ClickIpodShuffle.click();
		String text3=producPagetext.getText();
		Assert.assertEquals(text3, read.readData("productpagetext"));
		String text4=productPrice.getText();
		Assert.assertEquals(text4, read.readData("productprice"));
		Assert.assertTrue(Addtocart.isDisplayed());
		CommonCode.wait(5);
		Addtocart.click();
	}
	
	public void addToCart() throws InterruptedException{
		//commons.fluentWait(By.xpath(Elements.CartDetails));
		commons.wait(5);
		ClickShopingcart.click();
		Assert.assertEquals(CartDescription.getText(), read.readData("cartdescription"));
		Assert.assertTrue(Nextbutton.isDisplayed());
		Nextbutton.click();
		
		commons.wait(5);
		Assert.assertTrue(Cartlink.isDisplayed());
		Cartlink.click();
		commons.wait(5);
		System.out.println(CartSummary.getText());
		Assert.assertEquals(CartSummary.getText(), read.readData("cartsummary"));
		System.out.println(CartDescription.getText());
		Assert.assertEquals(CartDescription.getText(), read.readData("cartdescription"));
		System.out.println(productcost.getText());
		Assert.assertEquals(productcost.getText(), read.readData("productcost"));
		
	}
	
	public void deleteCartItem() throws InterruptedException{
		//commons.fluentWait(By.xpath(Elements.CartDetails));
		commons.wait(5);
		ClickShopingcart.click();
		
		Assert.assertTrue(Deletebutton.isDisplayed());
		Assert.assertTrue(ContinueshpBtn.isDisplayed());
		Assert.assertTrue(Nextbutton.isDisplayed());
		commons.wait(5);
		Deletebutton.click();
		commons.wait(5);
		String text=ShpngEmpty.getText();
		Assert.assertEquals(text, read.readData("shpngempty"));

		Homebutton.click();
		Assert.assertTrue(Logoutlink.isDisplayed());
		
	}
	
	public void cartAdress() throws InterruptedException{
		commons.wait(5);
		//commons.fluentWait(By.xpath(Elements.CartDetails));
	Assert.assertTrue(Nextbutton.isDisplayed());
		Nextbutton.click();
		commons.wait(5);
		Assert.assertTrue(Checkbox.isDisplayed());
		commons.wait(5);
		if(Checkbox.isSelected()){
			
			System.out.println("chckbox is enabled");
			}else
			{
				Checkbox.click();
				}
		
		Assert.assertTrue(Nextbutton2.isDisplayed());
		
		
		
		}
public void cartShipping() throws InterruptedException{
	commons.wait(5);
	//commons.fluentWait(By.xpath(Elements.CartDetails));
	
	Assert.assertTrue(NewaddresButton.isDisplayed());
	Assert.assertTrue(Nextbutton2.isDisplayed());
	Nextbutton2.click();
	commons.wait(5);
	Assert.assertEquals(Shippingtext.getText(), read.readData("shippingtext"));
	Assert.assertTrue(ShippingCheckbox.isDisplayed());
	
}

public void cartpayment() throws InterruptedException{
	commons.wait(5);
	

if(Checkbox2.isSelected()){
			
			System.out.println("chckbox is selected");
			}else
			{
				Checkbox2.click();
				}
		NextButton3.click();
		commons.wait(5);
		Assert.assertEquals(CartpaymentDescription.getText(), read.readData("cartpaymentdescription"));
		//System.out.println(CP.);
		//Assert.assertEquals(Cardpaymentdescriptionprice.getText(), "66.05");
		Assert.assertTrue(chequepay.isDisplayed());
		Assert.assertTrue(wirepay.isDisplayed());
		Assert.assertEquals(Creditcardpay.getText(), read.readData("creditcardpay"));
		Assert.assertTrue(Cashondelivery.isDisplayed());
		Assert.assertTrue(Submitbtn.isDisplayed());
		
	
}

public void cartsubmit() throws InterruptedException{
	commons.wait(5);
	//commons.fluentWait(By.xpath(Elements.CartDetails));
		Assert.assertEquals(CartpaymentDescription.getText(), read.readData("cartpaymentdescription"));
		//Assert.assertEquals(CP.Cardpaymentdescriptionprice.getText(), "$66.05 ");
		Assert.assertTrue(chequepay.isDisplayed());
		Assert.assertTrue(wirepay.isDisplayed());
		Assert.assertEquals(Creditcardpay.getText(), read.readData("creditcardpay"));
		Assert.assertTrue(Cashondelivery.isDisplayed());
		Assert.assertTrue(Submitbtn.isDisplayed());
		Cashondelivery.click();
		commons.wait(5);
		//Assert.assertEquals(Cashondeliverytext.getText(), read.readData("cashondeliverytext"));
		Assert.assertTrue(Otherpaymentbtn.isDisplayed());
		Assert.assertTrue(Confirmbtn.isDisplayed());
		Confirmbtn.click();
		commons.wait(5);
		Assert.assertEquals(Confirmedtext.getText(), read.readData("Confirmedtext"));
		
		//Assert.assertEquals(Cs.congratulationstext.getText(), "Congratulations, your payment has been approved and your order has been saved under the reference VUPSSMLLJ.");
		//Assert.assertEquals(Cs.cartempty.getText(), "");
		
	
}
public void test1() throws InterruptedException {

	Assert.assertTrue(homebtn.isDisplayed());
	startprctisingbtn.click();
	CommonCode.wait(3);
	String content = verifycontent.getText();
	Assert.assertEquals(content, read.readData("contenttext"));
	Intermediate.click();
	commons.wait(3);
	Assert.assertTrue(verifybutton.isDisplayed());
	proceed.click();
	commons.wait(3);
	Assert.assertTrue(verifycontent2.isDisplayed());
	commons.wait(3);
	Assert.assertTrue(verifycontent3.isDisplayed());
	completebtn.click();
	commons.wait(3);
	Assert.assertTrue(Completeverify.isDisplayed());
	homebtn.click();
}
}
