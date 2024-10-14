# Integrating AI in Java Projects


### 
```text
Please give a set of Java records that corresponds to this JSON Structure 
```

### JSON Sample for the prompt
```json
 {
  "object": "list",
  "data": [
    {
      "id": "gpt-4-turbo",
      "object": "model",
      "created": 1712361441,
      "owned_by": "system"
    },
    {
      "id": "gpt-4-turbo-2024-04-09",
      "object": "model",
      "created": 1712601677,
      "owned_by": "system"
    },
    {
      "id": "tts-1",
      "object": "model",
      "created": 1681940951,
      "owned_by": "openai-internal"
    },
    {
      "id": "tts-1-1106",
      "object": "model",
      "created": 1699053241,
      "owned_by": "system"
    },
    {
      "id": "chatgpt-4o-latest",
      "object": "model",
      "created": 1723515131,
      "owned_by": "system"
    },
    {
      "id": "dall-e-2",
      "object": "model",
      "created": 1698798177,
      "owned_by": "system"
    },
    {
      "id": "gpt-4-turbo-preview",
      "object": "model",
      "created": 1706037777,
      "owned_by": "system"
    },
    {
      "id": "gpt-4o-2024-08-06",
      "object": "model",
      "created": 1722814719,
      "owned_by": "system"
    },
    {
      "id": "gpt-3.5-turbo-instruct",
      "object": "model",
      "created": 1692901427,
      "owned_by": "system"
    },
    {
      "id": "gpt-4o",
      "object": "model",
      "created": 1715367049,
      "owned_by": "system"
    },
    {
      "id": "gpt-4-0125-preview",
      "object": "model",
      "created": 1706037612,
      "owned_by": "system"
    },
    {
      "id": "gpt-3.5-turbo-0125",
      "object": "model",
      "created": 1706048358,
      "owned_by": "system"
    },
    {
      "id": "gpt-3.5-turbo",
      "object": "model",
      "created": 1677610602,
      "owned_by": "openai"
    },
    {
      "id": "babbage-002",
      "object": "model",
      "created": 1692634615,
      "owned_by": "system"
    },
    {
      "id": "davinci-002",
      "object": "model",
      "created": 1692634301,
      "owned_by": "system"
    },
    {
      "id": "gpt-4o-realtime-preview-2024-10-01",
      "object": "model",
      "created": 1727131766,
      "owned_by": "system"
    },
    {
      "id": "dall-e-3",
      "object": "model",
      "created": 1698785189,
      "owned_by": "system"
    },
    {
      "id": "gpt-4o-realtime-preview",
      "object": "model",
      "created": 1727659998,
      "owned_by": "system"
    },
    {
      "id": "tts-1-hd",
      "object": "model",
      "created": 1699046015,
      "owned_by": "system"
    },
    {
      "id": "tts-1-hd-1106",
      "object": "model",
      "created": 1699053533,
      "owned_by": "system"
    },
    {
      "id": "gpt-4-1106-preview",
      "object": "model",
      "created": 1698957206,
      "owned_by": "system"
    },
    {
      "id": "text-embedding-ada-002",
      "object": "model",
      "created": 1671217299,
      "owned_by": "openai-internal"
    },
    {
      "id": "gpt-3.5-turbo-16k",
      "object": "model",
      "created": 1683758102,
      "owned_by": "openai-internal"
    },
    {
      "id": "text-embedding-3-small",
      "object": "model",
      "created": 1705948997,
      "owned_by": "system"
    },
    {
      "id": "text-embedding-3-large",
      "object": "model",
      "created": 1705953180,
      "owned_by": "system"
    },
    {
      "id": "whisper-1",
      "object": "model",
      "created": 1677532384,
      "owned_by": "openai-internal"
    },
    {
      "id": "gpt-3.5-turbo-1106",
      "object": "model",
      "created": 1698959748,
      "owned_by": "system"
    },
    {
      "id": "gpt-4-0613",
      "object": "model",
      "created": 1686588896,
      "owned_by": "openai"
    },
    {
      "id": "gpt-4",
      "object": "model",
      "created": 1687882411,
      "owned_by": "openai"
    },
    {
      "id": "gpt-3.5-turbo-instruct-0914",
      "object": "model",
      "created": 1694122472,
      "owned_by": "system"
    },
    {
      "id": "gpt-4o-mini",
      "object": "model",
      "created": 1721172741,
      "owned_by": "system"
    },
    {
      "id": "gpt-4o-2024-05-13",
      "object": "model",
      "created": 1715368132,
      "owned_by": "system"
    },
    {
      "id": "gpt-4o-mini-2024-07-18",
      "object": "model",
      "created": 1721172717,
      "owned_by": "system"
    }
  ]
}
```


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


### ..





- [Integrating AI in Java Projects](https://learning.oreilly.com/live-events/integrating-ai-in-java-projects/0642572001330/)
- [PDF Slides](https://on24static.akamaized.net/event/46/36/71/1/rt/1/documents/resourceList1723822613461/integratingaiinjavaprojects1723822613461.pdf)
- [Ken Kousen GitHub](https://github.com/kousen)
- [Ken Kousen openai Demos](https://github.com/kousen/openaidemo)
- [Ken Kousen AI Java Labs](https://github.com/kousen/AiJavaLabs)
- [OpenAI](https://platform.openai.com/)
- [Tokenizer](https://platform.openai.com/tokenizer)
- [Ollama](https://ollama.com/)
- [LangChain4j](https://docs.langchain4j.dev/)
- [Langchain4j Examples on GitHub](https://github.com/langchain4j/langchain4j-examples)
