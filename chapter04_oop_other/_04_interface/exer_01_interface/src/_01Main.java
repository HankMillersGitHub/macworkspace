public class _01Main {
    public static void main(String[] args) {
        // 1. 创建接口实现类的对象
        Printer p = new Printer();
        Computer c = new Computer();
        c.transferDate(p);
        System.out.println("------------------------");
        // 2. 创建接口实现类的匿名对象
        c.transferDate(new Dirve());
        System.out.println("------------------------");

        // 3. 创建接口匿名实现类的对象
        USB undefineUsb = new USB(){
            @Override
            public void start() {
                System.out.println("未知设备开始工作");
            }

            @Override
            public void stop() {
                System.out.println("未知设备结束工作");
            }
        };
        c.transferDate(undefineUsb);
        System.out.println("------------------------");

        // 4. 创建接口匿名实现类的匿名对象
        c.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("匿名设备开始工作");
            }

            @Override
            public void stop() {
                System.out.println("匿名设备结束工作");
            }
        });
    }
}
interface USB{
    void start();
    void stop();
}
class Printer implements USB{
    @Override
    public void start() {
        System.out.println("this is printer , it's begain.打印机开始工作");
    }
    @Override
    public void stop() {
        System.out.println("this is printer , it's stop.打印机结束工作");
    }
}

class Dirve implements USB{
    @Override
    public void start() {
        System.out.println("usb drive , begain。u盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("usb drive , stop。u盘结束工作");
    }
}

class Computer{
    public void transferDate(USB usb){ // 相当于 USB usb = new Printer();
        System.out.println("Device successfully connected，设备连接成功");
        usb.start();
        System.out.println("Data transmission in progress。。。。数据传输开始");
        usb.stop();
        System.out.println("Disconnect，断开连接");
    }
}