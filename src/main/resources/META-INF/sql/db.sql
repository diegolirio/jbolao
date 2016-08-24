insert into Usuario(email, nome, senha) 
SELECT * FROM (SELECT 'admin@admin.com', 'Administrador', '123@456') AS TMP 
WHERE NOT EXISTS (SELECT email FROM Usuario WHERE email = 'admin@admin.com') LIMIT 1;


insert into Usuario(nome, email, senha) 
SELECT * FROM (SELECT 'Diego Lirio', 'diegolirio.dl@gmail.com', 'diego123456') AS TMP 
WHERE NOT EXISTS (SELECT email FROM Usuario WHERE email = 'diegolirio.dl@gmail.com') LIMIT 1;
