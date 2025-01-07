-- Criando a tabela de perfis
CREATE TABLE profiles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Criando a tabela de cursos
CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_curso VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

-- Criando a tabela de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Tabela de relacionamento ManyToMany entre usuarios e perfis
CREATE TABLE usuario_perfil (
    usuario_id INT,
    perfil_id INT,
    PRIMARY KEY (usuario_id, perfil_id),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES profiles(id) ON DELETE CASCADE
);

-- Criando a tabela de topicos
CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(255) NOT NULL,
    usuario_forum_id INT,  -- FK para a tabela de usuarios
    curso_id INT,  -- FK para a tabela de cursos
    CONSTRAINT fk_usuario_forum FOREIGN KEY (usuario_forum_id) REFERENCES usuarios(id) ON DELETE SET NULL,
    CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE SET NULL
);

-- Criando a tabela de respostas
CREATE TABLE respostas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    topico_id INT,  -- FK para a tabela de topicos
    created_at TIMESTAMP NOT NULL,
    usuario_forum_id INT,  -- FK para a tabela de usuarios
    solucao VARCHAR(255),
    CONSTRAINT fk_topico FOREIGN KEY (topico_id) REFERENCES topicos(id) ON DELETE CASCADE,
    CONSTRAINT fk_usuario_forum FOREIGN KEY (usuario_forum_id) REFERENCES usuarios(id) ON DELETE CASCADE
);
