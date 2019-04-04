package model.chess;

import base.chess.Chess;
import enums.ChessType;
import core.Point;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc 象棋-士
 */
public class ScholarChess extends Chess {

    public ScholarChess(String name, ChessType chessType, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, chessType, bufferedImage, initPoints);
    }

    public ScholarChess(String name, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, bufferedImage, initPoints);
    }

    @Override
    public List<Point> canPoint(Point start) {
        List<Point> points = new ArrayList<>();
        points = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int x = start.getX() + i;
                int y = start.getY() + j;
                if ((i == j || i == -j) && inBossArea(x,y)){
                    points.add(new Point(x,y));
                }
            }
        }
        return points;
    }

    /**
     * 判断仕棋的范围
     * @param x
     * @param y
     * @return
     */
    private boolean inBossArea(int x,int y){
        boolean yArea = y >=3 && y<6;
        int initX = 7;
        if (chessType == ChessType.BLACK){
            initX = 0;
        }

        return x >= initX && x<initX+3 && yArea;
    }
}
