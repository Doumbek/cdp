package patterns.structural.bridge;

import patterns.structural.proxy.DBConnection;
import patterns.structural.proxy.DBConnectionProxy;
import patterns.structural.proxy.DBManager;
import patterns.structural.proxy.IDBConnection;

public class Example {

    public static void main(String[] args) {

        final RemoteControl tvRemoteControl = new CommonRemoteControl(new TV());
        final AdvancedRemoteControl radioRemoteControl = new AdvancedRemoteControl(new Radio());

        System.out.println(tvRemoteControl.getState());
        tvRemoteControl.volumeUp();
        tvRemoteControl.volumeUp();
        tvRemoteControl.volumeUp();
        tvRemoteControl.volumeDown();
        System.out.println(tvRemoteControl.getState());

        System.out.println("===============================");

        System.out.println(radioRemoteControl.getState());
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeDown();
        radioRemoteControl.mute();
        System.out.println(radioRemoteControl.getState());

    }

}
