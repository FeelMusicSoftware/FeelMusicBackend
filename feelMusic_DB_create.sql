drop database feelmusic_DB;
create database feelmusic_DB;
USE feelmusic_DB;

-- tables
-- Table: album
CREATE TABLE album (
                       id_album int NOT NULL AUTO_INCREMENT,
                       name varchar(250) NOT NULL,
                       song varchar(350) NOT NULL,
                       CONSTRAINT album_pk PRIMARY KEY (id_album)
);

-- Table: artist
CREATE TABLE artist (
                        id_artist int NOT NULL AUTO_INCREMENT,
                        id_user int NOT NULL,
                        country varchar(100) NOT NULL,
                        artist_name varchar(100) NOT NULL,
                        CONSTRAINT artist_pk PRIMARY KEY (id_artist)
);

-- Table: genre
CREATE TABLE genre (
                       id_genre int NOT NULL AUTO_INCREMENT,
                       name varchar(250) NOT NULL,
                       description varchar(500) NOT NULL,
                       CONSTRAINT genre_pk PRIMARY KEY (id_genre)
);

-- Table: images
CREATE TABLE images (
                        id_image int NOT NULL AUTO_INCREMENT,
                        id_album int NOT NULL,
                        name varchar(250) NOT NULL,
                        CONSTRAINT id_image PRIMARY KEY (id_image)
);

-- Table: language
CREATE TABLE language (
                          id_language int NOT NULL AUTO_INCREMENT,
                          language varchar(100) NOT NULL,
                          CONSTRAINT language_pk PRIMARY KEY (id_language)
);

-- Table: person
CREATE TABLE person (
                        id_person int NOT NULL AUTO_INCREMENT,
                        name varchar(250) NOT NULL,
                        first_surname varchar(350) NOT NULL,
                        second_surname varchar(100) NOT NULL,
                        phone varchar(100) NOT NULL,
                        CONSTRAINT person_pk PRIMARY KEY (id_person)
);

-- Table: playlist
CREATE TABLE playlist (
                          id_playlist int NOT NULL AUTO_INCREMENT,
                          id_user int NOT NULL,
                          name varchar(100) NOT NULL,
                          CONSTRAINT playlist_pk PRIMARY KEY (id_playlist)
);

-- Table: song
CREATE TABLE song (
                      id_song int NOT NULL AUTO_INCREMENT,
                      id_album int NOT NULL,
                      id_genre int NOT NULL,
                      id_language int NOT NULL,
                      id_artist int NOT NULL,
                      name varchar(250) NOT NULL,
                      duration double(7,2) NOT NULL,
    mood int NOT NULL,
    CONSTRAINT song_pk PRIMARY KEY (id_song)
);

-- Table: song_playlist
CREATE TABLE song_playlist (
                               id_song_playlist int NOT NULL AUTO_INCREMENT,
                               id_song int NOT NULL,
                               id_playlist int NOT NULL,
                               CONSTRAINT song_playlist_pk PRIMARY KEY (id_song_playlist)
);

-- Table: user
CREATE TABLE user (
                      id_user int NOT NULL AUTO_INCREMENT,
                      id_person int NOT NULL,
                      username varchar(250) NOT NULL,
                      email varchar(250) NOT NULL,
                      password varchar(250) NOT NULL,
                      CONSTRAINT user_pk PRIMARY KEY (id_user)
);

-- foreign keys
-- Reference: Artist_User (table: artist)
ALTER TABLE artist ADD CONSTRAINT Artist_User FOREIGN KEY Artist_User (id_user)
    REFERENCES user (id_user);

-- Reference: Images_Album (table: images)
ALTER TABLE images ADD CONSTRAINT Images_Album FOREIGN KEY Images_Album (id_album)
    REFERENCES album (id_album);

-- Reference: Playlist_User (table: playlist)
ALTER TABLE playlist ADD CONSTRAINT Playlist_User FOREIGN KEY Playlist_User (id_user)
    REFERENCES user (id_user);

-- Reference: Song_Album (table: song)
ALTER TABLE song ADD CONSTRAINT Song_Album FOREIGN KEY Song_Album (id_album)
    REFERENCES album (id_album);

-- Reference: Song_Artist (table: song)
ALTER TABLE song ADD CONSTRAINT Song_Artist FOREIGN KEY Song_Artist (id_artist)
    REFERENCES artist (id_artist);

-- Reference: Song_Genre (table: song)
ALTER TABLE song ADD CONSTRAINT Song_Genre FOREIGN KEY Song_Genre (id_genre)
    REFERENCES genre (id_genre);

-- Reference: Song_Language (table: song)
ALTER TABLE song ADD CONSTRAINT Song_Language FOREIGN KEY Song_Language (id_language)
    REFERENCES language (id_language);

-- Reference: Song_Playlist_Song (table: song_playlist)
ALTER TABLE song_playlist ADD CONSTRAINT Song_Playlist_Song FOREIGN KEY Song_Playlist_Song (id_song)
    REFERENCES song (id_song);

-- Reference: User_Person (table: user)
ALTER TABLE user ADD CONSTRAINT User_Person FOREIGN KEY User_Person (id_person)
    REFERENCES person (id_person);

-- Reference: song_playlist_playlist (table: song_playlist)
ALTER TABLE song_playlist ADD CONSTRAINT song_playlist_playlist FOREIGN KEY song_playlist_playlist (id_playlist)
    REFERENCES playlist (id_playlist);

-- End of file.
