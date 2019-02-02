package epam.cdp.utils;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.apache.commons.lang3.StringUtils.leftPad;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import com.google.common.base.Stopwatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitUtil {

    private static final String COMPLETED_DOCUMENT_STATE = "complete";
    private static final String LOADING_DOCUMENT_STATE = "loading";

    private WaitUtil() {
    }

    public static void waitABit(final long timeInMilliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeInMilliseconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(String.format("Unable to wait [%s] ms", timeInMilliseconds), e);
        }
    }

    public static void waitToBeFulfilled(final BooleanSupplier suppliedCondition, final long waitTimeout,
            final long waitInterval) {
        waitToBeFulfilled(suppliedCondition, waitTimeout, waitInterval,
            "Timeout expired - wait condition was not fulfilled.");
    }

    public static void waitToBeFulfilled(final BooleanSupplier suppliedCondition, final long waitTimeout,
            final long waitInterval, final String exceptionMessage) {
        waitToBeFulfilled(suppliedCondition, waitTimeout, waitInterval,
            () -> new IllegalStateException(exceptionMessage));
    }

    public static void waitToBeFulfilled(final BooleanSupplier suppliedCondition, final long waitTimeout,
            final long waitInterval, final Supplier<RuntimeException> exceptionSupplier) {
        waitFor(suppliedCondition, waitTimeout, waitInterval);
        if (!suppliedCondition.getAsBoolean()) {
            throw exceptionSupplier.get();
        }
    }

    public static void waitFor(final BooleanSupplier suppliedCondition, final long waitTimeout,
            final long waitInterval) {
        final Stopwatch waitTimer = Stopwatch.createStarted();
        for (long secs = 0; secs <= waitTimeout; secs += waitInterval) {
            waitABit(waitInterval);
            if (suppliedCondition.getAsBoolean() || (waitTimer.elapsed(MILLISECONDS) > waitTimeout)) {
                break;
            } else {
                // debugElapsedTime(waitTimer.elapsed(MILLISECONDS));
                System.out.println("Wait a bit...");
            }
        }
    }

    public static void waitSilently(final BooleanSupplier suppliedCondition, final long waitTimeout,
            final long waitInterval) {
        final Stopwatch waitTimer = Stopwatch.createStarted();
        for (long secs = 0; secs <= waitTimeout; secs += waitInterval) {
            waitABit(waitInterval);
            if (suppliedCondition.getAsBoolean() || (waitTimer.elapsed(MILLISECONDS) > waitTimeout)) {
                break;
            }
        }
    }

    private static void debugElapsedTime(final long millis) {
        final long logMillis = (millis / 1000) * 1000;
        log.debug("{} ms waiting...", leftPad(NumberFormat.getInstance().format(logMillis), 6));
    }
}
