package com.ashucodes.careerverse.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  name;

    private String experienceLevel;

    private String yearsofExperience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="job_seeker_profile")
    private JobSeekerProfile jobSeekerProfile;


    public Skills() {
    }

    public Skills(int id, String name, String experienceLevel, String yearsofExperience, JobSeekerProfile jobSeekerProfile) {
        this.id = id;
        this.name = name;
        this.experienceLevel = experienceLevel;
        this.yearsofExperience = yearsofExperience;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getYearsofExperience() {
        return yearsofExperience;
    }

    public void setYearsofExperience(String yearsofExperience) {
        this.yearsofExperience = yearsofExperience;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experienceLevel='" + experienceLevel + '\'' +
                ", yearsofExperience='" + yearsofExperience + '\'' +
                ", jobSeekerProfile=" + jobSeekerProfile +
                '}';
    }
}
