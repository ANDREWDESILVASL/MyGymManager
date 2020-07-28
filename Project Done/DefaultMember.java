public class DefaultMember {
    //Fields of Default Member
    private String memberName;
    private String membershipNumber;
    private Date memberShipDate;
    private String memberType;

    //Constructor
    public DefaultMember(String c_memberName, String c_membershipNumber, Date c_membershipDate, String c_memberType){
        memberName = c_memberName;
        membershipNumber = c_membershipNumber;
        memberShipDate = c_membershipDate;
        memberType = c_memberType;

    }

    //Methods of Default Member Class - Setter
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public void setMemberShipDate(Date memberShipDate) {
        this.memberShipDate = memberShipDate;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    //Methods of Default Member Class - Getter
    public String getMemberName() {
        return memberName;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public Date getMemberShipDate() {
        return memberShipDate;
    }

    public String getMemberType() {
        return memberType;
    }
}
