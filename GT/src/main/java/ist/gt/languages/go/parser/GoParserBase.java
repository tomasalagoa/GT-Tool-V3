package ist.gt.languages.go.parser;

// From https://raw.githubusercontent.com/antlr/grammars-v4/master/golang/Java/GoParserBase.java

import java.util.List;
import org.antlr.v4.runtime.*;

/**
 * All parser methods that used in grammar (p, prev, notLineTerminator, etc.)
 * should start with lower case char similar to parser rules.
 */
public abstract class GoParserBase extends Parser
{
    protected GoParserBase(TokenStream input) {
        super(input);
    }


    /**
     * Returns true if the current Token is a closing bracket (")" or "}")
     */
    protected boolean closingBracket()
    {
        BufferedTokenStream stream = (BufferedTokenStream)_input;
        int prevTokenType = stream.LA(1);
        
        return prevTokenType == GoParser.R_CURLY || prevTokenType == GoParser.R_PAREN;
    }
}
