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
 * @desc 象棋-炮
 */
public class CannonChess extends Chess {

    public CannonChess(String name, ChessType chessType, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, chessType, bufferedImage, initPoints);
    }

    public CannonChess(String name, BufferedImage bufferedImage, List<Point> initPoints) {
        super(name, bufferedImage, initPoints);
    }

    @Override
    public List<Point> canPoint(Point start) {
        ChessPices[][] chesspices = chessBoard.getChessPices();
        List<Point> points = new ArrayList<>();
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        for (int i = 1; true; i++) {

            if (left <= 1){

                left = change(left,start.getX(),start.getY() - i,chesspices,points);

            }

            if (right <= 1){

                right = change(right,start.getX(),start.getY()+ i,chesspices,points);

            }

            if (top <= 1){

                top = change(top,start.getX()-i,start.getY(),chesspices,points);

            }

            if (bottom <=1){

                bottom = change(bottom,start.getX()+i,start.getY(),chesspices,points);

            }


           if (left>1 && right>1 && top>1 && bottom>1){
               break;
           }
        }

        return points;
    }

    private int change(int dire,int x,int y,ChessPices[][] chesspices,List<Point> points){



        //如果超出了棋盘,则不再往左边检查
        if(chessBoard.overArea(x,y)){
            dire = 2;
        }

        //中间棋子没有的位置都可以移动
        if (dire == 0){

            if (chesspices[x][y] == ChessBoard.NONE){
                points.add(new Point(x,y));
            }else{
                dire =1;
            }
        }else{
            //中间有一个棋子的时候,如果还有棋子也可以移动
            if (dire == 1){
                if (chesspices[x][y] != ChessBoard.NONE){
                    points.add(new Point(x,y));
                    dire =2;
                }
            }
        }
        return dire;
    }
}
