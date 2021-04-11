import com.netpeak.pages.CareerPage;
import com.netpeak.pages.CoursesPage;
import com.netpeak.pages.FormFillPage;
import com.netpeak.pages.MainPage;
import com.netpeak.pages.util.FormFillPageData;
import com.netpeak.pages.util.MainPageData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

    public class TestSuiteNetPeak {
        MainPageData mainPageData = new MainPageData("https://netpeak.ua/"); //здесь ввод главной страницы для теста
        FormFillPageData inputName = new FormFillPageData(
                "Mike",                                                               //ввод для заполнения данных
                "Molodik",                                                         //ввод для заполнения данных
                "C:/dev_test/NetPeak/src/main/resources/CV.png");                   //ввод для заполнения данных


        @BeforeClass(alwaysRun = true)
        public void setUp() {
            browser = "chrome";
        }

        @Test
        public void testOpenStartPage() {
            MainPage mainPage = open(mainPageData.getMainPageAddress(),MainPage.class);  //1. Перейти по ссылке на главную страницу сайта Netpeak. (https://netpeak.ua/).
            CareerPage careerPage = mainPage.clickCareerPageLink();                      //2. Перейдите на страницу "Работа в Netpeak", нажав на кнопку "Карьера".
            FormFillPage formFillPage = careerPage.clickFormFillPageLink();              //3. Перейти на страницу заполнения анкеты, нажав кнопку - "Я хочу работать в Netpeak".
            formFillPage.uploadCVFile(inputName.getFilePath());                          //4. Загрузить файл с недопустимым форматом в блоке "Резюме"
            formFillPage.fileFormatError();                                              //проверить что на странице появилось сообщение, о том что формат изображения неверный.
            formFillPage.enterName(inputName.getName());                                 //5. Заполнить случайными данными блок "3. Личные данные".
            formFillPage.enterLastName(inputName.getLastName());                         //заполнить данными блок 3
            formFillPage.clickSubmitBtn();                                               //6. Нажать на кнопку отправить резюме.
            formFillPage.allFieldsFilled();                                              //7. Проверить что сообщение на текущей странице - "Все поля являются обязательными для заполнения" - подсветилось красным цветом.
            CoursesPage coursesPage = formFillPage.clickCoursesPageLink();               //8. Перейти на страницу "Курсы" нажав соответствующую кнопку в меню
            coursesPage.checkCoursesPage();                                               //и убедиться что открылась нужная страница.
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() {
            closeWebDriver();
            }
    }

