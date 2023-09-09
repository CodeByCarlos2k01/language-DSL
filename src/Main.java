import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.Trees;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Main {
    static Pattern classNamePatern = Pattern.compile("[a-zA-Z]+[$]([A-Za-z]+)Context");
    static String getRule(ParseTree t) {
       String className = t.getClass().getName();
       Matcher m = classNamePatern.matcher(className);
       if (m.find()) return m.group(1);
       return null;
    }
    
    static List<Double> doubleToList(Double num) {
      List<Double> list = new ArrayList<>();
      list.add(num);
      return list;
    }

    static List<Double> numbers = new ArrayList<>();
    static Map<String, List<Double>> memoria = new HashMap<>();
    public static List<Double> avalie(ParseTree t) {
        String ruleName = getRule(t);
         switch (ruleName) {
            // tratar comandos 'expr'
            //------------------------
            case "Comandos":
               avalie(t.getChild(0));
               avalie(t.getChild(1));
               return null;
            case "Print":
               System.out.println(avalie(t.getChild(1)));
               return null;
            case "Loop":
               while(avalie(t.getChild(1)).equals(doubleToList(1.0))) avalie(t.getChild(3));
               return null;
            case "Igualdade":
               return memoria.put(t.getChild(0).getText(), avalie(t.getChild(2)));
            case "IncrementoDecremento":
               return t.getChild(1).getText().equals("++") ? memoria.put(t.getChild(0).getText(), doubleToList(memoria.get(t.getChild(0).getText()).get(0) + 1.0)) 
               : memoria.put(t.getChild(0).getText(), doubleToList(memoria.get(t.getChild(0).getText()).get(0) - 1.0));
            case "Operacao":
               return avalie(t.getChild(0));

            //tratar 'cond'
            //------------------------
            case "Condicional":
               if(avalie(t.getChild(1)).equals(doubleToList(1.0))) return avalie(t.getChild(3));
               else if(t.getChildCount() == 9) return avalie(t.getChild(7));

            //tratar comandos 'comp'
            //------------------------
            case "Parentese":
               return avalie(t.getChild(1));
            case "And":
               return avalie(t.getChild(0)).equals(doubleToList(1.0)) && avalie(t.getChild(2)).equals(doubleToList(1.0)) ? 
               doubleToList(1.0) : doubleToList(0.0); 
            case "Or":
               return avalie(t.getChild(0)).equals(doubleToList(1.0)) || avalie(t.getChild(2)).equals(doubleToList(1.0)) ? 
               doubleToList(1.0) : doubleToList(0.0);
            case "Igual":
               return avalie(t.getChild(0)).equals(avalie(t.getChild(2))) ? doubleToList(1.0) : doubleToList(0.0);
            case "Diferente":
               return !avalie(t.getChild(0)).equals(avalie(t.getChild(2))) ? doubleToList(1.0) : doubleToList(0.0);
            case "Menor":
               return (avalie(t.getChild(0)) + "").compareTo(avalie(t.getChild(2)) + "") < 0 ? doubleToList(1.0) : doubleToList(0.0);
            case "MenorIgual":
               return (avalie(t.getChild(0)) + "").compareTo(avalie(t.getChild(2)) + "") <= 0 ? doubleToList(1.0) : doubleToList(0.0);
            case "Maior":
               return (avalie(t.getChild(0)) + "").compareTo(avalie(t.getChild(2)) + "") > 0 ? doubleToList(1.0) : doubleToList(0.0);
            case "MaiorIgual":
               return (avalie(t.getChild(0)) + "").compareTo(avalie(t.getChild(2)) + "") >= 0 ? doubleToList(1.0) : doubleToList(0.0);

            //tratar comandos 'op'
            //------------------------
            case "Parenteses":
               return avalie(t.getChild(1));
            case "Divisao":
               return (((List<Double>) avalie(t.getChild(0))).size() != 1) || (((List<Double>) avalie(t.getChild(2))).size() != 1) ? null
               : doubleToList(((List<Double>) avalie(t.getChild(0))).get(0) /  ((List<Double>) avalie(t.getChild(2))).get(0));
            case "Produto":
               return (((List<Double>) avalie(t.getChild(0))).size() != 1) || (((List<Double>) avalie(t.getChild(2))).size() != 1) ? null
               : doubleToList(((List<Double>) avalie(t.getChild(0))).get(0) *  ((List<Double>) avalie(t.getChild(2))).get(0));
            case "Resto":
               return (((List<Double>) avalie(t.getChild(0))).size() != 1) || (((List<Double>) avalie(t.getChild(2))).size() != 1) ? null
               : doubleToList(((List<Double>) avalie(t.getChild(0))).get(0) %  ((List<Double>) avalie(t.getChild(2))).get(0));
            case "Soma":
               return (((List<Double>) avalie(t.getChild(0))).size() != 1) || (((List<Double>) avalie(t.getChild(2))).size() != 1) ? null
               : doubleToList(((List<Double>) avalie(t.getChild(0))).get(0) +  ((List<Double>) avalie(t.getChild(2))).get(0));
            case "Subtracao":
               return (((List<Double>) avalie(t.getChild(0))).size() != 1) || (((List<Double>) avalie(t.getChild(2))).size() != 1) ? null
               : doubleToList(((List<Double>) avalie(t.getChild(0))).get(0) -  ((List<Double>) avalie(t.getChild(2))).get(0));
            case "Comando":
               return avalie(t.getChild(0));

            // tratar comandos 'com'
            //------------------------
            case "Media":
               numbers = avalie(t.getChild(2));
               return doubleToList(numbers.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN));
            case "Mediana":
               numbers = avalie(t.getChild(2));
               Collections.sort(numbers);
               double median;
               int size = numbers.size();
               median = (size % 2 == 0) ? (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2.0 : numbers.get(size / 2);
               return doubleToList(median);
            case "DPadrao":
               numbers = avalie(t.getChild(2));
               double m1 = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
               double sum = numbers.stream().mapToDouble(num -> Math.pow(num - m1, 2)).sum();
               double stddev = Math.sqrt(sum / numbers.size());
               return doubleToList(stddev);
            case "Minimo":
               numbers = avalie(t.getChild(2));
               return doubleToList(numbers.stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN));
            case "Maximo":
               numbers = avalie(t.getChild(2));
               return doubleToList(numbers.stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN));
            case "Variancia":
               numbers = avalie(t.getChild(2));
               double m2 = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
               double sumSquaredDiff = numbers.stream().mapToDouble(num -> Math.pow(num - m2, 2)).sum();
               return doubleToList(sumSquaredDiff / (numbers.size() - 1));
            case "Moda":
               numbers = avalie(t.getChild(2));
               Map<Double, Integer> freqMap = new HashMap<>();
               for (Double num : numbers) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
               int maxFrequency = Collections.max(freqMap.values());
               List<Double> modes = new ArrayList<>();
               for (Map.Entry<Double, Integer> entry : freqMap.entrySet()) 
                  if (entry.getValue() == maxFrequency) modes.add(entry.getKey());
               return modes;
            case "Lista":
               numbers = new ArrayList<>();
               for (int i = 0; i < t.getChildCount(); i++) {
                  String child = t.getChild(i).getText();
                  if (!child.equals(",")) {
                     double num = Double.parseDouble(child);
                     numbers.add(num);
                  }
               }
               return numbers;
            case "Funcao":
               return avalie(t.getChild(0));
            
            //tratar comandos 'func'
            //------------------------
            case "Add":
               List<Double> ladd = avalie(t.getChild(0));
               ladd.addAll(avalie(t.getChild(3)));
               return ladd;
            case "Remove":
               List<Double> lremove = avalie(t.getChild(0));
               lremove.removeAll(avalie(t.getChild(3)));
               return lremove;
            case "Pop":
               List<Double> lpop = avalie(t.getChild(0));
               lpop.remove(lpop.size() - 1);
               return lpop;
            case "Variavel":
               if(!memoria.containsKey(t.getChild(0).getText()))
                  memoria.put(t.getChild(0).getText(), new ArrayList<>());
               return memoria.get(t.getChild(0).getText());
        }
        throw new RuntimeException("Classe Invalida !");
    }

    public static void main(String args[]) throws Exception {
        CharStream input = CharStreams.fromFileName("input.exp");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        ExprParser parser = new ExprParser( tokens ); 
        ParserRuleContext tree = parser.expr();
        avalie(tree);
    }
}