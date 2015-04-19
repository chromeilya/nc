package by.netcracker.web.exceptions;

/**
 * Created by ilya on 4/8/15.
 */
public enum WebErrorCode {

    NC_WEB_000("Cannot get all students"),
    NC_WEB_001("Cannot delete student"),
    NC_WEB_002("Cannot get create student page"),
    NC_WEB_003("Cannot create student"),
    NC_WEB_004("Cannot get edit student page"),
    NC_WEB_005("Cannot update content on student page"),
    NC_WEB_006("Cannot find student"),
    NC_WEB_007("The page cannot be displayed");


    private final String value;

    private WebErrorCode(String s) {
        value = s;
    }

    public boolean equalsValue(String value2) {
        return (value2 != null) && value.equals(value2);
    }

    public String toString() {
        return value;
    }
}