package server;

import base.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @author Hearts
 * @date 2019/4/3
 * @desc
 */
public class GameServer extends Server {

    /**
     * 房间
     */
    private Map<Integer,GameRoom> roomMap;

    private User user;



    public GameServer() throws IOException {
    }

    public GameServer(String name) throws IOException {
        super(name);
    }

    public GameServer(String name, ServerSocket serverSocket) {
        super(name, serverSocket);
    }

    public void createRoom(int roomID){

    }

    @Override
    public void socketHandler(Socket socket) {

    }

    @Override
    public void closeHandler() {

    }
}
