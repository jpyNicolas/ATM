public class Person {
    private String name;
    private String family;
    private String nationalCode;
    //private List<Account> accounts;

    public Person(String name, String family, String nationalCode) {
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getNationalCode() {
        return nationalCode;
    }
}
