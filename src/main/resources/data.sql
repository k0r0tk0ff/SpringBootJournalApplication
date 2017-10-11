INSERT INTO people (client_id, firstname, lastname, login, password, tel) VALUES 
	(1, 'Peter', 'Pen', 'Pet', 'pa$$', '89889990001'),
	(2, 'Mike', 'Dorovsky', 'Dor', 'pa$$2', '89889990002'),
	(3, 'Den', 'Peleng', 'Den', 'pa$$3', '89889990003'),
	(4, 'Vanish', 'Obschazhny', 'Van', 'pa$$4', '89889990004'),
	(5, 'Oigan', 'Mokry', 'Iom', 'pa$$5', '89889990005');

INSERT INTO pets (pet_id, nick, kind, weight) VALUES
	(1, 'Murzik', 'cat', '2.0 kg'),
	(2, 'Polkan', 'dog', '5.0 kg'),
	(3, 'Musy', 'shinshilla', '1.0 kg'),
	(4, 'Penelopa', 'guerilla', '15.0 kg');
	
INSERT INTO catalog (client_id, pet_id) VALUES
	(1, 1),
	(2, 2),
	(2, 3),
	(3, 4);
