public class MultiClubMember extends Member {
    private int membershipPoints;
    public MultiClubMember(char pMemberType, int pMemberId, String pName, double pFees, int pMembershipPoints){
        super(pMemberType,pMemberId,pName, pFees);
        this.membershipPoints=pMembershipPoints;
    }
    public int getMembershipPoints(){
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return String.format("Категория посетителя: %s \nУникальный номер посетителя: %d \nИмя посетителя: %s \nОплата: %f \nБаллы: %s",
                getMemberType(),getMemberId(),getName(),getFees(),membershipPoints);
    }
}
