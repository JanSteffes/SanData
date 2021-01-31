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
public class PackageDataScan extends APackageData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4508849561700758716L;

	public final int chosenOption;

    public final String chosenName;

    public PackageDataScan(int ch, String name) {
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
	public Boolean Execute() {
		return (boolean) super.Execute();
	}

}
