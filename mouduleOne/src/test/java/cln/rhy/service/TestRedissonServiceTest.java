package cln.rhy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.redisson.RedissonReadWriteLock;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestRedissonServiceTest {

    @Mock
    private RedissonClient mockRedissonClient;

    @InjectMocks
    private TestRedissonService testRedissonServiceUnderTest;

    @Test
    public void testTest() {
        RReadWriteLock rwLock = new RedissonReadWriteLock(mockRedissonClient, "myLock");
        // Setup
        when(mockRedissonClient.getReadWriteLock("code")).thenReturn(rwLock);

        // Run the test
        testRedissonServiceUnderTest.test("code");

        // Verify the results
    }
}
