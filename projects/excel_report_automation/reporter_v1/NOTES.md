#

##

### Instructions for simple version
```bash

# install pip env
sudo apt-get install -y python3.10-venv

# create the virtual environment
python3 -m venv venv

# activate the virtual environment
source venv/bin/activate

# install required libraries
pip install pandas openpyxl openai

# list all dependencies
pip list

# deactivate/stop virtual envirnoment
deactivate
```

### Instructions for the langchain version
```bash
pip install langchain

pip install -qU langchain-openai

pip install langchain_experimental

pip install -U langchain-community

pip install tabulate
```

### Creating the `requirements.txt` file

To create a `requirements.txt` file for your project, follow these steps:

1. **Activate the virtual environment**:
```bash
source venv/bin/activate
```

2. **Freeze the current environment's packages**:
```bash
pip freeze > requirements.txt
```

This will generate a `requirements.txt` file with all the installed packages and their respective versions, which can be used to restore the virtual environment later.



### Restoring the project with specific dependencies

To restore the project with the specific dependencies listed in the `requirements.txt` file, follow these steps:

1. **Create the virtual environment** (if not already created):
```bash
python3 -m venv venv
```

2. **Activate the virtual environment**:
```bash
source venv/bin/activate
```

3. **Install the dependencies from `requirements.txt`**:
```bash
pip install -r requirements.txt
```

4. **Verify the installed dependencies**:
```bash
pip list
```

5. **Deactivate the virtual environment** (when done):
```bash
deactivate
```

Make sure you have a `requirements.txt` file in your project directory with the necessary dependencies listed.


## References

### GitHub
- [OpenAI Python API library](https://github.com/openai/openai-python)
- [Full API Library](https://github.com/openai/openai-python/blob/main/api.md)

### Open AI
- [OpenAI developer platform](https://platform.openai.com/docs/overview)
- [Developer quickstart](https://platform.openai.com/docs/quickstart?language-preference=python)
- [Text generation](https://platform.openai.com/docs/guides/text-generation)
- [Prompt examples](https://platform.openai.com/docs/examples)
- [Completions API Legacy](https://platform.openai.com/docs/guides/completions#chat-completions-vs-completions)


### Langchain
- [OpenAI](https://python.langchain.com/docs/integrations/llms/openai/)
- [Introduction](https://python.langchain.com/docs/introduction/)
- [Tutorials](https://python.langchain.com/v0.2/docs/tutorials/)
- [How-to guides](https://python.langchain.com/v0.2/docs/how_to/)
- [Conceptual guide](https://python.langchain.com/v0.2/docs/concepts/)
- [Security](https://python.langchain.com/docs/security/)
- [create_pandas_dataframe_agent](https://python.langchain.com/v0.2/api_reference/experimental/agents/langchain_experimental.agents.agent_toolkits.pandas.base.create_pandas_dataframe_agent.html)
- [How to do question answering over CSVs](https://python.langchain.com/v0.2/docs/how_to/sql_csv/)
- [Pandas Dataframe](https://python.langchain.com/v0.2/docs/integrations/tools/pandas/)
- [LangChain Python API Reference](https://python.langchain.com/api_reference/)


### Fix Issues
- [PythonRepl tools and Pandas/Xorbits/Spark/Python agents are moving to langchain_experimental #11680](https://github.com/langchain-ai/langchain/discussions/11680for)
- [Activate venv in vs code](https://stackoverflow.com/questions/69459896/activate-venv-in-vs-code)