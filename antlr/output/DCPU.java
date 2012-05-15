// $ANTLR 3.4 /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g 2012-05-11 02:41:16

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DCPU extends Lexer {
    public static final int EOF=-1;
    public static final int COMMENT_BEGIN=4;
    public static final int DIGIT=5;
    public static final int LABEL=6;
    public static final int LETTER=7;
    public static final int LITERAL=8;
    public static final int OPCODE=9;
    public static final int OPERAND=10;
    public static final int REGISTER=11;
    public static final int WS=12;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public DCPU() {} 
    public DCPU(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DCPU(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g"; }

    // $ANTLR start "LABEL"
    public final void mLABEL() throws RecognitionException {
        try {
            int _type = LABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:3:7: ( ( '_' | LETTER | DIGIT )+ ':' )
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:3:9: ( '_' | LETTER | DIGIT )+ ':'
            {
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:3:9: ( '_' | LETTER | DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LABEL"

    // $ANTLR start "OPCODE"
    public final void mOPCODE() throws RecognitionException {
        try {
            int _type = OPCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:6:2: ( 'SET' | 'ADD' | 'SUB' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='S') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='E') ) {
                    alt2=1;
                }
                else if ( (LA2_1=='U') ) {
                    alt2=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0=='A') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:6:4: 'SET'
                    {
                    match("SET"); 



                    }
                    break;
                case 2 :
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:6:12: 'ADD'
                    {
                    match("ADD"); 



                    }
                    break;
                case 3 :
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:6:20: 'SUB'
                    {
                    match("SUB"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPCODE"

    // $ANTLR start "OPERAND"
    public final void mOPERAND() throws RecognitionException {
        try {
            int _type = OPERAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:8:2: ( REGISTER | LITERAL | ( '[' )+ ( REGISTER )+ ']' | ( '[' )+ ( LITERAL )+ ']' )
            int alt7=4;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:8:4: REGISTER
                    {
                    mREGISTER(); 


                    }
                    break;
                case 2 :
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:9:5: LITERAL
                    {
                    mLITERAL(); 


                    }
                    break;
                case 3 :
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:10:5: ( '[' )+ ( REGISTER )+ ']'
                    {
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:10:5: ( '[' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='[') ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:10:5: '['
                    	    {
                    	    match('['); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:10:11: ( REGISTER )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= 'A' && LA4_0 <= 'B')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:
                    	    {
                    	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'B') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match(']'); 

                    }
                    break;
                case 4 :
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:11:5: ( '[' )+ ( LITERAL )+ ']'
                    {
                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:11:5: ( '[' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='[') ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:11:5: '['
                    	    {
                    	    match('['); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:11:11: ( LITERAL )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='1') ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:
                    	    {
                    	    if ( input.LA(1)=='1' ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    match(']'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPERAND"

    // $ANTLR start "REGISTER"
    public final void mREGISTER() throws RecognitionException {
        try {
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:13:2: ( 'A' | 'B' )
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'B') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REGISTER"

    // $ANTLR start "LITERAL"
    public final void mLITERAL() throws RecognitionException {
        try {
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:15:2: ( '1' )
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:15:4: '1'
            {
            match('1'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LITERAL"

    // $ANTLR start "COMMENT_BEGIN"
    public final void mCOMMENT_BEGIN() throws RecognitionException {
        try {
            int _type = COMMENT_BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:17:2: ( ';' )
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:17:4: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT_BEGIN"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:19:2: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:22:2: ( '0' .. '9' )
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:24:2: ( ( ' ' | '\\r' | '\\t' | '\\u000C' ) )
            // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:
            {
            if ( input.LA(1)=='\t'||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:1:8: ( LABEL | OPCODE | OPERAND | COMMENT_BEGIN )
        int alt8=4;
        switch ( input.LA(1) ) {
        case 'S':
            {
            switch ( input.LA(2) ) {
            case 'E':
                {
                int LA8_8 = input.LA(3);

                if ( (LA8_8=='T') ) {
                    int LA8_11 = input.LA(4);

                    if ( ((LA8_11 >= '0' && LA8_11 <= ':')||(LA8_11 >= 'A' && LA8_11 <= 'Z')||LA8_11=='_'||(LA8_11 >= 'a' && LA8_11 <= 'z')) ) {
                        alt8=1;
                    }
                    else {
                        alt8=2;
                    }
                }
                else if ( ((LA8_8 >= '0' && LA8_8 <= ':')||(LA8_8 >= 'A' && LA8_8 <= 'S')||(LA8_8 >= 'U' && LA8_8 <= 'Z')||LA8_8=='_'||(LA8_8 >= 'a' && LA8_8 <= 'z')) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 8, input);

                    throw nvae;

                }
                }
                break;
            case 'U':
                {
                int LA8_9 = input.LA(3);

                if ( (LA8_9=='B') ) {
                    int LA8_12 = input.LA(4);

                    if ( ((LA8_12 >= '0' && LA8_12 <= ':')||(LA8_12 >= 'A' && LA8_12 <= 'Z')||LA8_12=='_'||(LA8_12 >= 'a' && LA8_12 <= 'z')) ) {
                        alt8=1;
                    }
                    else {
                        alt8=2;
                    }
                }
                else if ( ((LA8_9 >= '0' && LA8_9 <= ':')||LA8_9=='A'||(LA8_9 >= 'C' && LA8_9 <= 'Z')||LA8_9=='_'||(LA8_9 >= 'a' && LA8_9 <= 'z')) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 9, input);

                    throw nvae;

                }
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case ':':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt8=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 1, input);

                throw nvae;

            }

            }
            break;
        case 'A':
            {
            switch ( input.LA(2) ) {
            case 'D':
                {
                int LA8_10 = input.LA(3);

                if ( (LA8_10=='D') ) {
                    int LA8_13 = input.LA(4);

                    if ( ((LA8_13 >= '0' && LA8_13 <= ':')||(LA8_13 >= 'A' && LA8_13 <= 'Z')||LA8_13=='_'||(LA8_13 >= 'a' && LA8_13 <= 'z')) ) {
                        alt8=1;
                    }
                    else {
                        alt8=2;
                    }
                }
                else if ( ((LA8_10 >= '0' && LA8_10 <= ':')||(LA8_10 >= 'A' && LA8_10 <= 'C')||(LA8_10 >= 'E' && LA8_10 <= 'Z')||LA8_10=='_'||(LA8_10 >= 'a' && LA8_10 <= 'z')) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 10, input);

                    throw nvae;

                }
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case ':':
            case 'A':
            case 'B':
            case 'C':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt8=1;
                }
                break;
            default:
                alt8=3;
            }

            }
            break;
        case 'B':
            {
            int LA8_3 = input.LA(2);

            if ( ((LA8_3 >= '0' && LA8_3 <= ':')||(LA8_3 >= 'A' && LA8_3 <= 'Z')||LA8_3=='_'||(LA8_3 >= 'a' && LA8_3 <= 'z')) ) {
                alt8=1;
            }
            else {
                alt8=3;
            }
            }
            break;
        case '1':
            {
            int LA8_4 = input.LA(2);

            if ( ((LA8_4 >= '0' && LA8_4 <= ':')||(LA8_4 >= 'A' && LA8_4 <= 'Z')||LA8_4=='_'||(LA8_4 >= 'a' && LA8_4 <= 'z')) ) {
                alt8=1;
            }
            else {
                alt8=3;
            }
            }
            break;
        case '0':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt8=1;
            }
            break;
        case '[':
            {
            alt8=3;
            }
            break;
        case ';':
            {
            alt8=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }

        switch (alt8) {
            case 1 :
                // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:1:10: LABEL
                {
                mLABEL(); 


                }
                break;
            case 2 :
                // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:1:16: OPCODE
                {
                mOPCODE(); 


                }
                break;
            case 3 :
                // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:1:23: OPERAND
                {
                mOPERAND(); 


                }
                break;
            case 4 :
                // /home/porter/workspace/DCPU-Battle-Bots/antlr/DCPU.g:1:31: COMMENT_BEGIN
                {
                mCOMMENT_BEGIN(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\6\uffff";
    static final String DFA7_eofS =
        "\6\uffff";
    static final String DFA7_minS =
        "\1\61\2\uffff\1\61\2\uffff";
    static final String DFA7_maxS =
        "\1\133\2\uffff\1\133\2\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\3\1\4";
    static final String DFA7_specialS =
        "\6\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\2\17\uffff\2\1\30\uffff\1\3",
            "",
            "",
            "\1\5\17\uffff\2\4\30\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "7:1: OPERAND : ( REGISTER | LITERAL | ( '[' )+ ( REGISTER )+ ']' | ( '[' )+ ( LITERAL )+ ']' );";
        }
    }
 

}