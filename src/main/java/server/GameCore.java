package server;

import java.net.Socket;

/**
 * @author Hearts
 * @date 2019/4/4
 * @desc
 */
public interface GameCore {

    /**
     * 创建房间
     * @param id
     */
    void createRoom(int id);

    /**
     * 加入房间
     * @param id
     */
    void joinRoom(int id);

    /**
     * 向客户端发送数据
     * @param data
     */
    void sendData(GameData data);




}
