At the moment HEDL does not wrap nullable Double/Integer
types into their corresponding object class.

Therefore the generated entities are changed (replacing double with Double where required).
This mean in particular after each generation the entities *must* be edited again.

See https://github.com/DevBoost/HEDL/issues/4 for details.