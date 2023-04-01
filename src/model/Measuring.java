package model;

public  class Measuring extends Action{
    private String category;

    public Measuring(long id, String name, double price, String category) {
        super(id, name, price);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String toString(){
        return super.toString() + " " + category;
    }
}
