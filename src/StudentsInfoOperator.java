import java.util.ArrayList;
import java.util.Scanner;

public class StudentsInfoOperator {
    //创建必要变量
    int choice;
    int n;  //用于记住学生信息的位置
    StudentsInfo studentInfo;

    //创建必要对象
    ArrayList<StudentsInfo> studentsInfos = new ArrayList<>();  //用于存储学生信息
    Scanner sc = new Scanner(System.in);
    //添加学生信息
    public void addStudent(String name , String sex , String number , String birthYear , String birthMonth , String birthDay){
        StudentsInfo newStudentInfo = new StudentsInfo();
        newStudentInfo.setName(name);
        newStudentInfo.setSex(sex);
        newStudentInfo.setNumber(number);
        newStudentInfo.setBirthYear(birthYear);
        newStudentInfo.setBirthMonth(birthMonth);
        newStudentInfo.setBirthDay(birthDay);

        //此方法可避免地址篡改
        double[] scores = new double[4];
        System.out.println("请分别输入四次考试的成绩（0-100分）");
        for (int i = 0; i < scores.length; i++) {
            while (true) {
                System.out.println("第" + (i + 1) + "次考试成绩：");
                scores[i] = sc.nextDouble();
                if(scores[i] < 0 && scores[i] > 100){
                    System.out.println("输入的数据有误");
                }else{
                    break;
                }
            }
        }
        newStudentInfo.setScores(scores);

        studentsInfos.add(newStudentInfo);
    }
    
    //删除学生信息
    public void deleteStudent(String number){
        while (true) {
            //查找对应学号的学生信息
            if(searchStudentInfo(number) != null){
                studentsInfos.remove(n);
                System.out.println("该学生信息已被移除");
                return;
            }

            //输入错误提示
            System.out.println("没有查询到学号为" + number + "的学生信息,是否重新输入?\n" +
                    "（重输：1，退出：0）");

            //出错后选择是否继续删除
            if (choice == 1) {
                System.out.println("请输入要删除的学生学号");
                number = sc.next();
            } else {
                return;
            }
        }
    }

    //修改学生信息
    public void editStudentInfo(String number){
        studentInfo = searchStudentInfo(number);
        if(studentInfo != null){
            while (true) {
                System.out.println("""
                        请选择需要修改的内容:
                        1.姓名
                        2.性别
                        3.学号
                        4.出生年份
                        5.出生月份
                        6.出生日期
                        7.成绩""");

                switch (choice){
                    case 1:
                        System.out.println("请输入姓名");
                        studentInfo.setName(sc.next());
                        break;
                    case 2:
                        System.out.println("请输入性别");
                        studentInfo.setSex(sc.next());
                        break;
                    case 3:
                        System.out.println("请输入学号");
                        studentInfo.setNumber(sc.next());
                        break;
                    case 4:
                        System.out.println("请输入出生年份");
                        studentInfo.setBirthYear(sc.next());
                        break;
                    case 5:
                        System.out.println("请输入出生月份");
                        studentInfo.setBirthMonth(sc.next());
                        break;
                    case 6:
                        System.out.println("请输入出生");
                        studentInfo.setBirthDay(sc.next());
                        break;
                    case 7:
                        System.out.println("请分别输入成绩");
                        double[] temp = new double[4];
                        for (int i = 0; i < temp.length; i++) {
                            System.out.println("第" + i + "个");
                        }
                        studentInfo.setScores(temp);
                        break;
                    default:
                        System.out.println("""
                                          输入的内容有误，是否重新输入
                                          （重输：1，退出：0）""");
                        if(choice != 1){
                            return;
                        }
                }
            }
        }else{
            System.out.println("没有查询到学号为" + number + "的学生信息");
        }
    }

    //查询学生信息
    public void viewStudentInfo(String number){
        studentInfo = searchStudentInfo(number);
        if(studentInfo != null){
            System.out.println("学生姓名：" + studentInfo.getName());
            System.out.println("学生性别：" + studentInfo.getSex());
            System.out.println("学生学号：" + studentInfo.getNumber());
            System.out.println("学生出生日期：" + studentInfo.getBirthYear() + "年" + studentInfo.getBirthMonth() + "月" + studentInfo.getBirthDay() + "日");
            System.out.println("学生成绩：");
            for (int i = 0; i < studentInfo.getScores().length; i++) {
                System.out.print(studentInfo.getScores()[i]+ "\n");
            }
        }else{
            System.out.println("没有查询到学号为" + number + "的学生信息");
        }
    }

    //显示已存系统中学生
    public void showAllStudents(){
        if(studentsInfos.isEmpty()){
            System.out.println("系统目前没有任何学生信息");
            return;
        }

        for (int i = 0; i < studentsInfos.size(); i++) {
            studentInfo = studentsInfos.get(i);
            System.out.println(i + "." + studentInfo.getName() + " " + studentInfo.getNumber() + "\t");
            if(i % 5 == 0){
                System.out.println();
            }
        }
    }

    //查询是否存在该学生信息
    private StudentsInfo searchStudentInfo(String number){
        //判断系统中是否存在学生信息
        if(studentsInfos.isEmpty()){
            System.out.println("系统目前没有任何学生信息");
            return null;
        }

        //查找对应学号的学生信息
        for (int i = 0; i < studentsInfos.size(); i++) {
            studentInfo = studentsInfos.get(i);
            if(number.equals(studentInfo.getNumber())){
                n = i;
                return studentInfo;
            }
        }
        return null;
    }


}
