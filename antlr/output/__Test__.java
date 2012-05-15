import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        DCPU lex = new DCPU(new ANTLRFileStream("/home/porter/workspace/DCPU-Battle-Bots/antlr/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

 g = new (tokens, 49100, null);
        try {
            g.COMMENT_BEGIN();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}