package enums;

public enum HeaderSections {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    public String title;

    HeaderSections(String title) {
        this.title = title;
    }
}
