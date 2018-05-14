package lesson6;

public class ArrayStudents {

    private int memory = 0;
    private Student[] students = new Student[2 + memory];
    private Student[] temp;

    public void addStudentToArray(Student student) {
        int i = 0;
        boolean flag = false;
        while (i < students.length && flag == false) {

            if (students[i] == null) {
                students[i] = student;
                flag = true;
            }
            i++;
            if (i == students.length) {
                memory++;//специально увеличиваю память всего на одну ячейку.
                temp = students;
                students = new Student[2 + memory];
                for (int j = 0; j < temp.length; j++) {
                    students[j] = temp[j];
                }
                i--;
            }

        }
    }

    public void deleteStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if(students[i].getLastName().equals(lastName) && students[i].getFirstName().equals(firstName)){
//                students[i];
            }

        }
    }
    public Student[] getArray(){
        return students;
    }

}
