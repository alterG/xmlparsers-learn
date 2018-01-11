package alterg.parser.jaxb;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@Setter
@ToString
@XmlRootElement(name = "Student")
@XmlType(propOrder = {"name", "age", "language"})
public class Student {

    private int id;
    private String name;
    private int age;
    private String language;
    private String password;

    public Student(int id, String name, int age, String language) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.language = language;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    @XmlElement(name = "lang")
    public String getLanguage() {
        return language;
    }


    @XmlTransient
    public String getPassword() {
        return password;
    }

}
