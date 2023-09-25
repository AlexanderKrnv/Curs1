import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement implements Calculator{
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        while (true) {
            // Проверяем, является ли введенное значение int
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер после считывания числа
                return input;
            } else {
                // Если пользователь ввел неверный тип, выводим сообщение об ошибке
                System.out.println("Mistake! Invalid value entered. Please try again.");
                scanner.nextLine(); // Очищаем буфер после считывания некорректного значения
            }
        }
    }
    public void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.print("Please select an option (or Enter -1 to quit): ");

        int choice = getIntInput();
        return choice;
    }
    public int calculateFees(int id){
        if(id==1){
            return 900;
        } else if (id==2) {
            return 950;
        } else if (id==3) {
            return 1000;
        }
        else return -1;
    };
    public String addMembers(LinkedList<Member> m){
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        System.out.println("Введите имя: ");
        name = scanner.nextLine();
        System.out.println("Введите идентификатор клуба: ");
        printClubOptions();
        club=getIntInput();
        if(m.size()==0){
            memberID=1;
        }
        else{
            memberID=m.size()+1;
        }
        if(calculateFees(club)!=-1){
            mbr=new SingleClubMember('S',memberID,name,calculateFees(club),club);
            m.add(mbr);
        }
        else{
            mbr= new MultiClubMember('M', memberID, name,1500, 100);
            m.add(mbr);
        }
        return m.toString();
    }

    public void removeMember(LinkedList<Member>m){
        int memberId;
        System.out.println("Введите идентификатор пользователя: ");
        memberId=getIntInput();
        for(int i=0;i<m.size();i++){
            if(m.get(i).getMemberId()==memberId){
                m.remove(i);
            }
        }

    }
    public void printMemberInfo(LinkedList<Member>m){
        int memberId;
        System.out.println("Введите идентификатор пользователя: ");
        memberId=getIntInput();
        for (Member member : m) {
            if (member.getMemberId() == memberId) {
                System.out.println(member.toString());
            }
        }

    }


}
