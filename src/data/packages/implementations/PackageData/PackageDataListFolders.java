/**
 * 
 */
package data.packages.implementations.PackageData;

import data.ServerAction;
import data.packages.APackageData;
import data.packages.interfaces.IStreamListener;

import java.io.Serializable;

/**
 * @author JanSt
 *
 */
public class PackageDataListFolders extends APackageData implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 8483857577336184959L;

	@Override
	public ServerAction getAction() {
		return ServerAction.ReadFolders;
	}

	@Override
	public String[] Execute() {
		return (String[]) super.Execute();
	}
}