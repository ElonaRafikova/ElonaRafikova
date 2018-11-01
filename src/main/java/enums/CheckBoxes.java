package enums;

public enum CheckBoxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String title;

    CheckBoxes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
