package model;

public abstract class SmartHome extends Product {
    private String category;
    private String AppName;

    public SmartHome(long id, int price, int stock, String name, String category, String appName) {
        super(id, price, stock, name);
        this.category = category;
        AppName = appName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }
}
