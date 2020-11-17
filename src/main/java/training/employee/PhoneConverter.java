package training.employee;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Phone.class)
public class PhoneConverter implements Converter<Phone> {

    @Override
    public Phone getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        String[] parts = s.split("-");
        String prefix = parts[0];
        String number = parts[1];
        return new Phone(prefix, number);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Phone phone) {
        return phone.getPrefix() + "-" + phone.getNumber();
    }
}
