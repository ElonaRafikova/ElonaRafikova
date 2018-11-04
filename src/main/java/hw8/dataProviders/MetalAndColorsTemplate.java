package hw8.dataProviders;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class MetalAndColorsTemplate {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;


    public List<String> asResult() {

        List<String> result = new ArrayList<>();
        result.add("Summary: " + Arrays.stream(summary).sum());
        result.add("Elements: " + String.join(", ", elements));
        result.add("Color: " + color);
        result.add("Metal: " + metals);
        result.add("Vegetables: " + String.join(", ", vegetables));
        return result;

    }
}
