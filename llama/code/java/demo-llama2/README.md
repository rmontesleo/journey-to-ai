

###
```bash
#
docker compose -f docker-compose.yaml  up -d

# 
docker exec -it ollama ollama run llama2

```
###
```bash
curl -X POST http://localhost:11434/api/generate -d '{
    "model" : "llama2",
    "prompt" : "List down 5 best indian cricketer name in the world" 
}'
```

###
```bash
curl http://localhost:9292/api/v1/generate?promptMessage="List down 5 best indian cricketer name in the world"
```

## Resources
- [GitHub Java Techie - spring-ai-llama2](https://github.com/Java-Techie-jt/spring-ai-llama2/tree/main)
- [pring AI - Run Meta's LLaMA 2 Locally with Ollama 🦙 | Hands-on Guide | Javatechie](https://www.youtube.com/watch?v=5ecArhs6d7I&list=PLVz2XdJiJQxx695lRqc4v3V-YitV6ERfn)

- [Spring AI](https://spring.io/projects/spring-ai)
- [Ollama](https://ollama.com/)
- [Ollama Chat](https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html)
- [Ollama Ollama](https://github.com/ollama/ollama)
- [Ollama Dockderhub](https://hub.docker.com/r/ollama/ollama)