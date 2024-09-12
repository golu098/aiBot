package shiv;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("AI-based Tech Content Generator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JComboBox<Skillset> skillsetJComboBox = new JComboBox<>(Skillset.values());
        JTextArea textArea = new JTextArea(10, 50);
        JButton generateButton = new JButton("Generate");
        JLabel disclaimerLabel = new JLabel("<html><i>Disclaimer: The content and suggestions are AI-generated and should be verified.</i></html>");

        generateButton.addActionListener(e -> {
            Skillset selectedSkill = (Skillset) skillsetJComboBox.getSelectedItem();
            String prompt = "Explain " + selectedSkill.getLanguage() + " and suggest resources for " + selectedSkill.getTopics();
            String content = ContentGenerator.generateContent(prompt);
            textArea.setText(content);
        });

        panel.add(skillsetJComboBox);
        panel.add(generateButton);
        panel.add(new JScrollPane(textArea));
        panel.add(disclaimerLabel);
        add(panel);
    }
}