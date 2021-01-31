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
public class PackageDataList extends APackageData implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8483857577336184959L;

	public PackageDataList() {
    }

    public String toString() {
        return "PackageDataList";
    }

	@Override
	public ServerAction getAction() {
		return ServerAction.ReadFiles;
	}
	
	@Override
	public String[] Execute() {
		return (String[]) super.Execute();
	}
}
