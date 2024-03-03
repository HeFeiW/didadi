package top.fatbird.didadi.enumeration;

public enum SexEnum {
    MALE(1), FEMALE(2), SECRET(3);

    private int value;

    SexEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}