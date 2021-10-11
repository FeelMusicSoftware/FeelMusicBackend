drop database feelmusic_DB;
create database feelmusic_DB;
USE feelmusic_DB;

-- tables
-- Table: Album
CREATE TABLE Album (
                       id_album int NOT NULL AUTO_INCREMENT,
                       name varchar(250) NOT NULL,
                       song varchar(350) NOT NULL,
                       CONSTRAINT Album_pk PRIMARY KEY (id_album)
);

-- Table: Artist
CREATE TABLE Artist (
                        id_artist int NOT NULL AUTO_INCREMENT,
                        id_user int NOT NULL,
                        country varchar(100) NOT NULL,
                        artist_name varchar(100) NOT NULL,
                        CONSTRAINT Artist_pk PRIMARY KEY (id_artist)
);

-- Table: Genre
CREATE TABLE Genre (
                       id_genre int NOT NULL AUTO_INCREMENT,
                       name varchar(250) NOT NULL,
                       description varchar(500) NOT NULL,
                       CONSTRAINT Genre_pk PRIMARY KEY (id_genre)
);

-- Table: Images
CREATE TABLE Images (
                        id_image int NOT NULL AUTO_INCREMENT,
                        id_album int NOT NULL,
                        name varchar(250) NOT NULL,
                        CONSTRAINT id_image PRIMARY KEY (id_image)
);

-- Table: Language
CREATE TABLE Language (
                          id_language int NOT NULL AUTO_INCREMENT,
                          language varchar(100) NOT NULL,
                          CONSTRAINT Language_pk PRIMARY KEY (id_language)
);

-- Table: Person
CREATE TABLE Person (
                        id_person int NOT NULL AUTO_INCREMENT,
                        name varchar(250) NOT NULL,
                        first_surname varchar(350) NOT NULL,
                        second_surname varchar(100) NOT NULL,
                        phone varchar(100) NOT NULL,
                        CONSTRAINT Person_pk PRIMARY KEY (id_person)
);

-- Table: Playlist
CREATE TABLE Playlist (
                          id_playlist int NOT NULL AUTO_INCREMENT,
                          id_user int NOT NULL,
                          name varchar(100) NOT NULL,
                          CONSTRAINT Playlist_pk PRIMARY KEY (id_playlist)
);

-- Table: Song
CREATE TABLE Song (
                      id_song int NOT NULL AUTO_INCREMENT,
                      id_album int NOT NULL,
                      id_genre int NOT NULL,
                      id_idioms int NOT NULL,
                      id_artist int NOT NULL,
                      name varchar(250) NOT NULL,
                      duration double(7,2) NOT NULL,
    mood int NOT NULL,
    CONSTRAINT Song_pk PRIMARY KEY (id_song)
);

-- Table: Song_Playlist
CREATE TABLE Song_Playlist (
                               id_song_playlist int NOT NULL AUTO_INCREMENT,
                               id_song int NOT NULL,
                               id_playlist int NOT NULL,
                               CONSTRAINT Song_Playlist_pk PRIMARY KEY (id_song_playlist)
);

-- Table: User
CREATE TABLE User (
                      id_user int NOT NULL AUTO_INCREMENT,
                      id_person int NOT NULL,
                      username varchar(250) NOT NULL,
                      email varchar(250) NOT NULL,
                      password varchar(250) NOT NULL,
                      CONSTRAINT User_pk PRIMARY KEY (id_user)
);

-- foreign keys
-- Reference: Artist_User (table: Artist)
ALTER TABLE Artist ADD CONSTRAINT Artist_User FOREIGN KEY Artist_User (id_user)
    REFERENCES User (id_user);

-- Reference: Images_Album (table: Images)
ALTER TABLE Images ADD CONSTRAINT Images_Album FOREIGN KEY Images_Album (id_album)
    REFERENCES Album (id_album);

-- Reference: Playlist_User (table: Playlist)
ALTER TABLE Playlist ADD CONSTRAINT Playlist_User FOREIGN KEY Playlist_User (id_user)
    REFERENCES User (id_user);

-- Reference: Song_Album (table: Song)
ALTER TABLE Song ADD CONSTRAINT Song_Album FOREIGN KEY Song_Album (id_album)
    REFERENCES Album (id_album);

-- Reference: Song_Artist (table: Song)
ALTER TABLE Song ADD CONSTRAINT Song_Artist FOREIGN KEY Song_Artist (id_artist)
    REFERENCES Artist (id_artist);

-- Reference: Song_Genre (table: Song)
ALTER TABLE Song ADD CONSTRAINT Song_Genre FOREIGN KEY Song_Genre (id_genre)
    REFERENCES Genre (id_genre);

-- Reference: Song_Idioms (table: Song)
ALTER TABLE Song ADD CONSTRAINT Song_Idioms FOREIGN KEY Song_Idioms (id_idioms)
    REFERENCES Language (id_language);

-- Reference: Song_Playlist_Playlist (table: Song_Playlist)
ALTER TABLE Song_Playlist ADD CONSTRAINT Song_Playlist_Playlist FOREIGN KEY Song_Playlist_Playlist (id_playlist)
    REFERENCES Playlist (id_playlist);

-- Reference: Song_Playlist_Song (table: Song_Playlist)
ALTER TABLE Song_Playlist ADD CONSTRAINT Song_Playlist_Song FOREIGN KEY Song_Playlist_Song (id_song)
    REFERENCES Song (id_song);

-- Reference: User_Person (table: User)
ALTER TABLE User ADD CONSTRAINT User_Person FOREIGN KEY User_Person (id_person)
    REFERENCES Person (id_person);

-- End of file.
