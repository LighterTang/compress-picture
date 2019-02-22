package com.test.image;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Title: ImageIOUtil
 * @Package: com.test.image
 * @Description: ImageIO test
 * @Author: tangquanbin
 * @Data: 2019/2/22 16:37
 * @Version: V1.0
 */
public class ImageIOUtil {

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        compressPic("E:\\154.jpg", "E:\\1.jpg", 0.25f);
        long end = System.nanoTime();
        System.out.println("压缩时间：" + (end - start) * 0.000000001 + "s");
    }

    public static void  compressPic(String srcFilePath, String descFilePath, Float quality) throws IOException {
        File input = new File(srcFilePath);
        BufferedImage image = ImageIO.read(input);

        // 指定写图片的方式为 jpg
        ImageWriter writer =  ImageIO.getImageWritersByFormatName("jpg").next();

        // 先指定Output，才能调用writer.write方法
        File output = new File(descFilePath);
        OutputStream out = new FileOutputStream(output);
        ImageOutputStream ios = ImageIO.createImageOutputStream(out);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()){
            // 指定压缩方式为MODE_EXPLICIT
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            // 压缩程度，参数qality是取值0~1范围内
            param.setCompressionQuality(quality);
        }
        // 调用write方法，向输入流写图片
        writer.write(null, new IIOImage(image, null, null), param);

        out.close();
        ios.close();
        writer.dispose();
    }


}
