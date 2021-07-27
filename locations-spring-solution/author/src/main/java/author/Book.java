package author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberISBN;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public Book(String numberISBN, String title) {
        this.numberISBN = numberISBN;
        this.title = title;
    }
}
