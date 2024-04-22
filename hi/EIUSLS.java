import java.io.*;
import java.util.*;

public class EIUSLS {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int numberOfStudents = reader.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = reader.next();
            int course = reader.nextInt();
            List<Integer> grades = new ArrayList<>();
            for (int j = 0; j < course; j++) {
                grades.add(reader.nextInt());
            }
            Student student = new Student(name, course, grades);
            students.add(student);
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                double gpaComparison = Double.compare(s2.calculateGPA(s2.getGrades()), s1.calculateGPA(s1.getGrades()));
                if (gpaComparison != 0) {
                    return (int) gpaComparison;
                }
                return students.indexOf(s1) - students.indexOf(s2);
            }
        });

        int count = 0;
        for (Student student : students) {
            str.append(student.getStudentName()).append("\n");
           count++;
           if (count == 2)
                break;
        }
        System.out.print(str);

    }

    static class Student {
        private String studentName;
        private int course;
        private List<Integer> grades = new ArrayList<>();

        public Student(String studentName, int course, List<Integer> grades) {
            this.studentName = studentName;
            this.course = course;
            this.grades = grades;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        public void setGrades(List<Integer> grades) {
            this.grades = grades;
        }

        public double calculateGPA(List<Integer> grades) {
            double totalPoint = 0;
            for (int grade : grades) {
                totalPoint += grade;
            }
            return (double) totalPoint / grades.size();
        }

    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
