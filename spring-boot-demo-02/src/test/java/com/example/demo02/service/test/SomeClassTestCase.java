package com.example.demo02.service.test;

import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.PowerMockIgnore;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
@PrepareForTest({SomeClass.class, Thread.class})
public class SomeClassTestCase {

    @Test(expected=Test.None.class)
    public void testRun() throws Exception {     
        // if false, test will take several seconds:
        boolean isMockMode = true;

        if (isMockMode) {
            PowerMockito.mockStatic(Thread.class);
            PowerMockito.doThrow(new RuntimeException("mock error")).when(Thread.class);
            Thread.sleep(1000); 
        }

        SomeClass someClass = new SomeClass();
        
        // test
        someClass.run(); 
    }
}