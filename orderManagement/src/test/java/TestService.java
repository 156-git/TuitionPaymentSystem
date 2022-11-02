import org.junit.Test;
import service.OrderService;

public class TestService {

    //测试查询总金额方法
    @Test
    public void testTotalAmount(){
        OrderService orderService=new OrderService();
        float f=orderService.queryTotalAmount();
        System.out.println(f);
    }


}
