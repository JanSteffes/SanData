package data.packages.implementations;

import data.ServerAction;
import data.packages.APackageData;

import java.io.Serializable;

public class PackageDataUpdate extends APackageData implements Serializable {

    private static final long serialVersionUID = -8659429541090872475L;

    public final String version;

    public PackageDataUpdate(String version) {
        this.version = version;
    }

    @Override
    public ServerAction getAction() {
        return ServerAction.CheckUpdate;
    }
}
