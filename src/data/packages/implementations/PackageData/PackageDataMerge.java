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
public class PackageDataMerge extends APackageDataFileOperation implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5006935905820211682L;

	/**
	 * Files to merge
	 */
    public final ArrayList<String> filesToMerge;
    
    /**
     * Name of file after merging
     */
    public final String mergedFileName;


	public PackageDataMerge(String folderName, String mergedFilename, ArrayList<String> filesToMerge) {
		this.folderName = folderName;
		this.mergedFileName = mergedFilename;
        this.filesToMerge = filesToMerge;
    }

    public String toString() {
        return "PackageDataMerge: " + mergedFileName + "|" + String.join(",", filesToMerge);
    }

	@Override
	public ServerAction getAction() {
		return ServerAction.MergeFiles;
	}

	@Override
	public Boolean Execute() {
		return (boolean) super.Execute();
	}
}
