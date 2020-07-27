public class Over60Member extends DefaultMember {
    //Fields of Over60Member Class
    private String age;

    //Constructor
    public Over60Member(String c_age, String c_memberName, String c_membershipNumber, Date c_membershipDate, String c_memberType){
        super(c_memberName,c_membershipNumber,c_membershipDate,c_memberType);
        age = c_age;
    }

    //Methods of Over60Member Class - Setter
    public void setAge(String age) {
        this.age = age;
    }

    //Methods of Over60Member Class - Getter
    public String getAge() {
        return age;
    }
}
