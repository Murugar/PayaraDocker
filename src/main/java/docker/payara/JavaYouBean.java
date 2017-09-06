package docker.payara;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.core.UriBuilder;


@Named
@RequestScoped
public class JavaYouBean {

    private String text1;
    private String text2;
    private String imageUrl;
  

    @Inject
    private EntityManager em;
    @Inject
    private Event<JavaYouEvent> event;

 
    @PostConstruct
    public void init() {
        text1 = "JAVA";
        text2 = "TEST";
        buildImageUrl();
    }

   

    private void buildImageUrl() {
        imageUrl = UriBuilder.fromPath("/api/generate")
                .queryParam("text1", text1)
                .queryParam("text2", text2)
                .build().toString();
    }

    @NotNull
    @Size(min = 1)
    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    @NotNull
    @Size(min = 1)
    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

   
}
