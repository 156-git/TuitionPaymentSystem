package pojo;

public class Paylist {
    private String stu_num;
    private String stu_name;
    private String time;
    private int state;
    private String stu_class;
    private float payment;
    private int show_state;

    public int getShow_state() {
        return show_state;
    }

    public void setShow_state(int show_state) {
        this.show_state = show_state;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Paylist{" +
                "stu_num='" + stu_num + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", time='" + time + '\'' +
                ", state=" + state +
                ", stu_class='" + stu_class + '\'' +
                ", payment=" + payment +
                '}';
    }
}
