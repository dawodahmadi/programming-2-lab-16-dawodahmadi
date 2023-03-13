# Programming 2 - Lab 16

This template repository is the starter project for Programming 2 Lab 16. Written in Java, and tested with Gradle/JUnit.

### Question(s)

1. **Exceptions Aren't Always Errors**

File CountLetters.java contains a program that reads a word from the user and prints the number
of occurrences of each letter in the word. Save it to your directory and study it, then compile and
run it to see how it works. In reading the code, note that the word is converted to all upper case
first, then each letter is translated to a number in the range 0..25 (by subtracting 'A') for use as an
index. No test is done to ensure that the characters are in fact letters.

1.1. Run CountLetters and enter a phrase, that is, more than one word with spaces or other punctuation in between. It should throw an ArrayIndexOutOfBoundsException, because a non-letter will generate an index that is not between 0 and 25. It might be desirable to allow non-letter characters, but not count them. Of course, you could explicitly test the value of the character to see if it is between 'A' and 'Z'. However, an alternative is to go ahead and use the translated character as an index and catch an ArrayIndexOutOfBoundsException if it occurs. Since you don't want to do anything when a non-letter occurs, the handler will be empty. Modify this method to do this as follows:

- Put the body of the first for loop in a try.
- Add a catch that catches the exception, but don't do anything with it.

Compile and run your program.

1.2. Now modify the body of the catch so that it prints a useful message (e.g., "Not a letter") followed by the exception. Compile and run the program. Although it's useful to print the exception for debugging when you're trying to smoothly handle a condition that you don't consider erroneous you often don't want to. In your print statement, replace the exception with the character that created the out-of-bounds index. Run the program again; much nicer!

2. **Placing Exception Handlers**

File ParseInts.java contains a program that does the following:

- Prompts for and reads in a line of input
- Uses a second Scanner to take the input line one token at a time and parses an integer from each token as it is extracted.
- Sums the integers.
- Prints the sum. Save ParseInts to your directory and compile and run it. If you give it the input

10 20 30 40

it should print

The sum of the integers on the line is 100.

Try some other inputs as well. Now try a line that contains both integers and other values, e.g.,

We have 2 dogs and 1 cat.

You should get a NumberFormatException when it tries to call Integer.parseInt on "We", which
is not an integer. One way around this is to put the loop that reads inside a try and catch the
NumberFormatException but not do anything with it. This way if it's not an integer it doesn't
cause an error; it goes to the exception handler, which does nothing. Do this as follows:

- Modify the program to add a try statement that encompasses the entire while loop. The try and opening { should go before the while and the catch after the loop body. Catch a NumberFormatException and have an empty body for the catch.

- Compile and run the program and enter a line with mixed integers and other values. You should find that it stops summing at the first non-integer, so the line above will produce a sum of 0, and the line "1 fish 2 fish" will produce a sum of 1. This is because the entire loop is inside the try, so when an exception is thrown the loop is terminated. To make it continue, move the try and catch inside the loop. Now when an exception is thrown, the next statement is the next iteration of the loop, so the entire line is processed. The dogs-and-cats input should now give a sum of 3, as should the fish input.
