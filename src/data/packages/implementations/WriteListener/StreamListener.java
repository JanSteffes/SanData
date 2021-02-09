package data.packages.implementations.WriteListener;

import data.packages.interfaces.IStreamListener;

public class StreamListener implements IStreamListener {

    public void registerListener(long amountOfBytesProcessed) {
        System.out.println(amountOfBytesProcessed);
    }

}