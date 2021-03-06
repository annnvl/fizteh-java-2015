package ru.mipt.diht.students.annnvl.Threads.RollCall;

public class RollCall {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Please type number of threads");
        }
        int threads = Integer.parseInt(args[0]);
        RollCallerThread.setNumberOfThreads(threads);
        for (int i = 0; i < threads; i++) {
            (new RollCallerThread()).start();
        }
        while (true) {
            RollCallerThread.makeEverybodyOk();
            System.out.println("Are you ready?");
            RollCallerThread.nextRollCall();
            while (!RollCallerThread.everybodyasked()) {
                Thread.yield();
            }
            if (RollCallerThread.isEverybodyOk()) {
                RollCallerThread.yes();
                RollCallerThread.nextRollCall();
                return;
            }
        }
    }
}
