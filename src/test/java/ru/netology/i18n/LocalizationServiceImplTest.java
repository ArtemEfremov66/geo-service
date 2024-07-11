package ru.netology.i18n;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
    @Test
    public void localeRu() {
        Country russia = Country.RUSSIA;
        String result = "Добро пожаловать";
        Assertions.assertEquals(localizationService.locale(russia), result);
    }
    @Test
    public void localeEn() {
        Country germany = Country.GERMANY;
        String result = "Welcome";
        Assertions.assertEquals(localizationService.locale(germany), result);
    }
}
