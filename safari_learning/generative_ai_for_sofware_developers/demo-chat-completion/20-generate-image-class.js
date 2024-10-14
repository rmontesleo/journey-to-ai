require('dotenv').config();
const OpenAI = require('openai');
const openai = new OpenAI();
const scenarios = require('./11-scenarios-by-chatgpt-01');

// prompt:Draw me for this scenario: The characer is wearing a space suit and looking at the following scene 

async function start() {

    console.log(scenarios[0].introduction );

    for ( let index=0; index <=3; index++ ) {
        const scenario = scenarios[index];
        const prompt = `Draw me for this scenario: ${scenario.introduction}`;
        //console.log( prompt );
        const response = await openai.images.generate({
            model: "dall-e-3",
            prompt,
            n: 1,
            size: "1024x1024",
        });
        image_url = response.data[0].url;
        console.log(`\n image_url ${image_url}`);
    }
}

start();

