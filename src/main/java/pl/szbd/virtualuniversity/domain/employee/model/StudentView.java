package pl.szbd.virtualuniversity.domain.employee.model;

import java.util.ArrayList;
import java.util.List;

public class StudentView {
    private class  Item{
        private Long ret;
        private String dsp;

        public Long getRet() {
            return ret;
        }

        public void setRet(Long ret) {
            this.ret = ret;
        }

        public String getDsp() {
            return dsp;
        }

        public void setDsp(String dsp) {
            this.dsp = dsp;
        }

        public Item(Long ret, String dsp) {
            this.ret = ret;
            this.dsp = dsp;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "ret=" + ret +
                    ", dsp='" + dsp + '\'' +
                    '}';
        }
    }
    private Long index;
    private String firstName;
    private String surname;
    private String secondName;
    private List<Item> semesters;

    public StudentView(Long index, String firstName, String surname, String secondName) {
        this.index = index;
        this.firstName = firstName;
        this.surname = surname;
        this.secondName = secondName;
        this.semesters = new ArrayList<>();
    }
    public  void addSemester(Long ret, String dsp){
        semesters.add(new Item(ret, dsp));
    }

    public StudentView() {
        semesters= new ArrayList<>();
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Item> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Item> semesters) {
        this.semesters = semesters;
    }

    @Override
    public String toString() {
        return "StudentView{" +
                "index=" + index +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", secondName='" + secondName + '\'' +
                ", semesters=" + semesters +
                '}';
    }
}
