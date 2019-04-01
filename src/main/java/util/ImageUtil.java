package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hearts
 * @date 2019/3/31
 * @desc 加载静态图片资源
 */
public class ImageUtil {

    private static Map<String,BufferedImage> imageIOMap;

    private static final String imagesPath = "src/main/resources/images";

    private ImageUtil(){}

    static {
        imageIOMap = new HashMap<String, BufferedImage>();
        File dir = new File(imagesPath);
        for (File file : dir.listFiles()) {
            String fileName = file.getName().trim();
            try {
                imageIOMap.put(fileName,ImageIO.read(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static BufferedImage getImage(String fileName){
        return imageIOMap.get(fileName);
    }
}
