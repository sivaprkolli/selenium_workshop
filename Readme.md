About Selenium 
Locators/Selectors

- id
- className
- name
- linkText
- partialLinkText
- tagName
- xpath
- cssSelctor

- pseudo elements


Not to use: 
1. attributes with alphaNumeric or zigzag alphanumeric 
2. following, preceding - use in the worst cases when there is no option

XPath vs Css

Basic Syntax xpath :
- //input[@id='username']
//button[text()='Login'] - text() not available in cssSelctor

- //tagName[@attribute='value']
- //tagName[text()='value']

Basic Syntax cssSelector:
- input[id='username']
- tagName[attribute='value']
- without tagName : [id='user-name']

Methods in Xpath:
- Contains
//input[contains(@id,'UserFirstName')]
//tagName[contains(@attribute,'value')] - using attribute
//label[contains(text(),'First name')] - using text

Methods in css:
input[id*='UserFirstName']

- Starts-with in xpath:
//span[starts-with(@id,'UserFirstName')]
//label[starts-with(text(),'First')] 
//label[starts-with(normalize-space(),'First')]
//button[normalize-space(text())='Accept All Cookies']
//button[normalize-space(@id)='Accept All Cookies']

- Starts-with in css:
span[id^='UserFirstName']

- ends-with(not working) in xpath

- ends-with in css:
input[aria-describedby$='errMsg']

- text() - not avialble in css

//span[text()='Enter your first name']
//label[contains(text(),'First name')] - using text
//button/span[.='XS'] - instead of text() can use '.'

- normalize-space()
//label[normalize-space()='First name']
//label[starts-with(normalize-space(),'First')]

- name() - specific cases in svg elements

- position()
//ul[@class='leftmenu']/li[position()=6]


Axis::

ancestors
parent
child
descendant

following
following-sibling
preceding
preceding-sibling
self


//body/div/input[@id="password"]

using child: 
//form/child::input

//form/child::div/child::input[@placeholder='Username']
//form/div/input[@placeholder='Username']

using parent:
//div[text()='Google']/parent::label/input
//div[text()='Google']/../input

using preceding-sibling::
//div[text()='Google']/preceding-sibling::input

using following-sibling::

//label[normalize-space()='First name']/following-sibling::span
//label[normalize-space()='Company']/following-sibling::span


using descendant::
//div[@title='Google']/descendant::input

using ancestor::
//div[text()='Google']/ancestor::div[@title='Google']

using self::
//img[@alt='Salesforce logo']/self::img

using descendant-or-self::
//img[@alt='Salesforce logo']/descendant-or-self::*


Conditions in Xpath:
And, Or, Not

And::
//input[@type='text' and @placeholder='Username']
//input[@type='password'][@placeholder='Password']

Or::
//input[@type='password' or @placeholder='Password']

Not:
//div[@class='form_group']/input[not(@placeholder="Username")]

CSS With Id:
#user-name

Css with class
.login-box
.input_error.form_input - when multiple compound classes

Child in Css:
[class='login-box']>form>div>input

similar siblings : first-of-type :: 
.leftmenu > li:first-of-type

.leftmenu > li:last-of-type

.leftmenu > li:nth-of-type(6)

xpath with indexing:
(//ul[@class='leftmenu']/li)[6] - avoid

Css following-sibling:: using '+'
[name='login'] > p + div > input[name='password']

.leftmenu > li:first-of-type + li + li + li

Css with n-th child:

.leftmenu > li:nth-child(5)

Css conditions:

And ::
[name='username'][class='input']

Or::
[name='username'],[class='input']

Not::
todo


Selenium Architecture:

- Language Libraries
- Browser 
- Browser Driver - 
- W3C Protocol - previously with JSON Wire Protocol

Why WebDriver driver = new WebDriver(); -  we could not create object/intance for interface 


WebDriver driver = new ChromeDriver();

ChromiumDriver driver1 = new ChromeDriver();

RemoteWebDriver driver2 = new ChromeDriver();

Locators: XPath vs CssSelector:
	xpath
 	Traverse in both forward and backward direction to find element.
 	Xpath having many functions and axes to find element
 	Color validation not possible
 	Xpath is slower in finding element
 	Using text function - element can be found
 	css:
 	Traverse in forward direction to find element 
 	Only few functions are available
 	CssSelector is faster
 	Element can’t found using text() method(deprecated)


Implicit Wait & Explicit waits::

Implicit wait: 
applicable for all webElements
Internally the command will be executed
Can give lesser time like 2 secs



Exceptions:

- org.openqa.selenium.InvalidSelectorException: Compound class names not permitted
       WebElement submitButton = driver.findElement(By.className("submit-button btn_action"));

- org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: 

- org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.cssSelector: .submit-button.btn_actio (tried for 10 second(s) with 500 milliseconds interval)

- org.openqa.selenium.TimeoutException: Expected condition failed: Please check the webElement locator (tried for 10 second(s) with 3000 milliseconds interval)

- org.openqa.selenium.InvalidSelectorException: invalid selector
when provided wrong locator 

org.openqa.selenium.NoSuchWindowException: no such window: target window already closed


- org.openqa.selenium.ElementClickInterceptedException: element click intercepted: 

org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found

org.openqa.selenium.NoSuchFrameException: No frame element found by name or id frame-left


Stabilizing the suite:

Locator Strategy 

-> uinqe locators [id, name, className, linkText, partialText, tagName]
-> cssSelector
-> Xpath

- Avoid Sleeps
- Use properway of implicit wait
- not use explicit wait for all elements

