package org.scars.MobilePhone;

public class MobilePhone {
    private String brand;
    private String model;
    private String operatingSystem;
    private int price;
    private int memory;

    @Override
    public String toString() {
        return "手机" +
                "品牌='" + brand + '\'' +
                ", 型号='" + model + '\'' +
                ", 操作系统='" + operatingSystem + '\'' +
                ", 价格=" + price +
                ", 内存=" + memory;
    }

    public MobilePhone(String brand, String model, String operatingSystem, int price, int memory) {
        this.brand = brand;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.memory = memory;
    }

    public void autoDial(String contact) {
        System.out.println("使用自动拨号功能。");
        System.out.println(contact + "的号码。");
    }

    public void playGame(String game) {
        System.out.println("玩" + game + "游戏。");
    }

    public void playSong(String song) {
        System.out.println("播放歌曲：" + song);
    }

    public void downloadSong(String song) {
        System.out.println("正在下载歌曲：" + song);
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }
}
