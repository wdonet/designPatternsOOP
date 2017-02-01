package design.pattern.facade

import design.pattern.facade.subsystem.CodeGenerator
import design.pattern.facade.subsystem.LexicalAnalyzer
import design.pattern.facade.subsystem.SemanticAnalyzer
import design.pattern.facade.subsystem.SyntaxAnalyzer

class FacadeCompiler {
    LexicalAnalyzer lexicalAnalyzer
    SyntaxAnalyzer syntaxAnalyzer
    SemanticAnalyzer semanticAnalyzer
    CodeGenerator codeGenerator

    FacadeCompiler(LexicalAnalyzer lexicalAnalyzer, SyntaxAnalyzer syntaxAnalyzer,
                   SemanticAnalyzer semanticAnalyzer, CodeGenerator codeGenerator) {
        this.lexicalAnalyzer = lexicalAnalyzer
        this.syntaxAnalyzer = syntaxAnalyzer
        this.semanticAnalyzer = semanticAnalyzer
        this.codeGenerator = codeGenerator
    }

    String compile() {
        String result = lexicalAnalyzer.runLexicalAnalysis()
        result += syntaxAnalyzer.runSyntaxAnalysis()
        result += semanticAnalyzer.runSemanticAnalysis()
        result += codeGenerator.runCodeGenerator()

        return result
    }
}
