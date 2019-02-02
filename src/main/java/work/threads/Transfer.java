package work.threads;

import static work.threads.Utils.doWithLock;
import static work.threads.Utils.waitABit;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Transfer implements Callable<Boolean> {

    private Account sourceAccount;
    private Account targetAccount;
    private int amount;
    private Semaphore semaphore;

    public Transfer(final Account sourceAccount, final Account targetAccount, final int amount) {
        this(sourceAccount, targetAccount, amount, null);
    }

    public Transfer(final Account sourceAccount, final Account targetAccount, final int amount,
            final Semaphore semaphore) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
        this.semaphore = semaphore;
    }

    @Override
    public Boolean call() throws Exception {
        Boolean result;
        if (Objects.nonNull(semaphore)) {
            try {
                semaphore.acquire();
                result = transferWithLock(sourceAccount, targetAccount, amount);
            } finally {
                semaphore.release();
            }
        } else {
            result = transferWithLock(sourceAccount, targetAccount, amount);
        }
        return result;
    }

    private Boolean transferWithLock(final Account sourceAccount, final Account targetAccount, int amount) {
        return doWithLock(sourceAccount::getLock,
            () -> doWithLock(targetAccount::getLock,
                () -> transfer(sourceAccount, targetAccount, amount)));
    }

    private void transfer(Account sourceAccount, Account targetAccount, int amount) {
        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);
        waitABit(ThreadLocalRandom.current().nextLong(2000L));
    }
}
