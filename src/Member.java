public class Member {

    private char memberType;
    private int memberId;
    private String name;
    private double fees;
    public Member(char pMemberType, int pMemberId, String pName, double pFees){
        this.memberType=pMemberType;
        this.memberId=pMemberId;
        this.name=pName;
        this.fees=pFees;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public char getMemberType() {
        return memberType;
    }
    public void setMemberId(int memberId){
        this.memberId=memberId;
    }
    public int getMemberId(){
        return memberId;
    }
    public void setFees(double fees){
        this.fees=fees;
    }
    public double getFees(){
        return fees;
    }
    @Override
    public String toString() {
        return String.format("%s %d %s %f",
                memberType,memberId,name,fees);
    }
}
