import os
import pandas as pd
from openai import OpenAI


# Read the sales data from the CSV file
file_path="csv/sales_data_01.csv"
df = pd.read_csv(file_path)

# Data preprocessing example: Summing total sales revenue
total_sales = df["TotalPrice"].sum()


# Generate AI summary usin OpenAI 
prompt = f"Summarize the total sales of {total_sales} from the following data;\n{df.head()}"
model="gpt-4o-mini"
client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))


response = client.chat.completions.create(
    model=model,
    messages=[
        {"role": "user", "content": prompt}
    ]
)

# Get the AI-generated summary
summary_text = response.choices[0].message.content.strip()

print(summary_text)

# Write the report to a excel file
with pd.ExcelWriter("reports/sales_report.xlsx") as writer:
    df.to_excel(writer, sheet_name="Sales Data", index=False)
    summary_df = pd.DataFrame([summary_text], columns=["Summary"])
    summary_df.to_excel(writer, sheet_name="AI Summary", index=False)

print("Report generated successfully!")