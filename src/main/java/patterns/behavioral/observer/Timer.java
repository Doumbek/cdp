package patterns.behavioral.observer;

import epam.cdp.utils.WaitUtil;

public class Timer implements Runnable {

    private InstantProvider instantProvider;

    public Timer(final InstantProvider instantProvider) {
        this.instantProvider = instantProvider;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            WaitUtil.waitABit(1000);
            instantProvider.updateInstant();
        }
    }

}
