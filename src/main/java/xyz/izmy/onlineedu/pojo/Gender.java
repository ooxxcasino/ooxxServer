package xyz.izmy.onlineedu.pojo;

/**
 * 人类性别枚举
 * @author iYmz
 */
public enum Gender {
    /**
     * 性别：男，女
     */
    male("男"),
    female("女");
    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }}
