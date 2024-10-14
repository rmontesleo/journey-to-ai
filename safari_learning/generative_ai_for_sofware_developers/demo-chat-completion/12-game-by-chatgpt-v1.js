const readline = require('readline');

// The scenarios for the game (from your example)
const scenarios = [{
    id: 'doors',
    introduction: 'You are standing in front of 2 doors, one is red, one is blue.',
    choices: [
        {
            text: 'Open the red door',
            goTo: 'red-door'
        },
        {
            text: 'Open the blue door',
            goTo: 'blue-door'
        },
    ]
}, {
    id: 'red-door',
    introduction: 'You find yourself in a room filled with strange paintings. One painting seems to move.',
    choices: [
        {
            text: 'Inspect the moving painting',
            goTo: 'painting'
        },
        {
            text: 'Leave the room',
            goTo: 'doors'
        }
    ]
}, {
    id: 'blue-door',
    introduction: 'You enter a cold and damp corridor. There is a faint light at the end.',
    choices: [
        {
            text: 'Walk towards the light',
            goTo: 'light'
        },
        {
            text: 'Turn back',
            goTo: 'doors'
        }
    ]
}, {
    id: 'painting',
    introduction: 'The painting comes alive and pulls you into a fantasy world.',
    choices: [
        {
            text: 'Explore the fantasy world',
            goTo: 'fantasy-world'
        },
        {
            text: 'Try to escape',
            goTo: 'escape'
        }
    ]
}, {
    id: 'light',
    introduction: 'As you approach the light, you find an exit leading to a sunny field.',
    choices: [
        {
            text: 'Step into the field',
            goTo: 'field'
        },
        {
            text: 'Return to the corridor',
            goTo: 'blue-door'
        }
    ]
}, {
    id: 'fantasy-world',
    introduction: 'You explore the world, filled with magical creatures and wonders. The adventure is just beginning!',
    choices: []
}, {
    id: 'escape',
    introduction: 'You manage to escape the painting, but the experience leaves you shaken.',
    choices: []
}, {
    id: 'field',
    introduction: 'You enjoy the peaceful surroundings of the field. Your adventure comes to a happy end.',
    choices: []
}];

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
