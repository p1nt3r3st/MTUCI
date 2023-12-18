import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);

    }
}



class Address implements Comparable<Address>{      // класс Адрес. сдержит улицу и номер дома
protected String street;
protected String house;

Address(String street, String house){      // конструктор
    this.street = street;
    this.house = house;
}

    @Override
    public int compareTo(Address address) {
        Integer result = this.street.compareTo(address.street);
        if (result == 0){
            result = this.house.compareTo(address.house);
        }
        return result;
    }

    // метод toString. Переводим данные объекта в строку
public String toString(){
    return String.format("%-20s", this.street + " " + this.house);
}
}







class Director implements Comparable<Director>{     // класс Директор. Содержит имя, фамилию и, по желанию, отчество
    protected String name = "";
    protected String surname = "";
    protected String patronymic = "";

    Director(String name, String surname, String patronymic){       // конструктор с отчеством
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String toString(){
        return String.format("%-40s",this.name + " " + this.patronymic + " " + this.surname);
    }

    @Override
    public int compareTo(Director director) {
        Integer result = this.name.compareTo(director.name);
        if (result == 0){
            result = this.surname.compareTo(director.surname);
            if (result == 0){
                result = this.patronymic.compareTo(director.patronymic);
            }
        }
        return result;
    }
}




class Library implements Comparable<Library> {          // класс библиотека
    protected String name;      // название библиотеки
    protected Address address;  // её адрес
    protected String city;      // город
    protected Director director;    // директор

    Library(String name, Address address, String city, Director director) {      // конструктор класса
        this.name = name;
        this.address = address;
        this.city = city;
        this.director = director;
    }

    @Override
    public int compareTo(Library library) {         // метод сравнения библиотек
        Integer result = this.name.compareTo(library.name);
        if (result == 0){
            result = this.address.compareTo(library.address);
            if (result == 0){
                result = this.city.compareTo(library.city);
                if (result == 0){
                    result = this.director.compareTo(library.director);
                }
            }
        }
        return result;
    }

    public String toString(){               // преобразование данных в строку
        return  String.format("%-30s ", this.name) +
                this.address +
                String.format("%-20s", this.city) +
                this.director + "\n";
    }

}

class customerComparator implements Comparator<Library> {

    @Override
    public int compare(Library library, Library t1) {
        return library.compareTo(t1);
    }
}


