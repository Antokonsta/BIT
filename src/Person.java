public class Person {

    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public Person getSpouse() {

        return this.spouse;
    }

    public String getSpouseName() { // метод для получения имени супруга, если супруга нет,вернет null

        return this.spouse != null ? this.spouse.getName() : null;
    }

    public boolean isMan() {

        return this.man;
    }

    public String getName() {

        return this.name;
    }

    public boolean marry(Person person) {
        if (person.man != this.man) { // проверка на гомосексуальность
            if (person.spouse != null) { // если у person уже есть супруг,то нужно сначала развестись
                person.divorce();
            }

            if (this.spouse != null) {
                this.divorce();
            }

            this.spouse = person; // женим их
            person.spouse = this;
            return true;
        } else {
            return false;
        }
    }

    public boolean divorce() {
        this.spouse.spouse = null; // сначала убираем связь ссылки и объекта у супруга person'a
        this.spouse = null; // затем убираем связь у самого person'a
        return true;
    }
}

