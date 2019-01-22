package pl.szbd.virtualuniversity.domain.employee.model;


import java.util.ArrayList;
import java.util.List;

public class QuestionnaireView {
    private String name;
    private String content;
    private List<Option> options;

    public QuestionnaireView() {
        options= new ArrayList<>();
    }

    public QuestionnaireView(String name, String content, List<Option> options) {
        this.name = name;
        this.content = content;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "QuestionnaireView{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", options=" + options +
                '}';
    }
}
