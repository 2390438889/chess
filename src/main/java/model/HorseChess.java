package model;

import enums.ChessType;
import exception.PlayChessException;

import javax.swing.*;
import java.awt.image.BufferedImage;
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
    public boolean playChess(Point start, Point end){
        return true;
    }
}