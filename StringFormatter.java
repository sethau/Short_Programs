/*String Formatter
author: Seth Denney
date: 4/2013

String Formatter will take formatted text and transform it into string literal format.
*****Newlines will be divided into two lines of literals as such:
Hello
World
-becomes-
"Helllo\r\n"
+ "World"

*****Cmd Arguments:
StringFormatter.jar {filepath\filename} (-v -c -p)
OPTIONAL FLAGS
'-v': Variables will be denoted by the # sign.
My name is #userName!
-becomes-
"My names is " + userName + "!"

'-c': The variable is commented out within
the string, so that the variable's nonexistence at
the time of import will not cause any compilation errors or such.

'-p': The output will be printed to standard console output
in addition to being saved in the output file.

*****Output is stored in 'StringFormatter.out' in directory of input file.
*/

   import java.io.*;
   import java.lang.String;

   public class StringFormatter {
   
      private static int VAR = 0;
      private static int COM = 1;
      private static int PRN = 2;
     
      public static void main(String[] args) {
         boolean[] flags = {false, false, false};
       //if path has no spaces AND no flags added
         if (args.length == 1 && args[0].indexOf('.') > 0){
            parse(args[0], flags[VAR], flags[COM], flags[PRN]);
         }
         //if path has spaces OR flag(s) added
         else if (args.length > 1){
            for (int i = 1; i < args.length; i++) {
            	//if it has a '\', then probably part of the path -> add to path
               if (args[i].indexOf('\\') > 0) args[0] += " " + args[i];
               //check for flags
               else if (args[i].equals("-v")) flags[VAR] = true;
               else if (args[i].equals("-c")) flags[COM] = true;
               else if (args[i].equals("-p")) flags[PRN] = true;
            }
            parse(args[0], flags[VAR], flags[COM], flags[PRN]);
         }
      }
      
      public static void parse(String inFile, boolean variables, boolean comment, boolean print) {
         String output = "";
         char next;
         int temp = -1;
         boolean nextRead;
         FileReader reader;
         FileWriter writer;
         
         try {
            reader = new FileReader(inFile);
            do {
               nextRead = true;
               if (temp != -1) {
                  next = (char) temp;
                  switch (next) {
                     case '"':
                        output += "\\\"";
                        break;
                     case '\\':
                        output += "\\\\";
                        break;
                     case '\'':
                        output += "\\\'";
                        break;
                     case '\r':
                        output += "\\r";
                        break;
                     case '\n':
                        output += "\"\n+ \"\\n";
                        break;
                     case '\t':
                        output += "\\t";
                        break;
                     case '#': //variable found (if variables)
                        if (variables) {
                           if (comment) output += "\"/* + ";
                           else output += "\" + ";
                           temp = reader.read();
                           next = (char) temp;
                        	//read until non-variable character found
                           while (!(temp == -1
                           || next == ' '
                           || next == '\r'
                           || next == '\n'
                           || next == '\t'
                           || next == '\''
                           || next == '/'
                           || next == '\\'
                           || next == '!'
                           || next == '?'
                           || next == '.'
                           || next == ',')) {
                              output += next;
                              temp = reader.read();
                              next = (char) temp;
                           }
                           if (comment) output += "*/ + \"";
                           else output += " + \"";
                           nextRead = false;
                        } 
                        else output += "#";
                        break;
                     default:
                        output += next;
                  }
               }
               if (nextRead) temp = reader.read();
            } while (temp != -1);
            
            output += "\"";
            output = "\"" + output;
            
            reader.close();
         	//output in input directory
            writer = new FileWriter(inFile.substring(0, inFile.lastIndexOf('\\')) + "\\StringFormatter.out");
            writer.write(output, 0, output.length());
            writer.close();
         
            if (print) System.out.println(output);
         } 
            catch (IOException e) {
               System.out.println("File Error");
            }
      }
   }