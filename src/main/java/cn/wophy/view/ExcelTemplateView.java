package cn.wophy.view;


public class ExcelTemplateView {

    private String title;

    private String attribute;

    public ExcelTemplateView() {
    }

    public ExcelTemplateView(String title, String attribute) {
        this.title = title;
        this.attribute = attribute;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
