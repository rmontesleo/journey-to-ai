# Integrating AI in Java Projects


## Using  API to get information from OpenAI

### Using speech 
```bash
curl  https://api.openai.com/v1/audio/speech \
-H "Authorization: Bearer $OPENAI_API_KEY" \
-H "Content-Type: application/json" \
-d '{\n    "model": "tts-1",\n    "input": "The quick brown fox jumped over the lazy dog.",\n    "voice": "alloy"\n  }' \
--output speech.mp3
```

### Getting models
```bash
curl https://api.openai.com/v1/models \
-H "Authorization: Bearer $OPENAI_API_KEY" | jq
```


## Using Chats to get information

### Ask this to ChatGPT and Claude  
```text
Please give a set of Java records that corresponds to this JSON Structure 
```

### JSON Sample for the prompt
Go to 01_sample_data_for_prompt.json

### From ChatGPT
```java
import java.util.List;

public record ModelData(String id, String object, long created, String owned_by) {}

public record ModelList(String object, List<ModelData> data) {}

```

### From Claude Antropic
```java
public record ModelList(String object, List<Model> data) {}

public record Model(String id, String object, long created, String ownedBy) {}

// Usage example
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Model model1 = new Model("gpt-4-turbo", "model", 1712361441L, "system");
        Model model2 = new Model("gpt-4-turbo-2024-04-09", "model", 1712601677L, "system");
        // ... other models ...

        List<Model> modelList = List.of(model1, model2 /* , ... other models ... */);
        ModelList fullList = new ModelList("list", modelList);

        // Access data
        System.out.println("Object type: " + fullList.object());
        System.out.println("First model ID: " + fullList.data().get(0).id());
    }
}
```





## Using de Playground in OpenAI

### Define for System
```text
You are an expert travel agent.
```

### First message
```text
I have a day off comming soon. Please suggest some good activities in th Hartford, CT, area for a day trip.
```

### Second message, press add and then run..
```text
That's good. I want something within 15 minutes of Marlborough, CT
```

### See the json sample for sandbox.  You can see the json in
- 02_sandbox_sample_conversation.json
- 03_curl_sandbox_conversation.sh


## Ollama

### Install Ollama on Linux
```bash

# install
curl -fsSL https://ollama.com/install.sh | sh

# list your local models
ollama list

# run llama3.1
ollama run llama3.1

```

### running ollama 3.1
```text

# you see a new prompt you can ask

>>> Who won the last Super Bowl?

>>> Tell me about the transformer model for GPT as if I was a 5 year old

>>> /bye

```

### checking the API
```bash
curl http://localhost:11434/api/generate -d '{
  "model": "llama3.2",
  "prompt":"Why is the sky blue?"
}'
```



---

## References
- [Integrating AI in Java Projects](https://learning.oreilly.com/live-events/integrating-ai-in-java-projects/0642572001330/)
- [PDF Slides](https://on24static.akamaized.net/event/46/36/71/1/rt/1/documents/resourceList1723822613461/integratingaiinjavaprojects1723822613461.pdf)
- [Ken Kousen GitHub](https://github.com/kousen)
- [Ken Kousen openai Demos](https://github.com/kousen/openaidemo)
- [Ken Kousen AI Java Labs](https://github.com/kousen/AiJavaLabs)

- [OpenAI](https://platform.openai.com/)
- [Tokenizer](https://platform.openai.com/tokenizer)

- [LangChain4j](https://docs.langchain4j.dev/)
- [Langchain4j Examples on GitHub](https://github.com/langchain4j/langchain4j-examples)
- [Langchain4j Language Models](https://docs.langchain4j.dev/category/language-models)

- [Ollama](https://ollama.com/)
- [GitHub Ollama](https://github.com/ollama/ollama)