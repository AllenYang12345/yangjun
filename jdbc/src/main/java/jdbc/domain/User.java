package jdbc.domain;

/**
 * Created by Allen Yang
 * 2018/4/29 15:02
 */
public class User {
    private Integer id;
    private String name;
    private String QQ;
    private String train_major;
    private Long admiss_time;
    private String graduate_school;
    private String online_number;
    private String Daily_link;
    private String oath;
    private String coaching_senior;
    private String where_know;
    private Long create_at;
    private Long update_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getTrain_major() {
        return train_major;
    }

    public void setTrain_major(String train_major) {
        this.train_major = train_major;
    }

    public Long getAdmiss_time() {
        return admiss_time;
    }

    public void setAdmiss_time(Long admiss_time) {
        this.admiss_time = admiss_time;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public String getOnline_number() {
        return online_number;
    }

    public void setOnline_number(String online_number) {
        this.online_number = online_number;
    }

    public String getDaily_link() {
        return Daily_link;
    }

    public void setDaily_link(String daily_link) {
        Daily_link = daily_link;
    }

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath;
    }

    public String getCoaching_senior() {
        return coaching_senior;
    }

    public void setCoaching_senior(String coaching_senior) {
        this.coaching_senior = coaching_senior;
    }

    public String getWhere_know() {
        return where_know;
    }

    public void setWhere_know(String where_know) {
        this.where_know = where_know;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }
}
