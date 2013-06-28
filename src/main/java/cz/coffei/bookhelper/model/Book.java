package cz.coffei.bookhelper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, max= 255)
    private String name;

    private String description;

    @ManyToOne(optional = false)
    @NotNull
    private Author author;
}
