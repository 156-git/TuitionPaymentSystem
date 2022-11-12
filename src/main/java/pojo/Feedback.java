package pojo;

public class Feedback {
    private String order_num;
    private String stu_num;
    private String stu_name;
    private String phone;
    private String time;
    private String feedbackContent;
    private int state;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Feedback{" +
                "order_num='" + order_num + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", phone='" + phone + '\'' +
                ", time='" + time + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", state=" + state +
                '}';
    }
}
