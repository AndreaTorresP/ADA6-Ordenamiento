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
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String name) {
        this.gender = name;
    }

    public String getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getYearsExperience() {
        return yearsExperience;
    }
    public void setYearsExperience(double yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String display() {
        return "{\nAge: " + getAge() + "\nGender:" + getGender() + "\nEducation Level: " + getEducationLevel() + "\nJob Title: " + getJobTitle()
                + "\nYears of Experience: " + getYearsExperience() + "\nSalary: " + getSalary() + "\n}";
    }
}
