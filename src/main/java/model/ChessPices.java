package model;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc
 */
public class ChessPices {

    /**
     * 是否存活
     */
    private boolean live;

    /**
     * 所持有的棋子
     */
    private Chess chess;

    /**
     * 棋子的初始坐标
     */
    private Point point;

    public ChessPices(Chess chess, Point point) {
        this(true,chess,point);
    }

    public ChessPices(boolean live, Chess chess, Point point) {
        this.live = live;
        this.chess = chess;
        this.point = point;
    }

    public void init(){
        live = true;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Chess getChess() {
        return chess;
    }

    public void setChess(Chess chess) {
        this.chess = chess;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
