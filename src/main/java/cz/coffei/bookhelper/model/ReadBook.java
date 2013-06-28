package cz.coffei.bookhelper.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Coffei
 * Date: 28.6.13
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ReadBook {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Date date;

    @ManyToOne(optional = false)
    @NotNull
    private Book book;

    @ManyToOne(optional = false)
    @NotNull
    private Member member;

    @DecimalMax(value = "10")
    @DecimalMin(value = "0")
    private int rating;

}
