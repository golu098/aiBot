package shiv;

import com.azure.ai.openai.OpenAIClient;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.ai.openai.OpenAIClientBuilder;

import com.azure.ai.openai.models.*;

import java.util.ArrayList;
import java.util.List;

public class ContentGenerator {

    private static final String ENDPOINT = "https://ai-proxy.lab.epam.com";
    private static final String API_KEY = "92a0ee28127347cfbb3e2b5d828bed12";

    public static String generateContent(String prompt) {
        String deploymentOrModelId = "{azure-open-ai-deployment-model-id}";

        OpenAIClient client = new OpenAIClientBuilder()
                .endpoint(ENDPOINT)
                .credential(new AzureKeyCredential(API_KEY))
                .buildClient();

        List<String> prompt1 = new ArrayList<>();
        prompt1.add("Why did the eagles not carry Frodo Baggins to Mordor?");

        Completions completions = client.getCompletions(deploymentOrModelId, new CompletionsOptions(prompt1));

        System.out.printf("Model ID=%s is created at %s.%n", completions.getId(), completions.getCreatedAt());
        for (Choice choice : completions.getChoices()) {
            System.out.printf("Index: %d, Text: %s.%n", choice.getIndex(), choice.getText());
        }

        CompletionsUsage usage = completions.getUsage();

        return String.format("Usage: number of prompt token is %d, "
                        + "number of completion token is %d, and number of total tokens in request and response is %d.%n",
                usage.getPromptTokens(), usage.getCompletionTokens(), usage.getTotalTokens());
    }

}