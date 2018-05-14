package javabeans;

import java.time.LocalDate;
import javabeans.Commentaire;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-14T14:25:25")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, String> titre;
    public static volatile SingularAttribute<Article, LocalDate> datePublication;
    public static volatile ListAttribute<Article, Commentaire> commentaires;
    public static volatile SingularAttribute<Article, Integer> id;

}