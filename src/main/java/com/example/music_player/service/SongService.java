package com.example.music_player.service;

import com.example.music_player.model.Song;

import java.util.List;

public interface SongService {
        Song getSongById(int id);
        List<Song> getAllSongs();
        Song saveSong(Song song);
        void deleteSong(int id);
}
