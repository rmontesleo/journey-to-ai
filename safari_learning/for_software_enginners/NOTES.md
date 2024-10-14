
# ChatGPT for sofware engineers


## 15 common use cases for ChatGPT

**The use cases for 5 major situations**
- When you’re starting a new project
- When you pick up code from someone else
- To pair with you on daily software development work
- To offload the tedious parts of your job
- When you’re interviewing for a new job


**The use cases for 5 major situations**
- When you’re starting a new project
    - Brainstorm implementation ideas
    - Generate boilerplate code
    - Generate frontend code from design

- When you pick up code from someone else
    - Explain code
    - Find bugs in code
    - Help with console errors

- To pair with you on daily software development work
    - Code review
    - Comment code
    - Write test cases
    - Help with Git commands


- To offload the tedious parts of your job
    - Generate regexes (and other hard syntax)
    - Generate test data
    - Convert file formats (eg: XML to JSON)
    - Generate documentation


- When you’re interviewing for a new job
    - Mock interview
    - Take home interview challenges





## You’re starting a new project

### 1. Brainstorm implementation ideas

#### Prompt template:
I nees to build `[Explain the task's requirements]`. Should I `[list the options your considering]` ? Explain the tradeoffs of each option.

#### Prompt Sample: 
I need to build a real-time analytics dashboard for a hisght-traffic web application, data will be read in JSON format from several parthenrs's APIs, and crunched into condensed data to be updates in the UI every minut. Should I use relational or NoSQL database? Explain the tradeoffs of each option.

### 2. Generate boilerplate code

#### Prompt Template:
Generate boilerplate code for an app that `[explain what you need this app to do]`. Please use 
`[explain what languages and frameworks should be used]`.

#### Prompt Sample: 
Generate bolerplate code for an app that integrates to Plaid API to pull teh last month of transactions from a list of users in my MongoDV database. Please write it in javascript using the latest version of the express.js framework.


### 3. Generate frontend code from design

#### Prompt Template:
Generate the `[language/framework]` code for this page.
(upload image file of mockup)

#### Prompt Smaple:
Generate the HTML/CSS code to replicate this page
(upload image file of mockup)

---


##  When you pick up code from someone else

### 4. Explain code

#### Prompt Template:
 Explain the code below. Make sure to include explanations to each line, each function, and to the overall code snippet.
`[code you want to be explained]`

#### Prompt Sample:
Explain the code below. Make sure to include explanations to each line, each function, and to the overall code snippet.

```javascript
fetch("https://api.stripe.com/v1/payments?created[gte]=last_month")
.then(response => response.json())
.then(data => {
let transactions = data.transactions;
let groupedTransactions = {};
transactions.forEach(transaction => {
if (!groupedTransactions[transaction.entity]) {
groupedTransactions[transaction.entity] = transaction.amount;
} else {
groupedTransactions[transaction.entity] += transaction.amount;
}
});
let sortedTransactions = Object.entries(groupedTransactions).sort((a, b) => b[1] - a[1]);
sortedTransactions.forEach(transaction => {
console.log(${transaction[0]}: $${Math.ceil(transaction[1])});
});
});
}

```


### 5. Find bugs in code.

#### Prompt Template:
Please find the bug in the code below. This is what it should be doing:
`[requirements to be fulfilled]`
Code:
`[code where you want to find bugs]`

#### Prompt Sample:
Please find the bug in the code below. This is wat is should be doing:
1. Fetch the response from teh stripe API for payments seceived last month.
2. Parse the response json into an arrays with all transactions.
3. Traverse the array to group all transactions from the same entity, and sums their amounts.The result is store in a different array.
4. Sort the resulting array by amount received, descending.
5. Write to the console all payments, sorted by date, with money amoounts rounded up to the integer.

Code.
```javascript

```


### 6. Help with console errors.


#### Prompt Template:
What’s this error about, and how to fix it?
`(upload image file of mockup)`

#### Prompt Sample:


### 7. Refactor code.


#### Prompt Template:
Rewrite the following code using `[language, framework and any other preferences for the refactored code]`.
`[code you want to be refactored]`


#### Prompt Sample:
Rewerite the following code using python, specifically the latest version of the Flask framework.

---

## GhatGPT as your pair programmer.


### 8 Code review

#### Prompt Template:
I'm opening a Pull Request with the code below. Write a code review for it, focusing on 
`[what the code review should focus on]`.

`[code you want to be reviewed]`

#### Prompt Sample
I'm opening a Pull Request with the code below. Write a code review for it, focusing on best practices such as code maintainability, security vulnerabilities and performance.

```javascript
//
```

### 9. Comment code

#### Prompt Template:
Comment the code below. Make sure your comments are clear and follow 
`[your preferred code commenting standards]`. Your response should be displayed inside a code block.
`[code you want to be commented]`

#### Prompt Template:
Comments the code below. Make sure hyour comments are clear and flolow code commenting best practises. your response should be idisplayed inside a code block.

```javascript
fetch("https://api.stripe.com/v1/payments?created[gte]=last_month")
.then(response => response.json())
.then(data => {
let transactions = data.transactions;
let groupedTransactions = {};
transactions.forEach(transaction => {
if (!groupedTransactions[transaction.entity]) {
groupedTransactions[transaction.entity] = transaction.amount;
} else {
groupedTransactions[transaction.entity] += transaction.amount;
}
});
let sortedTransactions = Object.entries(groupedTransactions).sort((a, b) => b[1] - a[1]);
sortedTransactions.forEach(transaction => {
console.log(${transaction[0]}: $${Math.ceil(transaction[1])});
});
});
}
```

### 10. Write test cases

#### Prompt Template:
Write unit tests for `[cases to be tested]` on the below code snippet. 
You should follow `[unit testing guidelines to follow]`. 
Your tests should be written in `[language and framework to be used]`.

`[code you want to write test cases for]`


#### Prompt Sample:
Write unit tests for the main edge cases you find on the below code snippet. YOu should follow Gherkin testing best practices.
Your tests should be writter in javascript using the Jest framework


```javascript
fetch("https://api.stripe.com/v1/payments?created[gte]=last_month")
    .then(response => response.json())
    .then(data => {
        let transactions = data.transactions;
        let groupedTransactions = {};
        transactions.forEach(transaction => {
            if (!groupedTransactions[transaction.entity]) {
                groupedTransactions[transaction.entity] = transaction.amount;
            } else {
                groupedTransactions[transaction.entity] += transaction.amount;
            }
        });
        let sortedTransactions = Object.entries(groupedTransactions).sort((a, b) => b[1] - a[1]);
        sortedTransactions.forEach(transaction => {
            console.log(${ transaction[0]}: $${ Math.ceil(transaction[1]) });
        });
    });
```

### 11. Help with Git commands

#### Prompt Template:
Show me how to [describe git workflow in natural language]


#### Prompt Sample:
Show me how to pull code changes from github repo without overriding my local changes, and how to push all code to the repo including my changes and reamining updated code.

---

## Offload the tedious tasks.
4 propts to have Chat GPT do in seconds what would otherwise take you a couple hours.


### 12. Generate regexes (and other hard syntax)


#### Prompt Template:
Generate a `[item with hard syntax you need]` to match 
`[what you need it to match described in natural language]`

#### Prompt Sample:
Generate a regex to match a phone number from the United States.


### 13. Gnerate test data

#### Prompt Template:
Generate SQL insert statements to populate the following tables with` [number of entries]`
entries of dummy data that `[requirements for the data to be generated].`
`[create statements of the tables to populate]`


#### Prompt Sample:
Generate SQL insert statements to populate the following tables with 10 entries of dummy data that is realistic enought to test my application

```sql

```

### 14. Convert file formats (eg: XML to JSON)

#### Prompt Template:
Convert the following `[current file format]` file into `[new file format]` format. The response 
should be enclosed in a code block.
`[original file to be converted]`


#### Prompt Sample:
Convert the followign XML file into JSON format. The response should be enclosed in a code block

```xml

```


### 15. Generate documentation

#### Prompt Template:
Generate documentation for the code below. You should 
`[list all your guidelines for what the documentation should include].`

`[code you want to generate documentation for]`

#### Prompt Sample:
Generate documentation for the code below. You should explain what the code does, include instructions to allow a software developer to run it on a locla machine, list any requirements to run it, and list any vulnerabiliteies that should be fixed in the future

```javascript
fetch("https://api.stripe.com/v1/payments?created[gte]=last_month")
.then(response => response.json())
.then(data => {
let transactions = data.transactions;
let groupedTransactions = {};
transactions.forEach(transaction => {
if (!groupedTransactions[transaction.entity]) {
groupedTransactions[transaction.entity] = transaction.amount;
} else {
groupedTransactions[transaction.entity] += transaction.amount;
}
});
let sortedTransactions = Object.entries(groupedTransactions).sort((a, b) => b[1] - a[1]);
sortedTransactions.forEach(transaction => {
console.log(${transaction[0]}: $${Math.ceil(transaction[1])});
});
});
}
```




## When you're looking for a job
3 prompts to help you land a new job

- Take home interview challenges
- Mock interview


### 16. Take home interview challenges

#### Prompt Template:
Generate code in `[desired language]` to solve the following challenge:
`[outline of the challenge to be solved]`


#### Prompt Sample:
Generate code in javascript to solve the following challenge:
- We have one 2D array, filled with zeros and ones.
- We have to find the starting point and endng point of all rectangles filled with 0.
- its is given that rectangles are spearated and do not touch each other however they can touch the boundary of the array.
- A rectangle might contain only one element.

Example input array
```javascript

```

### 17. Mock interview

#### Prompt Template:

#### Prompt Sample:



---

## Resources
- [ChatGPT for Software Engineers](https://learning.oreilly.com/live-events/chatgpt-for-software-engineers/0636920090062/0642572000420/)
- [PDF Slides](https://on24static.akamaized.net/event/45/94/29/0/rt/1/documents/resourceList1719857276159/oreillysergiopereirachatgptforsoftwareengineers11719857276159.pdf)
- [10 ChatGPT prompts for Software Engineers](https://on24static.akamaized.net/event/45/94/29/0/rt/1/documents/resourceList1719857307855/10chatgptpromptsforsoftwareengineersbysergiopereira1717771151527.pdf)
- [Remote Work Academy](https://www.remote-work.io/)
- [Jobs Copilot](https://jobscopilot.ai/)