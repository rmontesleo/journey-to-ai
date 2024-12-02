import pandas as pd
from langchain_experimental.agents import create_pandas_dataframe_agent
from langchain_openai import OpenAI


# load the sales data from the csv file
df = pd.read_csv("csv/sales_data_01.csv")


llm = OpenAI(temperature=0)

# This is just a hello world example, to validate langchain is working with OpenAI
#response = llm.invoke("Hello, how are you?")
#print(response)

# Create the LangChain agent
agent = create_pandas_dataframe_agent(
            llm, 
            df,             
            verbose=True,
            allow_dangerous_code=True)

# Example of querying the agent to get insights
query = "What is the total sales for the month of January?"

# Get the agent's response based on the query
response = agent.invoke(query)

# Print the response from the agent
print(response)
print(response['output'])