# CP03 - MS Montadoras

## Mudanças realizadas no Checkpoint 3

O projeto foi refatorado a partir do Checkpoint 2 com a adição de DTOs e Mappers,
separando as responsabilidades entre as camadas da API.

- Criados DTOs de request para Montadora e Modelo (usados nas operações POST e PUT)
- Criados DTOs de response para Montadora e Modelo (usados em todas as respostas da API)
- Criados Mappers para converter entre DTOs e Entities (MontadoraMapper e ModeloMapper)
- Controllers refatoradas para não expor mais as entidades JPA diretamente

---

## Subindo o banco de dados com Docker

```bash
docker run --name postgres-montadoras \
  -e POSTGRES_DB=montadoras \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin \
  -p 5432:5432 \
  -d postgres
```

---

## Como executar

```bash
./mvnw spring-boot:run
```

A aplicação sobe na porta `8080`.

Swagger disponível em: `http://localhost:8080/swagger-ui.html`
