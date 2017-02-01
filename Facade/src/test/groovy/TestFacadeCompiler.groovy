import design.pattern.facade.FacadeCompiler
import design.pattern.facade.subsystem.CodeGenerator
import design.pattern.facade.subsystem.LexicalAnalyzer
import design.pattern.facade.subsystem.SemanticAnalyzer
import design.pattern.facade.subsystem.SyntaxAnalyzer
import spock.lang.Specification

class TestFacadeCompiler extends Specification {

    def "Verify facade executes all expected functionalities"() {
        setup:
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer()
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer()
        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer()
        CodeGenerator codeGenerator = new CodeGenerator()
        FacadeCompiler facadeCompiler = new FacadeCompiler(lexicalAnalyzer, syntaxAnalyzer,
                semanticAnalyzer, codeGenerator)

        when:
        String compilation = facadeCompiler.compile()

        then:
        compilation == 'Lexical Analysis complete.' +
                'Syntax Analysis complete.' +
                'Semantic Analysis complete.' +
                'Code generator complete.'
    }
}
