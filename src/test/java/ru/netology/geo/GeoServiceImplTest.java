package ru.netology.geo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.entity.Location;

public class GeoServiceImplTest {
    String ip;
    GeoServiceImpl geoService = new GeoServiceImpl();
    @Test
    public void byIpNull() {
        ip = "666";
        Location result = geoService.byIp(ip);
        Assertions.assertNull(result);
    }
    @Test
    public void byIpLocal() {
        ip = "127.0.0.1";
        Location result = geoService.byIp(ip);
        Assertions.assertNull(result.getCountry());
    }
    @Test
    public void byIpUSA() {
        ip = "96.44.183.149";
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(result.getBuiling(), 32 );
    }
}
