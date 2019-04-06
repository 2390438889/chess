package server;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hearts
 * @date 2019/4/4
 * @desc
 */
public class GameRoom {

    private Integer roomID;

    private List<User> userList;

    public GameRoom(Integer roomID) {
        this.roomID = roomID;
        userList = new ArrayList<>();
    }

    public GameRoom(Integer roomID, List<User> userList) {
        this.roomID = roomID;
        this.userList = userList;
    }

    public void joinRoom(User user){
        userList.add(user);
    }

    public void exitRoom(User user){
        userList.remove(user);
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
