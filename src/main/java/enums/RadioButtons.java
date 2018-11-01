package enums;

public enum RadioButtons {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String title;

    RadioButtons(String title) {
        this.title = title;
    }

    public static String getCategory() {
        return "metal";
    }

    public String getTitle() {
        return title;
    }

}
