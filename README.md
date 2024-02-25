# Cloud Humans

Application to determine the ideal project for new professionals

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/EdvanLSBJunior/cloud-humans/blob/main/LICENSE)

### Description:

Cloud Humans is an application that helps in selecting the ideal project for new professionals ("Pros") who apply to the company. Through an intelligent algorithm, the application analyzes the answers provided by the Pros in the Pro Portal (a frontend application) and determines the project with the greatest adherence to their skills and profile. This optimization contributes to the rapid integration of new talents and the success of the company's projects.

### Features:

- Analysis of answers from the Pro Portal through an intelligent algorithm.
- Identification of the project with the greatest adherence to the skills and profile of the new professional.
- Optimized allocation of Pros to projects, promoting productivity and success.

### Requirements:

- Java 17
### Technologies used:

- Spring Boot 3.2.2
- Swagger

### Relevant links:

- Repositório GitHub: https://github.com/seu-nome-de-usuario/cloud-humans
- Acesso ao Swagger: http://localhost:8080/swagger.html (também declarado no application.properties)
  
### Installation and execution:

- Make sure you have Java 17 installed.
- Clone the GitHub repository:
```

  git clone https://github.com/seu-nome-de-usuario/cloud-humans.git

```

- Access the project folder:
```

  cd cloud-humans

```
- Install the dependencies:
```

  mvn install

```
- Run the application:
```

  mvn spring-boot:run

```
- json structure for testing via Postman or Insomnia
- Endpoint:
  http://localhost:8080/pro/validate
```
{
"age": 30,
"education_level": "bachelors_degree_or_high",
"past_experiences": {
"sales": true,
"support": false
},
"internet_test": {
"download_speed": 55,
"upload_speed": 55
},
"writing_score": 3,
"referral_code": "token1234"
}
```
