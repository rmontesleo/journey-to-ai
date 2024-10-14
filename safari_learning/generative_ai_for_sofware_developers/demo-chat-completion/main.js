const {getOpenAIChatResponse, getMessages} = require('./openai-api-client.js');
const readLine = require('./openai-api-read-client.js').rl;


// Function to ask for input continuously
async function execute() {
    readLine.question('Enter your prompt or type exit to quit: ', async (prompt) => {
        if (prompt.toLowerCase() === 'exit') {
            console.log('Hasta la vista Baby!');
            console.table( getMessages() );
            readLine.close();
        } else {
            const response = await getOpenAIChatResponse(prompt);
            console.log(`## response: ${response}`);
            execute(); // Continue asking for input
        }
    });
}

execute();