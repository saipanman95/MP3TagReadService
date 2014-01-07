/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.mp3.impl;

import com.mdrsolutions.web.mp3.MP3TagReader;
import com.mdrsolutions.web.mp3.model.MP3Tag;
import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.springframework.stereotype.Service;

/**
 *
 * @author michael
 */
@Service("mp3TagReader")
public class MP3TagReaderImpl implements MP3TagReader {

    public MP3Tag readMp3Tag(File file) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {

        if (isMP3(file)) {
            MP3File mpf = new MP3File(file);
            Tag tag = mpf.getTag();
            MP3Tag mp3Tag = new MP3Tag(tag, mpf.getMP3AudioHeader().getTrackLengthAsString());
            return mp3Tag;
        } else {
            return new MP3Tag(false);
        }
    }

    private boolean isMP3(File file) {
        int lastIndexOf = file.getName().lastIndexOf('.');
        String extension = "";
        if (lastIndexOf > 0) {
            extension = file.getName().substring(lastIndexOf + 1);
            if (extension.toLowerCase().contains("mp3")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
