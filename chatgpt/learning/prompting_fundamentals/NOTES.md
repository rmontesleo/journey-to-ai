# ChatGPT Prompting Fundamentals: Crafting Engaging and Productive ChatGPT Prompts

## Social Network
@tamsininnit
- Instagram
- pinteres
- instagram
- twitter

## Course Introduction


## Module 1: ChatGPT Basics

- GPT: Generative Pre-Trained Transformer

- Generative: It generates text based on an instruction/prompt.  Produces coherent and contextually relevant text based on the input (prompt).

- Pre-Trainied: It has been pre-trained on facts & Information and world events. Using a large datassest of text (such as books, articles, websites, and other writter material) to learn the patterns, structures, and nuances fo human languages.

    - Books: Fiction an non-fictions
    - Websites: Wikipedia, Reddit, Stack Overflow, Goverment websites, blogs, corporations and many more.
    - News & Press: News agency archives 
    - Scientific Journals: Published journals in varios scientific fields


- Transformer: It can process sequential data and information - it has statistical understanding of language. It can understand how different parts of a sentece or paragraph are related, event if they are far apart in the text.

    - Tokens: GPT breaks down language into 'tokens' to analyse words and phrases.
    - Relational: Processes words in relational to all other words in a sentence, rather than one-by-one in sequence.
    - Predicion: Predicts the next 'token' based on the context of the 'tokens' it has seen before.
    - Context awarness: Understand the meaning behind text by considering the context in which words appear.
    - Token Word
    - Token ID (numeric)

- Tokens & Probability
    - alligator: (all, igator) - [586, 98956]
    - fine and good: [107932, 326, 1899]
    - good and fine: [30744, 326, 8975]


- What is ChatGPT being used for?
    - Sales and marketing
    - Writting emails
    - Job description and applications
    - Video scripts
    - Educational resources.
    - Generating & troubleshooting <code>
    - (Yes, ChatGPT can write programming code as well as words)
    - Proofreading, editing and improving existing text
    - Problem solving
    - Finding creative solutions to complex and multi-facedted problems
    - Creative writing, storytelling
    - Writing proudct reviews
    - Letters of compliant
    - Answering questions
    - & more

- Interacting with ChatGPT
    Interacting with ChatGPT is a mixture of:
        - Instructing
        - Teaching
        - Programming
    "Programming with words" AKA "Prompting"


### Prompt 01:
```text
Teach me something new
```

### Same Prompt 01 - next request:
```text
Explain that again in one sentece that a 5 year old would understand
```

### Same Prompt 01 - next request: ELI5 (Explain like I'm 5)
```text
ELI5 in 1 sentence
```

### Same Prompt 01 - next request or edit the prompt
```text
Tell me a joke
```

### Same Prompt 01 - next request or edit the prompt, but more specific
```text
Tell me a joke about cats
```

### ChatGPT can remember

- ChatGPT can remember 4096 tokens (for ChatGPT 3.5 free versions) worth of conversation
- It can reference parts of the converstion without you having to repeat them.
- It can only reference parts of your current chat and cannot reference things across multiple chats.

### Quick recapt - ChatGPT & Tokens
- ChatGPT processes words as tokens
- Depending on wich model you use, there is a token limit wich forms ChatGPT's conversational memory (4096 tokens for  3.5)
- Prompts can be chained together, instead send a MegaPrompt
- The numbers of tokens used is shared between the prompot and the response.
- Tokens are also used for billing purposes when using the API


---
## Module 2: Prompt Engineering

### Prompting Fundamentals

- `Prompting Engineering`: Trying to improve the interaction between humans and AI
- `The basics of prompting`: Simply chat in a conversational tone, in the same way you would chat with a friend, colleague or personal assistant.
- Garbage IN = Garbage OUT
- ChatGPT Prompt Formula
    1. `Context`: You are an experiences content writer with hight levels of expertise and authority within the tech Industry.
    2. `Task`: Your job is to write content that will be publishs online on websites, social media, email newsletters and advertisements. Your writing style is informative, friendly and engaging while incorpoating humour and real-life-examples.
    3. `Instruction`: I will provide you wih a topic or series of topics and you will come up with an engaging article outline for this topic.
    4. `Clarify`: Do you understand?
    5. `Refine`: Rewrite using more natural, expressive language and include some examples to accompany this information.

- Difference between prompting vs Asking
    - Ask: What is the significance of the renaissance?
    - Prompt: Imagine that you're a historian who is describing the significance of the renaissance.

- It's all about context
    ```text
    Act as an expert dog trainer and behavioral expert who has workd with thousands of puppies, dogs and their owners/handlers to treat obedience issues to help dogs have a joyful, rewarding and happy life with their owners. You will be answering questions from dog owners with concerns about thier pet's behavior, so answer is a sympathetic and undertanding manner.
    ```

- No context.
    ```text
    Write some Python to filter data from a table.
    ```

- With context.
    ```text
    Using python, I need to filter data from an e-commerce website. The data is in the form of a tables and it contains information about orders placed on the website during the past 3 months, we need to identify with 2 (or more) items are most frequently purchased together. That will help us inform our marketing efforts and make improvements to the website.
    ```
- Give ChatGPT a quality criteria.
    ```text
    Here is the criteria:
    1. The content should provide original information, reporting, research or anlysis.
    2. The content should provide a substantial, complete, or comprehensive description of the topic.
    3. The content should provide insightful analysis or intersting information that is beyon the obvious.
    4.
    5.
    6.
    7.
    8.
    9.
    10. The content should be people-first, created primarialy for people and not to manipulate search engine rankings, and demostrate expertise and depth of knowledge while providing a stisfiyin experience for the reader.
    ```

- Contextual Priming could be:
    - Providing ChatGPT with context.
    - Giving a "perfect answer" as an example for ChatGPT
    - Role prompting ("act as an expert..")
    - Explaining a multi-faceted problem.
    - It's asking ChatGPT to role play!


- Feeding ChatGPT information
ChatGPT doesn't know everything that you're working on, you often mus feed inromation for it to reference.
- Write something using `our brand voice guidelines`
- Write a description of our latest product  prior to its release
- Help me to write teh next part of my fictioal story"
- "Use our blog post template to write a blog post about..."

If you're often using the same contextual and reference prompts for ChatGPT, it's useful to save these somewhere a ti saves time having to type repetitive prompts


- Avoiding repetition and "boring" responses
    - ChatGPT resposnes can sometime feel like reading from textbook.
    - Its generic responses are quite plain an straightforward.
    - It si simple to ask ChatGPT to writing styles to suit your needs.

- Tell ChatGPT what you don't want
    Please do not include the following words and phrases in your response:
        delving, unvoring, additionally, lets dive in,
        crucial, meticulous, meticulously, navigating, complexities,
        relm, bespoke, ever-changing, ever-evolving, in today's landscape, imagin this,
        picture this, daunting, merely, robust, unveil, it's about, it's all about, navigating, 
        towards, therefore or moreover.

- Adapt the writing style for the audience.
[ Your writing style is fantastical, creating an imaginary world with supernatural elements, while incorporating imaginative and creative language]

[Your writing style is humorous, using satire, irony, and puns to make the reader laugh, while incorporating pop culure references and wit]

[Your writing style is persuasive, using logical arguments and statistics to make a case, while incorporating clear and concise language and minimal humour.]

[Your writing style is lyrical, using rhythm, rhyme, and musical elements to convey emotions, while incorporating metaphors and symbols]

[Your writing style is experimental, pushing the boundaries of traditional writing conventions, while incorporating unconventional structure and language.]

[Your writing style is in the style of a journalist for the satirical website "The Daily Mash" using sarcasm and relatable humorous analogies where possible.]

---
## Module 3: hatGPT and

---
## Module 4: Accuracy, Safety, and Ethical Considerations

---
## Module 5: Building Your Own Prompt Library


---
## Module 6: Advanced and Future Uses of ChatGPT






## REFERENCES
- [ChatGPT Prompting Fundamentals: Crafting Engaging and Productive ChatGPT Prompts](https://learning.oreilly.com/course/chatgpt-prompting-fundamentals/0642572078898/)
- [OpenAI Tokenizer](https://platform.openai.com/tokenizer)
- [Awesome ChatGPT Prompts](https://prompts.chat/)
