public class StudentsInfo {

    //构造器
    public StudentsInfo() {
    }

    public StudentsInfo(String name, String sex, String number, String birthYear, String birthMonth, String birthDay, double[] scores) {
        this.name = name;
        this.sex = sex;
        this.number = number;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.scores = scores;
    }

    //=========================================================================================================================================

    //学生属性
    private String name;
    private String sex;
    //age待定
    private String number;
    private String birthYear;
    private String birthMonth;
    private String birthDay;
    private double[] scores = new double[4];

    //=========================================================================================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }
}
