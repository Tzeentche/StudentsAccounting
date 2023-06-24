public class SaveStudentOrder {
    public static void main(String[] args) {

        StudentOrder so = new StudentOrder();
        so.hFirstName = "Trofim";
        so.hLastName = "Trifonov";
        so.wFirstName = "Parafia";
        so.wLastName = "Trifonova";

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 1999;
        System.out.println("SaveStudentOrder" + studentOrder.hLastName);

        return answer;
    }
}