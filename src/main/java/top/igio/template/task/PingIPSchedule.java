package top.igio.template.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;


/**
 * @author ljl
 * @version V1.0
 * @data 2023/7/8 16:37
 * @description
 */
@Component
public class PingIPSchedule {
    private static final Logger logger = LoggerFactory.getLogger(PingIPSchedule.class);

    private static final String IP = "198.18.1.12";

    @Scheduled(cron = "0/6 * * * * ?")
    //@Scheduled(fixedRate = 1000)
    public void pingIP() {
        logger.info("开始Ping IP: {}", IP);
        try {
            InetAddress address = InetAddress.getByName(IP);
            boolean reachable = address.isReachable(1000);
            if (reachable) {
                logger.info("Ping IP: {} 成功", IP);
                playAlarmSound();
            } else {
                logger.error("Ping IP: {} 失败", IP);
            }
        } catch (IOException  e) {
            logger.error("Ping IP: {} 失败", IP);
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void playAlarmSound() throws AWTException {
        logger.info("开始播放报警声音");
        try {
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
        //        PingIPSchedule.class.getResourceAsStream("E:\\music\\QQMusic\\music\\Aphex Twin - Avril 14th.mp3")); // 替换为你的报警声音文件路径
        //AudioFormat format = audioInputStream.getFormat();
        //DataLine.Info info = new DataLine.Info(Clip.class, format);
        //Clip line = (Clip) AudioSystem.getLine(info);
        //line.open(audioInputStream);
        //line.loop(Clip.LOOP_CONTINUOUSLY); // 循环播放报警声音
        //line.start();
        logger.info("播放报警声音结束");
    }
}
