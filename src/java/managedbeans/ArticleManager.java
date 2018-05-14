/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import facades.ArticleFacade;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Article;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class ArticleManager {

    private Article article;
    private List<Article> lesArticles;
    
    @EJB
    private ArticleFacade articleFacade;

    @PostConstruct
    public void init() {
        article = new Article();
    }

    public String createArticle() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        try {
            articleFacade.create(article);
            lesArticles.add(article);
            article = new Article();
            return "toIndex";
        } catch (DateTimeException e) {
            message.setSummary("Erreur dans la date !");
            message.setSeverity(message.SEVERITY_ERROR);
            context.addMessage("ajoutArticle", message);
        }
        return "";
    }
    
  /*  public String showCommentaire(Article a ){
        article = a;
        return "toShowCommentaire";
    }*/

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Article> getLesArticles() {
        try {
            return lesArticles = articleFacade.findAll();
        } catch (EJBException ee) {
            return lesArticles = new ArrayList<>();
        }
    }

    public void setLesArticles(List<Article> lesArticles) {
        this.lesArticles = lesArticles;
    }

}
