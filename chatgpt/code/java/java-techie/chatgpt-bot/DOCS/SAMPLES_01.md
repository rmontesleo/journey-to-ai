

## Request 01
```bash
curl https://api.openai.com/v1/chat/completions   -H "Content-Type: application/json"   -H "Authorization: Bearer $OPENAI_API_KEY"   -d '{
  "model": "gpt-4o-mini",
  "messages": [
    {
      "role": "user",
      "content": [
        {
          "type": "text",
          "text": "Describe in a short sentence what is Vector Database"
        }
      ]
    }
  ] 
}' | jq
```

## Response 01
```json
{
  "id": "chatcmpl-XXXXXXXXXXXXXXXXXXXXXXXXXXXX",
  "object": "chat.completion",
  "created": 1726371710,
  "model": "gpt-4o-mini-2024-07-18",
  "choices": [
    {
      "index": 0,
      "message": {
        "role": "assistant",
        "content": "A vector database is a specialized database designed to store, index, and retrieve high-dimensional vectors, typically used in applications like machine learning, natural language processing, and image recognition for efficient similarity search and retrieval.",
        "refusal": null
      },
      "logprobs": null,
      "finish_reason": "stop"
    }
  ],
  "usage": {
    "prompt_tokens": 16,
    "completion_tokens": 41,
    "total_tokens": 57,
    "completion_tokens_details": {
      "reasoning_tokens": 0
    }
  },
  "system_fingerprint": "fp_483d39d857"
}
```