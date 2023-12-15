import withReentrantLock.CallThread;
import withSynchronized.SCall;
import withSynchronized.SCallThread;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 - решение через ReentrantLock\n2 - решение через synchronized\n");
        int option = in.nextInt();
        switch (option) {
            case 1:
                ReentrantLock locker = new ReentrantLock();
                Thread telegram = new Thread(new CallThread(locker, "Telegram", 6000));
                Thread vk = new Thread(new CallThread(locker, "VK", 3000));
                Thread zoom = new Thread(new CallThread(locker, "Zoom", 5000));
                Thread skype = new Thread(new CallThread(locker, "Skype", 1000));
                telegram.start();
                vk.start();
                zoom.start();
                skype.start();
                break;
            case 2:
                SCall call = new SCall();
                Thread telegramS = new Thread(new SCallThread(call, "Telegram", 6000));
                Thread vkS = new Thread(new SCallThread(call, "VK", 3000));
                Thread zoomS = new Thread(new SCallThread(call, "Zoom", 5000));
                Thread skypeS = new Thread(new SCallThread(call, "Skype", 1000));
                telegramS.start();
                vkS.start();
                zoomS.start();
                skypeS.start();
                break;
        }
    }
}