/**
 * La clase Empleo representa una fila del documento a ordenar.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 */
public class Empleo {
    private int age;
    private String gender;
    private String educationLevel;
    private String jobTitle;
    private double yearsExperience;
    private int salary;

    /**
     * Constructor para Empleo.
     * @param age
     * @param gender
     * @param educationLevel
     * @param jobTitle
     * @param yearsExperience
     * @param salary
     */
    public Empleo(int age, String gender, String educationLevel, String jobTitle, double yearsExperience, int salary) {
        this.age = age;
        this.gender = gender;
        this.educationLevel = educationLevel;
        this.jobTitle = jobTitle;
        this.yearsExperience = yearsExperience;
        this.salary = salary;
    }

    /** 
     * Devuelve la edad que se necesita para el empleo.
     * @return int
     */
    public int getAge() {
        return age;
    }
    /** 
     * Establece la edad que se necesita para el empleo.
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /** 
     * Devuelve el genero que se necesita para el empleo.
     * @return String
     */
    public String getGender() {
        return gender;
    }
    /** 
     * Establece el genero que se necesita para el empleo.
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** 
     * Devuelve el nivel de educacion que se necesita para el empleo.
     * @return String
     */
    public String getEducationLevel() {
        return educationLevel;
    }
    /** 
     * Establece el nivel de educacion que se necesita para el empleo.
     * @param educationLevel
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /** 
     * Devuelve el nombre del empleo.
     * @return String
     */
    public String getJobTitle() {
        return jobTitle;
    }
    /** 
     * Establece el nombre del empleo.
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /** 
     * Devuelve la cantidad de años de experiencia que se necesita para el empleo.
     * @return double
     */
    public double getYearsExperience() {
        return yearsExperience;
    }
    /** 
     * Establece la cantidad de años de experiencia que se necesita para el empleo.
     * @param yearsExperience
     */
    public void setYearsExperience(double yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    /** 
     * Devuelve el salario del empleo.
     * @return int
     */
    public int getSalary() {
        return salary;
    }
    /** 
     * Establece el salario del empleo.
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /** 
     * Devuelve el contenido de la fila del documento a ordenar.
     * @return String
     */
    public String display() {
        return "{\nAge: " + getAge() + "\nGender:" + getGender() + "\nEducation Level: " + getEducationLevel() + "\nJob Title: " + getJobTitle()
                + "\nYears of Experience: " + getYearsExperience() + "\nSalary: " + getSalary() + "\n}";
    }
}
