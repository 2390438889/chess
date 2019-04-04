package core;

import base.chess.Chess;
import enums.ChessType;
import model.chess.factory.BlackChessFactory;
import model.chess.factory.ChessFactory;
import model.chess.factory.RedChessFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc
 */
public class ChessPicesFactory {

    private static ChessFactory redChessFactory = new RedChessFactory();

    private static ChessFactory blackChessFactory = new BlackChessFactory();

    /**
     * 按黑方和红方分组生成棋子
     * @return
     */
    public static Map<ChessType,List<ChessPices>> createChessPices(){

        Map<ChessType,List<ChessPices>> chessTypeChessPicesMap = new HashMap<ChessType, List<ChessPices>>();

        chessTypeChessPicesMap.put(ChessType.RED,createChessPices(redChessFactory));

        chessTypeChessPicesMap.put(ChessType.BLACK,createChessPices(blackChessFactory));

        return chessTypeChessPicesMap;

    }

    /**
     * 生成全部棋子
     * @return
     */
    public static List<ChessPices> createChessPicesList(){
        List<ChessPices> chessPices = createChessPices(redChessFactory);
        chessPices.addAll(createChessPices(blackChessFactory));
        return chessPices;
    }

    private static List<ChessPices> createChessPices(ChessFactory chessFactory){
        List<ChessPices> chessPices = new ArrayList<ChessPices>();

        for (Chess chess : chessFactory.createChesses()) {

            for (Point point : chess.getInitPoints()) {

                chessPices.add(new ChessPices(chess,point));
            }
        }
        return chessPices;
    }
}
