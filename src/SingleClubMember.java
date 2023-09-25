
public class SingleClubMember extends Member {
    private int club;
    public SingleClubMember(char pMemberType, int pMemberId, String pName, double pFees, int pClub){
        super(pMemberType,pMemberId,pName, pFees);
        this.club=pClub;
    }
    public int getClub(){
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return String.format("Категория посетителя: %s \nУникальный номер посетителя: %d \nИмя посетителя: %s \nБаллы: %f \nИдентификатор клуба: %s",
                getMemberType(),getMemberId(),getName(),getFees(),club);
    }
}
