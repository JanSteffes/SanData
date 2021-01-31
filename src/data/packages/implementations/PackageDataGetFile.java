/**
 * 
 */
package data.packages.implementations;

import java.io.Serializable;

import data.ServerAction;
import data.packages.APackageData;

/**
 * @author JanSt
 *
 */
public class PackageDataGetFile extends APackageData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5552175804290001907L;

	public final String fileName;
	
	/**
	 * 
	 */
	public PackageDataGetFile(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public ServerAction getAction() {
		return ServerAction.StreamFile;
	}

	@Override
	public byte[] Execute() {
		return (byte[]) super.Execute();
	}

}
