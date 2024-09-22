# ChatGPT Recipes: Generative AI for Software Developers


## Section 1.  Basics of AI-Assisted Software Development

- Writing Code with ChatGPT
- Creating Basic Programs with GenAI
- Other AI Software Development 
- Possibilities
- Demo


### Prompt Sample 01
```text
Write me a JavaScript function that calculates descriptive statistics for an array of numbers
```

```text
Rewrite that function so that it returns the mean, median, etc as an array
```

### Prompt Sample 02
```text
Write me JavaScript functions for calculating the mean, media, mode, standard deviation and variance of an array of numbers
```

```text
Now write a function that uses all the above functions to put together a descriptive statistics object for an array of numbers
```

### Prompt Sample 03
```text
Write ma a Node.js script that will scrape the titles, upvotes, and article links from Hacker News. Here is a sample of th HTML from the site:

"""
   <tr class="spacer" style="height:5px"></tr>
                            <tr class='athing' id='41346530'>
                                <td align="right" valign="top" class="title">
                                    <span class="rank">5.</span>
                                </td>
                                <td valign="top" class="votelinks">
                                    <center>
                                        <a id='up_41346530' href='vote?id=41346530&amp;how=up&amp;goto=news'>
                                            <div class='votearrow' title='upvote'></div>
                                        </a>
                                    </center>
                                </td>
                                <td class="title">
                                    <span class="titleline">
                                        <a href="https://wyclif.substack.com/p/parochialism-in-time-and-space">Parochialism in time and space (2021)</a>
                                        <span class="sitebit comhead">
                                            (
                                            <a href="from?site=wyclif.substack.com">
                                                <span class="sitestr">wyclif.substack.com</span>
                                            </a>
                                            )
                                        </span>
                                    </span>
                                </td>
                            </tr>
"""

```


### Promt sample 04
```text
I would like to try a complex  query that join query wich should pull codes util no more new codes
```

```text
Now do it in Apex SOQL
```

### Prompt Sample 05
```text
Give a basic high-level architectural outline for an e-commerce site
```




## Section 2. Using AI for Content Creation

- Using AI for Text Generation
- Integrating AI-Generated Text with Software
- Going from AI-Generated Text to Real-Time Conversation


### Prompt Sample 01
```text
Rewrite this article in a more casual tone : https://siliconfolklore.com/internet-history/
```

```text
Now rewrite it in a very formal tone
```

```text
Now rewrite the original article in Spanish
```

```text
now summarize the main points of the article as an array of JSON Objects, with "point", "reference"
and "keywords" properties
```

---

## Section 3.  AI Image generation

- Overview of Image Generation Tools
- Creating Visual Elements with GenAI
- Generating Images in Real-Time
- Demo


### Prompt Sample 01

```text
Draw a scene where character in a spacesuit is standing in a cave . There is a fork in the tunnel,
with one side dark of the fork going up, and the other side going down
```

```text
Now draw a family in the kitchen, using chatgpt to make a meal
```

```text
Draw me a cheat sheet covering the basics of scraping with python
```

```text
Draw me a cheat sheet covering the basics of enterprice architecture
```

```text
Draw me a cheat sheet covering the basics of cloud architecture
```

### Prompt Sample 02
```text
Draw me a character for my video game. The character is a 30-year old male with brown hair and a beard who always wears bright yellow t-shirts.
He also carries a giant coffee thermos with him wherever he goes
```

```text
redraw as an anime character
```

```text
Redraw as a 3D disney character 
```

```text
redraw in the style of a children's book
```

---


## Section 4: Bringing It All Together

- Fine-Tuning Logic, Text, and Images
- Balancing AI-Generated Content with User Interaction
- Finalizing and Testing


### Step 01: Work in nodejs project
```bash
npm init -y
npm install dotenv
npm install openai

touch openai-api-demo.js

```

### Stept 02: Create program in first version
```javascript
require('dotenv').config()
const OpenAI = require('openai');

const openai = new OpenAI();
const messages = [{
    role: 'user',
    content: 'Write me a short story about a space explorer'
}];

async function main(){
    const completion = await openai.chat.completions.create({
        messages: messages,
        model: "gpt-4o-mini"
    });
    console.log(`choices...`);
    console.log( completion.choices[0]);

    
}

try {
    main();    
} catch (error) {
   console.error(error); 
}

```

### Step 03: Run the program
```bash
node openai-api-demo.js
```

### Step 04: Ask for a prompt to complete the program
```text
Write me a console-based  program in Node.js that continously gets input from the user iusing the readline package
```

### Step 05: Install required dependencies
```bash
npm install readline
```

### Step 06: Code given by ChatGPT
```javascript
const readline = require('readline');

// Create an interface for reading data from the console
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Function to ask for input continuously
function askQuestion() {
    rl.question('Enter something (type "exit" to quit): ', (answer) => {
        if (answer.toLowerCase() === 'exit') {
            console.log('Goodbye!');
            rl.close();
        } else {
            console.log(`You entered: ${answer}`);
            askQuestion(); // Continue asking for input
        }
    });
}

// Start the question loop
askQuestion();

// Handle closing of the readline interface
rl.on('close', () => {
    console.log('Exiting the program...');
    process.exit(0);
});

```

### Step 07 : Create a little client to send prompts to chatgpt (Version 1)
```javascript
require('dotenv').config()
const OpenAI = require('openai');
const readline = require('readline');


//Create an instance of the OpenAI class
const openai = new OpenAI();

// Create an interface for reading data from the console
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


const messages = [];

console.log('Please enter an initial prompt: ');

rl.on('line', async(input) => {
    messages.push({
        "role": "user",
        "content": input
    });

    const completion = await openai.chat.completions.create({
        messages: messages,
        model: "gpt-4o-mini"
    });

    const newMessage = completion.choices[0].message.content;
    console.log(newMessage);

    messages.push({
        "role": "assistant",
        "content": newMessage
    });

});


// Define the handle closing of the readline interface
rl.on('close', () => {
    process.exit(0);
});

```

### Step 08 : Add assistant initialization (Version 2)
```javascript
require('dotenv').config()
const OpenAI = require('openai');
const readline = require('readline');


//Create an instance of the OpenAI class
const openai = new OpenAI();

// Create an interface for reading data from the console
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});



//const contentOfSystem = "You are a helpful assistant that helps users with their questions.";
//const contentOfSystem = "Type all in caps";
const systemDefinition = "You are a helpful chatbot, you help peopole get where they need to go on our website, here are the pages:" +
    "1. The products page - this is where all the products can be found" +
    "2. The forum - this is where customers can discussd different products" + 
    "3. Customer service - this is where you can get in touch with an agent" +   
    "Therse are the oly pages. Your only task is to ask customers questions to get the to the right place. Refuse to do anything else.";

const initialAssistantMessage = "Hi!, Welcome to the site. I\'m here to help you find the right page. Tell me what brings you here today.";

const messages = [{
    "role": "system",
    content: systemDefinition
}, {
    role: "assistant",
    content: initialAssistantMessage
}
];

console.log(initialAssistantMessage);

rl.on('line', async(input) => {
    messages.push({
        "role": "user",
        "content": input
    });

    const completion = await openai.chat.completions.create({
        messages: messages,
        model: "gpt-4o-mini"
    });

    const newMessage = completion.choices[0].message.content;
    console.log(newMessage);

    messages.push({
        "role": "assistant",
        "content": newMessage
    });

});


// Define the handle closing of the readline interface
rl.on('close', () => {
    process.exit(0);
});


```

## Final Game

### Step 01: Prompt to put in ChatGPT and the original/basic code
```text

Expand this JSON array to add more scenarios for a "choose-your-own-adventure" game:
### this is the code
```
const scenarios = [{
    id: 'doors',
    introduction: 'You are standing in fronto of 2 doors, one is red , one is blue',
    choices: [
        {
            text: 'Opens the red door',
            gotTo: 'red-door'
        },
        {
            text: 'Opens the blue door',
            goTo: 'blue-door'
        },
    ]
}, {
    id: 'red-door',
    introduction: '...',
    choices: [
        // more choices listed here
    ]

}, {
    id: 'blue-door',
    introduction: '...',
    choices: [
        // more choices listed here
    ]
}];

```
### end the code

```

### Step 02: Prompt
```text
Write me a Node.js program that will act as a console-based "choose your own adventure". The scenarios for the game will come ina an array that looks like this:

### this is the code
```
const scenarios = [{
    id: 'doors',
    introduction: 'You are standing in fronto of 2 doors, one is red , one is blue',
    choices: [
        {
            text: 'Opens the red door',
            gotTo: 'red-door'
        },
        {
            text: 'Opens the blue door',
            goTo: 'blue-door'
        },
    ]
}, {
    id: 'red-door',
    introduction: '...',
    choices: [
        // more choices listed here
    ]

}, {
    id: 'blue-door',
    introduction: '...',
    choices: [
        // more choices listed here
    ]
}];

```
### end the code

```


### step 03: upload the file 11-scenarios by chatgpt 01 js and add the prompt
```text
This file contains a series of connected scenarios for a choose-your-own-advengure game. SOme of the coices don't have a corresponding scenario, expanda the array by adding additional choices that end in death or finding treasure and winning
```


### testing with audio. Paste and send the prompt. Listend with the audio button
```text
Write me a story in 100 words or less
```


---

## Resources
- [ChatGPT Recipes: Generative AI for Software Developers](https://learning.oreilly.com/live-events/chatgpt-recipes-generative-ai-for-software-developers/0642572003714/0642572006629/)
- [PDF Slides](https://on24static.akamaized.net/event/45/91/89/1/rt/1/documents/resourceList1722347008369/chatgptkitchen1722347008369.pdf)
- [Shaun Wassell](https://learning.oreilly.com/search/?q=shaun%20wassell&type=live-event-series&rows=100&language_with_transcripts=en)
- [Hacker News](https://news.ycombinator.com/)
- [OpenAI API Moderation](https://platform.openai.com/docs/guides/moderation/overview)
- [TTSMP3.com](https://ttsmp3.com)
- []()
- []()
- []()
