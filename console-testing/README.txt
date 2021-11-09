Automated testing is DIFFICULT when you rely on human input.
This plagues UI developers worldwide.

There are various techniques for handling this, including mock objects and
alternative input sources - like reading user-responses from a file for the testing,
but reading them from the console or GUI when the application runs for real.

This is a working example that demonstrates how to do automated unit testing without
human involvement, by reading user-responses from a file.

0. Extract zip, recommend extracting to StudentWork\MiniProject or similar.
   The result should be a *new* directory under MiniProject, called 'console-testing'.

1. Bring it into IntelliJ as a *new* standalone project:
   File -> New...  and in the dialog, select this new folder:
   C:\StudentWork\MiniProject\console-testing.

2. Add junit-4.13 as a dependency (as usual), and also the 'app-utils-1.1.jar' file,
   which resides in the lib/ folder directly under the project root directory.
   For the JAR, you can right-click -> Add as Library.

3. Review the Person class - simple!

4. Review, then run PersonClient.  This will prompt you for input at runtime.
   Prompter prompter = new Prompter(new Scanner(System.in));  // read from console

      Please enter your name:
      Please enter your age:
      Please enter your shoe size:

   Provide suitable values, e.g., your name, your age (integer), and your shoe size (decimal).

5. Review, then run PersonTest.  This reads user-responses from a file, with no human involvement.
   Prompter prompter = new Prompter(new Scanner(new File("responses/responses.txt")));  // read from file

   Review 'responses.txt' (in a folder called 'responses').
   A-HA, so *that's* where the "Jay Rostosky", "54", and "9.5" are coming from.
