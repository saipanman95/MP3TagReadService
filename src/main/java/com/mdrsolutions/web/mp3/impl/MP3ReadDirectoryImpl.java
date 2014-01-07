/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.mp3.impl;

import com.mdrsolutions.web.mp3.MP3FileReader;
import com.mdrsolutions.web.mp3.MP3ReadDirectory;
import com.mdrsolutions.web.mp3.MP3TagReader;
import com.mdrsolutions.web.mp3.model.MP3Tag;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author michael
 */
@Service("mp3ReadDirectory")
public class MP3ReadDirectoryImpl implements MP3ReadDirectory {

    @Autowired
    private MP3FileReader mp3FileReader;
    @Autowired
    private MP3TagReader mp3TagReader; 

    @Cacheable("myMp3Tags")
    public List<MP3Tag> readMP3Directory(String url) {
        File folder = new File(url);
        File[] listOfFiles = folder.listFiles();
        List<MP3Tag> mp3Tags = new ArrayList<MP3Tag>();
        for (File f : listOfFiles) {
            if (f.isFile()) {
                File mp3 = mp3FileReader.findMp3(f.getAbsolutePath());
                try {
                    mp3Tags.add(mp3TagReader.readMp3Tag(mp3));
                } catch (CannotReadException ex) {
                    Logger.getLogger(MP3ReadDirectoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MP3ReadDirectoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TagException ex) {
                    Logger.getLogger(MP3ReadDirectoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ReadOnlyFileException ex) {
                    Logger.getLogger(MP3ReadDirectoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidAudioFrameException ex) {
                    Logger.getLogger(MP3ReadDirectoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return mp3Tags;
    }

    public void setMp3FileReader(MP3FileReader mp3FileReader) {
        this.mp3FileReader = mp3FileReader;
    }

    public void setMp3TagReader(MP3TagReader mp3TagReader) {
        this.mp3TagReader = mp3TagReader;
    }
    
}
