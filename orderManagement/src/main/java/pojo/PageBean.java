package pojo;

import java.util.List;

public class PageBean<T> {
    //总记录数
    private int totalcount;
    //当前页面数
    private List<T> rows;

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalcount=" + totalcount +
                ", rows=" + rows +
                '}';
    }
}
