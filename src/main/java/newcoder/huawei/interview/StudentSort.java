package newcoder.huawei.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 现在有一个学校有很多学生，每个学生都测量了身高(单位cm)和体重(单位kg)，
 * 现在需要对所有的学生进行一个排序处理，
 * 排序要求如下：
 * 优先按照身高从高到低排，如果身高相同的则要按照体重从大到小排，请完成算法的设计：
 */
public class StudentSort {

    public static void main(String[] args) {
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student(166,53));
        allStudents.add(new Student(156,53));
        allStudents.add(new Student(166,33));
        allStudents.add(new Student(106,52));
        allStudents.add(new Student(136,63));

        sortAll(allStudents);

        allStudents.forEach(System.out::println);
    }

    static List<Student> sortAll(List<Student> allStudents){
        // 请补充完整
        Collections.sort(allStudents);
        return allStudents;
    }

    static class Student implements Comparable{
        public Student(int height,int weight){
            this.weight = weight;
            this.height = height;
        }
        int height;
        int weight;
        // 请补充 实现
        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            Student s = (Student)o;
            if(height == s.height){
                return s.weight - weight;
            }else{
                return s.height - height;
            }
        }

        @Override
        public String toString(){
            return height + " " + weight;
        }
    }
}
