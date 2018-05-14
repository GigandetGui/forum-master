/*
 * To change this license header, choose License Headers in Article Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

/**
 *
 * @author Admin
 */
@Entity
@Table(name="commentaire")
public class Commentaire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_commentaire")
    private int id;
    @Column(name="titre_commentaire")
    private String titre;
    @Column(name="contenu_commentaire")
    private String contenu;
    @Column(name="lien_image")
    private String urlImg;
    @Column(name = "dte_publication")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate datePublication;

    
    @ManyToOne
    @JoinColumn(name="fk_article")
    private Article article;
    
    public Commentaire() {
    }

    public Commentaire(int id, String titre, String contenu, String urlImg, LocalDate datePublication, Article article) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.urlImg = urlImg;
        this.datePublication = datePublication;
        this.article = article;
    }
    public String getContenu() {
        return contenu;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getDatePublication() {
        return datePublication.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void setDatePublication() {
         this.datePublication = LocalDate.now();
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commentaire)) return false;
        Commentaire commentaire = (Commentaire) o;
        return Objects.equals(getId(), commentaire.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
