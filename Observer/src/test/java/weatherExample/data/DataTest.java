package weatherExample.data;

import core.Observer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import weatherExample.entity.WeatherData;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class DataTest {

    private static final WeatherData DATA=new WeatherData(30,30,30);

    @Mock
    private WeatherDataProvider mockProvider;

    @Mock
    private Observer<WeatherData> mockObserver;

    @Test
    public void testFetchDataMethod(){
        when(mockProvider.fetchData()).thenReturn(DATA);
        mockProvider.register(mockObserver);
        mockProvider.update();
        mockProvider.notifyObserver();
        mockObserver.update(mockProvider.fetchData());


        verify(mockProvider).notifyObserver();
        verify(mockProvider).update();
        verify(mockProvider).register(mockObserver);
        verify(mockProvider).fetchData();
        verify(mockObserver).update(DATA);
    }
}
