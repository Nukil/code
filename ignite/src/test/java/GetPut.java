import bean.CacheFaceFeature;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class GetPut {
    public static void main(String[] args) {
        byte[] feature1 = new byte[1024];
        byte[] feature2 = new byte[1024];
        final float[] featureFloat1 = new float[256];
        final float[] featureFloat2 = new float[256];
        int days = 30;
        final BlockingQueue<String> queue = new LinkedBlockingDeque<String>();
        try {
            feature1 = getContent("feature1");
            feature2 = getContent("feature2");
        } catch (Exception e) {

        }
        for (int i = 0; i< 256; i++) {
            featureFloat1[i] = byte2float(feature1, i * 4);
            featureFloat2[i] = byte2float(feature2, i * 4);
        }

        InputStream is = ClassLoader.getSystemResourceAsStream("default-config.xml");
        Ignition.setClientMode(true);
        Ignite ignite = Ignition.start(is);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 0; i < days; i++) {
            queue.add(sdf.format(System.currentTimeMillis() - i * 86400000L));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(20);
    }


    static byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        fi.close();
        return buffer;
    }

    public static float byte2float(byte[] b, int index) {
        int l;
        l = b[index];
        l &= 0xff;
        l |= ((long) b[index + 1] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 2] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 3] << 24);
        return Float.intBitsToFloat(l);
    }
}
