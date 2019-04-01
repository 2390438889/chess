package model;

import enums.ChessType;
import exception.PlayChessException;

import javax.swing.*;
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

    /**
     * 走棋 将棋子放到某个坐标是否符合规则
     * @param start
     * @param end
     * @return
     * @throws PlayChessException
     */
    public abstract boolean playChess(Point start,Point end);

}
