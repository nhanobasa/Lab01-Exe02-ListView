package td.nhan.lab01_exe02_listview.model;

public class Job {
    private int resImg;
    private String name;
    private Long salary;
    private String dateCreated;

    public Job(int resImg, String name, Long salary, String dateCreated) {
        this.resImg = resImg;
        this.name = name;
        this.salary = salary;
        this.dateCreated = dateCreated;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Job{" +
                "resImg=" + resImg +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
