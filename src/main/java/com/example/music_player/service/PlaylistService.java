package com.example.music_player.service;

import com.example.music_player.model.Playlist;
import java.util.List;

public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    Playlist getPlaylistById(int id);
    List<Playlist> getAllPlaylists();
    Playlist updatePlaylist(int id, Playlist playlist);
    void deletePlaylist(int id);
    void addSongToPlaylist(int playlistId, int songId);
    void removeSongFromPlaylist(int playlistId, int songId);
}
