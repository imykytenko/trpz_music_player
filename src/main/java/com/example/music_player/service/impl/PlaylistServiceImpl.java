package com.example.music_player.service.impl;

import com.example.music_player.model.Playlist;
import com.example.music_player.model.Song;
import com.example.music_player.repository.PlaylistRepository;
import com.example.music_player.repository.SongRepository;
import com.example.music_player.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylistById(int id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist updatePlaylist(int id, Playlist playlist) {
        if (playlistRepository.existsById(id)) {
            playlist.setId(id);
            return playlistRepository.save(playlist);
        }
        return null;
    }

    @Override
    public void deletePlaylist(int id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public void addSongToPlaylist(int playlistId, int songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        Song song = songRepository.findById(songId).orElse(null);
        if (playlist != null && song != null) {
            playlist.addSong(song);
            playlistRepository.save(playlist);
        }
    }

    @Override
    public void removeSongFromPlaylist(int playlistId, int songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        Song song = songRepository.findById(songId).orElse(null);
        if (playlist != null && song != null) {
            playlist.removeSong(song);
            playlistRepository.save(playlist);
        }
    }
}
