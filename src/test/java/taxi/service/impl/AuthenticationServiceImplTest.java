package taxi.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import taxi.lib.exception.AuthenticationException;
import taxi.model.Driver;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {
    private static final String DRIVER_LOGIN = "John";
    private static final String DRIVER_PASSWORD = "12345";
    private Driver driver;

    @Mock
    private DriverServiceImpl driverService;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @BeforeEach
    void setUp() {
        driver = new Driver();
        driver.setLogin(DRIVER_LOGIN);
        driver.setPassword(DRIVER_PASSWORD);
    }

    @Test
    void loginMethodWork_Ok() throws AuthenticationException {
        String login = "John";
        String password = "12345";
        when(driverService.findByLogin(login))
                .thenReturn(Optional.ofNullable(driver));
        Driver loggedInDriver = authenticationService.login(login, password);
        assertNotNull(loggedInDriver);
        assertEquals(login,loggedInDriver.getLogin());
    }

    @Test
    void loginMethodWorkWithIncorrectParam_Ok() {
        String login = "Frank";
        String password = "12345";
        when(driverService.findByLogin(login))
                .thenAnswer(i -> {
                    if (login.equals(driver.getLogin())) {
                        return Optional.ofNullable(driver);
                    }
                    return Optional.empty();
                });
       assertThrows(AuthenticationException.class, () ->
       {authenticationService.login(login, password);});
    }

    @Test
    void loginMethodWorkWithIncorrectParam_NotOk() throws AuthenticationException {
        String login = "Mark";
        String password = "12345";
        when(driverService.findByLogin(login))
                .thenReturn(java.util.Optional.ofNullable(driver));
        Driver loggedInDriver = authenticationService.login(login, password);
        assertNotNull(loggedInDriver);
        assertNotEquals(login,loggedInDriver.getLogin());
    }
}