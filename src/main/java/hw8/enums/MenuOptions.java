package hw8.enums;

public enum MenuOptions {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    private String title;

    MenuOptions(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
