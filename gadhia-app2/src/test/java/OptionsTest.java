/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class OptionsTest {
    @Test
    void test_if_TSV_file_is_created() {
        Options options = new Options();

        File saveFiles = new File("docs/file.txt");
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("A-111-111-111", "PC", "$1550"));
        items.add(new Item("A", "b", "c"));
        options.saveFileTSV(saveFiles, items);

        // check if the file is created
        assertTrue(saveFiles.exists());

    }

    @Test
    void test_if_HTML_file_is_created() {
        Options options = new Options();

        File saveFiles = new File("docs/file.html");
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("B-12d-145-111", "Watch", "$4000"));
        options.saveFileHTML(saveFiles, items);

        assertTrue(saveFiles.exists());
    }

}