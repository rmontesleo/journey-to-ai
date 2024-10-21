#


## TODOS:
- Add a service to decouple the Resttemplate invocation
- Add Response Type Object with the http code to each controller method.
- Define how the system and assistant will be working and set by configuration
- 
- Create the Container image (Consider pass in env variables the OPENAI_API_KEY value)
- Push image to docker hub
- Deploy on Kubernetes (Minikube)
- Working in the cloud (registry, container service, K8s service)
    - Linode
    - digital ocean
    - Azure
    - AWS
    - GCP
- Create templating with Terraform
    - Linode
    - digital ocean
    - Azure
    - AWS
    - GCP
- Create a CI/CD pipeline (Compile, Container Image, SAST, SCA, DAST, Deploy) to the mentions cloud providers
    - Jenkins
    - Harness
    - GitLab
    - GitHub Actions    

- Thing how to improve this bot
- Create a frontend layer that consume this "bot"

## REFERENCES
- [YouTube: Spring Boot + OpenAI ChatGPT API Integration | JavaTechie](https://www.youtube.com/watch?v=HlDkuFy8xRM)
- [GitHub Project](https://github.com/Java-Techie-jt/springboot-chatgpt)
- [Chat GPT Solution](https://chatgpt.com/share/66e64f7b-4ad0-8004-8043-0adc4a91a2de)
- [Baeldung: Using Environment Variables in Spring Boot’s Properties Files](https://www.baeldung.com/spring-boot-properties-env-variables)