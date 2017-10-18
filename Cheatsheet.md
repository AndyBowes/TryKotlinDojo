## Kotlin Basic Syntax Cheatsheet


### Data Types
Everything is an object, no primitive types !!
- Byte, Short, Int, Long
- Float, Double
- Char, String
- Boolean

Root class is Any (similar to Java's Object).  Null values are instances of Nothing.

NB - By default, data types will not allow nulls.  Suffix datatype by '?' to indicate nullable values.

```kotlin
var a:Int = null    <-- Generates compile error
var b:Int? = null   <-- Nullable 
val c = "Welcome to Kotlin"  <-- Immutable value with inferred data type
```

### Example Kotlin File

```kotlin
package my.demo

import java.util.*

fun sum(a: Int, b: Int) : Int {
  return a + b
}

class MyFirstClass(){
  fun generateId(): String {
    return 
  }
  ...
}
```

### Control of Flow
#### Conditional Statements
```kotlin
if (response.isSuccess()){
    processResponse(response)
} else {
    processError(response)
}

val max = if (a > b) a else b
```

#### When conditions
```kotlin
val ordinal = when (x){
   1 -> "1st"
   2 -> "2nd"
   3 -> "3rd"
   else -> "$(x)th"
}

fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

when (){
  ->
}
```
#### Loops
```kotlin
while (condition){
  ....
}
```

#### Iteration through  Sequences
```kotlin
for (item in collection) print(item)
for (i in 1..100) { ... }  


```

### Function Definitions
1. Simple
1. Inferred Return Type
1. Default Parameter Values
1. Named Parameters

### Functional Programming
Functions can be declared as variables, passed as parameters and returned from functions.

```

```

### Lambda Functions


### Collections


### More

- Coroutines
- Android
- Native

## Further Reading


