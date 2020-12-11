package misc;

public class CompareStrings
{
    public static void main(String[] args)
    {
        System.out.println(compareStates(null, null));
        System.out.println(compareStates("DEVICE_STATE_VALUE", "DEVICE_STATE_VALUE"));
        System.out.println(compareStates(null, "DEVICE_STATE_VALUE"));
        System.out.println(compareStates("DEVICE_STATE_VALUE", null));
        System.out.println(compareStates("some value", "DEVICE_STATE_VALUE"));
        System.out.println(compareStates("", "DEVICE_STATE_VALUE"));
    
//        System.out.println(isEmpty(null));
//        System.out.println(isEmpty(""));
//        System.out.println(isEmpty("adsfasdf"));
    }
    
    static boolean compareStates(String deviceState, String aeDeviceState)
    {
        boolean isEqual = false;
        
//        isEqual = (deviceState == null && aeDeviceState == null) ? true : ((deviceState != null && aeDeviceState == null) || (aeDeviceState != null && deviceState == null)) ? false :
//                (aeDeviceState.equalsIgnoreCase(deviceState)) ? true : false;
        
        isEqual = deviceState == null ? aeDeviceState == null : deviceState.equals(aeDeviceState);
        
        return isEqual;
    }
    
    static boolean isEmpty(String value)
    {
        return (value != null ? value.trim().isEmpty() : true);
    }
}
