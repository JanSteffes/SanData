/**
 * 
 */
package data.packages.implementations.PackageData;

import java.io.Serializable;

import data.ServerAction;
import data.packages.interfaces.IStreamListener;

/**
 * @author JanSt
 *
 */
public class PackageDataGetFile extends APackageDataFileOperation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5552175804290001907L;

	public final String fileName;

	/**
	 * 
	 */
	public PackageDataGetFile(String folderName, String fileName) {
		this.folderName = folderName;
		this.fileName = fileName;
	}


	@Override
	public ServerAction getAction() {
		return ServerAction.StreamFile;
	}

	@Override
	public byte[] Execute(IStreamListener streamListener) {
		return (byte[]) super.Execute(streamListener);
	}

}
