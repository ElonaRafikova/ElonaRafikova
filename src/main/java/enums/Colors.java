package enums;

public enum Colors {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String title;

    Colors(String title) {
        this.title = title;
    }
    public static String getCategory()
    {
       return "Colors";
    }

    public String getTitle() {
        return title;
    }

}
