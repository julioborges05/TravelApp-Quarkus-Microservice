# Travel App

### Resumo

Aplicação de controle de uma agência de viagens, onde é possível cadastrar
e pesquisar voos e reservas em hotéis.

O Projeto foi criado com o intuito de quebrar um monólito em 3 microsserviços.  

Os arquivos foram divididos em duas partes, onde a pasta "mono" representa o
monólito. A segunda etapa se encontra na pasta "micro" onde os serviços
flight-app, hotel-app e travel-order-app estão presentes, assim como a sua
configuração para ser executadas com o kubernetes.
 
### Propriedades

- Todos os serviços são uma API Rest criadas com o Quarkus
- Todos os serviços têm verificação HealthCheck Liveness
- Serviço travel-order-app tem verificação HealthCheck Readiness
- Serviço travel-order-app consome a API dos outros serviços
- Serviço travel-order-app tem circuit breaker e fallback para prevenção de erros em cascata
- Banco de dados Postgresql
- Arquivos de configuração do kubernetes presentes na pasta "micro"