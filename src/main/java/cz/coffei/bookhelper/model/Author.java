package cz.coffei.bookhelper.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 5, max = 255)
    private String name;

    private String description;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> booksWritten;
}
