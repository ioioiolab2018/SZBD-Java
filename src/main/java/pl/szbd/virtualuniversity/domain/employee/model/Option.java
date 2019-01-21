package pl.szbd.virtualuniversity.domain.employee.model;

public class Option {
    private String name;
    private Integer count;

    public Option(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Option{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
