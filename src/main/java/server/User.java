package server;

import java.io.Serializable;
import java.net.Socket;

/**
 * @author Hearts
 * @date 2019/4/4
 * @desc
 */
public class User implements Serializable,Cloneable{

    /**
     * 当前登录的socket
     */
    private Socket socket;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    public User(Socket socket, String name, String password) {
        this.socket = socket;
        this.name = name;
        this.password = password;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
