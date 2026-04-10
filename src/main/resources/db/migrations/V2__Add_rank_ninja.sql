--V2: Migrations para adicionar a coluna de RANK na tabela de cadastros

ALTER TABLE ninja
ADD COLUMN ranking VARCHAR(255);