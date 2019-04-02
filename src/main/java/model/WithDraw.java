package model;

/**
 * @author Hearts
 * @date 2019/4/2
 * @desc 撤回棋盘操作
 */
public abstract class WithDraw {

    protected ChessPices chessPice;

    protected Point oldPoint;

    protected Point newPoint;

    public WithDraw(ChessPices chessPice, Point oldPoint, Point newPoint) {
        this.chessPice = chessPice;
        this.oldPoint = oldPoint;
        this.newPoint = newPoint;
    }

    public abstract void excute();


}
