/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.mp3;

import com.mdrsolutions.web.mp3.model.MP3Tag;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.CacheManager;

/**
 *
 * @author michael
 */
public interface MP3ReadDirectory {

    List<MP3Tag> readMP3Directory(String url);

    void setMp3FileReader(MP3FileReader mp3FileReader);

    void setMp3TagReader(MP3TagReader mp3TagReader);
    
}
