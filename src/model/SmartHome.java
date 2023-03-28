package model;

public  class SmartHome extends Product {
    private String category;
    private String AppName;

    public SmartHome(long id, String name, int stock, int price, String category, String appName) {
        super(id, name, stock, price);
        this.category = category;
        this.AppName = appName;
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

    @Override
    public String toString() {
        return super.toString() + " | Category : " + category + " | AppName: " + AppName ;
    }
}
