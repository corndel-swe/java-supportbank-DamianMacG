# Day 1 Exercises

The repository has some code in it already, but it isn't working because the
project hasn't been set up properly! The focus of these exercises is to follow
the steps required to get this repo working.

## Exercise 1: Setting up the project

- [x] Read the docs on
      [Creating a Maven project](https://tech-docs.corndel.com/java/creating-projects.html).

The rest of the steps have been done in this repo, but `picocli` hasn't been
added!

- [x] Add the `picocli`
      [dependency](https://tech-docs.corndel.com/java/creating-projects.html#adding-dependencies)
      to the `pom.xml` file

- [x] Run `./mvnw clean compile`

- [x] Run `./mvnw test -DTest="D1E1Test"` to check it's right, then commit and
      push

## Exercise 2: Creating a CLI

- [x] Read the docs on
      [creating a CLI](https://tech-docs.corndel.com/java/making-a-cli.html)

There is a file in `exercises/HelloWorld.java` where we will create a simple
CLI.

Use `picocli` just like in the video to create a CLI according to the following
specifications:

- [x] Import `picocli.CommandLine` and `picocli.CommandLine.Command`

- [x] Use the `@Command` decorator, making sure the `name` is `"hello"`

- [x] Make sure the `Hello` class implements runnable and `@Override`s the
      `run()` method

- [x] The `run()` should simply print `"Hello, World!"` (this is
      case-sensitive!)

- [x] In the `main()` method, create and execute the CLI and call `System.exit`
      with the exit code

> [!TIP]
>
> If you want to debug your CLI, you should be able to run it directly with the
> command
>
> ```bash
> ./mvnw exec:java -Phelloworld
> ```

- [ ] Run `./mvnw test -DTest="D1E2Test"` to check it's right, then commit and
      push

## Exercise 3: Adding params

- [ ] Add a `@Parameter` to the `HelloWorld` class

- [ ] Make sure the `index` is `0`

- [ ] Set `defaultValue = "World"` in the parameter to ensure that Exercise 2
      doesn't break!

- [ ] Run `./mvnw test -DTest="D1E3Test"` to check it's right, then commit and
      push

> [!TIP]
>
> You can debug your CLI with arguments by running a command like
>
> ```bash
> ./mvnw exec:java -Phelloworld -Dexec.args="Alice"
> ```

## Exercise 4: Attaching a subcommand

In `exercises/ColorCommand` you will find a subcommand. All we need to do is
attach it to the `HelloWorld` app!

- [ ] Read the notes on
      [adding subcommands](https://tech-docs.corndel.com/java/adding-subcommands.html)

- [ ] Take a look at the `exercises/ColorCommand` file. Uncomment the whole
      file. (`Ctrl + A` to select all, and `Ctrl + /` to toggle comment.)

- [ ] Add the `ColorCommand` subcommand to the `HelloWorld` app by including it
      in the `subcommands` argument.

- [ ] Run `./mvnw test -DTest="D1E4Test"` to check it's right, then commit and
      push

> [!NOTE]
>
> this is a simple subcommand, not a nested subcommand, so your code will look
> more like
> [this section](https://tech-docs.corndel.com/java/adding-subcommands.html#a-simple-subcommand)
> (i.e. you don't need to make a controller class).

> [!TIP]
>
> You can debug the color subcommand by running
>
> ```bash
> ./mvnw exec:java -Phelloworld -Dexec.args="color"
> ```
