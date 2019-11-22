-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 21-Nov-2019 às 22:05
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sgrh`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE `admin` (
  `idFuncionario` int(11) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `username` varchar(11) NOT NULL,
  `password` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`idFuncionario`, `cargo`, `username`, `password`) VALUES
(10, 'Tecnico', 'actq', 'actq');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL,
  `nomeCargo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salarioBase` double DEFAULT NULL,
  `totalTrab` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contracto`
--

CREATE TABLE `contracto` (
  `idFuncionario` int(4) NOT NULL,
  `dataInicio` date DEFAULT NULL,
  `dataFim` date DEFAULT NULL,
  `tipo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `contracto`
--

INSERT INTO `contracto` (`idFuncionario`, `dataInicio`, `dataFim`, `tipo`) VALUES
(1, '2018-11-23', '2020-11-29', 'A'),
(7, '2018-12-04', '2020-10-21', 'B'),
(9, '2019-06-11', '2020-11-25', 'A'),
(10, '2019-11-06', '2025-11-06', 'C'),
(11, '2019-11-20', '2020-11-20', 'A'),
(18, '2015-11-13', '2020-11-20', 'B'),
(19, '2013-11-28', '2019-11-30', 'A');

-- --------------------------------------------------------

--
-- Estrutura da tabela `experiencia`
--

CREATE TABLE `experiencia` (
  `idFuncionario` int(4) NOT NULL,
  `nomeEmpresa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `anoExperiencia` date DEFAULT NULL,
  `cargo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `areaFormacao` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `experiencia`
--

INSERT INTO `experiencia` (`idFuncionario`, `nomeEmpresa`, `anoExperiencia`, `cargo`, `areaFormacao`, `dataInicio`, `dataFim`) VALUES
(10, 'Tactical Programmer Studios', '2019-11-06', 'Programador', 'Engenharia', '2018-11-06', '2022-11-06');

-- --------------------------------------------------------

--
-- Estrutura da tabela `formacao`
--

CREATE TABLE `formacao` (
  `idFuncionario` int(11) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFIm` date NOT NULL,
  `nivel` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nomeFormacao` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `formacao`
--

INSERT INTO `formacao` (`idFuncionario`, `dataInicio`, `dataFIm`, `nivel`, `nomeFormacao`) VALUES
(10, '2018-11-06', '2022-11-06', 'Superior', 'Engenharia Informatica');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int(4) NOT NULL,
  `nome` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `apelido` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `bi` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `sexo` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `dataNasc` date NOT NULL,
  `NIB` int(35) NOT NULL,
  `nacionalidade` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `estadoCiv` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `nome`, `apelido`, `bi`, `sexo`, `dataNasc`, `NIB`, `nacionalidade`, `estadoCiv`) VALUES
(1, 'Carlos', 'Jonas', '12345678901b', 'M', '2019-11-05', 121231289, 'Mozambican', 'Casado'),
(2, 'Jonas', 'Fill', '12345678901c', 'M', '2019-11-15', 1234536578, 'Mozambican', 'Casado'),
(6, 'Jonas', 'Fill', '12345678901c', 'M', '2017-10-15', 2147483647, 'Mozambican', 'Casado'),
(7, 'Sara', 'Da Silva', '12345678901c', 'F', '2016-12-15', 2147483647, 'Mozambican', 'Casado'),
(8, 'Jonas', 'João', '12345678901c', 'M', '2015-03-15', 2147483647, 'Mozambican', 'Casado'),
(9, 'Anabella', 'Kali', '12345678901c', 'F', '2012-01-15', 2147483647, 'Mozambican', 'Casado'),
(10, 'Anderson', 'Queiroz', '123456789012n', 'M', '1999-11-06', 12345, 'Moçambicano', 'Solteiro'),
(11, 'Argentina', 'Cossa', '12345678901c', 'F', '2019-12-15', 234536578, 'Mozambican', 'Casado'),
(16, 'Debian', 'Done', '12345678901c', 'M', '2017-10-15', 2147483647, 'Mozambican', 'Solteiro'),
(17, 'Fedora', 'Great', '12345678901c', 'F', '2016-12-15', 2147483647, 'Mozambican', 'Casado'),
(18, 'Ubuntu', 'João', '12345678901c', 'M', '2015-03-15', 2147483647, 'Mozambican', 'Casado'),
(19, 'Kali', 'Anabella', '12345678901c', 'F', '2012-01-15', 2147483647, 'Mozambican', 'Casado'),
(20, 'José', 'Raquell', '12345678901c', 'F', '2011-01-15', 2147483647, 'Mozambican', 'Solteiro'),
(21, 'Argentina', 'Cossa', '12345678901c', 'F', '2019-12-15', 234536578, 'Mozambican', 'Solteiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `id` int(11) NOT NULL,
  `horasExtras` int(11) NOT NULL,
  `Faltas` int(11) NOT NULL,
  `bonus` int(11) NOT NULL,
  `desconto` int(11) NOT NULL,
  `dataPagamento` date DEFAULT NULL,
  `salarioBruto` decimal(11,0) NOT NULL,
  `salarioLiquido` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pagamento`
--

INSERT INTO `pagamento` (`id`, `horasExtras`, `Faltas`, `bonus`, `desconto`, `dataPagamento`, `salarioBruto`, `salarioLiquido`) VALUES
(10, 3, 4, 2, 1, NULL, '20100', '14070');

-- --------------------------------------------------------

--
-- Estrutura da tabela `planosaude`
--

CREATE TABLE `planosaude` (
  `idFuncionario` int(11) NOT NULL,
  `dataInicio` date DEFAULT NULL,
  `dataFim` date DEFAULT NULL,
  `nrAgre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `planosaude`
--

INSERT INTO `planosaude` (`idFuncionario`, `dataInicio`, `dataFim`, `nrAgre`) VALUES
(10, '2019-11-06', '2020-11-06', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `idFuncionario` int(4) NOT NULL,
  `totalTurma` int(2) DEFAULT NULL,
  `disciplina` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `remuneracao`
--

CREATE TABLE `remuneracao` (
  `idFuncionario` int(4) NOT NULL,
  `horasExtras` int(3) NOT NULL,
  `nrFaltas` int(2) NOT NULL,
  `bonus` decimal(8,2) NOT NULL,
  `salarioBruto` decimal(8,2) DEFAULT NULL,
  `dataPagamento` date NOT NULL,
  `salarioLiquido` decimal(8,2) DEFAULT NULL,
  `IRPS` decimal(3,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idCargo`);

--
-- Indexes for table `contracto`
--
ALTER TABLE `contracto`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `formacao`
--
ALTER TABLE `formacao`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`),
  ADD UNIQUE KEY `idFuncionario` (`idFuncionario`);

--
-- Indexes for table `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `planosaude`
--
ALTER TABLE `planosaude`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD UNIQUE KEY `idFuncionario` (`idFuncionario`) USING BTREE;

--
-- Indexes for table `remuneracao`
--
ALTER TABLE `remuneracao`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idCargo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `contracto`
--
ALTER TABLE `contracto`
  ADD CONSTRAINT `contracto_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`);

--
-- Limitadores para a tabela `experiencia`
--
ALTER TABLE `experiencia`
  ADD CONSTRAINT `experiencia_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`);

--
-- Limitadores para a tabela `formacao`
--
ALTER TABLE `formacao`
  ADD CONSTRAINT `formacao_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`);

--
-- Limitadores para a tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `planosaude`
--
ALTER TABLE `planosaude`
  ADD CONSTRAINT `idFuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `idFuncioanario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `remuneracao`
--
ALTER TABLE `remuneracao`
  ADD CONSTRAINT `remuneracao_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
