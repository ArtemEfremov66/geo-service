package ru.netology.sender;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.geo.GeoServiceImplTest;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class MessageSenderImplTest {
    @Test
    public void sendTestRu() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.0.0"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localService.locale(RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localService);

        Map<String, String> test = new HashMap<String, String>();
        test.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.0.0");

        String expected = messageSender.send(test);

        Assertions.assertEquals(expected, "Добро пожаловать");
    }
    @Test
    public void sendTestEn() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.0.0.0"))
                .thenReturn(new Location("New York", USA, " 10th Avenue", 32));

        LocalizationServiceImpl localService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localService.locale(USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localService);

        Map<String, String> test = new HashMap<String, String>();
        test.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.0.0.0");

        String expected = messageSender.send(test);

        Assertions.assertEquals(expected, "Welcome");
    }
}
