package com.sapient.entities;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Date;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Priyadarshan Singh
 * 
 */
@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@PersistenceUnit
@Slf4j
public class User {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "password")
    private byte[] password;

    @Column(name = "profile")
    private String profilePic;

    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "salt")
    private byte[] salt;

    @Column(name = "rating")
    private int rating;

    @Column(name = "createdon")
    private Date createdOn;

    public User() {
    }

    public User(String email, String password, String userName) {
        this.userName = userName;
        this.email = email;
        this.setPassword(password);
    }

    public User(String userName, int id, String email, int rating) {
        this.userName = userName;
        this.email = email;
        this.id = id;
        this.rating = rating;
    }

    public User(byte[] password, byte[] salt) {
        this.salt = salt;
        this.password = password;
    }

    public boolean setPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] randomSalt = new byte[16];
        random.nextBytes(randomSalt);

        this.salt = randomSalt;

        try {

            KeySpec spec = new PBEKeySpec(password.toCharArray(), randomSalt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            this.password = factory.generateSecret(spec).getEncoded();

            return true;

        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public boolean checkPassword(String password) {

        KeySpec spec = new PBEKeySpec(password.toCharArray(), this.getSalt(), 65536, 128);
        try {

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return Arrays.equals(this.getPassword(), factory.generateSecret(spec).getEncoded());

        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            return false;
        }

    }

}
