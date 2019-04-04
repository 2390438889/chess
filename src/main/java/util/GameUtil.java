package util;

import java.io.*;

/**
 * @author Hearts
 * @date 2019/4/4
 * @desc
 */
public class GameUtil {

    /**
     * 向流中发送数据对象
     * @param outputStream
     * @param object
     * @throws IOException
     */
    public static void send(OutputStream outputStream,Object object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
    }

    /**
     * 从流中读取对象
     * @param inputStream
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object get(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return objectInputStream.readObject();
    }
}
