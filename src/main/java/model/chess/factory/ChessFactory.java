package model.chess.factory;

import base.chess.Chess;

import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc
 */
public interface ChessFactory {
    List<Chess> createChesses();
}
