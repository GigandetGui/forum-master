package javabeans;

import java.time.LocalDate;
import javabeans.Article;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-14T14:25:25")
@StaticMetamodel(Commentaire.class)
public class Commentaire_ { 

    public static volatile SingularAttribute<Commentaire, String> titre;
    public static volatile SingularAttribute<Commentaire, LocalDate> datePublication;
    public static volatile SingularAttribute<Commentaire, Integer> id;
    public static volatile SingularAttribute<Commentaire, String> urlImg;
    public static volatile SingularAttribute<Commentaire, String> contenu;
    public static volatile SingularAttribute<Commentaire, Article> article;

}