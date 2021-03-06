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
public class PackageDataScan extends APackageDataFileOperation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4508849561700758716L;

	public final int chosenOption;

    public final String chosenName;

	public PackageDataScan(String folderName, int ch, String name) {
		this.folderName = folderName;
        this.chosenOption = ch;
        this.chosenName = name;
    }

	public String toString() {
        return "PackageDataScan: " + chosenOption + "|" + chosenName;
    }
    
    public int getOption()
    {
    	return chosenOption;
    }

	@Override
	public ServerAction getAction() {
		return ServerAction.Scan;
	}

	@Override
	public Boolean execute(IStreamListener streamListener) {
		return (boolean) super.execute(streamListener);
	}

}
