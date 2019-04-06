package server;

import base.server.Server;
import thread.ServerThread;

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

    private List<User> users;

    private ServerOperator serverOperator;

    private ArrayList<ServerThread> serverThreads;



    public GameServer() throws IOException {
        this("server+"+Server.count++);
    }

    public GameServer(String name) throws IOException {
        this(name,new ServerSocket(8080));
    }

    public GameServer(String name, ServerSocket serverSocket) {
        super(name, serverSocket);
        roomMap = new HashMap<>();
        users = new ArrayList<>();
        serverOperator = new ServerOperator(this);
        serverThreads = new ArrayList<>();
    }



    @Override
    public void socketHandler(Socket socket) {
        try {
            serverThreads.add(new ServerThread(socket,serverOperator.clone()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeHandler() {
        //中断所有线程
        for (ServerThread serverThread : serverThreads) {
            serverThread.interrupt();
        }
    }

    public Map<Integer, GameRoom> getRoomMap() {
        return roomMap;
    }

    public List<User> getUsers() {
        return users;
    }
}
