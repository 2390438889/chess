package base.chess;

import enums.ChessType;
import exception.PlayChessException;
import core.ChessBoard;
import core.Point;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc
 */
public abstract class Chess {

    protected String name;

    protected ChessType chessType;

    protected BufferedImage bufferedImage;

    protected List<Point> initPoints;

    protected ChessBoard chessBoard;

    public Chess(String name, ChessType chessType, BufferedImage bufferedImage, List<Point> initPoints) {
        this.name = name;
        this.chessType = chessType;
        this.bufferedImage = bufferedImage;
        this.initPoints = initPoints;
    }

    public Chess(String name, BufferedImage bufferedImage, List<Point> initPoints) {
        this.name = name;
        this.bufferedImage = bufferedImage;
        this.initPoints = initPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChessType(ChessType chessType) {
        this.chessType = chessType;
    }

    public ChessType getChessType() {
        return chessType;
    }

    public List<Point> getInitPoints() {
        return initPoints;
    }

    public void setInitPoints(List<Point> initPoints) {
        this.initPoints = initPoints;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    /**
     * 走棋 将棋子放到某个坐标是否符合规则
     * @param start
     * @param end
     * @return
     * @throws PlayChessException
     */
    public  boolean playChess(Point start,Point end){
        return end.inList(canPoint(start));
    }

    /**
     * 获取棋子下一步所有可能的地点
     * @param start
     * @return
     */
    public abstract List<Point> canPoint(Point start);

    /**
     * 判断是否过河
     * @return
     */
    protected boolean checkRiverOver(int x){
        if (chessType == ChessType.BLACK){
            return x > 4;
        }else{
            return x < 5;
        }
    }



}
