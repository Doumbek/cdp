package work.threads;

import static work.threads.Utils.doWithLock;
import static work.threads.Utils.getFailedLockCounter;
import static work.threads.Utils.waitABit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationsLock {

    public static void main(String[] args) throws Exception {

        final Account firstAccount = new Account(1000);
        final Account secondAccount = new Account(2000);

        Thread t1 = new Thread(() -> threadSafeTransfer(firstAccount, secondAccount, 500), "First to Second");
        Thread t2 = new Thread(() -> threadSafeTransfer(secondAccount, firstAccount, 300), "Second to First");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.debug("Failed lock attempt numbers: " + getFailedLockCounter());

    }

    private static void threadSafeTransfer(final Account sourceAccount, final Account targetAccount, int amount) {
        // transferWithSync(sourceAccount, targetAccount, amount);
        transferWithLock(sourceAccount, targetAccount, amount);
    }

    private static void transferWithSync(final Account sourceAccount, final Account targetAccount, int amount) {

        synchronized (sourceAccount) {
            log.debug("Source account was synchronized [{}]", sourceAccount.toString());
            waitABit(1000);
            synchronized (targetAccount) {
                log.debug("Target account was synchronized [{}]", targetAccount.toString());
                transfer(sourceAccount, targetAccount, amount);
                log.info("Transfer finished successful");
            }
        }
    }

    private static void transferWithLock(final Account sourceAccount, final Account targetAccount, int amount) {
        doWithLock(sourceAccount::getLock,
            () -> doWithLock(targetAccount::getLock,
                () -> transfer(sourceAccount, targetAccount, amount)));
    }

    private static void transfer(Account sourceAccount, Account targetAccount, int amount) {
        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);
    }

}
