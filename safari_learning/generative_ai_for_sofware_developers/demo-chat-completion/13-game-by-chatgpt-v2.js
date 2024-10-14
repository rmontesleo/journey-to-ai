const readline = require('readline');

// The scenarios for the game (from your example)
const scenarios = require('./11-scenarios-by-chatgpt-01');

// Create readline interface for user input
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Function to start the game
function startGame() {
    console.log('Welcome to the Choose Your Own Adventure game!');
    goToScenario('doors');
}

// Function to find a scenario by its ID
function findScenarioById(id) {
    return scenarios.find(scenario => scenario.id === id);
}

// Function to handle the player's choices
function handleChoice(scenario) {
    if (scenario.choices.length === 0) {
        console.log('The end! Thanks for playing.');
        rl.close();
        return;
    }

    console.log('What will you do?');
    scenario.choices.forEach((choice, index) => {
        console.log(`${index + 1}: ${choice.text}`);
    });

    rl.question('Choose an option: ', (answer) => {
        const choiceIndex = parseInt(answer) - 1;
        if (choiceIndex >= 0 && choiceIndex < scenario.choices.length) {
            const nextScenarioId = scenario.choices[choiceIndex].goTo;
            goToScenario(nextScenarioId);
        } else {
            console.log('Invalid choice, try again.');
            handleChoice(scenario);
        }
    });
}

// Function to move to the next scenario
function goToScenario(id) {
    const scenario = findScenarioById(id);
    if (scenario) {
        console.log(`\n${scenario.introduction}\n`);
        handleChoice(scenario);
    } else {
        console.log('Scenario not found.');
        rl.close();
    }
}

// Start the game
startGame();
