Explain what happens during compilation and execution of the following program.

The class Interference is declared, containing a static inner class Thing<T> that
takes a generic type parameter T and contains a private field of type T, a get and
a set method. A second inner class ThingThing<T> is declared that extends Thing<T>
and also takes a type parameter T, and overrides the set method but just calls the
parent's method. A static method outputThinges declares a parameter type U, takes
as input a List parameterized with type Thing, which is parameterized with the type
U (generic type declared), and iterates the argument printing its elements. Another
similar static method inputThing again declares a parameter type U, takes as input
an element to be added of type U (generic type declared) and a List parameterized
with type Thing, which is parameterized with the type U (generic type declared),
and iterates the argument printing its elements.

The main method creates an ArrayList object listOfIntegerThinges, using the type
parameter Thing<Integer>. Three method calls are made to add 3 Integer objects
using the insertThing method, that wraps the Integers as as Thing objects and
add them to the previously created list. The method outputThinges is then called,
which makes it iterate over the list, unwrap the Thing objects and print the elements.

Similarly to the first list instanciated, a second list is created as an ArrayList
object listOfStrings, using the type parameter Thing<String>. Two method calls are
made to add 2 String objects using the insertThing method, that wraps the Strings as
Thing objects and add them to the previously created list. The method outputThinges is
then called, which makes it iterate over the list, unwrap the Thing objects and print
the elements.

The line that is comment will cause a compilation time error because an Integer object
is being passed to a generics static method that expects a String as parameterized in
this call.
