package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;


public class WildberriesTests extends TestBase{


    @Test
    void searchLineTest(){
        open("");
        $("#searchInput").setValue("ноутбук").pressEnter();
        $(".searching-results__title").shouldHave(text("ноутбук"));
    }

    @Test
    void burgerLineTest(){
        open("");
        $(".nav-element__burger-line").click();
        $(".menu-burger__main-list-link--629").click();
        $(byTagAndText("a", "Аксессуары для обуви")).click();
        $(".catalog-title").shouldHave(text("Аксессуары для обуви"));

    }

    @Test
    void sellerTest(){
        open("");
        $(byTagAndText("a", "Продавайте на Wildberries")).click();
        webdriver().driver().switchTo().window(1);
        webdriver().shouldHave(currentFrameUrl("https://seller.wildberries.ru/about-portal/ru/"));
    }

    @Test
    void basketTest(){
        open("");
        $(".j-item-basket").click();
        $(byTagAndText("a", "Перейти на главную")).click();
        webdriver().shouldHave(currentFrameUrl("https://www.wildberries.ru/"));
    }

    @Test
    void addresTest(){
        open("");
        $(".navbar-pc__icon--address").click();
        $(".delivery-banner-title").shouldHave(text("Быстро доставим любой Ваш заказ по всей России"));
    }
}
