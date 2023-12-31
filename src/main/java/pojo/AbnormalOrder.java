package pojo;

public class AbnormalOrder {
    private String order_num;
    private String stu_num;
    private String stu_name;
    private String stu_class;
    private float stu_money;
    private String order_time;
    private int order_state;

    private  int show_state;


    public int getShow_state() {
        return show_state;
    }

    public void setShow_state(int show_state) {
        this.show_state = show_state;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public float getStu_money() {
        return stu_money;
    }

    public void setStu_money(float stu_money) {
        this.stu_money = stu_money;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    @Override
    public String toString() {
        return "AbnormalOrder{" +
                "order_num='" + order_num + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_class='" + stu_class + '\'' +
                ", stu_money=" + stu_money +
                ", order_time='" + order_time + '\'' +
                ", order_state=" + order_state +
                ", show_state=" + show_state +
                '}';
    }
}
