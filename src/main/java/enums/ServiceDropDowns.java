package enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceDropDowns {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFOMANCE("Performance");

    private String serviceItemTitle;

    public String getTitle() {
        return serviceItemTitle;
    }

    ServiceDropDowns(String serviceItemTitle) {
        this.serviceItemTitle = serviceItemTitle.toUpperCase();
    }
    public static List<String> getServiceDropDownsTitles() {
        List<String> serviceDropDownsTitles = new ArrayList<String>();
        for (ServiceDropDowns item : ServiceDropDowns.values()) {
            serviceDropDownsTitles.add(item.getTitle());
        }
        return serviceDropDownsTitles;
    }

    public static List<String> getServiceDropDownsTitlesUpper() {
        List<String> serviceDropDownsTitles = new ArrayList<String>();
        for (ServiceDropDowns item : ServiceDropDowns.values()) {
            serviceDropDownsTitles.add(item.getTitle().toUpperCase());
        }
        return serviceDropDownsTitles;
    }

}
