/*
 * To change this license header, choose License Headers in Article Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import facades.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javabeans.Article;
import javabeans.Commentaire;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class EntityManager implements Serializable
{

   private List<Commentaire> commentaires;
   private List<Article> articles;
   private Commentaire commentaire;
   private Commentaire commentaireToAdd;
   private Article article;
   private Article articleToAdd;

   @EJB
   private CommentaireFacade commentaireFacade;
   @EJB
   private ArticleFacade articleFacade;

   @PostConstruct
   public void init()
   {
      articleToAdd = new Article();
      commentaireToAdd = new Commentaire();
   }

   public void createArticle(ActionEvent actionEvent)
   {
      articleToAdd.setDatePublication();
      articleFacade.create(articleToAdd);
      articleToAdd = new Article();
      addMessage("Article ajouté avec succès !");
   }

   public void createCommentaire(ActionEvent actionEvent)
   {
      commentaireToAdd.setDatePublication();
      commentaireToAdd.setArticle(article);
      commentaireFacade.create(commentaireToAdd);
      article.getCommentaires().add(commentaireToAdd);
      articleFacade.edit(article);
      commentaireToAdd = new Commentaire();
      addMessage("Commentaire ajouté avec succès !");
   }

   public void deleteCommentaire(Commentaire comm)
   {
      commentaireFacade.remove(comm);
      commentaires.remove(comm);
   }

   public void deleteArticle(Article art)
   {
      articleFacade.remove(art);
      articles.remove(art);
   }

   public String editCommentaire(Commentaire comm)
   {
      commentaire = comm;
      return "toShowCommentaire";
   }
   public String editArticle(Article art)
   {
      article = art;
      return "toShowArticle";
   }
   public String updateCommentaire()
   {
      commentaireFacade.edit(commentaire);
      return "toIndex";
   }
      public String updateArticle()
   {
      articleFacade.edit(article);
      return "toIndex";
   }

   public void editArticle()
   {
//        articleToAdd.setDatePublication();
//        articleToAdd.setArticle(article);
//        articleFacade.create(commentaireToAdd);
//        article.getCommentaires().add(commentaireToAdd);
//        articleFacade.edit(article);
//        commentaireToAdd = new Commentaire();
//        addMessage("Article modifié avec succès !");
   }

   public void addMessage(String summary)
   {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
      FacesContext.getCurrentInstance().addMessage(null, message);
   }

   public List<Article> getArticles()
   {
      try
      {
         articles = articleFacade.findAll();
         return articles;

      } catch (EJBException ee)
      {
         return articles = new ArrayList<>();
      }
   }

   public void setArticles(List<Article> articles)
   {
      this.articles = articles;
   }

   public List<Commentaire> getCommentaires()
   {
      return commentaires;
   }

   public void setCommentaires(List<Commentaire> commentaires)
   {
      this.commentaires = commentaires;
   }

   public Commentaire getCommentaire()
   {
      return commentaire;
   }

   public void setCommentaire(Commentaire commentaire)
   {
      this.commentaire = commentaire;
   }

   public Article getArticle()
   {
      return article;
   }

   public void setArticle(Article article)
   {
      this.article = article;
   }

   public Article getArticleToAdd()
   {
      return articleToAdd;
   }

   public void setArticleToAdd(Article articleToAdd)
   {
      this.articleToAdd = articleToAdd;
   }

   public Commentaire getCommentaireToAdd()
   {
      return commentaireToAdd;
   }

   public void setCommentaireToAdd(Commentaire commentaireToAdd)
   {
      this.commentaireToAdd = commentaireToAdd;
   }

}
