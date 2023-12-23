 # Demo 
 [https://drive.google.com/file/d/12XgNckAUb-ImO3NyalD4AJOGAMLCpsOl/view?usp=sharing](https://drive.google.com/file/d/12XgNckAUb-ImO3NyalD4AJOGAMLCpsOl/view?usp=sharing)

# 

![Screenshot 2023-12-21 092726](https://github.com/NorhanTarek1572/Word_Statistics-/assets/107472972/bfa8ef78-c645-4448-b704-749889886911)
![Screenshot 2023-12-21 092804](https://github.com/NorhanTarek1572/Word_Statistics-/assets/107472972/0367f7c2-6450-4fb2-9f77-78f42f8f17bb)
![Screenshot 2023-12-21 092823](https://github.com/NorhanTarek1572/Word_Statistics-/assets/107472972/a2678ae7-cdc0-4fbc-95b0-c44a7ef1592c)

#  Project Idea

1. It is a java program using multithreads and synchronized manner that **reads all text files form a specific directory** and r**eturn word statistics (**number of words per file/directory and number of “is”, “are” and “you” ,longest and shortest word per directory and per file) 
2. The input of the program **is a director**  It should then search for all text files that reside in that directory and should be an **option to check for text files in subdirectories**
3. While the program is processing text files, it should display them (file names) and the up to-date statistics. (Statistics should be updated in run time)
4. Using  a Java GUI toolkit like Swing or **JavaFX** to create a user interface for the program. The GUI should have the following components:
    1. A text field for entering the directory path
    2. A checkbox to enable or disable searching for text files in subdirectories
    3. A button to start the processing
    4. A text area to display the file names, up-to-date word statistics, and any progress messages
5. Create a separate thread for each text file processing task, Each thread should have a method that takes the file path as input and performs the following tasks:
    1. Read the text file contents
    2. Count the number of words
    3. Count the occurrences of "is", "are", and "you"
    4. Find the longest word
    5. Find the shortest word
6.  **Each thread should update the word statistics in a synchronized manner to prevent race conditions ,**Use a `SwingWorker` or `JavaFX` Task to update the GUI text area with the latest statistics for each file.
7. The main thread should handle **user interactions**, such as directory path input and starting the processing. It should **create and manage the worker threads, monitor their progress, and update the GUI with overall statistics for the entire directory.**
8.  **Word Statistics:**
    - Number of words per file/directory: Keep a counter for each file and a separate counter for the entire directory.
    - Number of "is", "are", and "you": Keep separate counters for each word.
    - Longest word per file: Use a variable to store the longest word for each file and update it as needed.
    - Shortest word per file: Use a variable to store the shortest word for each file and update it as needed.
    - Longest word per directory: Keep a variable to store the overall longest word and update it whenever a longer word is encountered across all files.
    - Shortest word per directory: Keep a variable to store the overall shortest word and update it whenever a shorter word is encountered across all files.
9. **Directory Scanning:** Use a **recursive approach** to scan the directory and its subdirectories (if enabled) for text files. **Use a file filter to identify files with text extensions (e.g., .txt, .doc, .docx)**.
