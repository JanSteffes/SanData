package data.packages.implementations.WriteListener;

import data.packages.interfaces.IStreamListener;

public class StreamListener implements IStreamListener {

    private long maxBytesToProcess;
    private int processed;

    public void registerListener(long amountOfBytesProcessed) {
        if (maxBytesToProcess != 0) {
            int currentPercent = (int) (100 * amountOfBytesProcessed / maxBytesToProcess);
            if (currentPercent != this.processed) {
                this.processed = currentPercent;
                System.out.println(amountOfBytesProcessed + " of " + maxBytesToProcess + "(" + processed + "% )");
            }
        }
    }

    public void setMaxBytesToProcess(long amountOfBytesToProcess)
    {
        System.out.println("Setting bytes to process to " + amountOfBytesToProcess);
        maxBytesToProcess = amountOfBytesToProcess;
        this.processed = 0;
    }

}