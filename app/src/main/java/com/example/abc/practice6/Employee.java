package com.example.abc.practice6;

public class Employee {
    String Id;
    String Name;
    String Salary;
    public  Employee(String Id, String Name, String Salary)
    {
        this.Id = Id;
        this.Name = Name;
        this.Salary = Salary;
    }
    public String getId() {
        return Id;
    }
    public void setId(String Id)
    {
        this.Id = Id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getSalary() {
        return Salary;
    }
    public void setSalary(String Salary)
    {
        this.Salary = Salary;
    }
}
