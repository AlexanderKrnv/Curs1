import java.io.*;
import java.util.LinkedList;

public class FileHandler {
    public LinkedList<Member> readFile() {
        LinkedList<Member> members = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("members.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                char memberType = data[0].charAt(0);
                int memberId = Integer.parseInt(data[1]);
                String name = data[2];
                double fees = Double.parseDouble(data[3]);

                if (memberType == 'S') {
                    int clubId = Integer.parseInt(data[4]);
                    members.add(new SingleClubMember(memberType, memberId, name, fees, clubId));
                } else if (memberType == 'M') {
                    int points = Integer.parseInt(data[4]);
                    members.add(new MultiClubMember(memberType, memberId, name, fees, points));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return members;
    }

    public void appendFile(String mem) {
        try {
            FileWriter fileWriter = new FileWriter("members.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(mem);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void overWriteFile(LinkedList<Member> membersList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("members.csv"))) {
            for (Member member : membersList) {
                StringBuilder sb = new StringBuilder();
                sb.append(member.getMemberType()).append(",").append(member.getMemberId()).append(",").append(member.getName()).append(",").append(member.getFees());
                if (member instanceof SingleClubMember) {
                    sb.append(",").append(((SingleClubMember) member).getClub());
                } else if (member instanceof MultiClubMember) {
                    sb.append(",").append(((MultiClubMember) member).getMembershipPoints());
                }
                sb.append("\n");
                bw.write(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}