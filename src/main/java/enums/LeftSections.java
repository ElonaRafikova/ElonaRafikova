package enums;

public enum LeftSections {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors"),
    ELEMENTS_PACKS("Elements packs");

    public String title;

    LeftSections(String title) {
        this.title = title;
    }

}
