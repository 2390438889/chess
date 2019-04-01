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
public class BlackChessFactory implements ChessFactory {

    public List<Chess> createChesses() {
        List<Chess> chesses = new ArrayList<Chess>();

        //车
        chesses.add(new VehicleChess("车",ImageUtil.getImage("chess4.png"), Arrays.asList(new Point(0, 0), new Point(0, 8))));

        //马
        chesses.add(new HorseChess("马", ImageUtil.getImage("chess3.png"), Arrays.asList(new Point(0, 1), new Point(0, 7))));

        //象
        chesses.add(new ElephantChess("象",ImageUtil.getImage("chess2.png"),Arrays.asList(new Point(0,2),new Point(0,6))));

        //士
        chesses.add(new ScholarChess("士",ImageUtil.getImage("chess1.png"),Arrays.asList(new Point(0,3),new Point(0,5))));

        //将
        chesses.add(new BossChess("将",ImageUtil.getImage("chess0.png"),Arrays.asList(new Point(0,4))));

        //炮
        chesses.add(new CannonChess("炮",ImageUtil.getImage("chess5.png"),Arrays.asList(new Point(2,1),new Point(2,7))));

        //卒
        chesses.add(new ArmsChess("卒",ImageUtil.getImage("chess6.png"),Arrays.asList(new Point(3,0),new Point(3,2),new Point(3,4),new Point(3,6),new Point(3,8))));

        for (Chess chess : chesses) {
            chess.setChessType(ChessType.BLACK);
        }
        return chesses;
    }
}
