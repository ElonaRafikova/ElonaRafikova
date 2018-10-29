package enums;

public enum TextsUnderIcons {

    GOOD_PRACTICES("To include good practices\nand ideas from successful\nEPAM project"),
    FLEXIBLE("To be flexible and\ncustomizable"),
    MULTIPLATFORM("To be multiplatform"),
    GOOD_BASE("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    public String text;

    TextsUnderIcons(String text) {
        this.text = text;
    }

}




