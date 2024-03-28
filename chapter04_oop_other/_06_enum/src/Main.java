public class Main {
    public static void main(String[] args) {
        gender.MAN.show();
        gender.MALE.show();
    }
}
interface info{
    public void show();
}
enum gender implements info{
    MAN("男","长鸡鸡的"){
        @Override
        public void show() {
            System.out.println("老子有鸡鸡");
        }
    },
    MALE("女","不长鸡鸡的"){
        @Override
        public void show() {
            System.out.println("没见过女人？");
        }
    };
    private final String genderDesc;
    private final String genderName;

    public String getGenderDesc() {
        return genderDesc;
    }

    public String getGenderName() {
        return genderName;
    }
    gender(String genderName,String genderDesc){
        this.genderName = genderName;
        this.genderDesc = genderDesc;
    }

}