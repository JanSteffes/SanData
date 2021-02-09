package data.packages.models;

import data.packages.interfaces.IStreamListener;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamProgress extends InputStream {

    private final InputStream inputStream;
    private long bytesProcessed =0;
    private final IStreamListener streamListener;

    public InputStreamProgress(InputStream inputStream, IStreamListener writeListener) {
        this.inputStream = inputStream;
        this.streamListener = writeListener;
    }

    @Override
    public int read() throws IOException {
        int result = inputStream.read();
        bytesProcessed++;
        streamListener.registerListener(bytesProcessed);
        return result;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int result = inputStream.read(b);
        bytesProcessed+=result;
        streamListener.registerListener(bytesProcessed);
        return result;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = inputStream.read(b, off, len);
        bytesProcessed += result;
        streamListener.registerListener(bytesProcessed);
        return result;
    }

    @Override
    public long skip(long n) throws IOException {
        long skipped = inputStream.skip(n);
        bytesProcessed += skipped;
        streamListener.registerListener(bytesProcessed);
        return skipped;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}