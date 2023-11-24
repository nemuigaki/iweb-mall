package com.iweb.mall.portal;

import com.iweb.mall.portal.util.QRCodeUtil;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @Description
 * @Author sadalsuud
 * @Blog www.sadalsuud.cn
 * @Date 24/11/2023
 * @Package com.iweb.mall.portal
 */
public class QRCodeUtilTest {
    @Test
    public void test() throws IOException {
        QRCodeUtil.getQRCode("https://www.baidu.com", Files.newOutputStream(new File("./qcr.png").toPath()));
        System.out.println(QRCodeUtil.getBase64QRCode("https://www.baidu.com"));
    }
}
