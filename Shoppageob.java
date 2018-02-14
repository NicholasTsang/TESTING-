package testingweek;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Shoppageob {

	/*
	@FindBy(css = "")
	private WebElement ;
	*/
	
	
	
	@FindBy(css = "#newsletter-input")
	private WebElement NewsLetter ;
	
	@FindBy(css =" #newsletter_block_left > div > form > div > button ")
	private WebElement NewsButton;
	
	@FindBy(css = "#block_various_links_footer > ul > li:nth-child(4) > a")
	private WebElement TheirStore;
	
	@FindBy(css = "#addressInput")
	private WebElement Address;
	
	@FindBy(css = "#center_column > div.store-content > div:nth-child(3) > button")
	private WebElement AddressButton;
	
	@FindBy(css= "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement SigninButton; 
	
	@FindBy(css = "#email_create")
	private WebElement EmailCreate;
	
	@FindBy(css = "#SubmitCreate > span")
	private WebElement AccountCreate;
	
	@FindBy (css ="#id_gender1")
	private WebElement Man;

	@FindBy(css = "#customer_firstname" )
	private WebElement Firstname;
	
	@FindBy(css = "#customer_lastname")
	private WebElement Lastname;
	
	@FindBy(css = "#passwd")
	private WebElement Password ;
	
	@FindBy(css = "#days" )
	private WebElement Day;
	
	@FindBy(css = "#months")
	private WebElement Month;

	@FindBy(css = "#years")
	private WebElement Year;
	
	
	public void NewsEmail() {
		NewsLetter.sendKeys("ufhadf@isughsad.com");
	}
	
	public void NewsSend() {
		NewsButton.click();
	}

	public void StoreLocate() {
		TheirStore.click();
	}
	
	public void AddressInput() {
		Address.sendKeys("kendall");
	}
	
	public void AddressSearch() {
		AddressButton.click();
	}
	
	public void Signin () {
		SigninButton.click();
	}
	
	public void CreateAccount () {
		EmailCreate.sendKeys("usoasd@dhs.com");
		AccountCreate.click();
	}
	
	public void Personal () {
		Man.click();
		Firstname.sendKeys("fjow");
		Lastname.sendKeys("fref");
		Password.sendKeys("Primark1!");
		Day.click();
		Select DaySelect =  new Select(Day);
		DaySelect.selectByIndex(1);
		
		Month.click();
		Select MonthSelect =  new Select(Month);
		MonthSelect.selectByIndex(1);
		
		Year.click();
		Select YearSelect =  new Select(Year);
		YearSelect.selectByIndex(1965);
	}
}
