package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import pages.WildberriesPage;
import org.junit.jupiter.api.Test;


public class WildberriesTests extends TestBase{
    WildberriesPage steps = new WildberriesPage();

    @DisplayName("Тест перехода на страницу продавцов")
    @Tag("sellerTest")
    @Test
    void sellerPageTest(){
        steps.openPage()
                .sellerPage()
                .CheckNewInsetUrl("https://seller.wildberries.ru/about-portal/ru/");
    }

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
