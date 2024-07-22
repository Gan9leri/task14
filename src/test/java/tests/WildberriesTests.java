package tests;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import pages.WildberriesPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

@Tag("form")
@DisplayName("Тесты для формы Wildberries")
@Feature("Issues")
public class WildberriesTests extends TestBase{
    WildberriesPage steps = new WildberriesPage();

    @DisplayName("Тест перехода на страницу трудоустройства")
    @Tag("workPageTest")
    @Test
    void workPageTest() {
        steps.openPage()
                .workPage()
                .checkUrl("https://www.wildberries.ru/services/trudoustroystvo");
    }

    @DisplayName("Тест перехода в корзину и обратно")
    @Tag("basketTest")
    @Test
    void basketTest(){
        steps.openPage()
                .goToBasket()
                .goToMainPage()
                .checkUrl("https://www.wildberries.ru/");

    }
    @DisplayName("Тест пустоты корзины")
    @Tag("emptyBasketTest")
    @Test
    void emptyBasketTest(){
        steps.openPage()
                .goToBasket()
                .isEmptyBusket();
    }

    @DisplayName("Тест перехода к доставке")
    @Tag("addresPageTest")
    @Test
    void addresPageTest(){
        steps.openPage()
                .goToAddres()
                .testAddresPage("Быстро доставим любой Ваш заказ по всей России");
    }

    @DisplayName("Тест перехода на страницу авторизации")
    @Tag("loginPageTest")
    @Test
    void loginPageTest(){
        steps.openPage()
                .loginButtonClick()
                .checkLoginPage("Войти или создать профиль");
    }
}
