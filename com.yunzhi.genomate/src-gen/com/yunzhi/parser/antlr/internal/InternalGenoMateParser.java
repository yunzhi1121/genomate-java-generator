package com.yunzhi.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.yunzhi.services.GenoMateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGenoMateParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_LESS", "RULE_GREATER", "RULE_LBRACKET", "RULE_RBRACKET", "RULE_INT", "RULE_DECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'global'", "'{'", "'package:'", "'defaultAnnotations'", "'}'", "'model'", "';'", "'@'", "'('", "')'", "','", "'='", "'generate'", "'po'", "'for'", "'Serializable'", "'lombok:'", "'mybatis-plus:'", "'fieldAnnotations'", "'fieldAdd'", "'dto'", "'vo'", "'fieldExclude'", "'excludeAll:'", "'fieldValidation'", "'fieldJackson'", "'*'", "':'", "'single:'", "'local:'", "'foreach'", "'field'", "'global:'", "'set'", "'to'", "'if'", "'||'", "'&&'", "'type'", "'=='", "'!='", "'var'", "'+'", "'-'", "'static'", "'final'", "'mapping'", "'from'", "'Model'", "'VO'", "'target.all'", "'source.all'", "'DTO'", "'target.'", "'source.'", "'true'", "'false'", "'.'", "'AssertFalse'", "'AssertTrue'", "'DecimalMax'", "'DecimalMin'", "'Digits'", "'Email'", "'Future'", "'FutureOrPresent'", "'Max'", "'Min'", "'Negative'", "'NegativeOrZero'", "'NotBlank'", "'NotEmpty'", "'NotNull'", "'Null'", "'Past'", "'PastOrPresent'", "'Pattern'", "'Positive'", "'PositiveOrZero'", "'Size'", "'KeySequence'", "'TableName'", "'OrderBy'", "'TableField'", "'TableId'", "'TableLogic'", "'Version'", "'JsonAlias'", "'JsonAnyGetter'", "'JsonAnySetter'", "'JsonAutoDetect'", "'JsonDeserialize'", "'JsonFormat'", "'JsonIgnore'", "'JsonIgnoreProperties'", "'JsonInclude'", "'JsonRootName'", "'JsonSerialize'", "'JsonTypeInfo'", "'JsonUnwrapped'", "'JsonValue'", "'JsonView'", "'JsonProperty'", "'Accessors'", "'AllArgsConstructor'", "'Builder'", "'Data'", "'EqualsAndHashCode'", "'Getter'", "'NoArgsConstructor'", "'RequiredArgsConstructor'", "'Setter'", "'Singular'", "'SuperBuilder'", "'ToString'", "'int'", "'long'", "'Integer'", "'Double'", "'String'", "'LocalDate'", "'LocalDateTime'", "'BigDecimal'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=10;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int RULE_LBRACKET=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_GREATER=7;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int RULE_LESS=6;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;
    public static final int RULE_RBRACKET=9;

    // delegates
    // delegators


        public InternalGenoMateParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGenoMateParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGenoMateParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGenoMate.g"; }



     	private GenoMateGrammarAccess grammarAccess;

        public InternalGenoMateParser(TokenStream input, GenoMateGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "GenoMate";
       	}

       	@Override
       	protected GenoMateGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGenoMate"
    // InternalGenoMate.g:65:1: entryRuleGenoMate returns [EObject current=null] : iv_ruleGenoMate= ruleGenoMate EOF ;
    public final EObject entryRuleGenoMate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenoMate = null;


        try {
            // InternalGenoMate.g:65:49: (iv_ruleGenoMate= ruleGenoMate EOF )
            // InternalGenoMate.g:66:2: iv_ruleGenoMate= ruleGenoMate EOF
            {
             newCompositeNode(grammarAccess.getGenoMateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenoMate=ruleGenoMate();

            state._fsp--;

             current =iv_ruleGenoMate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenoMate"


    // $ANTLR start "ruleGenoMate"
    // InternalGenoMate.g:72:1: ruleGenoMate returns [EObject current=null] : ( ( (lv_globalConfig_0_0= ruleGlobalConfig ) )? ( (lv_model_1_0= ruleModel ) ) ( (lv_generateSection_2_0= ruleGenerateSection ) ) ( (lv_mappings_3_0= ruleMapping ) )* ) ;
    public final EObject ruleGenoMate() throws RecognitionException {
        EObject current = null;

        EObject lv_globalConfig_0_0 = null;

        EObject lv_model_1_0 = null;

        EObject lv_generateSection_2_0 = null;

        EObject lv_mappings_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:78:2: ( ( ( (lv_globalConfig_0_0= ruleGlobalConfig ) )? ( (lv_model_1_0= ruleModel ) ) ( (lv_generateSection_2_0= ruleGenerateSection ) ) ( (lv_mappings_3_0= ruleMapping ) )* ) )
            // InternalGenoMate.g:79:2: ( ( (lv_globalConfig_0_0= ruleGlobalConfig ) )? ( (lv_model_1_0= ruleModel ) ) ( (lv_generateSection_2_0= ruleGenerateSection ) ) ( (lv_mappings_3_0= ruleMapping ) )* )
            {
            // InternalGenoMate.g:79:2: ( ( (lv_globalConfig_0_0= ruleGlobalConfig ) )? ( (lv_model_1_0= ruleModel ) ) ( (lv_generateSection_2_0= ruleGenerateSection ) ) ( (lv_mappings_3_0= ruleMapping ) )* )
            // InternalGenoMate.g:80:3: ( (lv_globalConfig_0_0= ruleGlobalConfig ) )? ( (lv_model_1_0= ruleModel ) ) ( (lv_generateSection_2_0= ruleGenerateSection ) ) ( (lv_mappings_3_0= ruleMapping ) )*
            {
            // InternalGenoMate.g:80:3: ( (lv_globalConfig_0_0= ruleGlobalConfig ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalGenoMate.g:81:4: (lv_globalConfig_0_0= ruleGlobalConfig )
                    {
                    // InternalGenoMate.g:81:4: (lv_globalConfig_0_0= ruleGlobalConfig )
                    // InternalGenoMate.g:82:5: lv_globalConfig_0_0= ruleGlobalConfig
                    {

                    					newCompositeNode(grammarAccess.getGenoMateAccess().getGlobalConfigGlobalConfigParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_globalConfig_0_0=ruleGlobalConfig();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGenoMateRule());
                    					}
                    					set(
                    						current,
                    						"globalConfig",
                    						lv_globalConfig_0_0,
                    						"com.yunzhi.GenoMate.GlobalConfig");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalGenoMate.g:99:3: ( (lv_model_1_0= ruleModel ) )
            // InternalGenoMate.g:100:4: (lv_model_1_0= ruleModel )
            {
            // InternalGenoMate.g:100:4: (lv_model_1_0= ruleModel )
            // InternalGenoMate.g:101:5: lv_model_1_0= ruleModel
            {

            					newCompositeNode(grammarAccess.getGenoMateAccess().getModelModelParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_model_1_0=ruleModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGenoMateRule());
            					}
            					set(
            						current,
            						"model",
            						lv_model_1_0,
            						"com.yunzhi.GenoMate.Model");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:118:3: ( (lv_generateSection_2_0= ruleGenerateSection ) )
            // InternalGenoMate.g:119:4: (lv_generateSection_2_0= ruleGenerateSection )
            {
            // InternalGenoMate.g:119:4: (lv_generateSection_2_0= ruleGenerateSection )
            // InternalGenoMate.g:120:5: lv_generateSection_2_0= ruleGenerateSection
            {

            					newCompositeNode(grammarAccess.getGenoMateAccess().getGenerateSectionGenerateSectionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_generateSection_2_0=ruleGenerateSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGenoMateRule());
            					}
            					set(
            						current,
            						"generateSection",
            						lv_generateSection_2_0,
            						"com.yunzhi.GenoMate.GenerateSection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:137:3: ( (lv_mappings_3_0= ruleMapping ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==62) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGenoMate.g:138:4: (lv_mappings_3_0= ruleMapping )
            	    {
            	    // InternalGenoMate.g:138:4: (lv_mappings_3_0= ruleMapping )
            	    // InternalGenoMate.g:139:5: lv_mappings_3_0= ruleMapping
            	    {

            	    					newCompositeNode(grammarAccess.getGenoMateAccess().getMappingsMappingParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_mappings_3_0=ruleMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGenoMateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mappings",
            	    						lv_mappings_3_0,
            	    						"com.yunzhi.GenoMate.Mapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenoMate"


    // $ANTLR start "entryRuleGlobalConfig"
    // InternalGenoMate.g:160:1: entryRuleGlobalConfig returns [EObject current=null] : iv_ruleGlobalConfig= ruleGlobalConfig EOF ;
    public final EObject entryRuleGlobalConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalConfig = null;


        try {
            // InternalGenoMate.g:160:53: (iv_ruleGlobalConfig= ruleGlobalConfig EOF )
            // InternalGenoMate.g:161:2: iv_ruleGlobalConfig= ruleGlobalConfig EOF
            {
             newCompositeNode(grammarAccess.getGlobalConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGlobalConfig=ruleGlobalConfig();

            state._fsp--;

             current =iv_ruleGlobalConfig; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalConfig"


    // $ANTLR start "ruleGlobalConfig"
    // InternalGenoMate.g:167:1: ruleGlobalConfig returns [EObject current=null] : (otherlv_0= 'global' otherlv_1= '{' otherlv_2= 'package:' ( (lv_package_3_0= RULE_STRING ) ) (otherlv_4= 'defaultAnnotations' otherlv_5= '{' ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )? otherlv_8= '}' ) ;
    public final EObject ruleGlobalConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_package_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_varDefaultAnnotations_6_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:173:2: ( (otherlv_0= 'global' otherlv_1= '{' otherlv_2= 'package:' ( (lv_package_3_0= RULE_STRING ) ) (otherlv_4= 'defaultAnnotations' otherlv_5= '{' ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )? otherlv_8= '}' ) )
            // InternalGenoMate.g:174:2: (otherlv_0= 'global' otherlv_1= '{' otherlv_2= 'package:' ( (lv_package_3_0= RULE_STRING ) ) (otherlv_4= 'defaultAnnotations' otherlv_5= '{' ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )? otherlv_8= '}' )
            {
            // InternalGenoMate.g:174:2: (otherlv_0= 'global' otherlv_1= '{' otherlv_2= 'package:' ( (lv_package_3_0= RULE_STRING ) ) (otherlv_4= 'defaultAnnotations' otherlv_5= '{' ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )? otherlv_8= '}' )
            // InternalGenoMate.g:175:3: otherlv_0= 'global' otherlv_1= '{' otherlv_2= 'package:' ( (lv_package_3_0= RULE_STRING ) ) (otherlv_4= 'defaultAnnotations' otherlv_5= '{' ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getGlobalConfigAccess().getGlobalKeyword_0());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalConfigAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getGlobalConfigAccess().getPackageKeyword_2());
            		
            // InternalGenoMate.g:187:3: ( (lv_package_3_0= RULE_STRING ) )
            // InternalGenoMate.g:188:4: (lv_package_3_0= RULE_STRING )
            {
            // InternalGenoMate.g:188:4: (lv_package_3_0= RULE_STRING )
            // InternalGenoMate.g:189:5: lv_package_3_0= RULE_STRING
            {
            lv_package_3_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_package_3_0, grammarAccess.getGlobalConfigAccess().getPackageSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGlobalConfigRule());
            					}
            					setWithLastConsumed(
            						current,
            						"package",
            						lv_package_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalGenoMate.g:205:3: (otherlv_4= 'defaultAnnotations' otherlv_5= '{' ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalGenoMate.g:206:4: otherlv_4= 'defaultAnnotations' otherlv_5= '{' ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getGlobalConfigAccess().getDefaultAnnotationsKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,17,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getGlobalConfigAccess().getLeftCurlyBracketKeyword_4_1());
                    			
                    // InternalGenoMate.g:214:4: ( (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==57) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalGenoMate.g:215:5: (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration )
                    	    {
                    	    // InternalGenoMate.g:215:5: (lv_varDefaultAnnotations_6_0= ruleVariableDeclaration )
                    	    // InternalGenoMate.g:216:6: lv_varDefaultAnnotations_6_0= ruleVariableDeclaration
                    	    {

                    	    						newCompositeNode(grammarAccess.getGlobalConfigAccess().getVarDefaultAnnotationsVariableDeclarationParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_varDefaultAnnotations_6_0=ruleVariableDeclaration();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getGlobalConfigRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"varDefaultAnnotations",
                    	    							lv_varDefaultAnnotations_6_0,
                    	    							"com.yunzhi.GenoMate.VariableDeclaration");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,20,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getGlobalConfigAccess().getRightCurlyBracketKeyword_4_3());
                    			

                    }
                    break;

            }

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getGlobalConfigAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalConfig"


    // $ANTLR start "entryRuleModel"
    // InternalGenoMate.g:246:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalGenoMate.g:246:46: (iv_ruleModel= ruleModel EOF )
            // InternalGenoMate.g:247:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalGenoMate.g:253:1: ruleModel returns [EObject current=null] : (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) )* otherlv_4= '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_fields_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:259:2: ( (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) )* otherlv_4= '}' ) )
            // InternalGenoMate.g:260:2: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) )* otherlv_4= '}' )
            {
            // InternalGenoMate.g:260:2: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) )* otherlv_4= '}' )
            // InternalGenoMate.g:261:3: otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0());
            		
            // InternalGenoMate.g:265:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGenoMate.g:266:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGenoMate.g:266:4: (lv_name_1_0= RULE_ID )
            // InternalGenoMate.g:267:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGenoMate.g:287:3: ( (lv_fields_3_0= ruleField ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||(LA5_0>=131 && LA5_0<=138)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalGenoMate.g:288:4: (lv_fields_3_0= ruleField )
            	    {
            	    // InternalGenoMate.g:288:4: (lv_fields_3_0= ruleField )
            	    // InternalGenoMate.g:289:5: lv_fields_3_0= ruleField
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getFieldsFieldParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_fields_3_0=ruleField();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fields",
            	    						lv_fields_3_0,
            	    						"com.yunzhi.GenoMate.Field");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleField"
    // InternalGenoMate.g:314:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalGenoMate.g:314:46: (iv_ruleField= ruleField EOF )
            // InternalGenoMate.g:315:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalGenoMate.g:321:1: ruleField returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:327:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalGenoMate.g:328:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalGenoMate.g:328:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalGenoMate.g:329:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // InternalGenoMate.g:329:3: ( (lv_type_0_0= ruleType ) )
            // InternalGenoMate.g:330:4: (lv_type_0_0= ruleType )
            {
            // InternalGenoMate.g:330:4: (lv_type_0_0= ruleType )
            // InternalGenoMate.g:331:5: lv_type_0_0= ruleType
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_type_0_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"com.yunzhi.GenoMate.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:348:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGenoMate.g:349:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGenoMate.g:349:4: (lv_name_1_0= RULE_ID )
            // InternalGenoMate.g:350:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleLombokAnnotation"
    // InternalGenoMate.g:374:1: entryRuleLombokAnnotation returns [EObject current=null] : iv_ruleLombokAnnotation= ruleLombokAnnotation EOF ;
    public final EObject entryRuleLombokAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLombokAnnotation = null;


        try {
            // InternalGenoMate.g:374:57: (iv_ruleLombokAnnotation= ruleLombokAnnotation EOF )
            // InternalGenoMate.g:375:2: iv_ruleLombokAnnotation= ruleLombokAnnotation EOF
            {
             newCompositeNode(grammarAccess.getLombokAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLombokAnnotation=ruleLombokAnnotation();

            state._fsp--;

             current =iv_ruleLombokAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLombokAnnotation"


    // $ANTLR start "ruleLombokAnnotation"
    // InternalGenoMate.g:381:1: ruleLombokAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= ruleLombokType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleLombokAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:387:2: ( (otherlv_0= '@' ( (lv_name_1_0= ruleLombokType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) )
            // InternalGenoMate.g:388:2: (otherlv_0= '@' ( (lv_name_1_0= ruleLombokType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            {
            // InternalGenoMate.g:388:2: (otherlv_0= '@' ( (lv_name_1_0= ruleLombokType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            // InternalGenoMate.g:389:3: otherlv_0= '@' ( (lv_name_1_0= ruleLombokType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getLombokAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalGenoMate.g:393:3: ( (lv_name_1_0= ruleLombokType ) )
            // InternalGenoMate.g:394:4: (lv_name_1_0= ruleLombokType )
            {
            // InternalGenoMate.g:394:4: (lv_name_1_0= ruleLombokType )
            // InternalGenoMate.g:395:5: lv_name_1_0= ruleLombokType
            {

            					newCompositeNode(grammarAccess.getLombokAnnotationAccess().getNameLombokTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleLombokType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLombokAnnotationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.LombokType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:412:3: (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalGenoMate.g:413:4: otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getLombokAnnotationAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalGenoMate.g:417:4: ( (lv_parameters_3_0= ruleAnnotationParameters ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalGenoMate.g:418:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            {
                            // InternalGenoMate.g:418:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            // InternalGenoMate.g:419:6: lv_parameters_3_0= ruleAnnotationParameters
                            {

                            						newCompositeNode(grammarAccess.getLombokAnnotationAccess().getParametersAnnotationParametersParserRuleCall_2_1_0());
                            					
                            pushFollow(FOLLOW_18);
                            lv_parameters_3_0=ruleAnnotationParameters();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getLombokAnnotationRule());
                            						}
                            						set(
                            							current,
                            							"parameters",
                            							lv_parameters_3_0,
                            							"com.yunzhi.GenoMate.AnnotationParameters");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getLombokAnnotationAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLombokAnnotation"


    // $ANTLR start "entryRuleMybatisPlusModelAnnotation"
    // InternalGenoMate.g:445:1: entryRuleMybatisPlusModelAnnotation returns [EObject current=null] : iv_ruleMybatisPlusModelAnnotation= ruleMybatisPlusModelAnnotation EOF ;
    public final EObject entryRuleMybatisPlusModelAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMybatisPlusModelAnnotation = null;


        try {
            // InternalGenoMate.g:445:67: (iv_ruleMybatisPlusModelAnnotation= ruleMybatisPlusModelAnnotation EOF )
            // InternalGenoMate.g:446:2: iv_ruleMybatisPlusModelAnnotation= ruleMybatisPlusModelAnnotation EOF
            {
             newCompositeNode(grammarAccess.getMybatisPlusModelAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMybatisPlusModelAnnotation=ruleMybatisPlusModelAnnotation();

            state._fsp--;

             current =iv_ruleMybatisPlusModelAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMybatisPlusModelAnnotation"


    // $ANTLR start "ruleMybatisPlusModelAnnotation"
    // InternalGenoMate.g:452:1: ruleMybatisPlusModelAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusModelType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleMybatisPlusModelAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:458:2: ( (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusModelType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) )
            // InternalGenoMate.g:459:2: (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusModelType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            {
            // InternalGenoMate.g:459:2: (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusModelType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            // InternalGenoMate.g:460:3: otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusModelType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getMybatisPlusModelAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalGenoMate.g:464:3: ( (lv_name_1_0= ruleMybatisPlusModelType ) )
            // InternalGenoMate.g:465:4: (lv_name_1_0= ruleMybatisPlusModelType )
            {
            // InternalGenoMate.g:465:4: (lv_name_1_0= ruleMybatisPlusModelType )
            // InternalGenoMate.g:466:5: lv_name_1_0= ruleMybatisPlusModelType
            {

            					newCompositeNode(grammarAccess.getMybatisPlusModelAnnotationAccess().getNameMybatisPlusModelTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleMybatisPlusModelType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMybatisPlusModelAnnotationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.MybatisPlusModelType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:483:3: (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalGenoMate.g:484:4: otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getMybatisPlusModelAnnotationAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalGenoMate.g:488:4: ( (lv_parameters_3_0= ruleAnnotationParameters ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalGenoMate.g:489:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            {
                            // InternalGenoMate.g:489:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            // InternalGenoMate.g:490:6: lv_parameters_3_0= ruleAnnotationParameters
                            {

                            						newCompositeNode(grammarAccess.getMybatisPlusModelAnnotationAccess().getParametersAnnotationParametersParserRuleCall_2_1_0());
                            					
                            pushFollow(FOLLOW_18);
                            lv_parameters_3_0=ruleAnnotationParameters();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getMybatisPlusModelAnnotationRule());
                            						}
                            						set(
                            							current,
                            							"parameters",
                            							lv_parameters_3_0,
                            							"com.yunzhi.GenoMate.AnnotationParameters");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getMybatisPlusModelAnnotationAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMybatisPlusModelAnnotation"


    // $ANTLR start "entryRuleMybatisPlusFieldAnnotation"
    // InternalGenoMate.g:516:1: entryRuleMybatisPlusFieldAnnotation returns [EObject current=null] : iv_ruleMybatisPlusFieldAnnotation= ruleMybatisPlusFieldAnnotation EOF ;
    public final EObject entryRuleMybatisPlusFieldAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMybatisPlusFieldAnnotation = null;


        try {
            // InternalGenoMate.g:516:67: (iv_ruleMybatisPlusFieldAnnotation= ruleMybatisPlusFieldAnnotation EOF )
            // InternalGenoMate.g:517:2: iv_ruleMybatisPlusFieldAnnotation= ruleMybatisPlusFieldAnnotation EOF
            {
             newCompositeNode(grammarAccess.getMybatisPlusFieldAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMybatisPlusFieldAnnotation=ruleMybatisPlusFieldAnnotation();

            state._fsp--;

             current =iv_ruleMybatisPlusFieldAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMybatisPlusFieldAnnotation"


    // $ANTLR start "ruleMybatisPlusFieldAnnotation"
    // InternalGenoMate.g:523:1: ruleMybatisPlusFieldAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusFieldType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleMybatisPlusFieldAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:529:2: ( (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusFieldType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) )
            // InternalGenoMate.g:530:2: (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusFieldType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            {
            // InternalGenoMate.g:530:2: (otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusFieldType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            // InternalGenoMate.g:531:3: otherlv_0= '@' ( (lv_name_1_0= ruleMybatisPlusFieldType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getMybatisPlusFieldAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalGenoMate.g:535:3: ( (lv_name_1_0= ruleMybatisPlusFieldType ) )
            // InternalGenoMate.g:536:4: (lv_name_1_0= ruleMybatisPlusFieldType )
            {
            // InternalGenoMate.g:536:4: (lv_name_1_0= ruleMybatisPlusFieldType )
            // InternalGenoMate.g:537:5: lv_name_1_0= ruleMybatisPlusFieldType
            {

            					newCompositeNode(grammarAccess.getMybatisPlusFieldAnnotationAccess().getNameMybatisPlusFieldTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleMybatisPlusFieldType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMybatisPlusFieldAnnotationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.MybatisPlusFieldType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:554:3: (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalGenoMate.g:555:4: otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getMybatisPlusFieldAnnotationAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalGenoMate.g:559:4: ( (lv_parameters_3_0= ruleAnnotationParameters ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalGenoMate.g:560:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            {
                            // InternalGenoMate.g:560:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            // InternalGenoMate.g:561:6: lv_parameters_3_0= ruleAnnotationParameters
                            {

                            						newCompositeNode(grammarAccess.getMybatisPlusFieldAnnotationAccess().getParametersAnnotationParametersParserRuleCall_2_1_0());
                            					
                            pushFollow(FOLLOW_18);
                            lv_parameters_3_0=ruleAnnotationParameters();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getMybatisPlusFieldAnnotationRule());
                            						}
                            						set(
                            							current,
                            							"parameters",
                            							lv_parameters_3_0,
                            							"com.yunzhi.GenoMate.AnnotationParameters");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getMybatisPlusFieldAnnotationAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMybatisPlusFieldAnnotation"


    // $ANTLR start "entryRuleBeanValidationAnnotation"
    // InternalGenoMate.g:587:1: entryRuleBeanValidationAnnotation returns [EObject current=null] : iv_ruleBeanValidationAnnotation= ruleBeanValidationAnnotation EOF ;
    public final EObject entryRuleBeanValidationAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeanValidationAnnotation = null;


        try {
            // InternalGenoMate.g:587:65: (iv_ruleBeanValidationAnnotation= ruleBeanValidationAnnotation EOF )
            // InternalGenoMate.g:588:2: iv_ruleBeanValidationAnnotation= ruleBeanValidationAnnotation EOF
            {
             newCompositeNode(grammarAccess.getBeanValidationAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeanValidationAnnotation=ruleBeanValidationAnnotation();

            state._fsp--;

             current =iv_ruleBeanValidationAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBeanValidationAnnotation"


    // $ANTLR start "ruleBeanValidationAnnotation"
    // InternalGenoMate.g:594:1: ruleBeanValidationAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= ruleBeanValidationType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleBeanValidationAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:600:2: ( (otherlv_0= '@' ( (lv_name_1_0= ruleBeanValidationType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) )
            // InternalGenoMate.g:601:2: (otherlv_0= '@' ( (lv_name_1_0= ruleBeanValidationType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            {
            // InternalGenoMate.g:601:2: (otherlv_0= '@' ( (lv_name_1_0= ruleBeanValidationType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            // InternalGenoMate.g:602:3: otherlv_0= '@' ( (lv_name_1_0= ruleBeanValidationType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getBeanValidationAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalGenoMate.g:606:3: ( (lv_name_1_0= ruleBeanValidationType ) )
            // InternalGenoMate.g:607:4: (lv_name_1_0= ruleBeanValidationType )
            {
            // InternalGenoMate.g:607:4: (lv_name_1_0= ruleBeanValidationType )
            // InternalGenoMate.g:608:5: lv_name_1_0= ruleBeanValidationType
            {

            					newCompositeNode(grammarAccess.getBeanValidationAnnotationAccess().getNameBeanValidationTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleBeanValidationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBeanValidationAnnotationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.BeanValidationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:625:3: (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalGenoMate.g:626:4: otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getBeanValidationAnnotationAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalGenoMate.g:630:4: ( (lv_parameters_3_0= ruleAnnotationParameters ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_ID) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalGenoMate.g:631:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            {
                            // InternalGenoMate.g:631:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            // InternalGenoMate.g:632:6: lv_parameters_3_0= ruleAnnotationParameters
                            {

                            						newCompositeNode(grammarAccess.getBeanValidationAnnotationAccess().getParametersAnnotationParametersParserRuleCall_2_1_0());
                            					
                            pushFollow(FOLLOW_18);
                            lv_parameters_3_0=ruleAnnotationParameters();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getBeanValidationAnnotationRule());
                            						}
                            						set(
                            							current,
                            							"parameters",
                            							lv_parameters_3_0,
                            							"com.yunzhi.GenoMate.AnnotationParameters");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getBeanValidationAnnotationAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBeanValidationAnnotation"


    // $ANTLR start "entryRuleJacksonAnnotation"
    // InternalGenoMate.g:658:1: entryRuleJacksonAnnotation returns [EObject current=null] : iv_ruleJacksonAnnotation= ruleJacksonAnnotation EOF ;
    public final EObject entryRuleJacksonAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJacksonAnnotation = null;


        try {
            // InternalGenoMate.g:658:58: (iv_ruleJacksonAnnotation= ruleJacksonAnnotation EOF )
            // InternalGenoMate.g:659:2: iv_ruleJacksonAnnotation= ruleJacksonAnnotation EOF
            {
             newCompositeNode(grammarAccess.getJacksonAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJacksonAnnotation=ruleJacksonAnnotation();

            state._fsp--;

             current =iv_ruleJacksonAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJacksonAnnotation"


    // $ANTLR start "ruleJacksonAnnotation"
    // InternalGenoMate.g:665:1: ruleJacksonAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= ruleJacksonType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleJacksonAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:671:2: ( (otherlv_0= '@' ( (lv_name_1_0= ruleJacksonType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? ) )
            // InternalGenoMate.g:672:2: (otherlv_0= '@' ( (lv_name_1_0= ruleJacksonType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            {
            // InternalGenoMate.g:672:2: (otherlv_0= '@' ( (lv_name_1_0= ruleJacksonType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )? )
            // InternalGenoMate.g:673:3: otherlv_0= '@' ( (lv_name_1_0= ruleJacksonType ) ) (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getJacksonAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalGenoMate.g:677:3: ( (lv_name_1_0= ruleJacksonType ) )
            // InternalGenoMate.g:678:4: (lv_name_1_0= ruleJacksonType )
            {
            // InternalGenoMate.g:678:4: (lv_name_1_0= ruleJacksonType )
            // InternalGenoMate.g:679:5: lv_name_1_0= ruleJacksonType
            {

            					newCompositeNode(grammarAccess.getJacksonAnnotationAccess().getNameJacksonTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleJacksonType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJacksonAnnotationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.JacksonType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:696:3: (otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalGenoMate.g:697:4: otherlv_2= '(' ( (lv_parameters_3_0= ruleAnnotationParameters ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getJacksonAnnotationAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalGenoMate.g:701:4: ( (lv_parameters_3_0= ruleAnnotationParameters ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_ID) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalGenoMate.g:702:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            {
                            // InternalGenoMate.g:702:5: (lv_parameters_3_0= ruleAnnotationParameters )
                            // InternalGenoMate.g:703:6: lv_parameters_3_0= ruleAnnotationParameters
                            {

                            						newCompositeNode(grammarAccess.getJacksonAnnotationAccess().getParametersAnnotationParametersParserRuleCall_2_1_0());
                            					
                            pushFollow(FOLLOW_18);
                            lv_parameters_3_0=ruleAnnotationParameters();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getJacksonAnnotationRule());
                            						}
                            						set(
                            							current,
                            							"parameters",
                            							lv_parameters_3_0,
                            							"com.yunzhi.GenoMate.AnnotationParameters");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getJacksonAnnotationAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJacksonAnnotation"


    // $ANTLR start "entryRuleAnnotationParameters"
    // InternalGenoMate.g:729:1: entryRuleAnnotationParameters returns [EObject current=null] : iv_ruleAnnotationParameters= ruleAnnotationParameters EOF ;
    public final EObject entryRuleAnnotationParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationParameters = null;


        try {
            // InternalGenoMate.g:729:61: (iv_ruleAnnotationParameters= ruleAnnotationParameters EOF )
            // InternalGenoMate.g:730:2: iv_ruleAnnotationParameters= ruleAnnotationParameters EOF
            {
             newCompositeNode(grammarAccess.getAnnotationParametersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationParameters=ruleAnnotationParameters();

            state._fsp--;

             current =iv_ruleAnnotationParameters; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationParameters"


    // $ANTLR start "ruleAnnotationParameters"
    // InternalGenoMate.g:736:1: ruleAnnotationParameters returns [EObject current=null] : ( ( (lv_annparameters_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleAnnotationParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annparameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:742:2: ( ( ( (lv_annparameters_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameter ) ) )* ) )
            // InternalGenoMate.g:743:2: ( ( (lv_annparameters_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameter ) ) )* )
            {
            // InternalGenoMate.g:743:2: ( ( (lv_annparameters_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameter ) ) )* )
            // InternalGenoMate.g:744:3: ( (lv_annparameters_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameter ) ) )*
            {
            // InternalGenoMate.g:744:3: ( (lv_annparameters_0_0= ruleParameter ) )
            // InternalGenoMate.g:745:4: (lv_annparameters_0_0= ruleParameter )
            {
            // InternalGenoMate.g:745:4: (lv_annparameters_0_0= ruleParameter )
            // InternalGenoMate.g:746:5: lv_annparameters_0_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getAnnotationParametersAccess().getAnnparametersParameterParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_annparameters_0_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAnnotationParametersRule());
            					}
            					add(
            						current,
            						"annparameters",
            						lv_annparameters_0_0,
            						"com.yunzhi.GenoMate.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:763:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleParameter ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalGenoMate.g:764:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,26,FOLLOW_12); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAnnotationParametersAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalGenoMate.g:768:4: ( (lv_parameters_2_0= ruleParameter ) )
            	    // InternalGenoMate.g:769:5: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // InternalGenoMate.g:769:5: (lv_parameters_2_0= ruleParameter )
            	    // InternalGenoMate.g:770:6: lv_parameters_2_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getAnnotationParametersAccess().getParametersParameterParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_parameters_2_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAnnotationParametersRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_2_0,
            	    							"com.yunzhi.GenoMate.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationParameters"


    // $ANTLR start "entryRuleParameter"
    // InternalGenoMate.g:792:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalGenoMate.g:792:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalGenoMate.g:793:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalGenoMate.g:799:1: ruleParameter returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:805:2: ( ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalGenoMate.g:806:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalGenoMate.g:806:2: ( ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalGenoMate.g:807:3: ( (lv_key_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalGenoMate.g:807:3: ( (lv_key_0_0= RULE_ID ) )
            // InternalGenoMate.g:808:4: (lv_key_0_0= RULE_ID )
            {
            // InternalGenoMate.g:808:4: (lv_key_0_0= RULE_ID )
            // InternalGenoMate.g:809:5: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_key_0_0, grammarAccess.getParameterAccess().getKeyIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"key",
            						lv_key_0_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getEqualsSignKeyword_1());
            		
            // InternalGenoMate.g:829:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalGenoMate.g:830:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalGenoMate.g:830:4: (lv_value_2_0= ruleLiteral )
            // InternalGenoMate.g:831:5: lv_value_2_0= ruleLiteral
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getValueLiteralParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"com.yunzhi.GenoMate.Literal");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleGenerateSection"
    // InternalGenoMate.g:852:1: entryRuleGenerateSection returns [EObject current=null] : iv_ruleGenerateSection= ruleGenerateSection EOF ;
    public final EObject entryRuleGenerateSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerateSection = null;


        try {
            // InternalGenoMate.g:852:56: (iv_ruleGenerateSection= ruleGenerateSection EOF )
            // InternalGenoMate.g:853:2: iv_ruleGenerateSection= ruleGenerateSection EOF
            {
             newCompositeNode(grammarAccess.getGenerateSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerateSection=ruleGenerateSection();

            state._fsp--;

             current =iv_ruleGenerateSection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerateSection"


    // $ANTLR start "ruleGenerateSection"
    // InternalGenoMate.g:859:1: ruleGenerateSection returns [EObject current=null] : (otherlv_0= 'generate' otherlv_1= '{' ( (lv_rules_2_0= ruleGenerationRule ) )+ otherlv_3= '}' ) ;
    public final EObject ruleGenerateSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_rules_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:865:2: ( (otherlv_0= 'generate' otherlv_1= '{' ( (lv_rules_2_0= ruleGenerationRule ) )+ otherlv_3= '}' ) )
            // InternalGenoMate.g:866:2: (otherlv_0= 'generate' otherlv_1= '{' ( (lv_rules_2_0= ruleGenerationRule ) )+ otherlv_3= '}' )
            {
            // InternalGenoMate.g:866:2: (otherlv_0= 'generate' otherlv_1= '{' ( (lv_rules_2_0= ruleGenerationRule ) )+ otherlv_3= '}' )
            // InternalGenoMate.g:867:3: otherlv_0= 'generate' otherlv_1= '{' ( (lv_rules_2_0= ruleGenerationRule ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getGenerateSectionAccess().getGenerateKeyword_0());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getGenerateSectionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalGenoMate.g:875:3: ( (lv_rules_2_0= ruleGenerationRule ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==29||(LA17_0>=36 && LA17_0<=37)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalGenoMate.g:876:4: (lv_rules_2_0= ruleGenerationRule )
            	    {
            	    // InternalGenoMate.g:876:4: (lv_rules_2_0= ruleGenerationRule )
            	    // InternalGenoMate.g:877:5: lv_rules_2_0= ruleGenerationRule
            	    {

            	    					newCompositeNode(grammarAccess.getGenerateSectionAccess().getRulesGenerationRuleParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_rules_2_0=ruleGenerationRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGenerateSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rules",
            	    						lv_rules_2_0,
            	    						"com.yunzhi.GenoMate.GenerationRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            otherlv_3=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getGenerateSectionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerateSection"


    // $ANTLR start "entryRuleGenerationRule"
    // InternalGenoMate.g:902:1: entryRuleGenerationRule returns [EObject current=null] : iv_ruleGenerationRule= ruleGenerationRule EOF ;
    public final EObject entryRuleGenerationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerationRule = null;


        try {
            // InternalGenoMate.g:902:55: (iv_ruleGenerationRule= ruleGenerationRule EOF )
            // InternalGenoMate.g:903:2: iv_ruleGenerationRule= ruleGenerationRule EOF
            {
             newCompositeNode(grammarAccess.getGenerationRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerationRule=ruleGenerationRule();

            state._fsp--;

             current =iv_ruleGenerationRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerationRule"


    // $ANTLR start "ruleGenerationRule"
    // InternalGenoMate.g:909:1: ruleGenerationRule returns [EObject current=null] : (this_PoRule_0= rulePoRule | this_DtoRule_1= ruleDtoRule | this_VoRule_2= ruleVoRule ) ;
    public final EObject ruleGenerationRule() throws RecognitionException {
        EObject current = null;

        EObject this_PoRule_0 = null;

        EObject this_DtoRule_1 = null;

        EObject this_VoRule_2 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:915:2: ( (this_PoRule_0= rulePoRule | this_DtoRule_1= ruleDtoRule | this_VoRule_2= ruleVoRule ) )
            // InternalGenoMate.g:916:2: (this_PoRule_0= rulePoRule | this_DtoRule_1= ruleDtoRule | this_VoRule_2= ruleVoRule )
            {
            // InternalGenoMate.g:916:2: (this_PoRule_0= rulePoRule | this_DtoRule_1= ruleDtoRule | this_VoRule_2= ruleVoRule )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt18=1;
                }
                break;
            case 36:
                {
                alt18=2;
                }
                break;
            case 37:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalGenoMate.g:917:3: this_PoRule_0= rulePoRule
                    {

                    			newCompositeNode(grammarAccess.getGenerationRuleAccess().getPoRuleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PoRule_0=rulePoRule();

                    state._fsp--;


                    			current = this_PoRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:926:3: this_DtoRule_1= ruleDtoRule
                    {

                    			newCompositeNode(grammarAccess.getGenerationRuleAccess().getDtoRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DtoRule_1=ruleDtoRule();

                    state._fsp--;


                    			current = this_DtoRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:935:3: this_VoRule_2= ruleVoRule
                    {

                    			newCompositeNode(grammarAccess.getGenerationRuleAccess().getVoRuleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_VoRule_2=ruleVoRule();

                    state._fsp--;


                    			current = this_VoRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerationRule"


    // $ANTLR start "entryRulePoRule"
    // InternalGenoMate.g:947:1: entryRulePoRule returns [EObject current=null] : iv_rulePoRule= rulePoRule EOF ;
    public final EObject entryRulePoRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoRule = null;


        try {
            // InternalGenoMate.g:947:47: (iv_rulePoRule= rulePoRule EOF )
            // InternalGenoMate.g:948:2: iv_rulePoRule= rulePoRule EOF
            {
             newCompositeNode(grammarAccess.getPoRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoRule=rulePoRule();

            state._fsp--;

             current =iv_rulePoRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoRule"


    // $ANTLR start "rulePoRule"
    // InternalGenoMate.g:954:1: rulePoRule returns [EObject current=null] : (otherlv_0= 'po' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_serializable_4_0= 'Serializable' ) )? (otherlv_5= 'lombok:' ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )* )? (otherlv_7= 'mybatis-plus:' ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )* )? (otherlv_9= 'fieldAnnotations' otherlv_10= '{' ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )* otherlv_12= '}' )? (otherlv_13= 'fieldAdd' otherlv_14= '{' ( (lv_addField_15_0= rulePoAddField ) )* otherlv_16= '}' )? otherlv_17= '}' ) ;
    public final EObject rulePoRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_serializable_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_lombokAnnotation_6_0 = null;

        EObject lv_mybatisPlusModelAnnotation_8_0 = null;

        EObject lv_fieldAnns_11_0 = null;

        EObject lv_addField_15_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:960:2: ( (otherlv_0= 'po' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_serializable_4_0= 'Serializable' ) )? (otherlv_5= 'lombok:' ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )* )? (otherlv_7= 'mybatis-plus:' ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )* )? (otherlv_9= 'fieldAnnotations' otherlv_10= '{' ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )* otherlv_12= '}' )? (otherlv_13= 'fieldAdd' otherlv_14= '{' ( (lv_addField_15_0= rulePoAddField ) )* otherlv_16= '}' )? otherlv_17= '}' ) )
            // InternalGenoMate.g:961:2: (otherlv_0= 'po' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_serializable_4_0= 'Serializable' ) )? (otherlv_5= 'lombok:' ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )* )? (otherlv_7= 'mybatis-plus:' ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )* )? (otherlv_9= 'fieldAnnotations' otherlv_10= '{' ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )* otherlv_12= '}' )? (otherlv_13= 'fieldAdd' otherlv_14= '{' ( (lv_addField_15_0= rulePoAddField ) )* otherlv_16= '}' )? otherlv_17= '}' )
            {
            // InternalGenoMate.g:961:2: (otherlv_0= 'po' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_serializable_4_0= 'Serializable' ) )? (otherlv_5= 'lombok:' ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )* )? (otherlv_7= 'mybatis-plus:' ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )* )? (otherlv_9= 'fieldAnnotations' otherlv_10= '{' ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )* otherlv_12= '}' )? (otherlv_13= 'fieldAdd' otherlv_14= '{' ( (lv_addField_15_0= rulePoAddField ) )* otherlv_16= '}' )? otherlv_17= '}' )
            // InternalGenoMate.g:962:3: otherlv_0= 'po' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_serializable_4_0= 'Serializable' ) )? (otherlv_5= 'lombok:' ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )* )? (otherlv_7= 'mybatis-plus:' ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )* )? (otherlv_9= 'fieldAnnotations' otherlv_10= '{' ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )* otherlv_12= '}' )? (otherlv_13= 'fieldAdd' otherlv_14= '{' ( (lv_addField_15_0= rulePoAddField ) )* otherlv_16= '}' )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getPoRuleAccess().getPoKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getPoRuleAccess().getForKeyword_1());
            		
            // InternalGenoMate.g:970:3: ( (otherlv_2= RULE_ID ) )
            // InternalGenoMate.g:971:4: (otherlv_2= RULE_ID )
            {
            // InternalGenoMate.g:971:4: (otherlv_2= RULE_ID )
            // InternalGenoMate.g:972:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPoRuleRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_2, grammarAccess.getPoRuleAccess().getModelModelCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_29); 

            			newLeafNode(otherlv_3, grammarAccess.getPoRuleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalGenoMate.g:987:3: ( (lv_serializable_4_0= 'Serializable' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalGenoMate.g:988:4: (lv_serializable_4_0= 'Serializable' )
                    {
                    // InternalGenoMate.g:988:4: (lv_serializable_4_0= 'Serializable' )
                    // InternalGenoMate.g:989:5: lv_serializable_4_0= 'Serializable'
                    {
                    lv_serializable_4_0=(Token)match(input,31,FOLLOW_30); 

                    					newLeafNode(lv_serializable_4_0, grammarAccess.getPoRuleAccess().getSerializableSerializableKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPoRuleRule());
                    					}
                    					setWithLastConsumed(current, "serializable", lv_serializable_4_0, "Serializable");
                    				

                    }


                    }
                    break;

            }

            // InternalGenoMate.g:1001:3: (otherlv_5= 'lombok:' ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalGenoMate.g:1002:4: otherlv_5= 'lombok:' ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )*
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_31); 

                    				newLeafNode(otherlv_5, grammarAccess.getPoRuleAccess().getLombokKeyword_5_0());
                    			
                    // InternalGenoMate.g:1006:4: ( (lv_lombokAnnotation_6_0= ruleLombokAnnotation ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==23) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalGenoMate.g:1007:5: (lv_lombokAnnotation_6_0= ruleLombokAnnotation )
                    	    {
                    	    // InternalGenoMate.g:1007:5: (lv_lombokAnnotation_6_0= ruleLombokAnnotation )
                    	    // InternalGenoMate.g:1008:6: lv_lombokAnnotation_6_0= ruleLombokAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getPoRuleAccess().getLombokAnnotationLombokAnnotationParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_31);
                    	    lv_lombokAnnotation_6_0=ruleLombokAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPoRuleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"lombokAnnotation",
                    	    							lv_lombokAnnotation_6_0,
                    	    							"com.yunzhi.GenoMate.LombokAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGenoMate.g:1026:3: (otherlv_7= 'mybatis-plus:' ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalGenoMate.g:1027:4: otherlv_7= 'mybatis-plus:' ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )*
                    {
                    otherlv_7=(Token)match(input,33,FOLLOW_32); 

                    				newLeafNode(otherlv_7, grammarAccess.getPoRuleAccess().getMybatisPlusKeyword_6_0());
                    			
                    // InternalGenoMate.g:1031:4: ( (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==23) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalGenoMate.g:1032:5: (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation )
                    	    {
                    	    // InternalGenoMate.g:1032:5: (lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation )
                    	    // InternalGenoMate.g:1033:6: lv_mybatisPlusModelAnnotation_8_0= ruleMybatisPlusModelAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getPoRuleAccess().getMybatisPlusModelAnnotationMybatisPlusModelAnnotationParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_32);
                    	    lv_mybatisPlusModelAnnotation_8_0=ruleMybatisPlusModelAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPoRuleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"mybatisPlusModelAnnotation",
                    	    							lv_mybatisPlusModelAnnotation_8_0,
                    	    							"com.yunzhi.GenoMate.MybatisPlusModelAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGenoMate.g:1051:3: (otherlv_9= 'fieldAnnotations' otherlv_10= '{' ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )* otherlv_12= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalGenoMate.g:1052:4: otherlv_9= 'fieldAnnotations' otherlv_10= '{' ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )* otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,34,FOLLOW_6); 

                    				newLeafNode(otherlv_9, grammarAccess.getPoRuleAccess().getFieldAnnotationsKeyword_7_0());
                    			
                    otherlv_10=(Token)match(input,17,FOLLOW_33); 

                    				newLeafNode(otherlv_10, grammarAccess.getPoRuleAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalGenoMate.g:1060:4: ( (lv_fieldAnns_11_0= ruleFieldAnnotation ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==42) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalGenoMate.g:1061:5: (lv_fieldAnns_11_0= ruleFieldAnnotation )
                    	    {
                    	    // InternalGenoMate.g:1061:5: (lv_fieldAnns_11_0= ruleFieldAnnotation )
                    	    // InternalGenoMate.g:1062:6: lv_fieldAnns_11_0= ruleFieldAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getPoRuleAccess().getFieldAnnsFieldAnnotationParserRuleCall_7_2_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_fieldAnns_11_0=ruleFieldAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPoRuleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"fieldAnns",
                    	    							lv_fieldAnns_11_0,
                    	    							"com.yunzhi.GenoMate.FieldAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,20,FOLLOW_34); 

                    				newLeafNode(otherlv_12, grammarAccess.getPoRuleAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }

            // InternalGenoMate.g:1084:3: (otherlv_13= 'fieldAdd' otherlv_14= '{' ( (lv_addField_15_0= rulePoAddField ) )* otherlv_16= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalGenoMate.g:1085:4: otherlv_13= 'fieldAdd' otherlv_14= '{' ( (lv_addField_15_0= rulePoAddField ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_13, grammarAccess.getPoRuleAccess().getFieldAddKeyword_8_0());
                    			
                    otherlv_14=(Token)match(input,17,FOLLOW_35); 

                    				newLeafNode(otherlv_14, grammarAccess.getPoRuleAccess().getLeftCurlyBracketKeyword_8_1());
                    			
                    // InternalGenoMate.g:1093:4: ( (lv_addField_15_0= rulePoAddField ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==58) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalGenoMate.g:1094:5: (lv_addField_15_0= rulePoAddField )
                    	    {
                    	    // InternalGenoMate.g:1094:5: (lv_addField_15_0= rulePoAddField )
                    	    // InternalGenoMate.g:1095:6: lv_addField_15_0= rulePoAddField
                    	    {

                    	    						newCompositeNode(grammarAccess.getPoRuleAccess().getAddFieldPoAddFieldParserRuleCall_8_2_0());
                    	    					
                    	    pushFollow(FOLLOW_35);
                    	    lv_addField_15_0=rulePoAddField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPoRuleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"addField",
                    	    							lv_addField_15_0,
                    	    							"com.yunzhi.GenoMate.PoAddField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,20,FOLLOW_11); 

                    				newLeafNode(otherlv_16, grammarAccess.getPoRuleAccess().getRightCurlyBracketKeyword_8_3());
                    			

                    }
                    break;

            }

            otherlv_17=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getPoRuleAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoRule"


    // $ANTLR start "entryRuleDtoRule"
    // InternalGenoMate.g:1125:1: entryRuleDtoRule returns [EObject current=null] : iv_ruleDtoRule= ruleDtoRule EOF ;
    public final EObject entryRuleDtoRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDtoRule = null;


        try {
            // InternalGenoMate.g:1125:48: (iv_ruleDtoRule= ruleDtoRule EOF )
            // InternalGenoMate.g:1126:2: iv_ruleDtoRule= ruleDtoRule EOF
            {
             newCompositeNode(grammarAccess.getDtoRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDtoRule=ruleDtoRule();

            state._fsp--;

             current =iv_ruleDtoRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDtoRule"


    // $ANTLR start "ruleDtoRule"
    // InternalGenoMate.g:1132:1: ruleDtoRule returns [EObject current=null] : (otherlv_0= 'dto' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_dtos_4_0= ruleDtoDefinition ) )+ otherlv_5= '}' ) ;
    public final EObject ruleDtoRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_dtos_4_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1138:2: ( (otherlv_0= 'dto' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_dtos_4_0= ruleDtoDefinition ) )+ otherlv_5= '}' ) )
            // InternalGenoMate.g:1139:2: (otherlv_0= 'dto' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_dtos_4_0= ruleDtoDefinition ) )+ otherlv_5= '}' )
            {
            // InternalGenoMate.g:1139:2: (otherlv_0= 'dto' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_dtos_4_0= ruleDtoDefinition ) )+ otherlv_5= '}' )
            // InternalGenoMate.g:1140:3: otherlv_0= 'dto' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_dtos_4_0= ruleDtoDefinition ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getDtoRuleAccess().getDtoKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getDtoRuleAccess().getForKeyword_1());
            		
            // InternalGenoMate.g:1148:3: ( (otherlv_2= RULE_ID ) )
            // InternalGenoMate.g:1149:4: (otherlv_2= RULE_ID )
            {
            // InternalGenoMate.g:1149:4: (otherlv_2= RULE_ID )
            // InternalGenoMate.g:1150:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDtoRuleRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_2, grammarAccess.getDtoRuleAccess().getModelModelCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getDtoRuleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalGenoMate.g:1165:3: ( (lv_dtos_4_0= ruleDtoDefinition ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==36) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalGenoMate.g:1166:4: (lv_dtos_4_0= ruleDtoDefinition )
            	    {
            	    // InternalGenoMate.g:1166:4: (lv_dtos_4_0= ruleDtoDefinition )
            	    // InternalGenoMate.g:1167:5: lv_dtos_4_0= ruleDtoDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getDtoRuleAccess().getDtosDtoDefinitionParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_dtos_4_0=ruleDtoDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDtoRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"dtos",
            	    						lv_dtos_4_0,
            	    						"com.yunzhi.GenoMate.DtoDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDtoRuleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDtoRule"


    // $ANTLR start "entryRuleVoRule"
    // InternalGenoMate.g:1192:1: entryRuleVoRule returns [EObject current=null] : iv_ruleVoRule= ruleVoRule EOF ;
    public final EObject entryRuleVoRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoRule = null;


        try {
            // InternalGenoMate.g:1192:47: (iv_ruleVoRule= ruleVoRule EOF )
            // InternalGenoMate.g:1193:2: iv_ruleVoRule= ruleVoRule EOF
            {
             newCompositeNode(grammarAccess.getVoRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVoRule=ruleVoRule();

            state._fsp--;

             current =iv_ruleVoRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoRule"


    // $ANTLR start "ruleVoRule"
    // InternalGenoMate.g:1199:1: ruleVoRule returns [EObject current=null] : (otherlv_0= 'vo' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_vos_4_0= ruleVoDefinition ) )+ otherlv_5= '}' ) ;
    public final EObject ruleVoRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_vos_4_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1205:2: ( (otherlv_0= 'vo' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_vos_4_0= ruleVoDefinition ) )+ otherlv_5= '}' ) )
            // InternalGenoMate.g:1206:2: (otherlv_0= 'vo' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_vos_4_0= ruleVoDefinition ) )+ otherlv_5= '}' )
            {
            // InternalGenoMate.g:1206:2: (otherlv_0= 'vo' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_vos_4_0= ruleVoDefinition ) )+ otherlv_5= '}' )
            // InternalGenoMate.g:1207:3: otherlv_0= 'vo' otherlv_1= 'for' ( (otherlv_2= RULE_ID ) ) otherlv_3= '{' ( (lv_vos_4_0= ruleVoDefinition ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getVoRuleAccess().getVoKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getVoRuleAccess().getForKeyword_1());
            		
            // InternalGenoMate.g:1215:3: ( (otherlv_2= RULE_ID ) )
            // InternalGenoMate.g:1216:4: (otherlv_2= RULE_ID )
            {
            // InternalGenoMate.g:1216:4: (otherlv_2= RULE_ID )
            // InternalGenoMate.g:1217:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVoRuleRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_2, grammarAccess.getVoRuleAccess().getModelModelCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_38); 

            			newLeafNode(otherlv_3, grammarAccess.getVoRuleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalGenoMate.g:1232:3: ( (lv_vos_4_0= ruleVoDefinition ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==37) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalGenoMate.g:1233:4: (lv_vos_4_0= ruleVoDefinition )
            	    {
            	    // InternalGenoMate.g:1233:4: (lv_vos_4_0= ruleVoDefinition )
            	    // InternalGenoMate.g:1234:5: lv_vos_4_0= ruleVoDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getVoRuleAccess().getVosVoDefinitionParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_vos_4_0=ruleVoDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getVoRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"vos",
            	    						lv_vos_4_0,
            	    						"com.yunzhi.GenoMate.VoDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getVoRuleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoRule"


    // $ANTLR start "entryRuleDtoDefinition"
    // InternalGenoMate.g:1259:1: entryRuleDtoDefinition returns [EObject current=null] : iv_ruleDtoDefinition= ruleDtoDefinition EOF ;
    public final EObject entryRuleDtoDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDtoDefinition = null;


        try {
            // InternalGenoMate.g:1259:54: (iv_ruleDtoDefinition= ruleDtoDefinition EOF )
            // InternalGenoMate.g:1260:2: iv_ruleDtoDefinition= ruleDtoDefinition EOF
            {
             newCompositeNode(grammarAccess.getDtoDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDtoDefinition=ruleDtoDefinition();

            state._fsp--;

             current =iv_ruleDtoDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDtoDefinition"


    // $ANTLR start "ruleDtoDefinition"
    // InternalGenoMate.g:1266:1: ruleDtoDefinition returns [EObject current=null] : (otherlv_0= 'dto' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldValidation' otherlv_14= '{' ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) ) otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleDtoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' ) ;
    public final EObject ruleDtoDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_serializable_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        EObject lv_lombokAnnotation_5_0 = null;

        EObject lv_exclusions_8_0 = null;

        AntlrDatatypeRuleToken lv_excludeAll_10_0 = null;

        EObject lv_fieldAnnotationsBlock_15_0 = null;

        EObject lv_addField_19_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1272:2: ( (otherlv_0= 'dto' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldValidation' otherlv_14= '{' ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) ) otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleDtoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' ) )
            // InternalGenoMate.g:1273:2: (otherlv_0= 'dto' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldValidation' otherlv_14= '{' ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) ) otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleDtoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' )
            {
            // InternalGenoMate.g:1273:2: (otherlv_0= 'dto' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldValidation' otherlv_14= '{' ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) ) otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleDtoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' )
            // InternalGenoMate.g:1274:3: otherlv_0= 'dto' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldValidation' otherlv_14= '{' ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) ) otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleDtoAddField ) )* otherlv_20= '}' )? otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getDtoDefinitionAccess().getDtoKeyword_0());
            		
            // InternalGenoMate.g:1278:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGenoMate.g:1279:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGenoMate.g:1279:4: (lv_name_1_0= RULE_ID )
            // InternalGenoMate.g:1280:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDtoDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDtoDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getDtoDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGenoMate.g:1300:3: ( (lv_serializable_3_0= 'Serializable' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==31) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalGenoMate.g:1301:4: (lv_serializable_3_0= 'Serializable' )
                    {
                    // InternalGenoMate.g:1301:4: (lv_serializable_3_0= 'Serializable' )
                    // InternalGenoMate.g:1302:5: lv_serializable_3_0= 'Serializable'
                    {
                    lv_serializable_3_0=(Token)match(input,31,FOLLOW_41); 

                    					newLeafNode(lv_serializable_3_0, grammarAccess.getDtoDefinitionAccess().getSerializableSerializableKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDtoDefinitionRule());
                    					}
                    					setWithLastConsumed(current, "serializable", lv_serializable_3_0, "Serializable");
                    				

                    }


                    }
                    break;

            }

            // InternalGenoMate.g:1314:3: (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==32) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalGenoMate.g:1315:4: otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )*
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_42); 

                    				newLeafNode(otherlv_4, grammarAccess.getDtoDefinitionAccess().getLombokKeyword_4_0());
                    			
                    // InternalGenoMate.g:1319:4: ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==23) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalGenoMate.g:1320:5: (lv_lombokAnnotation_5_0= ruleLombokAnnotation )
                    	    {
                    	    // InternalGenoMate.g:1320:5: (lv_lombokAnnotation_5_0= ruleLombokAnnotation )
                    	    // InternalGenoMate.g:1321:6: lv_lombokAnnotation_5_0= ruleLombokAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getDtoDefinitionAccess().getLombokAnnotationLombokAnnotationParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_42);
                    	    lv_lombokAnnotation_5_0=ruleLombokAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDtoDefinitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"lombokAnnotation",
                    	    							lv_lombokAnnotation_5_0,
                    	    							"com.yunzhi.GenoMate.LombokAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGenoMate.g:1339:3: (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalGenoMate.g:1340:4: otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}'
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getDtoDefinitionAccess().getFieldExcludeKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,17,FOLLOW_43); 

                    				newLeafNode(otherlv_7, grammarAccess.getDtoDefinitionAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalGenoMate.g:1348:4: ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==20||LA34_0==59) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==39) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalGenoMate.g:1349:5: ( (lv_exclusions_8_0= ruleExclusions ) )*
                            {
                            // InternalGenoMate.g:1349:5: ( (lv_exclusions_8_0= ruleExclusions ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==59) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // InternalGenoMate.g:1350:6: (lv_exclusions_8_0= ruleExclusions )
                            	    {
                            	    // InternalGenoMate.g:1350:6: (lv_exclusions_8_0= ruleExclusions )
                            	    // InternalGenoMate.g:1351:7: lv_exclusions_8_0= ruleExclusions
                            	    {

                            	    							newCompositeNode(grammarAccess.getDtoDefinitionAccess().getExclusionsExclusionsParserRuleCall_5_2_0_0());
                            	    						
                            	    pushFollow(FOLLOW_44);
                            	    lv_exclusions_8_0=ruleExclusions();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getDtoDefinitionRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"exclusions",
                            	    								lv_exclusions_8_0,
                            	    								"com.yunzhi.GenoMate.Exclusions");
                            	    							afterParserOrEnumRuleCall();
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalGenoMate.g:1369:5: (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' )
                            {
                            // InternalGenoMate.g:1369:5: (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' )
                            // InternalGenoMate.g:1370:6: otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';'
                            {
                            otherlv_9=(Token)match(input,39,FOLLOW_25); 

                            						newLeafNode(otherlv_9, grammarAccess.getDtoDefinitionAccess().getExcludeAllKeyword_5_2_1_0());
                            					
                            // InternalGenoMate.g:1374:6: ( (lv_excludeAll_10_0= ruleBOOL ) )
                            // InternalGenoMate.g:1375:7: (lv_excludeAll_10_0= ruleBOOL )
                            {
                            // InternalGenoMate.g:1375:7: (lv_excludeAll_10_0= ruleBOOL )
                            // InternalGenoMate.g:1376:8: lv_excludeAll_10_0= ruleBOOL
                            {

                            								newCompositeNode(grammarAccess.getDtoDefinitionAccess().getExcludeAllBOOLParserRuleCall_5_2_1_1_0());
                            							
                            pushFollow(FOLLOW_14);
                            lv_excludeAll_10_0=ruleBOOL();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getDtoDefinitionRule());
                            								}
                            								set(
                            									current,
                            									"excludeAll",
                            									lv_excludeAll_10_0,
                            									"com.yunzhi.GenoMate.BOOL");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            otherlv_11=(Token)match(input,22,FOLLOW_11); 

                            						newLeafNode(otherlv_11, grammarAccess.getDtoDefinitionAccess().getSemicolonKeyword_5_2_1_2());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,20,FOLLOW_45); 

                    				newLeafNode(otherlv_12, grammarAccess.getDtoDefinitionAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalGenoMate.g:1404:3: (otherlv_13= 'fieldValidation' otherlv_14= '{' ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) ) otherlv_16= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==40) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalGenoMate.g:1405:4: otherlv_13= 'fieldValidation' otherlv_14= '{' ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) ) otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,40,FOLLOW_6); 

                    				newLeafNode(otherlv_13, grammarAccess.getDtoDefinitionAccess().getFieldValidationKeyword_6_0());
                    			
                    otherlv_14=(Token)match(input,17,FOLLOW_46); 

                    				newLeafNode(otherlv_14, grammarAccess.getDtoDefinitionAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalGenoMate.g:1413:4: ( (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock ) )
                    // InternalGenoMate.g:1414:5: (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock )
                    {
                    // InternalGenoMate.g:1414:5: (lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock )
                    // InternalGenoMate.g:1415:6: lv_fieldAnnotationsBlock_15_0= ruleFieldValidationBlock
                    {

                    						newCompositeNode(grammarAccess.getDtoDefinitionAccess().getFieldAnnotationsBlockFieldValidationBlockParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_fieldAnnotationsBlock_15_0=ruleFieldValidationBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDtoDefinitionRule());
                    						}
                    						set(
                    							current,
                    							"fieldAnnotationsBlock",
                    							lv_fieldAnnotationsBlock_15_0,
                    							"com.yunzhi.GenoMate.FieldValidationBlock");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,20,FOLLOW_34); 

                    				newLeafNode(otherlv_16, grammarAccess.getDtoDefinitionAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            // InternalGenoMate.g:1437:3: (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleDtoAddField ) )* otherlv_20= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==35) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalGenoMate.g:1438:4: otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleDtoAddField ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_17, grammarAccess.getDtoDefinitionAccess().getFieldAddKeyword_7_0());
                    			
                    otherlv_18=(Token)match(input,17,FOLLOW_35); 

                    				newLeafNode(otherlv_18, grammarAccess.getDtoDefinitionAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalGenoMate.g:1446:4: ( (lv_addField_19_0= ruleDtoAddField ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==58) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalGenoMate.g:1447:5: (lv_addField_19_0= ruleDtoAddField )
                    	    {
                    	    // InternalGenoMate.g:1447:5: (lv_addField_19_0= ruleDtoAddField )
                    	    // InternalGenoMate.g:1448:6: lv_addField_19_0= ruleDtoAddField
                    	    {

                    	    						newCompositeNode(grammarAccess.getDtoDefinitionAccess().getAddFieldDtoAddFieldParserRuleCall_7_2_0());
                    	    					
                    	    pushFollow(FOLLOW_35);
                    	    lv_addField_19_0=ruleDtoAddField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDtoDefinitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"addField",
                    	    							lv_addField_19_0,
                    	    							"com.yunzhi.GenoMate.DtoAddField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,20,FOLLOW_11); 

                    				newLeafNode(otherlv_20, grammarAccess.getDtoDefinitionAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }

            otherlv_21=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getDtoDefinitionAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDtoDefinition"


    // $ANTLR start "entryRuleVoDefinition"
    // InternalGenoMate.g:1478:1: entryRuleVoDefinition returns [EObject current=null] : iv_ruleVoDefinition= ruleVoDefinition EOF ;
    public final EObject entryRuleVoDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoDefinition = null;


        try {
            // InternalGenoMate.g:1478:53: (iv_ruleVoDefinition= ruleVoDefinition EOF )
            // InternalGenoMate.g:1479:2: iv_ruleVoDefinition= ruleVoDefinition EOF
            {
             newCompositeNode(grammarAccess.getVoDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVoDefinition=ruleVoDefinition();

            state._fsp--;

             current =iv_ruleVoDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoDefinition"


    // $ANTLR start "ruleVoDefinition"
    // InternalGenoMate.g:1485:1: ruleVoDefinition returns [EObject current=null] : (otherlv_0= 'vo' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldJackson' otherlv_14= '{' ( (lv_jacksons_15_0= ruleVoJackson ) )* otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleVoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' ) ;
    public final EObject ruleVoDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_serializable_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        EObject lv_lombokAnnotation_5_0 = null;

        EObject lv_exclusions_8_0 = null;

        AntlrDatatypeRuleToken lv_excludeAll_10_0 = null;

        EObject lv_jacksons_15_0 = null;

        EObject lv_addField_19_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1491:2: ( (otherlv_0= 'vo' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldJackson' otherlv_14= '{' ( (lv_jacksons_15_0= ruleVoJackson ) )* otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleVoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' ) )
            // InternalGenoMate.g:1492:2: (otherlv_0= 'vo' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldJackson' otherlv_14= '{' ( (lv_jacksons_15_0= ruleVoJackson ) )* otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleVoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' )
            {
            // InternalGenoMate.g:1492:2: (otherlv_0= 'vo' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldJackson' otherlv_14= '{' ( (lv_jacksons_15_0= ruleVoJackson ) )* otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleVoAddField ) )* otherlv_20= '}' )? otherlv_21= '}' )
            // InternalGenoMate.g:1493:3: otherlv_0= 'vo' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_serializable_3_0= 'Serializable' ) )? (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )? (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )? (otherlv_13= 'fieldJackson' otherlv_14= '{' ( (lv_jacksons_15_0= ruleVoJackson ) )* otherlv_16= '}' )? (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleVoAddField ) )* otherlv_20= '}' )? otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getVoDefinitionAccess().getVoKeyword_0());
            		
            // InternalGenoMate.g:1497:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGenoMate.g:1498:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGenoMate.g:1498:4: (lv_name_1_0= RULE_ID )
            // InternalGenoMate.g:1499:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVoDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVoDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getVoDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalGenoMate.g:1519:3: ( (lv_serializable_3_0= 'Serializable' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==31) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalGenoMate.g:1520:4: (lv_serializable_3_0= 'Serializable' )
                    {
                    // InternalGenoMate.g:1520:4: (lv_serializable_3_0= 'Serializable' )
                    // InternalGenoMate.g:1521:5: lv_serializable_3_0= 'Serializable'
                    {
                    lv_serializable_3_0=(Token)match(input,31,FOLLOW_48); 

                    					newLeafNode(lv_serializable_3_0, grammarAccess.getVoDefinitionAccess().getSerializableSerializableKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getVoDefinitionRule());
                    					}
                    					setWithLastConsumed(current, "serializable", lv_serializable_3_0, "Serializable");
                    				

                    }


                    }
                    break;

            }

            // InternalGenoMate.g:1533:3: (otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==32) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalGenoMate.g:1534:4: otherlv_4= 'lombok:' ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )*
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_49); 

                    				newLeafNode(otherlv_4, grammarAccess.getVoDefinitionAccess().getLombokKeyword_4_0());
                    			
                    // InternalGenoMate.g:1538:4: ( (lv_lombokAnnotation_5_0= ruleLombokAnnotation ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==23) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalGenoMate.g:1539:5: (lv_lombokAnnotation_5_0= ruleLombokAnnotation )
                    	    {
                    	    // InternalGenoMate.g:1539:5: (lv_lombokAnnotation_5_0= ruleLombokAnnotation )
                    	    // InternalGenoMate.g:1540:6: lv_lombokAnnotation_5_0= ruleLombokAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getVoDefinitionAccess().getLombokAnnotationLombokAnnotationParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_49);
                    	    lv_lombokAnnotation_5_0=ruleLombokAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVoDefinitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"lombokAnnotation",
                    	    							lv_lombokAnnotation_5_0,
                    	    							"com.yunzhi.GenoMate.LombokAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGenoMate.g:1558:3: (otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==38) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalGenoMate.g:1559:4: otherlv_6= 'fieldExclude' otherlv_7= '{' ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) ) otherlv_12= '}'
                    {
                    otherlv_6=(Token)match(input,38,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getVoDefinitionAccess().getFieldExcludeKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,17,FOLLOW_43); 

                    				newLeafNode(otherlv_7, grammarAccess.getVoDefinitionAccess().getLeftCurlyBracketKeyword_5_1());
                    			
                    // InternalGenoMate.g:1567:4: ( ( (lv_exclusions_8_0= ruleExclusions ) )* | (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' ) )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==20||LA43_0==59) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==39) ) {
                        alt43=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalGenoMate.g:1568:5: ( (lv_exclusions_8_0= ruleExclusions ) )*
                            {
                            // InternalGenoMate.g:1568:5: ( (lv_exclusions_8_0= ruleExclusions ) )*
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==59) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // InternalGenoMate.g:1569:6: (lv_exclusions_8_0= ruleExclusions )
                            	    {
                            	    // InternalGenoMate.g:1569:6: (lv_exclusions_8_0= ruleExclusions )
                            	    // InternalGenoMate.g:1570:7: lv_exclusions_8_0= ruleExclusions
                            	    {

                            	    							newCompositeNode(grammarAccess.getVoDefinitionAccess().getExclusionsExclusionsParserRuleCall_5_2_0_0());
                            	    						
                            	    pushFollow(FOLLOW_44);
                            	    lv_exclusions_8_0=ruleExclusions();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getVoDefinitionRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"exclusions",
                            	    								lv_exclusions_8_0,
                            	    								"com.yunzhi.GenoMate.Exclusions");
                            	    							afterParserOrEnumRuleCall();
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop42;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalGenoMate.g:1588:5: (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' )
                            {
                            // InternalGenoMate.g:1588:5: (otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';' )
                            // InternalGenoMate.g:1589:6: otherlv_9= 'excludeAll:' ( (lv_excludeAll_10_0= ruleBOOL ) ) otherlv_11= ';'
                            {
                            otherlv_9=(Token)match(input,39,FOLLOW_25); 

                            						newLeafNode(otherlv_9, grammarAccess.getVoDefinitionAccess().getExcludeAllKeyword_5_2_1_0());
                            					
                            // InternalGenoMate.g:1593:6: ( (lv_excludeAll_10_0= ruleBOOL ) )
                            // InternalGenoMate.g:1594:7: (lv_excludeAll_10_0= ruleBOOL )
                            {
                            // InternalGenoMate.g:1594:7: (lv_excludeAll_10_0= ruleBOOL )
                            // InternalGenoMate.g:1595:8: lv_excludeAll_10_0= ruleBOOL
                            {

                            								newCompositeNode(grammarAccess.getVoDefinitionAccess().getExcludeAllBOOLParserRuleCall_5_2_1_1_0());
                            							
                            pushFollow(FOLLOW_14);
                            lv_excludeAll_10_0=ruleBOOL();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getVoDefinitionRule());
                            								}
                            								set(
                            									current,
                            									"excludeAll",
                            									lv_excludeAll_10_0,
                            									"com.yunzhi.GenoMate.BOOL");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            otherlv_11=(Token)match(input,22,FOLLOW_11); 

                            						newLeafNode(otherlv_11, grammarAccess.getVoDefinitionAccess().getSemicolonKeyword_5_2_1_2());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,20,FOLLOW_50); 

                    				newLeafNode(otherlv_12, grammarAccess.getVoDefinitionAccess().getRightCurlyBracketKeyword_5_3());
                    			

                    }
                    break;

            }

            // InternalGenoMate.g:1623:3: (otherlv_13= 'fieldJackson' otherlv_14= '{' ( (lv_jacksons_15_0= ruleVoJackson ) )* otherlv_16= '}' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalGenoMate.g:1624:4: otherlv_13= 'fieldJackson' otherlv_14= '{' ( (lv_jacksons_15_0= ruleVoJackson ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,41,FOLLOW_6); 

                    				newLeafNode(otherlv_13, grammarAccess.getVoDefinitionAccess().getFieldJacksonKeyword_6_0());
                    			
                    otherlv_14=(Token)match(input,17,FOLLOW_33); 

                    				newLeafNode(otherlv_14, grammarAccess.getVoDefinitionAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalGenoMate.g:1632:4: ( (lv_jacksons_15_0= ruleVoJackson ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==42) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalGenoMate.g:1633:5: (lv_jacksons_15_0= ruleVoJackson )
                    	    {
                    	    // InternalGenoMate.g:1633:5: (lv_jacksons_15_0= ruleVoJackson )
                    	    // InternalGenoMate.g:1634:6: lv_jacksons_15_0= ruleVoJackson
                    	    {

                    	    						newCompositeNode(grammarAccess.getVoDefinitionAccess().getJacksonsVoJacksonParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_jacksons_15_0=ruleVoJackson();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVoDefinitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"jacksons",
                    	    							lv_jacksons_15_0,
                    	    							"com.yunzhi.GenoMate.VoJackson");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,20,FOLLOW_34); 

                    				newLeafNode(otherlv_16, grammarAccess.getVoDefinitionAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            // InternalGenoMate.g:1656:3: (otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleVoAddField ) )* otherlv_20= '}' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==35) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalGenoMate.g:1657:4: otherlv_17= 'fieldAdd' otherlv_18= '{' ( (lv_addField_19_0= ruleVoAddField ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_17, grammarAccess.getVoDefinitionAccess().getFieldAddKeyword_7_0());
                    			
                    otherlv_18=(Token)match(input,17,FOLLOW_35); 

                    				newLeafNode(otherlv_18, grammarAccess.getVoDefinitionAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalGenoMate.g:1665:4: ( (lv_addField_19_0= ruleVoAddField ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==58) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalGenoMate.g:1666:5: (lv_addField_19_0= ruleVoAddField )
                    	    {
                    	    // InternalGenoMate.g:1666:5: (lv_addField_19_0= ruleVoAddField )
                    	    // InternalGenoMate.g:1667:6: lv_addField_19_0= ruleVoAddField
                    	    {

                    	    						newCompositeNode(grammarAccess.getVoDefinitionAccess().getAddFieldVoAddFieldParserRuleCall_7_2_0());
                    	    					
                    	    pushFollow(FOLLOW_35);
                    	    lv_addField_19_0=ruleVoAddField();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVoDefinitionRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"addField",
                    	    							lv_addField_19_0,
                    	    							"com.yunzhi.GenoMate.VoAddField");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,20,FOLLOW_11); 

                    				newLeafNode(otherlv_20, grammarAccess.getVoDefinitionAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }

            otherlv_21=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getVoDefinitionAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoDefinition"


    // $ANTLR start "entryRuleFieldAnnotation"
    // InternalGenoMate.g:1697:1: entryRuleFieldAnnotation returns [EObject current=null] : iv_ruleFieldAnnotation= ruleFieldAnnotation EOF ;
    public final EObject entryRuleFieldAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldAnnotation = null;


        try {
            // InternalGenoMate.g:1697:56: (iv_ruleFieldAnnotation= ruleFieldAnnotation EOF )
            // InternalGenoMate.g:1698:2: iv_ruleFieldAnnotation= ruleFieldAnnotation EOF
            {
             newCompositeNode(grammarAccess.getFieldAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldAnnotation=ruleFieldAnnotation();

            state._fsp--;

             current =iv_ruleFieldAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldAnnotation"


    // $ANTLR start "ruleFieldAnnotation"
    // InternalGenoMate.g:1704:1: ruleFieldAnnotation returns [EObject current=null] : (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleMybatisPlusFieldAnnotation ) )* ) ;
    public final EObject ruleFieldAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_annList_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1710:2: ( (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleMybatisPlusFieldAnnotation ) )* ) )
            // InternalGenoMate.g:1711:2: (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleMybatisPlusFieldAnnotation ) )* )
            {
            // InternalGenoMate.g:1711:2: (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleMybatisPlusFieldAnnotation ) )* )
            // InternalGenoMate.g:1712:3: otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleMybatisPlusFieldAnnotation ) )*
            {
            otherlv_0=(Token)match(input,42,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getFieldAnnotationAccess().getAsteriskKeyword_0());
            		
            // InternalGenoMate.g:1716:3: ( ( ruleQualifiedName ) )
            // InternalGenoMate.g:1717:4: ( ruleQualifiedName )
            {
            // InternalGenoMate.g:1717:4: ( ruleQualifiedName )
            // InternalGenoMate.g:1718:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldAnnotationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFieldAnnotationAccess().getFieldFieldCrossReference_1_0());
            				
            pushFollow(FOLLOW_51);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getFieldAnnotationAccess().getColonKeyword_2());
            		
            // InternalGenoMate.g:1736:3: ( (lv_annList_3_0= ruleMybatisPlusFieldAnnotation ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==23) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalGenoMate.g:1737:4: (lv_annList_3_0= ruleMybatisPlusFieldAnnotation )
            	    {
            	    // InternalGenoMate.g:1737:4: (lv_annList_3_0= ruleMybatisPlusFieldAnnotation )
            	    // InternalGenoMate.g:1738:5: lv_annList_3_0= ruleMybatisPlusFieldAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getFieldAnnotationAccess().getAnnListMybatisPlusFieldAnnotationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_52);
            	    lv_annList_3_0=ruleMybatisPlusFieldAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFieldAnnotationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annList",
            	    						lv_annList_3_0,
            	    						"com.yunzhi.GenoMate.MybatisPlusFieldAnnotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldAnnotation"


    // $ANTLR start "entryRuleFieldValidationBlock"
    // InternalGenoMate.g:1759:1: entryRuleFieldValidationBlock returns [EObject current=null] : iv_ruleFieldValidationBlock= ruleFieldValidationBlock EOF ;
    public final EObject entryRuleFieldValidationBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldValidationBlock = null;


        try {
            // InternalGenoMate.g:1759:61: (iv_ruleFieldValidationBlock= ruleFieldValidationBlock EOF )
            // InternalGenoMate.g:1760:2: iv_ruleFieldValidationBlock= ruleFieldValidationBlock EOF
            {
             newCompositeNode(grammarAccess.getFieldValidationBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldValidationBlock=ruleFieldValidationBlock();

            state._fsp--;

             current =iv_ruleFieldValidationBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldValidationBlock"


    // $ANTLR start "ruleFieldValidationBlock"
    // InternalGenoMate.g:1766:1: ruleFieldValidationBlock returns [EObject current=null] : ( () ( (lv_actionGlobal_1_0= ruleGlobalAction ) )* ( (lv_actionLocal_2_0= ruleLocalLoopAction ) )* ( (lv_actionSingle_3_0= ruleSingleAction ) )? ) ;
    public final EObject ruleFieldValidationBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_actionGlobal_1_0 = null;

        EObject lv_actionLocal_2_0 = null;

        EObject lv_actionSingle_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1772:2: ( ( () ( (lv_actionGlobal_1_0= ruleGlobalAction ) )* ( (lv_actionLocal_2_0= ruleLocalLoopAction ) )* ( (lv_actionSingle_3_0= ruleSingleAction ) )? ) )
            // InternalGenoMate.g:1773:2: ( () ( (lv_actionGlobal_1_0= ruleGlobalAction ) )* ( (lv_actionLocal_2_0= ruleLocalLoopAction ) )* ( (lv_actionSingle_3_0= ruleSingleAction ) )? )
            {
            // InternalGenoMate.g:1773:2: ( () ( (lv_actionGlobal_1_0= ruleGlobalAction ) )* ( (lv_actionLocal_2_0= ruleLocalLoopAction ) )* ( (lv_actionSingle_3_0= ruleSingleAction ) )? )
            // InternalGenoMate.g:1774:3: () ( (lv_actionGlobal_1_0= ruleGlobalAction ) )* ( (lv_actionLocal_2_0= ruleLocalLoopAction ) )* ( (lv_actionSingle_3_0= ruleSingleAction ) )?
            {
            // InternalGenoMate.g:1774:3: ()
            // InternalGenoMate.g:1775:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFieldValidationBlockAccess().getFieldValidationBlockAction_0(),
            					current);
            			

            }

            // InternalGenoMate.g:1781:3: ( (lv_actionGlobal_1_0= ruleGlobalAction ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==48) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalGenoMate.g:1782:4: (lv_actionGlobal_1_0= ruleGlobalAction )
            	    {
            	    // InternalGenoMate.g:1782:4: (lv_actionGlobal_1_0= ruleGlobalAction )
            	    // InternalGenoMate.g:1783:5: lv_actionGlobal_1_0= ruleGlobalAction
            	    {

            	    					newCompositeNode(grammarAccess.getFieldValidationBlockAccess().getActionGlobalGlobalActionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_53);
            	    lv_actionGlobal_1_0=ruleGlobalAction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFieldValidationBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"actionGlobal",
            	    						lv_actionGlobal_1_0,
            	    						"com.yunzhi.GenoMate.GlobalAction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // InternalGenoMate.g:1800:3: ( (lv_actionLocal_2_0= ruleLocalLoopAction ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==45) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalGenoMate.g:1801:4: (lv_actionLocal_2_0= ruleLocalLoopAction )
            	    {
            	    // InternalGenoMate.g:1801:4: (lv_actionLocal_2_0= ruleLocalLoopAction )
            	    // InternalGenoMate.g:1802:5: lv_actionLocal_2_0= ruleLocalLoopAction
            	    {

            	    					newCompositeNode(grammarAccess.getFieldValidationBlockAccess().getActionLocalLocalLoopActionParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_actionLocal_2_0=ruleLocalLoopAction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFieldValidationBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"actionLocal",
            	    						lv_actionLocal_2_0,
            	    						"com.yunzhi.GenoMate.LocalLoopAction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            // InternalGenoMate.g:1819:3: ( (lv_actionSingle_3_0= ruleSingleAction ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==44) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalGenoMate.g:1820:4: (lv_actionSingle_3_0= ruleSingleAction )
                    {
                    // InternalGenoMate.g:1820:4: (lv_actionSingle_3_0= ruleSingleAction )
                    // InternalGenoMate.g:1821:5: lv_actionSingle_3_0= ruleSingleAction
                    {

                    					newCompositeNode(grammarAccess.getFieldValidationBlockAccess().getActionSingleSingleActionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_actionSingle_3_0=ruleSingleAction();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFieldValidationBlockRule());
                    					}
                    					set(
                    						current,
                    						"actionSingle",
                    						lv_actionSingle_3_0,
                    						"com.yunzhi.GenoMate.SingleAction");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldValidationBlock"


    // $ANTLR start "entryRuleSingleAction"
    // InternalGenoMate.g:1842:1: entryRuleSingleAction returns [EObject current=null] : iv_ruleSingleAction= ruleSingleAction EOF ;
    public final EObject entryRuleSingleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAction = null;


        try {
            // InternalGenoMate.g:1842:53: (iv_ruleSingleAction= ruleSingleAction EOF )
            // InternalGenoMate.g:1843:2: iv_ruleSingleAction= ruleSingleAction EOF
            {
             newCompositeNode(grammarAccess.getSingleActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleAction=ruleSingleAction();

            state._fsp--;

             current =iv_ruleSingleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleAction"


    // $ANTLR start "ruleSingleAction"
    // InternalGenoMate.g:1849:1: ruleSingleAction returns [EObject current=null] : (otherlv_0= 'single:' otherlv_1= '{' ( (lv_validations_2_0= ruleDtoValidation ) )+ otherlv_3= '}' ) ;
    public final EObject ruleSingleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_validations_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1855:2: ( (otherlv_0= 'single:' otherlv_1= '{' ( (lv_validations_2_0= ruleDtoValidation ) )+ otherlv_3= '}' ) )
            // InternalGenoMate.g:1856:2: (otherlv_0= 'single:' otherlv_1= '{' ( (lv_validations_2_0= ruleDtoValidation ) )+ otherlv_3= '}' )
            {
            // InternalGenoMate.g:1856:2: (otherlv_0= 'single:' otherlv_1= '{' ( (lv_validations_2_0= ruleDtoValidation ) )+ otherlv_3= '}' )
            // InternalGenoMate.g:1857:3: otherlv_0= 'single:' otherlv_1= '{' ( (lv_validations_2_0= ruleDtoValidation ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSingleActionAccess().getSingleKeyword_0());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getSingleActionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalGenoMate.g:1865:3: ( (lv_validations_2_0= ruleDtoValidation ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==42) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalGenoMate.g:1866:4: (lv_validations_2_0= ruleDtoValidation )
            	    {
            	    // InternalGenoMate.g:1866:4: (lv_validations_2_0= ruleDtoValidation )
            	    // InternalGenoMate.g:1867:5: lv_validations_2_0= ruleDtoValidation
            	    {

            	    					newCompositeNode(grammarAccess.getSingleActionAccess().getValidationsDtoValidationParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_validations_2_0=ruleDtoValidation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSingleActionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"validations",
            	    						lv_validations_2_0,
            	    						"com.yunzhi.GenoMate.DtoValidation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            otherlv_3=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSingleActionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleAction"


    // $ANTLR start "entryRuleLocalLoopAction"
    // InternalGenoMate.g:1892:1: entryRuleLocalLoopAction returns [EObject current=null] : iv_ruleLocalLoopAction= ruleLocalLoopAction EOF ;
    public final EObject entryRuleLocalLoopAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalLoopAction = null;


        try {
            // InternalGenoMate.g:1892:56: (iv_ruleLocalLoopAction= ruleLocalLoopAction EOF )
            // InternalGenoMate.g:1893:2: iv_ruleLocalLoopAction= ruleLocalLoopAction EOF
            {
             newCompositeNode(grammarAccess.getLocalLoopActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalLoopAction=ruleLocalLoopAction();

            state._fsp--;

             current =iv_ruleLocalLoopAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalLoopAction"


    // $ANTLR start "ruleLocalLoopAction"
    // InternalGenoMate.g:1899:1: ruleLocalLoopAction returns [EObject current=null] : (otherlv_0= 'local:' otherlv_1= 'foreach' otherlv_2= 'field' otherlv_3= '{' ( (lv_varDeclarations_4_0= ruleVariableDeclaration ) )* ( (lv_actions_5_0= ruleLocalAction ) )+ otherlv_6= '}' ) ;
    public final EObject ruleLocalLoopAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_varDeclarations_4_0 = null;

        EObject lv_actions_5_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:1905:2: ( (otherlv_0= 'local:' otherlv_1= 'foreach' otherlv_2= 'field' otherlv_3= '{' ( (lv_varDeclarations_4_0= ruleVariableDeclaration ) )* ( (lv_actions_5_0= ruleLocalAction ) )+ otherlv_6= '}' ) )
            // InternalGenoMate.g:1906:2: (otherlv_0= 'local:' otherlv_1= 'foreach' otherlv_2= 'field' otherlv_3= '{' ( (lv_varDeclarations_4_0= ruleVariableDeclaration ) )* ( (lv_actions_5_0= ruleLocalAction ) )+ otherlv_6= '}' )
            {
            // InternalGenoMate.g:1906:2: (otherlv_0= 'local:' otherlv_1= 'foreach' otherlv_2= 'field' otherlv_3= '{' ( (lv_varDeclarations_4_0= ruleVariableDeclaration ) )* ( (lv_actions_5_0= ruleLocalAction ) )+ otherlv_6= '}' )
            // InternalGenoMate.g:1907:3: otherlv_0= 'local:' otherlv_1= 'foreach' otherlv_2= 'field' otherlv_3= '{' ( (lv_varDeclarations_4_0= ruleVariableDeclaration ) )* ( (lv_actions_5_0= ruleLocalAction ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_56); 

            			newLeafNode(otherlv_0, grammarAccess.getLocalLoopActionAccess().getLocalKeyword_0());
            		
            otherlv_1=(Token)match(input,46,FOLLOW_57); 

            			newLeafNode(otherlv_1, grammarAccess.getLocalLoopActionAccess().getForeachKeyword_1());
            		
            otherlv_2=(Token)match(input,47,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getLocalLoopActionAccess().getFieldKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_58); 

            			newLeafNode(otherlv_3, grammarAccess.getLocalLoopActionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalGenoMate.g:1923:3: ( (lv_varDeclarations_4_0= ruleVariableDeclaration ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==57) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalGenoMate.g:1924:4: (lv_varDeclarations_4_0= ruleVariableDeclaration )
            	    {
            	    // InternalGenoMate.g:1924:4: (lv_varDeclarations_4_0= ruleVariableDeclaration )
            	    // InternalGenoMate.g:1925:5: lv_varDeclarations_4_0= ruleVariableDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getLocalLoopActionAccess().getVarDeclarationsVariableDeclarationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_58);
            	    lv_varDeclarations_4_0=ruleVariableDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLocalLoopActionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"varDeclarations",
            	    						lv_varDeclarations_4_0,
            	    						"com.yunzhi.GenoMate.VariableDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // InternalGenoMate.g:1942:3: ( (lv_actions_5_0= ruleLocalAction ) )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==51) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalGenoMate.g:1943:4: (lv_actions_5_0= ruleLocalAction )
            	    {
            	    // InternalGenoMate.g:1943:4: (lv_actions_5_0= ruleLocalAction )
            	    // InternalGenoMate.g:1944:5: lv_actions_5_0= ruleLocalAction
            	    {

            	    					newCompositeNode(grammarAccess.getLocalLoopActionAccess().getActionsLocalActionParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_59);
            	    lv_actions_5_0=ruleLocalAction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLocalLoopActionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"actions",
            	    						lv_actions_5_0,
            	    						"com.yunzhi.GenoMate.LocalAction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getLocalLoopActionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalLoopAction"


    // $ANTLR start "entryRuleGlobalAction"
    // InternalGenoMate.g:1969:1: entryRuleGlobalAction returns [EObject current=null] : iv_ruleGlobalAction= ruleGlobalAction EOF ;
    public final EObject entryRuleGlobalAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalAction = null;


        try {
            // InternalGenoMate.g:1969:53: (iv_ruleGlobalAction= ruleGlobalAction EOF )
            // InternalGenoMate.g:1970:2: iv_ruleGlobalAction= ruleGlobalAction EOF
            {
             newCompositeNode(grammarAccess.getGlobalActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGlobalAction=ruleGlobalAction();

            state._fsp--;

             current =iv_ruleGlobalAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalAction"


    // $ANTLR start "ruleGlobalAction"
    // InternalGenoMate.g:1976:1: ruleGlobalAction returns [EObject current=null] : (otherlv_0= 'global:' otherlv_1= 'set' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' ) ;
    public final EObject ruleGlobalAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalGenoMate.g:1982:2: ( (otherlv_0= 'global:' otherlv_1= 'set' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' ) )
            // InternalGenoMate.g:1983:2: (otherlv_0= 'global:' otherlv_1= 'set' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' )
            {
            // InternalGenoMate.g:1983:2: (otherlv_0= 'global:' otherlv_1= 'set' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' )
            // InternalGenoMate.g:1984:3: otherlv_0= 'global:' otherlv_1= 'set' otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_60); 

            			newLeafNode(otherlv_0, grammarAccess.getGlobalActionAccess().getGlobalKeyword_0());
            		
            otherlv_1=(Token)match(input,49,FOLLOW_61); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalActionAccess().getSetKeyword_1());
            		
            otherlv_2=(Token)match(input,50,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getGlobalActionAccess().getToKeyword_2());
            		
            // InternalGenoMate.g:1996:3: ( (otherlv_3= RULE_ID ) )
            // InternalGenoMate.g:1997:4: (otherlv_3= RULE_ID )
            {
            // InternalGenoMate.g:1997:4: (otherlv_3= RULE_ID )
            // InternalGenoMate.g:1998:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGlobalActionRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_3, grammarAccess.getGlobalActionAccess().getVariableVariableDeclarationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGlobalActionAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalAction"


    // $ANTLR start "entryRuleLocalAction"
    // InternalGenoMate.g:2017:1: entryRuleLocalAction returns [EObject current=null] : iv_ruleLocalAction= ruleLocalAction EOF ;
    public final EObject entryRuleLocalAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalAction = null;


        try {
            // InternalGenoMate.g:2017:52: (iv_ruleLocalAction= ruleLocalAction EOF )
            // InternalGenoMate.g:2018:2: iv_ruleLocalAction= ruleLocalAction EOF
            {
             newCompositeNode(grammarAccess.getLocalActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalAction=ruleLocalAction();

            state._fsp--;

             current =iv_ruleLocalAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalAction"


    // $ANTLR start "ruleLocalAction"
    // InternalGenoMate.g:2024:1: ruleLocalAction returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= 'field' ( (lv_condition_2_0= ruleTypeCondition ) ) otherlv_3= '{' otherlv_4= 'set' otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' otherlv_8= '}' ) ;
    public final EObject ruleLocalAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_condition_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2030:2: ( (otherlv_0= 'if' otherlv_1= 'field' ( (lv_condition_2_0= ruleTypeCondition ) ) otherlv_3= '{' otherlv_4= 'set' otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' otherlv_8= '}' ) )
            // InternalGenoMate.g:2031:2: (otherlv_0= 'if' otherlv_1= 'field' ( (lv_condition_2_0= ruleTypeCondition ) ) otherlv_3= '{' otherlv_4= 'set' otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' otherlv_8= '}' )
            {
            // InternalGenoMate.g:2031:2: (otherlv_0= 'if' otherlv_1= 'field' ( (lv_condition_2_0= ruleTypeCondition ) ) otherlv_3= '{' otherlv_4= 'set' otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' otherlv_8= '}' )
            // InternalGenoMate.g:2032:3: otherlv_0= 'if' otherlv_1= 'field' ( (lv_condition_2_0= ruleTypeCondition ) ) otherlv_3= '{' otherlv_4= 'set' otherlv_5= 'to' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_57); 

            			newLeafNode(otherlv_0, grammarAccess.getLocalActionAccess().getIfKeyword_0());
            		
            otherlv_1=(Token)match(input,47,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getLocalActionAccess().getFieldKeyword_1());
            		
            // InternalGenoMate.g:2040:3: ( (lv_condition_2_0= ruleTypeCondition ) )
            // InternalGenoMate.g:2041:4: (lv_condition_2_0= ruleTypeCondition )
            {
            // InternalGenoMate.g:2041:4: (lv_condition_2_0= ruleTypeCondition )
            // InternalGenoMate.g:2042:5: lv_condition_2_0= ruleTypeCondition
            {

            					newCompositeNode(grammarAccess.getLocalActionAccess().getConditionTypeConditionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_condition_2_0=ruleTypeCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocalActionRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_2_0,
            						"com.yunzhi.GenoMate.TypeCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_60); 

            			newLeafNode(otherlv_3, grammarAccess.getLocalActionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,49,FOLLOW_61); 

            			newLeafNode(otherlv_4, grammarAccess.getLocalActionAccess().getSetKeyword_4());
            		
            otherlv_5=(Token)match(input,50,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getLocalActionAccess().getToKeyword_5());
            		
            // InternalGenoMate.g:2071:3: ( (otherlv_6= RULE_ID ) )
            // InternalGenoMate.g:2072:4: (otherlv_6= RULE_ID )
            {
            // InternalGenoMate.g:2072:4: (otherlv_6= RULE_ID )
            // InternalGenoMate.g:2073:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalActionRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_6, grammarAccess.getLocalActionAccess().getVariableVariableDeclarationCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,22,FOLLOW_11); 

            			newLeafNode(otherlv_7, grammarAccess.getLocalActionAccess().getSemicolonKeyword_7());
            		
            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getLocalActionAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalAction"


    // $ANTLR start "entryRuleTypeCondition"
    // InternalGenoMate.g:2096:1: entryRuleTypeCondition returns [EObject current=null] : iv_ruleTypeCondition= ruleTypeCondition EOF ;
    public final EObject entryRuleTypeCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeCondition = null;


        try {
            // InternalGenoMate.g:2096:54: (iv_ruleTypeCondition= ruleTypeCondition EOF )
            // InternalGenoMate.g:2097:2: iv_ruleTypeCondition= ruleTypeCondition EOF
            {
             newCompositeNode(grammarAccess.getTypeConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeCondition=ruleTypeCondition();

            state._fsp--;

             current =iv_ruleTypeCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeCondition"


    // $ANTLR start "ruleTypeCondition"
    // InternalGenoMate.g:2103:1: ruleTypeCondition returns [EObject current=null] : this_OrTypeCondition_0= ruleOrTypeCondition ;
    public final EObject ruleTypeCondition() throws RecognitionException {
        EObject current = null;

        EObject this_OrTypeCondition_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2109:2: (this_OrTypeCondition_0= ruleOrTypeCondition )
            // InternalGenoMate.g:2110:2: this_OrTypeCondition_0= ruleOrTypeCondition
            {

            		newCompositeNode(grammarAccess.getTypeConditionAccess().getOrTypeConditionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrTypeCondition_0=ruleOrTypeCondition();

            state._fsp--;


            		current = this_OrTypeCondition_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeCondition"


    // $ANTLR start "entryRuleOrTypeCondition"
    // InternalGenoMate.g:2121:1: entryRuleOrTypeCondition returns [EObject current=null] : iv_ruleOrTypeCondition= ruleOrTypeCondition EOF ;
    public final EObject entryRuleOrTypeCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrTypeCondition = null;


        try {
            // InternalGenoMate.g:2121:56: (iv_ruleOrTypeCondition= ruleOrTypeCondition EOF )
            // InternalGenoMate.g:2122:2: iv_ruleOrTypeCondition= ruleOrTypeCondition EOF
            {
             newCompositeNode(grammarAccess.getOrTypeConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrTypeCondition=ruleOrTypeCondition();

            state._fsp--;

             current =iv_ruleOrTypeCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrTypeCondition"


    // $ANTLR start "ruleOrTypeCondition"
    // InternalGenoMate.g:2128:1: ruleOrTypeCondition returns [EObject current=null] : ( ( (lv_left_0_0= ruleAndTypeCondition ) ) (otherlv_1= '||' ( (lv_right_2_0= ruleAndTypeCondition ) ) )* ) ;
    public final EObject ruleOrTypeCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2134:2: ( ( ( (lv_left_0_0= ruleAndTypeCondition ) ) (otherlv_1= '||' ( (lv_right_2_0= ruleAndTypeCondition ) ) )* ) )
            // InternalGenoMate.g:2135:2: ( ( (lv_left_0_0= ruleAndTypeCondition ) ) (otherlv_1= '||' ( (lv_right_2_0= ruleAndTypeCondition ) ) )* )
            {
            // InternalGenoMate.g:2135:2: ( ( (lv_left_0_0= ruleAndTypeCondition ) ) (otherlv_1= '||' ( (lv_right_2_0= ruleAndTypeCondition ) ) )* )
            // InternalGenoMate.g:2136:3: ( (lv_left_0_0= ruleAndTypeCondition ) ) (otherlv_1= '||' ( (lv_right_2_0= ruleAndTypeCondition ) ) )*
            {
            // InternalGenoMate.g:2136:3: ( (lv_left_0_0= ruleAndTypeCondition ) )
            // InternalGenoMate.g:2137:4: (lv_left_0_0= ruleAndTypeCondition )
            {
            // InternalGenoMate.g:2137:4: (lv_left_0_0= ruleAndTypeCondition )
            // InternalGenoMate.g:2138:5: lv_left_0_0= ruleAndTypeCondition
            {

            					newCompositeNode(grammarAccess.getOrTypeConditionAccess().getLeftAndTypeConditionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_63);
            lv_left_0_0=ruleAndTypeCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrTypeConditionRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"com.yunzhi.GenoMate.AndTypeCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:2155:3: (otherlv_1= '||' ( (lv_right_2_0= ruleAndTypeCondition ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==52) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalGenoMate.g:2156:4: otherlv_1= '||' ( (lv_right_2_0= ruleAndTypeCondition ) )
            	    {
            	    otherlv_1=(Token)match(input,52,FOLLOW_62); 

            	    				newLeafNode(otherlv_1, grammarAccess.getOrTypeConditionAccess().getVerticalLineVerticalLineKeyword_1_0());
            	    			
            	    // InternalGenoMate.g:2160:4: ( (lv_right_2_0= ruleAndTypeCondition ) )
            	    // InternalGenoMate.g:2161:5: (lv_right_2_0= ruleAndTypeCondition )
            	    {
            	    // InternalGenoMate.g:2161:5: (lv_right_2_0= ruleAndTypeCondition )
            	    // InternalGenoMate.g:2162:6: lv_right_2_0= ruleAndTypeCondition
            	    {

            	    						newCompositeNode(grammarAccess.getOrTypeConditionAccess().getRightAndTypeConditionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_63);
            	    lv_right_2_0=ruleAndTypeCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrTypeConditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"right",
            	    							lv_right_2_0,
            	    							"com.yunzhi.GenoMate.AndTypeCondition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrTypeCondition"


    // $ANTLR start "entryRuleAndTypeCondition"
    // InternalGenoMate.g:2184:1: entryRuleAndTypeCondition returns [EObject current=null] : iv_ruleAndTypeCondition= ruleAndTypeCondition EOF ;
    public final EObject entryRuleAndTypeCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndTypeCondition = null;


        try {
            // InternalGenoMate.g:2184:57: (iv_ruleAndTypeCondition= ruleAndTypeCondition EOF )
            // InternalGenoMate.g:2185:2: iv_ruleAndTypeCondition= ruleAndTypeCondition EOF
            {
             newCompositeNode(grammarAccess.getAndTypeConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndTypeCondition=ruleAndTypeCondition();

            state._fsp--;

             current =iv_ruleAndTypeCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndTypeCondition"


    // $ANTLR start "ruleAndTypeCondition"
    // InternalGenoMate.g:2191:1: ruleAndTypeCondition returns [EObject current=null] : ( ( (lv_left_0_0= ruleTypeEqualityCondition ) ) (otherlv_1= '&&' ( (lv_right_2_0= ruleTypeEqualityCondition ) ) )* ) ;
    public final EObject ruleAndTypeCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2197:2: ( ( ( (lv_left_0_0= ruleTypeEqualityCondition ) ) (otherlv_1= '&&' ( (lv_right_2_0= ruleTypeEqualityCondition ) ) )* ) )
            // InternalGenoMate.g:2198:2: ( ( (lv_left_0_0= ruleTypeEqualityCondition ) ) (otherlv_1= '&&' ( (lv_right_2_0= ruleTypeEqualityCondition ) ) )* )
            {
            // InternalGenoMate.g:2198:2: ( ( (lv_left_0_0= ruleTypeEqualityCondition ) ) (otherlv_1= '&&' ( (lv_right_2_0= ruleTypeEqualityCondition ) ) )* )
            // InternalGenoMate.g:2199:3: ( (lv_left_0_0= ruleTypeEqualityCondition ) ) (otherlv_1= '&&' ( (lv_right_2_0= ruleTypeEqualityCondition ) ) )*
            {
            // InternalGenoMate.g:2199:3: ( (lv_left_0_0= ruleTypeEqualityCondition ) )
            // InternalGenoMate.g:2200:4: (lv_left_0_0= ruleTypeEqualityCondition )
            {
            // InternalGenoMate.g:2200:4: (lv_left_0_0= ruleTypeEqualityCondition )
            // InternalGenoMate.g:2201:5: lv_left_0_0= ruleTypeEqualityCondition
            {

            					newCompositeNode(grammarAccess.getAndTypeConditionAccess().getLeftTypeEqualityConditionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_64);
            lv_left_0_0=ruleTypeEqualityCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndTypeConditionRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"com.yunzhi.GenoMate.TypeEqualityCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:2218:3: (otherlv_1= '&&' ( (lv_right_2_0= ruleTypeEqualityCondition ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==53) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalGenoMate.g:2219:4: otherlv_1= '&&' ( (lv_right_2_0= ruleTypeEqualityCondition ) )
            	    {
            	    otherlv_1=(Token)match(input,53,FOLLOW_62); 

            	    				newLeafNode(otherlv_1, grammarAccess.getAndTypeConditionAccess().getAmpersandAmpersandKeyword_1_0());
            	    			
            	    // InternalGenoMate.g:2223:4: ( (lv_right_2_0= ruleTypeEqualityCondition ) )
            	    // InternalGenoMate.g:2224:5: (lv_right_2_0= ruleTypeEqualityCondition )
            	    {
            	    // InternalGenoMate.g:2224:5: (lv_right_2_0= ruleTypeEqualityCondition )
            	    // InternalGenoMate.g:2225:6: lv_right_2_0= ruleTypeEqualityCondition
            	    {

            	    						newCompositeNode(grammarAccess.getAndTypeConditionAccess().getRightTypeEqualityConditionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_64);
            	    lv_right_2_0=ruleTypeEqualityCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndTypeConditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"right",
            	    							lv_right_2_0,
            	    							"com.yunzhi.GenoMate.TypeEqualityCondition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndTypeCondition"


    // $ANTLR start "entryRuleTypeEqualityCondition"
    // InternalGenoMate.g:2247:1: entryRuleTypeEqualityCondition returns [EObject current=null] : iv_ruleTypeEqualityCondition= ruleTypeEqualityCondition EOF ;
    public final EObject entryRuleTypeEqualityCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeEqualityCondition = null;


        try {
            // InternalGenoMate.g:2247:62: (iv_ruleTypeEqualityCondition= ruleTypeEqualityCondition EOF )
            // InternalGenoMate.g:2248:2: iv_ruleTypeEqualityCondition= ruleTypeEqualityCondition EOF
            {
             newCompositeNode(grammarAccess.getTypeEqualityConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeEqualityCondition=ruleTypeEqualityCondition();

            state._fsp--;

             current =iv_ruleTypeEqualityCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeEqualityCondition"


    // $ANTLR start "ruleTypeEqualityCondition"
    // InternalGenoMate.g:2254:1: ruleTypeEqualityCondition returns [EObject current=null] : (otherlv_0= 'type' ( ( (lv_isEqual_1_0= '==' ) ) | ( (lv_isNotEqual_2_0= '!=' ) ) ) ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleTypeEqualityCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_isEqual_1_0=null;
        Token lv_isNotEqual_2_0=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2260:2: ( (otherlv_0= 'type' ( ( (lv_isEqual_1_0= '==' ) ) | ( (lv_isNotEqual_2_0= '!=' ) ) ) ( (lv_type_3_0= ruleType ) ) ) )
            // InternalGenoMate.g:2261:2: (otherlv_0= 'type' ( ( (lv_isEqual_1_0= '==' ) ) | ( (lv_isNotEqual_2_0= '!=' ) ) ) ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalGenoMate.g:2261:2: (otherlv_0= 'type' ( ( (lv_isEqual_1_0= '==' ) ) | ( (lv_isNotEqual_2_0= '!=' ) ) ) ( (lv_type_3_0= ruleType ) ) )
            // InternalGenoMate.g:2262:3: otherlv_0= 'type' ( ( (lv_isEqual_1_0= '==' ) ) | ( (lv_isNotEqual_2_0= '!=' ) ) ) ( (lv_type_3_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_65); 

            			newLeafNode(otherlv_0, grammarAccess.getTypeEqualityConditionAccess().getTypeKeyword_0());
            		
            // InternalGenoMate.g:2266:3: ( ( (lv_isEqual_1_0= '==' ) ) | ( (lv_isNotEqual_2_0= '!=' ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==55) ) {
                alt58=1;
            }
            else if ( (LA58_0==56) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalGenoMate.g:2267:4: ( (lv_isEqual_1_0= '==' ) )
                    {
                    // InternalGenoMate.g:2267:4: ( (lv_isEqual_1_0= '==' ) )
                    // InternalGenoMate.g:2268:5: (lv_isEqual_1_0= '==' )
                    {
                    // InternalGenoMate.g:2268:5: (lv_isEqual_1_0= '==' )
                    // InternalGenoMate.g:2269:6: lv_isEqual_1_0= '=='
                    {
                    lv_isEqual_1_0=(Token)match(input,55,FOLLOW_66); 

                    						newLeafNode(lv_isEqual_1_0, grammarAccess.getTypeEqualityConditionAccess().getIsEqualEqualsSignEqualsSignKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeEqualityConditionRule());
                    						}
                    						setWithLastConsumed(current, "isEqual", lv_isEqual_1_0, "==");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:2282:4: ( (lv_isNotEqual_2_0= '!=' ) )
                    {
                    // InternalGenoMate.g:2282:4: ( (lv_isNotEqual_2_0= '!=' ) )
                    // InternalGenoMate.g:2283:5: (lv_isNotEqual_2_0= '!=' )
                    {
                    // InternalGenoMate.g:2283:5: (lv_isNotEqual_2_0= '!=' )
                    // InternalGenoMate.g:2284:6: lv_isNotEqual_2_0= '!='
                    {
                    lv_isNotEqual_2_0=(Token)match(input,56,FOLLOW_66); 

                    						newLeafNode(lv_isNotEqual_2_0, grammarAccess.getTypeEqualityConditionAccess().getIsNotEqualExclamationMarkEqualsSignKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeEqualityConditionRule());
                    						}
                    						setWithLastConsumed(current, "isNotEqual", lv_isNotEqual_2_0, "!=");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalGenoMate.g:2297:3: ( (lv_type_3_0= ruleType ) )
            // InternalGenoMate.g:2298:4: (lv_type_3_0= ruleType )
            {
            // InternalGenoMate.g:2298:4: (lv_type_3_0= ruleType )
            // InternalGenoMate.g:2299:5: lv_type_3_0= ruleType
            {

            					newCompositeNode(grammarAccess.getTypeEqualityConditionAccess().getTypeTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_3_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypeEqualityConditionRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"com.yunzhi.GenoMate.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeEqualityCondition"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalGenoMate.g:2320:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalGenoMate.g:2320:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalGenoMate.g:2321:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalGenoMate.g:2327:1: ruleVariableDeclaration returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_annotation_3_0= ruleBeanValidationAnnotation ) ) otherlv_4= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotation_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2333:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_annotation_3_0= ruleBeanValidationAnnotation ) ) otherlv_4= ';' ) )
            // InternalGenoMate.g:2334:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_annotation_3_0= ruleBeanValidationAnnotation ) ) otherlv_4= ';' )
            {
            // InternalGenoMate.g:2334:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_annotation_3_0= ruleBeanValidationAnnotation ) ) otherlv_4= ';' )
            // InternalGenoMate.g:2335:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_annotation_3_0= ruleBeanValidationAnnotation ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableDeclarationAccess().getVarKeyword_0());
            		
            // InternalGenoMate.g:2339:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGenoMate.g:2340:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGenoMate.g:2340:4: (lv_name_1_0= RULE_ID )
            // InternalGenoMate.g:2341:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_67); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalGenoMate.g:2361:3: ( (lv_annotation_3_0= ruleBeanValidationAnnotation ) )
            // InternalGenoMate.g:2362:4: (lv_annotation_3_0= ruleBeanValidationAnnotation )
            {
            // InternalGenoMate.g:2362:4: (lv_annotation_3_0= ruleBeanValidationAnnotation )
            // InternalGenoMate.g:2363:5: lv_annotation_3_0= ruleBeanValidationAnnotation
            {

            					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getAnnotationBeanValidationAnnotationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_14);
            lv_annotation_3_0=ruleBeanValidationAnnotation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            					}
            					set(
            						current,
            						"annotation",
            						lv_annotation_3_0,
            						"com.yunzhi.GenoMate.BeanValidationAnnotation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getVariableDeclarationAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRulePoAddField"
    // InternalGenoMate.g:2388:1: entryRulePoAddField returns [EObject current=null] : iv_rulePoAddField= rulePoAddField EOF ;
    public final EObject entryRulePoAddField() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoAddField = null;


        try {
            // InternalGenoMate.g:2388:51: (iv_rulePoAddField= rulePoAddField EOF )
            // InternalGenoMate.g:2389:2: iv_rulePoAddField= rulePoAddField EOF
            {
             newCompositeNode(grammarAccess.getPoAddFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoAddField=rulePoAddField();

            state._fsp--;

             current =iv_rulePoAddField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoAddField"


    // $ANTLR start "rulePoAddField"
    // InternalGenoMate.g:2395:1: rulePoAddField returns [EObject current=null] : (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )* )? ) ;
    public final EObject rulePoAddField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_properties_1_0 = null;

        EObject lv_annotationList_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2401:2: ( (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )* )? ) )
            // InternalGenoMate.g:2402:2: (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )* )? )
            {
            // InternalGenoMate.g:2402:2: (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )* )? )
            // InternalGenoMate.g:2403:3: otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )* )?
            {
            otherlv_0=(Token)match(input,58,FOLLOW_68); 

            			newLeafNode(otherlv_0, grammarAccess.getPoAddFieldAccess().getPlusSignKeyword_0());
            		
            // InternalGenoMate.g:2407:3: ( (lv_properties_1_0= rulePropertyDeclaration ) )
            // InternalGenoMate.g:2408:4: (lv_properties_1_0= rulePropertyDeclaration )
            {
            // InternalGenoMate.g:2408:4: (lv_properties_1_0= rulePropertyDeclaration )
            // InternalGenoMate.g:2409:5: lv_properties_1_0= rulePropertyDeclaration
            {

            					newCompositeNode(grammarAccess.getPoAddFieldAccess().getPropertiesPropertyDeclarationParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_69);
            lv_properties_1_0=rulePropertyDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPoAddFieldRule());
            					}
            					set(
            						current,
            						"properties",
            						lv_properties_1_0,
            						"com.yunzhi.GenoMate.PropertyDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:2426:3: (otherlv_2= ':' ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==43) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalGenoMate.g:2427:4: otherlv_2= ':' ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )*
                    {
                    otherlv_2=(Token)match(input,43,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getPoAddFieldAccess().getColonKeyword_2_0());
                    			
                    // InternalGenoMate.g:2431:4: ( (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==23) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // InternalGenoMate.g:2432:5: (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation )
                    	    {
                    	    // InternalGenoMate.g:2432:5: (lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation )
                    	    // InternalGenoMate.g:2433:6: lv_annotationList_3_0= ruleMybatisPlusFieldAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getPoAddFieldAccess().getAnnotationListMybatisPlusFieldAnnotationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
                    	    lv_annotationList_3_0=ruleMybatisPlusFieldAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getPoAddFieldRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"annotationList",
                    	    							lv_annotationList_3_0,
                    	    							"com.yunzhi.GenoMate.MybatisPlusFieldAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoAddField"


    // $ANTLR start "entryRuleDtoAddField"
    // InternalGenoMate.g:2455:1: entryRuleDtoAddField returns [EObject current=null] : iv_ruleDtoAddField= ruleDtoAddField EOF ;
    public final EObject entryRuleDtoAddField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDtoAddField = null;


        try {
            // InternalGenoMate.g:2455:52: (iv_ruleDtoAddField= ruleDtoAddField EOF )
            // InternalGenoMate.g:2456:2: iv_ruleDtoAddField= ruleDtoAddField EOF
            {
             newCompositeNode(grammarAccess.getDtoAddFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDtoAddField=ruleDtoAddField();

            state._fsp--;

             current =iv_ruleDtoAddField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDtoAddField"


    // $ANTLR start "ruleDtoAddField"
    // InternalGenoMate.g:2462:1: ruleDtoAddField returns [EObject current=null] : (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )* )? ) ;
    public final EObject ruleDtoAddField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_properties_1_0 = null;

        EObject lv_annotationList_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2468:2: ( (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )* )? ) )
            // InternalGenoMate.g:2469:2: (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )* )? )
            {
            // InternalGenoMate.g:2469:2: (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )* )? )
            // InternalGenoMate.g:2470:3: otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )* )?
            {
            otherlv_0=(Token)match(input,58,FOLLOW_68); 

            			newLeafNode(otherlv_0, grammarAccess.getDtoAddFieldAccess().getPlusSignKeyword_0());
            		
            // InternalGenoMate.g:2474:3: ( (lv_properties_1_0= rulePropertyDeclaration ) )
            // InternalGenoMate.g:2475:4: (lv_properties_1_0= rulePropertyDeclaration )
            {
            // InternalGenoMate.g:2475:4: (lv_properties_1_0= rulePropertyDeclaration )
            // InternalGenoMate.g:2476:5: lv_properties_1_0= rulePropertyDeclaration
            {

            					newCompositeNode(grammarAccess.getDtoAddFieldAccess().getPropertiesPropertyDeclarationParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_69);
            lv_properties_1_0=rulePropertyDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDtoAddFieldRule());
            					}
            					set(
            						current,
            						"properties",
            						lv_properties_1_0,
            						"com.yunzhi.GenoMate.PropertyDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:2493:3: (otherlv_2= ':' ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==43) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalGenoMate.g:2494:4: otherlv_2= ':' ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )*
                    {
                    otherlv_2=(Token)match(input,43,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getDtoAddFieldAccess().getColonKeyword_2_0());
                    			
                    // InternalGenoMate.g:2498:4: ( (lv_annotationList_3_0= ruleBeanValidationAnnotation ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==23) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalGenoMate.g:2499:5: (lv_annotationList_3_0= ruleBeanValidationAnnotation )
                    	    {
                    	    // InternalGenoMate.g:2499:5: (lv_annotationList_3_0= ruleBeanValidationAnnotation )
                    	    // InternalGenoMate.g:2500:6: lv_annotationList_3_0= ruleBeanValidationAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getDtoAddFieldAccess().getAnnotationListBeanValidationAnnotationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
                    	    lv_annotationList_3_0=ruleBeanValidationAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDtoAddFieldRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"annotationList",
                    	    							lv_annotationList_3_0,
                    	    							"com.yunzhi.GenoMate.BeanValidationAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDtoAddField"


    // $ANTLR start "entryRuleVoAddField"
    // InternalGenoMate.g:2522:1: entryRuleVoAddField returns [EObject current=null] : iv_ruleVoAddField= ruleVoAddField EOF ;
    public final EObject entryRuleVoAddField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoAddField = null;


        try {
            // InternalGenoMate.g:2522:51: (iv_ruleVoAddField= ruleVoAddField EOF )
            // InternalGenoMate.g:2523:2: iv_ruleVoAddField= ruleVoAddField EOF
            {
             newCompositeNode(grammarAccess.getVoAddFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVoAddField=ruleVoAddField();

            state._fsp--;

             current =iv_ruleVoAddField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoAddField"


    // $ANTLR start "ruleVoAddField"
    // InternalGenoMate.g:2529:1: ruleVoAddField returns [EObject current=null] : (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )* )? ) ;
    public final EObject ruleVoAddField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_properties_1_0 = null;

        EObject lv_annotationList_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2535:2: ( (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )* )? ) )
            // InternalGenoMate.g:2536:2: (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )* )? )
            {
            // InternalGenoMate.g:2536:2: (otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )* )? )
            // InternalGenoMate.g:2537:3: otherlv_0= '+' ( (lv_properties_1_0= rulePropertyDeclaration ) ) (otherlv_2= ':' ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )* )?
            {
            otherlv_0=(Token)match(input,58,FOLLOW_68); 

            			newLeafNode(otherlv_0, grammarAccess.getVoAddFieldAccess().getPlusSignKeyword_0());
            		
            // InternalGenoMate.g:2541:3: ( (lv_properties_1_0= rulePropertyDeclaration ) )
            // InternalGenoMate.g:2542:4: (lv_properties_1_0= rulePropertyDeclaration )
            {
            // InternalGenoMate.g:2542:4: (lv_properties_1_0= rulePropertyDeclaration )
            // InternalGenoMate.g:2543:5: lv_properties_1_0= rulePropertyDeclaration
            {

            					newCompositeNode(grammarAccess.getVoAddFieldAccess().getPropertiesPropertyDeclarationParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_69);
            lv_properties_1_0=rulePropertyDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVoAddFieldRule());
            					}
            					set(
            						current,
            						"properties",
            						lv_properties_1_0,
            						"com.yunzhi.GenoMate.PropertyDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:2560:3: (otherlv_2= ':' ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==43) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalGenoMate.g:2561:4: otherlv_2= ':' ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )*
                    {
                    otherlv_2=(Token)match(input,43,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getVoAddFieldAccess().getColonKeyword_2_0());
                    			
                    // InternalGenoMate.g:2565:4: ( (lv_annotationList_3_0= ruleJacksonAnnotation ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==23) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalGenoMate.g:2566:5: (lv_annotationList_3_0= ruleJacksonAnnotation )
                    	    {
                    	    // InternalGenoMate.g:2566:5: (lv_annotationList_3_0= ruleJacksonAnnotation )
                    	    // InternalGenoMate.g:2567:6: lv_annotationList_3_0= ruleJacksonAnnotation
                    	    {

                    	    						newCompositeNode(grammarAccess.getVoAddFieldAccess().getAnnotationListJacksonAnnotationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
                    	    lv_annotationList_3_0=ruleJacksonAnnotation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getVoAddFieldRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"annotationList",
                    	    							lv_annotationList_3_0,
                    	    							"com.yunzhi.GenoMate.JacksonAnnotation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoAddField"


    // $ANTLR start "entryRuleExclusions"
    // InternalGenoMate.g:2589:1: entryRuleExclusions returns [EObject current=null] : iv_ruleExclusions= ruleExclusions EOF ;
    public final EObject entryRuleExclusions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusions = null;


        try {
            // InternalGenoMate.g:2589:51: (iv_ruleExclusions= ruleExclusions EOF )
            // InternalGenoMate.g:2590:2: iv_ruleExclusions= ruleExclusions EOF
            {
             newCompositeNode(grammarAccess.getExclusionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExclusions=ruleExclusions();

            state._fsp--;

             current =iv_ruleExclusions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExclusions"


    // $ANTLR start "ruleExclusions"
    // InternalGenoMate.g:2596:1: ruleExclusions returns [EObject current=null] : (otherlv_0= '-' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleExclusions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGenoMate.g:2602:2: ( (otherlv_0= '-' ( ( ruleQualifiedName ) ) ) )
            // InternalGenoMate.g:2603:2: (otherlv_0= '-' ( ( ruleQualifiedName ) ) )
            {
            // InternalGenoMate.g:2603:2: (otherlv_0= '-' ( ( ruleQualifiedName ) ) )
            // InternalGenoMate.g:2604:3: otherlv_0= '-' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getExclusionsAccess().getHyphenMinusKeyword_0());
            		
            // InternalGenoMate.g:2608:3: ( ( ruleQualifiedName ) )
            // InternalGenoMate.g:2609:4: ( ruleQualifiedName )
            {
            // InternalGenoMate.g:2609:4: ( ruleQualifiedName )
            // InternalGenoMate.g:2610:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExclusionsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExclusionsAccess().getFieldFieldCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExclusions"


    // $ANTLR start "entryRuleDtoValidation"
    // InternalGenoMate.g:2628:1: entryRuleDtoValidation returns [EObject current=null] : iv_ruleDtoValidation= ruleDtoValidation EOF ;
    public final EObject entryRuleDtoValidation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDtoValidation = null;


        try {
            // InternalGenoMate.g:2628:54: (iv_ruleDtoValidation= ruleDtoValidation EOF )
            // InternalGenoMate.g:2629:2: iv_ruleDtoValidation= ruleDtoValidation EOF
            {
             newCompositeNode(grammarAccess.getDtoValidationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDtoValidation=ruleDtoValidation();

            state._fsp--;

             current =iv_ruleDtoValidation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDtoValidation"


    // $ANTLR start "ruleDtoValidation"
    // InternalGenoMate.g:2635:1: ruleDtoValidation returns [EObject current=null] : (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleBeanValidationAnnotation ) )* ) ;
    public final EObject ruleDtoValidation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_annList_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2641:2: ( (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleBeanValidationAnnotation ) )* ) )
            // InternalGenoMate.g:2642:2: (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleBeanValidationAnnotation ) )* )
            {
            // InternalGenoMate.g:2642:2: (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleBeanValidationAnnotation ) )* )
            // InternalGenoMate.g:2643:3: otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleBeanValidationAnnotation ) )*
            {
            otherlv_0=(Token)match(input,42,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getDtoValidationAccess().getAsteriskKeyword_0());
            		
            // InternalGenoMate.g:2647:3: ( ( ruleQualifiedName ) )
            // InternalGenoMate.g:2648:4: ( ruleQualifiedName )
            {
            // InternalGenoMate.g:2648:4: ( ruleQualifiedName )
            // InternalGenoMate.g:2649:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDtoValidationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDtoValidationAccess().getFieldFieldCrossReference_1_0());
            				
            pushFollow(FOLLOW_51);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getDtoValidationAccess().getColonKeyword_2());
            		
            // InternalGenoMate.g:2667:3: ( (lv_annList_3_0= ruleBeanValidationAnnotation ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==23) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalGenoMate.g:2668:4: (lv_annList_3_0= ruleBeanValidationAnnotation )
            	    {
            	    // InternalGenoMate.g:2668:4: (lv_annList_3_0= ruleBeanValidationAnnotation )
            	    // InternalGenoMate.g:2669:5: lv_annList_3_0= ruleBeanValidationAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getDtoValidationAccess().getAnnListBeanValidationAnnotationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_52);
            	    lv_annList_3_0=ruleBeanValidationAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDtoValidationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annList",
            	    						lv_annList_3_0,
            	    						"com.yunzhi.GenoMate.BeanValidationAnnotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDtoValidation"


    // $ANTLR start "entryRuleVoJackson"
    // InternalGenoMate.g:2690:1: entryRuleVoJackson returns [EObject current=null] : iv_ruleVoJackson= ruleVoJackson EOF ;
    public final EObject entryRuleVoJackson() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoJackson = null;


        try {
            // InternalGenoMate.g:2690:50: (iv_ruleVoJackson= ruleVoJackson EOF )
            // InternalGenoMate.g:2691:2: iv_ruleVoJackson= ruleVoJackson EOF
            {
             newCompositeNode(grammarAccess.getVoJacksonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVoJackson=ruleVoJackson();

            state._fsp--;

             current =iv_ruleVoJackson; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoJackson"


    // $ANTLR start "ruleVoJackson"
    // InternalGenoMate.g:2697:1: ruleVoJackson returns [EObject current=null] : (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleJacksonAnnotation ) )* ) ;
    public final EObject ruleVoJackson() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_annList_3_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2703:2: ( (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleJacksonAnnotation ) )* ) )
            // InternalGenoMate.g:2704:2: (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleJacksonAnnotation ) )* )
            {
            // InternalGenoMate.g:2704:2: (otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleJacksonAnnotation ) )* )
            // InternalGenoMate.g:2705:3: otherlv_0= '*' ( ( ruleQualifiedName ) ) otherlv_2= ':' ( (lv_annList_3_0= ruleJacksonAnnotation ) )*
            {
            otherlv_0=(Token)match(input,42,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getVoJacksonAccess().getAsteriskKeyword_0());
            		
            // InternalGenoMate.g:2709:3: ( ( ruleQualifiedName ) )
            // InternalGenoMate.g:2710:4: ( ruleQualifiedName )
            {
            // InternalGenoMate.g:2710:4: ( ruleQualifiedName )
            // InternalGenoMate.g:2711:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVoJacksonRule());
            					}
            				

            					newCompositeNode(grammarAccess.getVoJacksonAccess().getFieldFieldCrossReference_1_0());
            				
            pushFollow(FOLLOW_51);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getVoJacksonAccess().getColonKeyword_2());
            		
            // InternalGenoMate.g:2729:3: ( (lv_annList_3_0= ruleJacksonAnnotation ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==23) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalGenoMate.g:2730:4: (lv_annList_3_0= ruleJacksonAnnotation )
            	    {
            	    // InternalGenoMate.g:2730:4: (lv_annList_3_0= ruleJacksonAnnotation )
            	    // InternalGenoMate.g:2731:5: lv_annList_3_0= ruleJacksonAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getVoJacksonAccess().getAnnListJacksonAnnotationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_52);
            	    lv_annList_3_0=ruleJacksonAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getVoJacksonRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annList",
            	    						lv_annList_3_0,
            	    						"com.yunzhi.GenoMate.JacksonAnnotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoJackson"


    // $ANTLR start "entryRulePropertyDeclaration"
    // InternalGenoMate.g:2752:1: entryRulePropertyDeclaration returns [EObject current=null] : iv_rulePropertyDeclaration= rulePropertyDeclaration EOF ;
    public final EObject entryRulePropertyDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDeclaration = null;


        try {
            // InternalGenoMate.g:2752:60: (iv_rulePropertyDeclaration= rulePropertyDeclaration EOF )
            // InternalGenoMate.g:2753:2: iv_rulePropertyDeclaration= rulePropertyDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPropertyDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyDeclaration=rulePropertyDeclaration();

            state._fsp--;

             current =iv_rulePropertyDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyDeclaration"


    // $ANTLR start "rulePropertyDeclaration"
    // InternalGenoMate.g:2759:1: rulePropertyDeclaration returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_defaultClause_4_0= ruleDefaultClause ) )? ) ;
    public final EObject rulePropertyDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        Token lv_final_1_0=null;
        Token lv_name_3_0=null;
        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_defaultClause_4_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2765:2: ( ( ( (lv_static_0_0= 'static' ) )? ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_defaultClause_4_0= ruleDefaultClause ) )? ) )
            // InternalGenoMate.g:2766:2: ( ( (lv_static_0_0= 'static' ) )? ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_defaultClause_4_0= ruleDefaultClause ) )? )
            {
            // InternalGenoMate.g:2766:2: ( ( (lv_static_0_0= 'static' ) )? ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_defaultClause_4_0= ruleDefaultClause ) )? )
            // InternalGenoMate.g:2767:3: ( (lv_static_0_0= 'static' ) )? ( (lv_final_1_0= 'final' ) )? ( (lv_type_2_0= ruleType ) ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_defaultClause_4_0= ruleDefaultClause ) )?
            {
            // InternalGenoMate.g:2767:3: ( (lv_static_0_0= 'static' ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==60) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalGenoMate.g:2768:4: (lv_static_0_0= 'static' )
                    {
                    // InternalGenoMate.g:2768:4: (lv_static_0_0= 'static' )
                    // InternalGenoMate.g:2769:5: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)match(input,60,FOLLOW_70); 

                    					newLeafNode(lv_static_0_0, grammarAccess.getPropertyDeclarationAccess().getStaticStaticKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPropertyDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "static", lv_static_0_0, "static");
                    				

                    }


                    }
                    break;

            }

            // InternalGenoMate.g:2781:3: ( (lv_final_1_0= 'final' ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==61) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalGenoMate.g:2782:4: (lv_final_1_0= 'final' )
                    {
                    // InternalGenoMate.g:2782:4: (lv_final_1_0= 'final' )
                    // InternalGenoMate.g:2783:5: lv_final_1_0= 'final'
                    {
                    lv_final_1_0=(Token)match(input,61,FOLLOW_66); 

                    					newLeafNode(lv_final_1_0, grammarAccess.getPropertyDeclarationAccess().getFinalFinalKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPropertyDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "final", lv_final_1_0, "final");
                    				

                    }


                    }
                    break;

            }

            // InternalGenoMate.g:2795:3: ( (lv_type_2_0= ruleType ) )
            // InternalGenoMate.g:2796:4: (lv_type_2_0= ruleType )
            {
            // InternalGenoMate.g:2796:4: (lv_type_2_0= ruleType )
            // InternalGenoMate.g:2797:5: lv_type_2_0= ruleType
            {

            					newCompositeNode(grammarAccess.getPropertyDeclarationAccess().getTypeTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_type_2_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPropertyDeclarationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"com.yunzhi.GenoMate.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGenoMate.g:2814:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalGenoMate.g:2815:4: (lv_name_3_0= RULE_ID )
            {
            // InternalGenoMate.g:2815:4: (lv_name_3_0= RULE_ID )
            // InternalGenoMate.g:2816:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_71); 

            					newLeafNode(lv_name_3_0, grammarAccess.getPropertyDeclarationAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            // InternalGenoMate.g:2832:3: ( (lv_defaultClause_4_0= ruleDefaultClause ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==27) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalGenoMate.g:2833:4: (lv_defaultClause_4_0= ruleDefaultClause )
                    {
                    // InternalGenoMate.g:2833:4: (lv_defaultClause_4_0= ruleDefaultClause )
                    // InternalGenoMate.g:2834:5: lv_defaultClause_4_0= ruleDefaultClause
                    {

                    					newCompositeNode(grammarAccess.getPropertyDeclarationAccess().getDefaultClauseDefaultClauseParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_defaultClause_4_0=ruleDefaultClause();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPropertyDeclarationRule());
                    					}
                    					set(
                    						current,
                    						"defaultClause",
                    						lv_defaultClause_4_0,
                    						"com.yunzhi.GenoMate.DefaultClause");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyDeclaration"


    // $ANTLR start "entryRuleDefaultClause"
    // InternalGenoMate.g:2855:1: entryRuleDefaultClause returns [String current=null] : iv_ruleDefaultClause= ruleDefaultClause EOF ;
    public final String entryRuleDefaultClause() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDefaultClause = null;


        try {
            // InternalGenoMate.g:2855:53: (iv_ruleDefaultClause= ruleDefaultClause EOF )
            // InternalGenoMate.g:2856:2: iv_ruleDefaultClause= ruleDefaultClause EOF
            {
             newCompositeNode(grammarAccess.getDefaultClauseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefaultClause=ruleDefaultClause();

            state._fsp--;

             current =iv_ruleDefaultClause.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultClause"


    // $ANTLR start "ruleDefaultClause"
    // InternalGenoMate.g:2862:1: ruleDefaultClause returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' this_Literal_1= ruleLiteral ) ;
    public final AntlrDatatypeRuleToken ruleDefaultClause() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Literal_1 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2868:2: ( (kw= '=' this_Literal_1= ruleLiteral ) )
            // InternalGenoMate.g:2869:2: (kw= '=' this_Literal_1= ruleLiteral )
            {
            // InternalGenoMate.g:2869:2: (kw= '=' this_Literal_1= ruleLiteral )
            // InternalGenoMate.g:2870:3: kw= '=' this_Literal_1= ruleLiteral
            {
            kw=(Token)match(input,27,FOLLOW_25); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDefaultClauseAccess().getEqualsSignKeyword_0());
            		

            			newCompositeNode(grammarAccess.getDefaultClauseAccess().getLiteralParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            this_Literal_1=ruleLiteral();

            state._fsp--;


            			current.merge(this_Literal_1);
            		

            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultClause"


    // $ANTLR start "entryRuleMapping"
    // InternalGenoMate.g:2889:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // InternalGenoMate.g:2889:48: (iv_ruleMapping= ruleMapping EOF )
            // InternalGenoMate.g:2890:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // InternalGenoMate.g:2896:1: ruleMapping returns [EObject current=null] : (this_ModelToVOMapping_0= ruleModelToVOMapping | this_DTOToModelMapping_1= ruleDTOToModelMapping ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        EObject this_ModelToVOMapping_0 = null;

        EObject this_DTOToModelMapping_1 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2902:2: ( (this_ModelToVOMapping_0= ruleModelToVOMapping | this_DTOToModelMapping_1= ruleDTOToModelMapping ) )
            // InternalGenoMate.g:2903:2: (this_ModelToVOMapping_0= ruleModelToVOMapping | this_DTOToModelMapping_1= ruleDTOToModelMapping )
            {
            // InternalGenoMate.g:2903:2: (this_ModelToVOMapping_0= ruleModelToVOMapping | this_DTOToModelMapping_1= ruleDTOToModelMapping )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==62) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==63) ) {
                    int LA70_2 = input.LA(3);

                    if ( (LA70_2==68) ) {
                        alt70=2;
                    }
                    else if ( (LA70_2==64) ) {
                        alt70=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalGenoMate.g:2904:3: this_ModelToVOMapping_0= ruleModelToVOMapping
                    {

                    			newCompositeNode(grammarAccess.getMappingAccess().getModelToVOMappingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ModelToVOMapping_0=ruleModelToVOMapping();

                    state._fsp--;


                    			current = this_ModelToVOMapping_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:2913:3: this_DTOToModelMapping_1= ruleDTOToModelMapping
                    {

                    			newCompositeNode(grammarAccess.getMappingAccess().getDTOToModelMappingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DTOToModelMapping_1=ruleDTOToModelMapping();

                    state._fsp--;


                    			current = this_DTOToModelMapping_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleModelToVOMapping"
    // InternalGenoMate.g:2925:1: entryRuleModelToVOMapping returns [EObject current=null] : iv_ruleModelToVOMapping= ruleModelToVOMapping EOF ;
    public final EObject entryRuleModelToVOMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelToVOMapping = null;


        try {
            // InternalGenoMate.g:2925:57: (iv_ruleModelToVOMapping= ruleModelToVOMapping EOF )
            // InternalGenoMate.g:2926:2: iv_ruleModelToVOMapping= ruleModelToVOMapping EOF
            {
             newCompositeNode(grammarAccess.getModelToVOMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelToVOMapping=ruleModelToVOMapping();

            state._fsp--;

             current =iv_ruleModelToVOMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelToVOMapping"


    // $ANTLR start "ruleModelToVOMapping"
    // InternalGenoMate.g:2932:1: ruleModelToVOMapping returns [EObject current=null] : (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'Model' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'VO' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' ) ;
    public final EObject ruleModelToVOMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_rules_8_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:2938:2: ( (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'Model' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'VO' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' ) )
            // InternalGenoMate.g:2939:2: (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'Model' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'VO' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' )
            {
            // InternalGenoMate.g:2939:2: (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'Model' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'VO' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' )
            // InternalGenoMate.g:2940:3: otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'Model' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'VO' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_72); 

            			newLeafNode(otherlv_0, grammarAccess.getModelToVOMappingAccess().getMappingKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_73); 

            			newLeafNode(otherlv_1, grammarAccess.getModelToVOMappingAccess().getFromKeyword_1());
            		
            otherlv_2=(Token)match(input,64,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getModelToVOMappingAccess().getModelKeyword_2());
            		
            // InternalGenoMate.g:2952:3: ( (otherlv_3= RULE_ID ) )
            // InternalGenoMate.g:2953:4: (otherlv_3= RULE_ID )
            {
            // InternalGenoMate.g:2953:4: (otherlv_3= RULE_ID )
            // InternalGenoMate.g:2954:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelToVOMappingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_61); 

            					newLeafNode(otherlv_3, grammarAccess.getModelToVOMappingAccess().getSourceModelCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,50,FOLLOW_74); 

            			newLeafNode(otherlv_4, grammarAccess.getModelToVOMappingAccess().getToKeyword_4());
            		
            otherlv_5=(Token)match(input,65,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getModelToVOMappingAccess().getVOKeyword_5());
            		
            // InternalGenoMate.g:2973:3: ( (otherlv_6= RULE_ID ) )
            // InternalGenoMate.g:2974:4: (otherlv_6= RULE_ID )
            {
            // InternalGenoMate.g:2974:4: (otherlv_6= RULE_ID )
            // InternalGenoMate.g:2975:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelToVOMappingRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_6, grammarAccess.getModelToVOMappingAccess().getTargetVoDefinitionCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_75); 

            			newLeafNode(otherlv_7, grammarAccess.getModelToVOMappingAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalGenoMate.g:2990:3: ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==20||LA72_0==69) ) {
                alt72=1;
            }
            else if ( (LA72_0==66) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalGenoMate.g:2991:4: ( (lv_rules_8_0= ruleMappingRule ) )*
                    {
                    // InternalGenoMate.g:2991:4: ( (lv_rules_8_0= ruleMappingRule ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==69) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalGenoMate.g:2992:5: (lv_rules_8_0= ruleMappingRule )
                    	    {
                    	    // InternalGenoMate.g:2992:5: (lv_rules_8_0= ruleMappingRule )
                    	    // InternalGenoMate.g:2993:6: lv_rules_8_0= ruleMappingRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelToVOMappingAccess().getRulesMappingRuleParserRuleCall_8_0_0());
                    	    					
                    	    pushFollow(FOLLOW_76);
                    	    lv_rules_8_0=ruleMappingRule();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getModelToVOMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"rules",
                    	    							lv_rules_8_0,
                    	    							"com.yunzhi.GenoMate.MappingRule");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3011:4: (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' )
                    {
                    // InternalGenoMate.g:3011:4: (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' )
                    // InternalGenoMate.g:3012:5: otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,66,FOLLOW_24); 

                    					newLeafNode(otherlv_9, grammarAccess.getModelToVOMappingAccess().getTargetAllKeyword_8_1_0());
                    				
                    otherlv_10=(Token)match(input,27,FOLLOW_77); 

                    					newLeafNode(otherlv_10, grammarAccess.getModelToVOMappingAccess().getEqualsSignKeyword_8_1_1());
                    				
                    otherlv_11=(Token)match(input,67,FOLLOW_14); 

                    					newLeafNode(otherlv_11, grammarAccess.getModelToVOMappingAccess().getSourceAllKeyword_8_1_2());
                    				
                    otherlv_12=(Token)match(input,22,FOLLOW_11); 

                    					newLeafNode(otherlv_12, grammarAccess.getModelToVOMappingAccess().getSemicolonKeyword_8_1_3());
                    				

                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getModelToVOMappingAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelToVOMapping"


    // $ANTLR start "entryRuleDTOToModelMapping"
    // InternalGenoMate.g:3038:1: entryRuleDTOToModelMapping returns [EObject current=null] : iv_ruleDTOToModelMapping= ruleDTOToModelMapping EOF ;
    public final EObject entryRuleDTOToModelMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDTOToModelMapping = null;


        try {
            // InternalGenoMate.g:3038:58: (iv_ruleDTOToModelMapping= ruleDTOToModelMapping EOF )
            // InternalGenoMate.g:3039:2: iv_ruleDTOToModelMapping= ruleDTOToModelMapping EOF
            {
             newCompositeNode(grammarAccess.getDTOToModelMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDTOToModelMapping=ruleDTOToModelMapping();

            state._fsp--;

             current =iv_ruleDTOToModelMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDTOToModelMapping"


    // $ANTLR start "ruleDTOToModelMapping"
    // InternalGenoMate.g:3045:1: ruleDTOToModelMapping returns [EObject current=null] : (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'DTO' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'Model' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' ) ;
    public final EObject ruleDTOToModelMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_rules_8_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:3051:2: ( (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'DTO' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'Model' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' ) )
            // InternalGenoMate.g:3052:2: (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'DTO' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'Model' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' )
            {
            // InternalGenoMate.g:3052:2: (otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'DTO' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'Model' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}' )
            // InternalGenoMate.g:3053:3: otherlv_0= 'mapping' otherlv_1= 'from' otherlv_2= 'DTO' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'Model' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_72); 

            			newLeafNode(otherlv_0, grammarAccess.getDTOToModelMappingAccess().getMappingKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_78); 

            			newLeafNode(otherlv_1, grammarAccess.getDTOToModelMappingAccess().getFromKeyword_1());
            		
            otherlv_2=(Token)match(input,68,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getDTOToModelMappingAccess().getDTOKeyword_2());
            		
            // InternalGenoMate.g:3065:3: ( (otherlv_3= RULE_ID ) )
            // InternalGenoMate.g:3066:4: (otherlv_3= RULE_ID )
            {
            // InternalGenoMate.g:3066:4: (otherlv_3= RULE_ID )
            // InternalGenoMate.g:3067:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDTOToModelMappingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_61); 

            					newLeafNode(otherlv_3, grammarAccess.getDTOToModelMappingAccess().getSourceDtoDefinitionCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,50,FOLLOW_73); 

            			newLeafNode(otherlv_4, grammarAccess.getDTOToModelMappingAccess().getToKeyword_4());
            		
            otherlv_5=(Token)match(input,64,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getDTOToModelMappingAccess().getModelKeyword_5());
            		
            // InternalGenoMate.g:3086:3: ( (otherlv_6= RULE_ID ) )
            // InternalGenoMate.g:3087:4: (otherlv_6= RULE_ID )
            {
            // InternalGenoMate.g:3087:4: (otherlv_6= RULE_ID )
            // InternalGenoMate.g:3088:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDTOToModelMappingRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_6, grammarAccess.getDTOToModelMappingAccess().getTargetModelCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_75); 

            			newLeafNode(otherlv_7, grammarAccess.getDTOToModelMappingAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalGenoMate.g:3103:3: ( ( (lv_rules_8_0= ruleMappingRule ) )* | (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==20||LA74_0==69) ) {
                alt74=1;
            }
            else if ( (LA74_0==66) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalGenoMate.g:3104:4: ( (lv_rules_8_0= ruleMappingRule ) )*
                    {
                    // InternalGenoMate.g:3104:4: ( (lv_rules_8_0= ruleMappingRule ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==69) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalGenoMate.g:3105:5: (lv_rules_8_0= ruleMappingRule )
                    	    {
                    	    // InternalGenoMate.g:3105:5: (lv_rules_8_0= ruleMappingRule )
                    	    // InternalGenoMate.g:3106:6: lv_rules_8_0= ruleMappingRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getDTOToModelMappingAccess().getRulesMappingRuleParserRuleCall_8_0_0());
                    	    					
                    	    pushFollow(FOLLOW_76);
                    	    lv_rules_8_0=ruleMappingRule();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getDTOToModelMappingRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"rules",
                    	    							lv_rules_8_0,
                    	    							"com.yunzhi.GenoMate.MappingRule");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3124:4: (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' )
                    {
                    // InternalGenoMate.g:3124:4: (otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';' )
                    // InternalGenoMate.g:3125:5: otherlv_9= 'target.all' otherlv_10= '=' otherlv_11= 'source.all' otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,66,FOLLOW_24); 

                    					newLeafNode(otherlv_9, grammarAccess.getDTOToModelMappingAccess().getTargetAllKeyword_8_1_0());
                    				
                    otherlv_10=(Token)match(input,27,FOLLOW_77); 

                    					newLeafNode(otherlv_10, grammarAccess.getDTOToModelMappingAccess().getEqualsSignKeyword_8_1_1());
                    				
                    otherlv_11=(Token)match(input,67,FOLLOW_14); 

                    					newLeafNode(otherlv_11, grammarAccess.getDTOToModelMappingAccess().getSourceAllKeyword_8_1_2());
                    				
                    otherlv_12=(Token)match(input,22,FOLLOW_11); 

                    					newLeafNode(otherlv_12, grammarAccess.getDTOToModelMappingAccess().getSemicolonKeyword_8_1_3());
                    				

                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getDTOToModelMappingAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDTOToModelMapping"


    // $ANTLR start "entryRuleMappingRule"
    // InternalGenoMate.g:3151:1: entryRuleMappingRule returns [EObject current=null] : iv_ruleMappingRule= ruleMappingRule EOF ;
    public final EObject entryRuleMappingRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingRule = null;


        try {
            // InternalGenoMate.g:3151:52: (iv_ruleMappingRule= ruleMappingRule EOF )
            // InternalGenoMate.g:3152:2: iv_ruleMappingRule= ruleMappingRule EOF
            {
             newCompositeNode(grammarAccess.getMappingRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingRule=ruleMappingRule();

            state._fsp--;

             current =iv_ruleMappingRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingRule"


    // $ANTLR start "ruleMappingRule"
    // InternalGenoMate.g:3158:1: ruleMappingRule returns [EObject current=null] : (otherlv_0= 'target.' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) ) | ( (lv_default_5_0= ruleLiteral ) ) ) otherlv_6= ';' ) ;
    public final EObject ruleMappingRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_default_5_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:3164:2: ( (otherlv_0= 'target.' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) ) | ( (lv_default_5_0= ruleLiteral ) ) ) otherlv_6= ';' ) )
            // InternalGenoMate.g:3165:2: (otherlv_0= 'target.' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) ) | ( (lv_default_5_0= ruleLiteral ) ) ) otherlv_6= ';' )
            {
            // InternalGenoMate.g:3165:2: (otherlv_0= 'target.' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) ) | ( (lv_default_5_0= ruleLiteral ) ) ) otherlv_6= ';' )
            // InternalGenoMate.g:3166:3: otherlv_0= 'target.' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) ) | ( (lv_default_5_0= ruleLiteral ) ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingRuleAccess().getTargetKeyword_0());
            		
            // InternalGenoMate.g:3170:3: ( ( ruleQualifiedName ) )
            // InternalGenoMate.g:3171:4: ( ruleQualifiedName )
            {
            // InternalGenoMate.g:3171:4: ( ruleQualifiedName )
            // InternalGenoMate.g:3172:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMappingRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getMappingRuleAccess().getTargetFieldFieldCrossReference_1_0());
            				
            pushFollow(FOLLOW_24);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_79); 

            			newLeafNode(otherlv_2, grammarAccess.getMappingRuleAccess().getEqualsSignKeyword_2());
            		
            // InternalGenoMate.g:3190:3: ( (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) ) | ( (lv_default_5_0= ruleLiteral ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==70) ) {
                alt75=1;
            }
            else if ( (LA75_0==RULE_STRING||(LA75_0>=RULE_INT && LA75_0<=RULE_DECIMAL)||(LA75_0>=71 && LA75_0<=72)) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalGenoMate.g:3191:4: (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) )
                    {
                    // InternalGenoMate.g:3191:4: (otherlv_3= 'source.' ( ( ruleQualifiedName ) ) )
                    // InternalGenoMate.g:3192:5: otherlv_3= 'source.' ( ( ruleQualifiedName ) )
                    {
                    otherlv_3=(Token)match(input,70,FOLLOW_12); 

                    					newLeafNode(otherlv_3, grammarAccess.getMappingRuleAccess().getSourceKeyword_3_0_0());
                    				
                    // InternalGenoMate.g:3196:5: ( ( ruleQualifiedName ) )
                    // InternalGenoMate.g:3197:6: ( ruleQualifiedName )
                    {
                    // InternalGenoMate.g:3197:6: ( ruleQualifiedName )
                    // InternalGenoMate.g:3198:7: ruleQualifiedName
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMappingRuleRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getMappingRuleAccess().getSourceFieldFieldCrossReference_3_0_1_0());
                    						
                    pushFollow(FOLLOW_14);
                    ruleQualifiedName();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3214:4: ( (lv_default_5_0= ruleLiteral ) )
                    {
                    // InternalGenoMate.g:3214:4: ( (lv_default_5_0= ruleLiteral ) )
                    // InternalGenoMate.g:3215:5: (lv_default_5_0= ruleLiteral )
                    {
                    // InternalGenoMate.g:3215:5: (lv_default_5_0= ruleLiteral )
                    // InternalGenoMate.g:3216:6: lv_default_5_0= ruleLiteral
                    {

                    						newCompositeNode(grammarAccess.getMappingRuleAccess().getDefaultLiteralParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_default_5_0=ruleLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMappingRuleRule());
                    						}
                    						set(
                    							current,
                    							"default",
                    							lv_default_5_0,
                    							"com.yunzhi.GenoMate.Literal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getMappingRuleAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingRule"


    // $ANTLR start "entryRuleType"
    // InternalGenoMate.g:3242:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalGenoMate.g:3242:45: (iv_ruleType= ruleType EOF )
            // InternalGenoMate.g:3243:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalGenoMate.g:3249:1: ruleType returns [EObject current=null] : (this_GenericDataType_0= ruleGenericDataType | this_ArrayType_1= ruleArrayType | this_SimpleType_2= ruleSimpleType | this_NormalType_3= ruleNormalType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_GenericDataType_0 = null;

        EObject this_ArrayType_1 = null;

        EObject this_SimpleType_2 = null;

        EObject this_NormalType_3 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:3255:2: ( (this_GenericDataType_0= ruleGenericDataType | this_ArrayType_1= ruleArrayType | this_SimpleType_2= ruleSimpleType | this_NormalType_3= ruleNormalType ) )
            // InternalGenoMate.g:3256:2: (this_GenericDataType_0= ruleGenericDataType | this_ArrayType_1= ruleArrayType | this_SimpleType_2= ruleSimpleType | this_NormalType_3= ruleNormalType )
            {
            // InternalGenoMate.g:3256:2: (this_GenericDataType_0= ruleGenericDataType | this_ArrayType_1= ruleArrayType | this_SimpleType_2= ruleSimpleType | this_NormalType_3= ruleNormalType )
            int alt76=4;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalGenoMate.g:3257:3: this_GenericDataType_0= ruleGenericDataType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getGenericDataTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenericDataType_0=ruleGenericDataType();

                    state._fsp--;


                    			current = this_GenericDataType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3266:3: this_ArrayType_1= ruleArrayType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getArrayTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArrayType_1=ruleArrayType();

                    state._fsp--;


                    			current = this_ArrayType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:3275:3: this_SimpleType_2= ruleSimpleType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleType_2=ruleSimpleType();

                    state._fsp--;


                    			current = this_SimpleType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalGenoMate.g:3284:3: this_NormalType_3= ruleNormalType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getNormalTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_NormalType_3=ruleNormalType();

                    state._fsp--;


                    			current = this_NormalType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleSimpleType"
    // InternalGenoMate.g:3296:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // InternalGenoMate.g:3296:51: (iv_ruleSimpleType= ruleSimpleType EOF )
            // InternalGenoMate.g:3297:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             newCompositeNode(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleType=ruleSimpleType();

            state._fsp--;

             current =iv_ruleSimpleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleType"


    // $ANTLR start "ruleSimpleType"
    // InternalGenoMate.g:3303:1: ruleSimpleType returns [EObject current=null] : ( (lv_builtInType_0_0= ruleBuiltInType ) ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_builtInType_0_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:3309:2: ( ( (lv_builtInType_0_0= ruleBuiltInType ) ) )
            // InternalGenoMate.g:3310:2: ( (lv_builtInType_0_0= ruleBuiltInType ) )
            {
            // InternalGenoMate.g:3310:2: ( (lv_builtInType_0_0= ruleBuiltInType ) )
            // InternalGenoMate.g:3311:3: (lv_builtInType_0_0= ruleBuiltInType )
            {
            // InternalGenoMate.g:3311:3: (lv_builtInType_0_0= ruleBuiltInType )
            // InternalGenoMate.g:3312:4: lv_builtInType_0_0= ruleBuiltInType
            {

            				newCompositeNode(grammarAccess.getSimpleTypeAccess().getBuiltInTypeBuiltInTypeEnumRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_builtInType_0_0=ruleBuiltInType();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getSimpleTypeRule());
            				}
            				set(
            					current,
            					"builtInType",
            					lv_builtInType_0_0,
            					"com.yunzhi.GenoMate.BuiltInType");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleNormalType"
    // InternalGenoMate.g:3332:1: entryRuleNormalType returns [EObject current=null] : iv_ruleNormalType= ruleNormalType EOF ;
    public final EObject entryRuleNormalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNormalType = null;


        try {
            // InternalGenoMate.g:3332:51: (iv_ruleNormalType= ruleNormalType EOF )
            // InternalGenoMate.g:3333:2: iv_ruleNormalType= ruleNormalType EOF
            {
             newCompositeNode(grammarAccess.getNormalTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNormalType=ruleNormalType();

            state._fsp--;

             current =iv_ruleNormalType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNormalType"


    // $ANTLR start "ruleNormalType"
    // InternalGenoMate.g:3339:1: ruleNormalType returns [EObject current=null] : ( (lv_customType_0_0= RULE_ID ) ) ;
    public final EObject ruleNormalType() throws RecognitionException {
        EObject current = null;

        Token lv_customType_0_0=null;


        	enterRule();

        try {
            // InternalGenoMate.g:3345:2: ( ( (lv_customType_0_0= RULE_ID ) ) )
            // InternalGenoMate.g:3346:2: ( (lv_customType_0_0= RULE_ID ) )
            {
            // InternalGenoMate.g:3346:2: ( (lv_customType_0_0= RULE_ID ) )
            // InternalGenoMate.g:3347:3: (lv_customType_0_0= RULE_ID )
            {
            // InternalGenoMate.g:3347:3: (lv_customType_0_0= RULE_ID )
            // InternalGenoMate.g:3348:4: lv_customType_0_0= RULE_ID
            {
            lv_customType_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_customType_0_0, grammarAccess.getNormalTypeAccess().getCustomTypeIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNormalTypeRule());
            				}
            				setWithLastConsumed(
            					current,
            					"customType",
            					lv_customType_0_0,
            					"com.yunzhi.GenoMate.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNormalType"


    // $ANTLR start "entryRuleGenericDataType"
    // InternalGenoMate.g:3367:1: entryRuleGenericDataType returns [EObject current=null] : iv_ruleGenericDataType= ruleGenericDataType EOF ;
    public final EObject entryRuleGenericDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericDataType = null;


        try {
            // InternalGenoMate.g:3367:56: (iv_ruleGenericDataType= ruleGenericDataType EOF )
            // InternalGenoMate.g:3368:2: iv_ruleGenericDataType= ruleGenericDataType EOF
            {
             newCompositeNode(grammarAccess.getGenericDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenericDataType=ruleGenericDataType();

            state._fsp--;

             current =iv_ruleGenericDataType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenericDataType"


    // $ANTLR start "ruleGenericDataType"
    // InternalGenoMate.g:3374:1: ruleGenericDataType returns [EObject current=null] : ( ( (lv_containerTypeName_0_0= RULE_ID ) ) this_LESS_1= RULE_LESS ( (lv_containedTypeName_2_0= ruleType ) ) this_GREATER_3= RULE_GREATER ) ;
    public final EObject ruleGenericDataType() throws RecognitionException {
        EObject current = null;

        Token lv_containerTypeName_0_0=null;
        Token this_LESS_1=null;
        Token this_GREATER_3=null;
        EObject lv_containedTypeName_2_0 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:3380:2: ( ( ( (lv_containerTypeName_0_0= RULE_ID ) ) this_LESS_1= RULE_LESS ( (lv_containedTypeName_2_0= ruleType ) ) this_GREATER_3= RULE_GREATER ) )
            // InternalGenoMate.g:3381:2: ( ( (lv_containerTypeName_0_0= RULE_ID ) ) this_LESS_1= RULE_LESS ( (lv_containedTypeName_2_0= ruleType ) ) this_GREATER_3= RULE_GREATER )
            {
            // InternalGenoMate.g:3381:2: ( ( (lv_containerTypeName_0_0= RULE_ID ) ) this_LESS_1= RULE_LESS ( (lv_containedTypeName_2_0= ruleType ) ) this_GREATER_3= RULE_GREATER )
            // InternalGenoMate.g:3382:3: ( (lv_containerTypeName_0_0= RULE_ID ) ) this_LESS_1= RULE_LESS ( (lv_containedTypeName_2_0= ruleType ) ) this_GREATER_3= RULE_GREATER
            {
            // InternalGenoMate.g:3382:3: ( (lv_containerTypeName_0_0= RULE_ID ) )
            // InternalGenoMate.g:3383:4: (lv_containerTypeName_0_0= RULE_ID )
            {
            // InternalGenoMate.g:3383:4: (lv_containerTypeName_0_0= RULE_ID )
            // InternalGenoMate.g:3384:5: lv_containerTypeName_0_0= RULE_ID
            {
            lv_containerTypeName_0_0=(Token)match(input,RULE_ID,FOLLOW_80); 

            					newLeafNode(lv_containerTypeName_0_0, grammarAccess.getGenericDataTypeAccess().getContainerTypeNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGenericDataTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"containerTypeName",
            						lv_containerTypeName_0_0,
            						"com.yunzhi.GenoMate.ID");
            				

            }


            }

            this_LESS_1=(Token)match(input,RULE_LESS,FOLLOW_66); 

            			newLeafNode(this_LESS_1, grammarAccess.getGenericDataTypeAccess().getLESSTerminalRuleCall_1());
            		
            // InternalGenoMate.g:3404:3: ( (lv_containedTypeName_2_0= ruleType ) )
            // InternalGenoMate.g:3405:4: (lv_containedTypeName_2_0= ruleType )
            {
            // InternalGenoMate.g:3405:4: (lv_containedTypeName_2_0= ruleType )
            // InternalGenoMate.g:3406:5: lv_containedTypeName_2_0= ruleType
            {

            					newCompositeNode(grammarAccess.getGenericDataTypeAccess().getContainedTypeNameTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_81);
            lv_containedTypeName_2_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGenericDataTypeRule());
            					}
            					set(
            						current,
            						"containedTypeName",
            						lv_containedTypeName_2_0,
            						"com.yunzhi.GenoMate.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_GREATER_3=(Token)match(input,RULE_GREATER,FOLLOW_2); 

            			newLeafNode(this_GREATER_3, grammarAccess.getGenericDataTypeAccess().getGREATERTerminalRuleCall_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenericDataType"


    // $ANTLR start "entryRuleArrayType"
    // InternalGenoMate.g:3431:1: entryRuleArrayType returns [EObject current=null] : iv_ruleArrayType= ruleArrayType EOF ;
    public final EObject entryRuleArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayType = null;


        try {
            // InternalGenoMate.g:3431:50: (iv_ruleArrayType= ruleArrayType EOF )
            // InternalGenoMate.g:3432:2: iv_ruleArrayType= ruleArrayType EOF
            {
             newCompositeNode(grammarAccess.getArrayTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayType=ruleArrayType();

            state._fsp--;

             current =iv_ruleArrayType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayType"


    // $ANTLR start "ruleArrayType"
    // InternalGenoMate.g:3438:1: ruleArrayType returns [EObject current=null] : ( ( ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) ) ) this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET ) ;
    public final EObject ruleArrayType() throws RecognitionException {
        EObject current = null;

        Token this_LBRACKET_1=null;
        Token this_RBRACKET_2=null;
        EObject lv_elementType_0_1 = null;

        EObject lv_elementType_0_2 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:3444:2: ( ( ( ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) ) ) this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET ) )
            // InternalGenoMate.g:3445:2: ( ( ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) ) ) this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET )
            {
            // InternalGenoMate.g:3445:2: ( ( ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) ) ) this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET )
            // InternalGenoMate.g:3446:3: ( ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) ) ) this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET
            {
            // InternalGenoMate.g:3446:3: ( ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) ) )
            // InternalGenoMate.g:3447:4: ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) )
            {
            // InternalGenoMate.g:3447:4: ( (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType ) )
            // InternalGenoMate.g:3448:5: (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType )
            {
            // InternalGenoMate.g:3448:5: (lv_elementType_0_1= ruleSimpleType | lv_elementType_0_2= ruleNormalType )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=131 && LA77_0<=138)) ) {
                alt77=1;
            }
            else if ( (LA77_0==RULE_ID) ) {
                alt77=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalGenoMate.g:3449:6: lv_elementType_0_1= ruleSimpleType
                    {

                    						newCompositeNode(grammarAccess.getArrayTypeAccess().getElementTypeSimpleTypeParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_82);
                    lv_elementType_0_1=ruleSimpleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArrayTypeRule());
                    						}
                    						set(
                    							current,
                    							"elementType",
                    							lv_elementType_0_1,
                    							"com.yunzhi.GenoMate.SimpleType");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3465:6: lv_elementType_0_2= ruleNormalType
                    {

                    						newCompositeNode(grammarAccess.getArrayTypeAccess().getElementTypeNormalTypeParserRuleCall_0_0_1());
                    					
                    pushFollow(FOLLOW_82);
                    lv_elementType_0_2=ruleNormalType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArrayTypeRule());
                    						}
                    						set(
                    							current,
                    							"elementType",
                    							lv_elementType_0_2,
                    							"com.yunzhi.GenoMate.NormalType");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }

            this_LBRACKET_1=(Token)match(input,RULE_LBRACKET,FOLLOW_83); 

            			newLeafNode(this_LBRACKET_1, grammarAccess.getArrayTypeAccess().getLBRACKETTerminalRuleCall_1());
            		
            this_RBRACKET_2=(Token)match(input,RULE_RBRACKET,FOLLOW_2); 

            			newLeafNode(this_RBRACKET_2, grammarAccess.getArrayTypeAccess().getRBRACKETTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayType"


    // $ANTLR start "entryRuleLiteral"
    // InternalGenoMate.g:3495:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // InternalGenoMate.g:3495:47: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalGenoMate.g:3496:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalGenoMate.g:3502:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL | this_BOOL_3= ruleBOOL ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        AntlrDatatypeRuleToken this_BOOL_3 = null;



        	enterRule();

        try {
            // InternalGenoMate.g:3508:2: ( (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL | this_BOOL_3= ruleBOOL ) )
            // InternalGenoMate.g:3509:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL | this_BOOL_3= ruleBOOL )
            {
            // InternalGenoMate.g:3509:2: (this_STRING_0= RULE_STRING | this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL | this_BOOL_3= ruleBOOL )
            int alt78=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt78=1;
                }
                break;
            case RULE_INT:
                {
                alt78=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt78=3;
                }
                break;
            case 71:
            case 72:
                {
                alt78=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalGenoMate.g:3510:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3518:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:3526:3: this_DECIMAL_2= RULE_DECIMAL
                    {
                    this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                    			current.merge(this_DECIMAL_2);
                    		

                    			newLeafNode(this_DECIMAL_2, grammarAccess.getLiteralAccess().getDECIMALTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalGenoMate.g:3534:3: this_BOOL_3= ruleBOOL
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getBOOLParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_BOOL_3=ruleBOOL();

                    state._fsp--;


                    			current.merge(this_BOOL_3);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBOOL"
    // InternalGenoMate.g:3548:1: entryRuleBOOL returns [String current=null] : iv_ruleBOOL= ruleBOOL EOF ;
    public final String entryRuleBOOL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOL = null;


        try {
            // InternalGenoMate.g:3548:44: (iv_ruleBOOL= ruleBOOL EOF )
            // InternalGenoMate.g:3549:2: iv_ruleBOOL= ruleBOOL EOF
            {
             newCompositeNode(grammarAccess.getBOOLRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBOOL=ruleBOOL();

            state._fsp--;

             current =iv_ruleBOOL.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOL"


    // $ANTLR start "ruleBOOL"
    // InternalGenoMate.g:3555:1: ruleBOOL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBOOL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGenoMate.g:3561:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalGenoMate.g:3562:2: (kw= 'true' | kw= 'false' )
            {
            // InternalGenoMate.g:3562:2: (kw= 'true' | kw= 'false' )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==71) ) {
                alt79=1;
            }
            else if ( (LA79_0==72) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalGenoMate.g:3563:3: kw= 'true'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBOOLAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3569:3: kw= 'false'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBOOLAccess().getFalseKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOL"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalGenoMate.g:3578:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalGenoMate.g:3578:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalGenoMate.g:3579:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalGenoMate.g:3585:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalGenoMate.g:3591:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalGenoMate.g:3592:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalGenoMate.g:3592:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalGenoMate.g:3593:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_84); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalGenoMate.g:3600:3: (kw= '.' this_ID_2= RULE_ID )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==73) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalGenoMate.g:3601:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,73,FOLLOW_12); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_84); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleBeanValidationType"
    // InternalGenoMate.g:3618:1: ruleBeanValidationType returns [Enumerator current=null] : ( (enumLiteral_0= 'AssertFalse' ) | (enumLiteral_1= 'AssertTrue' ) | (enumLiteral_2= 'DecimalMax' ) | (enumLiteral_3= 'DecimalMin' ) | (enumLiteral_4= 'Digits' ) | (enumLiteral_5= 'Email' ) | (enumLiteral_6= 'Future' ) | (enumLiteral_7= 'FutureOrPresent' ) | (enumLiteral_8= 'Max' ) | (enumLiteral_9= 'Min' ) | (enumLiteral_10= 'Negative' ) | (enumLiteral_11= 'NegativeOrZero' ) | (enumLiteral_12= 'NotBlank' ) | (enumLiteral_13= 'NotEmpty' ) | (enumLiteral_14= 'NotNull' ) | (enumLiteral_15= 'Null' ) | (enumLiteral_16= 'Past' ) | (enumLiteral_17= 'PastOrPresent' ) | (enumLiteral_18= 'Pattern' ) | (enumLiteral_19= 'Positive' ) | (enumLiteral_20= 'PositiveOrZero' ) | (enumLiteral_21= 'Size' ) ) ;
    public final Enumerator ruleBeanValidationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;


        	enterRule();

        try {
            // InternalGenoMate.g:3624:2: ( ( (enumLiteral_0= 'AssertFalse' ) | (enumLiteral_1= 'AssertTrue' ) | (enumLiteral_2= 'DecimalMax' ) | (enumLiteral_3= 'DecimalMin' ) | (enumLiteral_4= 'Digits' ) | (enumLiteral_5= 'Email' ) | (enumLiteral_6= 'Future' ) | (enumLiteral_7= 'FutureOrPresent' ) | (enumLiteral_8= 'Max' ) | (enumLiteral_9= 'Min' ) | (enumLiteral_10= 'Negative' ) | (enumLiteral_11= 'NegativeOrZero' ) | (enumLiteral_12= 'NotBlank' ) | (enumLiteral_13= 'NotEmpty' ) | (enumLiteral_14= 'NotNull' ) | (enumLiteral_15= 'Null' ) | (enumLiteral_16= 'Past' ) | (enumLiteral_17= 'PastOrPresent' ) | (enumLiteral_18= 'Pattern' ) | (enumLiteral_19= 'Positive' ) | (enumLiteral_20= 'PositiveOrZero' ) | (enumLiteral_21= 'Size' ) ) )
            // InternalGenoMate.g:3625:2: ( (enumLiteral_0= 'AssertFalse' ) | (enumLiteral_1= 'AssertTrue' ) | (enumLiteral_2= 'DecimalMax' ) | (enumLiteral_3= 'DecimalMin' ) | (enumLiteral_4= 'Digits' ) | (enumLiteral_5= 'Email' ) | (enumLiteral_6= 'Future' ) | (enumLiteral_7= 'FutureOrPresent' ) | (enumLiteral_8= 'Max' ) | (enumLiteral_9= 'Min' ) | (enumLiteral_10= 'Negative' ) | (enumLiteral_11= 'NegativeOrZero' ) | (enumLiteral_12= 'NotBlank' ) | (enumLiteral_13= 'NotEmpty' ) | (enumLiteral_14= 'NotNull' ) | (enumLiteral_15= 'Null' ) | (enumLiteral_16= 'Past' ) | (enumLiteral_17= 'PastOrPresent' ) | (enumLiteral_18= 'Pattern' ) | (enumLiteral_19= 'Positive' ) | (enumLiteral_20= 'PositiveOrZero' ) | (enumLiteral_21= 'Size' ) )
            {
            // InternalGenoMate.g:3625:2: ( (enumLiteral_0= 'AssertFalse' ) | (enumLiteral_1= 'AssertTrue' ) | (enumLiteral_2= 'DecimalMax' ) | (enumLiteral_3= 'DecimalMin' ) | (enumLiteral_4= 'Digits' ) | (enumLiteral_5= 'Email' ) | (enumLiteral_6= 'Future' ) | (enumLiteral_7= 'FutureOrPresent' ) | (enumLiteral_8= 'Max' ) | (enumLiteral_9= 'Min' ) | (enumLiteral_10= 'Negative' ) | (enumLiteral_11= 'NegativeOrZero' ) | (enumLiteral_12= 'NotBlank' ) | (enumLiteral_13= 'NotEmpty' ) | (enumLiteral_14= 'NotNull' ) | (enumLiteral_15= 'Null' ) | (enumLiteral_16= 'Past' ) | (enumLiteral_17= 'PastOrPresent' ) | (enumLiteral_18= 'Pattern' ) | (enumLiteral_19= 'Positive' ) | (enumLiteral_20= 'PositiveOrZero' ) | (enumLiteral_21= 'Size' ) )
            int alt81=22;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt81=1;
                }
                break;
            case 75:
                {
                alt81=2;
                }
                break;
            case 76:
                {
                alt81=3;
                }
                break;
            case 77:
                {
                alt81=4;
                }
                break;
            case 78:
                {
                alt81=5;
                }
                break;
            case 79:
                {
                alt81=6;
                }
                break;
            case 80:
                {
                alt81=7;
                }
                break;
            case 81:
                {
                alt81=8;
                }
                break;
            case 82:
                {
                alt81=9;
                }
                break;
            case 83:
                {
                alt81=10;
                }
                break;
            case 84:
                {
                alt81=11;
                }
                break;
            case 85:
                {
                alt81=12;
                }
                break;
            case 86:
                {
                alt81=13;
                }
                break;
            case 87:
                {
                alt81=14;
                }
                break;
            case 88:
                {
                alt81=15;
                }
                break;
            case 89:
                {
                alt81=16;
                }
                break;
            case 90:
                {
                alt81=17;
                }
                break;
            case 91:
                {
                alt81=18;
                }
                break;
            case 92:
                {
                alt81=19;
                }
                break;
            case 93:
                {
                alt81=20;
                }
                break;
            case 94:
                {
                alt81=21;
                }
                break;
            case 95:
                {
                alt81=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalGenoMate.g:3626:3: (enumLiteral_0= 'AssertFalse' )
                    {
                    // InternalGenoMate.g:3626:3: (enumLiteral_0= 'AssertFalse' )
                    // InternalGenoMate.g:3627:4: enumLiteral_0= 'AssertFalse'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getAssertFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBeanValidationTypeAccess().getAssertFalseEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3634:3: (enumLiteral_1= 'AssertTrue' )
                    {
                    // InternalGenoMate.g:3634:3: (enumLiteral_1= 'AssertTrue' )
                    // InternalGenoMate.g:3635:4: enumLiteral_1= 'AssertTrue'
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getAssertTrueEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBeanValidationTypeAccess().getAssertTrueEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:3642:3: (enumLiteral_2= 'DecimalMax' )
                    {
                    // InternalGenoMate.g:3642:3: (enumLiteral_2= 'DecimalMax' )
                    // InternalGenoMate.g:3643:4: enumLiteral_2= 'DecimalMax'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getDecimalMaxEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBeanValidationTypeAccess().getDecimalMaxEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGenoMate.g:3650:3: (enumLiteral_3= 'DecimalMin' )
                    {
                    // InternalGenoMate.g:3650:3: (enumLiteral_3= 'DecimalMin' )
                    // InternalGenoMate.g:3651:4: enumLiteral_3= 'DecimalMin'
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getDecimalMinEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBeanValidationTypeAccess().getDecimalMinEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGenoMate.g:3658:3: (enumLiteral_4= 'Digits' )
                    {
                    // InternalGenoMate.g:3658:3: (enumLiteral_4= 'Digits' )
                    // InternalGenoMate.g:3659:4: enumLiteral_4= 'Digits'
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getDigitsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getBeanValidationTypeAccess().getDigitsEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGenoMate.g:3666:3: (enumLiteral_5= 'Email' )
                    {
                    // InternalGenoMate.g:3666:3: (enumLiteral_5= 'Email' )
                    // InternalGenoMate.g:3667:4: enumLiteral_5= 'Email'
                    {
                    enumLiteral_5=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getEmailEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getBeanValidationTypeAccess().getEmailEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalGenoMate.g:3674:3: (enumLiteral_6= 'Future' )
                    {
                    // InternalGenoMate.g:3674:3: (enumLiteral_6= 'Future' )
                    // InternalGenoMate.g:3675:4: enumLiteral_6= 'Future'
                    {
                    enumLiteral_6=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getFutureEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getBeanValidationTypeAccess().getFutureEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalGenoMate.g:3682:3: (enumLiteral_7= 'FutureOrPresent' )
                    {
                    // InternalGenoMate.g:3682:3: (enumLiteral_7= 'FutureOrPresent' )
                    // InternalGenoMate.g:3683:4: enumLiteral_7= 'FutureOrPresent'
                    {
                    enumLiteral_7=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getFutureOrPresentEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getBeanValidationTypeAccess().getFutureOrPresentEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalGenoMate.g:3690:3: (enumLiteral_8= 'Max' )
                    {
                    // InternalGenoMate.g:3690:3: (enumLiteral_8= 'Max' )
                    // InternalGenoMate.g:3691:4: enumLiteral_8= 'Max'
                    {
                    enumLiteral_8=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getMaxEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getBeanValidationTypeAccess().getMaxEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalGenoMate.g:3698:3: (enumLiteral_9= 'Min' )
                    {
                    // InternalGenoMate.g:3698:3: (enumLiteral_9= 'Min' )
                    // InternalGenoMate.g:3699:4: enumLiteral_9= 'Min'
                    {
                    enumLiteral_9=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getMinEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getBeanValidationTypeAccess().getMinEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalGenoMate.g:3706:3: (enumLiteral_10= 'Negative' )
                    {
                    // InternalGenoMate.g:3706:3: (enumLiteral_10= 'Negative' )
                    // InternalGenoMate.g:3707:4: enumLiteral_10= 'Negative'
                    {
                    enumLiteral_10=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getNegativeEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getBeanValidationTypeAccess().getNegativeEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalGenoMate.g:3714:3: (enumLiteral_11= 'NegativeOrZero' )
                    {
                    // InternalGenoMate.g:3714:3: (enumLiteral_11= 'NegativeOrZero' )
                    // InternalGenoMate.g:3715:4: enumLiteral_11= 'NegativeOrZero'
                    {
                    enumLiteral_11=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getNegativeOrZeroEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getBeanValidationTypeAccess().getNegativeOrZeroEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalGenoMate.g:3722:3: (enumLiteral_12= 'NotBlank' )
                    {
                    // InternalGenoMate.g:3722:3: (enumLiteral_12= 'NotBlank' )
                    // InternalGenoMate.g:3723:4: enumLiteral_12= 'NotBlank'
                    {
                    enumLiteral_12=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getNotBlankEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getBeanValidationTypeAccess().getNotBlankEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalGenoMate.g:3730:3: (enumLiteral_13= 'NotEmpty' )
                    {
                    // InternalGenoMate.g:3730:3: (enumLiteral_13= 'NotEmpty' )
                    // InternalGenoMate.g:3731:4: enumLiteral_13= 'NotEmpty'
                    {
                    enumLiteral_13=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getNotEmptyEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getBeanValidationTypeAccess().getNotEmptyEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalGenoMate.g:3738:3: (enumLiteral_14= 'NotNull' )
                    {
                    // InternalGenoMate.g:3738:3: (enumLiteral_14= 'NotNull' )
                    // InternalGenoMate.g:3739:4: enumLiteral_14= 'NotNull'
                    {
                    enumLiteral_14=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getNotNullEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getBeanValidationTypeAccess().getNotNullEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalGenoMate.g:3746:3: (enumLiteral_15= 'Null' )
                    {
                    // InternalGenoMate.g:3746:3: (enumLiteral_15= 'Null' )
                    // InternalGenoMate.g:3747:4: enumLiteral_15= 'Null'
                    {
                    enumLiteral_15=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getNullEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getBeanValidationTypeAccess().getNullEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalGenoMate.g:3754:3: (enumLiteral_16= 'Past' )
                    {
                    // InternalGenoMate.g:3754:3: (enumLiteral_16= 'Past' )
                    // InternalGenoMate.g:3755:4: enumLiteral_16= 'Past'
                    {
                    enumLiteral_16=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getPastEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getBeanValidationTypeAccess().getPastEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalGenoMate.g:3762:3: (enumLiteral_17= 'PastOrPresent' )
                    {
                    // InternalGenoMate.g:3762:3: (enumLiteral_17= 'PastOrPresent' )
                    // InternalGenoMate.g:3763:4: enumLiteral_17= 'PastOrPresent'
                    {
                    enumLiteral_17=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getPastOrPresentEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getBeanValidationTypeAccess().getPastOrPresentEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalGenoMate.g:3770:3: (enumLiteral_18= 'Pattern' )
                    {
                    // InternalGenoMate.g:3770:3: (enumLiteral_18= 'Pattern' )
                    // InternalGenoMate.g:3771:4: enumLiteral_18= 'Pattern'
                    {
                    enumLiteral_18=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getPatternEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getBeanValidationTypeAccess().getPatternEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalGenoMate.g:3778:3: (enumLiteral_19= 'Positive' )
                    {
                    // InternalGenoMate.g:3778:3: (enumLiteral_19= 'Positive' )
                    // InternalGenoMate.g:3779:4: enumLiteral_19= 'Positive'
                    {
                    enumLiteral_19=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getPositiveEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getBeanValidationTypeAccess().getPositiveEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalGenoMate.g:3786:3: (enumLiteral_20= 'PositiveOrZero' )
                    {
                    // InternalGenoMate.g:3786:3: (enumLiteral_20= 'PositiveOrZero' )
                    // InternalGenoMate.g:3787:4: enumLiteral_20= 'PositiveOrZero'
                    {
                    enumLiteral_20=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getPositiveOrZeroEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getBeanValidationTypeAccess().getPositiveOrZeroEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalGenoMate.g:3794:3: (enumLiteral_21= 'Size' )
                    {
                    // InternalGenoMate.g:3794:3: (enumLiteral_21= 'Size' )
                    // InternalGenoMate.g:3795:4: enumLiteral_21= 'Size'
                    {
                    enumLiteral_21=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getBeanValidationTypeAccess().getSizeEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getBeanValidationTypeAccess().getSizeEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBeanValidationType"


    // $ANTLR start "ruleMybatisPlusModelType"
    // InternalGenoMate.g:3805:1: ruleMybatisPlusModelType returns [Enumerator current=null] : ( (enumLiteral_0= 'KeySequence' ) | (enumLiteral_1= 'TableName' ) ) ;
    public final Enumerator ruleMybatisPlusModelType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGenoMate.g:3811:2: ( ( (enumLiteral_0= 'KeySequence' ) | (enumLiteral_1= 'TableName' ) ) )
            // InternalGenoMate.g:3812:2: ( (enumLiteral_0= 'KeySequence' ) | (enumLiteral_1= 'TableName' ) )
            {
            // InternalGenoMate.g:3812:2: ( (enumLiteral_0= 'KeySequence' ) | (enumLiteral_1= 'TableName' ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==96) ) {
                alt82=1;
            }
            else if ( (LA82_0==97) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalGenoMate.g:3813:3: (enumLiteral_0= 'KeySequence' )
                    {
                    // InternalGenoMate.g:3813:3: (enumLiteral_0= 'KeySequence' )
                    // InternalGenoMate.g:3814:4: enumLiteral_0= 'KeySequence'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getMybatisPlusModelTypeAccess().getKeySequenceEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMybatisPlusModelTypeAccess().getKeySequenceEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3821:3: (enumLiteral_1= 'TableName' )
                    {
                    // InternalGenoMate.g:3821:3: (enumLiteral_1= 'TableName' )
                    // InternalGenoMate.g:3822:4: enumLiteral_1= 'TableName'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getMybatisPlusModelTypeAccess().getTableNameEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMybatisPlusModelTypeAccess().getTableNameEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMybatisPlusModelType"


    // $ANTLR start "ruleMybatisPlusFieldType"
    // InternalGenoMate.g:3832:1: ruleMybatisPlusFieldType returns [Enumerator current=null] : ( (enumLiteral_0= 'OrderBy' ) | (enumLiteral_1= 'TableField' ) | (enumLiteral_2= 'TableId' ) | (enumLiteral_3= 'TableLogic' ) | (enumLiteral_4= 'Version' ) ) ;
    public final Enumerator ruleMybatisPlusFieldType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalGenoMate.g:3838:2: ( ( (enumLiteral_0= 'OrderBy' ) | (enumLiteral_1= 'TableField' ) | (enumLiteral_2= 'TableId' ) | (enumLiteral_3= 'TableLogic' ) | (enumLiteral_4= 'Version' ) ) )
            // InternalGenoMate.g:3839:2: ( (enumLiteral_0= 'OrderBy' ) | (enumLiteral_1= 'TableField' ) | (enumLiteral_2= 'TableId' ) | (enumLiteral_3= 'TableLogic' ) | (enumLiteral_4= 'Version' ) )
            {
            // InternalGenoMate.g:3839:2: ( (enumLiteral_0= 'OrderBy' ) | (enumLiteral_1= 'TableField' ) | (enumLiteral_2= 'TableId' ) | (enumLiteral_3= 'TableLogic' ) | (enumLiteral_4= 'Version' ) )
            int alt83=5;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt83=1;
                }
                break;
            case 99:
                {
                alt83=2;
                }
                break;
            case 100:
                {
                alt83=3;
                }
                break;
            case 101:
                {
                alt83=4;
                }
                break;
            case 102:
                {
                alt83=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalGenoMate.g:3840:3: (enumLiteral_0= 'OrderBy' )
                    {
                    // InternalGenoMate.g:3840:3: (enumLiteral_0= 'OrderBy' )
                    // InternalGenoMate.g:3841:4: enumLiteral_0= 'OrderBy'
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getMybatisPlusFieldTypeAccess().getOrderByEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMybatisPlusFieldTypeAccess().getOrderByEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3848:3: (enumLiteral_1= 'TableField' )
                    {
                    // InternalGenoMate.g:3848:3: (enumLiteral_1= 'TableField' )
                    // InternalGenoMate.g:3849:4: enumLiteral_1= 'TableField'
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getMybatisPlusFieldTypeAccess().getTableFieldEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMybatisPlusFieldTypeAccess().getTableFieldEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:3856:3: (enumLiteral_2= 'TableId' )
                    {
                    // InternalGenoMate.g:3856:3: (enumLiteral_2= 'TableId' )
                    // InternalGenoMate.g:3857:4: enumLiteral_2= 'TableId'
                    {
                    enumLiteral_2=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getMybatisPlusFieldTypeAccess().getTableIdEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMybatisPlusFieldTypeAccess().getTableIdEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGenoMate.g:3864:3: (enumLiteral_3= 'TableLogic' )
                    {
                    // InternalGenoMate.g:3864:3: (enumLiteral_3= 'TableLogic' )
                    // InternalGenoMate.g:3865:4: enumLiteral_3= 'TableLogic'
                    {
                    enumLiteral_3=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getMybatisPlusFieldTypeAccess().getTableLogicEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getMybatisPlusFieldTypeAccess().getTableLogicEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGenoMate.g:3872:3: (enumLiteral_4= 'Version' )
                    {
                    // InternalGenoMate.g:3872:3: (enumLiteral_4= 'Version' )
                    // InternalGenoMate.g:3873:4: enumLiteral_4= 'Version'
                    {
                    enumLiteral_4=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getMybatisPlusFieldTypeAccess().getVersionEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getMybatisPlusFieldTypeAccess().getVersionEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMybatisPlusFieldType"


    // $ANTLR start "ruleJacksonType"
    // InternalGenoMate.g:3883:1: ruleJacksonType returns [Enumerator current=null] : ( (enumLiteral_0= 'JsonAlias' ) | (enumLiteral_1= 'JsonAnyGetter' ) | (enumLiteral_2= 'JsonAnySetter' ) | (enumLiteral_3= 'JsonAutoDetect' ) | (enumLiteral_4= 'JsonDeserialize' ) | (enumLiteral_5= 'JsonFormat' ) | (enumLiteral_6= 'JsonIgnore' ) | (enumLiteral_7= 'JsonIgnoreProperties' ) | (enumLiteral_8= 'JsonInclude' ) | (enumLiteral_9= 'JsonRootName' ) | (enumLiteral_10= 'JsonSerialize' ) | (enumLiteral_11= 'JsonTypeInfo' ) | (enumLiteral_12= 'JsonUnwrapped' ) | (enumLiteral_13= 'JsonValue' ) | (enumLiteral_14= 'JsonView' ) | (enumLiteral_15= 'JsonProperty' ) ) ;
    public final Enumerator ruleJacksonType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;


        	enterRule();

        try {
            // InternalGenoMate.g:3889:2: ( ( (enumLiteral_0= 'JsonAlias' ) | (enumLiteral_1= 'JsonAnyGetter' ) | (enumLiteral_2= 'JsonAnySetter' ) | (enumLiteral_3= 'JsonAutoDetect' ) | (enumLiteral_4= 'JsonDeserialize' ) | (enumLiteral_5= 'JsonFormat' ) | (enumLiteral_6= 'JsonIgnore' ) | (enumLiteral_7= 'JsonIgnoreProperties' ) | (enumLiteral_8= 'JsonInclude' ) | (enumLiteral_9= 'JsonRootName' ) | (enumLiteral_10= 'JsonSerialize' ) | (enumLiteral_11= 'JsonTypeInfo' ) | (enumLiteral_12= 'JsonUnwrapped' ) | (enumLiteral_13= 'JsonValue' ) | (enumLiteral_14= 'JsonView' ) | (enumLiteral_15= 'JsonProperty' ) ) )
            // InternalGenoMate.g:3890:2: ( (enumLiteral_0= 'JsonAlias' ) | (enumLiteral_1= 'JsonAnyGetter' ) | (enumLiteral_2= 'JsonAnySetter' ) | (enumLiteral_3= 'JsonAutoDetect' ) | (enumLiteral_4= 'JsonDeserialize' ) | (enumLiteral_5= 'JsonFormat' ) | (enumLiteral_6= 'JsonIgnore' ) | (enumLiteral_7= 'JsonIgnoreProperties' ) | (enumLiteral_8= 'JsonInclude' ) | (enumLiteral_9= 'JsonRootName' ) | (enumLiteral_10= 'JsonSerialize' ) | (enumLiteral_11= 'JsonTypeInfo' ) | (enumLiteral_12= 'JsonUnwrapped' ) | (enumLiteral_13= 'JsonValue' ) | (enumLiteral_14= 'JsonView' ) | (enumLiteral_15= 'JsonProperty' ) )
            {
            // InternalGenoMate.g:3890:2: ( (enumLiteral_0= 'JsonAlias' ) | (enumLiteral_1= 'JsonAnyGetter' ) | (enumLiteral_2= 'JsonAnySetter' ) | (enumLiteral_3= 'JsonAutoDetect' ) | (enumLiteral_4= 'JsonDeserialize' ) | (enumLiteral_5= 'JsonFormat' ) | (enumLiteral_6= 'JsonIgnore' ) | (enumLiteral_7= 'JsonIgnoreProperties' ) | (enumLiteral_8= 'JsonInclude' ) | (enumLiteral_9= 'JsonRootName' ) | (enumLiteral_10= 'JsonSerialize' ) | (enumLiteral_11= 'JsonTypeInfo' ) | (enumLiteral_12= 'JsonUnwrapped' ) | (enumLiteral_13= 'JsonValue' ) | (enumLiteral_14= 'JsonView' ) | (enumLiteral_15= 'JsonProperty' ) )
            int alt84=16;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt84=1;
                }
                break;
            case 104:
                {
                alt84=2;
                }
                break;
            case 105:
                {
                alt84=3;
                }
                break;
            case 106:
                {
                alt84=4;
                }
                break;
            case 107:
                {
                alt84=5;
                }
                break;
            case 108:
                {
                alt84=6;
                }
                break;
            case 109:
                {
                alt84=7;
                }
                break;
            case 110:
                {
                alt84=8;
                }
                break;
            case 111:
                {
                alt84=9;
                }
                break;
            case 112:
                {
                alt84=10;
                }
                break;
            case 113:
                {
                alt84=11;
                }
                break;
            case 114:
                {
                alt84=12;
                }
                break;
            case 115:
                {
                alt84=13;
                }
                break;
            case 116:
                {
                alt84=14;
                }
                break;
            case 117:
                {
                alt84=15;
                }
                break;
            case 118:
                {
                alt84=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalGenoMate.g:3891:3: (enumLiteral_0= 'JsonAlias' )
                    {
                    // InternalGenoMate.g:3891:3: (enumLiteral_0= 'JsonAlias' )
                    // InternalGenoMate.g:3892:4: enumLiteral_0= 'JsonAlias'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonAliasEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJacksonTypeAccess().getJsonAliasEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:3899:3: (enumLiteral_1= 'JsonAnyGetter' )
                    {
                    // InternalGenoMate.g:3899:3: (enumLiteral_1= 'JsonAnyGetter' )
                    // InternalGenoMate.g:3900:4: enumLiteral_1= 'JsonAnyGetter'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonAnyGetterEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJacksonTypeAccess().getJsonAnyGetterEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:3907:3: (enumLiteral_2= 'JsonAnySetter' )
                    {
                    // InternalGenoMate.g:3907:3: (enumLiteral_2= 'JsonAnySetter' )
                    // InternalGenoMate.g:3908:4: enumLiteral_2= 'JsonAnySetter'
                    {
                    enumLiteral_2=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonAnySetterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getJacksonTypeAccess().getJsonAnySetterEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGenoMate.g:3915:3: (enumLiteral_3= 'JsonAutoDetect' )
                    {
                    // InternalGenoMate.g:3915:3: (enumLiteral_3= 'JsonAutoDetect' )
                    // InternalGenoMate.g:3916:4: enumLiteral_3= 'JsonAutoDetect'
                    {
                    enumLiteral_3=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonAutoDetectEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getJacksonTypeAccess().getJsonAutoDetectEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGenoMate.g:3923:3: (enumLiteral_4= 'JsonDeserialize' )
                    {
                    // InternalGenoMate.g:3923:3: (enumLiteral_4= 'JsonDeserialize' )
                    // InternalGenoMate.g:3924:4: enumLiteral_4= 'JsonDeserialize'
                    {
                    enumLiteral_4=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonDeserializeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getJacksonTypeAccess().getJsonDeserializeEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGenoMate.g:3931:3: (enumLiteral_5= 'JsonFormat' )
                    {
                    // InternalGenoMate.g:3931:3: (enumLiteral_5= 'JsonFormat' )
                    // InternalGenoMate.g:3932:4: enumLiteral_5= 'JsonFormat'
                    {
                    enumLiteral_5=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonFormatEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getJacksonTypeAccess().getJsonFormatEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalGenoMate.g:3939:3: (enumLiteral_6= 'JsonIgnore' )
                    {
                    // InternalGenoMate.g:3939:3: (enumLiteral_6= 'JsonIgnore' )
                    // InternalGenoMate.g:3940:4: enumLiteral_6= 'JsonIgnore'
                    {
                    enumLiteral_6=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonIgnoreEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getJacksonTypeAccess().getJsonIgnoreEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalGenoMate.g:3947:3: (enumLiteral_7= 'JsonIgnoreProperties' )
                    {
                    // InternalGenoMate.g:3947:3: (enumLiteral_7= 'JsonIgnoreProperties' )
                    // InternalGenoMate.g:3948:4: enumLiteral_7= 'JsonIgnoreProperties'
                    {
                    enumLiteral_7=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonIgnorePropertiesEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getJacksonTypeAccess().getJsonIgnorePropertiesEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalGenoMate.g:3955:3: (enumLiteral_8= 'JsonInclude' )
                    {
                    // InternalGenoMate.g:3955:3: (enumLiteral_8= 'JsonInclude' )
                    // InternalGenoMate.g:3956:4: enumLiteral_8= 'JsonInclude'
                    {
                    enumLiteral_8=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonIncludeEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getJacksonTypeAccess().getJsonIncludeEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalGenoMate.g:3963:3: (enumLiteral_9= 'JsonRootName' )
                    {
                    // InternalGenoMate.g:3963:3: (enumLiteral_9= 'JsonRootName' )
                    // InternalGenoMate.g:3964:4: enumLiteral_9= 'JsonRootName'
                    {
                    enumLiteral_9=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonRootNameEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getJacksonTypeAccess().getJsonRootNameEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalGenoMate.g:3971:3: (enumLiteral_10= 'JsonSerialize' )
                    {
                    // InternalGenoMate.g:3971:3: (enumLiteral_10= 'JsonSerialize' )
                    // InternalGenoMate.g:3972:4: enumLiteral_10= 'JsonSerialize'
                    {
                    enumLiteral_10=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonSerializeEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getJacksonTypeAccess().getJsonSerializeEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalGenoMate.g:3979:3: (enumLiteral_11= 'JsonTypeInfo' )
                    {
                    // InternalGenoMate.g:3979:3: (enumLiteral_11= 'JsonTypeInfo' )
                    // InternalGenoMate.g:3980:4: enumLiteral_11= 'JsonTypeInfo'
                    {
                    enumLiteral_11=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonTypeInfoEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getJacksonTypeAccess().getJsonTypeInfoEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalGenoMate.g:3987:3: (enumLiteral_12= 'JsonUnwrapped' )
                    {
                    // InternalGenoMate.g:3987:3: (enumLiteral_12= 'JsonUnwrapped' )
                    // InternalGenoMate.g:3988:4: enumLiteral_12= 'JsonUnwrapped'
                    {
                    enumLiteral_12=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonUnwrappedEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getJacksonTypeAccess().getJsonUnwrappedEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalGenoMate.g:3995:3: (enumLiteral_13= 'JsonValue' )
                    {
                    // InternalGenoMate.g:3995:3: (enumLiteral_13= 'JsonValue' )
                    // InternalGenoMate.g:3996:4: enumLiteral_13= 'JsonValue'
                    {
                    enumLiteral_13=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonValueEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getJacksonTypeAccess().getJsonValueEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalGenoMate.g:4003:3: (enumLiteral_14= 'JsonView' )
                    {
                    // InternalGenoMate.g:4003:3: (enumLiteral_14= 'JsonView' )
                    // InternalGenoMate.g:4004:4: enumLiteral_14= 'JsonView'
                    {
                    enumLiteral_14=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonViewEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getJacksonTypeAccess().getJsonViewEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalGenoMate.g:4011:3: (enumLiteral_15= 'JsonProperty' )
                    {
                    // InternalGenoMate.g:4011:3: (enumLiteral_15= 'JsonProperty' )
                    // InternalGenoMate.g:4012:4: enumLiteral_15= 'JsonProperty'
                    {
                    enumLiteral_15=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getJacksonTypeAccess().getJsonPropertyEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getJacksonTypeAccess().getJsonPropertyEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJacksonType"


    // $ANTLR start "ruleLombokType"
    // InternalGenoMate.g:4022:1: ruleLombokType returns [Enumerator current=null] : ( (enumLiteral_0= 'Accessors' ) | (enumLiteral_1= 'AllArgsConstructor' ) | (enumLiteral_2= 'Builder' ) | (enumLiteral_3= 'Data' ) | (enumLiteral_4= 'EqualsAndHashCode' ) | (enumLiteral_5= 'Getter' ) | (enumLiteral_6= 'NoArgsConstructor' ) | (enumLiteral_7= 'RequiredArgsConstructor' ) | (enumLiteral_8= 'Setter' ) | (enumLiteral_9= 'Singular' ) | (enumLiteral_10= 'SuperBuilder' ) | (enumLiteral_11= 'ToString' ) ) ;
    public final Enumerator ruleLombokType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;


        	enterRule();

        try {
            // InternalGenoMate.g:4028:2: ( ( (enumLiteral_0= 'Accessors' ) | (enumLiteral_1= 'AllArgsConstructor' ) | (enumLiteral_2= 'Builder' ) | (enumLiteral_3= 'Data' ) | (enumLiteral_4= 'EqualsAndHashCode' ) | (enumLiteral_5= 'Getter' ) | (enumLiteral_6= 'NoArgsConstructor' ) | (enumLiteral_7= 'RequiredArgsConstructor' ) | (enumLiteral_8= 'Setter' ) | (enumLiteral_9= 'Singular' ) | (enumLiteral_10= 'SuperBuilder' ) | (enumLiteral_11= 'ToString' ) ) )
            // InternalGenoMate.g:4029:2: ( (enumLiteral_0= 'Accessors' ) | (enumLiteral_1= 'AllArgsConstructor' ) | (enumLiteral_2= 'Builder' ) | (enumLiteral_3= 'Data' ) | (enumLiteral_4= 'EqualsAndHashCode' ) | (enumLiteral_5= 'Getter' ) | (enumLiteral_6= 'NoArgsConstructor' ) | (enumLiteral_7= 'RequiredArgsConstructor' ) | (enumLiteral_8= 'Setter' ) | (enumLiteral_9= 'Singular' ) | (enumLiteral_10= 'SuperBuilder' ) | (enumLiteral_11= 'ToString' ) )
            {
            // InternalGenoMate.g:4029:2: ( (enumLiteral_0= 'Accessors' ) | (enumLiteral_1= 'AllArgsConstructor' ) | (enumLiteral_2= 'Builder' ) | (enumLiteral_3= 'Data' ) | (enumLiteral_4= 'EqualsAndHashCode' ) | (enumLiteral_5= 'Getter' ) | (enumLiteral_6= 'NoArgsConstructor' ) | (enumLiteral_7= 'RequiredArgsConstructor' ) | (enumLiteral_8= 'Setter' ) | (enumLiteral_9= 'Singular' ) | (enumLiteral_10= 'SuperBuilder' ) | (enumLiteral_11= 'ToString' ) )
            int alt85=12;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt85=1;
                }
                break;
            case 120:
                {
                alt85=2;
                }
                break;
            case 121:
                {
                alt85=3;
                }
                break;
            case 122:
                {
                alt85=4;
                }
                break;
            case 123:
                {
                alt85=5;
                }
                break;
            case 124:
                {
                alt85=6;
                }
                break;
            case 125:
                {
                alt85=7;
                }
                break;
            case 126:
                {
                alt85=8;
                }
                break;
            case 127:
                {
                alt85=9;
                }
                break;
            case 128:
                {
                alt85=10;
                }
                break;
            case 129:
                {
                alt85=11;
                }
                break;
            case 130:
                {
                alt85=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalGenoMate.g:4030:3: (enumLiteral_0= 'Accessors' )
                    {
                    // InternalGenoMate.g:4030:3: (enumLiteral_0= 'Accessors' )
                    // InternalGenoMate.g:4031:4: enumLiteral_0= 'Accessors'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getAccessorsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLombokTypeAccess().getAccessorsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:4038:3: (enumLiteral_1= 'AllArgsConstructor' )
                    {
                    // InternalGenoMate.g:4038:3: (enumLiteral_1= 'AllArgsConstructor' )
                    // InternalGenoMate.g:4039:4: enumLiteral_1= 'AllArgsConstructor'
                    {
                    enumLiteral_1=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getAllArgsConstructorEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLombokTypeAccess().getAllArgsConstructorEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:4046:3: (enumLiteral_2= 'Builder' )
                    {
                    // InternalGenoMate.g:4046:3: (enumLiteral_2= 'Builder' )
                    // InternalGenoMate.g:4047:4: enumLiteral_2= 'Builder'
                    {
                    enumLiteral_2=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getBuilderEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLombokTypeAccess().getBuilderEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGenoMate.g:4054:3: (enumLiteral_3= 'Data' )
                    {
                    // InternalGenoMate.g:4054:3: (enumLiteral_3= 'Data' )
                    // InternalGenoMate.g:4055:4: enumLiteral_3= 'Data'
                    {
                    enumLiteral_3=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getDataEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLombokTypeAccess().getDataEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGenoMate.g:4062:3: (enumLiteral_4= 'EqualsAndHashCode' )
                    {
                    // InternalGenoMate.g:4062:3: (enumLiteral_4= 'EqualsAndHashCode' )
                    // InternalGenoMate.g:4063:4: enumLiteral_4= 'EqualsAndHashCode'
                    {
                    enumLiteral_4=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getEqualsAndHashCodeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLombokTypeAccess().getEqualsAndHashCodeEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGenoMate.g:4070:3: (enumLiteral_5= 'Getter' )
                    {
                    // InternalGenoMate.g:4070:3: (enumLiteral_5= 'Getter' )
                    // InternalGenoMate.g:4071:4: enumLiteral_5= 'Getter'
                    {
                    enumLiteral_5=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getGetterEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLombokTypeAccess().getGetterEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalGenoMate.g:4078:3: (enumLiteral_6= 'NoArgsConstructor' )
                    {
                    // InternalGenoMate.g:4078:3: (enumLiteral_6= 'NoArgsConstructor' )
                    // InternalGenoMate.g:4079:4: enumLiteral_6= 'NoArgsConstructor'
                    {
                    enumLiteral_6=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getNoArgsConstructorEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLombokTypeAccess().getNoArgsConstructorEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalGenoMate.g:4086:3: (enumLiteral_7= 'RequiredArgsConstructor' )
                    {
                    // InternalGenoMate.g:4086:3: (enumLiteral_7= 'RequiredArgsConstructor' )
                    // InternalGenoMate.g:4087:4: enumLiteral_7= 'RequiredArgsConstructor'
                    {
                    enumLiteral_7=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getRequiredArgsConstructorEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLombokTypeAccess().getRequiredArgsConstructorEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalGenoMate.g:4094:3: (enumLiteral_8= 'Setter' )
                    {
                    // InternalGenoMate.g:4094:3: (enumLiteral_8= 'Setter' )
                    // InternalGenoMate.g:4095:4: enumLiteral_8= 'Setter'
                    {
                    enumLiteral_8=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getSetterEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLombokTypeAccess().getSetterEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalGenoMate.g:4102:3: (enumLiteral_9= 'Singular' )
                    {
                    // InternalGenoMate.g:4102:3: (enumLiteral_9= 'Singular' )
                    // InternalGenoMate.g:4103:4: enumLiteral_9= 'Singular'
                    {
                    enumLiteral_9=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getSingularEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLombokTypeAccess().getSingularEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalGenoMate.g:4110:3: (enumLiteral_10= 'SuperBuilder' )
                    {
                    // InternalGenoMate.g:4110:3: (enumLiteral_10= 'SuperBuilder' )
                    // InternalGenoMate.g:4111:4: enumLiteral_10= 'SuperBuilder'
                    {
                    enumLiteral_10=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getSuperBuilderEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLombokTypeAccess().getSuperBuilderEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalGenoMate.g:4118:3: (enumLiteral_11= 'ToString' )
                    {
                    // InternalGenoMate.g:4118:3: (enumLiteral_11= 'ToString' )
                    // InternalGenoMate.g:4119:4: enumLiteral_11= 'ToString'
                    {
                    enumLiteral_11=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getLombokTypeAccess().getToStringEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLombokTypeAccess().getToStringEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLombokType"


    // $ANTLR start "ruleBuiltInType"
    // InternalGenoMate.g:4129:1: ruleBuiltInType returns [Enumerator current=null] : ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'long' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'Double' ) | (enumLiteral_4= 'String' ) | (enumLiteral_5= 'LocalDate' ) | (enumLiteral_6= 'LocalDateTime' ) | (enumLiteral_7= 'BigDecimal' ) ) ;
    public final Enumerator ruleBuiltInType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalGenoMate.g:4135:2: ( ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'long' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'Double' ) | (enumLiteral_4= 'String' ) | (enumLiteral_5= 'LocalDate' ) | (enumLiteral_6= 'LocalDateTime' ) | (enumLiteral_7= 'BigDecimal' ) ) )
            // InternalGenoMate.g:4136:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'long' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'Double' ) | (enumLiteral_4= 'String' ) | (enumLiteral_5= 'LocalDate' ) | (enumLiteral_6= 'LocalDateTime' ) | (enumLiteral_7= 'BigDecimal' ) )
            {
            // InternalGenoMate.g:4136:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'long' ) | (enumLiteral_2= 'Integer' ) | (enumLiteral_3= 'Double' ) | (enumLiteral_4= 'String' ) | (enumLiteral_5= 'LocalDate' ) | (enumLiteral_6= 'LocalDateTime' ) | (enumLiteral_7= 'BigDecimal' ) )
            int alt86=8;
            switch ( input.LA(1) ) {
            case 131:
                {
                alt86=1;
                }
                break;
            case 132:
                {
                alt86=2;
                }
                break;
            case 133:
                {
                alt86=3;
                }
                break;
            case 134:
                {
                alt86=4;
                }
                break;
            case 135:
                {
                alt86=5;
                }
                break;
            case 136:
                {
                alt86=6;
                }
                break;
            case 137:
                {
                alt86=7;
                }
                break;
            case 138:
                {
                alt86=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // InternalGenoMate.g:4137:3: (enumLiteral_0= 'int' )
                    {
                    // InternalGenoMate.g:4137:3: (enumLiteral_0= 'int' )
                    // InternalGenoMate.g:4138:4: enumLiteral_0= 'int'
                    {
                    enumLiteral_0=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getIntEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBuiltInTypeAccess().getIntEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGenoMate.g:4145:3: (enumLiteral_1= 'long' )
                    {
                    // InternalGenoMate.g:4145:3: (enumLiteral_1= 'long' )
                    // InternalGenoMate.g:4146:4: enumLiteral_1= 'long'
                    {
                    enumLiteral_1=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getLongEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBuiltInTypeAccess().getLongEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGenoMate.g:4153:3: (enumLiteral_2= 'Integer' )
                    {
                    // InternalGenoMate.g:4153:3: (enumLiteral_2= 'Integer' )
                    // InternalGenoMate.g:4154:4: enumLiteral_2= 'Integer'
                    {
                    enumLiteral_2=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getIntegerEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBuiltInTypeAccess().getIntegerEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGenoMate.g:4161:3: (enumLiteral_3= 'Double' )
                    {
                    // InternalGenoMate.g:4161:3: (enumLiteral_3= 'Double' )
                    // InternalGenoMate.g:4162:4: enumLiteral_3= 'Double'
                    {
                    enumLiteral_3=(Token)match(input,134,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getDoubleEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBuiltInTypeAccess().getDoubleEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGenoMate.g:4169:3: (enumLiteral_4= 'String' )
                    {
                    // InternalGenoMate.g:4169:3: (enumLiteral_4= 'String' )
                    // InternalGenoMate.g:4170:4: enumLiteral_4= 'String'
                    {
                    enumLiteral_4=(Token)match(input,135,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getStringEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getBuiltInTypeAccess().getStringEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGenoMate.g:4177:3: (enumLiteral_5= 'LocalDate' )
                    {
                    // InternalGenoMate.g:4177:3: (enumLiteral_5= 'LocalDate' )
                    // InternalGenoMate.g:4178:4: enumLiteral_5= 'LocalDate'
                    {
                    enumLiteral_5=(Token)match(input,136,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getLocalDateEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getBuiltInTypeAccess().getLocalDateEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalGenoMate.g:4185:3: (enumLiteral_6= 'LocalDateTime' )
                    {
                    // InternalGenoMate.g:4185:3: (enumLiteral_6= 'LocalDateTime' )
                    // InternalGenoMate.g:4186:4: enumLiteral_6= 'LocalDateTime'
                    {
                    enumLiteral_6=(Token)match(input,137,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getLocalDateTimeEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getBuiltInTypeAccess().getLocalDateTimeEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalGenoMate.g:4193:3: (enumLiteral_7= 'BigDecimal' )
                    {
                    // InternalGenoMate.g:4193:3: (enumLiteral_7= 'BigDecimal' )
                    // InternalGenoMate.g:4194:4: enumLiteral_7= 'BigDecimal'
                    {
                    enumLiteral_7=(Token)match(input,138,FOLLOW_2); 

                    				current = grammarAccess.getBuiltInTypeAccess().getBigDecimalEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getBuiltInTypeAccess().getBigDecimalEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBuiltInType"

    // Delegated rules


    protected DFA76 dfa76 = new DFA76(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\uffff\1\13\10\15\4\uffff";
    static final String dfa_3s = "\12\5\4\uffff";
    static final String dfa_4s = "\1\u008a\11\65\4\uffff";
    static final String dfa_5s = "\12\uffff\1\1\1\4\1\2\1\3";
    static final String dfa_6s = "\16\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\175\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\13\1\12\1\13\1\14\10\uffff\1\13\42\uffff\2\13",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "\1\15\1\uffff\1\15\1\14\10\uffff\1\15\42\uffff\2\15",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3256:2: (this_GenericDataType_0= ruleGenericDataType | this_ArrayType_1= ruleArrayType | this_SimpleType_2= ruleSimpleType | this_NormalType_3= ruleNormalType )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0200000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100020L,0x0000000000000000L,0x00000000000007F8L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0xFF80000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000300000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000007C00000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x00000000FFFFFC00L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x007FFF8000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000C10L,0x0000000000000180L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000003020000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000003020100000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000F80100000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000F00100000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000E00900000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000C00900000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000040000100000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0400000000100000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001000100000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000002000100000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000014980100000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000014900100000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000014800900000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0800008000100000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0800000000100000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000010800100000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0001300000100000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000024980100000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000024900100000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000024800900000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000020800100000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001300000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0208000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0208000000100000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000000L,0x00000000000007F8L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x3000000000000020L,0x0000000000000000L,0x00000000000007F8L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x2000000000000020L,0x0000000000000000L,0x00000000000007F8L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000024L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000C10L,0x00000000000001C0L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});

}