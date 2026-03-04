# Utilidades de RESOURCES

> É colocado o que não são código Java, Configurações da Aplicação: como a 
> conexão do SGBD, A porta em que o servidor vai rodar, O nome da aplicação,
> Configurações de segurança e logs. Arquivos Estáticos (Front-end básico),
> Certificados, Chaves e etc.
    
    // URL do SGBD                               
        spring.datasource.url= jdbc:postgresql://localhost:5432/PRODUCTS

    // Autenticacao
        spring.datasource.username=postgres
        spring.datasource.password=banco123

    // Se a tabela nao existir, ele vai criar ou atualizar o SGBD.
        spring.jpa.hibernate.ddl-auto=update
        
        spring.application.name=cadastroClientes