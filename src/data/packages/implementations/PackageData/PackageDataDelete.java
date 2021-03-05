/**
 * 
 */
package data.packages.implementations.PackageData;

import java.io.Serializable;
import java.util.ArrayList;

import data.ServerAction;
import data.packages.interfaces.IStreamListener;

/**
 * @author JanSt
 *
 */
public class PackageDataDelete extends APackageDataFileOperation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6498300798327382888L;
	
	/**
	 * Files to delete
	 */
    public final ArrayList<String> filesToDelete;


	/**
	 * 
	 */
	public PackageDataDelete(String folderName, ArrayList<String> filesToDelete) {
		this.folderName = folderName;
		this.filesToDelete = filesToDelete;
	}

	@Override
	public ServerAction getAction() {
		return ServerAction.DeleteFiles;
	}
	
	@Override
	public Boolean Execute(IStreamListener streamListener) {
		return (boolean) super.Execute(streamListener);
	}

}
