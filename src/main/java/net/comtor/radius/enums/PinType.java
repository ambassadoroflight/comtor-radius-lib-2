package net.comtor.radius.enums;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 30, 2019
 */
public enum PinType {

    LOCAL("Red Local"),
    FULL("Internet");

    private final String name;

    private PinType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PinType{"
                + ", name=" + name
                + '}';
    }

}
