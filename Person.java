/**
 * Represents a Person with a name and age
 */
public class Person {

  private String name;     // first name of person
  private int age;         // age in years

  /** Constructor */
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  /** Accessor Method for name */
  public String getName() {
    return name;
  }
  
  /** Accessor Method for age */
  public int getAge() {
    return age;
  }
  
  /** toString Method override */
  public String toString() {
    return name + " (" + age + " years old)";
  }
  
}