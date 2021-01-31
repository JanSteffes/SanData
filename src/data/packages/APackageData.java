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

/**
 * @author JanSt
 *
 */
public abstract class APackageData implements IPackageData 
{

	public Object Execute()
	{
		try
		{
			Socket socket = new Socket();
			InetSocketAddress endpoint;
			System.out.println("connecting to " + Config.SERVER_ADDRESS + ":" + Config.SERVER_PORT + " ...");
			endpoint = new InetSocketAddress(InetAddress.getByName(Config.SERVER_ADDRESS), Config.SERVER_PORT);
			socket.connect(endpoint);
			System.out.println("connected!");
			System.out.println("get output steam..");
			OutputStream outputStream = socket.getOutputStream();
			System.out.println("create output writer...");
			ObjectOutputStream writer = new ObjectOutputStream(outputStream);

			System.out.println("sending " + getClass().getName() + " request...");
			writer.writeObject(this);
			writer.flush();

			System.out.println("get input steam..");
			InputStream inputStream = socket.getInputStream();
			System.out.println("create input reader...");
			ObjectInputStream reader = new ObjectInputStream(inputStream);
			System.out.println("read object...");
			Object result = reader.readObject();
			System.out.println("Got data!");
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
