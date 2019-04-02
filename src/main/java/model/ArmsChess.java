package model;

import enums.ChessType;
import exception.PlayChessException;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc 象棋-兵
 */
public class ArmsChess extends Chess {

    public ArmsChess(String name, ChessType chessType, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, chessType, bufferedImage, initPoints);
    }

    public ArmsChess(String name, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, bufferedImage, initPoints);
    }


    public List<Point> canPoint(Point start){
        List<Point> points;
        int step = -1;
        if (chessType == ChessType.BLACK){
            step = 1;
        }
        //如果已经过河
        if (checkRiverOver(start.getX())){
            points = Arrays.asList(new Point(start.getX()+step,start.getY()),
                    new Point(start.getX(),start.getY()+1),
                    new Point(start.getX(),start.getY()-1));
        }else{
            points = Arrays.asList(new Point(start.getX()+step,start.getY()));
        }

        return points;
    }




}
