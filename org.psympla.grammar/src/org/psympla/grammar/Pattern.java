package org.psympla.grammar;

import java.util.Optional;
import java.util.stream.Stream;

/*-
 * 


Symbolic Metapattern Expression Grammar





for every rule containing variables, expand all terms on the RHS
by recursive partial application of other rules, discarding (and
short-circuiting) when we get to productions which 







1. (start)                    ->    (stack)
2. (stack ...L)               ->    (stack stack ...L)
                               |    ('a' ...L)
3. (X stack ...L)             ->    (X) (X ...L)
4. (stack stack stack cheese) ->    ?


-------------------------


1. (start)                    ->    (stack)
2. (stack ...L)               ->    (stack stack ...L)            PA 4
                                 2  (stack stack stack ...L)
                                 2  ('a' stack ...L)
                               |    ('a' ...L)                    PA 3
3. (X stack ...L)             ->    (X) (X ...L)                  PA 3
4. (stack stack stack cheese) ->    ?


-------------------------


1. (start)                    ->    (stack)
2. (stack ...L)               ->    (stack stack ...L)            PA 4
                                 2  (stack stack stack ...L)
                                 2  ('a' stack ...L)
                               |    ('a' ...L)                    PA 3
3. (X stack ...L)             ->    (X) (X ...L)                  PA 3
4. (stack stack stack cheese) ->    ?





 * 
 */
public interface Pattern<T extends LexicalItem<T>> {
  /**
   * @return the uninstantiated variables mentioned by this pattern
   */
  Stream<Variable<?>> getVariables();

  /**
   * The construct operation makes a substitution of all the variables mentioned
   * by the pattern for a given set of instantiations.
   * <p>
   * The inverse of this function is {@link #destructure(ParameterizedSymbol)}.
   * 
   * @param instantiations
   * @return
   */
  T construct(Instantiations instantiations);

  /**
   * The destructure operation is a pattern matcher. If possible, it finds the set
   * of instantiations for the variables mentioned by the pattern such that the
   * result is the given symbol. If this is not possible then it is said that the
   * given symbol does not match the pattern.
   * <p>
   * The inverse of this function is {@link #construct(Instantiations)}.
   * 
   * @param symbol
   * @return
   */
  Optional<Instantiations> destructure(T symbol);
}
