package org.zerock.jdbc.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object obj = event.getValue();
        if (name.equals("logInfo")) {
            log.info("A user logged in.");
            log.info(obj);
        }
    }
}
