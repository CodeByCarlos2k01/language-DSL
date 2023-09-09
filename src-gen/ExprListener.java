// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(ExprParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(ExprParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Grupo}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGrupo(ExprParser.GrupoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Grupo}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGrupo(ExprParser.GrupoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Soma}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSoma(ExprParser.SomaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Soma}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSoma(ExprParser.SomaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Elem}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterElem(ExprParser.ElemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Elem}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitElem(ExprParser.ElemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Produto}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterProduto(ExprParser.ProdutoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Produto}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitProduto(ExprParser.ProdutoContext ctx);
}