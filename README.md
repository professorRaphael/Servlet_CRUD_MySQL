# PROJETO SERVLET CRUD
Códigos de aula

Simples exemplo de uso de JSP + HTML + CRUD + MySQL + Servlet.

![Animação](https://user-images.githubusercontent.com/95256788/144121303-d00c4920-c01b-4a82-8483-cbe1e85a9d9f.gif)

--
-- Tabela  `produto`
--
```
CREATE TABLE `produto` (
  `codigo` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
```