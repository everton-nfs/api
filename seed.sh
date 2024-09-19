#!/bin/bash

# 1. Levantar os serviços usando docker-compose
echo "Iniciando serviços Docker..."
docker-compose up -d

# 2. Aguardar o MySQL estar pronto para conexões
echo "Aguardando o MySQL inicializar..."
while ! docker exec api_atividade_mysql mysqladmin --user=root --password=12345678 --host "127.0.0.1" ping --silent &> /dev/null ; do
    echo -n "." 
    sleep 1
done
echo "MySQL pronto!"

# 3. Criar as tabelas e inserir os dados diretamente no MySQL
echo "Criando tabelas e inserindo dados no banco de dados MySQL no contêiner..."

docker exec -i api_atividade_mysql mysql -u root --password=12345678 api_spring << EOF
-- Criar a tabela 'projeto' se não existir
CREATE TABLE IF NOT EXISTS projeto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

-- Criar a tabela 'tarefa' se não existir
CREATE TABLE IF NOT EXISTS tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(255) NOT NULL
);

-- Criar a tabela 'recurso' se não existir
CREATE TABLE IF NOT EXISTS recurso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Inserir dados na tabela 'projeto'
INSERT INTO projeto (descricao) VALUES
('Projeto de Desenvolvimento de Sistema'),
('Projeto de Integração de APIs'),
('Projeto de Automação de Testes');

-- Inserir dados na tabela 'tarefa'
INSERT INTO tarefa (status) VALUES
('Em andamento'),
('Concluída'),
('Pendente');

-- Inserir dados na tabela 'recurso'
INSERT INTO recurso (nome) VALUES
('Everton'),
('Maria'),
('João');
EOF

# 4. Verificação final
if [ $? -eq 0 ]; then
    echo "Dados inseridos com sucesso no banco de dados!"
else
    echo "Ocorreu um erro ao inserir os dados."
    exit 1
fi
