package internetshop.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Transient
    private Long bucketId;

    private String token;

    private String name;

    private String surname;

    private String login;

    private String password;

    private byte[] salt;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bucket_id", referencedColumnName = "id", columnDefinition = "int4")
    private Bucket bucket;

    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", columnDefinition = "int4"),
            inverseJoinColumns = @JoinColumn(name = "role_id", columnDefinition = "int4"))
    private Set<Role> roles;

    public User(Long id, Long bucketId, String token,
                String name, String surname, String login, String password, byte[] salt) {
        this.id = id;
        this.bucketId = bucketId;
        this.token = token;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.salt = salt;
    }

    public User(String login, String password, byte[] salt,
                String name, String surname, Bucket bucket) {
        this.bucket = bucket;
        this.token = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.roles = new HashSet<>();
        addRole(new Role(1L, Role.RoleName.USER));
    }

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    @Deprecated
    public Long getBucketId() {
        return bucketId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return this.name + "_" + this.surname;
    }
}
