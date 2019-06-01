package com.test.image;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
 * @Title: ThumbnailatorUtil
 * @Package: com.test.image
 * @Description: google Thumbnailator 测试
 * @Author: monkjavaer
 * @Data: 2019/2/22 14:07
 * @Version: V1.0
 */
public class ThumbnailatorUtil {

    public static void main(String[] args) {
        try {
            long start = System.nanoTime();
            compressPic();
            long end = System.nanoTime();
            System.out.println("压缩时间："+(end-start)*0.000000001+"s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * scale: 按比例
     * outputQuality：输出的图片质量，范围：0.0~1.0，1为最高质量。注意使用该方法时输出的图片格式必须为jpg
     * @throws IOException
     */
    public static void compressPic() throws IOException {
//        Thumbnails.of("E:\\3.png")
        Thumbnails.of("E:\\154.jpg")
                .scale(1f)
                .outputQuality(0.25f)
                .toFile("E:\\1.jpg");
    }

}
