import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class drinkingAgeCheck {


    public static void printPersons(
            List<Person> roster, checkPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.toString();
            }
        }
    }


    public static void main(String[] args) {
        Person tp, tp1, tp2, tp3, tp4;
        ArrayList<Person> myPeeps = new ArrayList<>();

        tp = new Person("Deku", LocalDate.of(1990, Month.APRIL, 22), Person.Sex.MALE, "Allmight@gmail.com");
        tp1 = new Person("Froppy", LocalDate.of(1970, Month.AUGUST, 12), Person.Sex.FEMALE, "Froggie@gmail.com");
        tp2 = new Person("Uravity", LocalDate.of(1980, Month.JULY, 18), Person.Sex.FEMALE, "Gravity@gmail.com");
        tp3 = new Person("Bakugou", LocalDate.of(2001, Month.MARCH, 7), Person.Sex.MALE, "Grenade@gmail.com");
        tp4 = new Person("Dabi", LocalDate.of(2003, Month.MAY, 22), Person.Sex.MALE, "BlueFire@gmail.com");
        myPeeps.add(tp1);
        myPeeps.add(tp2);
        myPeeps.add(tp3);
        myPeeps.add(tp4);
        myPeeps.add(tp);



        //Example of a local class
        class checkForOver18 implements checkPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        }
        printPersons(myPeeps, new checkForOver18());


        //Example using an anonymous class
        printPersons(myPeeps, new checkPerson() {
            @Override // Function we're implementing from the interface below
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });


        //Example using an lambdas
        printPersons(myPeeps, person -> person.getAge() >= 45);

    }
}
