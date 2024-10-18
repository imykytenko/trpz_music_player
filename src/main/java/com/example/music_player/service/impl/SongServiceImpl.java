package com.example.music_player.service.impl;

import com.example.music_player.model.Song;
import com.example.music_player.repository.SongRepository;
import com.example.music_player.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song getSongById(int id) {
        Optional<Song> song = songRepository.findById(id);
        return song.orElseThrow(() -> new RuntimeException("Song not found with id " + id));
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteSong(int id) {
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
        } else {
            throw new RuntimeException("Song not found with id " + id);
        }
    }
}
