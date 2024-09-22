const readline = require('readline');

// Create an interface for reading data from the console
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Define Handle closing of the readline interface
rl.on('close', () => {
    console.log('Exiting the program...');
    process.exit(0);
});


module.exports = {
    rl
}


