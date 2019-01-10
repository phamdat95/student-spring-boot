package com.example.bootemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(max = 10)
    private String code;
    @NotEmpty
    @Size(max = 200)
    private String firstName;
    @NotEmpty
    @Size(max = 200)
    private String lastName;
    @NotEmpty
    @Size(max = 200)
    private String address;
    @NotEmpty
    @Pattern(regexp = "^$|[0-9]{10}", message = " size must be 10 and style must be integer")
    private String numberPhone;
    @NotEmpty
    @Pattern(regexp = "^$|[5,6,7,8,9,10,11]", message = " 5 to 10 and style must be integer")
    private String averageGrade;
    @NotEmpty
    @Pattern(regexp = "^$|[0,1,2,3,4]", message = " size must be 0 to 3 and style must be integer")
    private String status;

    private String email;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    private String note;

    private String description;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id")
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(String averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student() {
    }

    public Student(@NotEmpty @Size(max = 10) String code, @NotEmpty @Size(max = 200) String firstName, @NotEmpty @Size(max = 200) String lastName, @NotEmpty @Size(max = 200) String address, @NotEmpty @Pattern(regexp = "^$|[0-9]{10}", message = " size must be 10 and style must be integer") String numberPhone, @NotEmpty @Pattern(regexp = "^$|[0-9]{5,10}", message = " size must be 5 to 10 and style must be integer") String averageGrade, @NotEmpty @Pattern(regexp = "^$|[0-9]{0,3}", message = " size must be 0 to 3 and style must be integer") String status, @NotEmpty String email, @NotEmpty String note, @NotEmpty String description, Department department) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.numberPhone = numberPhone;
        this.averageGrade = averageGrade;
        this.status = status;
        this.email = email;
        this.note = note;
        this.description = description;
        this.department = department;
    }
}
