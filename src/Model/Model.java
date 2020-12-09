package Model;

public class Model {
    private DrawPanel drawPanel;
    private IWorld world;
    private VehicleAttribute hasTurboModel;
    private VehicleAttribute hasPlatformModel;

    public Model() {

    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public IWorld getWorld() {
        return world;
    }

    public VehicleAttribute getHasTurboModel() {
        return hasTurboModel;
    }

    public VehicleAttribute getHasPlatformModel() {
        return hasPlatformModel;
    }
}
