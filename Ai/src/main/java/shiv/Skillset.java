package shiv;

import java.util.Arrays;
import java.util.List;

public enum Skillset {
    JAVA("Java", "Object-Oriented Programming", "Spring Framework"),
    PYTHON("Python", "Data Science", "Machine Learning"),
    JAVASCRIPT("JavaScript", "Web Development", "Node.js");

    private String language;
    private List<String> topics;

    Skillset(String language, String... topics) {
        this.language = language;
        this.topics = Arrays.asList(topics);
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getTopics() {
        return topics;
    }
}