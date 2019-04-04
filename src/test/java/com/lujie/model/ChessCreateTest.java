package com.lujie.model;

import enums.ChessType;
import core.ChessPices;
import core.ChessPicesFactory;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc
 */
public class ChessCreateTest {

    @Test
    public void testChessCreate(){

        String[][] strings = new String[10][9];

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                strings[i][j] = " ";
            }
        }

        for (Map.Entry<ChessType, List<ChessPices>> chessTypeListEntry : ChessPicesFactory.createChessPices().
                entrySet()) {
            for (ChessPices chessPices : chessTypeListEntry.getValue()) {
                strings[chessPices.getPoint().getX()][chessPices.getPoint().getY()] = chessPices.getChess().getName();
            }
        }

        for (String[] string : strings) {
            for (String s : string) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }
}
