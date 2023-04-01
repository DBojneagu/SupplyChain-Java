package model;

public  class Assembly extends Action {
        protected int  number_of_products;
        private int number_of_employees;
        // Poate facem aici o lista de angajati inloc de numar ca sa folosim Array

        public Assembly(long id, String name, double price, int number_of_products, int number_of_employees){
            super(id,name,price);
            this.number_of_employees = number_of_employees;
            this.number_of_products = number_of_products;
        }

    public int getNumber_of_products() {
        return number_of_products;
    }

    public void setNumber_of_products(int number_of_products) {
        this.number_of_products = number_of_products;
    }

    public int getNumber_of_employees() {
        return number_of_employees;
    }

    public void setNumber_of_employees(int number_of_employees) {
        this.number_of_employees = number_of_employees;
    }

    @Override
    public String toString(){
            return super.toString() + " | Number of products :  " +  number_of_products + " | Number of Employees : " +  number_of_employees;
    }
}
