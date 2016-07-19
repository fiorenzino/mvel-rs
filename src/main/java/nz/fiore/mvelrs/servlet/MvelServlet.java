package nz.fiore.mvelrs.servlet;

import nz.fiore.mvelrs.servlet.util.RsCaller;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateCompiler;
import org.mvel2.templates.TemplateRuntime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fiorenzo on 19/07/16.
 */
@WebServlet(name = "MvelServlet", urlPatterns = {"/mvel/*"}
)
public class MvelServlet extends javax.servlet.http.HttpServlet {


    private static String MVEL_PATH = "docs/";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        RsCaller rsCaller = new RsCaller();
        Map<String, Object> contest = new HashMap<>();
        contest.put("rscaller", rsCaller);
        contest.put("request", req);

        CompiledTemplate compiled = TemplateCompiler.compileTemplate(new File(MVEL_PATH + action));
        TemplateRuntime.execute(compiled, contest, resp.getOutputStream());
    }
}
