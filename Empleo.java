public class Empleo {
    private int age;
    private String gender;
    private String educationLevel;
    private String jobTitle;
    private double yearsExperience;
    private int salary;

    public Empleo(int age, String gender, String educationLevel, String jobTitle, double yearsExperience, int salary) {
        this.age = age;
        this.gender = gender;
        this.educationLevel = educationLevel;
        this.jobTitle = jobTitle;
        this.yearsExperience = yearsExperience;
        this.salary = salary;
    }

    
    /** 
     * @return int
     */
    public int getAge() {
        return age;
    }
    
    /** 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    
    /** 
     * @return String
     */
    public String getGender() {
        return gender;
    }
    
    /** 
     * @param name
     */
    public void setGender(String name) {
        this.gender = name;
    }

    
    /** 
     * @return String
     */
    public String getEducationLevel() {
        return educationLevel;
    }
    
    /** 
     * @param educationLevel
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    
    /** 
     * @return String
     */
    public String getJobTitle() {
        return jobTitle;
    }
    
    /** 
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    
    /** 
     * @return double
     */
    public double getYearsExperience() {
        return yearsExperience;
    }
    
    /** 
     * @param yearsExperience
     */
    public void setYearsExperience(double yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    
    /** 
     * @return int
     */
    public int getSalary() {
        return salary;
    }
    
    /** 
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    
    /** 
     * @return String
     */
    public String display() {
        return "{\nAge: " + getAge() + "\nGender:" + getGender() + "\nEducation Level: " + getEducationLevel() + "\nJob Title: " + getJobTitle()
                + "\nYears of Experience: " + getYearsExperience() + "\nSalary: " + getSalary() + "\n}";
    }
}
