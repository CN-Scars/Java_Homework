package org.scars.Sound;

public class Walkman implements Soundable {
    @Override
    public void playSound() {
        System.out.println("正在播放歌曲：七里香");
    }

    @Override
    public void decreaseVolume() {
        System.out.println("音量减小");
    }

    @Override
    public void increaseVolume() {
        System.out.println("音量增加");
    }

    @Override
    public void stopSound() {
        System.out.println("随身听停止发声");
    }
}
