package Model;

import java.util.List;

public class Job {

    private String JobName;
    private String JobTitle;
    private String Dates;
    private List<String> Responsibilities;

    public Job(String jobName, String jobTitle, String dates, List<String> responsibilities) {
        JobName = jobName;
        JobTitle = jobTitle;
        Dates = dates;
        Responsibilities = responsibilities;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getDates() {
        return Dates;
    }

    public void setDates(String dates) {
        Dates = dates;
    }

    public List<String> getResponsibilities() {
        return Responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        Responsibilities = responsibilities;
    }
}
