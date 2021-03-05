package data.packages.interfaces;

public interface IStreamListener {
    void registerListener(long amountOfBytesWritten);
    void setMaxBytesToProcess(long amountOfBytesToProcess);
}
