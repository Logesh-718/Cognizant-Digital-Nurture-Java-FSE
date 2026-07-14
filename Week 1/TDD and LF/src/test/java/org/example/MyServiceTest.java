package org.example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
public class MyServiceTest {
    @Test
    public void testExternalApi() {

        // Create Mock Object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the Method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject Mock into Service
        MyService service = new MyService(mockApi);

        // Call Method
        String result = service.fetchData();

        System.out.println("Returned Data = " + result);

        // Verify
        assertEquals("Mock Data", result);
    }
}
