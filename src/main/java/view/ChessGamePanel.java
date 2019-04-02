package view;

import enums.ChessType;
import model.*;
import model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Hearts
 * @date 2019/4/1
 * @desc
 */
public class ChessGamePanel extends JPanel {

    private ChessBoard chessBoard;

    private JButton jButton;

    public ChessGamePanel(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        //设置大小
        this.setSize(800, 900);

        //设置可见
        this.setVisible(true);

        //添加组件
        addComponent();

        //添加监听器
        addListener();

    }

    private void addComponent() {
        jButton = new JButton("悔棋");
        this.add(jButton);
    }

    public void init(){
        //初始化棋盘
        chessBoard.init();

    }

    private void addListener(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chessBoard.withDraw()){
                    JOptionPane.showMessageDialog(null,"已到初始状态,无法撤回");
                }
                repaint();
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point x = transposeView(e.getX(), e.getY());
                chessBoard.chessBoardPlay(x);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    /**
     * 图像坐标转化为数组坐标
     * @param x
     * @param y
     * @return
     */
    private Point transposeView(int x,int y){
        return new Point((y - 105 +42)/71,(x - 103 +39)/70);
    }

    /**
     * 将数组坐标转化为图像坐标
     * @param x
     * @param y
     * @return
     */
    private Point transposeArray(int x, int y){
        return new Point(105+71*y -42,103+70*x - 39);
    }

    private Point transposeArray(Point point){
        return transposeArray(point.getX(),point.getY());
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawString("当前"+chessBoard.getBoardOfChessPlayer()+"方下棋！",400,20);

        g.drawImage(chessBoard.getBufferedImage(), 45, 45, null);
        if (! chessBoard.NONE_POINT.equals(chessBoard.getNowPoint())){
            drawFlag(g, transposeArray(chessBoard.getNowPoint()));
        }

        ChessPices[][] chessPices = chessBoard.getChessPices();
        for (int i = 0; i <chessPices.length; i++) {
            for (int j = 0; j < chessPices[i].length; j++) {
                if (chessPices[i][j] != null) {
                    Point point = transposeArray(i, j);
                    g.drawImage(chessPices[i][j].getChess().getBufferedImage(), point.getX(), point.getY(), null);
                }
            }
        }

        if (chessBoard.getSuccessChessType() != ChessBoard.SUCCESS_NONE){
            JOptionPane.showMessageDialog(null, chessBoard.getSuccessChessType() + "方胜利了");
            int result = JOptionPane.showConfirmDialog(null,"开始新的游戏");
            if (result == 0){
                init();
            }else{
                System.exit(0);
            }
        }
    }

    private void drawFlag(Graphics g,Point point){
        g.setColor(Color.red);
        g.drawRect(point.getX()+5, point.getY(), 75, 75);
    }


}
