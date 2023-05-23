# SupplyChainApp-Java-MySQL
Console Menu application in Java simulating the activity of a supply chain store, using MySQL for CRUD operations, and it also features and AUDIT service. 
You can execute CRUD Operations on each model.
Technologies used : MySQL, Java


# How to use it
1. You need to download a service to use MySQL. I personally used XAMMP. Then, you need to install java and intellij. Last but not least you need a mysql-connector-java ( Needed to be able to work with the database)
2. Start your MySQL from xammp.
![image](https://github.com/DBojneagu/SupplyChainApp-Java-MySQL/assets/93039914/0d969dba-3aa4-4834-bf1f-75d576132ab9)

Press the admin button, which sends you into the phpmyadmin page. Here, you need to create a database. If you don't want to make any changes to the config file in the project,
just run the database on 3306 and put the database name david. After that, go into the SQL tab inside the david database and execute the script in the sqlscript.txt in the project folder.
![image](https://github.com/DBojneagu/SupplyChainApp-Java-MySQL/assets/93039914/2b6c036e-ff78-4279-ac9f-13891f3c3551)

3. After that, you need to go into the main folder of the project and in the main class, and press the start button ![image](https://github.com/DBojneagu/SupplyChainApp-Java-MySQL/assets/93039914/83d611d5-8ef1-4024-966f-ea520cdfe3e7)

# Models
We have 3 models

1. Product : This is a parent class, that has 3 children that derive from it : Furniture, Lighting and SmartHome.
2. Action : This is a parent class, that has 3 children that derive from it : Delivery, Measuring and Assembly.
3. Orders : This is a class that contains a product and an action, and finally the total cost of the two. 
![image](https://github.com/DBojneagu/SupplyChainApp-Java-MySQL/assets/93039914/21a0b278-30f4-4124-925a-2cd26af7665a)


# How it is structured

1. Model folder : self-explanatory
2. Repository folder : here we have all the functions and actions that interact with the database, so pretty much the CRUD operations.
3. Config folder : The Database configuration, if you want to change the port or the name, here you need to do it. 
4. Service folder : Here we have the builder for the models, as well as the audit feature. 
For the full menu you need to acces the shop class inside model, here we have the whole menu and how it is structured.
