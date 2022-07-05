DSVConverter CONVERT DSV(_Delimiter-separated values_) files into JSONL (JSON line) format.

To create  jar:
Run "_`mvn package`_" command in your Maven terminal.This will
create DSVConverter.jar in project output directory.


To run jar in command Line with arguments:
`java -jar "PATH_TO_JAR\DSVConverter.jar" "PATH_TO_INPUT_TEXT_FILE\DSV input 1.txt" "YOUR_DELIMITER_PATTERN"`

Example:
`java -jar "D:\projects\dsvconverter\target\DSVConverter.jar" "D:\projects\dsvconverter\src\main\resources\DSV input 1.txt" ",(?=(?:[^"]*"[^"]*")*[^"]*$)`_"



One can provide source file and delimiter later also.To do that
run:
`java -jar "PATH_TO_JAR\DSVConverter.jar`"

Example:
java -jar "_`D:\projects\dsvconverter\target\DSVConverter.jar`_"

in your command line.
then it will ask for file path.
after providing file path it will ask for DELIMITER_PATTERN.

one can find output json file form printed output file directory.


example:
-----
`_C:\Users\murad>java -jar "D:\projects\dsvconverter\target\DSVConverter.jar"
Argument Not Provided With Jar.
Please Enter file Path
D:\projects\dsvconverter\src\main\resources\DSV input 1.txt
Entered file path : D:\projects\dsvconverter\src\main\resources\DSV input 1.txt
Please Enter DELIMITER_PATTERN
,(?=(?:[^"]*"[^"]*")*[^"]*$)
Entered DELIMITER_PATTERN : ,(?=(?:[^"]*"[^"]*")*[^"]*$)_`
-----