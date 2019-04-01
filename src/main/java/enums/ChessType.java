package enums;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc
 */
public enum  ChessType {
    RED("红"),BLACK("黑");

    private String name;

    ChessType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
