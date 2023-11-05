package homework_23_09_13;


import java.util.Objects;

public class MyClass implements Comparable<MyClass> {

    private int id;
    private String name;
    private int account;
    private String category;

    public MyClass(int id, String name, int account, String category) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.category = category;
    }

    public MyClass() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAccount() {
        return account;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return id == myClass.id && account == myClass.account
                && Objects.equals(name, myClass.name)
                && Objects.equals(category, myClass.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, name, category);
    }

    @Override
    public int compareTo(MyClass o) {
        int result = Integer.compare(this.id, o.id);
        if (result == 0) {
            result = Integer.compare(this.account, o.account);
            if (result == 0) {
                result = this.name.compareTo(o.name);
                if (result == 0) {
                    result = this.category.compareTo(o.category);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", category='" + category + '\'' +
                '}';
    }
}
