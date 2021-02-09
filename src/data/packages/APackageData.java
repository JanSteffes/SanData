/**
 * 
 */
package data.packages;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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

	public Object Execute()
	{
		return Execute(null);
	}

	public Object Execute(IStreamListener streamListener)
	{
		try
		{
			String address = Config.getServer();
			Socket socket = new Socket();
			InetSocketAddress endpoint;
			System.out.println("connecting to " + address + ":" + Config.SERVER_PORT + " ...");
			endpoint = new InetSocketAddress(InetAddress.getByName(address), Config.SERVER_PORT);
			socket.connect(endpoint);
			System.out.println("connected!");
			System.out.println("get output steam..");
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream writer;
			System.out.println("create output writer...");
			if (streamListener != null)
			{
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
			if (streamListener != null) {
				InputStreamProgress inputStreamProgress = new InputStreamProgress(inputStream, streamListener);
				reader = new ObjectInputStream(inputStreamProgress);
			}
			else
			{
				reader = new ObjectInputStream(inputStream);
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
