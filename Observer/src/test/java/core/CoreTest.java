package core;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


@RunWith(MockitoJUnitRunner.class)
public class CoreTest {

    private static final String TEST_STRING=CoreTest.class.getSimpleName();

    private FakeObservable fakeObservable;

    @Mock
    private Observable<String> mockObservable;

    @Mock
    private Observer<String> mockObserver;

    @Before
    public void setUp(){
        fakeObservable=new FakeObservable(TEST_STRING);
    }

    @Test
    public void testMockObservableRegister(){
        mockObservable.register(result->{});
        mockObservable.register(result->{});

        verify(mockObservable,times(2)).register(any());
    }

    @Test
    public void testSpyObservableRegister(){

        fakeObservable=Mockito.spy(fakeObservable);
        fakeObservable.register(result->assertThat(result,is(TEST_STRING)));
        fakeObservable.register(result->assertThat(result.toLowerCase(),is(TEST_STRING.toLowerCase())));
        fakeObservable.register(result->assertThat(result.length(),is(TEST_STRING.length())));

        fakeObservable.notifyObserver();

        verify(fakeObservable,times(3)).register(any());
        verify(fakeObservable).notifyObserver();

    }

    @Test
    public void testSpyObservableDisposing(){

        fakeObservable=Mockito.spy(fakeObservable);
        fakeObservable.register(mockObserver);
        fakeObservable.unregister(mockObserver);

        verify(fakeObservable).unregister(mockObserver);
        assertThat(fakeObservable.getObservers().size(),is(0));

        fakeObservable.register(mockObserver);
        fakeObservable.disposeAll();

        verify(fakeObservable).disposeAll();
        assertThat(fakeObservable.getObservers().size(),is(0));
    }


}
