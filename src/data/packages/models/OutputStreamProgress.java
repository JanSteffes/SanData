package data.packages.models;

import data.packages.interfaces.IStreamListener;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamProgress extends OutputStream {

    private final OutputStream outStream;
    private long bytesWritten=0;
    private final IStreamListener writeListener;

    public OutputStreamProgress(OutputStream outStream, IStreamListener writeListener) {
        this.outStream = outStream;
        this.writeListener = writeListener;
    }

    @Override
    public void write(int b) throws IOException {
        outStream.write(b);
        bytesWritten++;
        writeListener.registerListener(bytesWritten);
    }

    @Override
    public void write(byte[] b) throws IOException {
        outStream.write(b);
        bytesWritten += b.length;
        writeListener.registerListener(bytesWritten);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outStream.write(b, off, len);
        bytesWritten += len;
        writeListener.registerListener(bytesWritten);
    }

    @Override
    public void flush() throws IOException {
        outStream.flush();
    }

    @Override
    public void close() throws IOException {
        outStream.close();
    }
}