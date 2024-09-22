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

