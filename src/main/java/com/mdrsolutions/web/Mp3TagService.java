/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web;

import com.mdrsolutions.web.mp3.MP3ReadDirectory;
import com.mdrsolutions.web.mp3.model.MP3Tag;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author michael
 */
public class Mp3TagService extends AbstractHandler {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new Mp3TagService());
        server.start();
        server.join();
    }

    public void handle(String string, Request rqst, HttpServletRequest hsr, HttpServletResponse hsr1) throws IOException, ServletException {
        hsr1.setContentType("application/json; charset=UTF-8");
        hsr1.setStatus(HttpServletResponse.SC_OK);
        rqst.setHandled(true);
        String location = rqst.getParameter("loc");
        ApplicationContext ac = ApplicationContextUtils.getApplicationContext();
        MP3ReadDirectory readDirectory = (MP3ReadDirectory) ac.getBean("mp3ReadDirectory");

        if (null != location) {
            List<MP3Tag> readMP3Directory = readDirectory.readMP3Directory(location);
            ObjectMapper mapper = new ObjectMapper();

            hsr1.getWriter().println(mapper.writeValueAsString(readMP3Directory));
        } else {
            hsr1.getWriter().println("");
        }
    }

    private boolean validateRequestParam(String requestParam) {
        boolean flag = true;
        return flag;
    }
}
