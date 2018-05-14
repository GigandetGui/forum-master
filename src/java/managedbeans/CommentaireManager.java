/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import facades.ArticleFacade;
import facades.CommentaireFacade;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Commentaire;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class CommentaireManager {

    private Commentaire commentaire;
    private List<Commentaire> lesCommentaires;
    
    @EJB
    private CommentaireFacade commentaireFacade;
    @EJB
    private ArticleFacade articleFacade;

    @PostConstruct
    public void init() {
        commentaire = new Commentaire();
        lesCommentaires = new ArrayList();
    }

    public String createCommentaire() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        try {
            articleFacade.find(commentaire.getArticle().getId()).getCommentaires().add(commentaire);
            commentaireFacade.create(commentaire);
            lesCommentaires.add(commentaire);
            commentaire = new Commentaire();
            return "toIndex";
        } catch (DateTimeException e) {
            message.setSummary("Erreur dans la date !");
            message.setSeverity(message.SEVERITY_ERROR);
            context.addMessage("ajoutCommentaire", message);
        }
        return "";
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public List<Commentaire> getLesCommentaires() {
        return lesCommentaires;
    }

    public void setLesCommentaires(List<Commentaire> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }

}
