package server;

import util.GameUtil;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * @author Hearts
 * @date 2019/4/4
 * @desc
 */
public class ServerOperator implements Cloneable,GameCore{

    private final GameServer gameServer;

    private int roomId;

    private User user;

    private Socket socket;


    public ServerOperator(GameServer gameServer) {
        this.gameServer = gameServer;
    }

    /**
     * 登录
     * @param username
     * @param password
     */
    public void login(String username,String password){
        user = new User(socket,username,password);
    }

    /**
     * 创建指定id的房间
     * @param id
     */
    @Override
    public void createRoom(int id) {
        roomId = id;
        GameRoom room = new GameRoom(id);
        room.joinRoom(user);
        gameServer.getRoomMap().put(id,room);

    }

    /**
     * 加入指定id的房间
     * @param id
     */
    @Override
    public void joinRoom(int id) {
        gameServer.getRoomMap().get(id).joinRoom(user);
    }

    /**
     * 相房间内其他用户发送实时数据
     * @param data
     */
    @Override
    public void sendData(GameData data) {
        GameRoom gameRoom = gameServer.getRoomMap().get(roomId);
        for (User user1 : gameRoom.getUserList()) {
            if (!user.equals(user1)){
                try {
                    GameUtil.send(user1.getSocket().getOutputStream(),data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Override
    protected ServerOperator clone() throws CloneNotSupportedException {
        ServerOperator serverOperator = (ServerOperator) super.clone();
        return serverOperator;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
