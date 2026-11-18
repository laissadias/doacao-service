# Doação Service

![CI](https://github.com/laissadias/doacao-service/actions/workflows/ci.yml/badge.svg)

Microsserviço de doações de uma plataforma de banco de alimentos, que conecta doadores (mercados, padarias, restaurantes) a instituições que recebem os alimentos. Este é o primeiro serviço de um sistema maior, planejado para ser orientado a eventos.

## Tecnologias

- Java 25 e Spring Boot 4
- Spring Data JPA e PostgreSQL
- Validação com Bean Validation
- Swagger / OpenAPI (springdoc)
- Testes com JUnit 5 e Mockito
- Docker e Docker Compose
- GitHub Actions (CI)

## Como executar

Pré-requisito: Docker instalado.

```bash
docker compose up --build
```

A API sobe em `http://localhost:8080` e a documentação interativa (Swagger) em:

```
http://localhost:8080/swagger-ui/index.html
```

Para parar mantendo os dados do banco:

```bash
docker compose down
```

## Endpoints

| Método | Caminho | Descrição |
|---|---|---|
| GET | `/doacoes` | Lista todas as doações |
| GET | `/doacoes/{id}` | Busca uma doação pelo id |
| POST | `/doacoes` | Cadastra uma doação |
| PUT | `/doacoes/{id}` | Atualiza uma doação |
| DELETE | `/doacoes/{id}` | Remove uma doação |

Exemplo de corpo para `POST /doacoes`:

```json
{
  "alimento": "Feijão",
  "nomeDoador": "Padaria Bom Pão",
  "quantidadeKg": 25.5,
  "validadeEmDias": 5
}
```

## Testes

```bash
./mvnw test
```

Os testes rodam automaticamente a cada push, pelo GitHub Actions.

## Próximos passos

- Serviço de notificações consumindo eventos (mensageria)
- Autenticação com Keycloak
- Front-end em Angular
- Deploy na AWS com Terraform