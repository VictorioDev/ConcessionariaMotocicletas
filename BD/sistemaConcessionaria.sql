-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.21-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para sistemaconcessionaria
CREATE DATABASE IF NOT EXISTS `sistemaconcessionaria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `sistemaconcessionaria`;

-- Copiando estrutura para tabela sistemaconcessionaria.acessorios
CREATE TABLE IF NOT EXISTS `acessorios` (
  `idAcessorio` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`idAcessorio`),
  UNIQUE KEY `idAcessorio_UNIQUE` (`idAcessorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `descricao` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `idCategoria_UNIQUE` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.categoriasmotocicletas
CREATE TABLE IF NOT EXISTS `categoriasmotocicletas` (
  `idMotocicleta` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idMotocicleta`,`idCategoria`),
  KEY `fk_Motocicletas_has_Categorias_Categorias1_idx` (`idCategoria`),
  KEY `fk_Motocicletas_has_Categorias_Motocicletas1_idx` (`idMotocicleta`),
  CONSTRAINT `fk_Motocicletas_has_Categorias_Categorias1` FOREIGN KEY (`idCategoria`) REFERENCES `mydb`.`categorias` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Motocicletas_has_Categorias_Motocicletas1` FOREIGN KEY (`idMotocicleta`) REFERENCES `mydb`.`motocicletas` (`idMotocicleta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `razaoSocial` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `CPF` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `CNPJ` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `endereco` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `telefone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `RG` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `dataCadastro` datetime NOT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.faturas
CREATE TABLE IF NOT EXISTS `faturas` (
  `idFatura` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `numeroParcela` int(11) NOT NULL,
  `dataEmissao` date NOT NULL,
  `dataVencimento` date NOT NULL,
  `valorParcela` float NOT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `tipoPagamento` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `idVenda` int(11) NOT NULL,
  PRIMARY KEY (`idFatura`),
  UNIQUE KEY `idFatura_UNIQUE` (`idFatura`),
  KEY `fk_Faturas_Vendas1_idx` (`idVenda`),
  CONSTRAINT `fk_Faturas_Vendas1` FOREIGN KEY (`idVenda`) REFERENCES `mydb`.`vendas` (`idVenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.logs
CREATE TABLE IF NOT EXISTS `logs` (
  `idLog` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `acao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `data` datetime NOT NULL,
  `idUsuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idLog`),
  KEY `fk_Logs_Usuarios1_idx` (`idUsuario`),
  CONSTRAINT `fk_Logs_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `mydb`.`usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.marcas
CREATE TABLE IF NOT EXISTS `marcas` (
  `idMarca` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `descricao` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`idMarca`),
  UNIQUE KEY `idMarcas_UNIQUE` (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.modelos
CREATE TABLE IF NOT EXISTS `modelos` (
  `idModelo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `descricao` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `idMarca` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idModelo`),
  UNIQUE KEY `idModelos_UNIQUE` (`idModelo`),
  KEY `fk_Modelos_Marcas_idx` (`idMarca`),
  CONSTRAINT `fk_Modelos_Marcas` FOREIGN KEY (`idMarca`) REFERENCES `mydb`.`marcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.motocicletas
CREATE TABLE IF NOT EXISTS `motocicletas` (
  `chassi` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `ano` int(11) NOT NULL,
  `cor` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `tipoCombustivel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `valorCompra` float NOT NULL,
  `valorVenda` float NOT NULL,
  `situacaoMotocicleta` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `renavam` int(11) NOT NULL,
  `placa` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `motor` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `dataVistoria` date NOT NULL,
  `valorIPVA` float NOT NULL,
  `situacaoIPVA` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `idProprietario` int(11) NOT NULL,
  `idModelo` int(11) NOT NULL,
  `idMotocicleta` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idMotocicleta`),
  KEY `fk_Motocicletas_Proprietarios1_idx` (`idProprietario`),
  KEY `fk_Motocicletas_Modelos1_idx` (`idModelo`),
  CONSTRAINT `fk_Motocicletas_Modelos1` FOREIGN KEY (`idModelo`) REFERENCES `mydb`.`modelos` (`idModelo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Motocicletas_Proprietarios1` FOREIGN KEY (`idProprietario`) REFERENCES `mydb`.`proprietarios` (`idProprietario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.motocicletasacessorios
CREATE TABLE IF NOT EXISTS `motocicletasacessorios` (
  `idMotocicleta` int(11) NOT NULL,
  `idAcessorio` int(11) NOT NULL,
  PRIMARY KEY (`idMotocicleta`,`idAcessorio`),
  KEY `fk_Motocicletas_has_Acessorios_Acessorios1_idx` (`idAcessorio`),
  KEY `fk_Motocicletas_has_Acessorios_Motocicletas1_idx` (`idMotocicleta`),
  CONSTRAINT `fk_Motocicletas_has_Acessorios_Acessorios1` FOREIGN KEY (`idAcessorio`) REFERENCES `mydb`.`acessorios` (`idAcessorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Motocicletas_has_Acessorios_Motocicletas1` FOREIGN KEY (`idMotocicleta`) REFERENCES `mydb`.`motocicletas` (`idMotocicleta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.proprietarios
CREATE TABLE IF NOT EXISTS `proprietarios` (
  `idProprietario` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `nome` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `razaoSocial` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `RG` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `CPF` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `CNPJ` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `endereco` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `telefone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `cartorio` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`idProprietario`),
  UNIQUE KEY `idProprietario_UNIQUE` (`idProprietario`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `login` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `senha` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `CPF` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `endereco` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `telefone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela sistemaconcessionaria.vendas
CREATE TABLE IF NOT EXISTS `vendas` (
  `idVenda` int(11) NOT NULL AUTO_INCREMENT,
  `dataVenda` datetime NOT NULL,
  `quantidadeParcelas` int(11) NOT NULL,
  `valor` float NOT NULL,
  `diaPreferencial` int(11) NOT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idUsuario` int(10) unsigned NOT NULL,
  `idMotocicleta` int(11) NOT NULL,
  PRIMARY KEY (`idVenda`),
  UNIQUE KEY `idVendas_UNIQUE` (`idVenda`),
  KEY `fk_Vendas_Clientes1_idx` (`idCliente`),
  KEY `fk_Vendas_Usuarios1_idx` (`idUsuario`),
  KEY `fk_Vendas_Motocicletas1_idx` (`idMotocicleta`),
  CONSTRAINT `fk_Vendas_Clientes1` FOREIGN KEY (`idCliente`) REFERENCES `mydb`.`clientes` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_Motocicletas1` FOREIGN KEY (`idMotocicleta`) REFERENCES `mydb`.`motocicletas` (`idMotocicleta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vendas_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `mydb`.`usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
