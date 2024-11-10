# Master Thesis Project: "Vulnerability Detection in Multiple Languages"

- In this version, **GT-Tool** supports value tracking (primitive values and objects), web frameworks, multiple file analysis in one execution and many other functionalities that are explained in detail in the dissertation document.

- To run an application/program, check the *ParserRun.java* file (main entry point to give the tool the necessary information to analyse the application) which contains an example there. Can also go through the *experimentalEvaluationTests* folder to see how the tests were made!

 Will update this README if needed.

---

# GT-Tool v3

**Requires Java 21 or newer!**

Tested and ran on Linux and Windows.

## Install ANTLR4

Follow https://github.com/antlr/antlr4/blob/master/doc/getting-started.md#unix

## Building and running the project

Build the project and install its dependencies before running the tool.

To run this project, simply run the main function of the `ParserRun.java` file.
Change the `reportFilePath` of the `GT/src/main/resource/astconverter-settings.json` file to your desired output 
report file path. If it is not provided, the tool will default to a newly created temporary directory with a report.
json file inside.

## Tests

Unpack the `Experimental_Evaluation.zip` file in `GT/src/test/resources` and run the tests
