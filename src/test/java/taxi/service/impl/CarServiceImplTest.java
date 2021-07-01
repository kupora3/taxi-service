package taxi.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import taxi.dao.CarDao;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.model.Manufacturer;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {
    private static final Integer ACTUAL_SIZE = 0;
    @Mock
    private CarDao carDao;
    @InjectMocks
    private CarServiceImpl carService;
    private Car car;
    private Driver driver;

    @BeforeEach
    void setUp() {
    car = new Car("Mercedes",
            new Manufacturer("Mercedes-Motors","Germany"));
    driver = new Driver();
    driver.setName("John");
    }

    @Test
    void addDriverToCar_Ok() {
        OngoingStubbing<Car> carOngoingStubbing = when(carDao.update(car)).thenReturn(car);
        carService.addDriverToCar(driver,car);
        verify(carDao).update(car);
        assertNotNull(carOngoingStubbing);
        assertEquals(car.getDrivers().get(0),driver);
    }

    @Test
    void removeDriverFromCar_Ok() {
        OngoingStubbing<Car> carOngoingStubbing = when(carDao.update(car)).thenReturn(car);
        carService.removeDriverFromCar(driver,car);
        verify(carDao).update(car);
        assertNotNull(carOngoingStubbing);
        assertEquals(car.getDrivers().size(),ACTUAL_SIZE);
    }
}