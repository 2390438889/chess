package model;

import enums.ChessType;
import util.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/4/1
 * @desc
 */
public class ChessBoard {

    public static final Point NONE_POINT=new Point(-1,-1);

    public static final ChessPices NONE = null;

    public static final ChessType SUCCESS_NONE = null;

    /**
     * 棋盘
     */
    private ChessPices[][] chessPices;

    /**
     * 棋盘图片
     */
    private BufferedImage bufferedImage;

    /**
     * 所有的棋子
     */
    private List<ChessPices> chessPicesList;

    /**
     * 当前下棋一方
     */
    private ChessType boardOfChessPlayer;

    /**
     * 当前所选择的位置
     */
    private  Point nowPoint;

    /**
     * 胜利的一方
     */
    private ChessType successChessType;

    /**
     * 判断是否可以下棋
     */
    private boolean canPlay;

    private Point next;

    public ChessBoard() {
        this(ImageUtil.getImage("chessBoard.png"));
    }

    public ChessBoard(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        chessPices = new ChessPices[10][9];
        chessPicesList = ChessPicesFactory.createChessPicesList();
        nowPoint = new Point(NONE_POINT);
        next = new Point(NONE_POINT);
        init();
    }

    /**
     * 清空棋盘
     */
    private void clearBoard(){
        for (int i = 0; i < chessPices.length; i++) {
            for (int j = 0; j < chessPices[0].length; j++) {
                chessPices[i][j] = NONE;
            }
        }
    }

    /**
     * 初始化棋盘
     */
    public void init(){
        //清空棋盘
        clearBoard();

        //重新设置棋子
        for (ChessPices pices : chessPicesList) {
            //重新初始化棋子
            pices.init();
            chessPices[pices.getPoint().getX()][pices.getPoint().getY()] = pices;
        }

        //设置执棋手
        boardOfChessPlayer = ChessType.RED;

        //设置当前选择的位置
        nowPoint.setPoint(NONE_POINT);

        //默认不可以下棋
        canPlay = false;

        //默认非成功
        successChessType = SUCCESS_NONE;



    }

    /**
     * 设置当前选择的位置,并判段当前坐标所在的棋子是否可以动用
     * @param x
     * @param y
     * @return
     */
    private void setNowPoint(int x,int y){
        canPlay = false;
        if (x >= 0 && y >= 0 && x < chessPices.length && y < chessPices[0].length){
            if (chessPices[x][y] != null && chessPices[x][y].getChess().getChessType() == boardOfChessPlayer){
                canPlay = true;
            }
            nowPoint.setPoint(x,y);
        }

    }

    /**
     * 下棋
     * @param x
     * @param y
     */
    public void chessBoardPlay(int x,int y){

        if (canPlay){
            chessPlay(x, y);
        }

        setNowPoint(x, y);

    }

    public void chessBoardPlay(Point point){
        chessBoardPlay(point.getX(), point.getY());
    }

    private void chessPlay(int x,int y){

        next.setPoint(x,y);

        //如果能够移动
        if (canPlay){

            ChessPices chess = chessPices[nowPoint.getX()][nowPoint.getY()];

            //判断该位置是否为本方棋子,选择该棋子为当前棋子
            if (chessPices[x][y] == NONE || chessPices[x][y].getChess().chessType != boardOfChessPlayer){

                //如果符合走棋规则
                if (chess.getChess().playChess(nowPoint,next)){

                    //如果有敌方棋子则敌方棋子死亡
                    if (chessPices[x][y] != null){

                        chessPices[x][y].setLive(false);
                        //判断该棋子是否为帅
                        checkChessBoardSuccess(chessPices[x][y]);
                    }

                    //将棋子移动到该坐标
                    chessPices[x][y] = chess;

                    //将原来坐标上的对象去除
                    chessPices[nowPoint.getX()][nowPoint.getY()] = NONE;

                    //转换下棋方
                    changeBoardOfChessPlayer();
                }
            }
        }
    }

    /**
     * 胜利的条件
     * @param chessPices
     */
    private void checkChessBoardSuccess(ChessPices chessPices){

        if (chessPices.getChess() instanceof BossChess){

            successChessType = boardOfChessPlayer;
        }
    }

    /**
     * 改变当前下棋的一方
     */
    private void changeBoardOfChessPlayer(){
        if (boardOfChessPlayer == ChessType.RED){
            boardOfChessPlayer = ChessType.BLACK;
        }else {
            boardOfChessPlayer = ChessType.RED;
        }
    }

    public ChessPices[][] getChessPices() {
        return chessPices;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public ChessType getBoardOfChessPlayer() {
        return boardOfChessPlayer;
    }

    public Point getNowPoint() {
        return nowPoint;
    }

    public ChessType getSuccessChessType() {
        return successChessType;
    }
}
