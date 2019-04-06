package base.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Hearts
 * @date 2019/4/3
 * @desc 服务器基本类
 */
public abstract class Server {

    protected static int count = 0;

    /**
     * 服务器名称
     */
    protected String name;

    /**
     * 服务端
     */
    protected ServerSocket serverSocket;

    /**
     * 所有连接到服务端的客户端
     */
    protected Set<Socket> sockets;

    /**
     * 服务器开始运行时间
     */
    protected Long startTime;

    public Server() throws IOException {
        this("server_"+count++);
    }

    public Server(String name) throws IOException {
        this(name,new ServerSocket(8080));

    }

    public Server(String name, ServerSocket serverSocket) {
        this.name = name;
        this.serverSocket = serverSocket;
        this.sockets = new HashSet<Socket>();
        this.startTime = 0L;
    }

    public void start(){
        //记录服务器开始运行的时间戳
        this.startTime = System.currentTimeMillis();
        System.out.println(name +"服务器启动>>>");
        try {
            while (true){
                Socket socket = serverSocket.accept();
                sockets.add(socket);
                socketHandler(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown(){
        Iterator<Socket> iterator = sockets.iterator();

        closeHandler();

        try{
            //关闭所有客户端连接
            while (iterator.hasNext()){
                Socket socket = iterator.next();
                sockets.remove(socket);
                socket.close();
            }

            //关闭服务端连接
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(name +"服务器关机>>>");


    }

    public abstract void socketHandler(Socket socket);

    public abstract void closeHandler();

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Set<Socket> getSockets() {
        return sockets;
    }

    public void setSockets(Set<Socket> sockets) {
        this.sockets = sockets;
    }


}
