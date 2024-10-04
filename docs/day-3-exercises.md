# Day 3 Exercises

## Exercise 1: Environment variables

- [x] Have a look at the documentation on
      [environment variables](https://tech-docs.corndel.com/java/environment-variables.html)

- [x] Create a `.env` file in the root of your project

- [x] Add the following environment variable:

```
SECRET_PASSWORD=opensesame
```

- [x] Test, commit and push!

## Exercise 2: GET Requests

In this exercise, we'll be fetching data from the
[PokeAPI](https://pokeapi.co/docs/v2).

- [x] Have a look at the documentation on
      [fetching data](https://tech-docs.corndel.com/java/fetching-data.html).

- [x] Open `exercises/pokeAPI.java`.

- [x] Complete the static method `getPokemonByName(name)`. It should

  - make a `GET` request to `"https://pokeapi.co/api/v2/pokemon/" + name`

  - map the response body into `Pokemon.class` (this class is provided for you
    in the `pokeAPI.java` file)

  - return the `Pokemon` object

## Exercise 3: POST Requests

- [x] Have a look at the documentation on
      [posting data](https://tech-docs.corndel.com/java/http-post.html)

- [x] Open `exercises/Postman.java`

- [x] Use the `id` and `content` arguments to create a new `Message` and send it
      as the body of a POST request to `https://postman-echo.com/post`. (All
      this endpoint does is sends the same data back in a slightly different
      format, it's generally used for testing purposes.)

- [x] Return the body of the response directly, i.e. return a string of JSON
      rather than an object.

> [!WARNING]
>
> Make sure to set the Content-Type header to application/json

## Extension

See if you can get a list of pokemon back from the API, and map it into a java
`List` of `Pokemon` objects.

There is a note on parsing lists of JSON
[here](https://tech-docs.corndel.com/java/working-with-json.html#json-lists).
