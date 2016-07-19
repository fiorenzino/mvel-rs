import nz.fiore.mvelrs.servlet.util.RsCaller;
import org.junit.Test;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateCompiler;
import org.mvel2.templates.TemplateRuntime;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by fiorenzo on 19/07/16.
 */

public class SimpleTest {
    @Test
    public void testOutputStream1() {
        final StringBuilder sb = new StringBuilder();
        OutputStream outstream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                sb.append((char) b);
            }
        };
        String template = "@foreach{item:['foo','far']}@{item}@end{}";
        CompiledTemplate compiled = TemplateCompiler.compileTemplate(template);
        TemplateRuntime.execute(compiled, new HashMap(), outstream);
        assertEquals("foofar", sb.toString());
    }

    @Test
    public void fromFile() throws Exception {

        Map<String, Object> contest = new HashMap<>();
        contest.put("list", News.list());
        contest.put("single", new News(0L, "nome1", "conten1"));
        CompiledTemplate compiled = TemplateCompiler.compileTemplate(new File("docs/template.mvl"));
        Object result = TemplateRuntime.execute(compiled, contest);
        System.out.println(result.toString());

    }

    @Test
    public void fromFileRest() throws Exception {
        RsCaller rsCaller = new RsCaller();
        Map<String, Object> contest = new HashMap<>();
        contest.put("rscaller", rsCaller);
        Map<String, String[]> request = new HashMap<>();
        request.put("id", new String[]{"33"});
        contest.put("request", request);
        CompiledTemplate compiled = TemplateCompiler.compileTemplate(new File("docs/template.mvl"));
        Object result = TemplateRuntime.execute(compiled, contest);
        System.out.println(result.toString());

    }


}
