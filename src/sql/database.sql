-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Nov-2019 às 02:13
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

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `alocarPofessor` (`idTurmaA` INT(4), `idFun` INT(4))  BEGIN
  declare a int;
select count(*)
into a
from profesor p
where p.idFuncionario=idFunA;
if(a=1) then
INSERT into profesorTurma
VALUES(`idFun`, `idturma`);
UPDATE profesor p
set nrTurmas
= nrTurmas + 1 where p.idFun=idFunA;
end
if;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cadastrarFuncionario` (`idFuncionario` INT(4), `nome` VARCHAR(45), `apelido` VARCHAR(45), `bi` VARCHAR(15), `sexo` CHAR(1), `dataNasc` DATE, `nacionalidade` VARCHAR(45), `NIB` INT(35), `totalTurma` INT(2), `idDept` INT(4), `idCargo` INT(11), `dataInicio` DATE, `dataFim` DATE, `tipo` VARCHAR(45), `valHorasExtras` DECIMAL(4,2), `valFaltas` DECIMAL(4,2), `tel1` INT(11), `telFix` INT(11), `tel2` INT(11), `email` VARCHAR(45), `nomeDep` VARCHAR(45), `dataNascimento` DATE, `grauPar` VARCHAR(45), `ano` YEAR, `formacao` VARCHAR(45))  BEGIN
  insert into funcionario
  values(idFuncionario, nome, apelido, bi, sexo, dataNasc, NIB , nacionalidade, estadoCiv);
  INSERT INTO `
  profesor`
  VALUES(idFuncionario, totalTurma);
  INSERT INTO `
  adminstrador`
  VALUES(idFuncionario, idDept, idCargo);
  INSERT INTO `
  contracto`
  VALUES(idFuncionario, dataInicio, dataFim, tipo,
      valHorasExtras, valFaltas);
  INSERT INTO `
  contacto`
  VALUES(idFuncionario, tel1, telFix, tel2, email);
  insert into `
  dependentes`
  values(idFuncionario, nomeDep, dataNascimento, grauPar);
  insert into `
  formacao`
  values(idFuncionario, ano, formacao);
  END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `calculodoIRPS` () RETURNS DECIMAL(8,2) BEGIN
    Declare sumSalario int;
  Declare a int;
select count(*)
into a
from remunercao
where YEAR(data)=2019;
if( a=12) then
select sum(salarioBruto)
into sumSalario
from remunercao
where YEAR(data)=2019;
end
if;
	IF (sumSalario<4200) then
return (select sumSalario*(1-0, 1)
);
			else
IF(sumSalario<168000) then
return sumSalario*(1-0,15);
else
if(sumSalario<504000) then
return sumSalario*(1-0,20);
else
return sumSalario*(1-0,25)
;
end
if;
		end
if;
	end
if;
	end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `idFuncionario` int(11) NOT NULL,
  `idDept` int(4) NOT NULL,
  `idCargo` int(11) NOT NULL,
  `totalAdmin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Acionadores `administrador`
--
DELIMITER $$
CREATE TRIGGER `AFTER_Delete_administrador` AFTER DELETE ON `administrador` FOR EACH ROW BEGIN
  update departamento d
  set totalTrab
  = totalTrab-1
    where d.idDept=old.idDept;

update administrador 
    set totalAdmin= totalAdmin-1;

update Cargo C
set totalTrab
= totalTrab+1
    where C.idCargo=old.idCargo;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AFTER_update_administrador` AFTER UPDATE ON `administrador` FOR EACH ROW BEGIN
  update departamento d
  set totalTrab
  = totalTrab-1
    where d.idDept=old.idDept;

update departamento d
set totalTrab
= totalTrab+1
    where d.idDept=NEW.idDept;

update Cargo 
    set totalTrab= totalTrab+1
    where idCargo=NEW.idCargo;


update Cargo 
    set totalTrab= totalTrab-1
    where idCargo=old.idCargo;

END
$$
DELIMITER ;

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `experiencia`
--

CREATE TABLE `experiencia` (
  `idFuncionario` int(4) NOT NULL,
  `anos` int(11) DEFAULT NULL,
  `experiencia` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `formacao`
--

CREATE TABLE `formacao` (
  `idFuncionario` int(11) NOT NULL,
  `ano` year(4) DEFAULT NULL,
  `formacao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dataInicio` date NOT NULL,
  `dataFIm` date NOT NULL,
  `nomeFormacao` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `estadoCiv` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `bairro` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `casa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `rua` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tel1` int(11) NOT NULL,
  `tel2` int(11) DEFAULT NULL,
  `tel3` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `id` int(11) NOT NULL,
  `Nome` varchar(11) NOT NULL,
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

INSERT INTO `pagamento` (`id`, `Nome`, `horasExtras`, `Faltas`, `bonus`, `desconto`, `dataPagamento`, `salarioBruto`, `salarioLiquido`) VALUES
(1, 'Henry', 6, 2, 2, 2, NULL, '0', '0'),
(3, 'James', 1, 2, 3, 4, NULL, '1200', '1080'),
(2, 'Mister', 2, 3, 3, 2, NULL, '0', '0');

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `idFuncionario` int(4) NOT NULL,
  `totalTurma` int(2) DEFAULT NULL,
  `totalProf` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Acionadores `professor`
--
DELIMITER $$
CREATE TRIGGER `AFTER_DELETE_professor` AFTER DELETE ON `professor` FOR EACH ROW BEGIN
  update professor d
  set totalProf
  = totalProf-1;


end
$$
DELIMITER ;

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
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idFuncionario`),
  ADD KEY `administrador_ibfk_1` (`idCargo`);

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
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`Nome`),
  ADD UNIQUE KEY `key` (`id`);

--
-- Indexes for table `planosaude`
--
ALTER TABLE `planosaude`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`idFuncionario`);

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
  MODIFY `idFuncionario` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pagamento`
--
ALTER TABLE `pagamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`) ON DELETE CASCADE ON UPDATE CASCADE;

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
