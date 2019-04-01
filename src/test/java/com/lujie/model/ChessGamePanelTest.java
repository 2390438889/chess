package com.lujie.model;

import model.ChessBoard;
import org.junit.Test;
import view.ChessGamePanel;

import javax.swing.*;

/**
 * @author Hearts
 * @date 2019/4/1
 * @desc
 */
public class ChessGamePanelTest {

    @Test
    public void view(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(200,200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(new ChessGamePanel(new ChessBoard()));
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(800,900);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(new ChessGamePanel(new ChessBoard()));
        jFrame.setVisible(true);
    }
}
