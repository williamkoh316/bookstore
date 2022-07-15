package com.example.bookstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorIdPK implements Serializable{
	
	private String name;
	private Date birthday;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorIdPK)) return false;
        AuthorIdPK authorId = (AuthorIdPK) o;
        return Objects.equals(getName(), authorId.getName()) &&
                Objects.equals(getBirthday(), authorId.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday());
    }

}
