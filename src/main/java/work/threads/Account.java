package work.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Account {

    private Lock lock;
    private int balance;

    public Account(int balance) {
        this(balance, new ReentrantLock());
    }

    public Account(int balance, final Lock lock) {
        debugWithThreadName("New account was created with balance {}", balance);
        this.balance = balance;
        this.lock = lock;
    }

    public void withdraw(int amount) {
        debugWithThreadName("Current balance is: {}. Try to withdraw {} amount", balance, amount);
        if (getBalance() < amount) {
            throw new IllegalStateException("You do not have enough money!");
        }
        balance -= amount;
        debugWithThreadName("New balance is {}", balance);
    }

    public void deposit(int amount) {
        debugWithThreadName("Current balance is: {}. Try to deposit {} amount", balance, amount);
        balance += amount;
        debugWithThreadName("New balance is {}", balance);

    }

    private void debugWithThreadName(final String message, Object... objects) {
        final String threadName = String.format("[%s] -> ", Thread.currentThread().getName());
        log.debug(threadName.concat(message), objects);
    }

}
