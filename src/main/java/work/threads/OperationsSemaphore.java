package work.threads;

import static java.util.concurrent.TimeUnit.SECONDS;
import static work.threads.Utils.getFailedLockCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import org.apache.commons.lang3.RandomUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsSemaphore {

    public static final long SERVICE_TERMINATION_TIMEOUT = 30;

    public static void main(String[] args) throws Exception {

        final Account firstAccount = new Account(1000);
        final Account secondAccount = new Account(2000);
        final Semaphore semaphore = new Semaphore(2);
        final ExecutorService service = Executors.newFixedThreadPool(5);
        final List<Transfer> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Transfer(firstAccount, secondAccount, RandomUtils.nextInt(50, 100), semaphore));
        }
        final List<Future<Boolean>> results = service.invokeAll(threads);
        service.shutdown();
        service.awaitTermination(SERVICE_TERMINATION_TIMEOUT, SECONDS);

        log.debug("Failed lock attempt numbers: " + getFailedLockCounter());

        results.forEach(f -> {
            try {
                log.debug(String.valueOf(f.get()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

}
