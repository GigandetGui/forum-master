/*
 * To change this license header, choose License Headers in Article Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

/**
 *
 * @author Admin
 */
@Entity
@Table(name="article")
public class Article implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private int id;
    @Column(name = "titre_article")
    private String titre;
    @Column(name = "dte_publication")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate datePublication;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="article")
    private List<Commentaire> commentaires;
    
    public Article() {
    }

    public Article(int id, String titre, LocalDate datePublication) {
        this.id = id;
        this.titre = titre;
        this.datePublication = datePublication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDatePublication() {
        return datePublication.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void setDatePublication() {
        this.datePublication = LocalDate.now();
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getId(), article.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    
}
