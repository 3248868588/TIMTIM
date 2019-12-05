package cn.itcast.timtim.entity;

public class Titleandcontext {
    private String title;
    private String context;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Titleandcontext(String title, String context) {
        this.title = title;
        this.context = context;
    }
}
