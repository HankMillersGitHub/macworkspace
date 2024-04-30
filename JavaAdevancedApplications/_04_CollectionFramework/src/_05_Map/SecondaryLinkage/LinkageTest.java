package _05_Map.SecondaryLinkage;

import java.util.*;

import static _05_Map.SecondaryLinkage.CityMap.model;

public class LinkageTest {
    public static void main(String[] args) {
        while (true) {
            Set set = model.keySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.print("\t"+iterator.next());
            }
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入您选择的省份:");
            String privence = scanner.next();
            boolean isFlag = false;
            // 判断当前集合是否有用户输入的省份
            if (model.containsKey(privence)) {
                for (String cityName : (String[]) model.get(privence)) {
                    System.out.print(cityName+"\t");
                }
                System.out.println();
                // 如果用户输入的省份包含在Set中 则让用户输入城市名
                System.out.print("请输入您所在的城市：");
                String userCity = scanner.next();
                // 如果有 就将该省份的城市名称返回为集合
                for (String cityName : (String[]) model.get(privence)) {
                    if (userCity.equals(cityName)) {
                        System.out.println("您所在的位置为：" + privence + userCity);
                        isFlag = true;
                        break;
                    }
                }
                if (!isFlag) {
                    System.out.println("您输入的城市有误");
                }
            } else {
                System.out.println("您输入的省份有误");
            }
        }
    }
}
