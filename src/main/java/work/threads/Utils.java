package work.threads;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    public static final long WAIT_LOCK_SECONDS = 5;
    private static AtomicInteger failedLockCounter = new AtomicInteger(0);

    private Utils() {
    }

    public static Boolean doWithLock(final Supplier<Lock> lockProvider, final Action action) {
        Lock lock = lockProvider.get();
        Boolean result = false;
        try {
            log.debug("Try to lock resource [{}]", lock.toString());
            if (lock.tryLock(WAIT_LOCK_SECONDS, SECONDS)) {
                log.debug("Resource was locked [{}]", lock.toString());
                try {
                    action.perform();
                    result = true;
                } finally {
                    lock.unlock();
                    log.debug("Resource was unlocked [{}]", lock.toString());
                }
            } else {
                log.debug("Could not lock resource [{}]", lock.toString());
                incrementFailedLockCounter();
                result = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void incrementFailedLockCounter() {
        failedLockCounter.incrementAndGet();
    }

    public static int getFailedLockCounter() {
        return failedLockCounter.get();
    }

    public static void waitABit(final long timeoutImMills) {
        try {
            MILLISECONDS.sleep(timeoutImMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
