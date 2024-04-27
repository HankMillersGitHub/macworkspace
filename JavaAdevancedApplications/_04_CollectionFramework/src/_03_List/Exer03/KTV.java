package _03_List.Exer03;

import java.util.ArrayList;
import java.util.Scanner;

public class KTV {
    private static ArrayList musicList = new ArrayList();// 歌曲列表
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isFlag = true;
        while (isFlag){
            System.out.println("当前歌曲列表：" + musicList);
            System.out.println("--------欢迎来到HankKTV--------");
            System.out.println("--------1.添加歌曲至列表--------");
            System.out.println("--------2.将歌曲置顶   --------");
            System.out.println("--------3.将歌曲前移一位--------");
            System.out.println("--------4.退出        --------");
            int key = scanner.nextInt();
            switch (key){
                case 1:addMusicList();break;
                case 2:toTop();break;
                case 3:step();break;
                case 4:isFlag = false;break;
            }
        }
    }

    private static void stop() {
    }

    private static void step() {
        System.out.println("请输入要前移的歌曲：");
        String name = scanner.next();
        int musicIndex = musicList.indexOf(name);
        if(musicIndex < 0){
            System.out.println("当前列表没有此歌曲");
        }else if(musicIndex == 0){
            System.out.println("此歌曲已在最靠前位置");
        }else{
            // 自己写的 存储了一下目标数据
            /*Object targetArea = musicList.get(musicIndex);
            musicList.remove(musicIndex);
            musicList.add(musicIndex - 1,targetArea);*/
            // 老师写的 ，没有存储目标数据 相当于直接添加新数据
            musicList.remove(name);
            musicList.add(musicIndex - 1 ,name);
            System.out.println("已将歌曲《" + name + "》前移一位");
        }
    }

    private static void toTop() {
        System.out.println("请输入要置顶的歌曲：");
        String name = scanner.next();
        int musicIndex = musicList.indexOf(name);
        if(musicIndex < 0){
            System.out.println("当前列表没有此歌曲");
        }else if(musicIndex == 0){
            System.out.println("此歌曲已在置顶位置");
        }else{
            // 这里是直接交换位置 逻辑正确但不合理
            // musicList.set(0,musicList.get(musicIndex));
            // 先remove 然后添加到首位
            musicList.remove(name);
            musicList.add(0,name);
            System.out.println("已将歌曲《" + name + "》置顶");
        }
    }

    private static void addMusicList() {
        System.out.println("请输入要添加的歌曲：");
        String name = scanner.next();
        musicList.add(name);
        System.out.println("歌曲已添加：" + name);
    }

}
