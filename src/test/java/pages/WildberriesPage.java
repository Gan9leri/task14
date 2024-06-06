package pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class WildberriesPage {

    private final SelenideElement
            workButton = $(byTagAndText("a", "Работа в Wildberries")),
            basket = $(".j-item-basket"),
            emptyBasketTitle = $(".basket-empty__title"),
            mainPageButton = $(byTagAndText("a", "Перейти на главную")),
            addresButton = $(".navbar-pc__icon--address"),
            deliveryBannerTitle =  $(".delivery-banner-title"),
            loginButton =  $(".j-main-login"),
            loginTitle = $(byTagAndText("h2","Войти или создать профиль"));


    @Step("Открытие страницы")
    public WildberriesPage openPage(){
        open("");
        return this;
    }

    @Step("Переход на страницу трудоустройства")
    public WildberriesPage workPage(){
        workButton.click();
        return this;
    }

    @Step("Проверка url")
    public WildberriesPage checkUrl(String value){
        webdriver().shouldHave(currentFrameUrl(value));
        return this;
    }

    @Step("Переход в корзину")
    public WildberriesPage goToBasket(){
        basket.click();
        return this;
    }

    @Step("Проверка, что в корзине пусто")
    public WildberriesPage isEmptyBusket(){
        emptyBasketTitle.shouldHave(text("В корзине пока пусто"));
        return this;
    }

    @Step("Переход на главную страницу")
    public WildberriesPage goToMainPage(){
        mainPageButton.click();
        return this;
    }

    @Step("Переход к доставке")
    public WildberriesPage goToAddres(){
        addresButton.click();
        return this;
    }

    @Step("Проверка информации по доставке")
    public WildberriesPage testAddresPage(String value){
        deliveryBannerTitle.shouldHave(text(value));
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public WildberriesPage loginButtonClick(){
        loginButton.click();
        return this;
    }

    @Step("Проверка заголовка окна авторизации")
    public WildberriesPage checkLoginPage(String value){
        loginTitle.shouldHave(text(value));
        return this;
    }



}
