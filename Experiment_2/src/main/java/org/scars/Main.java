import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Map<String, String> users = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        // 创建预定义的root用户
        users.put("root", "password");

        boolean quit = false;
        while (!quit) {
            displayMainMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // 消耗掉换行符

            switch (choice) {
                case 1:
                    String username = login();
                    if (username != null) {
                        loggedInMenu(username);
                    } else {
                        System.out.println("登录失败，请重新尝试。");
                    }
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
        sc.close();
    }

    public static void displayMainMenu() {
        System.out.println("主菜单：");
        System.out.println("1. 登录");
        System.out.println("2. 注册");
        System.out.println("3. 退出");
        System.out.print("请输入您的选择：");
    }

    public static void loggedInMenu(String username) {
        boolean loggedOut = false;
        while (!loggedOut) {
            System.out.println("登录成功, 请选择您要进行的操作：");
            System.out.println("1. 剪刀石头布游戏");
            System.out.println("2. 幸运观众抽取");
            System.out.println("3. 修改密码");
            System.out.println("4. 注销");
            if ("root".equals(username)) {
                System.out.println("5. 查看所有用户名和密码");
            }
            int choice = sc.nextInt();
            sc.nextLine(); // 消耗掉换行符
            switch (choice) {
                case 1:
                    playGame();
                    break;
                case 2:
                    luckyAudience();
                    break;
                case 3:
                    changePassword(username);
                    break;
                case 4:
                    loggedOut = true;
                    break;
                case 5:
                    if ("root".equals(username)) {
                        displayUsers();
                    } else {
                        System.out.println("无权限查看！");
                    }
                    break;
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }

    public static String login() {
        System.out.print("请输入用户名：");
        String username = sc.nextLine();
        System.out.print("请输入密码：");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("登录成功！");
            return username;
        } else {
            System.out.println("用户名或密码错误。");
            return null;
        }
    }

    public static void register() {
        System.out.print("请输入新的用户名：");
        String username = sc.nextLine();
        if (users.containsKey(username)) {
            System.out.println("用户名已存在，请选择其他用户名。");
            return;
        }
        System.out.print("请输入新的密码：");
        String password = sc.nextLine();
        users.put(username, password);
        System.out.println("注册成功！");
    }

    public static void changePassword(String username) {
        System.out.print("请输入新的密码：");
        String newPassword = sc.nextLine();
        users.put(username, newPassword);
        System.out.println("密码修改成功！");
    }

    public static void displayUsers() {
        System.out.println("所有用户名和密码：");
        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println("用户名: " + entry.getKey() + ", 密码: " + entry.getValue());
        }
    }

    public static void playGame() {
        while (true) {
            displayGameMenu();
            int userChoice = sc.nextInt();

            int computerChoice = random.nextInt(3) + 1; // 1 是石头, 2 是布, 3 是剪刀
            if (userChoice == 4) {
                System.out.println("游戏结束，谢谢参与！");
                break;
            }
            System.out.print("电脑选择了 ");
            displayChoice(computerChoice);
            System.out.println();

            if (userChoice == computerChoice) {
                System.out.println("平局！");
            } else if ((userChoice == 1 && computerChoice == 3) ||
                    (userChoice == 2 && computerChoice == 1) ||
                    (userChoice == 3 && computerChoice == 2)) {
                System.out.println("你赢了！");
            } else {
                System.out.println("你输了！");
            }
        }
    }

    public static void displayGameMenu() {
        System.out.println("欢迎来到剪刀石头布游戏！");
        System.out.println("1. 石头");
        System.out.println("2. 布");
        System.out.println("3. 剪刀");
        System.out.println("4. 退出游戏");
        System.out.print("请选择（1-4）：");
    }

    public static void displayChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.print("石头");
                break;
            case 2:
                System.out.print("布");
                break;
            case 3:
                System.out.print("剪刀");
                break;
        }
    }

    public static void luckyAudience() {
        List<String> audienceList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.print("请输入第" + i + "名观众的姓名：");
            String name = sc.nextLine();
            audienceList.add(name);
        }

        System.out.println("观众总览：");
        for (String name : audienceList) {
            System.out.println(name);
        }

        int luckyIndex = random.nextInt(audienceList.size());
        System.out.println("幸运观众是：" + audienceList.get(luckyIndex));
    }
}
