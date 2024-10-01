# Day 2 Exercises

## Exercise 1: Throwing errors

In this exercise, we'll be working with `exercises/UserId.java`. This class can
be used like so:

```java
String id = new UserId("abcd123");
boolean isValid = id.validate();
```

- [x] Read the docs on
      [Handling Errors](https://tech-docs.corndel.com/java/handling-errors.html)

- [x] In `UserId.java`, follow the instructions to throw errors with the correct
      messages under different conditions.

- [x] Make sure to test, commit and push!

## Exercise 2: File I/O

In this exercise, we'll be working in `exercises/Adder.java` to add together all
the numbers in a file such as `src/data/nums.txt`. Each row contains a single
integer.

- [x] Have a look at
      [Reading and Writing Files](https://tech-docs.corndel.com/java/file-io.html).

> [!IMPORTANT]
>
> We will follow the convention that the input files are located in the
> `src/data` directory (or a subdirectory). When constructing your filepath, you
> should construct it as "src/data/..." like we do in the docs.

- [x] In `Adder.java`, complete the `add` method to return the sum of the
      numbers in the given file. There are hints in the file to follow. (Note
      that it isn't necessary to create a `FileIO` class in order to pass this
      exercise, just follow the hints given to read the file directly.)

- [x] Wrap your logic in a `try/catch` block and, in case of failure:

  - use `System.err.println` to print the message `"Something went wrong"`

  - return `0`

## Exercise 3: Working with JSON

Take a look at the `exercises/Element.java` file.

This class has a static method called `fromJSONFile` which accepts a filename
such as `helium.json`. These JSON files are located in `src/data/elements`. The
method's purpose is to create an instance of `Element` based on the data in the
file.

- [ ] Read the docs on
      [working with JSON](https://tech-docs.corndel.com/java/working-with-json.html)

- [ ] Use the `nio` library to read the element file specified by the filename,
      e.g. `helium.json`.

- [ ] Join the data in the file into a single JSON string.

- [ ] Use Jackson's `ObjectMapper` to convert the JSON string into an instance
      of `Element`.

- [ ] Return the newly created element.

Feel free to rethrow any errors, they're handled by the tests.

There is a `main()` method to help debug.
