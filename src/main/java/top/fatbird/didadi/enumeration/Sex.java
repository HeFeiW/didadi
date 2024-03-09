package top.fatbird.didadi.enumeration;

public enum Sex {
    MALE(1), FEMALE(2), SECRET(3);
    private Integer value;
    private Sex(Integer value){
        this.value=value;
    }
    public Integer getValue(){return value;}
    public static Sex getSex(Integer index){
        for (Sex sex : Sex.values()) {
            if (sex.getValue() == index) {
                return sex;
            }
        }
        return null;
    }
}