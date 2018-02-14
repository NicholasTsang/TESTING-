package testingweek;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Mousepage {
	
	/*
	@FindBy(css = "")
	private WebElement ;
	*/
	
	@FindBy(css = "#draggableview > p")
	private WebElement Dragme ;
	
	@FindBy(css = "#droppableview")
	private WebElement Drophere;
	
	@FindBy(css = "#ui-id-2")
	private WebElement Accept;
	
	@FindBy(css = "#draggableaccept > p")
	private WebElement ADrag;
	
	@FindBy(css = "#droppableaccept")
	private WebElement ADrop;
	
	@FindBy(css = "#ui-id-5")
	private WebElement Shopcart;
	
	@FindBy(css = "#ui-id-7 > ul > li:nth-child(1)")
	private WebElement LolCatShirt ;
	
	@FindBy(css = "#ui-id-8")
	private WebElement Bags;
	
	@FindBy(css = "#ui-id-9 > ul > li:nth-child(3)")
	private WebElement AlLeather ;
	
	@FindBy(css = "#ui-id-10")
	private WebElement Gadgets ;
	
	@FindBy(css = "#ui-id-11 > ul > li:nth-child(1)")
	private WebElement Iphone ;

	@FindBy(css = "#cart > div > ol")
	private WebElement Cart;
	
	public void DropD(WebDriver webDriver) {
		Actions Mouzer = new Actions(webDriver);
		Mouzer.clickAndHold(Dragme).moveToElement(Drophere).release().perform();
	}
	
	public void DropA(WebDriver webDriver) {
		Actions Mouzer = new Actions(webDriver);
		Accept.click();
		Mouzer.clickAndHold(ADrag).moveToElement(ADrop).release().perform();
	}
	
	public void ShoppingCart(){
		Shopcart.click();
	}
	
	public void BuyShirt(WebDriver webDriver) {
		Actions Mouzer = new Actions(webDriver);
		Mouzer.clickAndHold(LolCatShirt).moveToElement(Cart).release().perform();
	}
	
	public void BagSection() {

		Bags.click();
	}
	
	public void BuyBag(WebDriver webDriver) {
		
		Actions Mouzer = new Actions(webDriver);
		Mouzer.clickAndHold(AlLeather).moveToElement(Cart).release().perform();
	}
	
	public void GadgetsSection(){
		Gadgets.click();
	}
	
	public void BuyApple(WebDriver webDriver) {
		
		Actions Mouzer = new Actions(webDriver);
		Mouzer.clickAndHold(Iphone).moveToElement(Cart).release().perform();
	}

}
