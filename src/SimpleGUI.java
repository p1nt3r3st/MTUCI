import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

class SimpleGUI extends JFrame {            // графический интерфейс
    private JButton button_print = new JButton("Вывести список библиотек"); // при нажатии - вывод всех добавленный библиотек
    private JButton button_add = new JButton("Добавить библиотеку");    // при нажатии - добавление библиотеки

    private JTextField input_name = new JTextField("Библиотека Мтуси", 5);      // ввод названия библиотеки
    private JLabel jLabel_name = new JLabel("Введите название");        // текст

    private JTextField input_city = new JTextField("Москва", 5);
    private JLabel jLabel_city = new JLabel("Введите город");

    private JTextField input_street = new JTextField("Красная", 5);

    private JLabel jLabel_street = new JLabel("Введите улицу");

    private JTextField input_house = new JTextField("1", 5);
    private JLabel jLabel_house = new JLabel("Введите номер дома");

    private JTextField input_full_name = new JTextField("Иванов", 5);
    private JLabel jLabel_full_name = new JLabel("Имя директора");

    private JTextField input_surname = new JTextField("Иван", 5);
    private JLabel jLabel_surname = new JLabel("Фамилия директора");

    private JTextField input_patronymic = new JTextField("Иванович", 5);
    private JLabel jLabel_patronymic = new JLabel("Отчество директора");



    private JCheckBox check = new JCheckBox("Отсортировать", false);        // флажок сортировки
    public ArrayList<Library> libraries = new ArrayList<>();        // список библиотек. тут преобразуем класс в коллекцию

    public SimpleGUI() {        // конструктор

        super("Библиотеки");        // название окна
        this.setBounds(100, 100, 1000, 300);        // размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // реакция на закрытие окна

        Container container = this.getContentPane();        // форма, в которую мы будем помещать кнопки
        container.setLayout(new GridLayout(3, 3, 5, 6));
        container.add(jLabel_name);     // добавляем кнопки, тексты и т.д.
        container.add(input_name);

        container.add(jLabel_street);
        container.add(input_street);

        container.add(jLabel_house);
        container.add(input_house);

        container.add(jLabel_city);
        container.add(input_city);

        container.add(jLabel_full_name);
        container.add(input_full_name);

        container.add(jLabel_surname);
        container.add(input_surname);

        container.add(jLabel_patronymic);
        container.add(input_patronymic);

        container.add(check);

        button_print.addActionListener(new ButtonEventListener());      // реакция на кнопки
        container.add(button_print);

        button_add.addActionListener(new ButtonAddingListener());
        container.add(button_add);

    }

    class ButtonEventListener implements ActionListener {       // реакция на нажатие кнопки
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if (check.isSelected()){
                Collections.sort(libraries, new customerComparator());      // если отмечен флажок, то сортируем
            }

            String message = String.format("%-30s", "Название библиотеки") +
                    String.format("%-20s", "Адрес") +
                    String.format("%-20s", "Город") +
                    String.format("%-40s", "ФИО директора") + "\n";
            for (int i = 0; i < libraries.size(); i++){
                message = message.concat(libraries.get(i).toString());          // формируем итоговую строку
            }
            JOptionPane.showMessageDialog(null, message, "Список библиотек", JOptionPane.PLAIN_MESSAGE);        // вывод на экран в виде отдельного окна
        }
    }


    class ButtonAddingListener implements ActionListener{       // реакция на нажатие кнопки
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            libraries.add(new Library(input_name.getText(), new Address(input_street.getText(), input_house.getText()),
                    input_city.getText(), new Director(input_full_name.getText(), input_surname.getText(), input_patronymic.getText())));           // добавляем объект библиотека
            input_name.setText("");         // обнуляем введённый текст
            input_street.setText("");
            input_house.setText("");
            input_city.setText("");
            input_full_name.setText("");
            input_surname.setText("");
            input_patronymic.setText("");
        }
    }

}