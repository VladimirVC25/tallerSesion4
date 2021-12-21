package factoryDevice;

public class FactoryDevices {

    public enum DeviceType {
        ANDROID,
        CLOUD
    }

    public static IDevice make(DeviceType deviceType){
        IDevice device;
        switch (deviceType){

            case ANDROID :
                device = new Android();
                break;
            case CLOUD:
                device = new AndroidCloud();
                break;
            default:
                device = new Android();
                break;
        }
        return device;
    }
}
