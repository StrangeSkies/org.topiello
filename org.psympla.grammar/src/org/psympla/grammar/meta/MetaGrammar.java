package org.psympla.grammar.meta;

import java.util.List;

import org.psympla.grammar.Grammar;
import org.psympla.grammar.Pattern;
import org.psympla.grammar.Rule;
import org.psympla.grammar.Symbol;

public class MetaGrammar extends Grammar {
  protected MetaGrammar() {
    super(createRules(), createTerminals());
  }

  private static List<Rule> createRules() {
    // TODO Auto-generated method stub
    return null;
  }

  private static List<Pattern<Symbol>> createTerminals() {
    // TODO Auto-generated method stub
    return null;
  }
}
