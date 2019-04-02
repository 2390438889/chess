package model;

import enums.ChessType;
import exception.PlayChessException;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc 象棋-将
 */
public class BossChess extends Chess {

    public BossChess(String name, ChessType chessType, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, chessType, bufferedImage, initPoints);
    }

    public BossChess(String name, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, bufferedImage, initPoints);
    }


    @Override
    public List<Point> canPoint(Point start) {
        List<Point> points = new ArrayList<>();
        points = new ArrayList<>();
        ChessPices[][] chessPices = chessBoard.getChessPices();
        int sign = 1;
        if (chessType == ChessType.RED){
            sign = -1;
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int x = start.getX() + i;
                int y = start.getY() + j;
                if (i != j && i != -j && inBossArea(x,y)){
                    points.add(new Point(x,y));

                }
            }
        }

        //如果两将直面
        for (int i = start.getX()+1; i < chessBoard.getChessPices().length; ) {
            if (chessPices[i][start.getY()] != ChessBoard.NONE && (chessPices[i][start.getY()].getChess() instanceof BossChess)){
                points.add(new Point(i,start.getY()));
                break;
            }
            i += sign;
        }

        return points;
    }

    /**
     * 判断帅棋的范围
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
