USE newbook;                                                                                                                                                              CREATE TABLE `book` (                                                                                                                                                               `id` varchar(255) NOT NULL,
          `title` varchar(255) DEFAULT NULL,
          `author` varchar(255) DEFAULT NULL,
          `category` varchar(255) DEFAULT NULL,
          `availability` tinyint(1) DEFAULT NULL,
          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
insert into  book(id, title, author, category, availability) values('B001', 'ART OF WAR', 'SUN TZU', 'FANTASY', 1);