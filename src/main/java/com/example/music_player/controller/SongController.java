package com.example.music_player.controller;

import com.example.music_player.model.Song;
import com.example.music_player.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController{

    @Autowired
    private SongService songService;

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable int id) {
        Song song = songService.getSongById(id);
        return ResponseEntity.ok(song);
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        Song savedSong = songService.saveSong(song);
        return ResponseEntity.status(201).body(savedSong);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable int id, @RequestBody Song songDetails) {
        Song song = songService.getSongById(id);
        song.setTitle(songDetails.getTitle());
        song.setArtist(songDetails.getArtist());
        song.setDuration(songDetails.getDuration());
        song.setFilePath(songDetails.getFilePath());
        song.setFormat(songDetails.getFormat());

        Song updatedSong = songService.saveSong(song);
        return ResponseEntity.ok(updatedSong);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}
