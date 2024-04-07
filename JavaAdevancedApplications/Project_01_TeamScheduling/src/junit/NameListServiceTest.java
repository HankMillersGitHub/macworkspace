package junit;
import domain.Employee;
import org.junit.Test;
import service.NameListService;
import service.TeamException;

public class NameListServiceTest {
    @Test
    public void test(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    @Test
    public void test2(){
        NameListService nameListService = new NameListService();
        try{
            System.out.println(nameListService.getEmployee(13));
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
