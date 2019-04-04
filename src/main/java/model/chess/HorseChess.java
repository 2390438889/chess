package model.chess;

import base.chess.Chess;
import enums.ChessType;
import core.ChessBoard;
import core.ChessPices;
import core.Point;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc 象棋-马
 */
public class HorseChess extends Chess {

    public HorseChess(String name, ChessType chessType, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, chessType, bufferedImage, initPoints);
    }

    public HorseChess(String name, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, bufferedImage, initPoints);
    }


    @Override
    public List<Point> canPoint(Point start) {

        ChessPices[][] chessPices = chessBoard.getChessPices();

        List<Point> points = new ArrayList<>();

        int x=0,y=0;

        int[] sign = new int[]{1,2,-1,-2};

        for (int i = 0; i < sign.length; i++) {
            for (int j = 0; j < sign.length; j++) {
                if (sign[i]!=sign[j] && sign[i]!=-sign[j]){
                    x = start.getX();
                    y = start.getY();
                    if (Math.abs(sign[i]) ==1){
                        if (sign[j] > 0){
                            y += 1;
                        }else{
                            y += -1;
                        }
                    }else{
                        if (sign[i] > 0){
                            x += 1;
                        }else{
                            x += -1;
                        }
                    }
                    if (!chessBoard.overArea(start.getX() + sign[i],start.getY() +sign[j]) && chessPices[x][y] == ChessBoard.NONE){
                        points.add(new Point(start.getX() + sign[i],start.getY() +sign[j]));
                    }

                }
            }
        }

        return points;
    }
}
