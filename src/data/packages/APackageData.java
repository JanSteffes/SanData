package data.packages;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import data.Config;
import data.packages.interfaces.IPackageData;
import data.packages.interfaces.IStreamListener;
import data.packages.models.InputStreamProgress;
import data.packages.models.OutputStreamProgress;

/**
 * @author JanSt
 *
 */
public abstract class APackageData implements IPackageData
{
	private int getSize() throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
		objectOutputStream.writeObject(this);
		objectOutputStream.flush();
		return outStream.toByteArray().length;

	}

	public Object execute(IStreamListener streamListener)
	{
		try
		{
			String address = Config.getServer();
			Socket socket = new Socket();
			InetSocketAddress endpoint;
			System.out.println("connecting to " + address + ":" + Config.getPort() + " ...");
			endpoint = new InetSocketAddress(InetAddress.getByName(address), Config.getPort());
			socket.connect(endpoint);
			System.out.println("connected!");
			System.out.println("get output steam..");
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream writer;
			System.out.println("create output writer...");
			if (streamListener != null)
			{
				streamListener.setMaxBytesToProcess(getSize());
				OutputStreamProgress outputStreamProgress = new OutputStreamProgress(outputStream, streamListener);
				writer = new ObjectOutputStream(outputStreamProgress);
			}
			else
			{
				writer = new ObjectOutputStream(outputStream);
			}

			System.out.println("sending " + getClass().getName() + " request...");
			writer.writeObject(this);
			writer.flush();
			System.out.println("get input steam..");
			InputStream inputStream = socket.getInputStream();
			System.out.println("create input reader...");
			ObjectInputStream reader;
			InputStreamProgress inputStreamProgress = null;
			if (streamListener != null) {
				streamListener.setMaxBytesToProcess(0);
				inputStreamProgress = new InputStreamProgress(inputStream, streamListener);
				reader = new ObjectInputStream(inputStreamProgress);
			}
			else{
				reader = new ObjectInputStream(inputStream);
			}
			int size = reader.readInt();
			System.out.println("size is " + size + " bytes");
			if (streamListener != null)
			{
				inputStreamProgress.resetBytesProcessed();
				streamListener.setMaxBytesToProcess(size - (Integer.bitCount(size) / 8) - 4);
			}
			System.out.println("read object...");
			Object result = reader.readObject();
			System.out.println("Got data: " + result);
			reader.close();
			writer.close();
			socket.close();
			System.out.println("terminating connection..");
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
