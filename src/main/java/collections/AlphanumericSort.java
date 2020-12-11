package collections;

import java.util.*;
import java.util.stream.Collectors;

public class AlphanumericSort {


    public static void main(String[] args) {
//        String[] alphaNumericStringArray = new String[]{"Android-4.4", "Android-5.0", "Android-5.1", "Android-6.0", "Android-7.0", "Android-7.1", "Android-8.0", "Android-8.1", "iOS-9.0", "iOS-9.1", "iOS-9.2", "iOS-9.3", "iOS-10.0", "iOS-10.1", "iOS-10.2", "iOS-10.3", "iOS-11.0", "iOS-11.1", "iOS-11.2", "iOS-11.3", "Windows Phone-8.1", "Windows Phone-10.0", "Blackberry-10"};


        System.out.println("GroupBy : ");
        System.out.println(Arrays.stream(getMobileSupportedPlatformsList()).collect(Collectors.groupingBy(MobileSupportedPlatform::getProductName)));

        Arrays.stream(getMobileSupportedPlatformsList()).collect(Collectors.groupingBy(MobileSupportedPlatform::getProductName));

//        System.out.println(Arrays.stream(getMobileSupportedPlatformsList()).filter(os -> os.getName().contains("Android")).collect(Collectors.toList()));
//        System.out.println(Arrays.stream(getMobileSupportedPlatformsList()).filter(os -> os.getName().contains("Android")).map(MobileSupportedPlatform::getName).collect(Collectors.toList()));

//        String[] androidPlatform = Arrays.stream(alphaNumericStringArray).filter(os -> os.contains("Android")).toArray(String[]::new);

       /* String[] mobileOS = {"Android", "iOS", "Windows Phone", "Blackberry"};

        List<String> osses = new ArrayList<>();

        for (String os1 : mobileOS) {
            osses = Arrays.stream(getMobileSupportedPlatformsList()).filter(os -> os.getName().contains(os1)).map(MobileSupportedPlatform::getName).collect(Collectors.toList());
//        Arrays.sort(androidPlatform, new Comparator<String>() {
            Collections.sort(osses, new Comparator<String>() {
                @Override
                public int compare(String firstString, String secondString) {

                    if (secondString == null || firstString == null) {
                        return 0;
                    }

                    int lengthFirstStr = firstString.length();
                    int lengthSecondStr = secondString.length();

                    int index1 = 0;
                    int index2 = 0;

                    while (index1 < lengthFirstStr && index2 < lengthSecondStr) {
                        char ch1 = firstString.charAt(index1);
                        char ch2 = secondString.charAt(index2);

                        char[] space1 = new char[lengthFirstStr];
                        char[] space2 = new char[lengthSecondStr];

                        int loc1 = 0;
                        int loc2 = 0;

                        do {
                            space1[loc1++] = ch1;
                            index1++;

                            if (index1 > lengthFirstStr) {
                                ch1 = firstString.charAt(index1);
                            } else {
                                break;
                            }
                        } while (Character.isDigit(ch1) == Character.isDigit(space1[0]));

                        do {
                            space2[loc2++] = ch2;
                            index2++;

                            if (index2 > lengthSecondStr) {
                                ch2 = secondString.charAt(index2);
                            } else {
                                break;
                            }
                        } while (Character.isDigit(ch2) == Character.isDigit(space2[0]));

                        String str1 = new String(space1);
                        String str2 = new String(space2);

                        int result;

                        if (Character.isDigit(space1[0]) && Character.isDigit(space2[0])) {
                            Integer firstNumberToCompare = new Integer(Integer
                                    .parseInt(str1.trim()));
                            Integer secondNumberToCompare = new Integer(Integer
                                    .parseInt(str2.trim()));
                            result = secondNumberToCompare.compareTo(firstNumberToCompare);
                        } else {
                            result = str2.compareTo(str1);
                        }

                        if (result != 0) {
                            return result;
                        }
                    }
                    return lengthSecondStr - lengthFirstStr;
                }
            });

            ArrayList<String> as = new ArrayList<>();
            osses.stream().forEach(as::add);
            as.stream().forEach(System.out::println);
        }*/

        /*for (int i = 0; i < osses.size(); i++) {
            System.out.println(osses[i]);
        }*/

    }

    /*@Override
    public int compare(Object firstObjToCompare, Object secondObjToCompare) {
        String firstString = firstObjToCompare.toString();
        String secondString = secondObjToCompare.toString();

        if (secondString == null || firstString == null) {
            return 0;
        }

        int lengthFirstStr = firstString.length();
        int lengthSecondStr = secondString.length();

        int index1 = 0;
        int index2 = 0;

        while (index1 < lengthFirstStr && index2 < lengthSecondStr) {
            char ch1 = firstString.charAt(index1);
            char ch2 = secondString.charAt(index2);

            char[] space1 = new char[lengthFirstStr];
            char[] space2 = new char[lengthSecondStr];

            int loc1 = 0;
            int loc2 = 0;

            do {
                space1[loc1++] = ch1;
                index1++;

                if (index1 > lengthFirstStr) {
                    ch1 = firstString.charAt(index1);
                } else {
                    break;
                }
            } while (Character.isDigit(ch1) == Character.isDigit(space1[0]));

            do {
                space2[loc2++] = ch2;
                index2++;

                if (index2 > lengthSecondStr) {
                    ch2 = secondString.charAt(index2);
                } else {
                    break;
                }
            } while (Character.isDigit(ch2) == Character.isDigit(space2[0]));

            String str1 = new String(space1);
            String str2 = new String(space2);

            int result;

            if (Character.isDigit(space1[0]) && Character.isDigit(space2[0])) {
                Integer firstNumberToCompare = new Integer(Integer
                        .parseInt(str1.trim()));
                Integer secondNumberToCompare = new Integer(Integer
                        .parseInt(str2.trim()));
                result = secondNumberToCompare.compareTo(firstNumberToCompare);
            } else {
                result = str2.compareTo(str1);
            }

            if (result != 0) {
                return result;
            }
        }
        return lengthSecondStr - lengthFirstStr;
    }*/

    public static MobileSupportedPlatform[] getMobileSupportedPlatformsList() {

        MobileSupportedPlatform supportedPlatform[] = new MobileSupportedPlatform[]{
                new MobileSupportedPlatform("Android-4.4", "PLATFORM_TYPE_ANDROID", "Google", "4.4", "0"),
                new MobileSupportedPlatform("Android-5.0", "PLATFORM_TYPE_ANDROID", "Google", "5.0", "0"),
                new MobileSupportedPlatform("Android-5.1", "PLATFORM_TYPE_ANDROID", "Google", "5.1", "0"),
                new MobileSupportedPlatform("Android-6.0", "PLATFORM_TYPE_ANDROID", "Google", "6.0", "0"),
                new MobileSupportedPlatform("Android-7.0", "PLATFORM_TYPE_ANDROID", "Google", "7.0", "0"),
                new MobileSupportedPlatform("Android-7.1", "PLATFORM_TYPE_ANDROID", "Google", "7.1", "0"),
                new MobileSupportedPlatform("Android-8.0", "PLATFORM_TYPE_ANDROID", "Google", "8.0", "0"),
                new MobileSupportedPlatform("Android-8.1", "PLATFORM_TYPE_ANDROID", "Google", "8.1", "0"),

                new MobileSupportedPlatform("iOS-9.0", "PLATFORM_TYPE_IOS", "Apple", "9.0", "0"),
                new MobileSupportedPlatform("iOS-9.1", "PLATFORM_TYPE_IOS", "Apple", "9.1", "0"),
                new MobileSupportedPlatform("iOS-9.2", "PLATFORM_TYPE_IOS", "Apple", "9.2", "0"),
                new MobileSupportedPlatform("iOS-9.3", "PLATFORM_TYPE_IOS", "Apple", "9.3", "0"),
                new MobileSupportedPlatform("iOS-10.0", "PLATFORM_TYPE_IOS", "Apple", "10.0", "0"),
                new MobileSupportedPlatform("iOS-10.1", "PLATFORM_TYPE_IOS", "Apple", "10.1", "0"),
                new MobileSupportedPlatform("iOS-10.2", "PLATFORM_TYPE_IOS", "Apple", "10.2", "0"),
                new MobileSupportedPlatform("iOS-10.3", "PLATFORM_TYPE_IOS", "Apple", "10.3", "0"),
                new MobileSupportedPlatform("iOS-11.0", "PLATFORM_TYPE_IOS", "Apple", "11.0", "0"),
                new MobileSupportedPlatform("iOS-11.1", "PLATFORM_TYPE_IOS", "Apple", "11.1", "0"),
                new MobileSupportedPlatform("iOS-11.2", "PLATFORM_TYPE_IOS", "Apple", "11.2", "0"),
                new MobileSupportedPlatform("iOS-11.3", "PLATFORM_TYPE_IOS", "Apple", "11.3", "0"),

                new MobileSupportedPlatform("Windows Phone-8.1", "PLATFORM_TYPE_WINDOWS_PHONE", "Microsoft", "8.1", "0"),
                new MobileSupportedPlatform("Windows Phone-10.0", "PLATFORM_TYPE_WINDOWS_PHONE", "Microsoft", "10.0", "0"),

                new MobileSupportedPlatform("Blackberry-10", "PLATFORM_TYPE_BLACKBERRY", "Blackberry", "10", "0")
        };
        return supportedPlatform;
    }
}

class MobileSupportedPlatform {

    private String name;
    String id;
    private String productName;
    private String platform;
    private String vendor;
    private String version;
    private String minorVersion;

    public MobileSupportedPlatform() {

    }

    public MobileSupportedPlatform(String name, String productName, String vendor, String version, String minorVersion) {
        this.name = name;
        this.productName = productName;
        this.vendor = vendor;
        this.version = version;
        this.minorVersion = minorVersion;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(String minorVersion) {
        this.minorVersion = minorVersion;
    }
}
