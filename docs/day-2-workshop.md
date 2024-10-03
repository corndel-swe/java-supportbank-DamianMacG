# Day 2 Workshop

## Reading transactions

The support team keep their records in CSV format. Their records for 2014 are
stored in `data/Transactions2014.csv`

Note that there’s a header row, telling you what each column means. Every record
has a date and represents a payment from one person to another person. There’s
also a narrative field which describes what the payment was for.

The person in the ‘From’ column is paying money, so the amount needs to be
deducted from their account. The person in the ‘To’ column is being paid, so the
amount needs to be added to their account.

Use a class for each type of object you want to create.

You should add two commands:

- [ ] `supportbank transaction summarise <filename>` – should output the names
      of each person, and their current balance according to the given file, e.g.
      `Transactions2014.csv`.

- [ ] `supportbank transaction list <filename> <account name>` – should print a
      list of every transaction, with the date and narrative, for that person’s
      account. For example, `supportbank transaction list "jon a"` would list
      all of Jon A’s transactions.

Your main task is to make the above commands work with `Transactions2014.csv`.
git branch
## Extensions

Once you have dealt with `data/Transactions2014.csv`, there are some other files
in the `data` folder - see if you can make the application work with those, too.
You might need to do some research online to see how to deal with issues that
may crop up.

## Hints

### HashMap

You could use a `HashMap` to keep track of the user accounts. For example,

```java
Map<String, Double> accounts = new HashMap<>();

double oldBalance = accounts.containsKey(username) ? accounts.get(username) : 0.0;
double newBalance = oldBalance + amount;
accounts.put(username, newBalance);
```

### Working with csv

There is a note on
[working with CSV](https://tech-docs.corndel.com/java/file-io.html#csv) which
will give you some ideas about using split and join to deal with rows of CSV.

### JSON lists

There is a note on
[parsing lists of JSON](https://tech-docs.corndel.com/java/working-with-json.html#json-lists)
which will help with `Transactions2013.json`.

### JSON keys

If you find that the keys in the JSON don't match up with the keys in the object
you're mapping to, you can use a special decorator.

For example,

```java
class Transaction {
  @JsonProperty("Amount")
  private double value;
}
```

Now, parsing a JSON which has `{ "Amount": 1.57 }` will map `1.57` into the
`value` property of the `Transaction` class.

### XML

There are some notes on how to parse XML
[here](https://www.baeldung.com/java-xerces-dom-parsing)
