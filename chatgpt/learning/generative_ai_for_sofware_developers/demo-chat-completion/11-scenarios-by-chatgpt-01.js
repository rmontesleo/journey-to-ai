//this is the response of chatgpt

module.exports = [
    {
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
            }
        ]
    },
    {
        id: 'red-door',
        introduction: 'You enter a room lit by flickering torches. In front of you is a narrow path leading to a dark forest, and another path leading to a cave.',
        choices: [
            {
                text: 'Take the forest path',
                goTo: 'forest'
            },
            {
                text: 'Enter the cave',
                goTo: 'cave'
            }
        ]
    },
    {
        id: 'blue-door',
        introduction: 'You find yourself in a grand library with towering shelves of books. In the corner, you see a mysterious figure writing in a book, and there is also a spiral staircase leading up.',
        choices: [
            {
                text: 'Approach the mysterious figure',
                goTo: 'figure'
            },
            {
                text: 'Climb the staircase',
                goTo: 'staircase'
            }
        ]
    },
    {
        id: 'forest',
        introduction: 'The forest is dense and full of strange sounds. Ahead, you see a glowing tree and a river with a boat.',
        choices: [
            {
                text: 'Examine the glowing tree',
                goTo: 'tree'
            },
            {
                text: 'Take the boat down the river',
                goTo: 'boat'
            }
        ]
    },
    {
        id: 'cave',
        introduction: 'The cave is cold and damp. You hear water dripping and see a faint light deeper inside. A narrow tunnel leads in another direction.',
        choices: [
            {
                text: 'Follow the light',
                goTo: 'light'
            },
            {
                text: 'Explore the tunnel',
                goTo: 'tunnel'
            }
        ]
    },
    {
        id: 'figure',
        introduction: 'The figure looks up at you, revealing an old face with glowing eyes. "Do you seek knowledge or power?" they ask.',
        choices: [
            {
                text: 'Seek knowledge',
                goTo: 'knowledge'
            },
            {
                text: 'Seek power',
                goTo: 'power'
            }
        ]
    },
    {
        id: 'staircase',
        introduction: 'The staircase creaks as you ascend. At the top, you find a locked door and a window looking out over a strange landscape.',
        choices: [
            {
                text: 'Look out the window',
                goTo: 'window'
            },
            {
                text: 'Try to unlock the door',
                goTo: 'locked-door'
            }
        ]
    },
    {
        id: 'tree',
        introduction: 'The glowing tree hums with energy. As you touch it, you feel a surge of power and hear a voice whispering in your mind.',
        choices: [
            {
                text: 'Listen to the voice',
                goTo: 'voice'
            },
            {
                text: 'Step away from the tree',
                goTo: 'forest-path'
            }
        ]
    },
    {
        id: 'boat',
        introduction: 'The boat drifts silently down the river. As the mist thickens, you see an island ahead with a tall tower.',
        choices: [
            {
                text: 'Row towards the tower',
                goTo: 'tower'
            },
            {
                text: 'Turn back to shore',
                goTo: 'shore'
            }
        ]
    },
    {
        id: 'light',
        introduction: 'The light leads you to an underground chamber filled with ancient treasures. In the center lies a glowing artifact.',
        choices: [
            {
                text: 'Take the artifact',
                goTo: 'artifact'
            },
            {
                text: 'Leave the artifact and explore further',
                goTo: 'chamber'
            }
        ]
    },
    {
        id: 'tunnel',
        introduction: 'The tunnel twists and turns before opening into a vast underground city. You hear footsteps approaching.',
        choices: [
            {
                text: 'Hide',
                goTo: 'hide'
            },
            {
                text: 'Confront the approaching figure',
                goTo: 'confront'
            }
        ]
    },
    {
        id: 'knowledge',
        introduction: 'The figure hands you a book. As you open it, your mind is flooded with forgotten knowledge. You now understand the true nature of the world.',
        choices: [
            {
                text: 'Use your knowledge for good',
                goTo: 'good-ending'
            },
            {
                text: 'Use your knowledge for personal gain',
                goTo: 'selfish-ending'
            }
        ]
    },
    {
        id: 'power',
        introduction: 'The figure grants you immense strength and control over elements. "But power comes with a price," they warn.',
        choices: [
            {
                text: 'Accept the power and its price',
                goTo: 'power-ending'
            },
            {
                text: 'Reject the power',
                goTo: 'reject-power'
            }
        ]
    },
    {
        id: 'window',
        introduction: 'Looking out the window, you see a land of shadows and shifting shapes. You feel an inexplicable pull to enter that world.',
        choices: [
            {
                text: 'Step through the window',
                goTo: 'shadow-world'
            },
            {
                text: 'Stay and figure out the locked door',
                goTo: 'locked-door'
            }
        ]
    },
    {
        id: 'locked-door',
        introduction: 'The door resists at first, but eventually clicks open. Inside, you find a room filled with mirrors. Each reflection shows a different version of you.',
        choices: [
            {
                text: 'Step into one of the mirrors',
                goTo: 'mirror-world'
            },
            {
                text: 'Leave the room',
                goTo: 'library'
            }
        ]
    }
];
