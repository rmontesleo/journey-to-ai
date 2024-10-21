require('dotenv').config()
const OpenAI = require('openai');

const openai = new OpenAI();
const openAIModel = "gpt-4o-mini";

const messages = [{
    role: 'system',
    content: 'You are a helpful assistant that helps users with their questions.'
}];

async function getOpenAIChatResponse( prompt ) {
    messages.push({
        role: 'user',
        content: prompt
    });
  

    try {
        const completion = await openai.chat.completions.create({
            messages: messages,
            model: openAIModel
        });
        
        return completion.choices[0].message.content;    
    } catch (error) {
        console.error(error);
    }        
}

function getMessages() {
    return messages;
}


module.exports = {
    getOpenAIChatResponse,
    getMessages
};

