package thread;

import server.GameData;
import server.RequestHandler;
import server.ServerOperator;
import util.GameUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Hearts
 * @date 2019/4/4
 * @desc
 */
public class ServerThread extends Thread{

    private final Socket socket;

    private final ServerOperator serverOperator;

    public ServerThread(Socket socket, ServerOperator serverOperator) {
        this.socket = socket;
        this.serverOperator = serverOperator;
        serverOperator.setSocket(socket);
    }

    @Override
    public void run() {
        while (true){
            try{
                if (interrupted()){
                    break;
                }
                RequestHandler requestHandler = (RequestHandler) GameUtil.get(socket.getInputStream());
                if (null != requestHandler){
                    requestHandler.handler(serverOperator);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
