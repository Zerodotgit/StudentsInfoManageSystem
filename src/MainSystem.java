import java.util.Scanner;

public class MainSystem {
    //创建必要对象
    Scanner sc = new Scanner(System.in);
    //创建必要变量
    private String name;
    private String sex;
    private String number;
    private String birthYear;
    private String birthMonth;
    private String birthDay;
    private double[] scores = new double[4];

    private void setTempInfo(){

        System.out.println("请输入姓名");
        name = sc.next();

        System.out.println("请输入性别");
        sex = sc.next();

        System.out.println("请输入学号");
        number = sc.next();

        System.out.println("请输入出生年份");
        birthYear = sc.next();

        System.out.println("请输入出生月份");
        birthMonth = sc.next();

        System.out.println("请输入出生日期");
        birthDay = sc.next();


    }

    public void start() {
        //创建必要对象
        Scanner sc = new Scanner(System.in);
        StudentsInfoOperator studentsInfoOperator = new StudentsInfoOperator();
        //创建必要变量
        int choice;

        System.out.println("====欢迎进入学生信息管理系统====");

        while (true) {
            System.out.println("请选择");
            System.out.println("""
                    1.添加学生信息
                    2.删除学生信息
                    3.修改学生信息
                    4.查询学生信息
                    5.显示已存系统中学生
                    6.退出系统""");

            choice = sc.nextInt();
            switch (choice){

                case 1:
                    //添加学生信息
                    setTempInfo();
                    studentsInfoOperator.addStudent(name ,sex ,number ,birthYear ,birthMonth ,birthDay);
                    System.out.println("添加成功");
                    break;
                case 2:
                    //删除学生信息(通过对应学号删除)
                    System.out.println("请输入要删除的学生学号");
                    number = sc.next();
                    studentsInfoOperator.deleteStudent(number);
                    break;
                case 3:
                    //修改学生信息
                    System.out.println("请输入要修改的学生学号");
                    number = sc.next();
                    studentsInfoOperator.editStudentInfo(number);
                    break;
                case 4:
                    //查询学生信息
                    System.out.println("请输入要查询的学生学号");
                    number = sc.next();
                    studentsInfoOperator.viewStudentInfo(number);
                    break;
                case 5:
                    //显示已存入系统中的学生
                    studentsInfoOperator.showAllStudents();
                    break;
                case 6:
                    //退出系统
                    return;
            }
        }
    }
}
