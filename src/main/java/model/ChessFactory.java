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
public interface ChessFactory {
    List<Chess> createChesses();
}
