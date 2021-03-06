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
public class PackageDataListFiles extends APackageDataFileOperation implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8483857577336184959L;

	public PackageDataListFiles(String folderName) {
		this.folderName = folderName;
    }

	@Override
	public ServerAction getAction() {
		return ServerAction.ReadFiles;
	}

	@Override
	public String[] execute(IStreamListener streamListener) {
		return (String[]) super.execute(streamListener);
	}
}
