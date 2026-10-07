public class AlquizarGradeCalculator {

    public String studentName;
    public double exam1;
    public double exam2;
    public double exam3;
    public double exam4;
    public double writtenWorks;

    public AlquizarGradeCalculator(String nameInput, double e1, double e2, double e3, double e4, double writtenWorksInput) {
    studentName = nameInput;
    exam1 = e1;
    exam2 = e2;
    exam3 = e3;
    exam4 = e4;
    writtenWorks = writtenWorksInput;
}

    public String retriveStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double retriveExam1() {
        return exam1;
    }

    public void setExam1(double exam1) {
        this.exam1 = exam1;
    }

    public double retriveExam2() {
        return exam2;
    }

    public void setExam2(double exam2) {
        this.exam2 = exam2;
    }

    public double retriveExam3() {
        return exam3;
    }

    public void setExam3(double exam3) {
        this.exam3 = exam3;
    }

    public double retiveExam4() {
        return exam4;
    }

    public void setExam4(double exam4) {
        this.exam4 = exam4;
    }

    public double retriveWrittenWorks() {
        return writtenWorks;
    }

    public void setWrittenWorks(double writtenWorks) {
        this.writtenWorks = writtenWorks;
    }

    public double calculateExamGrade() {
        return (exam1*0.10) + (exam2*0.10) + (exam3*0.10) + (exam4*0.40);
    }

    public double calculateWrittenWorksGrade() {
        return writtenWorks*0.30;
    }

    public double calculateRawScore() {
        return calculateExamGrade() + calculateWrittenWorksGrade();
    }

    public double calculateFinalGrade() {
        double rawScore = calculateRawScore();
        return (rawScore/100) * 85 + 15;
    }
}
