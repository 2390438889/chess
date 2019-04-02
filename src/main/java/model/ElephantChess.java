package model;

import enums.ChessType;
import exception.PlayChessException;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc 象棋-相
 */
public class ElephantChess extends Chess {


    public ElephantChess(String name, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, bufferedImage, initPoints);
    }

    public ElephantChess(String name, ChessType chessType, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, chessType, bufferedImage, initPoints);
    }

    @Override
    public List<Point> canPoint(Point start) {

        ChessPices[][] chesspices = chessBoard.getChessPices();

        List<Point> points = new ArrayList<>();

        int[] sign = new int[]{2,-2};

        int x = 0;

        int y = 0;

        for (int i = 0; i < sign.length; i++) {
            for (int j = 0; j < sign.length; j++) {
                x = start.getX() + sign[i];
                y = start.getY() + sign[j];
                //判断中心没有棋子,并且坐标在棋盘中,没有过河
                if (!chessBoard.overArea(x,y) && chesspices[x - sign[i]/2][y-sign[j]/2] == ChessBoard.NONE && !checkRiverOver(x)){
                    points.add(new Point(x,y));
                }
            }
        }


        return points;
    }
}
