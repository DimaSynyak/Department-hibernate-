package ua.synyak.dima.project2.department;


import ua.synyak.dima.project2.department.DAO.Factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by root on 7/6/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Department department = null;
        Person person = null;
        Education education = null;
        Position position = null;
        LastPositions lastPositions = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для получения подробной информации введите help или команду для выполнения программы");

        while (true){
            String str = reader.readLine();
            if ("help".equals(str.toLowerCase())){
                System.out.println("команды");
                continue;
            }

            switch (str){
                case "addPerson":
                    person = new Person();
                    System.out.println("Введите имя");
                    str = reader.readLine(); //warning not null
                    person.setFirstName(str);

                    System.out.println("Введите фамилию:");
                    str = reader.readLine(); //warning not null
                    person.setLastName(str);

                    System.out.println("Введите отчество:");
                    str = reader.readLine(); //warning not null
                    person.setMiddle(str);

                    System.out.println("Введите номер карты:");
                    str = reader.readLine(); //warning not null
                    Card card = new Card();
                    card.setCardNum(Integer.parseInt(str));
                    person.setCard(card);

                    System.out.println("Введите город:");
                    str = reader.readLine(); //warning not null
                    Address address = new Address();
                    address.setCity(str);

                    System.out.println("Введите страну:");
                    str = reader.readLine(); //warning not null
                    address.setState(str);

                    System.out.println("Введите почтовый адрес:");
                    str = reader.readLine(); //warning not null
                    address.setPost(str);

                    System.out.println("Введите номер дома:");
                    str = reader.readLine(); //warning not null
                    address.setHomeNumber(Integer.parseInt(str));

                    System.out.println("Введите номер телефона:");
                    str = reader.readLine(); //warning not null
                    address.setPhone(Integer.parseInt(str));
                    person.setAddress(address);

                    System.out.println("Введите департамент: ");
                    str = reader.readLine(); //warning not null

                    department = Factory.getInstance().getDepartmentDAO().getDepartment(str);
                    if (department != null) {
                        person.setDepartment_id(department.getDepartment_id());
                    }

                    System.out.println("Введите образование:");
                    str = reader.readLine(); //warning not null
                    education = Factory.getEducationDAO().getEducation(str);
                    if (education != null){
                        person.setEducation_id(education.getEducation_id());
                    }

                    System.out.println("Введите должность:");
                    str = reader.readLine(); //warning not null
                    position = null;
                    if (department.containPosition(str)){
                        position = department.getPosition(str);
                    }

                    if (position != null) {
                        person.setPosition_id(position.getPosition_id());
                    }

                    Factory.getInstance().getPersonDAO().addPerson(person);

                    break;
                case "addDepartment":
                    department = new Department();
                    System.out.println("Введите название департамента: ");
                    str = reader.readLine(); //warning not null
                    department.setDepartmentName(str);
                    Factory.getInstance().getDepartmentDAO().addDepartment(department);
                    break;
                case "addEducation":
                    education = new Education();
                    System.out.println("Введите название образовательного учреждения: ");
                    str = reader.readLine(); //warning not null
                    education.setEducationName(str);
                    Factory.getInstance().getEducationDAO().addEducation(education);
                    break;
                case "addPosition":
                    position = new Position();
                    System.out.println("Введите должность: ");
                    str = reader.readLine(); //warning not null
                    position.setPositionName(str);
                    Factory.getInstance().getPositionDAO().addPosition(position);
                    break;
                case "updatePersonPosition":
                    System.out.println("Введите person_id: ");
                    str = reader.readLine();
                    int person_id = Integer.parseInt(str);
                    System.out.println("Введите название должности: ");
                    str = reader.readLine();

                    position = Factory.getInstance().getPositionDAO().getPosition(str);
                    person = Factory.getInstance().getPersonDAO().getPerson((long) person_id);

                    if (person.getPosition_id() == position.getPosition_id()){
                        continue;
                    }

                    person.setPosition_id(position.getPosition_id());
                    person.setDepartment_id(position.getDepartment_id());

                    lastPositions = new LastPositions();
                    lastPositions.setPosition_id(position.getPosition_id());
                    lastPositions.setPerson_id(person_id);

                    Factory.getInstance().getLastPositionDAO().addLastPosition(lastPositions);
                    Factory.getInstance().getPersonDAO().updatePersone(person);

                    break;
                case  "addLastPositions":
                    lastPositions = new LastPositions();
                    lastPositions.setPerson_id(2);
                    lastPositions.setPosition_id(3);
                    Factory.getInstance().getLastPositionDAO().addLastPosition(lastPositions);
                    System.out.println(1);
                    break;
                case "updatePerson":
                    person = Factory.getInstance().getPersonDAO().getPerson((long) 1);
                    person.setFirstName("Александр");
                    Factory.getInstance().getPersonDAO().updatePersone(person);
                    System.out.println(1);
                    break;
                default:
                    System.out.println("Такой команды не существует!");
            }
        }
    }
}
