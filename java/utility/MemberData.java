package utility;

/**
 * Created by huangzhengyue on 5/21/16.
 */
public class MemberData {
    private String stuId;
    private String name;
    private String birthday;
    private String hobies;
    //constructor
    public MemberData(){

    }

    public MemberData(String stuId, String name, String birthday, String hobies) {
        this.stuId = stuId;
        this.name = name;
        this.birthday = birthday;
        this.hobies = hobies;
    }

    //getters & setters

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHobies() {
        return hobies;
    }

    public void setHobies(String hobies) {
        this.hobies = hobies;
    }
}
