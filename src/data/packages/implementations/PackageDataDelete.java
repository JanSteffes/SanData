/**
 * 
 */
package data.packages.implementations;

import java.io.Serializable;
import java.util.ArrayList;

import data.ServerAction;
import data.packages.APackageData;

/**
 * @author JanSt
 *
 */
public class PackageDataDelete extends APackageData implements Serializable {

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
	public PackageDataDelete(ArrayList<String> filesToDelete) {
		this.filesToDelete = filesToDelete;
	}

	@Override
	public ServerAction getAction() {
		return ServerAction.DeleteFiles;
	}
	
	@Override
	public Boolean Execute() {
		return (boolean) super.Execute();
	}

}
