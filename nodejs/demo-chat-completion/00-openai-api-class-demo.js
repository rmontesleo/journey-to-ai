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


const openAIModel = "gpt-4o-mini";

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
        model:openAIModel
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

