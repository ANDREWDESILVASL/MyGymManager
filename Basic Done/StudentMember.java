public class StudentMember extends DefaultMember {
    //Fields of StudentMember Class
    private String schoolName;

    //Constructor
    public StudentMember (String c_schoolName, String c_memberName, String c_membershipNumber, Date c_membershipDate, String c_memberType){
        super(c_memberName,c_membershipNumber,c_membershipDate,c_memberType);
        schoolName = c_schoolName;
    }

    //Methods of StudentMember Class - Setter
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    //Methods of StudentMember Class - Getter
    public String getSchoolName() {
        return schoolName;
    }
}
