package training.employee;


import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
public class MessageContext {

    public void addMessage(String message) {
        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(message));
// Redirect after post miatt
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .setKeepMessages(true);
    }
}
