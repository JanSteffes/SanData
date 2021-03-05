package data.packages.implementations.PackageData;

import data.ServerAction;
import data.packages.APackageData;
import data.packages.interfaces.IStreamListener;

import java.io.Serializable;


public class PackageDataUpdateCheck extends APackageData implements Serializable {


    private static final long serialVersionUID = -274219567025293430L;

    public final String version;

    public PackageDataUpdateCheck(String version)
    {
        this.version = version;
    }

    @Override
    public ServerAction getAction() {
        return ServerAction.CheckUpdate;
    }

    @Override
    public Boolean Execute(IStreamListener streamListener) {
        return (boolean) super.Execute(streamListener);
    }
}
