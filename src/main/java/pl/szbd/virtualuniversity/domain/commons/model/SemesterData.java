package pl.szbd.virtualuniversity.domain.commons.model;

import java.util.List;

public class SemesterData implements Comparable<SemesterData> {
    private Integer nr;
    private List<TableData> data;

    public SemesterData() {
    }

    public SemesterData(Integer nr, List<TableData> data) {
        this.nr = nr;
        this.data = data;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public List<TableData> getData() {
        return data;
    }

    public void setData(List<TableData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SemesterData{" +
                "nr=" + nr +
                ", data=" + data +
                '}';
    }

    @Override
    public int compareTo(SemesterData o) {
        return nr.compareTo(o.nr);
    }
}
