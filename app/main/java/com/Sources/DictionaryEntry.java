package com.example.bahar.ivt.Activities.Sources;

/**
 * Created by Bahar on 6/16/2018.
 */
public class DictionaryEntry {
    private String word, pronunciation, definition, synonym, example, meaning, codingWord, codingExample, correct;
    private int lessonNumber;
    private int gif;
    private TestEntry testEntry;


    public DictionaryEntry(int lessonNumber, String word, String pronunciation, String definition, String synonym, String example, String meaning, String codingWord, String codingExample, int gif, TestEntry testEntry, String correct) {
        this.lessonNumber = lessonNumber;
        this.word = word;
        this.pronunciation = pronunciation;
        this.definition = definition;
        this.synonym = synonym;
        this.example = example;
        this.meaning = meaning;
        this.codingWord = codingWord;
        this.codingExample = codingExample;
        this.gif = gif;
        this.testEntry = testEntry;
        this.correct = correct;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public TestEntry getTestEntry() {
        return testEntry;
    }

    public void setTestEntry(TestEntry testEntry) {
        this.testEntry = testEntry;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getCodingWord() {
        return codingWord;
    }

    public void setCodingWord(String codingWord) {
        this.codingWord = codingWord;
    }

    public String getCodingExample() {
        return codingExample;
    }

    public void setCodingExample(String codingExample) {
        this.codingExample = codingExample;
    }

    public int getGif() {
        return gif;
    }

    public void setGif(int gif) {
        this.gif = gif;
    }
}
