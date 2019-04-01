package model;

import enums.ChessType;
import util.ImageUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc
 */
public class RedChessFactory implements ChessFactory {
    public List<Chess> createChesses() {
        List<Chess> chesses = new ArrayList<Chess>();

        //车
        chesses.add(new VehicleChess("车",ImageUtil.getImage("chess11.png"),Arrays.asList(new Point(9, 0), new Point(9, 8))));

        //马
        chesses.add(new HorseChess("马", ImageUtil.getImage("chess10.png"), Arrays.asList(new Point(9, 1), new Point(9, 7))));

        //相
        chesses.add(new ElephantChess("相",ImageUtil.getImage("chess9.png"),Arrays.asList(new Point(9,2),new Point(9,6))));

        //仕
        chesses.add(new ScholarChess("仕",ImageUtil.getImage("chess8.png"),Arrays.asList(new Point(9,3),new Point(9,5))));

        //帅
        chesses.add(new BossChess("帅",ImageUtil.getImage("chess7.png"),Arrays.asList(new Point(9,4))));

        //炮
        chesses.add(new CannonChess("炮",ImageUtil.getImage("chess12.png"),Arrays.asList(new Point(7,1),new Point(7,7))));

        //兵
        chesses.add(new ArmsChess("兵",ImageUtil.getImage("chess13.png"),Arrays.asList(new Point(6, 0), new Point(6, 2), new Point(6, 4), new Point(6, 6), new Point(6, 8))));

        for (Chess chess : chesses) {
            chess.setChessType(ChessType.RED);
        }
        return chesses;
    }
}
