# Scrap-a-zon
## Author: Tarek El-Hajjaoui

## Description of Program
### Background on the site choice
- A Webscraper for https://books.toscrape.com, a book e-commerce website that is intended for users to webscrape from. 
Originally I wanted to webscrape Amazon.com, but Amazon is very difficult to webscrape because each search result can give very different html pages and
Amazon purposely designs their frontend to make it difficult their website. Using https://books.toscrape.com is also better because it is a stable website and
so this project can serve to be a portfolio project for a longer time than an actual company e-commerce site.
### What the program does
- Upon opening the application, the user is presented with menu items and a search bar with a submit button. The user can search any of the tags (menu item options)
in the search bar which will invokes the WebScraper to scrape the book items of the user inputted category from https://books.toscrape.com. The results are presented
in a csv (comma separated value) format. The columns are: book title, book price, and availability. Each category's results can be verified by visiting and looking
through https://books.toscrape.com. After the results for a category appears, a save button appears to the left of the results. If clicked, the results are written
in a csv file called "output.csv" within the same directory; the absolute path is shown to the user for thoroughness. The user can then search for another category.
### Edge cases and error handling
- If the Webscraper is not able to connect to https://books.toscrape.com, an error message appears on the frontend and console.
- If the user inputted category is invalid, an error message appears on the frontend and console.
- If the user adds extra or missing spaces, has different capitalizations, but still spells the category correctly, the results of the category shall still appear. 

## Pre-requisites
### Before running the program:
1. Have Java version 8 installed on computer.
2. Have Apache Ant(TM) version 1.10.11 or above installed on computer.
3. Have Netbeans 12.4 or above installed

# Important
## Instructions to run the program (if using .jar file)
**In order for Jsoup to work from the .jar file, must follow these instructions.**
1. Using the command line, navigate to the root directory of Scrap-A-zon.
2. cd (change directory) into the dist folder:
```
cd dist
```
3. To execute this command to start the application:
```
java -jar Scrap-a-zon.jar
``` 
4. Use the program.

## Instructions to run the program (if downloading src code from GitHub):
1. Open the project with Netbeans.
2. Click on the play button.
3. Use the program.

## Source Files (under *src* directory):
### Controller directory
- AppController.java
- Test.java
- WebScraper.java
### Model directory
- FileHelper.java
- GridMatrix.java
- Helper.java
- Product.java
- UserInput.java

## Sources referred to:
- JavaFx documentation: https://docs.oracle.com/javase/8/javafx/api/toc.htm
- JavaFx & FXML tutorial: https://www.youtube.com/watch?v=9XJicRt_FaI
- Jsoup documentation: https://jsoup.org/apidocs/
- Java create, write to, and delete file: https://www.w3schools.com/java/java_files_create.asp
- Java ArrayList: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html