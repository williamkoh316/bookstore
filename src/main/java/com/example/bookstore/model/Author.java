package com.example.bookstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Author")
@IdClass(AuthorIdPK.class)
@NoArgsConstructor
public class Author implements Comparable<Author>{
	@Id
	private String name;
	@Id
	private Date birthday;
	
	@ManyToMany(mappedBy = "authors")
//	@ManyToMany(targetEntity = Book.class, cascade = CascadeType.ALL, mappedBy = "authors" )
	private List<Book> books = new ArrayList<>();
	
	public Author(String name, Date birthday){
		this.name = name;
		this.birthday = birthday;
	}

	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getName(), author.getName()) &&
                Objects.equals(getBirthday(), author.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday());
    }


	@Override
	public int compareTo(Author o) {
		return name.compareTo(o.getName());
	}

}
