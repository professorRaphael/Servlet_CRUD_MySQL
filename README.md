# PROJETO_E_IMPLEMENTACAO_ORIENTADO_A_OBJETO
Códigos de aula

MIT License

Copyright (c) [2021] [Raphael Mauricio Sanches de Jesus]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Simples exemplo de uso de JSP + HTML + CRUD + MySQL + Servlet.

![Animação](https://user-images.githubusercontent.com/95256788/144121303-d00c4920-c01b-4a82-8483-cbe1e85a9d9f.gif)

--
-- Tabela  `produto`
--

CREATE TABLE `produto` (
  `codigo` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
