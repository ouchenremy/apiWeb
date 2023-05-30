-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 14 avr. 2023 à 06:45
-- Version du serveur :  10.5.6-MariaDB-1:10.5.6+maria~stretch
-- Version de PHP : 7.3.19-1~deb10u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projetClef`
--

-- --------------------------------------------------------

--
-- Structure de la table `Appartement`
--

CREATE TABLE `Appartement` (
  `immeuble` int(11) NOT NULL,
  `num` int(3) NOT NULL,
  `description` longtext DEFAULT NULL,
  `loyer` double NOT NULL,
  `superficie` double NOT NULL,
  `terrasse` tinyint(1) NOT NULL,
  `classeConso` char(1) NOT NULL,
  `chauffage` char(1) NOT NULL,
  `placeParking` tinyint(1) NOT NULL,
  `prixParking` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `clef`
--

CREATE TABLE `clef` (
  `numeroClef` int(11) NOT NULL,
  `couleurCLef` varchar(50) DEFAULT NULL,
  `libelleClef` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `clef`
--

INSERT INTO `clef` (`numeroClef`, `couleurCLef`, `libelleClef`) VALUES
(1, 'Pink', '13537-563'),
(2, 'Teal', '62011-0011'),
(3, 'Purple', '49349-712'),
(4, 'Teal', '30142-133'),
(5, 'Blue', '68788-9868'),
(6, 'Khaki', '55301-939'),
(7, 'Fuscia', '0268-0011'),
(8, 'Red', '68462-260'),
(9, 'Yellow', '55739-1022'),
(10, 'Purple', '65044-0614'),
(11, 'Indigo', '0268-1523'),
(12, 'Turquoise', '0024-5833'),
(13, 'Maroon', '42291-120'),
(14, 'Khaki', '44183-220'),
(15, 'Pink', '76420-720'),
(16, 'Puce', '68084-376'),
(17, 'Orange', '58232-0649'),
(18, 'Red', '59450-223'),
(19, 'Turquoise', '60512-6600'),
(20, 'Green', '50224-002'),
(21, 'Blue', 'E-204');

-- --------------------------------------------------------

--
-- Structure de la table `Immeuble`
--

CREATE TABLE `Immeuble` (
  `id` int(11) NOT NULL,
  `adrNum` varchar(7) NOT NULL,
  `adrVoie` varchar(100) NOT NULL,
  `adrCodePostal` varchar(5) NOT NULL,
  `adrVille` varchar(30) NOT NULL,
  `fibreOptique` tinyint(4) NOT NULL,
  `parkingPrivatif` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Photo`
--

CREATE TABLE `Photo` (
  `immeuble` int(11) NOT NULL,
  `appartement` int(3) NOT NULL,
  `reference` int(11) NOT NULL,
  `titre` varchar(75) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `uri` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Piece`
--

CREATE TABLE `Piece` (
  `immeuble` int(11) NOT NULL,
  `appartement` int(3) NOT NULL,
  `num` int(2) NOT NULL,
  `superficie` double DEFAULT NULL,
  `fonction` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `nom` varchar(100) NOT NULL,
  `mdp` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`nom`, `mdp`) VALUES
('bbullcockb', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('ccharleg', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('cmaffini', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('cponde7', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('eberthomieuf', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('eorable5', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('epagin6', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('fnorthcliffed', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('fpragnall8', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('gebbingj', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('grobeiroh', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('hheady2', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('iredsall9', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('jhiers4', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('llitzmanna', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('lzorer1', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('pfreddi3', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('sio', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('smazilliusc', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a'),
('tswinfene', '43a73deab476b063a1d8cae4db2e978ea296e31de26bf1294e7fa4d06e924f0a');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Appartement`
--
ALTER TABLE `Appartement`
  ADD PRIMARY KEY (`immeuble`,`num`);

--
-- Index pour la table `clef`
--
ALTER TABLE `clef`
  ADD PRIMARY KEY (`numeroClef`);

--
-- Index pour la table `Immeuble`
--
ALTER TABLE `Immeuble`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Photo`
--
ALTER TABLE `Photo`
  ADD PRIMARY KEY (`immeuble`,`appartement`,`reference`);

--
-- Index pour la table `Piece`
--
ALTER TABLE `Piece`
  ADD PRIMARY KEY (`immeuble`,`appartement`,`num`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`nom`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Immeuble`
--
ALTER TABLE `Immeuble`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Appartement`
--
ALTER TABLE `Appartement`
  ADD CONSTRAINT `fk_immeuble` FOREIGN KEY (`immeuble`) REFERENCES `Immeuble` (`id`);

--
-- Contraintes pour la table `Photo`
--
ALTER TABLE `Photo`
  ADD CONSTRAINT `fk_appartement_photo` FOREIGN KEY (`immeuble`,`appartement`) REFERENCES `Appartement` (`immeuble`, `num`);

--
-- Contraintes pour la table `Piece`
--
ALTER TABLE `Piece`
  ADD CONSTRAINT `fk_appartement_piece` FOREIGN KEY (`immeuble`,`appartement`) REFERENCES `Appartement` (`immeuble`, `num`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
