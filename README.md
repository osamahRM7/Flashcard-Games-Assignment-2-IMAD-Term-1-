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
