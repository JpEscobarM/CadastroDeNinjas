
-- Missões | ENUM Ranking -> D=0, C=1, B=2, A=3, S=4
INSERT INTO MISSAO (nome, dificuldade) VALUES ('Recuperar o Pergaminho', 0);
INSERT INTO MISSAO (nome, dificuldade) VALUES ('Proteger o Daimyo', 2);
INSERT INTO MISSAO (nome, dificuldade) VALUES ('Infiltrar Vila Inimiga', 3);
INSERT INTO MISSAO (nome, dificuldade) VALUES ('Capturar Bijuu', 4);

-- Ninjas
INSERT INTO NINJA (nome, email, idade, aldeia, id_missao) VALUES ('Naruto Uzumaki', 'naruto@konoha.com', 17, 'Konoha', 4);
INSERT INTO NINJA (nome, email, idade, aldeia, id_missao) VALUES ('Sasuke Uchiha', 'sasuke@konoha.com', 17, 'Konoha', 3);
INSERT INTO NINJA (nome, email, idade, aldeia, id_missao) VALUES ('Sakura Haruno', 'sakura@konoha.com', 17, 'Konoha', 2);
INSERT INTO NINJA (nome, email, idade, aldeia, id_missao) VALUES ('Rock Lee', 'lee@konoha.com', 17, 'Konoha', 1);
INSERT INTO NINJA (nome, email, idade, aldeia, id_missao) VALUES ('Gaara', 'gaara@areia.com', 17, 'Vila da Areia', null);
