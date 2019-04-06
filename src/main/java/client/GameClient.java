package client;

import core.ChessBoard;
import server.GameData;
import util.GameUtil;
import view.ChessGamePanel;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Hearts
 * @date 2019/4/1
 * @desc
 */
public class GameClient {

    private Socket socket;

    private ChessGamePanel chessGamePanel;

    public GameClient() throws IOException {
        this.socket = new Socket("127.0.0.1",8080);
        this.chessGamePanel = new ChessGamePanel(new ChessBoard(),socket);
    }

    public GameClient(Socket socket, ChessGamePanel chessGamePanel) {
        this.socket = socket;
        this.chessGamePanel = chessGamePanel;
    }

    public void run(){

        while (true){
            try {
                GameData gameData = (GameData) GameUtil.get(socket.getInputStream());
                chessGamePanel.exec(gameData);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void view(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(800,900);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(chessGamePanel);
        jFrame.setVisible(true);
    }
}
