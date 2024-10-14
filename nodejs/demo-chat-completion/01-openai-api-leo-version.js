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

// Define the handle closing of the readline interface
rl.on('close', () => {
    console.log('Exiting the program...');
    process.exit(0);
});


const messages = [{"role": "system", "content": "You are a helpful assistant."}];

async function sendChat(){
    const completion = await openai.chat.completions.create({
        messages: messages,
        model: "gpt-4o-mini"
    });
    console.log(`choices...`);
    console.log( completion.choices[0]);
    
}


// Function to ask for input continuously
async function askQuestion() {
    rl.question('Enter your prompt or type exit to quit: ', async (userMessage) => {
        if (userMessage.toLowerCase() === 'exit') {
            console.log('Goodbye!');
            console.table(messages);
            rl.close();
        } else {
            const userPrompt ={
                "role": "user",
                "content": userMessage
            }

            messages.push(userPrompt);

            await sendChat();
            askQuestion(); // Continue asking for input
        }
    });
}

// Start the question loop
askQuestion();







