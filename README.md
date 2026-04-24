# Flashcard-Games-Assignment-2-IMAD-Term-1-










* Refrence

1-(Expline the logical of the array lisit (https://developer.android.com/codelabs/basic-android-kotlin-collections#2))

3. Lists
A list is an ordered, resizable collection, typically implemented as a resizable array. When the array is filled to capacity and you try to insert a new element, the array is copied to a new bigger array.

a4970d42cd1d2b66.png

With a list, you can also insert new elements between other elements at a specific index.

27afd8dd880e1ae5.png

This is how lists are able to add and remove elements. In most cases, it takes the same amount of time to add any element to a list, regardless of how many elements are in the list. Every once in a while, if adding a new element would put the array above its defined size, the array elements might have to move to make room for new elements. Lists do all of this for you, but behind the scenes, it's just an array that gets swapped out for a new array when needed.

List and MutableList
The collection types you'll encounter in Kotlin implement one or more interfaces. As you learned in the Generics, Objects, and Extensions codelab earlier in this unit, interfaces provide a standard set of properties and methods for a class to implement. A class that implements the List interface provides implementations for all the properties and methods of the List interface. The same is true for MutableList.

So what do List and MutableList do?

List is an interface that defines properties and methods related to a read-only ordered collection of items.
MutableList extends the List interface by defining methods to modify a list, such as adding and removing elements.
These interfaces only specify the properties and methods of a List and/or MutableList. It's up to the class that extends them to determine how each property and method is implemented. The array-based implementation described above is what you'll use most, if not all of the time, but Kotlin allows other classes to extend List and MutableList.

The listOf() function
Like arrayOf(), the listOf() function takes the items as parameters, but returns a List rather than an array.

Remove the existing code from main().
In main(), create a List of planets called solarSystem by calling listOf().

fun main() {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
}
List has a size property to get the number of elements in the list. Print the size of the solarSystem list.

println(solarSystem.size) 
Run your code. The size of the list should be 8.

8
Access elements from a list
Like an array, you can access an element at a specific index from a List using subscript syntax. You can do the same using the get() method. Subscript syntax and the get() method take an Int as a parameter and return the element at that index. Like Array, ArrayList is zero-indexed, so for example, the fourth element would be at index 3.

Print the planet at index 2 using subscript syntax.

println(solarSystem[2])
Print the element at index 3 by calling get() on the solarSystem list.

println(solarSystem.get(3))
Run your code. The element at index 2 is "Earth" and the element at index 3 is "Mars".

...
Earth
Mars
In addition to getting an element by its index, you can also search for the index of a specific element using the indexOf() method. The indexOf() method searches the list for a given element (passed in as an argument), and returns the index of the first occurrence of that element. If the element doesn't occur in the list, it returns -1.

Print the result of calling indexOf() on the solarSystem list, passing in "Earth".

println(solarSystem.indexOf("Earth"))
Call indexOf(), passing in "Pluto", and print the result.

println(solarSystem.indexOf("Pluto"))
Run your code. An element matches "Earth", so the index, 2, is printed. There isn't an element that matches "Pluto", so -1 is printed.

...
2
-1
Iterate over list elements using a for loop
When you learned about function types and lambda expressions, you saw how you could use the repeat() function to execute code multiple times.

A common task in programming is to perform a task once for each element in a list. Kotlin includes a feature called a for loop to accomplish this with a concise and readable syntax. You'll often see this referred to as looping through a list or iterating over a list.

1245a226a9ceeba1.png

To loop through a list, use the for keyword, followed by a pair of opening and closing parentheses. Within the parentheses, include a variable name, followed by the in keyword, followed by the name of the collection. After the closing parenthesis comes a pair of opening and closing curly braces, where you include the code you want executed for each element in the collection. This is known as the body of the loop. Each time this code executes is known as an iteration.

The variable before the in keyword isn't declared with val or var—it's assumed to be get-only. You can name it anything you want. If a list is given a plural name, like planets, it's common to name the variable the singular form, such as planet. It's also common to name the variable item or element.

This will be used as a temporary variable corresponding to the current element in the collection—the element at index 0 for the first iteration, element at index 1 for the second iteration, and so on, and can be accessed within the curly braces.

To see this in action, you'll print out each planet name on a separate line using a for loop.

In main(), below the most recent call to println(), add a for loop. Within the parentheses, name the variable planet, and loop through the solarSystem list.

for (planet in solarSystem) {
}
Within the curly braces, print the value of planet using println().

for (planet in solarSystem) {
    println(planet)
}
Run your code. The code within the body of the loop is executed for each item in the collection.

...
Mercury
Venus
Earth
Mars
Jupiter
Saturn
Uranus
Neptune
Add elements to a list
The ability to add, remove, and update elements in a collection is exclusive to classes that implement the MutableList interface. If you were keeping track of newly discovered planets, you'd likely want the ability to frequently add elements to a list. You need to specifically call the mutableListOf() function, instead of listOf(), when creating a list you wish to add and remove elements from.

There are two versions of the add() function:

The first add() function has a single parameter of the type of element in the list and adds it to the end of the list.
The other version of add() has two parameters. The first parameter corresponds to an index at which the new element should be inserted. The second parameter is the element being added to the list.
Let's see both in action.

Change the initialization of solarSystem to call mutableListOf() instead of listOf(). You can now call methods defined in MutableList.

val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
Again, we might want to classify Pluto as a planet. Call the add() method on solarSystem, passing in "Pluto" as the single argument.

solarSystem.add("Pluto")
Some scientists theorize a planet called Theia used to exist before colliding with Earth and forming the Moon. Insert "Theia" at index 3, between "Earth" and "Mars".

solarSystem.add(3, "Theia")
Update elements at a specific index
You can update existing elements with subscript syntax:

Update the value at index 3 to "Future Moon".

solarSystem[3] = "Future Moon"
Print the value at indexes 3 and 9 using subscript syntax.

println(solarSystem[3])
println(solarSystem[9])
Run your code to verify the output.

Future Moon
Pluto
Remove elements from a list
Elements are removed using the remove() or removeAt() method. You can either remove an element by passing it into the remove() method or by its index using removeAt().

Let's see both methods to remove an element in action.

Call removeAt() on solarSystem, passing in 9 for the index. This should remove "Pluto" from the list.

solarSystem.removeAt(9)
Call remove() on solarSystem, passing in "Future Moon" as the element to remove. This should search the list, and if a matching element is found, it will be removed.

solarSystem.remove("Future Moon")
List provides the contains() method that returns a Boolean if an element exists in a list. Print the result of calling contains() for "Pluto".

println(solarSystem.contains("Pluto"))
An even more concise syntax is to use the in operator. You can check if an element is in a list using the element, the in operator, and the collection. Use the in operator to check if solarSystem contains "Future Moon".

println("Future Moon" in solarSystem)
Run your code. Both statements should print false.

...
false
false

#2- (Expline the logical of the array lisit for Boolen(https://kotlinlang.org/docs/arrays.html))

An array is a data structure that holds a fixed number of values of the same type or its subtypes. The most common type of array in Kotlin is the object-type array, represented by the Array class.

If you use primitives in an object-type array, this has a performance impact because your primitives are boxed into objects. To avoid boxing overhead, use primitive-type arrays instead.

When to use arrays﻿
Use arrays in Kotlin when you have specialized low-level requirements that you need to meet. For example, if you have performance requirements beyond what is needed for regular applications, or you need to build custom data structures. If you don't have these sorts of restrictions, use collections instead.

Collections have the following benefits compared to arrays:

Collections can be read-only, which gives you more control and allows you to write robust code that has a clear intent.

It is easy to add or remove elements from collections. In comparison, arrays are fixed in size. The only way to add or remove elements from an array is to create a new array each time, which is very inefficient:

var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
​
// Using the += assignment operation creates a new riversArray,
// copies over the original elements and adds "Mississippi"
riversArray += "Mississippi"
println(riversArray.joinToString())
// Nile, Amazon, Yangtze, Mississippi
Open in Playground →
Target: JVM
Running on v.2.3.21
You can use the equality operator (==) to check if collections are structurally equal. You can't use this operator for arrays. Instead, you have to use a special function, which you can read more about in Compare arrays.

For more information about collections, see Collections overview.

Create arrays﻿
To create arrays in Kotlin, you can use:

functions, such as arrayOf(), arrayOfNulls() or emptyArray().

the Array constructor.

This example uses the arrayOf() function and passes item values to it:

// Creates an array with values [1, 2, 3]
val simpleArray = arrayOf(1, 2, 3)
println(simpleArray.joinToString())
// 1, 2, 3
Open in Playground →
Target: JVM
Running on v.2.3.21
This example uses the arrayOfNulls() function to create an array of a given size filled with null elements:

// Creates an array with values [null, null, null]
val nullArray: Array<Int?> = arrayOfNulls(3)
println(nullArray.joinToString())
// null, null, null
Open in Playground →
Target: JVM
Running on v.2.3.21
This example uses the emptyArray() function to create an empty array :

var exampleArray = emptyArray<String>()
You can specify the type of the empty array on the left-hand or right-hand side of the assignment due to Kotlin's type inference.

For example:

var exampleArray = emptyArray<String>()

var exampleArray: Array<String> = emptyArray()
The Array constructor takes the array size and a function that returns values for array elements given its index:

// Creates an Array<Int> that initializes with zeros [0, 0, 0]
val initArray = Array<Int>(3) { 0 }
println(initArray.joinToString())
// 0, 0, 0
​
// Creates an Array<String> with values ["0", "1", "4", "9", "16"]
val asc = Array(5) { i -> (i * i).toString() }
asc.forEach { print(it) }
// 014916
Open in Playground →
Target: JVM
Running on v.2.3.21
Like in most programming languages, indices start from 0 in Kotlin.

Nested arrays﻿
Arrays can be nested within each other to create multidimensional arrays:

// Creates a two-dimensional array
val twoDArray = Array(2) { Array<Int>(2) { 0 } }
println(twoDArray.contentDeepToString())
// [[0, 0], [0, 0]]
​
// Creates a three-dimensional array
val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 0 } } }
println(threeDArray.contentDeepToString())
// [[[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]
Open in Playground →
Target: JVM
Running on v.2.3.21
Nested arrays don't have to be the same type or the same size.

Access and modify elements﻿
Arrays are always mutable. To access and modify elements in an array, use the indexed access operator[]:

val simpleArray = arrayOf(1, 2, 3)
val twoDArray = Array(2) { Array<Int>(2) { 0 } }
​
// Accesses the element and modifies it
simpleArray[0] = 10
twoDArray[0][0] = 2
​
// Prints the modified element
println(simpleArray[0].toString()) // 10
println(twoDArray[0][0].toString()) // 2
Open in Playground →
Target: JVM
Running on v.2.3.21
Arrays in Kotlin are invariant. This means that Kotlin doesn't allow you to assign an Array<String> to an Array<Any> to prevent a possible runtime failure. Instead, you can use Array<out Any>. For more information, see Type Projections.

Work with arrays﻿
In Kotlin, you can work with arrays by using them to pass a variable number of arguments to a function or perform operations on the arrays themselves. For example, comparing arrays, transforming their contents or converting them to collections.

Pass variable number of arguments to a function﻿
In Kotlin, you can pass a variable number of arguments to a function via the vararg parameter. This is useful when you don't know the number of arguments in advance, like when formatting a message or creating an SQL query.

To pass an array containing a variable number of arguments to a function, use the spread operator (*). The spread operator passes each element of the array as individual arguments to your chosen function:

fun main() {
    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", *lettersArray)
    // abcd
}
​
fun printAllStrings(vararg strings: String) {
    for (string in strings) {
        print(string)
    }
}
Open in Playground →
Target: JVM
Running on v.2.3.21
For more information, see Variable number of arguments (varargs).

Compare arrays﻿
To compare whether two arrays have the same elements in the same order, use the .contentEquals() and .contentDeepEquals() functions:

val simpleArray = arrayOf(1, 2, 3)
val anotherArray = arrayOf(1, 2, 3)
​
// Compares contents of arrays
println(simpleArray.contentEquals(anotherArray))
// true
​
// Using infix notation, compares contents of arrays after an element 
// is changed
simpleArray[0] = 10
println(simpleArray contentEquals anotherArray)
// false
Open in Playground →
Target: JVM
Running on v.2.3.21
Don't use equality (==) and inequality (!=) operators to compare the contents of arrays. These operators check whether the assigned variables point to the same object.

To learn more about why arrays in Kotlin behave this way, see our blog post.

Transform arrays﻿
Kotlin has many useful functions to transform arrays. This document highlights a few but this isn't an exhaustive list. For the full list of functions, see our API reference.

Sum﻿
To return the sum of all elements in an array, use the .sum() function:

val sumArray = arrayOf(1, 2, 3)
​
// Sums array elements
println(sumArray.sum())
// 6
Open in Playground →
Target: JVM
Running on v.2.3.21
The .sum() function can only be used with arrays of numeric data types, such as Int.

Shuffle﻿
To randomly shuffle the elements in an array, use the .shuffle() function:

val simpleArray = arrayOf(1, 2, 3)
​
// Shuffles elements [3, 2, 1]
simpleArray.shuffle()
println(simpleArray.joinToString())
​
// Shuffles elements again [2, 3, 1]
simpleArray.shuffle()
println(simpleArray.joinToString())
Open in Playground →
Target: JVM
Running on v.2.3.21
Convert arrays to collections﻿
If you work with different APIs where some use arrays and some use collections, then you can convert your arrays to collections and vice versa.

Convert to List or Set﻿
To convert an array to a List or Set, use the .toList() and .toSet() functions.

val simpleArray = arrayOf("a", "b", "c", "c")
​
// Converts to a Set
println(simpleArray.toSet())
// [a, b, c]
​
// Converts to a List
println(simpleArray.toList())
// [a, b, c, c]
Open in Playground →
Target: JVM
Running on v.2.3.21
Convert to Map﻿
To convert an array to a Map, use the .toMap() function.

Only an array of Pair<K,V> can be converted to a Map. The first value of a Pair instance becomes a key, and the second becomes a value. This example uses the infix notation to call the to function to create tuples of Pair:

val pairArray = arrayOf("apple" to 120, "banana" to 150, "cherry" to 90, "apple" to 140)
​
// Converts to a Map
// The keys are fruits and the values are their number of calories
// Note how keys must be unique, so the latest value of "apple"
// overwrites the first
println(pairArray.toMap())
// {apple=140, banana=150, cherry=90}
​
Open in Playground →
Target: JVM
Running on v.2.3.21
Primitive-type arrays﻿
If you use the Array class with primitive values, these values are boxed into objects. As an alternative, you can use primitive-type arrays, which allow you to store primitives in an array without the side effect of boxing overhead:

Primitive-type array

Equivalent in Java

BooleanArray

boolean[]

ByteArray

byte[]

CharArray

char[]

DoubleArray

double[]

FloatArray

float[]

IntArray

int[]

LongArray

long[]

ShortArray

short[]

These classes have no inheritance relation to the Array class, but they have the same set of functions and properties.

This example creates an instance of the IntArray class:

// Creates an array of Int of size 5 with the values initialized to zero
val exampleArray = IntArray(5)
println(exampleArray.joinToString())
// 0, 0, 0, 0, 0
Open in Playground →
Target: JVM
Running on v.2.3.21
To convert primitive-type arrays to object-type arrays, use the .toTypedArray() function.

To convert object-type arrays to primitive-type arrays, use .toBooleanArray(), .toByteArray(), .toCharArray(), and so on.
