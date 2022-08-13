/* IMPORTANTE! 
	Sem aspas, os identificadores ficam com todas as letras maiúsculas no H2 Database.
*/

/* O JPA cria a tabela automaticamente.
CREATE TABLE Person(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	telephone VARCHAR(15),
	birth_date DATE,
	salary NUMERIC(18,2)
);
*/	

INSERT INTO Person(name, telephone, birth_date, salary) 
VALUES('Fulano de Tal', '123-456', null, 5000);

INSERT INTO Person(name, telephone, birth_date, salary) 
VALUES('Ciclano da Silva', '456-789', null, 10000);

INSERT INTO Person(name, telephone, birth_date, salary) 
VALUES('Beltrano de Souza', '147-963', null, 15000);